package j$.util.function;

import java.util.function.ObjIntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class y0 implements ObjIntConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z0 f50349a;

    private /* synthetic */ y0(z0 z0Var) {
        this.f50349a = z0Var;
    }

    public static /* synthetic */ ObjIntConsumer a(z0 z0Var) {
        if (z0Var == null) {
            return null;
        }
        return z0Var instanceof x0 ? ((x0) z0Var).f50347a : new y0(z0Var);
    }

    @Override // java.util.function.ObjIntConsumer
    public final /* synthetic */ void accept(Object obj, int i8) {
        this.f50349a.accept(obj, i8);
    }
}
