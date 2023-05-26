package io.ktor.http;

import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlDecodedParametersBuilder.kt */
/* loaded from: classes5.dex */
public final class UrlDecodedParametersBuilderKt {
    public static final /* synthetic */ void a(StringValuesBuilder stringValuesBuilder, StringValues stringValues) {
        c(stringValuesBuilder, stringValues);
    }

    private static final void b(StringValuesBuilder stringValuesBuilder, StringValuesBuilder stringValuesBuilder2) {
        int v7;
        for (String str : stringValuesBuilder2.names()) {
            List<String> c8 = stringValuesBuilder2.c(str);
            if (c8 == null) {
                c8 = CollectionsKt__CollectionsKt.k();
            }
            String k8 = CodecsKt.k(str, 0, 0, false, null, 15, null);
            v7 = CollectionsKt__IterablesKt.v(c8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (String str2 : c8) {
                arrayList.add(CodecsKt.k(str2, 0, 0, true, null, 11, null));
            }
            stringValuesBuilder.e(k8, arrayList);
        }
    }

    public static final void c(StringValuesBuilder stringValuesBuilder, StringValues stringValues) {
        int v7;
        for (String str : stringValues.names()) {
            List<String> c8 = stringValues.c(str);
            if (c8 == null) {
                c8 = CollectionsKt__CollectionsKt.k();
            }
            String m8 = CodecsKt.m(str, false, 1, null);
            v7 = CollectionsKt__IterablesKt.v(c8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (String str2 : c8) {
                arrayList.add(CodecsKt.n(str2));
            }
            stringValuesBuilder.e(m8, arrayList);
        }
    }

    public static final Parameters d(StringValuesBuilder parameters) {
        Intrinsics.f(parameters, "parameters");
        ParametersBuilder b8 = ParametersKt.b(0, 1, null);
        b(b8, parameters);
        return b8.build();
    }

    public static final ParametersBuilder e(StringValues parameters) {
        Intrinsics.f(parameters, "parameters");
        ParametersBuilder b8 = ParametersKt.b(0, 1, null);
        c(b8, parameters);
        return b8;
    }
}
