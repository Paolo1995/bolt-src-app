package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Predicate;
import java.util.Comparator;

/* renamed from: j$.util.function.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0114a implements InterfaceC0120d, Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50309a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f50310b;

    public /* synthetic */ C0114a(int i8, Object obj) {
        this.f50309a = i8;
        this.f50310b = obj;
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f50309a) {
            case 0:
                return BiFunction.CC.$default$andThen(this, function);
            default:
                return BiFunction.CC.$default$andThen(this, function);
        }
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f50309a) {
            case 0:
                return ((Comparator) this.f50310b).compare(obj, obj2) >= 0 ? obj : obj2;
            default:
                return ((Comparator) this.f50310b).compare(obj, obj2) <= 0 ? obj : obj2;
        }
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return !((Predicate) this.f50310b).test(obj);
    }
}
