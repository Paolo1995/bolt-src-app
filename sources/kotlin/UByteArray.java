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

/* compiled from: UByteArray.kt */
/* loaded from: classes5.dex */
public final class UByteArray implements Collection<UByte>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f50834f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UByteArray.kt */
    /* loaded from: classes5.dex */
    public static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f50835f;

        /* renamed from: g  reason: collision with root package name */
        private int f50836g;

        public Iterator(byte[] array) {
            Intrinsics.f(array, "array");
            this.f50835f = array;
        }

        public byte b() {
            int i8 = this.f50836g;
            byte[] bArr = this.f50835f;
            if (i8 < bArr.length) {
                this.f50836g = i8 + 1;
                return UByte.c(bArr[i8]);
            }
            throw new NoSuchElementException(String.valueOf(this.f50836g));
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super UByte> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f50836g < this.f50835f.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return UByte.a(b());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.f50834f = bArr;
    }

    public static final /* synthetic */ UByteArray b(byte[] bArr) {
        return new UByteArray(bArr);
    }

    public static byte[] d(int i8) {
        return g(new byte[i8]);
    }

    public static byte[] g(byte[] storage) {
        Intrinsics.f(storage, "storage");
        return storage;
    }

    public static boolean k(byte[] bArr, byte b8) {
        boolean w7;
        w7 = ArraysKt___ArraysKt.w(bArr, b8);
        return w7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(byte[] r4, java.util.Collection<kotlin.UByte> r5) {
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
            boolean r3 = r0 instanceof kotlin.UByte
            if (r3 == 0) goto L2f
            kotlin.UByte r0 = (kotlin.UByte) r0
            byte r0 = r0.j()
            boolean r0 = kotlin.collections.ArraysKt.w(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UByteArray.m(byte[], java.util.Collection):boolean");
    }

    public static boolean n(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.a(bArr, ((UByteArray) obj).y());
    }

    public static final byte o(byte[] bArr, int i8) {
        return UByte.c(bArr[i8]);
    }

    public static int r(byte[] bArr) {
        return bArr.length;
    }

    public static int s(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean u(byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    public static java.util.Iterator<UByte> v(byte[] bArr) {
        return new Iterator(bArr);
    }

    public static final void w(byte[] bArr, int i8, byte b8) {
        bArr[i8] = b8;
    }

    public static String x(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        return i(((UByte) obj).j());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return m(this.f50834f, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return n(this.f50834f, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f50834f);
    }

    public boolean i(byte b8) {
        return k(this.f50834f, b8);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f50834f);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UByte> iterator() {
        return v(this.f50834f);
    }

    @Override // java.util.Collection
    /* renamed from: p */
    public int size() {
        return r(this.f50834f);
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
        return x(this.f50834f);
    }

    public final /* synthetic */ byte[] y() {
        return this.f50834f;
    }
}
