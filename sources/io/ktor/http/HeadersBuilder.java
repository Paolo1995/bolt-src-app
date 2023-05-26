package io.ktor.http;

import io.ktor.util.StringValuesBuilderImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes5.dex */
public final class HeadersBuilder extends StringValuesBuilderImpl {
    public HeadersBuilder() {
        this(0, 1, null);
    }

    public HeadersBuilder(int i8) {
        super(true, i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.util.StringValuesBuilderImpl
    public void n(String name) {
        Intrinsics.f(name, "name");
        super.n(name);
        HttpHeaders.f46782a.a(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.util.StringValuesBuilderImpl
    public void o(String value) {
        Intrinsics.f(value, "value");
        super.o(value);
        HttpHeaders.f46782a.b(value);
    }

    public Headers p() {
        return new HeadersImpl(k());
    }

    public /* synthetic */ HeadersBuilder(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 8 : i8);
    }
}
