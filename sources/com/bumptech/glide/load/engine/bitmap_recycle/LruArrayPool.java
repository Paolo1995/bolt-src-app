package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Object> f10201a;

    /* renamed from: b  reason: collision with root package name */
    private final KeyPool f10202b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f10203c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, ArrayAdapterInterface<?>> f10204d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10205e;

    /* renamed from: f  reason: collision with root package name */
    private int f10206f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f10207a;

        /* renamed from: b  reason: collision with root package name */
        int f10208b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f10209c;

        Key(KeyPool keyPool) {
            this.f10207a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f10207a.c(this);
        }

        void b(int i8, Class<?> cls) {
            this.f10208b = i8;
            this.f10209c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f10208b != key.f10208b || this.f10209c != key.f10209c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i8;
            int i9 = this.f10208b * 31;
            Class<?> cls = this.f10209c;
            if (cls != null) {
                i8 = cls.hashCode();
            } else {
                i8 = 0;
            }
            return i9 + i8;
        }

        public String toString() {
            return "Key{size=" + this.f10208b + "array=" + this.f10209c + '}';
        }
    }

    /* loaded from: classes.dex */
    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        Key e(int i8, Class<?> cls) {
            Key b8 = b();
            b8.b(i8, cls);
            return b8;
        }
    }

    public LruArrayPool() {
        this.f10201a = new GroupedLinkedMap<>();
        this.f10202b = new KeyPool();
        this.f10203c = new HashMap();
        this.f10204d = new HashMap();
        this.f10205e = 4194304;
    }

    private void e(int i8, Class<?> cls) {
        NavigableMap<Integer, Integer> l8 = l(cls);
        Integer num = l8.get(Integer.valueOf(i8));
        if (num != null) {
            if (num.intValue() == 1) {
                l8.remove(Integer.valueOf(i8));
                return;
            } else {
                l8.put(Integer.valueOf(i8), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i8 + ", this: " + this);
    }

    private void f() {
        g(this.f10205e);
    }

    private void g(int i8) {
        while (this.f10206f > i8) {
            Object f8 = this.f10201a.f();
            Preconditions.d(f8);
            ArrayAdapterInterface h8 = h(f8);
            this.f10206f -= h8.c(f8) * h8.b();
            e(h8.c(f8), f8.getClass());
            if (Log.isLoggable(h8.a(), 2)) {
                Log.v(h8.a(), "evicted: " + h8.c(f8));
            }
        }
    }

    private <T> ArrayAdapterInterface<T> h(T t7) {
        return i(t7.getClass());
    }

    private <T> ArrayAdapterInterface<T> i(Class<T> cls) {
        IntegerArrayAdapter integerArrayAdapter = (ArrayAdapterInterface<T>) this.f10204d.get(cls);
        if (integerArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                integerArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                integerArrayAdapter = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f10204d.put(cls, integerArrayAdapter);
        }
        return integerArrayAdapter;
    }

    private <T> T j(Key key) {
        return (T) this.f10201a.a(key);
    }

    private <T> T k(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> i8 = i(cls);
        T t7 = (T) j(key);
        if (t7 != null) {
            this.f10206f -= i8.c(t7) * i8.b();
            e(i8.c(t7), cls);
        }
        if (t7 == null) {
            if (Log.isLoggable(i8.a(), 2)) {
                Log.v(i8.a(), "Allocated " + key.f10208b + " bytes");
            }
            return i8.newArray(key.f10208b);
        }
        return t7;
    }

    private NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f10203c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f10203c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean m() {
        int i8 = this.f10206f;
        if (i8 != 0 && this.f10205e / i8 < 2) {
            return false;
        }
        return true;
    }

    private boolean n(int i8) {
        if (i8 <= this.f10205e / 2) {
            return true;
        }
        return false;
    }

    private boolean o(int i8, Integer num) {
        if (num != null && (m() || num.intValue() <= i8 * 8)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void a(int i8) {
        try {
            if (i8 >= 40) {
                b();
            } else if (i8 >= 20 || i8 == 15) {
                g(this.f10205e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void b() {
        g(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T c(int i8, Class<T> cls) {
        Key e8;
        Integer ceilingKey = l(cls).ceilingKey(Integer.valueOf(i8));
        if (o(i8, ceilingKey)) {
            e8 = this.f10202b.e(ceilingKey.intValue(), cls);
        } else {
            e8 = this.f10202b.e(i8, cls);
        }
        return (T) k(e8, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T d(int i8, Class<T> cls) {
        return (T) k(this.f10202b.e(i8, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t7) {
        Class<?> cls = t7.getClass();
        ArrayAdapterInterface<T> i8 = i(cls);
        int c8 = i8.c(t7);
        int b8 = i8.b() * c8;
        if (!n(b8)) {
            return;
        }
        Key e8 = this.f10202b.e(c8, cls);
        this.f10201a.d(e8, t7);
        NavigableMap<Integer, Integer> l8 = l(cls);
        Integer num = l8.get(Integer.valueOf(e8.f10208b));
        Integer valueOf = Integer.valueOf(e8.f10208b);
        int i9 = 1;
        if (num != null) {
            i9 = 1 + num.intValue();
        }
        l8.put(valueOf, Integer.valueOf(i9));
        this.f10206f += b8;
        f();
    }

    public LruArrayPool(int i8) {
        this.f10201a = new GroupedLinkedMap<>();
        this.f10202b = new KeyPool();
        this.f10203c = new HashMap();
        this.f10204d = new HashMap();
        this.f10205e = i8;
    }
}
