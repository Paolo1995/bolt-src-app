package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ActorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* compiled from: OkHttpWebsocketSession.kt */
/* loaded from: classes5.dex */
public final class OkHttpWebsocketSession extends WebSocketListener implements CoroutineScope {

    /* renamed from: f  reason: collision with root package name */
    private final OkHttpClient f46206f;

    /* renamed from: g  reason: collision with root package name */
    private final WebSocket.Factory f46207g;

    /* renamed from: h  reason: collision with root package name */
    private final CoroutineContext f46208h;

    /* renamed from: i  reason: collision with root package name */
    private final CompletableDeferred<OkHttpWebsocketSession> f46209i;

    /* renamed from: j  reason: collision with root package name */
    private final CompletableDeferred<Response> f46210j;

    /* renamed from: k  reason: collision with root package name */
    private final Channel<Frame> f46211k;

    /* renamed from: l  reason: collision with root package name */
    private final CompletableDeferred<CloseReason> f46212l;

    /* renamed from: m  reason: collision with root package name */
    private final SendChannel<Frame> f46213m;

    public OkHttpWebsocketSession(OkHttpClient engine, WebSocket.Factory webSocketFactory, Request engineRequest, CoroutineContext coroutineContext) {
        Intrinsics.f(engine, "engine");
        Intrinsics.f(webSocketFactory, "webSocketFactory");
        Intrinsics.f(engineRequest, "engineRequest");
        Intrinsics.f(coroutineContext, "coroutineContext");
        this.f46206f = engine;
        this.f46207g = webSocketFactory;
        this.f46208h = coroutineContext;
        this.f46209i = CompletableDeferredKt.b(null, 1, null);
        this.f46210j = CompletableDeferredKt.b(null, 1, null);
        this.f46211k = ChannelKt.b(0, null, null, 7, null);
        this.f46212l = CompletableDeferredKt.b(null, 1, null);
        this.f46213m = ActorKt.b(this, null, 0, null, null, new OkHttpWebsocketSession$outgoing$1(this, engineRequest, null), 15, null);
    }

    public final CompletableDeferred<Response> c() {
        return this.f46210j;
    }

    public SendChannel<Frame> e() {
        return this.f46213m;
    }

    public final void f() {
        this.f46209i.d0(this);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46208h;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i8, String reason) {
        Object valueOf;
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(reason, "reason");
        super.onClosed(webSocket, i8, reason);
        short s7 = (short) i8;
        this.f46212l.d0(new CloseReason(s7, reason));
        SendChannel.DefaultImpls.a(this.f46211k, null, 1, null);
        SendChannel<Frame> e8 = e();
        StringBuilder sb = new StringBuilder();
        sb.append("WebSocket session closed with code ");
        CloseReason.Codes a8 = CloseReason.Codes.f47521g.a(s7);
        if (a8 == null || (valueOf = a8.toString()) == null) {
            valueOf = Integer.valueOf(i8);
        }
        sb.append(valueOf);
        sb.append('.');
        e8.b(new CancellationException(sb.toString()));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i8, String reason) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(reason, "reason");
        super.onClosing(webSocket, i8, reason);
        short s7 = (short) i8;
        this.f46212l.d0(new CloseReason(s7, reason));
        try {
            ChannelsKt.b(e(), new Frame.Close(new CloseReason(s7, reason)));
        } catch (Throwable unused) {
        }
        SendChannel.DefaultImpls.a(this.f46211k, null, 1, null);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable t7, Response response) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(t7, "t");
        super.onFailure(webSocket, t7, response);
        this.f46212l.a(t7);
        this.f46210j.a(t7);
        this.f46211k.b(t7);
        e().b(t7);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(bytes, "bytes");
        super.onMessage(webSocket, bytes);
        ChannelsKt.b(this.f46211k, new Frame.Binary(true, bytes.C()));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(response, "response");
        super.onOpen(webSocket, response);
        this.f46210j.d0(response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String text) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(text, "text");
        super.onMessage(webSocket, text);
        Channel<Frame> channel = this.f46211k;
        byte[] bytes = text.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        ChannelsKt.b(channel, new Frame.Text(true, bytes));
    }
}
