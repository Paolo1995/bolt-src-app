package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BooleanSupplier;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.Supplier;
import java.util.List;

/* renamed from: j$.util.stream.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0161a implements Supplier, InterfaceC0129h0, Consumer, BooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f50538b;

    public /* synthetic */ C0161a(int i8, Object obj) {
        this.f50537a = i8;
        this.f50538b = obj;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f50537a) {
            case 3:
                ((InterfaceC0193g2) this.f50538b).accept((InterfaceC0193g2) obj);
                return;
            default:
                ((List) this.f50538b).add(obj);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50537a) {
            case 3:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    @Override // j$.util.function.InterfaceC0129h0
    public final Object apply(long j8) {
        int i8 = K0.f50431k;
        return AbstractC0254w0.O0(j8, (IntFunction) this.f50538b);
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        switch (this.f50537a) {
            case 0:
                return (Spliterator) this.f50538b;
            default:
                return ((AbstractC0171c) this.f50538b).F1();
        }
    }

    @Override // j$.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        switch (this.f50537a) {
            case 4:
                C0185e3 c0185e3 = (C0185e3) this.f50538b;
                return c0185e3.f50519d.tryAdvance(c0185e3.f50520e);
            case 5:
                g3 g3Var = (g3) this.f50538b;
                return g3Var.f50519d.tryAdvance(g3Var.f50520e);
            case 6:
                i3 i3Var = (i3) this.f50538b;
                return i3Var.f50519d.tryAdvance(i3Var.f50520e);
            default:
                z3 z3Var = (z3) this.f50538b;
                return z3Var.f50519d.tryAdvance(z3Var.f50520e);
        }
    }
}
