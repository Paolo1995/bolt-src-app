package kotlin.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: AbstractIterator.kt */
/* loaded from: classes5.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private State f50857f = State.NotReady;

    /* renamed from: g  reason: collision with root package name */
    private T f50858g;

    /* compiled from: AbstractIterator.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50859a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f50859a = iArr;
        }
    }

    private final boolean e() {
        this.f50857f = State.Failed;
        b();
        if (this.f50857f == State.Ready) {
            return true;
        }
        return false;
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.f50857f = State.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(T t7) {
        this.f50858g = t7;
        this.f50857f = State.Ready;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        boolean z7;
        State state = this.f50857f;
        if (state != State.Failed) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i8 = WhenMappings.f50859a[state.ordinal()];
            if (i8 == 1) {
                return false;
            }
            if (i8 != 2) {
                return e();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f50857f = State.NotReady;
            return this.f50858g;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
