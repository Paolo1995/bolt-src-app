package j$.util.function;

import java.util.function.LongBinaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class Y implements InterfaceC0115a0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongBinaryOperator f50307a;

    private /* synthetic */ Y(LongBinaryOperator longBinaryOperator) {
        this.f50307a = longBinaryOperator;
    }

    public static /* synthetic */ InterfaceC0115a0 a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        return longBinaryOperator instanceof Z ? ((Z) longBinaryOperator).f50308a : new Y(longBinaryOperator);
    }

    @Override // j$.util.function.InterfaceC0115a0
    public final /* synthetic */ long applyAsLong(long j8, long j9) {
        return this.f50307a.applyAsLong(j8, j9);
    }
}
