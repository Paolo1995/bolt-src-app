package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* renamed from: j$.util.stream.q2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0233q2 extends AbstractC0176d {

    /* renamed from: j  reason: collision with root package name */
    private final AbstractC0171c f50647j;

    /* renamed from: k  reason: collision with root package name */
    private final IntFunction f50648k;

    /* renamed from: l  reason: collision with root package name */
    private final long f50649l;

    /* renamed from: m  reason: collision with root package name */
    private final long f50650m;

    /* renamed from: n  reason: collision with root package name */
    private long f50651n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f50652o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0233q2(AbstractC0171c abstractC0171c, AbstractC0171c abstractC0171c2, Spliterator spliterator, IntFunction intFunction, long j8, long j9) {
        super(abstractC0171c2, spliterator);
        this.f50647j = abstractC0171c;
        this.f50648k = intFunction;
        this.f50649l = j8;
        this.f50650m = j9;
    }

    C0233q2(C0233q2 c0233q2, Spliterator spliterator) {
        super(c0233q2, spliterator);
        this.f50647j = c0233q2.f50647j;
        this.f50648k = c0233q2.f50648k;
        this.f50649l = c0233q2.f50649l;
        this.f50650m = c0233q2.f50650m;
    }

    private long j(long j8) {
        if (this.f50652o) {
            return this.f50651n;
        }
        C0233q2 c0233q2 = (C0233q2) this.f50575d;
        C0233q2 c0233q22 = (C0233q2) this.f50576e;
        if (c0233q2 == null || c0233q22 == null) {
            return this.f50651n;
        }
        long j9 = c0233q2.j(j8);
        return j9 >= j8 ? j9 : j9 + c0233q22.j(j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final Object a() {
        if (c() == null) {
            A0 q12 = this.f50647j.q1(U2.SIZED.i(this.f50647j.f50548j) ? this.f50647j.Z0(this.f50573b) : -1L, this.f50648k);
            InterfaceC0193g2 J1 = this.f50647j.J1(this.f50572a.f1(), q12);
            AbstractC0254w0 abstractC0254w0 = this.f50572a;
            abstractC0254w0.V0(this.f50573b, abstractC0254w0.w1(J1));
            return q12.build();
        }
        AbstractC0254w0 abstractC0254w02 = this.f50572a;
        A0 q13 = abstractC0254w02.q1(-1L, this.f50648k);
        abstractC0254w02.v1(this.f50573b, q13);
        F0 build = q13.build();
        this.f50651n = build.count();
        this.f50652o = true;
        this.f50573b = null;
        return build;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final AbstractC0186f d(Spliterator spliterator) {
        return new C0233q2(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0176d
    protected final void g() {
        this.f50563i = true;
        if (this.f50652o) {
            e(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0176d
    /* renamed from: k */
    public final Z0 i() {
        return AbstractC0254w0.Y0(this.f50647j.C1());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    @Override // j$.util.stream.AbstractC0186f, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0233q2.onCompletion(java.util.concurrent.CountedCompleter):void");
    }
}
