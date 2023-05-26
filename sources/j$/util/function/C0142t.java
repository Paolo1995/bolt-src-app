package j$.util.function;

import java.util.function.DoubleToIntFunction;

/* renamed from: j$.util.function.t  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0142t implements DoubleToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0143u f50341a;

    private /* synthetic */ C0142t(InterfaceC0143u interfaceC0143u) {
        this.f50341a = interfaceC0143u;
    }

    public static /* synthetic */ DoubleToIntFunction a(InterfaceC0143u interfaceC0143u) {
        if (interfaceC0143u == null) {
            return null;
        }
        return interfaceC0143u instanceof C0141s ? ((C0141s) interfaceC0143u).f50339a : new C0142t(interfaceC0143u);
    }

    @Override // java.util.function.DoubleToIntFunction
    public final /* synthetic */ int applyAsInt(double d8) {
        return ((C0141s) this.f50341a).a(d8);
    }
}
