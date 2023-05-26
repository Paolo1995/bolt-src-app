package j$.util.function;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.util.function.g  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0126g implements DoubleBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0128h f50320a;

    private /* synthetic */ C0126g(InterfaceC0128h interfaceC0128h) {
        this.f50320a = interfaceC0128h;
    }

    public static /* synthetic */ DoubleBinaryOperator a(InterfaceC0128h interfaceC0128h) {
        if (interfaceC0128h == null) {
            return null;
        }
        return interfaceC0128h instanceof C0124f ? ((C0124f) interfaceC0128h).f50318a : new C0126g(interfaceC0128h);
    }

    @Override // java.util.function.DoubleBinaryOperator
    public final /* synthetic */ double applyAsDouble(double d8, double d9) {
        return this.f50320a.applyAsDouble(d8, d9);
    }
}
