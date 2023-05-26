package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupResponseLogging$observer$1", f = "Logging.kt", l = {196, 199, 200, 199, 200, 199, 200}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class Logging$setupResponseLogging$observer$1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46563g;

    /* renamed from: h  reason: collision with root package name */
    int f46564h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46565i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Logging f46566j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupResponseLogging$observer$1(Logging logging, Continuation<? super Logging$setupResponseLogging$observer$1> continuation) {
        super(2, continuation);
        this.f46566j = logging;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Logging$setupResponseLogging$observer$1 logging$setupResponseLogging$observer$1 = new Logging$setupResponseLogging$observer$1(this.f46566j, continuation);
        logging$setupResponseLogging$observer$1.f46565i = obj;
        return logging$setupResponseLogging$observer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return ((Logging$setupResponseLogging$observer$1) create(httpResponse, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.Logging$setupResponseLogging$observer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
