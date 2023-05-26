package j$.util;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class r implements j$.util.function.J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f50363a;

    public /* synthetic */ r(Consumer consumer) {
        this.f50363a = consumer;
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        this.f50363a.accept(Integer.valueOf(i8));
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
