package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface WebSocketListener {
    void a(WebSocket webSocket);

    void b(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException;

    void c(WebSocket webSocket, int i8, String str, boolean z7);

    String d(WebSocket webSocket) throws InvalidDataException;

    void e(WebSocket webSocket, Handshakedata handshakedata);

    void f(WebSocket webSocket, String str);

    void g(WebSocket webSocket, int i8, String str, boolean z7);

    void i(WebSocket webSocket, Exception exc);

    void j(WebSocket webSocket, Framedata framedata);

    void k(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException;

    void l(WebSocket webSocket, int i8, String str);

    void m(WebSocket webSocket, Framedata framedata);

    void n(WebSocket webSocket, Framedata framedata);

    void o(WebSocket webSocket, ByteBuffer byteBuffer);

    ServerHandshakeBuilder p(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException;

    InetSocketAddress r(WebSocket webSocket);
}
