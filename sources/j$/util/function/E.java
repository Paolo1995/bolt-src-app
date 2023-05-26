package j$.util.function;

import java.util.function.IntBinaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class E implements IntBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ F f50280a;

    private /* synthetic */ E(F f8) {
        this.f50280a = f8;
    }

    public static /* synthetic */ IntBinaryOperator a(F f8) {
        if (f8 == null) {
            return null;
        }
        return f8 instanceof D ? ((D) f8).f50276a : new E(f8);
    }

    @Override // java.util.function.IntBinaryOperator
    public final /* synthetic */ int applyAsInt(int i8, int i9) {
        return this.f50280a.applyAsInt(i8, i9);
    }
}
