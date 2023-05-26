package io.ktor.client.plugins.cache;

import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
/* loaded from: classes5.dex */
public final class HttpCacheKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(URLProtocol uRLProtocol) {
        if (!Intrinsics.a(uRLProtocol.e(), "http") && !Intrinsics.a(uRLProtocol.e(), "https")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<String, String> d(final OutgoingContent outgoingContent, final Function1<? super String, String> function1, final Function1<? super String, ? extends List<String>> function12) {
        return new Function1<String, String>() { // from class: io.ktor.client.plugins.cache.HttpCacheKt$mergedHeadersLookup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(String header) {
                String f02;
                String headerValueWithParameters;
                Intrinsics.f(header, "header");
                HttpHeaders httpHeaders = HttpHeaders.f46782a;
                if (Intrinsics.a(header, httpHeaders.h())) {
                    Long a8 = OutgoingContent.this.a();
                    if (a8 == null || (headerValueWithParameters = a8.toString()) == null) {
                        return "";
                    }
                } else if (Intrinsics.a(header, httpHeaders.i())) {
                    ContentType b8 = OutgoingContent.this.b();
                    if (b8 == null || (headerValueWithParameters = b8.toString()) == null) {
                        return "";
                    }
                } else if (Intrinsics.a(header, httpHeaders.s())) {
                    String str = OutgoingContent.this.c().get(httpHeaders.s());
                    if (str == null) {
                        String invoke = function1.invoke(httpHeaders.s());
                        if (invoke == null) {
                            return UtilsKt.c();
                        }
                        return invoke;
                    }
                    return str;
                } else {
                    List<String> c8 = OutgoingContent.this.c().c(header);
                    if (c8 == null && (c8 = function12.invoke(header)) == null) {
                        c8 = CollectionsKt__CollectionsKt.k();
                    }
                    f02 = CollectionsKt___CollectionsKt.f0(c8, ";", null, null, 0, null, null, 62, null);
                    return f02;
                }
                return headerValueWithParameters;
            }
        };
    }
}
