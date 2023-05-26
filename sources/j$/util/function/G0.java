package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class G0 implements java.util.function.Supplier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Supplier f50286a;

    private /* synthetic */ G0(Supplier supplier) {
        this.f50286a = supplier;
    }

    public static /* synthetic */ java.util.function.Supplier a(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier instanceof F0 ? ((F0) supplier).f50282a : new G0(supplier);
    }

    @Override // java.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.f50286a.get();
    }
}
