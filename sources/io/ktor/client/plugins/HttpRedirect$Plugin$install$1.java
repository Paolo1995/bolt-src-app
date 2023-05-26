package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRedirect.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin$install$1", f = "HttpRedirect.kt", l = {61, 66}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpRedirect$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46357g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46358h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46359i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpRedirect f46360j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ HttpClient f46361k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$install$1(HttpRedirect httpRedirect, HttpClient httpClient, Continuation<? super HttpRedirect$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46360j = httpRedirect;
        this.f46361k = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRedirect$Plugin$install$1 httpRedirect$Plugin$install$1 = new HttpRedirect$Plugin$install$1(this.f46360j, this.f46361k, continuation);
        httpRedirect$Plugin$install$1.f46358h = sender;
        httpRedirect$Plugin$install$1.f46359i = httpRequestBuilder;
        return httpRedirect$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Sender sender;
        HttpRequestBuilder httpRequestBuilder;
        boolean z7;
        boolean z8;
        Set set;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46357g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            httpRequestBuilder = (HttpRequestBuilder) this.f46359i;
            sender = (Sender) this.f46358h;
        } else {
            ResultKt.b(obj);
            Sender sender2 = (Sender) this.f46358h;
            HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) this.f46359i;
            this.f46358h = sender2;
            this.f46359i = httpRequestBuilder2;
            this.f46357g = 1;
            Object a8 = sender2.a(httpRequestBuilder2, this);
            if (a8 == d8) {
                return d8;
            }
            sender = sender2;
            httpRequestBuilder = httpRequestBuilder2;
            obj = a8;
        }
        HttpClientCall httpClientCall = (HttpClientCall) obj;
        z7 = this.f46360j.f46341a;
        if (z7) {
            set = HttpRedirectKt.f46362a;
            if (!set.contains(httpClientCall.e().getMethod())) {
                return httpClientCall;
            }
        }
        HttpRedirect.Plugin plugin = HttpRedirect.f46338c;
        z8 = this.f46360j.f46342b;
        HttpClient httpClient = this.f46361k;
        this.f46358h = null;
        this.f46359i = null;
        this.f46357g = 2;
        obj = plugin.e(sender, httpRequestBuilder, httpClientCall, z8, httpClient, this);
        if (obj == d8) {
            return d8;
        }
        return obj;
    }
}
