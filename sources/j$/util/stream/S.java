package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class S extends T {

    /* renamed from: b  reason: collision with root package name */
    final Consumer f50471b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(Consumer consumer, boolean z7) {
        super(z7);
        this.f50471b = consumer;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f50471b.accept(obj);
    }
}
