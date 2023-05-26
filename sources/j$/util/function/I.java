package j$.util.function;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class I implements IntConsumer {

    /* renamed from: a */
    final /* synthetic */ J f50289a;

    private /* synthetic */ I(J j8) {
        this.f50289a = j8;
    }

    public static /* synthetic */ IntConsumer a(J j8) {
        if (j8 == null) {
            return null;
        }
        return j8 instanceof H ? ((H) j8).f50287a : new I(j8);
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ void accept(int i8) {
        this.f50289a.accept(i8);
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a(this.f50289a.m(H.a(intConsumer)));
    }
}
