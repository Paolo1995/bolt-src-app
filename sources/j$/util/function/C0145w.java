package j$.util.function;

import java.util.function.DoubleToLongFunction;

/* renamed from: j$.util.function.w  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0145w implements DoubleToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0146x f50346a;

    private /* synthetic */ C0145w(InterfaceC0146x interfaceC0146x) {
        this.f50346a = interfaceC0146x;
    }

    public static /* synthetic */ DoubleToLongFunction a(InterfaceC0146x interfaceC0146x) {
        if (interfaceC0146x == null) {
            return null;
        }
        return interfaceC0146x instanceof C0144v ? ((C0144v) interfaceC0146x).f50344a : new C0145w(interfaceC0146x);
    }

    @Override // java.util.function.DoubleToLongFunction
    public final /* synthetic */ long applyAsLong(double d8) {
        return this.f50346a.applyAsLong(d8);
    }
}
