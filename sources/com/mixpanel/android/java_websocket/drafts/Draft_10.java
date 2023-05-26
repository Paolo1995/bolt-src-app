package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.FrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import okhttp3.internal.ws.WebSocketProtocol;

@SuppressLint({"Assert", "UseValueOf"})
/* loaded from: classes3.dex */
public class Draft_10 extends Draft {

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f19015e;

    /* renamed from: f  reason: collision with root package name */
    private Framedata f19016f = null;

    /* renamed from: g  reason: collision with root package name */
    private final Random f19017g = new Random();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class IncompleteException extends Throwable {

        /* renamed from: f  reason: collision with root package name */
        private int f19018f;

        public IncompleteException(int i8) {
            this.f19018f = i8;
        }

        public int a() {
            return this.f19018f;
        }
    }

    private byte t(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + opcode.toString());
    }

    private String u(String str) {
        try {
            return Base64.g(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static int v(Handshakedata handshakedata) {
        String i8 = handshakedata.i("Sec-WebSocket-Version");
        if (i8.length() > 0) {
            try {
                return new Integer(i8.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    private byte[] w(long j8, int i8) {
        byte[] bArr = new byte[i8];
        int i9 = (i8 * 8) - 8;
        for (int i10 = 0; i10 < i8; i10++) {
            bArr[i10] = (byte) (j8 >>> (i9 - (i10 * 8)));
        }
        return bArr;
    }

    private Framedata.Opcode x(byte b8) throws InvalidFrameException {
        if (b8 != 0) {
            if (b8 != 1) {
                if (b8 != 2) {
                    switch (b8) {
                        case 8:
                            return Framedata.Opcode.CLOSING;
                        case 9:
                            return Framedata.Opcode.PING;
                        case 10:
                            return Framedata.Opcode.PONG;
                        default:
                            throw new InvalidFrameException("unknow optcode " + ((int) b8));
                    }
                }
                return Framedata.Opcode.BINARY;
            }
            return Framedata.Opcode.TEXT;
        }
        return Framedata.Opcode.CONTINUOUS;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (clientHandshake.b("Sec-WebSocket-Key") && serverHandshake.b("Sec-WebSocket-Accept")) {
            if (u(clientHandshake.i("Sec-WebSocket-Key")).equals(serverHandshake.i("Sec-WebSocket-Accept"))) {
                return Draft.HandshakeState.MATCHED;
            }
            return Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState b(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        int v7 = v(clientHandshake);
        if (v7 != 7 && v7 != 8) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (c(clientHandshake)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft f() {
        return new Draft_10();
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer g(Framedata framedata) {
        boolean z7;
        int i8;
        int i9;
        int i10;
        int i11;
        ByteBuffer f8 = framedata.f();
        int i12 = 0;
        if (this.f19006a == WebSocket.Role.CLIENT) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (f8.remaining() <= 125) {
            i8 = 1;
        } else if (f8.remaining() <= 65535) {
            i8 = 2;
        } else {
            i8 = 8;
        }
        if (i8 > 1) {
            i9 = i8 + 1;
        } else {
            i9 = i8;
        }
        int i13 = i9 + 1;
        if (z7) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i13 + i10 + f8.remaining());
        byte t7 = t(framedata.b());
        byte b8 = Byte.MIN_VALUE;
        if (framedata.d()) {
            i11 = -128;
        } else {
            i11 = 0;
        }
        allocate.put((byte) (((byte) i11) | t7));
        byte[] w7 = w(f8.remaining(), i8);
        if (i8 == 1) {
            byte b9 = w7[0];
            if (!z7) {
                b8 = 0;
            }
            allocate.put((byte) (b9 | b8));
        } else if (i8 == 2) {
            if (!z7) {
                b8 = 0;
            }
            allocate.put((byte) (b8 | 126));
            allocate.put(w7);
        } else if (i8 == 8) {
            if (!z7) {
                b8 = 0;
            }
            allocate.put((byte) (b8 | Byte.MAX_VALUE));
            allocate.put(w7);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z7) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.f19017g.nextInt());
            allocate.put(allocate2.array());
            while (f8.hasRemaining()) {
                allocate.put((byte) (f8.get() ^ allocate2.get(i12 % 4)));
                i12++;
            }
        } else {
            allocate.put(f8);
        }
        allocate.flip();
        return allocate;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType j() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ClientHandshakeBuilder k(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "websocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.f19017g.nextBytes(bArr);
        clientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.g(bArr));
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public HandshakeBuilder l(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put("Upgrade", "websocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.i("Connection"));
        serverHandshakeBuilder.g("Switching Protocols");
        String i8 = clientHandshake.i("Sec-WebSocket-Key");
        if (i8 != null) {
            serverHandshakeBuilder.put("Sec-WebSocket-Accept", u(i8));
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public void o() {
        this.f19015e = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        LinkedList linkedList = new LinkedList();
        if (this.f19015e != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f19015e.remaining();
                if (remaining2 > remaining) {
                    this.f19015e.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f19015e.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(y((ByteBuffer) this.f19015e.duplicate().position(0)));
                this.f19015e = null;
            } catch (IncompleteException e8) {
                this.f19015e.limit();
                ByteBuffer allocate = ByteBuffer.allocate(d(e8.a()));
                this.f19015e.rewind();
                allocate.put(this.f19015e);
                this.f19015e = allocate;
                return q(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(y(byteBuffer));
            } catch (IncompleteException e9) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(d(e9.a()));
                this.f19015e = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Framedata y(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        boolean z7;
        boolean z8;
        int i8;
        FrameBuilder framedataImpl1;
        int remaining = byteBuffer.remaining();
        int i9 = 2;
        if (remaining >= 2) {
            byte b8 = byteBuffer.get();
            if ((b8 >> 8) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            byte b9 = (byte) ((b8 & Byte.MAX_VALUE) >> 4);
            if (b9 == 0) {
                byte b10 = byteBuffer.get();
                if ((b10 & Byte.MIN_VALUE) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                int i10 = (byte) (b10 & Byte.MAX_VALUE);
                Framedata.Opcode x7 = x((byte) (b8 & 15));
                if (!z7 && (x7 == Framedata.Opcode.PING || x7 == Framedata.Opcode.PONG || x7 == Framedata.Opcode.CLOSING)) {
                    throw new InvalidFrameException("control frames may no be fragmented");
                }
                if (i10 < 0 || i10 > 125) {
                    if (x7 != Framedata.Opcode.PING && x7 != Framedata.Opcode.PONG && x7 != Framedata.Opcode.CLOSING) {
                        if (i10 == 126) {
                            if (remaining >= 4) {
                                i10 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                                i9 = 4;
                            } else {
                                throw new IncompleteException(4);
                            }
                        } else {
                            i9 = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i11 = 0; i11 < 8; i11++) {
                                    bArr[i11] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue <= 2147483647L) {
                                    i10 = (int) longValue;
                                } else {
                                    throw new LimitExedeedException("Payloadsize is to big...");
                                }
                            } else {
                                throw new IncompleteException(10);
                            }
                        }
                    } else {
                        throw new InvalidFrameException("more than 125 octets");
                    }
                }
                if (z8) {
                    i8 = 4;
                } else {
                    i8 = 0;
                }
                int i12 = i9 + i8 + i10;
                if (remaining >= i12) {
                    ByteBuffer allocate = ByteBuffer.allocate(d(i10));
                    if (z8) {
                        byte[] bArr2 = new byte[4];
                        byteBuffer.get(bArr2);
                        for (int i13 = 0; i13 < i10; i13++) {
                            allocate.put((byte) (byteBuffer.get() ^ bArr2[i13 % 4]));
                        }
                    } else {
                        allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                        byteBuffer.position(byteBuffer.position() + allocate.limit());
                    }
                    if (x7 == Framedata.Opcode.CLOSING) {
                        framedataImpl1 = new CloseFrameBuilder();
                    } else {
                        framedataImpl1 = new FramedataImpl1();
                        framedataImpl1.c(z7);
                        framedataImpl1.g(x7);
                    }
                    allocate.flip();
                    framedataImpl1.h(allocate);
                    return framedataImpl1;
                }
                throw new IncompleteException(i12);
            }
            throw new InvalidFrameException("bad rsv " + ((int) b9));
        }
        throw new IncompleteException(2);
    }
}
