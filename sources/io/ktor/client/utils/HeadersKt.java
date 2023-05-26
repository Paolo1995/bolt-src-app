package io.ktor.client.utils;

import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: headers.kt */
/* loaded from: classes5.dex */
public final class HeadersKt {
    public static final Headers a(Function1<? super HeadersBuilder, Unit> block) {
        Intrinsics.f(block, "block");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        block.invoke(headersBuilder);
        return headersBuilder.p();
    }
}
