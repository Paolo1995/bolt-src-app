package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes5.dex */
public class HttpClientCall implements CoroutineScope {

    /* renamed from: f  reason: collision with root package name */
    private final HttpClient f46073f;

    /* renamed from: g  reason: collision with root package name */
    protected HttpRequest f46074g;

    /* renamed from: h  reason: collision with root package name */
    protected HttpResponse f46075h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f46076i;
    private volatile /* synthetic */ int received;

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f46070j = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static final AttributeKey<Object> f46072l = new AttributeKey<>("CustomResponse");

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f46071k = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");

    /* compiled from: HttpClientCall.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HttpClientCall(HttpClient client) {
        Intrinsics.f(client, "client");
        this.f46073f = client;
        this.received = 0;
    }

    static /* synthetic */ Object h(HttpClientCall httpClientCall, Continuation continuation) {
        return httpClientCall.f().a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(io.ktor.util.reflect.TypeInfo r7, kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.HttpClientCall.a(io.ktor.util.reflect.TypeInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected boolean b() {
        return this.f46076i;
    }

    public final HttpClient c() {
        return this.f46073f;
    }

    public final HttpRequest e() {
        HttpRequest httpRequest = this.f46074g;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.w("request");
        return null;
    }

    public final HttpResponse f() {
        HttpResponse httpResponse = this.f46075h;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.w("response");
        return null;
    }

    protected Object g(Continuation<? super ByteReadChannel> continuation) {
        return h(this, continuation);
    }

    public final Attributes getAttributes() {
        return e().getAttributes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(HttpRequest httpRequest) {
        Intrinsics.f(httpRequest, "<set-?>");
        this.f46074g = httpRequest;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return f().j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(HttpResponse httpResponse) {
        Intrinsics.f(httpResponse, "<set-?>");
        this.f46075h = httpResponse;
    }

    public final void l(HttpResponse response) {
        Intrinsics.f(response, "response");
        k(response);
    }

    public String toString() {
        return "HttpClientCall[" + e().getUrl() + ", " + f().e() + ']';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClientCall(HttpClient client, HttpRequestData requestData, HttpResponseData responseData) {
        this(client);
        Intrinsics.f(client, "client");
        Intrinsics.f(requestData, "requestData");
        Intrinsics.f(responseData, "responseData");
        i(new DefaultHttpRequest(this, requestData));
        k(new DefaultHttpResponse(this, responseData));
        if (responseData.a() instanceof ByteReadChannel) {
            return;
        }
        getAttributes().b(f46072l, responseData.a());
    }
}
