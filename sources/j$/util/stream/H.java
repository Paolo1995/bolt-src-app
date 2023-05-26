package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Predicate;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
final class H implements B3 {

    /* renamed from: a  reason: collision with root package name */
    final boolean f50404a;

    /* renamed from: b  reason: collision with root package name */
    final Object f50405b;

    /* renamed from: c  reason: collision with root package name */
    final Predicate f50406c;

    /* renamed from: d  reason: collision with root package name */
    final Supplier f50407d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(boolean z7, int i8, Object obj, L0 l02, C0166b c0166b) {
        this.f50404a = z7;
        this.f50405b = obj;
        this.f50406c = l02;
        this.f50407d = c0166b;
    }

    @Override // j$.util.stream.B3
    public final int O() {
        return U2.f50505u | (this.f50404a ? 0 : U2.f50502r);
    }

    @Override // j$.util.stream.B3
    public final Object m0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        C3 c32 = (C3) this.f50407d.get();
        abstractC0254w0.v1(spliterator, c32);
        Object obj = c32.get();
        return obj != null ? obj : this.f50405b;
    }

    @Override // j$.util.stream.B3
    public final Object y(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        return new N(this, abstractC0254w0, spliterator).invoke();
    }
}
