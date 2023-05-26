package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;

/* compiled from: OkHttpWebsocketSession.kt */
/* loaded from: classes5.dex */
public final class OkHttpWebsocketSessionKt {

    /* renamed from: a  reason: collision with root package name */
    private static final CloseReason f46220a = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Client failure");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(CloseReason closeReason) {
        CloseReason.Codes a8 = CloseReason.Codes.f47521g.a(closeReason.a());
        if (a8 != null && a8 != CloseReason.Codes.CLOSED_ABNORMALLY) {
            return false;
        }
        return true;
    }
}
