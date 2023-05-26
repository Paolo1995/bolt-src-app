package j$.util.stream;

/* loaded from: classes2.dex */
final class X2 extends Z2 implements j$.util.function.J {

    /* renamed from: c  reason: collision with root package name */
    final int[] f50529c = new int[128];

    @Override // j$.util.stream.Z2
    public final void a(Object obj, long j8) {
        j$.util.function.J j9 = (j$.util.function.J) obj;
        for (int i8 = 0; i8 < j8; i8++) {
            j9.accept(this.f50529c[i8]);
        }
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        int[] iArr = this.f50529c;
        int i9 = this.f50536b;
        this.f50536b = i9 + 1;
        iArr[i9] = i8;
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
