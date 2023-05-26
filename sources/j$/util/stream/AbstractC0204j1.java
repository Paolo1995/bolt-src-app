package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;

/* renamed from: j$.util.stream.j1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0204j1 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    F0 f50594a;

    /* renamed from: b  reason: collision with root package name */
    int f50595b;

    /* renamed from: c  reason: collision with root package name */
    Spliterator f50596c;

    /* renamed from: d  reason: collision with root package name */
    Spliterator f50597d;

    /* renamed from: e  reason: collision with root package name */
    ArrayDeque f50598e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0204j1(F0 f02) {
        this.f50594a = f02;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static F0 e(ArrayDeque arrayDeque) {
        while (true) {
            F0 f02 = (F0) arrayDeque.pollFirst();
            if (f02 == null) {
                return null;
            }
            if (f02.n() != 0) {
                int n8 = f02.n();
                while (true) {
                    n8--;
                    if (n8 >= 0) {
                        arrayDeque.addFirst(f02.a(n8));
                    }
                }
            } else if (f02.count() > 0) {
                return f02;
            }
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 64;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        long j8 = 0;
        if (this.f50594a == null) {
            return 0L;
        }
        Spliterator spliterator = this.f50596c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i8 = this.f50595b; i8 < this.f50594a.n(); i8++) {
            j8 += this.f50594a.a(i8).count();
        }
        return j8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayDeque f() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int n8 = this.f50594a.n();
        while (true) {
            n8--;
            if (n8 < this.f50595b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f50594a.a(n8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g() {
        if (this.f50594a == null) {
            return false;
        }
        if (this.f50597d == null) {
            Spliterator spliterator = this.f50596c;
            if (spliterator == null) {
                ArrayDeque f8 = f();
                this.f50598e = f8;
                F0 e8 = e(f8);
                if (e8 == null) {
                    this.f50594a = null;
                    return false;
                }
                spliterator = e8.spliterator();
            }
            this.f50597d = spliterator;
            return true;
        }
        return true;
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
    public /* bridge */ /* synthetic */ j$.util.D trySplit() {
        return (j$.util.D) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.G trySplit() {
        return (j$.util.G) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.J trySplit() {
        return (j$.util.J) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.M trySplit() {
        return (j$.util.M) trySplit();
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        F0 f02 = this.f50594a;
        if (f02 == null || this.f50597d != null) {
            return null;
        }
        Spliterator spliterator = this.f50596c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        if (this.f50595b < f02.n() - 1) {
            F0 f03 = this.f50594a;
            int i8 = this.f50595b;
            this.f50595b = i8 + 1;
            return f03.a(i8).spliterator();
        }
        F0 a8 = this.f50594a.a(this.f50595b);
        this.f50594a = a8;
        if (a8.n() == 0) {
            Spliterator spliterator2 = this.f50594a.spliterator();
            this.f50596c = spliterator2;
            return spliterator2.trySplit();
        }
        F0 f04 = this.f50594a;
        this.f50595b = 0 + 1;
        return f04.a(0).spliterator();
    }
}
