package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes5.dex */
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private int f51116f;

    /* renamed from: g  reason: collision with root package name */
    private T f51117g;

    /* renamed from: h  reason: collision with root package name */
    private Iterator<? extends T> f51118h;

    /* renamed from: i  reason: collision with root package name */
    private Continuation<? super Unit> f51119i;

    private final Throwable d() {
        int i8 = this.f51116f;
        if (i8 != 4) {
            if (i8 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f51116f);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.SequenceScope
    public Object b(T t7, Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        Object d10;
        this.f51117g = t7;
        this.f51116f = 3;
        this.f51119i = continuation;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (d8 == d9) {
            DebugProbesKt.c(continuation);
        }
        d10 = IntrinsicsKt__IntrinsicsKt.d();
        if (d8 == d10) {
            return d8;
        }
        return Unit.f50853a;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final void g(Continuation<? super Unit> continuation) {
        this.f51119i = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f50912f;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i8 = this.f51116f;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 == 2 || i8 == 3) {
                        return true;
                    }
                    if (i8 == 4) {
                        return false;
                    }
                    throw d();
                }
                java.util.Iterator<? extends T> it = this.f51118h;
                Intrinsics.c(it);
                if (it.hasNext()) {
                    this.f51116f = 2;
                    return true;
                }
                this.f51118h = null;
            }
            this.f51116f = 5;
            Continuation<? super Unit> continuation = this.f51119i;
            Intrinsics.c(continuation);
            this.f51119i = null;
            Result.Companion companion = Result.f50818g;
            continuation.resumeWith(Result.b(Unit.f50853a));
        }
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        int i8 = this.f51116f;
        if (i8 != 0 && i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    this.f51116f = 0;
                    T t7 = this.f51117g;
                    this.f51117g = null;
                    return t7;
                }
                throw d();
            }
            this.f51116f = 1;
            java.util.Iterator<? extends T> it = this.f51118h;
            Intrinsics.c(it);
            return it.next();
        }
        return e();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        ResultKt.b(obj);
        this.f51116f = 4;
    }
}
