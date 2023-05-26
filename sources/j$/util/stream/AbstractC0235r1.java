package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.r1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0235r1 extends CountedCompleter implements InterfaceC0193g2 {

    /* renamed from: a  reason: collision with root package name */
    protected final Spliterator f50655a;

    /* renamed from: b  reason: collision with root package name */
    protected final AbstractC0254w0 f50656b;

    /* renamed from: c  reason: collision with root package name */
    protected final long f50657c;

    /* renamed from: d  reason: collision with root package name */
    protected long f50658d;

    /* renamed from: e  reason: collision with root package name */
    protected long f50659e;

    /* renamed from: f  reason: collision with root package name */
    protected int f50660f;

    /* renamed from: g  reason: collision with root package name */
    protected int f50661g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0235r1(int i8, Spliterator spliterator, AbstractC0254w0 abstractC0254w0) {
        this.f50655a = spliterator;
        this.f50656b = abstractC0254w0;
        this.f50657c = AbstractC0186f.f(spliterator.estimateSize());
        this.f50658d = 0L;
        this.f50659e = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0235r1(AbstractC0235r1 abstractC0235r1, Spliterator spliterator, long j8, long j9, int i8) {
        super(abstractC0235r1);
        this.f50655a = spliterator;
        this.f50656b = abstractC0235r1.f50656b;
        this.f50657c = abstractC0235r1.f50657c;
        this.f50658d = j8;
        this.f50659e = j9;
        if (j8 < 0 || j9 < 0 || (j8 + j9) - 1 >= i8) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j8), Long.valueOf(j8), Long.valueOf(j9), Integer.valueOf(i8)));
        }
    }

    abstract AbstractC0235r1 a(Spliterator spliterator, long j8, long j9);

    public /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    public /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    public /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f50655a;
        AbstractC0235r1 abstractC0235r1 = this;
        while (spliterator.estimateSize() > abstractC0235r1.f50657c && (trySplit = spliterator.trySplit()) != null) {
            abstractC0235r1.setPendingCount(1);
            long estimateSize = trySplit.estimateSize();
            abstractC0235r1.a(trySplit, abstractC0235r1.f50658d, estimateSize).fork();
            abstractC0235r1 = abstractC0235r1.a(spliterator, abstractC0235r1.f50658d + estimateSize, abstractC0235r1.f50659e - estimateSize);
        }
        abstractC0235r1.f50656b.v1(spliterator, abstractC0235r1);
        abstractC0235r1.propagateCompletion();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        long j9 = this.f50659e;
        if (j8 > j9) {
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }
        int i8 = (int) this.f50658d;
        this.f50660f = i8;
        this.f50661g = i8 + ((int) j9);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }
}
