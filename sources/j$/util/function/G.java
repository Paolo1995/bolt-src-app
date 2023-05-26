package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class G implements J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J f50284a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ J f50285b;

    public /* synthetic */ G(J j8, J j9) {
        this.f50284a = j8;
        this.f50285b = j9;
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        J j8 = this.f50284a;
        J j9 = this.f50285b;
        j8.accept(i8);
        j9.accept(i8);
    }

    @Override // j$.util.function.J
    public final J m(J j8) {
        j8.getClass();
        return new G(this, j8);
    }
}
