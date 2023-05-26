package j$.util;

import j$.util.function.Consumer;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class O implements java.util.Iterator, Consumer {

    /* renamed from: a  reason: collision with root package name */
    boolean f50150a = false;

    /* renamed from: b  reason: collision with root package name */
    Object f50151b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Spliterator f50152c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(Spliterator spliterator) {
        this.f50152c = spliterator;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f50150a = true;
        this.f50151b = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f50150a) {
            this.f50152c.tryAdvance(this);
        }
        return this.f50150a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f50150a || hasNext()) {
            this.f50150a = false;
            return this.f50151b;
        }
        throw new NoSuchElementException();
    }
}
