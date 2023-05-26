package j$.util.function;

import java.util.function.DoubleFunction;

/* renamed from: j$.util.function.n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0137n implements DoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0138o f50331a;

    private /* synthetic */ C0137n(InterfaceC0138o interfaceC0138o) {
        this.f50331a = interfaceC0138o;
    }

    public static /* synthetic */ DoubleFunction a(InterfaceC0138o interfaceC0138o) {
        if (interfaceC0138o == null) {
            return null;
        }
        return interfaceC0138o instanceof C0136m ? ((C0136m) interfaceC0138o).f50329a : new C0137n(interfaceC0138o);
    }

    @Override // java.util.function.DoubleFunction
    public final /* synthetic */ Object apply(double d8) {
        return this.f50331a.apply(d8);
    }
}
