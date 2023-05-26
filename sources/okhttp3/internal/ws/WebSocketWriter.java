package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: WebSocketWriter.kt */
/* loaded from: classes5.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z7, BufferedSink sink, Random random, boolean z8, boolean z9, long j8) {
        byte[] bArr;
        Intrinsics.f(sink, "sink");
        Intrinsics.f(random, "random");
        this.isClient = z7;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z8;
        this.noContextTakeover = z9;
        this.minimumDeflateSize = j8;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = sink.b();
        if (z7) {
            bArr = new byte[4];
        } else {
            bArr = null;
        }
        this.maskKey = bArr;
        this.maskCursor = z7 ? new Buffer.UnsafeCursor() : null;
    }

    private final void writeControlFrame(int i8, ByteString byteString) throws IOException {
        boolean z7;
        if (!this.writerClosed) {
            int z8 = byteString.z();
            if (z8 <= 125) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.sinkBuffer.writeByte(i8 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(z8 | 128);
                    Random random = this.random;
                    byte[] bArr = this.maskKey;
                    Intrinsics.c(bArr);
                    random.nextBytes(bArr);
                    this.sinkBuffer.write(this.maskKey);
                    if (z8 > 0) {
                        long size = this.sinkBuffer.size();
                        this.sinkBuffer.a1(byteString);
                        Buffer buffer = this.sinkBuffer;
                        Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                        Intrinsics.c(unsafeCursor);
                        buffer.Y(unsafeCursor);
                        this.maskCursor.g(size);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(z8);
                    this.sinkBuffer.a1(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i8, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.f52592j;
        if (i8 != 0 || byteString != null) {
            if (i8 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i8);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i8);
            if (byteString != null) {
                buffer.a1(byteString);
            }
            byteString2 = buffer.N0();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i8, ByteString data) throws IOException {
        Intrinsics.f(data, "data");
        if (!this.writerClosed) {
            this.messageBuffer.a1(data);
            int i9 = 128;
            int i10 = i8 | 128;
            if (this.perMessageDeflate && data.z() >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater = this.messageDeflater;
                if (messageDeflater == null) {
                    messageDeflater = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater;
                }
                messageDeflater.deflate(this.messageBuffer);
                i10 |= 64;
            }
            long size = this.messageBuffer.size();
            this.sinkBuffer.writeByte(i10);
            if (!this.isClient) {
                i9 = 0;
            }
            if (size <= 125) {
                this.sinkBuffer.writeByte(((int) size) | i9);
            } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.writeByte(i9 | 126);
                this.sinkBuffer.writeShort((int) size);
            } else {
                this.sinkBuffer.writeByte(i9 | 127);
                this.sinkBuffer.c1(size);
            }
            if (this.isClient) {
                Random random = this.random;
                byte[] bArr = this.maskKey;
                Intrinsics.c(bArr);
                random.nextBytes(bArr);
                this.sinkBuffer.write(this.maskKey);
                if (size > 0) {
                    Buffer buffer = this.messageBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    Intrinsics.c(unsafeCursor);
                    buffer.Y(unsafeCursor);
                    this.maskCursor.g(0L);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, size);
            this.sink.v();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(ByteString payload) throws IOException {
        Intrinsics.f(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(ByteString payload) throws IOException {
        Intrinsics.f(payload, "payload");
        writeControlFrame(10, payload);
    }
}
