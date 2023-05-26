package ee.mtakso.driver.service.analytics;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public final class AnalyticScope {

    /* renamed from: a  reason: collision with root package name */
    private final int f23427a;

    public AnalyticScope(int i8) {
        this.f23427a = i8;
    }

    public final AnalyticScope a(AnalyticScope other) {
        Intrinsics.f(other, "other");
        return new AnalyticScope(other.f23427a ^ this.f23427a);
    }

    public final boolean b(AnalyticScope scope) {
        Intrinsics.f(scope, "scope");
        if ((scope.f23427a & this.f23427a) > 0) {
            return true;
        }
        return false;
    }

    public final AnalyticScope c(AnalyticScope other) {
        Intrinsics.f(other, "other");
        return new AnalyticScope(other.f23427a | this.f23427a);
    }

    public String toString() {
        int a8;
        int i8 = this.f23427a;
        a8 = CharsKt__CharJVMKt.a(2);
        String num = Integer.toString(i8, a8);
        Intrinsics.e(num, "toString(this, checkRadix(radix))");
        return num;
    }
}
