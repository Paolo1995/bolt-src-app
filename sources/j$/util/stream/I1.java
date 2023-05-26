package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class I1 extends AbstractC0254w0 {

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ j$.util.function.F f50422h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ int f50423i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I1(int i8, j$.util.function.F f8, int i9) {
        super(i8);
        this.f50422h = f8;
        this.f50423i = i9;
    }

    @Override // j$.util.stream.AbstractC0254w0
    public final P1 t1() {
        return new J1(this.f50423i, this.f50422h);
    }
}
