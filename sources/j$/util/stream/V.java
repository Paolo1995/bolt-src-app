package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
final class V extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    private Spliterator f50512a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0193g2 f50513b;

    /* renamed from: c  reason: collision with root package name */
    private final AbstractC0254w0 f50514c;

    /* renamed from: d  reason: collision with root package name */
    private long f50515d;

    V(V v7, Spliterator spliterator) {
        super(v7);
        this.f50512a = spliterator;
        this.f50513b = v7.f50513b;
        this.f50515d = v7.f50515d;
        this.f50514c = v7.f50514c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        super(null);
        this.f50513b = interfaceC0193g2;
        this.f50514c = abstractC0254w0;
        this.f50512a = spliterator;
        this.f50515d = 0L;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f50512a;
        long estimateSize = spliterator.estimateSize();
        long j8 = this.f50515d;
        if (j8 == 0) {
            j8 = AbstractC0186f.f(estimateSize);
            this.f50515d = j8;
        }
        boolean h8 = U2.SHORT_CIRCUIT.h(this.f50514c.f1());
        boolean z7 = false;
        InterfaceC0193g2 interfaceC0193g2 = this.f50513b;
        V v7 = this;
        while (true) {
            if (h8 && interfaceC0193g2.g()) {
                break;
            } else if (estimateSize <= j8 || (trySplit = spliterator.trySplit()) == null) {
                break;
            } else {
                V v8 = new V(v7, trySplit);
                v7.addToPendingCount(1);
                if (z7) {
                    spliterator = trySplit;
                } else {
                    V v9 = v7;
                    v7 = v8;
                    v8 = v9;
                }
                z7 = !z7;
                v7.fork();
                v7 = v8;
                estimateSize = spliterator.estimateSize();
            }
        }
        v7.f50514c.U0(spliterator, interfaceC0193g2);
        v7.f50512a = null;
        v7.propagateCompletion();
    }
}
