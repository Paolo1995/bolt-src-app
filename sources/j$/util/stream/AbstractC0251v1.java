package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.v1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0251v1 extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    protected final F0 f50693a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f50694b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0251v1(F0 f02) {
        this.f50693a = f02;
        this.f50694b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0251v1(AbstractC0251v1 abstractC0251v1, F0 f02, int i8) {
        super(abstractC0251v1);
        this.f50693a = f02;
        this.f50694b = i8;
    }

    abstract void a();

    abstract C0247u1 b(int i8, int i9);

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        AbstractC0251v1 abstractC0251v1 = this;
        while (abstractC0251v1.f50693a.n() != 0) {
            abstractC0251v1.setPendingCount(abstractC0251v1.f50693a.n() - 1);
            int i8 = 0;
            int i9 = 0;
            while (i8 < abstractC0251v1.f50693a.n() - 1) {
                C0247u1 b8 = abstractC0251v1.b(i8, abstractC0251v1.f50694b + i9);
                i9 = (int) (i9 + b8.f50693a.count());
                b8.fork();
                i8++;
            }
            abstractC0251v1 = abstractC0251v1.b(i8, abstractC0251v1.f50694b + i9);
        }
        abstractC0251v1.a();
        abstractC0251v1.propagateCompletion();
    }
}
