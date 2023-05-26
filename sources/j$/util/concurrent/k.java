package j$.util.concurrent;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class k extends q implements Spliterator {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f50217i;

    /* renamed from: j  reason: collision with root package name */
    long f50218j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(m[] mVarArr, int i8, int i9, int i10, long j8, int i11) {
        super(mVarArr, i8, i9, i10);
        this.f50217i = i11;
        this.f50218j = j8;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        switch (this.f50217i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        switch (this.f50217i) {
            case 0:
                return this.f50218j;
            default:
                return this.f50218j;
        }
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        switch (this.f50217i) {
            case 0:
                consumer.getClass();
                while (true) {
                    m e8 = e();
                    if (e8 == null) {
                        return;
                    }
                    consumer.accept(e8.f50223b);
                }
            default:
                consumer.getClass();
                while (true) {
                    m e9 = e();
                    if (e9 == null) {
                        return;
                    }
                    consumer.accept(e9.f50224c);
                }
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        switch (this.f50217i) {
            case 0:
                return Spliterator.CC.$default$getComparator(this);
            default:
                return Spliterator.CC.$default$getComparator(this);
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.f50217i) {
            case 0:
                return Spliterator.CC.a(this);
            default:
                return Spliterator.CC.a(this);
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        switch (this.f50217i) {
            case 0:
                return Spliterator.CC.$default$hasCharacteristics(this, i8);
            default:
                return Spliterator.CC.$default$hasCharacteristics(this, i8);
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        switch (this.f50217i) {
            case 0:
                consumer.getClass();
                m e8 = e();
                if (e8 == null) {
                    return false;
                }
                consumer.accept(e8.f50223b);
                return true;
            default:
                consumer.getClass();
                m e9 = e();
                if (e9 == null) {
                    return false;
                }
                consumer.accept(e9.f50224c);
                return true;
        }
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        switch (this.f50217i) {
            case 0:
                int i8 = this.f50235f;
                int i9 = this.f50236g;
                int i10 = (i8 + i9) >>> 1;
                if (i10 <= i8) {
                    return null;
                }
                m[] mVarArr = this.f50230a;
                int i11 = this.f50237h;
                this.f50236g = i10;
                long j8 = this.f50218j >>> 1;
                this.f50218j = j8;
                return new k(mVarArr, i11, i10, i9, j8, 0);
            default:
                int i12 = this.f50235f;
                int i13 = this.f50236g;
                int i14 = (i12 + i13) >>> 1;
                if (i14 <= i12) {
                    return null;
                }
                m[] mVarArr2 = this.f50230a;
                int i15 = this.f50237h;
                this.f50236g = i14;
                long j9 = this.f50218j >>> 1;
                this.f50218j = j9;
                return new k(mVarArr2, i15, i14, i13, j9, 1);
        }
    }
}
