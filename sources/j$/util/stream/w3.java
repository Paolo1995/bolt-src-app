package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class w3 extends x3 implements Spliterator, Consumer {

    /* renamed from: e  reason: collision with root package name */
    Object f50710e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w3(Spliterator spliterator, long j8, long j9) {
        super(spliterator, j8, j9);
    }

    w3(Spliterator spliterator, w3 w3Var) {
        super(spliterator, w3Var);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f50710e = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        C0165a3 c0165a3 = null;
        while (true) {
            int r7 = r();
            if (r7 == 1) {
                return;
            }
            if (r7 != 2) {
                this.f50717a.forEachRemaining(consumer);
                return;
            }
            if (c0165a3 == null) {
                c0165a3 = new C0165a3();
            } else {
                c0165a3.f50545a = 0;
            }
            long j8 = 0;
            while (this.f50717a.tryAdvance(c0165a3)) {
                j8++;
                if (j8 >= 128) {
                    break;
                }
            }
            if (j8 == 0) {
                return;
            }
            long p8 = p(j8);
            for (int i8 = 0; i8 < p8; i8++) {
                consumer.accept(c0165a3.f50540b[i8]);
            }
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

    @Override // j$.util.stream.x3
    protected final Spliterator q(Spliterator spliterator) {
        return new w3(spliterator, this);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        while (r() != 1 && this.f50717a.tryAdvance(this)) {
            if (p(1L) == 1) {
                consumer.accept(this.f50710e);
                this.f50710e = null;
                return true;
            }
        }
        return false;
    }
}
