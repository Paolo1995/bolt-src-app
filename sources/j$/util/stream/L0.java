package j$.util.stream;

import j$.util.C0113f;
import j$.util.C0149g;
import j$.util.C0150h;
import j$.util.C0152j;
import j$.util.C0153k;
import j$.util.C0154l;
import j$.util.Optional;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0120d;
import j$.util.function.InterfaceC0128h;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.InterfaceC0138o;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToLongFunction;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public final /* synthetic */ class L0 implements InterfaceC0120d, InterfaceC0129h0, IntFunction, ToLongFunction, Consumer, Supplier, BiConsumer, InterfaceC0128h, InterfaceC0138o, j$.util.function.w0, Predicate, j$.util.function.F, j$.util.function.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50436a;

    public /* synthetic */ L0(int i8) {
        this.f50436a = i8;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
    }

    @Override // j$.util.function.w0
    public final void accept(Object obj, double d8) {
        ((C0113f) obj).accept(d8);
    }

    @Override // j$.util.function.z0
    public final void accept(Object obj, int i8) {
        ((C0149g) obj).accept(i8);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f50436a) {
            case 16:
                ((LinkedHashSet) obj).add(obj2);
                return;
            case 17:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                return;
            default:
                ((C0113f) obj).a((C0113f) obj2);
                return;
        }
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f50436a) {
            case 23:
                return Predicate.CC.$default$and(this, predicate);
            case 24:
                return Predicate.CC.$default$and(this, predicate);
            case 25:
                return Predicate.CC.$default$and(this, predicate);
            default:
                return Predicate.CC.$default$and(this, predicate);
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f50436a) {
            case 16:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 17:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f50436a) {
            case 0:
                return BiFunction.CC.$default$andThen(this, function);
            case 1:
            default:
                return BiFunction.CC.$default$andThen(this, function);
            case 2:
                return BiFunction.CC.$default$andThen(this, function);
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50436a) {
            case 10:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    @Override // j$.util.function.InterfaceC0138o
    public final Object apply(double d8) {
        return Double.valueOf(d8);
    }

    @Override // j$.util.function.IntFunction
    public final Object apply(int i8) {
        switch (this.f50436a) {
            case 4:
                int i9 = Y1.f50532s;
                return new Object[i8];
            case 5:
            default:
                int i10 = C0225o2.f50632v;
                return new Double[i8];
            case 6:
                return new Object[i8];
            case 7:
                int i11 = C0209k2.f50607v;
                return new Integer[i8];
            case 8:
                int i12 = C0217m2.f50617v;
                return new Long[i8];
        }
    }

    @Override // j$.util.function.InterfaceC0129h0
    public final Object apply(long j8) {
        return AbstractC0254w0.i1(j8);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f50436a) {
            case 0:
                return new O0((C0) obj, (C0) obj2);
            case 1:
            default:
                return new R0((F0) obj, (F0) obj2);
            case 2:
                return new P0((D0) obj, (D0) obj2);
        }
    }

    @Override // j$.util.function.InterfaceC0128h
    public final double applyAsDouble(double d8, double d9) {
        switch (this.f50436a) {
            case 18:
                return Math.min(d8, d9);
            default:
                return Math.max(d8, d9);
        }
    }

    @Override // j$.util.function.F
    public final int applyAsInt(int i8, int i9) {
        switch (this.f50436a) {
            case 27:
                return Math.min(i8, i9);
            default:
                return i8 + i9;
        }
    }

    @Override // j$.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        int i8 = Y1.f50532s;
        return 1L;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        switch (this.f50436a) {
            case 12:
                return new C0113f();
            case 13:
                return new C0149g();
            case 14:
                return new C0150h();
            default:
                return new LinkedHashSet();
        }
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f50436a) {
            case 23:
                return Predicate.CC.$default$negate(this);
            case 24:
                return Predicate.CC.$default$negate(this);
            case 25:
                return Predicate.CC.$default$negate(this);
            default:
                return Predicate.CC.$default$negate(this);
        }
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f50436a) {
            case 23:
                return Predicate.CC.$default$or(this, predicate);
            case 24:
                return Predicate.CC.$default$or(this, predicate);
            case 25:
                return Predicate.CC.$default$or(this, predicate);
            default:
                return Predicate.CC.$default$or(this, predicate);
        }
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f50436a) {
            case 23:
                return ((C0152j) obj).c();
            case 24:
                return ((C0154l) obj).c();
            case 25:
                return ((Optional) obj).isPresent();
            default:
                return ((C0153k) obj).c();
        }
    }
}
