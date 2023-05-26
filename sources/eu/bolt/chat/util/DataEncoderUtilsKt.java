package eu.bolt.chat.util;

import io.ktor.http.CodecsKt;
import io.ktor.http.ParametersBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataEncoderUtils.kt */
/* loaded from: classes5.dex */
public final class DataEncoderUtilsKt {
    public static final void a(ParametersBuilder parametersBuilder, String name, String value) {
        Intrinsics.f(parametersBuilder, "<this>");
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        parametersBuilder.f(CodecsKt.m(name, false, 1, null), CodecsKt.l(value, true));
    }
}
