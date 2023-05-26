package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0123e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.m1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0216m1 extends N2 implements D0, InterfaceC0266z0 {
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

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    @Override // j$.util.stream.N2, j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        super.accept(j8);
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        k((Long) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.P2, j$.util.stream.E0
    public final Object b() {
        return (long[]) super.b();
    }

    @Override // j$.util.stream.InterfaceC0266z0, j$.util.stream.A0
    public final D0 build() {
        return this;
    }

    @Override // j$.util.stream.A0
    public final F0 build() {
        return this;
    }

    @Override // j$.util.stream.P2, j$.util.stream.E0
    public final void c(int i8, Object obj) {
        super.c(i8, (long[]) obj);
    }

    @Override // j$.util.stream.P2, j$.util.stream.E0
    public final void d(Object obj) {
        super.d((InterfaceC0123e0) obj);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        clear();
        u(j8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
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
        return AbstractC0254w0.G0(this, j8, j9);
    }

    @Override // j$.util.stream.N2, j$.util.stream.P2, java.lang.Iterable
    public final j$.util.M spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.N2, j$.util.stream.P2, java.lang.Iterable
    public final Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.N2
    public final j$.util.J x() {
        return super.spliterator();
    }

    @Override // j$.util.stream.F0
    /* renamed from: y */
    public final /* synthetic */ void i(Long[] lArr, int i8) {
        AbstractC0254w0.A0(this, lArr, i8);
    }
}
