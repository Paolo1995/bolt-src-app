package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class Draft_75 extends Draft {

    /* renamed from: g  reason: collision with root package name */
    protected ByteBuffer f19022g;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f19020e = false;

    /* renamed from: f  reason: collision with root package name */
    protected List<Framedata> f19021f = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    private final Random f19023h = new Random();

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (clientHandshake.i("WebSocket-Origin").equals(serverHandshake.i("Origin")) && c(serverHandshake)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.HandshakeState b(ClientHandshake clientHandshake) {
        if (clientHandshake.b("Origin") && c(clientHandshake)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft f() {
        return new Draft_75();
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ByteBuffer g(Framedata framedata) {
        if (framedata.b() == Framedata.Opcode.TEXT) {
            ByteBuffer f8 = framedata.f();
            ByteBuffer allocate = ByteBuffer.allocate(f8.remaining() + 2);
            allocate.put((byte) 0);
            f8.mark();
            allocate.put(f8);
            f8.reset();
            allocate.put((byte) -1);
            allocate.flip();
            return allocate;
        }
        throw new RuntimeException("only text frames supported");
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType j() {
        return Draft.CloseHandshakeType.NONE;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public ClientHandshakeBuilder k(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        clientHandshakeBuilder.put("Upgrade", "WebSocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        if (!clientHandshakeBuilder.b("Origin")) {
            clientHandshakeBuilder.put("Origin", "random" + this.f19023h.nextInt());
        }
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public HandshakeBuilder l(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.g("Web Socket Protocol Handshake");
        serverHandshakeBuilder.put("Upgrade", "WebSocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.i("Connection"));
        serverHandshakeBuilder.put("WebSocket-Origin", clientHandshake.i("Origin"));
        serverHandshakeBuilder.put("WebSocket-Location", "ws://" + clientHandshake.i("Host") + clientHandshake.c());
        return serverHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public void o() {
        this.f19020e = false;
        this.f19022g = null;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException {
        List<Framedata> v7 = v(byteBuffer);
        if (v7 != null) {
            return v7;
        }
        throw new InvalidDataException(1002);
    }

    public ByteBuffer t() {
        return ByteBuffer.allocate(Draft.f19004c);
    }

    public ByteBuffer u(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        byteBuffer.flip();
        ByteBuffer allocate = ByteBuffer.allocate(d(byteBuffer.capacity() * 2));
        allocate.put(byteBuffer);
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Framedata> v(ByteBuffer byteBuffer) throws InvalidDataException {
        while (byteBuffer.hasRemaining()) {
            byte b8 = byteBuffer.get();
            if (b8 == 0) {
                if (!this.f19020e) {
                    this.f19020e = true;
                } else {
                    throw new InvalidFrameException("unexpected START_OF_FRAME");
                }
            } else if (b8 == -1) {
                if (this.f19020e) {
                    ByteBuffer byteBuffer2 = this.f19022g;
                    if (byteBuffer2 != null) {
                        byteBuffer2.flip();
                        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
                        framedataImpl1.h(this.f19022g);
                        framedataImpl1.c(true);
                        framedataImpl1.g(Framedata.Opcode.TEXT);
                        this.f19021f.add(framedataImpl1);
                        this.f19022g = null;
                        byteBuffer.mark();
                    }
                    this.f19020e = false;
                } else {
                    throw new InvalidFrameException("unexpected END_OF_FRAME");
                }
            } else if (!this.f19020e) {
                return null;
            } else {
                ByteBuffer byteBuffer3 = this.f19022g;
                if (byteBuffer3 == null) {
                    this.f19022g = t();
                } else if (!byteBuffer3.hasRemaining()) {
                    this.f19022g = u(this.f19022g);
                }
                this.f19022g.put(b8);
            }
        }
        List<Framedata> list = this.f19021f;
        this.f19021f = new LinkedList();
        return list;
    }
}
