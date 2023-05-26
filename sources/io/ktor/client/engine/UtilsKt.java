package io.ktor.client.engine;

import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
/* loaded from: classes5.dex */
public final class UtilsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46137a = "Ktor client";

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f46138b;

    static {
        Set<String> f8;
        HttpHeaders httpHeaders = HttpHeaders.f46782a;
        f8 = SetsKt__SetsKt.f(httpHeaders.j(), httpHeaders.l(), httpHeaders.p(), httpHeaders.m(), httpHeaders.o());
        f46138b = f8;
    }

    public static final Object b(Continuation<? super CoroutineContext> continuation) {
        CoroutineContext.Element g8 = continuation.getContext().g(KtorCallContextElement.f46135g);
        Intrinsics.c(g8);
        return ((KtorCallContextElement) g8).b();
    }

    public static final String c() {
        return f46137a;
    }

    public static final void d(final Headers requestHeaders, final OutgoingContent content, final Function2<? super String, ? super String, Unit> block) {
        boolean z7;
        String str;
        String str2;
        Intrinsics.f(requestHeaders, "requestHeaders");
        Intrinsics.f(content, "content");
        Intrinsics.f(block, "block");
        HeadersKt.a(new Function1<HeadersBuilder, Unit>() { // from class: io.ktor.client.engine.UtilsKt$mergeHeaders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(HeadersBuilder buildHeaders) {
                Intrinsics.f(buildHeaders, "$this$buildHeaders");
                buildHeaders.d(Headers.this);
                buildHeaders.d(content.c());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HeadersBuilder headersBuilder) {
                b(headersBuilder);
                return Unit.f50853a;
            }
        }).d(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.client.engine.UtilsKt$mergeHeaders$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public final void b(String key, List<String> values) {
                Set set;
                String f02;
                Intrinsics.f(key, "key");
                Intrinsics.f(values, "values");
                HttpHeaders httpHeaders = HttpHeaders.f46782a;
                if (!Intrinsics.a(httpHeaders.h(), key) && !Intrinsics.a(httpHeaders.i(), key)) {
                    set = UtilsKt.f46138b;
                    if (set.contains(key)) {
                        Function2<String, String, Unit> function2 = block;
                        for (String str3 : values) {
                            function2.s(key, str3);
                        }
                        return;
                    }
                    Function2<String, String, Unit> function22 = block;
                    f02 = CollectionsKt___CollectionsKt.f0(values, ",", null, null, 0, null, null, 62, null);
                    function22.s(key, f02);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(String str3, List<? extends String> list) {
                b(str3, list);
                return Unit.f50853a;
            }
        });
        HttpHeaders httpHeaders = HttpHeaders.f46782a;
        if (requestHeaders.get(httpHeaders.s()) == null && content.c().get(httpHeaders.s()) == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && e()) {
            block.s(httpHeaders.s(), f46137a);
        }
        ContentType b8 = content.b();
        if ((b8 == null || (str = b8.toString()) == null) && (str = content.c().get(httpHeaders.i())) == null) {
            str = requestHeaders.get(httpHeaders.i());
        }
        Long a8 = content.a();
        if ((a8 == null || (str2 = a8.toString()) == null) && (str2 = content.c().get(httpHeaders.h())) == null) {
            str2 = requestHeaders.get(httpHeaders.h());
        }
        if (str != null) {
            block.s(httpHeaders.i(), str);
        }
        if (str2 != null) {
            block.s(httpHeaders.h(), str2);
        }
    }

    private static final boolean e() {
        return !PlatformUtils.f47049a.a();
    }
}
