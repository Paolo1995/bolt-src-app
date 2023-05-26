package j$.util.function;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.util.function.f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0124f implements InterfaceC0128h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleBinaryOperator f50318a;

    private /* synthetic */ C0124f(DoubleBinaryOperator doubleBinaryOperator) {
        this.f50318a = doubleBinaryOperator;
    }

    public static /* synthetic */ InterfaceC0128h a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return doubleBinaryOperator instanceof C0126g ? ((C0126g) doubleBinaryOperator).f50320a : new C0124f(doubleBinaryOperator);
    }

    @Override // j$.util.function.InterfaceC0128h
    public final /* synthetic */ double applyAsDouble(double d8, double d9) {
        return this.f50318a.applyAsDouble(d8, d9);
    }
}
