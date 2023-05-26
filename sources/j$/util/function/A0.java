package j$.util.function;

import java.util.function.ObjLongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class A0 implements C0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ObjLongConsumer f50265a;

    private /* synthetic */ A0(ObjLongConsumer objLongConsumer) {
        this.f50265a = objLongConsumer;
    }

    public static /* synthetic */ C0 a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        return objLongConsumer instanceof B0 ? ((B0) objLongConsumer).f50269a : new A0(objLongConsumer);
    }

    @Override // j$.util.function.C0
    public final /* synthetic */ void accept(Object obj, long j8) {
        this.f50265a.accept(obj, j8);
    }
}
