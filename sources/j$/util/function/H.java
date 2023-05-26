package j$.util.function;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class H implements J {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntConsumer f50287a;

    private /* synthetic */ H(IntConsumer intConsumer) {
        this.f50287a = intConsumer;
    }

    public static /* synthetic */ J a(IntConsumer intConsumer) {
        if (intConsumer == null) {
            return null;
        }
        return intConsumer instanceof I ? ((I) intConsumer).f50289a : new H(intConsumer);
    }

    @Override // j$.util.function.J
    public final /* synthetic */ void accept(int i8) {
        this.f50287a.accept(i8);
    }

    @Override // j$.util.function.J
    public final /* synthetic */ J m(J j8) {
        return a(this.f50287a.andThen(I.a(j8)));
    }
}
