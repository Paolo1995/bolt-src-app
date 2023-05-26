package j$.util.function;

import java.util.function.ObjIntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class x0 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ObjIntConsumer f50347a;

    private /* synthetic */ x0(ObjIntConsumer objIntConsumer) {
        this.f50347a = objIntConsumer;
    }

    public static /* synthetic */ z0 a(ObjIntConsumer objIntConsumer) {
        if (objIntConsumer == null) {
            return null;
        }
        return objIntConsumer instanceof y0 ? ((y0) objIntConsumer).f50349a : new x0(objIntConsumer);
    }

    @Override // j$.util.function.z0
    public final /* synthetic */ void accept(Object obj, int i8) {
        this.f50347a.accept(obj, i8);
    }
}
