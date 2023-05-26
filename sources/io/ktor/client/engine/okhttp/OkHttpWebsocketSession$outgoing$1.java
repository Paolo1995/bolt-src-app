package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import okhttp3.Request;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpWebsocketSession.kt */
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1", f = "OkHttpWebsocketSession.kt", l = {62, 66}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class OkHttpWebsocketSession$outgoing$1 extends SuspendLambda implements Function2<ActorScope<Frame>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46214g;

    /* renamed from: h  reason: collision with root package name */
    Object f46215h;

    /* renamed from: i  reason: collision with root package name */
    int f46216i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f46217j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ OkHttpWebsocketSession f46218k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Request f46219l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpWebsocketSession$outgoing$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation<? super OkHttpWebsocketSession$outgoing$1> continuation) {
        super(2, continuation);
        this.f46218k = okHttpWebsocketSession;
        this.f46219l = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpWebsocketSession$outgoing$1 okHttpWebsocketSession$outgoing$1 = new OkHttpWebsocketSession$outgoing$1(this.f46218k, this.f46219l, continuation);
        okHttpWebsocketSession$outgoing$1.f46217j = obj;
        return okHttpWebsocketSession$outgoing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ActorScope<Frame> actorScope, Continuation<? super Unit> continuation) {
        return ((OkHttpWebsocketSession$outgoing$1) create(actorScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[Catch: all -> 0x0113, TryCatch #1 {all -> 0x0113, blocks: (B:25:0x0091, B:27:0x0099, B:29:0x00a3, B:30:0x00b7, B:32:0x00bb, B:34:0x00cf, B:36:0x00d3, B:48:0x00fa, B:49:0x00ff), top: B:68:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008a -> B:68:0x0091). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
