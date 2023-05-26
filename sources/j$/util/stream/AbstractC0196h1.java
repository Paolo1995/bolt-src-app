package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;

/* renamed from: j$.util.stream.h1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0196h1 extends AbstractC0204j1 implements j$.util.M {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0196h1(E0 e02) {
        super(e02);
    }

    @Override // j$.util.M
    /* renamed from: forEachRemaining */
    public final void c(Object obj) {
        if (this.f50594a == null) {
            return;
        }
        if (this.f50597d != null) {
            do {
            } while (n(obj));
            return;
        }
        Spliterator spliterator = this.f50596c;
        if (spliterator != null) {
            ((j$.util.M) spliterator).forEachRemaining(obj);
            return;
        }
        ArrayDeque f8 = f();
        while (true) {
            E0 e02 = (E0) AbstractC0204j1.e(f8);
            if (e02 == null) {
                this.f50594a = null;
                return;
            }
            e02.d(obj);
        }
    }

    @Override // j$.util.M
    /* renamed from: tryAdvance */
    public final boolean n(Object obj) {
        E0 e02;
        if (g()) {
            boolean tryAdvance = ((j$.util.M) this.f50597d).tryAdvance(obj);
            if (!tryAdvance) {
                if (this.f50596c == null && (e02 = (E0) AbstractC0204j1.e(this.f50598e)) != null) {
                    j$.util.M spliterator = e02.spliterator();
                    this.f50597d = spliterator;
                    return spliterator.tryAdvance(obj);
                }
                this.f50594a = null;
            }
            return tryAdvance;
        }
        return false;
    }
}
