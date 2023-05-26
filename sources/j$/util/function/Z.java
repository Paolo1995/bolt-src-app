package j$.util.function;

import java.util.function.LongBinaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class Z implements LongBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0115a0 f50308a;

    private /* synthetic */ Z(InterfaceC0115a0 interfaceC0115a0) {
        this.f50308a = interfaceC0115a0;
    }

    public static /* synthetic */ LongBinaryOperator a(InterfaceC0115a0 interfaceC0115a0) {
        if (interfaceC0115a0 == null) {
            return null;
        }
        return interfaceC0115a0 instanceof Y ? ((Y) interfaceC0115a0).f50307a : new Z(interfaceC0115a0);
    }

    @Override // java.util.function.LongBinaryOperator
    public final /* synthetic */ long applyAsLong(long j8, long j9) {
        return this.f50308a.applyAsLong(j8, j9);
    }
}
