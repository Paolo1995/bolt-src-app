package j$.util.function;

import java.util.function.IntToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class O implements Q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntToDoubleFunction f50296a;

    private /* synthetic */ O(IntToDoubleFunction intToDoubleFunction) {
        this.f50296a = intToDoubleFunction;
    }

    public static /* synthetic */ Q b(IntToDoubleFunction intToDoubleFunction) {
        if (intToDoubleFunction == null) {
            return null;
        }
        return intToDoubleFunction instanceof P ? ((P) intToDoubleFunction).f50297a : new O(intToDoubleFunction);
    }

    public final /* synthetic */ double a(int i8) {
        return this.f50296a.applyAsDouble(i8);
    }
}
