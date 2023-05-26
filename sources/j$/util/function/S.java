package j$.util.function;

import java.util.function.IntToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class S implements U {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntToLongFunction f50299a;

    private /* synthetic */ S(IntToLongFunction intToLongFunction) {
        this.f50299a = intToLongFunction;
    }

    public static /* synthetic */ U a(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        return intToLongFunction instanceof T ? ((T) intToLongFunction).f50300a : new S(intToLongFunction);
    }

    @Override // j$.util.function.U
    public final /* synthetic */ long applyAsLong(int i8) {
        return this.f50299a.applyAsLong(i8);
    }
}
