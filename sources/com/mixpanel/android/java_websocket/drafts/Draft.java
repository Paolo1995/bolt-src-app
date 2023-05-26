package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class Draft {

    /* renamed from: c  reason: collision with root package name */
    public static int f19004c = 64;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f19005d = Charsetfunctions.d("<policy-file-request/>\u0000");

    /* renamed from: a  reason: collision with root package name */
    protected WebSocket.Role f19006a = null;

    /* renamed from: b  reason: collision with root package name */
    protected Framedata.Opcode f19007b = null;

    /* loaded from: classes3.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes3.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer m(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b8 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b9 = byteBuffer.get();
            allocate.put(b9);
            if (b8 == 13 && b9 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b8 = b9;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String n(ByteBuffer byteBuffer) {
        ByteBuffer m8 = m(byteBuffer);
        if (m8 == null) {
            return null;
        }
        return Charsetfunctions.b(m8.array(), 0, m8.limit());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server, com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder] */
    public static HandshakeBuilder s(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        HandshakeImpl1Client handshakeImpl1Client;
        String n8 = n(byteBuffer);
        if (n8 != null) {
            String[] split = n8.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    ?? handshakeImpl1Server = new HandshakeImpl1Server();
                    handshakeImpl1Server.e(Short.parseShort(split[1]));
                    handshakeImpl1Server.g(split[2]);
                    handshakeImpl1Client = handshakeImpl1Server;
                } else {
                    HandshakeImpl1Client handshakeImpl1Client2 = new HandshakeImpl1Client();
                    handshakeImpl1Client2.f(split[1]);
                    handshakeImpl1Client = handshakeImpl1Client2;
                }
                String n9 = n(byteBuffer);
                while (n9 != null && n9.length() > 0) {
                    String[] split2 = n9.split(":", 2);
                    if (split2.length == 2) {
                        handshakeImpl1Client.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        n9 = n(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (n9 != null) {
                    return handshakeImpl1Client;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public abstract HandshakeState a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException;

    public abstract HandshakeState b(ClientHandshake clientHandshake) throws InvalidHandshakeException;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(Handshakedata handshakedata) {
        if (handshakedata.i("Upgrade").equalsIgnoreCase("websocket") && handshakedata.i("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) {
            return true;
        }
        return false;
    }

    public int d(int i8) throws LimitExedeedException, InvalidDataException {
        if (i8 >= 0) {
            return i8;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z7) {
        Framedata.Opcode opcode2;
        if (opcode != Framedata.Opcode.BINARY && opcode != (opcode2 = Framedata.Opcode.TEXT) && opcode != opcode2) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.f19007b != null) {
            this.f19007b = Framedata.Opcode.CONTINUOUS;
        } else {
            this.f19007b = opcode;
        }
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(this.f19007b);
        try {
            framedataImpl1.h(byteBuffer);
            framedataImpl1.c(z7);
            if (z7) {
                this.f19007b = null;
            } else {
                this.f19007b = opcode;
            }
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e8) {
            throw new RuntimeException(e8);
        }
    }

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public List<ByteBuffer> h(Handshakedata handshakedata, WebSocket.Role role) {
        return i(handshakedata, role, true);
    }

    public List<ByteBuffer> i(Handshakedata handshakedata, WebSocket.Role role, boolean z7) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).c());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb.append("HTTP/1.1 101 " + ((ServerHandshake) handshakedata).a());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> d8 = handshakedata.d();
        while (d8.hasNext()) {
            String next = d8.next();
            String i8 = handshakedata.i(next);
            sb.append(next);
            sb.append(": ");
            sb.append(i8);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a8 = Charsetfunctions.a(sb.toString());
        if (z7) {
            bArr = handshakedata.getContent();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length + a8.length);
        allocate.put(a8);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public abstract CloseHandshakeType j();

    public abstract ClientHandshakeBuilder k(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException;

    public abstract HandshakeBuilder l(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException;

    public abstract void o();

    public void p(WebSocket.Role role) {
        this.f19006a = role;
    }

    public abstract List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException;

    public Handshakedata r(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return s(byteBuffer, this.f19006a);
    }
}
