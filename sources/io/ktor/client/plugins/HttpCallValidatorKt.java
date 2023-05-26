package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes5.dex */
public final class HttpCallValidatorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<Boolean> f46314a = new AttributeKey<>("ExpectSuccessAttributeKey");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1] */
    public static final HttpCallValidatorKt$HttpRequest$1 a(final HttpRequestBuilder httpRequestBuilder) {
        return new HttpRequest() { // from class: io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1

            /* renamed from: f  reason: collision with root package name */
            private final HttpMethod f46315f;

            /* renamed from: g  reason: collision with root package name */
            private final Url f46316g;

            /* renamed from: h  reason: collision with root package name */
            private final Attributes f46317h;

            /* renamed from: i  reason: collision with root package name */
            private final Headers f46318i;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f46315f = HttpRequestBuilder.this.g();
                this.f46316g = HttpRequestBuilder.this.h().b();
                this.f46317h = HttpRequestBuilder.this.b();
                this.f46318i = HttpRequestBuilder.this.getHeaders().p();
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpClientCall Y() {
                throw new IllegalStateException("Call is not initialized".toString());
            }

            @Override // io.ktor.client.request.HttpRequest
            public Attributes getAttributes() {
                return this.f46317h;
            }

            @Override // io.ktor.client.request.HttpRequest
            public OutgoingContent getContent() {
                OutgoingContent outgoingContent;
                Object c8 = HttpRequestBuilder.this.c();
                if (c8 instanceof OutgoingContent) {
                    outgoingContent = (OutgoingContent) c8;
                } else {
                    outgoingContent = null;
                }
                if (outgoingContent != null) {
                    return outgoingContent;
                }
                throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + HttpRequestBuilder.this.c()).toString());
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.f46318i;
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpMethod getMethod() {
                return this.f46315f;
            }

            @Override // io.ktor.client.request.HttpRequest
            public Url getUrl() {
                return this.f46316g;
            }

            @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
            public CoroutineContext j() {
                return HttpRequest.DefaultImpls.a(this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(HttpClientConfig<?> httpClientConfig, Function1<? super HttpCallValidator.Config, Unit> block) {
        Intrinsics.f(httpClientConfig, "<this>");
        Intrinsics.f(block, "block");
        httpClientConfig.g(HttpCallValidator.f46282d, block);
    }

    public static final AttributeKey<Boolean> d() {
        return f46314a;
    }
}
