package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
final class U extends CountedCompleter {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f50480h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0254w0 f50481a;

    /* renamed from: b  reason: collision with root package name */
    private Spliterator f50482b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50483c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap f50484d;

    /* renamed from: e  reason: collision with root package name */
    private final InterfaceC0193g2 f50485e;

    /* renamed from: f  reason: collision with root package name */
    private final U f50486f;

    /* renamed from: g  reason: collision with root package name */
    private F0 f50487g;

    U(U u7, Spliterator spliterator, U u8) {
        super(u7);
        this.f50481a = u7.f50481a;
        this.f50482b = spliterator;
        this.f50483c = u7.f50483c;
        this.f50484d = u7.f50484d;
        this.f50485e = u7.f50485e;
        this.f50486f = u8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public U(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        super(null);
        this.f50481a = abstractC0254w0;
        this.f50482b = spliterator;
        this.f50483c = AbstractC0186f.f(spliterator.estimateSize());
        this.f50484d = new ConcurrentHashMap(Math.max(16, AbstractC0186f.f50571g << 1));
        this.f50485e = interfaceC0193g2;
        this.f50486f = null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f50482b;
        long j8 = this.f50483c;
        boolean z7 = false;
        U u7 = this;
        while (spliterator.estimateSize() > j8 && (trySplit = spliterator.trySplit()) != null) {
            U u8 = new U(u7, trySplit, u7.f50486f);
            U u9 = new U(u7, spliterator, u8);
            u7.addToPendingCount(1);
            u9.addToPendingCount(1);
            u7.f50484d.put(u8, u9);
            if (u7.f50486f != null) {
                u8.addToPendingCount(1);
                if (u7.f50484d.replace(u7.f50486f, u7, u8)) {
                    u7.addToPendingCount(-1);
                } else {
                    u8.addToPendingCount(-1);
                }
            }
            if (z7) {
                spliterator = trySplit;
                u7 = u8;
                u8 = u9;
            } else {
                u7 = u9;
            }
            z7 = !z7;
            u8.fork();
        }
        if (u7.getPendingCount() > 0) {
            C0166b c0166b = new C0166b(14);
            AbstractC0254w0 abstractC0254w0 = u7.f50481a;
            A0 q12 = abstractC0254w0.q1(abstractC0254w0.Z0(spliterator), c0166b);
            u7.f50481a.v1(spliterator, q12);
            u7.f50487g = q12.build();
            u7.f50482b = null;
        }
        u7.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        F0 f02 = this.f50487g;
        if (f02 != null) {
            f02.forEach(this.f50485e);
            this.f50487g = null;
        } else {
            Spliterator spliterator = this.f50482b;
            if (spliterator != null) {
                this.f50481a.v1(spliterator, this.f50485e);
                this.f50482b = null;
            }
        }
        U u7 = (U) this.f50484d.remove(this);
        if (u7 != null) {
            u7.tryComplete();
        }
    }
}
