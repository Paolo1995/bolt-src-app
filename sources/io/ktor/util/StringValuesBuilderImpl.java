package io.ktor.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
/* loaded from: classes5.dex */
public class StringValuesBuilderImpl implements StringValuesBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f47054a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<String>> f47055b;

    public StringValuesBuilderImpl() {
        this(false, 0, 3, null);
    }

    public StringValuesBuilderImpl(boolean z7, int i8) {
        this.f47054a = z7;
        this.f47055b = z7 ? CollectionsKt.a() : new LinkedHashMap<>(i8);
    }

    private final List<String> i(String str) {
        List<String> list = this.f47055b.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            n(str);
            this.f47055b.put(str, arrayList);
            return arrayList;
        }
        return list;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<Map.Entry<String, List<String>>> a() {
        return CollectionsJvmKt.a(this.f47055b.entrySet());
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean b() {
        return this.f47054a;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List<String> c(String name) {
        Intrinsics.f(name, "name");
        return this.f47055b.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.f47055b.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        Intrinsics.f(name, "name");
        return this.f47055b.containsKey(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void d(StringValues stringValues) {
        Intrinsics.f(stringValues, "stringValues");
        stringValues.d(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesBuilderImpl$appendAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(String name, List<String> values) {
                Intrinsics.f(name, "name");
                Intrinsics.f(values, "values");
                StringValuesBuilderImpl.this.e(name, values);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(String str, List<? extends String> list) {
                b(str, list);
                return Unit.f50853a;
            }
        });
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void e(String name, Iterable<String> values) {
        Intrinsics.f(name, "name");
        Intrinsics.f(values, "values");
        List<String> i8 = i(name);
        for (String str : values) {
            o(str);
            i8.add(str);
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void f(String name, String value) {
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        o(value);
        i(name).add(value);
    }

    public void g(StringValues stringValues) {
        Intrinsics.f(stringValues, "stringValues");
        stringValues.d(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesBuilderImpl$appendMissing$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(String name, List<String> values) {
                Intrinsics.f(name, "name");
                Intrinsics.f(values, "values");
                StringValuesBuilderImpl.this.h(name, values);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(String str, List<? extends String> list) {
                b(str, list);
                return Unit.f50853a;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(java.lang.String r5, java.lang.Iterable<java.lang.String> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = r4.f47055b
            java.lang.Object r0 = r0.get(r5)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L1a
            java.util.Set r0 = kotlin.collections.CollectionsKt.L0(r0)
            if (r0 != 0) goto L1e
        L1a:
            java.util.Set r0 = kotlin.collections.SetsKt.b()
        L1e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L27:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L40
            java.lang.Object r2 = r6.next()
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r0.contains(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L27
            r1.add(r2)
            goto L27
        L40:
            r4.e(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.StringValuesBuilderImpl.h(java.lang.String, java.lang.Iterable):void");
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.f47055b.isEmpty();
    }

    public String j(String name) {
        Intrinsics.f(name, "name");
        List<String> c8 = c(name);
        if (c8 != null) {
            return (String) CollectionsKt___CollectionsKt.Y(c8);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, List<String>> k() {
        return this.f47055b;
    }

    public void l(String name) {
        Intrinsics.f(name, "name");
        this.f47055b.remove(name);
    }

    public void m(String name, String value) {
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        o(value);
        List<String> i8 = i(name);
        i8.clear();
        i8.add(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(String name) {
        Intrinsics.f(name, "name");
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<String> names() {
        return this.f47055b.keySet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(String value) {
        Intrinsics.f(value, "value");
    }

    public /* synthetic */ StringValuesBuilderImpl(boolean z7, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? false : z7, (i9 & 2) != 0 ? 8 : i8);
    }
}
