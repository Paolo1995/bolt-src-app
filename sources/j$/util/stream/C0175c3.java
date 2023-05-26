package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: j$.util.stream.c3  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0175c3 implements Spliterator, Consumer {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f50558d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Spliterator f50559a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f50560b;

    /* renamed from: c  reason: collision with root package name */
    private Object f50561c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0175c3(Spliterator spliterator) {
        this(spliterator, new ConcurrentHashMap());
    }

    private C0175c3(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f50559a = spliterator;
        this.f50560b = concurrentHashMap;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f50561c = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return (this.f50559a.characteristics() & (-16469)) | 1;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50559a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        this.f50559a.forEachRemaining(new C0222o(6, this, consumer));
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f50559a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return Spliterator.CC.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(Consumer consumer, Object obj) {
        if (this.f50560b.putIfAbsent(obj != null ? obj : f50558d, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return Spliterator.CC.$default$hasCharacteristics(this, i8);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        while (this.f50559a.tryAdvance(this)) {
            ConcurrentHashMap concurrentHashMap = this.f50560b;
            Object obj = this.f50561c;
            if (obj == null) {
                obj = f50558d;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.f50561c);
                this.f50561c = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator trySplit = this.f50559a.trySplit();
        if (trySplit != null) {
            return new C0175c3(trySplit, this.f50560b);
        }
        return null;
    }
}
