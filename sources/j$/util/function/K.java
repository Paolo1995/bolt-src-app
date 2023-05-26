package j$.util.function;

import j$.util.function.IntFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class K implements java.util.function.IntFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntFunction f50293a;

    private /* synthetic */ K(IntFunction intFunction) {
        this.f50293a = intFunction;
    }

    public static /* synthetic */ java.util.function.IntFunction a(IntFunction intFunction) {
        if (intFunction == null) {
            return null;
        }
        return intFunction instanceof IntFunction.VivifiedWrapper ? ((IntFunction.VivifiedWrapper) intFunction).f50291a : new K(intFunction);
    }

    @Override // java.util.function.IntFunction
    public final /* synthetic */ Object apply(int i8) {
        return this.f50293a.apply(i8);
    }
}
