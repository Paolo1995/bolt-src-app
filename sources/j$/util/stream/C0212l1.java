package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.l1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0212l1 extends C0208k1 implements InterfaceC0266z0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0212l1(long j8) {
        super(j8);
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

    @Override // j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        int i8 = this.f50606b;
        long[] jArr = this.f50605a;
        if (i8 >= jArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f50605a.length)));
        }
        this.f50606b = i8 + 1;
        jArr[i8] = j8;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        k((Long) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0266z0, j$.util.stream.A0
    public final D0 build() {
        if (this.f50606b >= this.f50605a.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f50606b), Integer.valueOf(this.f50605a.length)));
    }

    @Override // j$.util.stream.A0
    public final /* bridge */ /* synthetic */ F0 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 != this.f50605a.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j8), Integer.valueOf(this.f50605a.length)));
        }
        this.f50606b = 0;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void end() {
        if (this.f50606b < this.f50605a.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f50606b), Integer.valueOf(this.f50605a.length)));
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
    }

    @Override // j$.util.stream.C0208k1
    public final String toString() {
        return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.f50605a.length - this.f50606b), Arrays.toString(this.f50605a));
    }
}
