package j$.util.function;

import j$.util.function.ToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class H0 implements java.util.function.ToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ToDoubleFunction f50288a;

    private /* synthetic */ H0(ToDoubleFunction toDoubleFunction) {
        this.f50288a = toDoubleFunction;
    }

    public static /* synthetic */ java.util.function.ToDoubleFunction a(ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return toDoubleFunction instanceof ToDoubleFunction.VivifiedWrapper ? ((ToDoubleFunction.VivifiedWrapper) toDoubleFunction).f50301a : new H0(toDoubleFunction);
    }

    @Override // java.util.function.ToDoubleFunction
    public final /* synthetic */ double applyAsDouble(Object obj) {
        return this.f50288a.applyAsDouble(obj);
    }
}
