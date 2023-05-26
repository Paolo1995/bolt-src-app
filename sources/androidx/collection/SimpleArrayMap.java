package androidx.collection;

import androidx.annotation.NonNull;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {

    /* renamed from: i  reason: collision with root package name */
    static Object[] f4274i;

    /* renamed from: j  reason: collision with root package name */
    static int f4275j;

    /* renamed from: k  reason: collision with root package name */
    static Object[] f4276k;

    /* renamed from: l  reason: collision with root package name */
    static int f4277l;

    /* renamed from: f  reason: collision with root package name */
    int[] f4278f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f4279g;

    /* renamed from: h  reason: collision with root package name */
    int f4280h;

    public SimpleArrayMap() {
        this.f4278f = ContainerHelpers.f4251a;
        this.f4279g = ContainerHelpers.f4253c;
        this.f4280h = 0;
    }

    private void a(int i8) {
        if (i8 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = f4276k;
                if (objArr != null) {
                    this.f4279g = objArr;
                    f4276k = (Object[]) objArr[0];
                    this.f4278f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4277l--;
                    return;
                }
            }
        } else if (i8 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = f4274i;
                if (objArr2 != null) {
                    this.f4279g = objArr2;
                    f4274i = (Object[]) objArr2[0];
                    this.f4278f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4275j--;
                    return;
                }
            }
        }
        this.f4278f = new int[i8];
        this.f4279g = new Object[i8 << 1];
    }

    private static int b(int[] iArr, int i8, int i9) {
        try {
            return ContainerHelpers.a(iArr, i8, i9);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i8) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (f4277l < 10) {
                    objArr[0] = f4276k;
                    objArr[1] = iArr;
                    for (int i9 = (i8 << 1) - 1; i9 >= 2; i9--) {
                        objArr[i9] = null;
                    }
                    f4276k = objArr;
                    f4277l++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (f4275j < 10) {
                    objArr[0] = f4274i;
                    objArr[1] = iArr;
                    for (int i10 = (i8 << 1) - 1; i10 >= 2; i10--) {
                        objArr[i10] = null;
                    }
                    f4274i = objArr;
                    f4275j++;
                }
            }
        }
    }

    public void c(int i8) {
        int i9 = this.f4280h;
        int[] iArr = this.f4278f;
        if (iArr.length < i8) {
            Object[] objArr = this.f4279g;
            a(i8);
            if (this.f4280h > 0) {
                System.arraycopy(iArr, 0, this.f4278f, 0, i9);
                System.arraycopy(objArr, 0, this.f4279g, 0, i9 << 1);
            }
            d(iArr, objArr, i9);
        }
        if (this.f4280h == i9) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int i8 = this.f4280h;
        if (i8 > 0) {
            int[] iArr = this.f4278f;
            Object[] objArr = this.f4279g;
            this.f4278f = ContainerHelpers.f4251a;
            this.f4279g = ContainerHelpers.f4253c;
            this.f4280h = 0;
            d(iArr, objArr, i8);
        }
        if (this.f4280h <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object obj) {
        if (g(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (i(obj) >= 0) {
            return true;
        }
        return false;
    }

    int e(Object obj, int i8) {
        int i9 = this.f4280h;
        if (i9 == 0) {
            return -1;
        }
        int b8 = b(this.f4278f, i9, i8);
        if (b8 < 0) {
            return b8;
        }
        if (obj.equals(this.f4279g[b8 << 1])) {
            return b8;
        }
        int i10 = b8 + 1;
        while (i10 < i9 && this.f4278f[i10] == i8) {
            if (obj.equals(this.f4279g[i10 << 1])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = b8 - 1; i11 >= 0 && this.f4278f[i11] == i8; i11--) {
            if (obj.equals(this.f4279g[i11 << 1])) {
                return i11;
            }
        }
        return ~i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i8 = 0; i8 < this.f4280h; i8++) {
                try {
                    K j8 = j(i8);
                    V n8 = n(i8);
                    Object obj2 = simpleArrayMap.get(j8);
                    if (n8 == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(j8)) {
                            return false;
                        }
                    } else if (!n8.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i9 = 0; i9 < this.f4280h; i9++) {
                try {
                    K j9 = j(i9);
                    V n9 = n(i9);
                    Object obj3 = map.get(j9);
                    if (n9 == null) {
                        if (obj3 != null || !map.containsKey(j9)) {
                            return false;
                        }
                    } else if (!n9.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int g(Object obj) {
        if (obj == null) {
            return h();
        }
        return e(obj, obj.hashCode());
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v7) {
        int g8 = g(obj);
        if (g8 >= 0) {
            return (V) this.f4279g[(g8 << 1) + 1];
        }
        return v7;
    }

    int h() {
        int i8 = this.f4280h;
        if (i8 == 0) {
            return -1;
        }
        int b8 = b(this.f4278f, i8, 0);
        if (b8 < 0) {
            return b8;
        }
        if (this.f4279g[b8 << 1] == null) {
            return b8;
        }
        int i9 = b8 + 1;
        while (i9 < i8 && this.f4278f[i9] == 0) {
            if (this.f4279g[i9 << 1] == null) {
                return i9;
            }
            i9++;
        }
        for (int i10 = b8 - 1; i10 >= 0 && this.f4278f[i10] == 0; i10--) {
            if (this.f4279g[i10 << 1] == null) {
                return i10;
            }
        }
        return ~i9;
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.f4278f;
        Object[] objArr = this.f4279g;
        int i8 = this.f4280h;
        int i9 = 1;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            Object obj = objArr[i9];
            int i12 = iArr[i10];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i11 += hashCode ^ i12;
            i10++;
            i9 += 2;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(Object obj) {
        int i8 = this.f4280h * 2;
        Object[] objArr = this.f4279g;
        if (obj == null) {
            for (int i9 = 1; i9 < i8; i9 += 2) {
                if (objArr[i9] == null) {
                    return i9 >> 1;
                }
            }
            return -1;
        }
        for (int i10 = 1; i10 < i8; i10 += 2) {
            if (obj.equals(objArr[i10])) {
                return i10 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f4280h <= 0) {
            return true;
        }
        return false;
    }

    public K j(int i8) {
        return (K) this.f4279g[i8 << 1];
    }

    public void k(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i8 = simpleArrayMap.f4280h;
        c(this.f4280h + i8);
        if (this.f4280h == 0) {
            if (i8 > 0) {
                System.arraycopy(simpleArrayMap.f4278f, 0, this.f4278f, 0, i8);
                System.arraycopy(simpleArrayMap.f4279g, 0, this.f4279g, 0, i8 << 1);
                this.f4280h = i8;
                return;
            }
            return;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            put(simpleArrayMap.j(i9), simpleArrayMap.n(i9));
        }
    }

    public V l(int i8) {
        Object[] objArr = this.f4279g;
        int i9 = i8 << 1;
        V v7 = (V) objArr[i9 + 1];
        int i10 = this.f4280h;
        int i11 = 0;
        if (i10 <= 1) {
            d(this.f4278f, objArr, i10);
            this.f4278f = ContainerHelpers.f4251a;
            this.f4279g = ContainerHelpers.f4253c;
        } else {
            int i12 = i10 - 1;
            int[] iArr = this.f4278f;
            int i13 = 8;
            if (iArr.length > 8 && i10 < iArr.length / 3) {
                if (i10 > 8) {
                    i13 = i10 + (i10 >> 1);
                }
                a(i13);
                if (i10 == this.f4280h) {
                    if (i8 > 0) {
                        System.arraycopy(iArr, 0, this.f4278f, 0, i8);
                        System.arraycopy(objArr, 0, this.f4279g, 0, i9);
                    }
                    if (i8 < i12) {
                        int i14 = i8 + 1;
                        int i15 = i12 - i8;
                        System.arraycopy(iArr, i14, this.f4278f, i8, i15);
                        System.arraycopy(objArr, i14 << 1, this.f4279g, i9, i15 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i8 < i12) {
                    int i16 = i8 + 1;
                    int i17 = i12 - i8;
                    System.arraycopy(iArr, i16, iArr, i8, i17);
                    Object[] objArr2 = this.f4279g;
                    System.arraycopy(objArr2, i16 << 1, objArr2, i9, i17 << 1);
                }
                Object[] objArr3 = this.f4279g;
                int i18 = i12 << 1;
                objArr3[i18] = null;
                objArr3[i18 + 1] = null;
            }
            i11 = i12;
        }
        if (i10 == this.f4280h) {
            this.f4280h = i11;
            return v7;
        }
        throw new ConcurrentModificationException();
    }

    public V m(int i8, V v7) {
        int i9 = (i8 << 1) + 1;
        Object[] objArr = this.f4279g;
        V v8 = (V) objArr[i9];
        objArr[i9] = v7;
        return v8;
    }

    public V n(int i8) {
        return (V) this.f4279g[(i8 << 1) + 1];
    }

    public V put(K k8, V v7) {
        int i8;
        int e8;
        int i9 = this.f4280h;
        if (k8 == null) {
            e8 = h();
            i8 = 0;
        } else {
            int hashCode = k8.hashCode();
            i8 = hashCode;
            e8 = e(k8, hashCode);
        }
        if (e8 >= 0) {
            int i10 = (e8 << 1) + 1;
            Object[] objArr = this.f4279g;
            V v8 = (V) objArr[i10];
            objArr[i10] = v7;
            return v8;
        }
        int i11 = ~e8;
        int[] iArr = this.f4278f;
        if (i9 >= iArr.length) {
            int i12 = 4;
            if (i9 >= 8) {
                i12 = (i9 >> 1) + i9;
            } else if (i9 >= 4) {
                i12 = 8;
            }
            Object[] objArr2 = this.f4279g;
            a(i12);
            if (i9 == this.f4280h) {
                int[] iArr2 = this.f4278f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f4279g, 0, objArr2.length);
                }
                d(iArr, objArr2, i9);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < i9) {
            int[] iArr3 = this.f4278f;
            int i13 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i13, i9 - i11);
            Object[] objArr3 = this.f4279g;
            System.arraycopy(objArr3, i11 << 1, objArr3, i13 << 1, (this.f4280h - i11) << 1);
        }
        int i14 = this.f4280h;
        if (i9 == i14) {
            int[] iArr4 = this.f4278f;
            if (i11 < iArr4.length) {
                iArr4[i11] = i8;
                Object[] objArr4 = this.f4279g;
                int i15 = i11 << 1;
                objArr4[i15] = k8;
                objArr4[i15 + 1] = v7;
                this.f4280h = i14 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k8, V v7) {
        V v8 = get(k8);
        if (v8 == null) {
            return put(k8, v7);
        }
        return v8;
    }

    public V remove(Object obj) {
        int g8 = g(obj);
        if (g8 >= 0) {
            return l(g8);
        }
        return null;
    }

    public V replace(K k8, V v7) {
        int g8 = g(k8);
        if (g8 >= 0) {
            return m(g8, v7);
        }
        return null;
    }

    public int size() {
        return this.f4280h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4280h * 28);
        sb.append('{');
        for (int i8 = 0; i8 < this.f4280h; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            K j8 = j(i8);
            if (j8 != this) {
                sb.append(j8);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V n8 = n(i8);
            if (n8 != this) {
                sb.append(n8);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int g8 = g(obj);
        if (g8 >= 0) {
            V n8 = n(g8);
            if (obj2 == n8 || (obj2 != null && obj2.equals(n8))) {
                l(g8);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean replace(K k8, V v7, V v8) {
        int g8 = g(k8);
        if (g8 >= 0) {
            V n8 = n(g8);
            if (n8 == v7 || (v7 != null && v7.equals(n8))) {
                m(g8, v8);
                return true;
            }
            return false;
        }
        return false;
    }

    public SimpleArrayMap(int i8) {
        if (i8 == 0) {
            this.f4278f = ContainerHelpers.f4251a;
            this.f4279g = ContainerHelpers.f4253c;
        } else {
            a(i8);
        }
        this.f4280h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            k(simpleArrayMap);
        }
    }
}
