package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlDecodedParametersBuilder.kt */
/* loaded from: classes5.dex */
public final class UrlDecodedParametersBuilder implements ParametersBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final ParametersBuilder f46938a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f46939b;

    public UrlDecodedParametersBuilder(ParametersBuilder encodedParametersBuilder) {
        Intrinsics.f(encodedParametersBuilder, "encodedParametersBuilder");
        this.f46938a = encodedParametersBuilder;
        this.f46939b = encodedParametersBuilder.b();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<Map.Entry<String, List<String>>> a() {
        return UrlDecodedParametersBuilderKt.d(this.f46938a).a();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean b() {
        return this.f46939b;
    }

    @Override // io.ktor.http.ParametersBuilder
    public Parameters build() {
        return UrlDecodedParametersBuilderKt.d(this.f46938a);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List<String> c(String name) {
        int v7;
        Intrinsics.f(name, "name");
        ArrayList arrayList = null;
        List<String> c8 = this.f46938a.c(CodecsKt.m(name, false, 1, null));
        if (c8 != null) {
            v7 = CollectionsKt__IterablesKt.v(c8, 10);
            arrayList = new ArrayList(v7);
            for (String str : c8) {
                arrayList.add(CodecsKt.k(str, 0, 0, true, null, 11, null));
            }
        }
        return arrayList;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.f46938a.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        Intrinsics.f(name, "name");
        return this.f46938a.contains(CodecsKt.m(name, false, 1, null));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void d(StringValues stringValues) {
        Intrinsics.f(stringValues, "stringValues");
        UrlDecodedParametersBuilderKt.a(this.f46938a, stringValues);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void e(String name, Iterable<String> values) {
        int v7;
        Intrinsics.f(name, "name");
        Intrinsics.f(values, "values");
        ParametersBuilder parametersBuilder = this.f46938a;
        String m8 = CodecsKt.m(name, false, 1, null);
        v7 = CollectionsKt__IterablesKt.v(values, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (String str : values) {
            arrayList.add(CodecsKt.n(str));
        }
        parametersBuilder.e(m8, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void f(String name, String value) {
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        this.f46938a.f(CodecsKt.m(name, false, 1, null), CodecsKt.n(value));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.f46938a.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<String> names() {
        int v7;
        Set<String> L0;
        Set<String> names = this.f46938a.names();
        v7 = CollectionsKt__IterablesKt.v(names, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (String str : names) {
            arrayList.add(CodecsKt.k(str, 0, 0, false, null, 15, null));
        }
        L0 = CollectionsKt___CollectionsKt.L0(arrayList);
        return L0;
    }
}
