package kotlin.jvm.internal;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes5.dex */
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> a(T[] array) {
        Intrinsics.f(array, "array");
        return new ArrayIterator(array);
    }
}
