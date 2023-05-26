package j$.util.function;

import java.util.function.ObjDoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class u0 implements w0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ObjDoubleConsumer f50343a;

    private /* synthetic */ u0(ObjDoubleConsumer objDoubleConsumer) {
        this.f50343a = objDoubleConsumer;
    }

    public static /* synthetic */ w0 a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        return objDoubleConsumer instanceof v0 ? ((v0) objDoubleConsumer).f50345a : new u0(objDoubleConsumer);
    }

    @Override // j$.util.function.w0
    public final /* synthetic */ void accept(Object obj, double d8) {
        this.f50343a.accept(obj, d8);
    }
}
