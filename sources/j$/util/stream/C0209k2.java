package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.k2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0209k2 extends AbstractC0172c0 {

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ int f50607v = 0;

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f50608t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f50609u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0209k2(AbstractC0171c abstractC0171c, int i8, long j8, long j9) {
        super(abstractC0171c, i8);
        this.f50608t = j8;
        this.f50609u = j9;
    }

    static j$.util.G Q1(j$.util.G g8, long j8, long j9, long j10) {
        long j11;
        long j12;
        if (j8 <= j10) {
            long j13 = j10 - j8;
            j12 = j9 >= 0 ? Math.min(j9, j13) : j13;
            j11 = 0;
        } else {
            j11 = j8;
            j12 = j9;
        }
        return new t3(g8, j11, j12);
    }

    @Override // j$.util.stream.AbstractC0171c
    final F0 G1(Spliterator spliterator, IntFunction intFunction, AbstractC0171c abstractC0171c) {
        long Z0 = abstractC0171c.Z0(spliterator);
        return (Z0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !U2.ORDERED.h(abstractC0171c.f1()) ? AbstractC0254w0.R0(this, Q1((j$.util.G) abstractC0171c.N1(spliterator), this.f50608t, this.f50609u, Z0), true) : (F0) new C0233q2(this, abstractC0171c, spliterator, intFunction, this.f50608t, this.f50609u).invoke() : AbstractC0254w0.R0(abstractC0171c, AbstractC0254w0.J0(abstractC0171c.D1(), spliterator, this.f50608t, this.f50609u), true);
    }

    @Override // j$.util.stream.AbstractC0171c
    final Spliterator H1(AbstractC0171c abstractC0171c, Spliterator spliterator) {
        long Z0 = abstractC0171c.Z0(spliterator);
        if (Z0 <= 0 || !spliterator.hasCharacteristics(16384)) {
            return !U2.ORDERED.h(abstractC0171c.f1()) ? Q1((j$.util.G) abstractC0171c.N1(spliterator), this.f50608t, this.f50609u, Z0) : ((F0) new C0233q2(this, abstractC0171c, spliterator, new L0(7), this.f50608t, this.f50609u).invoke()).spliterator();
        }
        long j8 = this.f50608t;
        return new m3((j$.util.G) abstractC0171c.N1(spliterator), j8, AbstractC0254w0.I0(j8, this.f50609u));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        return new C0205j2(this, interfaceC0193g2);
    }
}
