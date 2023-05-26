package org.koin.dsl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.module.Module;

/* compiled from: ModuleDSL.kt */
/* loaded from: classes5.dex */
public final class ModuleDSLKt {
    public static final Module a(boolean z7, Function1<? super Module, Unit> moduleDeclaration) {
        Intrinsics.f(moduleDeclaration, "moduleDeclaration");
        Module module = new Module(z7);
        moduleDeclaration.invoke(module);
        return module;
    }

    public static /* synthetic */ Module b(boolean z7, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return a(z7, function1);
    }
}
