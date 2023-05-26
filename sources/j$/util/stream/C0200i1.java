package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.ArrayDeque;

/* renamed from: j$.util.stream.i1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0200i1 extends AbstractC0204j1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0200i1(F0 f02) {
        super(f02);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.f50594a == null) {
            return;
        }
        if (this.f50597d != null) {
            do {
            } while (tryAdvance(consumer));
            return;
        }
        Spliterator spliterator = this.f50596c;
        if (spliterator != null) {
            spliterator.forEachRemaining(consumer);
            return;
        }
        ArrayDeque f8 = f();
        while (true) {
            F0 e8 = AbstractC0204j1.e(f8);
            if (e8 == null) {
                this.f50594a = null;
                return;
            }
            e8.forEach(consumer);
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        F0 e8;
        if (g()) {
            boolean tryAdvance = this.f50597d.tryAdvance(consumer);
            if (!tryAdvance) {
                if (this.f50596c == null && (e8 = AbstractC0204j1.e(this.f50598e)) != null) {
                    Spliterator spliterator = e8.spliterator();
                    this.f50597d = spliterator;
                    return spliterator.tryAdvance(consumer);
                }
                this.f50594a = null;
            }
            return tryAdvance;
        }
        return false;
    }
}
