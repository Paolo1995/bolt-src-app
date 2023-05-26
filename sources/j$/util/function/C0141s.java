package j$.util.function;

import java.util.function.DoubleToIntFunction;

/* renamed from: j$.util.function.s  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0141s implements InterfaceC0143u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleToIntFunction f50339a;

    private /* synthetic */ C0141s(DoubleToIntFunction doubleToIntFunction) {
        this.f50339a = doubleToIntFunction;
    }

    public static /* synthetic */ InterfaceC0143u b(DoubleToIntFunction doubleToIntFunction) {
        if (doubleToIntFunction == null) {
            return null;
        }
        return doubleToIntFunction instanceof C0142t ? ((C0142t) doubleToIntFunction).f50341a : new C0141s(doubleToIntFunction);
    }

    public final /* synthetic */ int a(double d8) {
        return this.f50339a.applyAsInt(d8);
    }
}
