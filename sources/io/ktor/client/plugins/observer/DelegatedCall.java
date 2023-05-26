package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
/* loaded from: classes5.dex */
public final class DelegatedCall extends HttpClientCall {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegatedCall(HttpClient client, ByteReadChannel content, HttpClientCall originCall) {
        super(client);
        Intrinsics.f(client, "client");
        Intrinsics.f(content, "content");
        Intrinsics.f(originCall, "originCall");
        i(new DelegatedRequest(this, originCall.e()));
        k(new DelegatedResponse(this, content, originCall.f()));
    }
}
