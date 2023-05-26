package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTransformersJvm.kt */
/* loaded from: classes5.dex */
public final class DefaultTransformersJvmKt {
    public static final OutgoingContent a(final ContentType contentType, final HttpRequestBuilder context, final Object body) {
        Intrinsics.f(context, "context");
        Intrinsics.f(body, "body");
        if (body instanceof InputStream) {
            return new OutgoingContent.ReadChannelContent(context, contentType, body) { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformRequestDefaultTransform$1

                /* renamed from: a  reason: collision with root package name */
                private final Long f46273a;

                /* renamed from: b  reason: collision with root package name */
                private final ContentType f46274b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Object f46275c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Long l8;
                    this.f46275c = body;
                    String j8 = context.getHeaders().j(HttpHeaders.f46782a.h());
                    if (j8 != null) {
                        l8 = Long.valueOf(Long.parseLong(j8));
                    } else {
                        l8 = null;
                    }
                    this.f46273a = l8;
                    this.f46274b = contentType == null ? ContentType.Application.f46731a.b() : contentType;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long a() {
                    return this.f46273a;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType b() {
                    return this.f46274b;
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public ByteReadChannel e() {
                    return ReadingKt.b((InputStream) this.f46275c, null, null, 3, null);
                }
            };
        }
        return null;
    }

    public static final void b(HttpClient httpClient) {
        Intrinsics.f(httpClient, "<this>");
        httpClient.l().l(HttpResponsePipeline.f46667h.a(), new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(null));
    }
}
