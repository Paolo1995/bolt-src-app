package j$.util.function;

import java.util.function.DoubleConsumer;

/* renamed from: j$.util.function.k */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0134k implements DoubleConsumer {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0135l f50327a;

    private /* synthetic */ C0134k(InterfaceC0135l interfaceC0135l) {
        this.f50327a = interfaceC0135l;
    }

    public static /* synthetic */ DoubleConsumer a(InterfaceC0135l interfaceC0135l) {
        if (interfaceC0135l == null) {
            return null;
        }
        return interfaceC0135l instanceof C0132j ? ((C0132j) interfaceC0135l).f50325a : new C0134k(interfaceC0135l);
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        this.f50327a.accept(d8);
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a(this.f50327a.l(C0132j.a(doubleConsumer)));
    }
}
