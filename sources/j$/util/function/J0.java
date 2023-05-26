package j$.util.function;

import j$.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class J0 implements java.util.function.ToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ToLongFunction f50292a;

    private /* synthetic */ J0(ToLongFunction toLongFunction) {
        this.f50292a = toLongFunction;
    }

    public static /* synthetic */ java.util.function.ToLongFunction a(ToLongFunction toLongFunction) {
        if (toLongFunction == null) {
            return null;
        }
        return toLongFunction instanceof ToLongFunction.VivifiedWrapper ? ((ToLongFunction.VivifiedWrapper) toLongFunction).f50303a : new J0(toLongFunction);
    }

    @Override // java.util.function.ToLongFunction
    public final /* synthetic */ long applyAsLong(Object obj) {
        return this.f50292a.applyAsLong(obj);
    }
}
