package io.netty.handler.codec.http.websocketx;

import io.netty.util.AsciiString;

/* loaded from: classes5.dex */
public final class WebSocketScheme {
    public static final WebSocketScheme WS = new WebSocketScheme(80, "ws");
    public static final WebSocketScheme WSS = new WebSocketScheme(443, "wss");
    private final AsciiString name;
    private final int port;

    private WebSocketScheme(int i8, String str) {
        this.port = i8;
        this.name = AsciiString.cached(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WebSocketScheme)) {
            return false;
        }
        WebSocketScheme webSocketScheme = (WebSocketScheme) obj;
        if (webSocketScheme.port() != this.port || !webSocketScheme.name().equals(this.name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.port * 31) + this.name.hashCode();
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }
}
