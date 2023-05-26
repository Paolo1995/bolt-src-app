package j$.util.function;

import java.util.function.ObjLongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class B0 implements ObjLongConsumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0 f50269a;

    private /* synthetic */ B0(C0 c02) {
        this.f50269a = c02;
    }

    public static /* synthetic */ ObjLongConsumer a(C0 c02) {
        if (c02 == null) {
            return null;
        }
        return c02 instanceof A0 ? ((A0) c02).f50265a : new B0(c02);
    }

    @Override // java.util.function.ObjLongConsumer
    public final /* synthetic */ void accept(Object obj, long j8) {
        this.f50269a.accept(obj, j8);
    }
}
