package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CloseableJVM.kt */
/* loaded from: classes5.dex */
public final class CloseableJVMKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Lazy f47379a;

    static {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Method>() { // from class: io.ktor.utils.io.core.CloseableJVMKt$AddSuppressedMethod$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Method invoke() {
                try {
                    return Throwable.class.getMethod("addSuppressed", Throwable.class);
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        f47379a = b8;
    }

    public static final void a(Throwable th, Throwable other) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(other, "other");
        Method b8 = b();
        if (b8 != null) {
            b8.invoke(th, other);
        }
    }

    private static final Method b() {
        return (Method) f47379a.getValue();
    }
}
