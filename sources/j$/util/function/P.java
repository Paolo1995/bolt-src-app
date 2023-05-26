package j$.util.function;

import java.util.function.IntToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class P implements IntToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Q f50297a;

    private /* synthetic */ P(Q q8) {
        this.f50297a = q8;
    }

    public static /* synthetic */ IntToDoubleFunction a(Q q8) {
        if (q8 == null) {
            return null;
        }
        return q8 instanceof O ? ((O) q8).f50296a : new P(q8);
    }

    @Override // java.util.function.IntToDoubleFunction
    public final /* synthetic */ double applyAsDouble(int i8) {
        return ((O) this.f50297a).a(i8);
    }
}
