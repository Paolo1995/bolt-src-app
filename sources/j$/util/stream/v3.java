package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class v3 extends x3 implements j$.util.M {
    /* JADX INFO: Access modifiers changed from: package-private */
    public v3(j$.util.M m8, long j8, long j9) {
        super(m8, j8, j9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v3(j$.util.M m8, v3 v3Var) {
        super(m8, v3Var);
    }

    @Override // j$.util.M
    /* renamed from: forEachRemaining */
    public final void c(Object obj) {
        obj.getClass();
        Z2 z22 = null;
        while (true) {
            int r7 = r();
            if (r7 == 1) {
                return;
            }
            if (r7 != 2) {
                ((j$.util.M) this.f50717a).forEachRemaining(obj);
                return;
            }
            if (z22 == null) {
                z22 = t();
            } else {
                z22.f50536b = 0;
            }
            long j8 = 0;
            while (((j$.util.M) this.f50717a).tryAdvance(z22)) {
                j8++;
                if (j8 >= 128) {
                    break;
                }
            }
            if (j8 == 0) {
                return;
            }
            z22.a(obj, p(j8));
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

    protected abstract void s(Object obj);

    protected abstract Z2 t();

    @Override // j$.util.M
    /* renamed from: tryAdvance */
    public final boolean n(Object obj) {
        obj.getClass();
        while (r() != 1 && ((j$.util.M) this.f50717a).tryAdvance(this)) {
            if (p(1L) == 1) {
                s(obj);
                return true;
            }
        }
        return false;
    }
}
