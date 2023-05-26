package io.ktor.util;

import e0.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
/* loaded from: classes5.dex */
public class StringValuesImpl implements StringValues {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f47058c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, List<String>> f47059d;

    public StringValuesImpl() {
        this(false, null, 3, null);
    }

    public StringValuesImpl(boolean z7, Map<String, ? extends List<String>> values) {
        Intrinsics.f(values, "values");
        this.f47058c = z7;
        Map a8 = z7 ? CollectionsKt.a() : new LinkedHashMap();
        for (Map.Entry<String, ? extends List<String>> entry : values.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            int size = value.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i8 = 0; i8 < size; i8++) {
                arrayList.add(value.get(i8));
            }
            a8.put(key, arrayList);
        }
        this.f47059d = a8;
    }

    private final List<String> e(String str) {
        return this.f47059d.get(str);
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> a() {
        return CollectionsJvmKt.a(this.f47059d.entrySet());
    }

    @Override // io.ktor.util.StringValues
    public final boolean b() {
        return this.f47058c;
    }

    @Override // io.ktor.util.StringValues
    public List<String> c(String name) {
        Intrinsics.f(name, "name");
        return e(name);
    }

    @Override // io.ktor.util.StringValues
    public void d(Function2<? super String, ? super List<String>, Unit> body) {
        Intrinsics.f(body, "body");
        for (Map.Entry<String, List<String>> entry : this.f47059d.entrySet()) {
            body.s(entry.getKey(), entry.getValue());
        }
    }

    public boolean equals(Object obj) {
        boolean d8;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (this.f47058c == stringValues.b()) {
            d8 = StringValuesKt.d(a(), stringValues.a());
            return d8;
        }
        return false;
    }

    @Override // io.ktor.util.StringValues
    public String get(String name) {
        Intrinsics.f(name, "name");
        List<String> e8 = e(name);
        if (e8 != null) {
            return (String) CollectionsKt___CollectionsKt.Y(e8);
        }
        return null;
    }

    public int hashCode() {
        int e8;
        e8 = StringValuesKt.e(a(), a.a(this.f47058c) * 31);
        return e8;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return this.f47059d.isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return CollectionsJvmKt.a(this.f47059d.keySet());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StringValues(case=");
        sb.append(!this.f47058c);
        sb.append(") ");
        sb.append(a());
        return sb.toString();
    }

    public /* synthetic */ StringValuesImpl(boolean z7, Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? MapsKt__MapsKt.f() : map);
    }
}
