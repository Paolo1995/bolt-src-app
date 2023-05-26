package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f10221d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f10222e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f10223f;

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f10224g;

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f10225h;

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f10226a = new KeyPool();

    /* renamed from: b  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Bitmap> f10227b = new GroupedLinkedMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f10228c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10229a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f10229a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10229a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10229a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10229a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f10230a;

        /* renamed from: b  reason: collision with root package name */
        int f10231b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f10232c;

        public Key(KeyPool keyPool) {
            this.f10230a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f10230a.c(this);
        }

        public void b(int i8, Bitmap.Config config) {
            this.f10231b = i8;
            this.f10232c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f10231b != key.f10231b || !Util.d(this.f10232c, key.f10232c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i8;
            int i9 = this.f10231b * 31;
            Bitmap.Config config = this.f10232c;
            if (config != null) {
                i8 = config.hashCode();
            } else {
                i8 = 0;
            }
            return i9 + i8;
        }

        public String toString() {
            return SizeConfigStrategy.h(this.f10231b, this.f10232c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i8, Bitmap.Config config) {
            Key b8 = b();
            b8.b(i8, config);
            return b8;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f10221d = configArr;
        f10222e = configArr;
        f10223f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f10224g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f10225h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j8 = j(bitmap.getConfig());
        Integer num2 = j8.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                j8.remove(num);
                return;
            } else {
                j8.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
    }

    private Key g(int i8, Bitmap.Config config) {
        Bitmap.Config[] i9;
        Key e8 = this.f10226a.e(i8, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i8));
            if (ceilingKey != null && ceilingKey.intValue() <= i8 * 8) {
                if (ceilingKey.intValue() == i8) {
                    if (config2 == null) {
                        if (config == null) {
                            return e8;
                        }
                    } else if (config2.equals(config)) {
                        return e8;
                    }
                }
                this.f10226a.c(e8);
                return this.f10226a.e(ceilingKey.intValue(), config2);
            }
        }
        return e8;
    }

    static String h(int i8, Bitmap.Config config) {
        return "[" + i8 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f10222e;
        }
        int i8 = AnonymousClass1.f10229a[config.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return i8 != 4 ? new Bitmap.Config[]{config} : f10225h;
                }
                return f10224g;
            }
            return f10223f;
        }
        return f10221d;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f10228c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f10228c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String a(Bitmap bitmap) {
        return h(Util.h(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i8, int i9, Bitmap.Config config) {
        return h(Util.g(i8, i9, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void c(Bitmap bitmap) {
        Key e8 = this.f10226a.e(Util.h(bitmap), bitmap.getConfig());
        this.f10227b.d(e8, bitmap);
        NavigableMap<Integer, Integer> j8 = j(bitmap.getConfig());
        Integer num = j8.get(Integer.valueOf(e8.f10231b));
        Integer valueOf = Integer.valueOf(e8.f10231b);
        int i8 = 1;
        if (num != null) {
            i8 = 1 + num.intValue();
        }
        j8.put(valueOf, Integer.valueOf(i8));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap d(int i8, int i9, Bitmap.Config config) {
        Key g8 = g(Util.g(i8, i9, config), config);
        Bitmap a8 = this.f10227b.a(g8);
        if (a8 != null) {
            f(Integer.valueOf(g8.f10231b), a8);
            a8.reconfigure(i8, i9, config);
        }
        return a8;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int e(Bitmap bitmap) {
        return Util.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap f8 = this.f10227b.f();
        if (f8 != null) {
            f(Integer.valueOf(Util.h(f8)), f8);
        }
        return f8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f10227b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f10228c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f10228c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
