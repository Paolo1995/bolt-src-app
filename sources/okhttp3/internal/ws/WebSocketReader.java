package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: WebSocketReader.kt */
/* loaded from: classes5.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final Buffer controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final BufferedSource source;

    /* compiled from: WebSocketReader.kt */
    /* loaded from: classes5.dex */
    public interface FrameCallback {
        void onReadClose(int i8, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z7, BufferedSource source, FrameCallback frameCallback, boolean z8, boolean z9) {
        byte[] bArr;
        Intrinsics.f(source, "source");
        Intrinsics.f(frameCallback, "frameCallback");
        this.isClient = z7;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z8;
        this.noContextTakeover = z9;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        if (z7) {
            bArr = null;
        } else {
            bArr = new byte[4];
        }
        this.maskKey = bArr;
        this.maskCursor = z7 ? null : new Buffer.UnsafeCursor();
    }

    private final void readControlFrame() throws IOException {
        String str;
        long j8 = this.frameLength;
        if (j8 > 0) {
            this.source.E(this.controlFrameBuffer, j8);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.c(unsafeCursor);
                buffer.Y(unsafeCursor);
                this.maskCursor.g(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                Intrinsics.c(bArr);
                webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s7 = 1005;
                long size = this.controlFrameBuffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s7 = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.k0();
                        String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s7);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s7, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.N0());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.N0());
                return;
            default:
                throw new ProtocolException(Intrinsics.n("Unknown control opcode: ", Util.toHexString(this.opcode)));
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        String str;
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int and = Util.and(this.source.readByte(), 255);
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                int i8 = and & 15;
                this.opcode = i8;
                boolean z13 = false;
                if ((and & 128) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.isFinalFrame = z7;
                if ((and & 8) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                this.isControlFrame = z8;
                if (z8 && !z7) {
                    throw new ProtocolException("Control frames must be final.");
                }
                if ((and & 64) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (i8 != 1 && i8 != 2) {
                    if (z9) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                } else {
                    if (z9) {
                        if (this.perMessageDeflate) {
                            z10 = true;
                        } else {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                    } else {
                        z10 = false;
                    }
                    this.readingCompressedMessage = z10;
                }
                if ((and & 32) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    if ((and & 16) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        int and2 = Util.and(this.source.readByte(), 255);
                        if ((and2 & 128) != 0) {
                            z13 = true;
                        }
                        if (z13 == this.isClient) {
                            if (this.isClient) {
                                str = "Server-sent frames must not be masked.";
                            } else {
                                str = "Client-sent frames must be masked.";
                            }
                            throw new ProtocolException(str);
                        }
                        long j8 = and2 & 127;
                        this.frameLength = j8;
                        if (j8 == 126) {
                            this.frameLength = Util.and(this.source.readShort(), (int) Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                        } else if (j8 == 127) {
                            long readLong = this.source.readLong();
                            this.frameLength = readLong;
                            if (readLong < 0) {
                                throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                            }
                        }
                        if (this.isControlFrame && this.frameLength > 125) {
                            throw new ProtocolException("Control frame must be less than 125B.");
                        }
                        if (z13) {
                            BufferedSource bufferedSource = this.source;
                            byte[] bArr = this.maskKey;
                            Intrinsics.c(bArr);
                            bufferedSource.readFully(bArr);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("Unexpected rsv3 flag");
                }
                throw new ProtocolException("Unexpected rsv2 flag");
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        }
        throw new IOException("closed");
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j8 = this.frameLength;
            if (j8 > 0) {
                this.source.E(this.messageFrameBuffer, j8);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    Intrinsics.c(unsafeCursor);
                    buffer.Y(unsafeCursor);
                    this.maskCursor.g(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    Intrinsics.c(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException(Intrinsics.n("Expected continuation opcode. Got: ", Util.toHexString(this.opcode)));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i8 = this.opcode;
        if (i8 != 1 && i8 != 2) {
            throw new ProtocolException(Intrinsics.n("Unknown opcode: ", Util.toHexString(i8)));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i8 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.k0());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.N0());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
