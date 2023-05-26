package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0186f extends CountedCompleter {

    /* renamed from: g  reason: collision with root package name */
    static final int f50571g = ForkJoinPool.getCommonPoolParallelism() << 2;

    /* renamed from: a  reason: collision with root package name */
    protected final AbstractC0254w0 f50572a;

    /* renamed from: b  reason: collision with root package name */
    protected Spliterator f50573b;

    /* renamed from: c  reason: collision with root package name */
    protected long f50574c;

    /* renamed from: d  reason: collision with root package name */
    protected AbstractC0186f f50575d;

    /* renamed from: e  reason: collision with root package name */
    protected AbstractC0186f f50576e;

    /* renamed from: f  reason: collision with root package name */
    private Object f50577f;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0186f(AbstractC0186f abstractC0186f, Spliterator spliterator) {
        super(abstractC0186f);
        this.f50573b = spliterator;
        this.f50572a = abstractC0186f.f50572a;
        this.f50574c = abstractC0186f.f50574c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0186f(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        super(null);
        this.f50572a = abstractC0254w0;
        this.f50573b = spliterator;
        this.f50574c = 0L;
    }

    public static long f(long j8) {
        long j9 = j8 / f50571g;
        if (j9 > 0) {
            return j9;
        }
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b() {
        return this.f50577f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AbstractC0186f c() {
        return (AbstractC0186f) getCompleter();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f50573b;
        long estimateSize = spliterator.estimateSize();
        long j8 = this.f50574c;
        if (j8 == 0) {
            j8 = f(estimateSize);
            this.f50574c = j8;
        }
        boolean z7 = false;
        AbstractC0186f abstractC0186f = this;
        while (estimateSize > j8 && (trySplit = spliterator.trySplit()) != null) {
            AbstractC0186f d8 = abstractC0186f.d(trySplit);
            abstractC0186f.f50575d = d8;
            AbstractC0186f d9 = abstractC0186f.d(spliterator);
            abstractC0186f.f50576e = d9;
            abstractC0186f.setPendingCount(1);
            if (z7) {
                spliterator = trySplit;
                abstractC0186f = d8;
                d8 = d9;
            } else {
                abstractC0186f = d9;
            }
            z7 = !z7;
            d8.fork();
            estimateSize = spliterator.estimateSize();
        }
        abstractC0186f.e(abstractC0186f.a());
        abstractC0186f.tryComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AbstractC0186f d(Spliterator spliterator);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Object obj) {
        this.f50577f = obj;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f50577f;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.f50573b = null;
        this.f50576e = null;
        this.f50575d = null;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    protected final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
