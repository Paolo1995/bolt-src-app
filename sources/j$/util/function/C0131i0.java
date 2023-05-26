package j$.util.function;

import java.util.function.LongPredicate;

/* renamed from: j$.util.function.i0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0131i0 implements k0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongPredicate f50324a;

    private /* synthetic */ C0131i0(LongPredicate longPredicate) {
        this.f50324a = longPredicate;
    }

    public static /* synthetic */ k0 b(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return longPredicate instanceof C0133j0 ? ((C0133j0) longPredicate).f50326a : new C0131i0(longPredicate);
    }

    public final /* synthetic */ k0 a(k0 k0Var) {
        return b(this.f50324a.and(C0133j0.a(k0Var)));
    }

    public final /* synthetic */ k0 c() {
        return b(this.f50324a.negate());
    }

    public final /* synthetic */ k0 d(k0 k0Var) {
        return b(this.f50324a.or(C0133j0.a(k0Var)));
    }

    public final /* synthetic */ boolean e(long j8) {
        return this.f50324a.test(j8);
    }
}
