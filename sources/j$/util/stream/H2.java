package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class H2 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    int f50414a;

    /* renamed from: b  reason: collision with root package name */
    final int f50415b;

    /* renamed from: c  reason: collision with root package name */
    int f50416c;

    /* renamed from: d  reason: collision with root package name */
    final int f50417d;

    /* renamed from: e  reason: collision with root package name */
    Object[] f50418e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Q2 f50419f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H2(Q2 q22, int i8, int i9, int i10, int i11) {
        this.f50419f = q22;
        this.f50414a = i8;
        this.f50415b = i9;
        this.f50416c = i10;
        this.f50417d = i11;
        Object[][] objArr = q22.f50468f;
        this.f50418e = objArr == null ? q22.f50467e : objArr[i8];
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        int i8 = this.f50414a;
        int i9 = this.f50415b;
        if (i8 == i9) {
            return this.f50417d - this.f50416c;
        }
        long[] jArr = this.f50419f.f50569d;
        return ((jArr[i9] + this.f50417d) - jArr[i8]) - this.f50416c;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i8;
        consumer.getClass();
        int i9 = this.f50414a;
        int i10 = this.f50415b;
        if (i9 < i10 || (i9 == i10 && this.f50416c < this.f50417d)) {
            int i11 = this.f50416c;
            while (true) {
                i8 = this.f50415b;
                if (i9 >= i8) {
                    break;
                }
                Object[] objArr = this.f50419f.f50468f[i9];
                while (i11 < objArr.length) {
                    consumer.accept(objArr[i11]);
                    i11++;
                }
                i11 = 0;
                i9++;
            }
            Object[] objArr2 = this.f50414a == i8 ? this.f50418e : this.f50419f.f50468f[i8];
            int i12 = this.f50417d;
            while (i11 < i12) {
                consumer.accept(objArr2[i11]);
                i11++;
            }
            this.f50414a = this.f50415b;
            this.f50416c = this.f50417d;
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return Spliterator.CC.$default$getComparator(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return Spliterator.CC.a(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return Spliterator.CC.$default$hasCharacteristics(this, i8);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i8 = this.f50414a;
        int i9 = this.f50415b;
        if (i8 < i9 || (i8 == i9 && this.f50416c < this.f50417d)) {
            Object[] objArr = this.f50418e;
            int i10 = this.f50416c;
            this.f50416c = i10 + 1;
            consumer.accept(objArr[i10]);
            if (this.f50416c == this.f50418e.length) {
                this.f50416c = 0;
                int i11 = this.f50414a + 1;
                this.f50414a = i11;
                Object[][] objArr2 = this.f50419f.f50468f;
                if (objArr2 != null && i11 <= this.f50415b) {
                    this.f50418e = objArr2[i11];
                }
            }
            return true;
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i8 = this.f50414a;
        int i9 = this.f50415b;
        if (i8 < i9) {
            Q2 q22 = this.f50419f;
            int i10 = i9 - 1;
            H2 h22 = new H2(q22, i8, i10, this.f50416c, q22.f50468f[i10].length);
            int i11 = this.f50415b;
            this.f50414a = i11;
            this.f50416c = 0;
            this.f50418e = this.f50419f.f50468f[i11];
            return h22;
        } else if (i8 == i9) {
            int i12 = this.f50417d;
            int i13 = this.f50416c;
            int i14 = (i12 - i13) / 2;
            if (i14 == 0) {
                return null;
            }
            Spliterator spliterator = Spliterators.spliterator(this.f50418e, i13, i13 + i14, 1040);
            this.f50416c += i14;
            return spliterator;
        } else {
            return null;
        }
    }
}
