package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkUtils.kt */
/* loaded from: classes5.dex */
public final class OkHttpCallback implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private final HttpRequestData f46145a;

    /* renamed from: b  reason: collision with root package name */
    private final CancellableContinuation<Response> f46146b;

    /* JADX WARN: Multi-variable type inference failed */
    public OkHttpCallback(HttpRequestData requestData, CancellableContinuation<? super Response> continuation) {
        Intrinsics.f(requestData, "requestData");
        Intrinsics.f(continuation, "continuation");
        this.f46145a = requestData;
        this.f46146b = continuation;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e8) {
        Throwable f8;
        Intrinsics.f(call, "call");
        Intrinsics.f(e8, "e");
        if (this.f46146b.isCancelled()) {
            return;
        }
        CancellableContinuation<Response> cancellableContinuation = this.f46146b;
        Result.Companion companion = Result.f50818g;
        f8 = OkUtilsKt.f(this.f46145a, e8);
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(f8)));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        if (!call.isCanceled()) {
            this.f46146b.resumeWith(Result.b(response));
        }
    }
}
