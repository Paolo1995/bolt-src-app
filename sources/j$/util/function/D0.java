package j$.util.function;

import j$.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class D0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50277a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f50278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Predicate f50279c;

    public /* synthetic */ D0(Predicate predicate, Predicate predicate2, int i8) {
        this.f50277a = i8;
        this.f50278b = predicate;
        this.f50279c = predicate2;
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f50277a) {
            case 0:
                return Predicate.CC.$default$and(this, predicate);
            default:
                return Predicate.CC.$default$and(this, predicate);
        }
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f50277a) {
            case 0:
                return Predicate.CC.$default$negate(this);
            default:
                return Predicate.CC.$default$negate(this);
        }
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f50277a) {
            case 0:
                return Predicate.CC.$default$or(this, predicate);
            default:
                return Predicate.CC.$default$or(this, predicate);
        }
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f50277a) {
            case 0:
                return this.f50278b.test(obj) && this.f50279c.test(obj);
            default:
                return this.f50278b.test(obj) || this.f50279c.test(obj);
        }
    }
}
