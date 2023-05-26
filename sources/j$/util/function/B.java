package j$.util.function;

import j$.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class B implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50266a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f50267b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f50268c;

    public /* synthetic */ B(Function function, Function function2, int i8) {
        this.f50266a = i8;
        this.f50267b = function;
        this.f50268c = function2;
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function andThen(Function function) {
        switch (this.f50266a) {
            case 0:
                return Function.CC.$default$andThen(this, function);
            default:
                return Function.CC.$default$andThen(this, function);
        }
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f50266a) {
            case 0:
                return this.f50268c.apply(this.f50267b.apply(obj));
            default:
                return this.f50267b.apply(this.f50268c.apply(obj));
        }
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        switch (this.f50266a) {
            case 0:
                return Function.CC.$default$compose(this, function);
            default:
                return Function.CC.$default$compose(this, function);
        }
    }
}
