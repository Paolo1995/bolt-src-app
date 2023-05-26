package j$.util.function;

import j$.util.function.Consumer;

/* renamed from: j$.util.function.e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0122e implements java.util.function.Consumer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Consumer f50317a;

    private /* synthetic */ C0122e(Consumer consumer) {
        this.f50317a = consumer;
    }

    public static /* synthetic */ java.util.function.Consumer a(Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof Consumer.VivifiedWrapper ? ((Consumer.VivifiedWrapper) consumer).f50275a : new C0122e(consumer);
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        this.f50317a.accept(obj);
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
        return a(this.f50317a.andThen(Consumer.VivifiedWrapper.convert(consumer)));
    }
}
