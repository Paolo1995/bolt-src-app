package j$.util.stream;

import j$.util.C0153k;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class K1 implements P1, InterfaceC0184e2 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f50432a;

    /* renamed from: b  reason: collision with root package name */
    private int f50433b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$.util.function.F f50434c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K1(j$.util.function.F f8) {
        this.f50434c = f8;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        if (this.f50432a) {
            this.f50432a = false;
        } else {
            i8 = this.f50434c.applyAsInt(this.f50433b, i8);
        }
        this.f50433b = i8;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        f((Integer) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50432a = true;
        this.f50433b = 0;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        return this.f50432a ? C0153k.a() : C0153k.d(this.f50433b);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        K1 k12 = (K1) p12;
        if (k12.f50432a) {
            return;
        }
        accept(k12.f50433b);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
