package j$.util.function;

import j$.util.function.ToIntFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class I0 implements java.util.function.ToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ToIntFunction f50290a;

    private /* synthetic */ I0(ToIntFunction toIntFunction) {
        this.f50290a = toIntFunction;
    }

    public static /* synthetic */ java.util.function.ToIntFunction a(ToIntFunction toIntFunction) {
        if (toIntFunction == null) {
            return null;
        }
        return toIntFunction instanceof ToIntFunction.VivifiedWrapper ? ((ToIntFunction.VivifiedWrapper) toIntFunction).f50302a : new I0(toIntFunction);
    }

    @Override // java.util.function.ToIntFunction
    public final /* synthetic */ int applyAsInt(Object obj) {
        return this.f50290a.applyAsInt(obj);
    }
}
