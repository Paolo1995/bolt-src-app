package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.u0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0246u0 implements B3 {

    /* renamed from: a  reason: collision with root package name */
    final EnumC0242t0 f50683a;

    /* renamed from: b  reason: collision with root package name */
    final Supplier f50684b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0246u0(int i8, EnumC0242t0 enumC0242t0, C0222o c0222o) {
        this.f50683a = enumC0242t0;
        this.f50684b = c0222o;
    }

    @Override // j$.util.stream.B3
    public final int O() {
        return U2.f50505u | U2.f50502r;
    }

    @Override // j$.util.stream.B3
    public final Object m0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        AbstractC0238s0 abstractC0238s0 = (AbstractC0238s0) this.f50684b.get();
        abstractC0254w0.v1(spliterator, abstractC0238s0);
        return Boolean.valueOf(abstractC0238s0.f50671b);
    }

    @Override // j$.util.stream.B3
    public final Object y(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        return (Boolean) new C0250v0(this, abstractC0254w0, spliterator).invoke();
    }
}
