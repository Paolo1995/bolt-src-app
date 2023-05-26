package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class HttpStatement$execute$4 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46685g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46686h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpStatement$execute$4(Continuation<? super HttpStatement$execute$4> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HttpStatement$execute$4 httpStatement$execute$4 = new HttpStatement$execute$4(continuation);
        httpStatement$execute$4.f46686h = obj;
        return httpStatement$execute$4;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
        return ((HttpStatement$execute$4) create(httpResponse, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46685g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            HttpClientCall Y = ((HttpResponse) this.f46686h).Y();
            this.f46685g = 1;
            obj = SavedCallKt.a(Y, this);
            if (obj == d8) {
                return d8;
            }
        }
        return ((HttpClientCall) obj).f();
    }
}
