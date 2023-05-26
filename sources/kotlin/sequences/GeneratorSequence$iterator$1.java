package kotlin.sequences;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes5.dex */
public final class GeneratorSequence$iterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private T f51113f;

    /* renamed from: g  reason: collision with root package name */
    private int f51114g = -2;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ GeneratorSequence<T> f51115h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.f51115h = generatorSequence;
    }

    private final void b() {
        Function1 function1;
        T t7;
        int i8;
        Function0 function0;
        if (this.f51114g == -2) {
            function0 = ((GeneratorSequence) this.f51115h).f51111a;
            t7 = (T) function0.invoke();
        } else {
            function1 = ((GeneratorSequence) this.f51115h).f51112b;
            T t8 = this.f51113f;
            Intrinsics.c(t8);
            t7 = (T) function1.invoke(t8);
        }
        this.f51113f = t7;
        if (t7 == null) {
            i8 = 0;
        } else {
            i8 = 1;
        }
        this.f51114g = i8;
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
        if (this.f51114g < 0) {
            b();
        }
        if (this.f51114g == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        if (this.f51114g < 0) {
            b();
        }
        if (this.f51114g != 0) {
            T t7 = this.f51113f;
            Intrinsics.d(t7, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f51114g = -1;
            return t7;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
