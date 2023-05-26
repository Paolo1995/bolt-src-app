package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.d1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0178d1 extends L2 implements C0, InterfaceC0262y0 {
    @Override // j$.util.stream.E0, j$.util.stream.F0
    public final E0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.F0
    public final /* bridge */ /* synthetic */ F0 a(int i8) {
        a(i8);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.L2, j$.util.function.J
    public final void accept(int i8) {
        super.accept(i8);
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

    @Override // j$.util.stream.P2, j$.util.stream.E0
    public final Object b() {
        return (int[]) super.b();
    }

    @Override // j$.util.stream.InterfaceC0262y0, j$.util.stream.A0
    public final C0 build() {
        return this;
    }

    @Override // j$.util.stream.A0
    public final F0 build() {
        return this;
    }

    @Override // j$.util.stream.P2, j$.util.stream.E0
    public final void c(int i8, Object obj) {
        super.c(i8, (int[]) obj);
    }

    @Override // j$.util.stream.P2, j$.util.stream.E0
    public final void d(Object obj) {
        super.d((j$.util.function.J) obj);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        clear();
        u(j8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void end() {
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ int n() {
        return 0;
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ Object[] p(IntFunction intFunction) {
        return AbstractC0254w0.x0(this, intFunction);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.F0(this, j8, j9);
    }

    @Override // j$.util.stream.L2, j$.util.stream.P2, java.lang.Iterable
    public final j$.util.M spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.L2, j$.util.stream.P2, java.lang.Iterable
    public final Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.L2
    public final j$.util.G x() {
        return super.spliterator();
    }

    @Override // j$.util.stream.F0
    /* renamed from: y */
    public final /* synthetic */ void i(Integer[] numArr, int i8) {
        AbstractC0254w0.z0(this, numArr, i8);
    }
}
