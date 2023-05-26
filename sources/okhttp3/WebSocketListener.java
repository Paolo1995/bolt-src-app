package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* compiled from: WebSocketListener.kt */
/* loaded from: classes5.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i8, String reason) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int i8, String reason) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t7, Response response) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(t7, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(text, "text");
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(bytes, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(response, "response");
    }
}
