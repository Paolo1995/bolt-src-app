package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Parameters.kt */
/* loaded from: classes5.dex */
public final class ParametersImpl extends StringValuesImpl implements Parameters {
    public ParametersImpl() {
        this(null, 1, null);
    }

    public /* synthetic */ ParametersImpl(Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? MapsKt__MapsKt.f() : map);
    }

    @Override // io.ktor.util.StringValuesImpl
    public String toString() {
        return "Parameters " + a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParametersImpl(Map<String, ? extends List<String>> values) {
        super(true, values);
        Intrinsics.f(values, "values");
    }
}
