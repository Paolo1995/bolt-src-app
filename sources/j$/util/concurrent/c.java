package j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class c implements Collection, Serializable {

    /* renamed from: a  reason: collision with root package name */
    final ConcurrentHashMap f50212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ConcurrentHashMap concurrentHashMap) {
        this.f50212a = concurrentHashMap;
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f50212a.clear();
    }

    @Override // java.util.Collection
    public abstract boolean contains(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsAll(java.util.Collection r2) {
        /*
            r1 = this;
            if (r2 == r1) goto L1a
            java.util.Iterator r2 = r2.iterator()
        L6:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L1a
            java.lang.Object r0 = r2.next()
            if (r0 == 0) goto L18
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L6
        L18:
            r2 = 0
            return r2
        L1a:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.c.containsAll(java.util.Collection):boolean");
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f50212a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator iterator();

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        boolean z7 = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        boolean z7 = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f50212a.size();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        long mappingCount = this.f50212a.mappingCount();
        if (mappingCount <= 2147483639) {
            int i8 = (int) mappingCount;
            Object[] objArr = new Object[i8];
            int i9 = 0;
            Iterator it = iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (i9 == i8) {
                    if (i8 >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i10 = i8 < 1073741819 ? (i8 >>> 1) + 1 + i8 : 2147483639;
                    objArr = Arrays.copyOf(objArr, i10);
                    i8 = i10;
                }
                objArr[i9] = next;
                i9++;
            }
            return i9 == i8 ? objArr : Arrays.copyOf(objArr, i9);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        long mappingCount = this.f50212a.mappingCount();
        if (mappingCount <= 2147483639) {
            int i8 = (int) mappingCount;
            Object[] objArr2 = objArr.length >= i8 ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i8);
            int length = objArr2.length;
            int i9 = 0;
            Iterator it = iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (i9 == length) {
                    if (length >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i10 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                    objArr2 = Arrays.copyOf(objArr2, i10);
                    length = i10;
                }
                objArr2[i9] = next;
                i9++;
            }
            if (objArr != objArr2 || i9 >= length) {
                return i9 == length ? objArr2 : Arrays.copyOf(objArr2, i9);
            }
            objArr2[i9] = null;
            return objArr2;
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
