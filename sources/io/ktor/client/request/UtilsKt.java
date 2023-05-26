package io.ktor.client.request;

import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.Base64Kt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
/* loaded from: classes5.dex */
public final class UtilsKt {
    public static final void a(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        Intrinsics.f(httpMessageBuilder, "<this>");
        Intrinsics.f(contentType, "contentType");
        httpMessageBuilder.getHeaders().f(HttpHeaders.f46782a.c(), contentType.toString());
    }

    public static final void b(HttpMessageBuilder httpMessageBuilder, String username, String password) {
        Intrinsics.f(httpMessageBuilder, "<this>");
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        String e8 = HttpHeaders.f46782a.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(Base64Kt.b(username + ':' + password));
        d(httpMessageBuilder, e8, sb.toString());
    }

    public static final void c(HttpMessageBuilder httpMessageBuilder, String token) {
        Intrinsics.f(httpMessageBuilder, "<this>");
        Intrinsics.f(token, "token");
        String e8 = HttpHeaders.f46782a.e();
        d(httpMessageBuilder, e8, "Bearer " + token);
    }

    public static final void d(HttpMessageBuilder httpMessageBuilder, String key, Object obj) {
        Intrinsics.f(httpMessageBuilder, "<this>");
        Intrinsics.f(key, "key");
        if (obj != null) {
            httpMessageBuilder.getHeaders().f(key, obj.toString());
            Unit unit = Unit.f50853a;
        }
    }

    public static final void e(HttpRequestBuilder httpRequestBuilder, String key, Object obj) {
        Intrinsics.f(httpRequestBuilder, "<this>");
        Intrinsics.f(key, "key");
        if (obj != null) {
            httpRequestBuilder.h().k().f(key, obj.toString());
            Unit unit = Unit.f50853a;
        }
    }
}
