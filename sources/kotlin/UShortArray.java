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

/* compiled from: UShortArray.kt */
/* loaded from: classes5.dex */
public final class UShortArray implements Collection<UShort>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    private final short[] f50850f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UShortArray.kt */
    /* loaded from: classes5.dex */
    public static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final short[] f50851f;

        /* renamed from: g  reason: collision with root package name */
        private int f50852g;

        public Iterator(short[] array) {
            Intrinsics.f(array, "array");
            this.f50851f = array;
        }

        public short b() {
            int i8 = this.f50852g;
            short[] sArr = this.f50851f;
            if (i8 < sArr.length) {
                this.f50852g = i8 + 1;
                return UShort.c(sArr[i8]);
            }
            throw new NoSuchElementException(String.valueOf(this.f50852g));
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super UShort> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f50852g < this.f50851f.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return UShort.a(b());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UShortArray(short[] sArr) {
        this.f50850f = sArr;
    }

    public static final /* synthetic */ UShortArray b(short[] sArr) {
        return new UShortArray(sArr);
    }

    public static short[] d(int i8) {
        return g(new short[i8]);
    }

    public static short[] g(short[] storage) {
        Intrinsics.f(storage, "storage");
        return storage;
    }

    public static boolean k(short[] sArr, short s7) {
        boolean A;
        A = ArraysKt___ArraysKt.A(sArr, s7);
        return A;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(short[] r4, java.util.Collection<kotlin.UShort> r5) {
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
            boolean r3 = r0 instanceof kotlin.UShort
            if (r3 == 0) goto L2f
            kotlin.UShort r0 = (kotlin.UShort) r0
            short r0 = r0.j()
            boolean r0 = kotlin.collections.ArraysKt.A(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UShortArray.m(short[], java.util.Collection):boolean");
    }

    public static boolean n(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.a(sArr, ((UShortArray) obj).y());
    }

    public static final short o(short[] sArr, int i8) {
        return UShort.c(sArr[i8]);
    }

    public static int r(short[] sArr) {
        return sArr.length;
    }

    public static int s(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean u(short[] sArr) {
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    public static java.util.Iterator<UShort> v(short[] sArr) {
        return new Iterator(sArr);
    }

    public static final void w(short[] sArr, int i8, short s7) {
        sArr[i8] = s7;
    }

    public static String x(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        return i(((UShort) obj).j());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return m(this.f50850f, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f50850f, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f50850f);
    }

    public boolean i(short s7) {
        return k(this.f50850f, s7);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f50850f);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UShort> iterator() {
        return v(this.f50850f);
    }

    @Override // java.util.Collection
    /* renamed from: p */
    public int size() {
        return r(this.f50850f);
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
        return x(this.f50850f);
    }

    public final /* synthetic */ short[] y() {
        return this.f50850f;
    }
}
