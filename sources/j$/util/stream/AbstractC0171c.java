package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0171c extends AbstractC0254w0 implements InterfaceC0198i {

    /* renamed from: h  reason: collision with root package name */
    private final AbstractC0171c f50546h;

    /* renamed from: i  reason: collision with root package name */
    private final AbstractC0171c f50547i;

    /* renamed from: j  reason: collision with root package name */
    protected final int f50548j;

    /* renamed from: k  reason: collision with root package name */
    private AbstractC0171c f50549k;

    /* renamed from: l  reason: collision with root package name */
    private int f50550l;

    /* renamed from: m  reason: collision with root package name */
    private int f50551m;

    /* renamed from: n  reason: collision with root package name */
    private Spliterator f50552n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f50553o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f50554p;

    /* renamed from: q  reason: collision with root package name */
    private Runnable f50555q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f50556r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0171c(Spliterator spliterator, int i8, boolean z7) {
        this.f50547i = null;
        this.f50552n = spliterator;
        this.f50546h = this;
        int i9 = U2.f50491g & i8;
        this.f50548j = i9;
        this.f50551m = (~(i9 << 1)) & U2.f50496l;
        this.f50550l = 0;
        this.f50556r = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0171c(AbstractC0171c abstractC0171c, int i8) {
        if (abstractC0171c.f50553o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        abstractC0171c.f50553o = true;
        abstractC0171c.f50549k = this;
        this.f50547i = abstractC0171c;
        this.f50548j = U2.f50492h & i8;
        this.f50551m = U2.d(i8, abstractC0171c.f50551m);
        AbstractC0171c abstractC0171c2 = abstractC0171c.f50546h;
        this.f50546h = abstractC0171c2;
        if (I1()) {
            abstractC0171c2.f50554p = true;
        }
        this.f50550l = abstractC0171c.f50550l + 1;
    }

    private Spliterator K1(int i8) {
        int i9;
        int i10;
        AbstractC0171c abstractC0171c = this.f50546h;
        Spliterator spliterator = abstractC0171c.f50552n;
        if (spliterator != null) {
            abstractC0171c.f50552n = null;
            if (abstractC0171c.f50556r && abstractC0171c.f50554p) {
                AbstractC0171c abstractC0171c2 = abstractC0171c.f50549k;
                int i11 = 1;
                while (abstractC0171c != this) {
                    int i12 = abstractC0171c2.f50548j;
                    if (abstractC0171c2.I1()) {
                        i11 = 0;
                        if (U2.SHORT_CIRCUIT.h(i12)) {
                            i12 &= ~U2.f50505u;
                        }
                        spliterator = abstractC0171c2.H1(abstractC0171c, spliterator);
                        if (spliterator.hasCharacteristics(64)) {
                            i9 = i12 & (~U2.f50504t);
                            i10 = U2.f50503s;
                        } else {
                            i9 = i12 & (~U2.f50503s);
                            i10 = U2.f50504t;
                        }
                        i12 = i9 | i10;
                    }
                    abstractC0171c2.f50550l = i11;
                    abstractC0171c2.f50551m = U2.d(i12, abstractC0171c.f50551m);
                    i11++;
                    AbstractC0171c abstractC0171c3 = abstractC0171c2;
                    abstractC0171c2 = abstractC0171c2.f50549k;
                    abstractC0171c = abstractC0171c3;
                }
            }
            if (i8 != 0) {
                this.f50551m = U2.d(i8, this.f50551m);
            }
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    abstract F0 A1(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7, IntFunction intFunction);

    abstract void B1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int C1();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int D1() {
        AbstractC0171c abstractC0171c = this;
        while (abstractC0171c.f50550l > 0) {
            abstractC0171c = abstractC0171c.f50547i;
        }
        return abstractC0171c.C1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean E1() {
        return U2.ORDERED.h(this.f50551m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Spliterator F1() {
        return K1(0);
    }

    F0 G1(Spliterator spliterator, IntFunction intFunction, AbstractC0171c abstractC0171c) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    Spliterator H1(AbstractC0171c abstractC0171c, Spliterator spliterator) {
        return G1(spliterator, new C0166b(0), abstractC0171c).spliterator();
    }

    abstract boolean I1();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Spliterator L1() {
        AbstractC0171c abstractC0171c = this.f50546h;
        if (this == abstractC0171c) {
            if (this.f50553o) {
                throw new IllegalStateException("stream has already been operated upon or closed");
            }
            this.f50553o = true;
            Spliterator spliterator = abstractC0171c.f50552n;
            if (spliterator != null) {
                abstractC0171c.f50552n = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException();
    }

    abstract Spliterator M1(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Spliterator N1(Spliterator spliterator) {
        return this.f50550l == 0 ? spliterator : M1(this, new C0161a(0, spliterator), this.f50546h.f50556r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final void U0(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        if (U2.SHORT_CIRCUIT.h(this.f50551m)) {
            V0(spliterator, interfaceC0193g2);
            return;
        }
        interfaceC0193g2.e(spliterator.getExactSizeIfKnown());
        spliterator.forEachRemaining(interfaceC0193g2);
        interfaceC0193g2.end();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final void V0(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        AbstractC0171c abstractC0171c = this;
        while (abstractC0171c.f50550l > 0) {
            abstractC0171c = abstractC0171c.f50547i;
        }
        interfaceC0193g2.e(spliterator.getExactSizeIfKnown());
        abstractC0171c.B1(spliterator, interfaceC0193g2);
        interfaceC0193g2.end();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final long Z0(Spliterator spliterator) {
        if (U2.SIZED.h(this.f50551m)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // j$.util.stream.InterfaceC0198i, java.lang.AutoCloseable
    public final void close() {
        this.f50553o = true;
        this.f50552n = null;
        AbstractC0171c abstractC0171c = this.f50546h;
        Runnable runnable = abstractC0171c.f50555q;
        if (runnable != null) {
            abstractC0171c.f50555q = null;
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final int f1() {
        return this.f50551m;
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final boolean isParallel() {
        return this.f50546h.f50556r;
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final InterfaceC0198i onClose(Runnable runnable) {
        AbstractC0171c abstractC0171c = this.f50546h;
        Runnable runnable2 = abstractC0171c.f50555q;
        if (runnable2 != null) {
            runnable = new A3(runnable2, runnable);
        }
        abstractC0171c.f50555q = runnable;
        return this;
    }

    public final InterfaceC0198i parallel() {
        this.f50546h.f50556r = true;
        return this;
    }

    public final InterfaceC0198i sequential() {
        this.f50546h.f50556r = false;
        return this;
    }

    public Spliterator spliterator() {
        if (this.f50553o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f50553o = true;
        AbstractC0171c abstractC0171c = this.f50546h;
        if (this == abstractC0171c) {
            Spliterator spliterator = abstractC0171c.f50552n;
            if (spliterator != null) {
                abstractC0171c.f50552n = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        return M1(this, new C0161a(1, this), abstractC0171c.f50556r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final InterfaceC0193g2 v1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        U0(spliterator, w1(interfaceC0193g2));
        return interfaceC0193g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final InterfaceC0193g2 w1(InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        for (AbstractC0171c abstractC0171c = this; abstractC0171c.f50550l > 0; abstractC0171c = abstractC0171c.f50547i) {
            interfaceC0193g2 = abstractC0171c.J1(abstractC0171c.f50547i.f50551m, interfaceC0193g2);
        }
        return interfaceC0193g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final F0 x1(Spliterator spliterator, boolean z7, IntFunction intFunction) {
        if (this.f50546h.f50556r) {
            return A1(this, spliterator, z7, intFunction);
        }
        A0 q12 = q1(Z0(spliterator), intFunction);
        v1(spliterator, q12);
        return q12.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object y1(B3 b32) {
        if (this.f50553o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f50553o = true;
        return this.f50546h.f50556r ? b32.y(this, K1(b32.O())) : b32.m0(this, K1(b32.O()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final F0 z1(IntFunction intFunction) {
        if (this.f50553o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f50553o = true;
        if (this.f50546h.f50556r && this.f50547i != null && I1()) {
            this.f50550l = 0;
            AbstractC0171c abstractC0171c = this.f50547i;
            return G1(abstractC0171c.K1(0), intFunction, abstractC0171c);
        }
        return x1(K1(0), true, intFunction);
    }
}
