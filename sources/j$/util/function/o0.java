package j$.util.function;

import java.util.function.LongToIntFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class o0 implements q0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongToIntFunction f50332a;

    private /* synthetic */ o0(LongToIntFunction longToIntFunction) {
        this.f50332a = longToIntFunction;
    }

    public static /* synthetic */ q0 b(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        return longToIntFunction instanceof p0 ? ((p0) longToIntFunction).f50334a : new o0(longToIntFunction);
    }

    public final /* synthetic */ int a(long j8) {
        return this.f50332a.applyAsInt(j8);
    }
}
