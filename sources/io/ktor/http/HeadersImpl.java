package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes5.dex */
public final class HeadersImpl extends StringValuesImpl implements Headers {
    public HeadersImpl() {
        this(null, 1, null);
    }

    public /* synthetic */ HeadersImpl(Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? MapsKt__MapsKt.f() : map);
    }

    @Override // io.ktor.util.StringValuesImpl
    public String toString() {
        return "Headers " + a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadersImpl(Map<String, ? extends List<String>> values) {
        super(true, values);
        Intrinsics.f(values, "values");
    }
}
