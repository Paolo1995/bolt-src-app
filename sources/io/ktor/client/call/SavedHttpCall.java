package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedCall.kt */
/* loaded from: classes5.dex */
public final class SavedHttpCall extends HttpClientCall {

    /* renamed from: m  reason: collision with root package name */
    private final byte[] f46088m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f46089n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient client, HttpRequest request, HttpResponse response, byte[] responseBody) {
        super(client);
        Intrinsics.f(client, "client");
        Intrinsics.f(request, "request");
        Intrinsics.f(response, "response");
        Intrinsics.f(responseBody, "responseBody");
        this.f46088m = responseBody;
        i(new SavedHttpRequest(this, request));
        k(new SavedHttpResponse(this, responseBody, response));
        this.f46089n = true;
    }

    @Override // io.ktor.client.call.HttpClientCall
    protected boolean b() {
        return this.f46089n;
    }

    @Override // io.ktor.client.call.HttpClientCall
    protected Object g(Continuation<? super ByteReadChannel> continuation) {
        return ByteChannelCtorKt.a(this.f46088m);
    }
}
