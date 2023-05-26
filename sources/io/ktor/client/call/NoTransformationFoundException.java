package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.StringValuesKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: HttpClientCall.kt */
/* loaded from: classes5.dex */
public final class NoTransformationFoundException extends UnsupportedOperationException {

    /* renamed from: f  reason: collision with root package name */
    private final String f46082f;

    public NoTransformationFoundException(HttpResponse response, KClass<?> from, KClass<?> to) {
        String f02;
        String h8;
        Intrinsics.f(response, "response");
        Intrinsics.f(from, "from");
        Intrinsics.f(to, "to");
        StringBuilder sb = new StringBuilder();
        sb.append("No transformation found: ");
        sb.append(from);
        sb.append(" -> ");
        sb.append(to);
        sb.append("\n        |with response from ");
        sb.append(HttpResponseKt.d(response).getUrl());
        sb.append(":\n        |status: ");
        sb.append(response.e());
        sb.append("\n        |response headers: \n        |");
        f02 = CollectionsKt___CollectionsKt.f0(StringValuesKt.f(response.getHeaders()), null, null, null, 0, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: io.ktor.client.call.NoTransformationFoundException$message$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CharSequence invoke(Pair<String, String> pair) {
                Intrinsics.f(pair, "<name for destructuring parameter 0>");
                return pair.a() + ": " + pair.b() + '\n';
            }
        }, 31, null);
        sb.append(f02);
        sb.append("\n    ");
        h8 = StringsKt__IndentKt.h(sb.toString(), null, 1, null);
        this.f46082f = h8;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f46082f;
    }
}
