package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.a1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0163a1 extends I0 implements A0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0163a1(long j8, IntFunction intFunction) {
        super(j8, intFunction);
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
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        int i8 = this.f50421b;
        Object[] objArr = this.f50420a;
        if (i8 >= objArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.f50420a.length)));
        }
        this.f50421b = i8 + 1;
        objArr[i8] = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.A0
    public final F0 build() {
        if (this.f50421b >= this.f50420a.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f50421b), Integer.valueOf(this.f50420a.length)));
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 != this.f50420a.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j8), Integer.valueOf(this.f50420a.length)));
        }
        this.f50421b = 0;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void end() {
        if (this.f50421b < this.f50420a.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f50421b), Integer.valueOf(this.f50420a.length)));
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.stream.I0
    public final String toString() {
        return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(this.f50420a.length - this.f50421b), Arrays.toString(this.f50420a));
    }
}
