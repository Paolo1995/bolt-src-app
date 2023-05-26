package j$.util.stream;

import j$.util.function.Consumer;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.c1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0173c1 extends C0168b1 implements InterfaceC0262y0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0173c1(long j8) {
        super(j8);
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        int i9 = this.f50543b;
        int[] iArr = this.f50542a;
        if (i9 >= iArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f50542a.length)));
        }
        this.f50543b = i9 + 1;
        iArr[i9] = i8;
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

    @Override // j$.util.stream.InterfaceC0262y0, j$.util.stream.A0
    public final C0 build() {
        if (this.f50543b >= this.f50542a.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f50543b), Integer.valueOf(this.f50542a.length)));
    }

    @Override // j$.util.stream.A0
    public final /* bridge */ /* synthetic */ F0 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 != this.f50542a.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j8), Integer.valueOf(this.f50542a.length)));
        }
        this.f50543b = 0;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void end() {
        if (this.f50543b < this.f50542a.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f50543b), Integer.valueOf(this.f50542a.length)));
        }
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }

    @Override // j$.util.stream.C0168b1
    public final String toString() {
        return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(this.f50542a.length - this.f50543b), Arrays.toString(this.f50542a));
    }
}
