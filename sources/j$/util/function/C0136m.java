package j$.util.function;

import java.util.function.DoubleFunction;

/* renamed from: j$.util.function.m  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0136m implements InterfaceC0138o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleFunction f50329a;

    private /* synthetic */ C0136m(DoubleFunction doubleFunction) {
        this.f50329a = doubleFunction;
    }

    public static /* synthetic */ InterfaceC0138o a(DoubleFunction doubleFunction) {
        if (doubleFunction == null) {
            return null;
        }
        return doubleFunction instanceof C0137n ? ((C0137n) doubleFunction).f50331a : new C0136m(doubleFunction);
    }

    @Override // j$.util.function.InterfaceC0138o
    public final /* synthetic */ Object apply(double d8) {
        return this.f50329a.apply(d8);
    }
}
