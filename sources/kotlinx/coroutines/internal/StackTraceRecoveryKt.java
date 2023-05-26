package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes5.dex */
public final class StackTraceRecoveryKt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f51833a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f51834b;

    static {
        Object b8;
        Object b9;
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        if (Result.e(b8) != null) {
            b8 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f51833a = (String) b8;
        try {
            b9 = Result.b(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.f50818g;
            b9 = Result.b(ResultKt.a(th2));
        }
        if (Result.e(b9) != null) {
            b9 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f51834b = (String) b9;
    }

    public static final <E extends Throwable> E a(E e8) {
        return e8;
    }
}
