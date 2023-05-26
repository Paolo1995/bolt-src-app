package j$.util.function;

import j$.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class C implements java.util.function.Function {

    /* renamed from: a */
    final /* synthetic */ Function f50274a;

    private /* synthetic */ C(Function function) {
        this.f50274a = function;
    }

    public static /* synthetic */ java.util.function.Function a(Function function) {
        if (function == null) {
            return null;
        }
        return function instanceof Function.VivifiedWrapper ? ((Function.VivifiedWrapper) function).f50283a : new C(function);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ java.util.function.Function andThen(java.util.function.Function function) {
        return a(this.f50274a.andThen(Function.VivifiedWrapper.convert(function)));
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return this.f50274a.apply(obj);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
        return a(this.f50274a.compose(Function.VivifiedWrapper.convert(function)));
    }
}
