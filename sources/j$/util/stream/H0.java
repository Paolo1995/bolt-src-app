package j$.util.stream;

/* loaded from: classes2.dex */
abstract class H0 implements F0 {

    /* renamed from: a  reason: collision with root package name */
    protected final F0 f50408a;

    /* renamed from: b  reason: collision with root package name */
    protected final F0 f50409b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50410c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H0(F0 f02, F0 f03) {
        this.f50408a = f02;
        this.f50409b = f03;
        this.f50410c = f02.count() + f03.count();
    }

    @Override // j$.util.stream.F0
    public /* bridge */ /* synthetic */ E0 a(int i8) {
        return (E0) a(i8);
    }

    @Override // j$.util.stream.F0
    public final F0 a(int i8) {
        if (i8 == 0) {
            return this.f50408a;
        }
        if (i8 == 1) {
            return this.f50409b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return this.f50410c;
    }

    @Override // j$.util.stream.F0
    public final int n() {
        return 2;
    }
}
