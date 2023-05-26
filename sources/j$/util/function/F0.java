package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class F0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.Supplier f50282a;

    private /* synthetic */ F0(java.util.function.Supplier supplier) {
        this.f50282a = supplier;
    }

    public static /* synthetic */ Supplier a(java.util.function.Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier instanceof G0 ? ((G0) supplier).f50286a : new F0(supplier);
    }

    @Override // j$.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.f50282a.get();
    }
}
