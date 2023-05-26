package j$.util.function;

import java.util.function.LongToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class l0 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongToDoubleFunction f50328a;

    private /* synthetic */ l0(LongToDoubleFunction longToDoubleFunction) {
        this.f50328a = longToDoubleFunction;
    }

    public static /* synthetic */ n0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return longToDoubleFunction instanceof m0 ? ((m0) longToDoubleFunction).f50330a : new l0(longToDoubleFunction);
    }

    public final /* synthetic */ double a(long j8) {
        return this.f50328a.applyAsDouble(j8);
    }
}
