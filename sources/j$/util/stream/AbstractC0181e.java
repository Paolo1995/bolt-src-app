package j$.util.stream;

/* renamed from: j$.util.stream.e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0181e {

    /* renamed from: a  reason: collision with root package name */
    protected final int f50566a;

    /* renamed from: b  reason: collision with root package name */
    protected int f50567b;

    /* renamed from: c  reason: collision with root package name */
    protected int f50568c;

    /* renamed from: d  reason: collision with root package name */
    protected long[] f50569d;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0181e() {
        this.f50566a = 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0181e(int i8) {
        if (i8 >= 0) {
            this.f50566a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i8 - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i8);
    }

    public abstract void clear();

    public final long count() {
        int i8 = this.f50568c;
        return i8 == 0 ? this.f50567b : this.f50569d[i8] + this.f50567b;
    }
}
