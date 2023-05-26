package j$.util.stream;

import j$.util.C0149g;
import j$.util.C0150h;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0115a0;
import j$.util.function.InterfaceC0129h0;

/* loaded from: classes2.dex */
public final /* synthetic */ class X implements BiConsumer, IntFunction, j$.util.function.F, InterfaceC0115a0, InterfaceC0129h0, j$.util.function.C0, Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50528a;

    public /* synthetic */ X(int i8) {
        this.f50528a = i8;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
    }

    @Override // j$.util.function.C0
    public final void accept(Object obj, long j8) {
        ((C0150h) obj).accept(j8);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f50528a) {
            case 0:
                ((C0149g) obj).a((C0149g) obj2);
                return;
            default:
                ((C0150h) obj).a((C0150h) obj2);
                return;
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f50528a) {
            case 0:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.IntFunction
    public final Object apply(int i8) {
        return Integer.valueOf(i8);
    }

    @Override // j$.util.function.InterfaceC0129h0
    public final Object apply(long j8) {
        return Long.valueOf(j8);
    }

    @Override // j$.util.function.F
    public final int applyAsInt(int i8, int i9) {
        return Math.max(i8, i9);
    }

    @Override // j$.util.function.InterfaceC0115a0
    public final long applyAsLong(long j8, long j9) {
        switch (this.f50528a) {
            case 3:
                return Math.min(j8, j9);
            case 4:
                return Math.max(j8, j9);
            default:
                return j8 + j9;
        }
    }
}
