package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class V2 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    final boolean f50516a;

    /* renamed from: b  reason: collision with root package name */
    final AbstractC0254w0 f50517b;

    /* renamed from: c  reason: collision with root package name */
    private Supplier f50518c;

    /* renamed from: d  reason: collision with root package name */
    Spliterator f50519d;

    /* renamed from: e  reason: collision with root package name */
    InterfaceC0193g2 f50520e;

    /* renamed from: f  reason: collision with root package name */
    C0161a f50521f;

    /* renamed from: g  reason: collision with root package name */
    long f50522g;

    /* renamed from: h  reason: collision with root package name */
    AbstractC0181e f50523h;

    /* renamed from: i  reason: collision with root package name */
    boolean f50524i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V2(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        this.f50517b = abstractC0254w0;
        this.f50518c = null;
        this.f50519d = spliterator;
        this.f50516a = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V2(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        this.f50517b = abstractC0254w0;
        this.f50518c = c0161a;
        this.f50519d = null;
        this.f50516a = z7;
    }

    private boolean f() {
        while (this.f50523h.count() == 0) {
            if (this.f50520e.g() || !this.f50521f.getAsBoolean()) {
                if (this.f50524i) {
                    return false;
                }
                this.f50520e.end();
                this.f50524i = true;
            }
        }
        return true;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        g();
        int k8 = U2.k(this.f50517b.f1()) & U2.f50490f;
        return (k8 & 64) != 0 ? (k8 & (-16449)) | (this.f50519d.characteristics() & 16448) : k8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        AbstractC0181e abstractC0181e = this.f50523h;
        if (abstractC0181e == null) {
            if (this.f50524i) {
                return false;
            }
            g();
            h();
            this.f50522g = 0L;
            this.f50520e.e(this.f50519d.getExactSizeIfKnown());
            return f();
        }
        long j8 = this.f50522g + 1;
        this.f50522g = j8;
        boolean z7 = j8 < abstractC0181e.count();
        if (z7) {
            return z7;
        }
        this.f50522g = 0L;
        this.f50523h.clear();
        return f();
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        g();
        return this.f50519d.estimateSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        if (this.f50519d == null) {
            this.f50519d = (Spliterator) this.f50518c.get();
            this.f50518c = null;
        }
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (Spliterator.CC.$default$hasCharacteristics(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        g();
        if (U2.SIZED.h(this.f50517b.f1())) {
            return this.f50519d.getExactSizeIfKnown();
        }
        return -1L;
    }

    abstract void h();

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return Spliterator.CC.$default$hasCharacteristics(this, i8);
    }

    abstract V2 j(Spliterator spliterator);

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.f50519d);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        if (!this.f50516a || this.f50524i) {
            return null;
        }
        g();
        Spliterator trySplit = this.f50519d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return j(trySplit);
    }
}
