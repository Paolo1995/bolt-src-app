package io.ktor.client.plugins.cache;

import io.ktor.http.HeadersBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
/* loaded from: classes5.dex */
/* synthetic */ class HttpCache$findResponse$lookup$1 extends FunctionReferenceImpl implements Function1<String, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCache$findResponse$lookup$1(Object obj) {
        super(1, obj, HeadersBuilder.class, "get", "get(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final String invoke(String p02) {
        Intrinsics.f(p02, "p0");
        return ((HeadersBuilder) this.f50989g).j(p02);
    }
}
