package io.ktor.client.plugins.websocket;

import io.ktor.client.engine.HttpClientEngineCapability;
import kotlin.Unit;

/* compiled from: WebSockets.kt */
/* loaded from: classes5.dex */
public final class WebSocketCapability implements HttpClientEngineCapability<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final WebSocketCapability f46603a = new WebSocketCapability();

    private WebSocketCapability() {
    }

    public String toString() {
        return "WebSocketCapability";
    }
}
