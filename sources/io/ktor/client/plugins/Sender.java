package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;

/* compiled from: HttpSend.kt */
/* loaded from: classes5.dex */
public interface Sender {
    Object a(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation);
}
