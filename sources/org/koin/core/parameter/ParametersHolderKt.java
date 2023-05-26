package org.koin.core.parameter;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParametersHolder.kt */
/* loaded from: classes5.dex */
public final class ParametersHolderKt {
    public static final ParametersHolder a() {
        return new ParametersHolder(null, 1, null);
    }

    public static final ParametersHolder b(Object... parameters) {
        List h02;
        Intrinsics.f(parameters, "parameters");
        h02 = ArraysKt___ArraysKt.h0(parameters);
        return new ParametersHolder(h02);
    }
}
