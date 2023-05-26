package j$.util.function;

import java.util.function.ObjDoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class v0 implements ObjDoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w0 f50345a;

    private /* synthetic */ v0(w0 w0Var) {
        this.f50345a = w0Var;
    }

    public static /* synthetic */ ObjDoubleConsumer a(w0 w0Var) {
        if (w0Var == null) {
            return null;
        }
        return w0Var instanceof u0 ? ((u0) w0Var).f50343a : new v0(w0Var);
    }

    @Override // java.util.function.ObjDoubleConsumer
    public final /* synthetic */ void accept(Object obj, double d8) {
        this.f50345a.accept(obj, d8);
    }
}
