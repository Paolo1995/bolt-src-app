package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint({"UseValueOf"})
/* loaded from: classes3.dex */
public class Draft_76 extends Draft_75 {

    /* renamed from: k  reason: collision with root package name */
    private static final byte[] f19024k = {-1, 0};

    /* renamed from: i  reason: collision with root package name */
    private boolean f19025i = false;

    /* renamed from: j  reason: collision with root package name */
    private final Random f19026j = new Random();

    public static byte[] w(String str, String str2, byte[] bArr) throws InvalidHandshakeException {
        byte[] y7 = y(str);
        byte[] y8 = y(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{y7[0], y7[1], y7[2], y7[3], y8[0], y8[1], y8[2], y8[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e8) {
            throw new RuntimeException(e8);
        }
    }

    private static String x() {
        Random random = new Random();
        long nextInt = random.nextInt(12) + 1;
        String l8 = Long.toString((random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i8 = 0; i8 < nextInt2; i8++) {
            int abs = Math.abs(random.nextInt(l8.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l8 = new StringBuilder(l8).insert(abs, nextInt3).toString();
        }
        for (int i9 = 0; i9 < nextInt; i9++) {
            l8 = new StringBuilder(l8).insert(Math.abs(random.nextInt(l8.length() - 1) + 1), " ").toString();
        }
        return l8;
    }

    private static byte[] y(String str) throws InvalidHandshakeException {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length != 0) {
                long longValue = new Long(parseLong / length).longValue();
                return new byte[]{(byte) (longValue >> 24), (byte) ((longValue << 8) >> 24), (byte) ((longValue << 16) >> 24), (byte) ((longValue << 24) >> 24)};
            }
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
        } catch (NumberFormatException unused) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (this.f19025i) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (serverHandshake.i("Sec-WebSocket-Origin").equals(clientHandshake.i("Origin")) && c(serverHandshake)) {
                byte[] content = serverHandshake.getContent();
                if (content != null && content.length != 0) {
                    if (Arrays.equals(content, w(clientHandshake.i("Sec-WebSocket-Key1"), clientHandshake.i("Sec-WebSocket-Key2"), clientHandshake.getContent()))) {
                        return Draft.HandshakeState.MATCHED;
                    }
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                throw new IncompleteHandshakeException();
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e8) {
            throw new RuntimeException("bad handshakerequest", e8);
        }
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState b(ClientHandshake clientHandshake) {
        if (clientHandshake.i("Upgrade").equals("WebSocket") && clientHandshake.i("Connection").contains("Upgrade") && clientHandshake.i("Sec-WebSocket-Key1").length() > 0 && !clientHandshake.i("Sec-WebSocket-Key2").isEmpty() && clientHandshake.b("Origin")) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft f() {
        return new Draft_76();
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer g(Framedata framedata) {
        if (framedata.b() == Framedata.Opcode.CLOSING) {
            return ByteBuffer.wrap(f19024k);
        }
        return super.g(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType j() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public ClientHandshakeBuilder k(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "WebSocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        clientHandshakeBuilder.put("Sec-WebSocket-Key1", x());
        clientHandshakeBuilder.put("Sec-WebSocket-Key2", x());
        if (!clientHandshakeBuilder.b("Origin")) {
            clientHandshakeBuilder.put("Origin", "random" + this.f19026j.nextInt());
        }
        byte[] bArr = new byte[8];
        this.f19026j.nextBytes(bArr);
        clientHandshakeBuilder.h(bArr);
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public HandshakeBuilder l(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.g("WebSocket Protocol Handshake");
        serverHandshakeBuilder.put("Upgrade", "WebSocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.i("Connection"));
        serverHandshakeBuilder.put("Sec-WebSocket-Origin", clientHandshake.i("Origin"));
        serverHandshakeBuilder.put("Sec-WebSocket-Location", "ws://" + clientHandshake.i("Host") + clientHandshake.c());
        String i8 = clientHandshake.i("Sec-WebSocket-Key1");
        String i9 = clientHandshake.i("Sec-WebSocket-Key2");
        byte[] content = clientHandshake.getContent();
        if (i8 != null && i9 != null && content != null && content.length == 8) {
            serverHandshakeBuilder.h(w(i8, i9, content));
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("Bad keys");
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_75, com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException {
        byteBuffer.mark();
        List<Framedata> v7 = super.v(byteBuffer);
        if (v7 == null) {
            byteBuffer.reset();
            List<Framedata> list = this.f19021f;
            this.f19020e = true;
            if (this.f19022g == null) {
                this.f19022g = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() <= this.f19022g.remaining()) {
                    this.f19022g.put(byteBuffer);
                    if (!this.f19022g.hasRemaining()) {
                        if (Arrays.equals(this.f19022g.array(), f19024k)) {
                            list.add(new CloseFrameBuilder(1000));
                            return list;
                        }
                        throw new InvalidFrameException();
                    }
                    this.f19021f = new LinkedList();
                    return list;
                }
                throw new InvalidFrameException();
            }
            throw new InvalidFrameException();
        }
        return v7;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Handshakedata r(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        int i8;
        HandshakeBuilder s7 = Draft.s(byteBuffer, this.f19006a);
        if ((s7.b("Sec-WebSocket-Key1") || this.f19006a == WebSocket.Role.CLIENT) && !s7.b("Sec-WebSocket-Version")) {
            if (this.f19006a == WebSocket.Role.SERVER) {
                i8 = 8;
            } else {
                i8 = 16;
            }
            byte[] bArr = new byte[i8];
            try {
                byteBuffer.get(bArr);
                s7.h(bArr);
            } catch (BufferUnderflowException unused) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return s7;
    }
}
