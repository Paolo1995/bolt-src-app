package j$.util.function;

import java.util.function.LongFunction;

/* renamed from: j$.util.function.f0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0125f0 implements InterfaceC0129h0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongFunction f50319a;

    private /* synthetic */ C0125f0(LongFunction longFunction) {
        this.f50319a = longFunction;
    }

    public static /* synthetic */ InterfaceC0129h0 a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return longFunction instanceof C0127g0 ? ((C0127g0) longFunction).f50321a : new C0125f0(longFunction);
    }

    @Override // j$.util.function.InterfaceC0129h0
    public final /* synthetic */ Object apply(long j8) {
        return this.f50319a.apply(j8);
    }
}
