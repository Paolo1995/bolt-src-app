package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$3", f = "HttpCallValidator.kt", l = {147, 148}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpCallValidator$Companion$install$3 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46296g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46297h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46298i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpCallValidator f46299j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$3(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$3> continuation) {
        super(3, continuation);
        this.f46299j = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpCallValidator$Companion$install$3 httpCallValidator$Companion$install$3 = new HttpCallValidator$Companion$install$3(this.f46299j, continuation);
        httpCallValidator$Companion$install$3.f46297h = sender;
        httpCallValidator$Companion$install$3.f46298i = httpRequestBuilder;
        return httpCallValidator$Companion$install$3.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object f8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46296g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    HttpClientCall httpClientCall = (HttpClientCall) this.f46297h;
                    ResultKt.b(obj);
                    return httpClientCall;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            this.f46297h = null;
            this.f46296g = 1;
            obj = ((Sender) this.f46297h).a((HttpRequestBuilder) this.f46298i, this);
            if (obj == d8) {
                return d8;
            }
        }
        HttpClientCall httpClientCall2 = (HttpClientCall) obj;
        HttpCallValidator httpCallValidator = this.f46299j;
        HttpResponse f9 = httpClientCall2.f();
        this.f46297h = httpClientCall2;
        this.f46296g = 2;
        f8 = httpCallValidator.f(f9, this);
        if (f8 == d8) {
            return d8;
        }
        return httpClientCall2;
    }
}
