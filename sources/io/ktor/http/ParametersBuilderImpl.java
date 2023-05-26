package io.ktor.http;

import io.ktor.util.StringValuesBuilderImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Parameters.kt */
/* loaded from: classes5.dex */
public final class ParametersBuilderImpl extends StringValuesBuilderImpl implements ParametersBuilder {
    public ParametersBuilderImpl() {
        this(0, 1, null);
    }

    public /* synthetic */ ParametersBuilderImpl(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 8 : i8);
    }

    @Override // io.ktor.http.ParametersBuilder
    public Parameters build() {
        return new ParametersImpl(k());
    }

    public ParametersBuilderImpl(int i8) {
        super(true, i8);
    }
}
