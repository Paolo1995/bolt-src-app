package j$.util.function;

import java.util.function.DoubleToLongFunction;

/* renamed from: j$.util.function.v  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0144v implements InterfaceC0146x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleToLongFunction f50344a;

    private /* synthetic */ C0144v(DoubleToLongFunction doubleToLongFunction) {
        this.f50344a = doubleToLongFunction;
    }

    public static /* synthetic */ InterfaceC0146x a(DoubleToLongFunction doubleToLongFunction) {
        if (doubleToLongFunction == null) {
            return null;
        }
        return doubleToLongFunction instanceof C0145w ? ((C0145w) doubleToLongFunction).f50346a : new C0144v(doubleToLongFunction);
    }

    @Override // j$.util.function.InterfaceC0146x
    public final /* synthetic */ long applyAsLong(double d8) {
        return this.f50344a.applyAsLong(d8);
    }
}
