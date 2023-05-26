package j$.util.function;

import java.util.function.DoubleConsumer;

/* renamed from: j$.util.function.j  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0132j implements InterfaceC0135l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleConsumer f50325a;

    private /* synthetic */ C0132j(DoubleConsumer doubleConsumer) {
        this.f50325a = doubleConsumer;
    }

    public static /* synthetic */ InterfaceC0135l a(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return doubleConsumer instanceof C0134k ? ((C0134k) doubleConsumer).f50327a : new C0132j(doubleConsumer);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        this.f50325a.accept(d8);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final /* synthetic */ InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        return a(this.f50325a.andThen(C0134k.a(interfaceC0135l)));
    }
}
