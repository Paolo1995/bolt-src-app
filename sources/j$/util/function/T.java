package j$.util.function;

import java.util.function.IntToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class T implements IntToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ U f50300a;

    private /* synthetic */ T(U u7) {
        this.f50300a = u7;
    }

    public static /* synthetic */ IntToLongFunction a(U u7) {
        if (u7 == null) {
            return null;
        }
        return u7 instanceof S ? ((S) u7).f50299a : new T(u7);
    }

    @Override // java.util.function.IntToLongFunction
    public final /* synthetic */ long applyAsLong(int i8) {
        return this.f50300a.applyAsLong(i8);
    }
}
