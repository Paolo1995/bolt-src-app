package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpClientEngine$executeWithinCallContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponseData>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46113g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ HttpClientEngine f46114h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpRequestData f46115i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$executeWithinCallContext$2(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData, Continuation<? super HttpClientEngine$executeWithinCallContext$2> continuation) {
        super(2, continuation);
        this.f46114h = httpClientEngine;
        this.f46115i = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpClientEngine$executeWithinCallContext$2(this.f46114h, this.f46115i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super HttpResponseData> continuation) {
        return ((HttpClientEngine$executeWithinCallContext$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        boolean f8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46113g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            f8 = HttpClientEngine.DefaultImpls.f(this.f46114h);
            if (!f8) {
                HttpClientEngine httpClientEngine = this.f46114h;
                HttpRequestData httpRequestData = this.f46115i;
                this.f46113g = 1;
                obj = httpClientEngine.Y0(httpRequestData, this);
                if (obj == d8) {
                    return d8;
                }
            } else {
                throw new ClientEngineClosedException(null, 1, null);
            }
        }
        return obj;
    }
}
