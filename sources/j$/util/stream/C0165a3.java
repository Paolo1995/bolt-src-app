package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.a3  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0165a3 extends AbstractC0170b3 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    final Object[] f50540b = new Object[128];

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.f50540b;
        int i8 = this.f50545a;
        this.f50545a = i8 + 1;
        objArr[i8] = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
