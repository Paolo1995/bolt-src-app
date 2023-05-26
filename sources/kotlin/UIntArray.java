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

/* compiled from: UIntArray.kt */
/* loaded from: classes5.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    private final int[] f50839f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIntArray.kt */
    /* loaded from: classes5.dex */
    public static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final int[] f50840f;

        /* renamed from: g  reason: collision with root package name */
        private int f50841g;

        public Iterator(int[] array) {
            Intrinsics.f(array, "array");
            this.f50840f = array;
        }

        public int b() {
            int i8 = this.f50841g;
            int[] iArr = this.f50840f;
            if (i8 < iArr.length) {
                this.f50841g = i8 + 1;
                return UInt.c(iArr[i8]);
            }
            throw new NoSuchElementException(String.valueOf(this.f50841g));
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super UInt> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f50841g < this.f50840f.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return UInt.a(b());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.f50839f = iArr;
    }

    public static final /* synthetic */ UIntArray b(int[] iArr) {
        return new UIntArray(iArr);
    }

    public static int[] d(int i8) {
        return g(new int[i8]);
    }

    public static int[] g(int[] storage) {
        Intrinsics.f(storage, "storage");
        return storage;
    }

    public static boolean k(int[] iArr, int i8) {
        boolean x7;
        x7 = ArraysKt___ArraysKt.x(iArr, i8);
        return x7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(int[] r4, java.util.Collection<kotlin.UInt> r5) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            boolean r0 = r5.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
        Ld:
            r1 = 1
            goto L32
        Lf:
            java.util.Iterator r5 = r5.iterator()
        L13:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r5.next()
            boolean r3 = r0 instanceof kotlin.UInt
            if (r3 == 0) goto L2f
            kotlin.UInt r0 = (kotlin.UInt) r0
            int r0 = r0.j()
            boolean r0 = kotlin.collections.ArraysKt.x(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UIntArray.m(int[], java.util.Collection):boolean");
    }

    public static boolean n(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.a(iArr, ((UIntArray) obj).y());
    }

    public static final int o(int[] iArr, int i8) {
        return UInt.c(iArr[i8]);
    }

    public static int r(int[] iArr) {
        return iArr.length;
    }

    public static int s(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean u(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    public static java.util.Iterator<UInt> v(int[] iArr) {
        return new Iterator(iArr);
    }

    public static final void w(int[] iArr, int i8, int i9) {
        iArr[i8] = i9;
    }

    public static String x(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return i(((UInt) obj).j());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return m(this.f50839f, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f50839f, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f50839f);
    }

    public boolean i(int i8) {
        return k(this.f50839f, i8);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f50839f);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UInt> iterator() {
        return v(this.f50839f);
    }

    @Override // java.util.Collection
    /* renamed from: p */
    public int size() {
        return r(this.f50839f);
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
        return x(this.f50839f);
    }

    public final /* synthetic */ int[] y() {
        return this.f50839f;
    }
}
