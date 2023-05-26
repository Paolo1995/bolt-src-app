package kotlin;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ULongArray.kt */
/* loaded from: classes5.dex */
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    private final long[] f50844f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ULongArray.kt */
    /* loaded from: classes5.dex */
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final long[] f50845f;

        /* renamed from: g  reason: collision with root package name */
        private int f50846g;

        public Iterator(long[] array) {
            Intrinsics.f(array, "array");
            this.f50845f = array;
        }

        public long b() {
            int i8 = this.f50846g;
            long[] jArr = this.f50845f;
            if (i8 < jArr.length) {
                this.f50846g = i8 + 1;
                return ULong.c(jArr[i8]);
            }
            throw new NoSuchElementException(String.valueOf(this.f50846g));
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super ULong> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f50846g < this.f50845f.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return ULong.a(b());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.f50844f = jArr;
    }

    public static final /* synthetic */ ULongArray b(long[] jArr) {
        return new ULongArray(jArr);
    }

    public static long[] d(int i8) {
        return g(new long[i8]);
    }

    public static long[] g(long[] storage) {
        Intrinsics.f(storage, "storage");
        return storage;
    }

    public static boolean k(long[] jArr, long j8) {
        boolean y7;
        y7 = ArraysKt___ArraysKt.y(jArr, j8);
        return y7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(long[] r5, java.util.Collection<kotlin.ULong> r6) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            boolean r0 = r6.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
        Ld:
            r1 = 1
            goto L32
        Lf:
            java.util.Iterator r6 = r6.iterator()
        L13:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r6.next()
            boolean r3 = r0 instanceof kotlin.ULong
            if (r3 == 0) goto L2f
            kotlin.ULong r0 = (kotlin.ULong) r0
            long r3 = r0.j()
            boolean r0 = kotlin.collections.ArraysKt.y(r5, r3)
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 != 0) goto L13
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ULongArray.m(long[], java.util.Collection):boolean");
    }

    public static boolean n(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.a(jArr, ((ULongArray) obj).y());
    }

    public static final long o(long[] jArr, int i8) {
        return ULong.c(jArr[i8]);
    }

    public static int r(long[] jArr) {
        return jArr.length;
    }

    public static int s(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean u(long[] jArr) {
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    public static java.util.Iterator<ULong> v(long[] jArr) {
        return new Iterator(jArr);
    }

    public static final void w(long[] jArr, int i8, long j8) {
        jArr[i8] = j8;
    }

    public static String x(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        return i(((ULong) obj).j());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return m(this.f50844f, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f50844f, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f50844f);
    }

    public boolean i(long j8) {
        return k(this.f50844f, j8);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f50844f);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<ULong> iterator() {
        return v(this.f50844f);
    }

    @Override // java.util.Collection
    /* renamed from: p */
    public int size() {
        return r(this.f50844f);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.f(array, "array");
        return (T[]) CollectionToArray.b(this, array);
    }

    public String toString() {
        return x(this.f50844f);
    }

    public final /* synthetic */ long[] y() {
        return this.f50844f;
    }
}
