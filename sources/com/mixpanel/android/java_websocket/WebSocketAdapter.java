package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public abstract class WebSocketAdapter implements WebSocketListener {
    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void b(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public String d(WebSocket webSocket) throws InvalidDataException {
        InetSocketAddress h8 = webSocket.h();
        if (h8 != null) {
            StringBuffer stringBuffer = new StringBuffer(90);
            stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            stringBuffer.append(h8.getPort());
            stringBuffer.append("\" /></cross-domain-policy>\u0000");
            return stringBuffer.toString();
        }
        throw new InvalidHandshakeException("socket not bound");
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void j(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void k(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void m(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void n(WebSocket webSocket, Framedata framedata) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(framedata);
        framedataImpl1.g(Framedata.Opcode.PONG);
        webSocket.q(framedataImpl1);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public ServerHandshakeBuilder p(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException {
        return new HandshakeImpl1Server();
    }
}
