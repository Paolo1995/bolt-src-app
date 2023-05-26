package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class UnsafeUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f15241a = Logger.getLogger(UnsafeUtil.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f15242b = B();

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f15243c = Android.b();

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f15244d = m(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f15245e = m(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    private static final MemoryAccessor f15246f = z();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f15247g = Q();

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f15248h = P();

    /* renamed from: i  reason: collision with root package name */
    static final long f15249i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f15250j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f15251k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f15252l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f15253m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f15254n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f15255o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f15256p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f15257q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f15258r;

    /* renamed from: s  reason: collision with root package name */
    private static final long f15259s;

    /* renamed from: t  reason: collision with root package name */
    private static final long f15260t;

    /* renamed from: u  reason: collision with root package name */
    private static final long f15261u;

    /* renamed from: v  reason: collision with root package name */
    private static final long f15262v;

    /* renamed from: w  reason: collision with root package name */
    private static final int f15263w;

    /* renamed from: x  reason: collision with root package name */
    static final boolean f15264x;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Android32MemoryAccessor extends MemoryAccessor {
        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean c(Object obj, long j8) {
            return UnsafeUtil.f15264x ? UnsafeUtil.q(obj, j8) : UnsafeUtil.r(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte d(Object obj, long j8) {
            return UnsafeUtil.f15264x ? UnsafeUtil.t(obj, j8) : UnsafeUtil.u(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double e(Object obj, long j8) {
            return Double.longBitsToDouble(h(obj, j8));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float f(Object obj, long j8) {
            return Float.intBitsToFloat(g(obj, j8));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void k(Object obj, long j8, boolean z7) {
            if (UnsafeUtil.f15264x) {
                UnsafeUtil.F(obj, j8, z7);
            } else {
                UnsafeUtil.G(obj, j8, z7);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void l(Object obj, long j8, byte b8) {
            if (UnsafeUtil.f15264x) {
                UnsafeUtil.I(obj, j8, b8);
            } else {
                UnsafeUtil.J(obj, j8, b8);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void m(Object obj, long j8, double d8) {
            p(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void n(Object obj, long j8, float f8) {
            o(obj, j8, Float.floatToIntBits(f8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean c(Object obj, long j8) {
            return UnsafeUtil.f15264x ? UnsafeUtil.q(obj, j8) : UnsafeUtil.r(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte d(Object obj, long j8) {
            return UnsafeUtil.f15264x ? UnsafeUtil.t(obj, j8) : UnsafeUtil.u(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double e(Object obj, long j8) {
            return Double.longBitsToDouble(h(obj, j8));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float f(Object obj, long j8) {
            return Float.intBitsToFloat(g(obj, j8));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void k(Object obj, long j8, boolean z7) {
            if (UnsafeUtil.f15264x) {
                UnsafeUtil.F(obj, j8, z7);
            } else {
                UnsafeUtil.G(obj, j8, z7);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void l(Object obj, long j8, byte b8) {
            if (UnsafeUtil.f15264x) {
                UnsafeUtil.I(obj, j8, b8);
            } else {
                UnsafeUtil.J(obj, j8, b8);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void m(Object obj, long j8, double d8) {
            p(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void n(Object obj, long j8, float f8) {
            o(obj, j8, Float.floatToIntBits(f8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean c(Object obj, long j8) {
            return this.f15265a.getBoolean(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte d(Object obj, long j8) {
            return this.f15265a.getByte(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double e(Object obj, long j8) {
            return this.f15265a.getDouble(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float f(Object obj, long j8) {
            return this.f15265a.getFloat(obj, j8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void k(Object obj, long j8, boolean z7) {
            this.f15265a.putBoolean(obj, j8, z7);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void l(Object obj, long j8, byte b8) {
            this.f15265a.putByte(obj, j8, b8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void m(Object obj, long j8, double d8) {
            this.f15265a.putDouble(obj, j8, d8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void n(Object obj, long j8, float f8) {
            this.f15265a.putFloat(obj, j8, f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class MemoryAccessor {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f15265a;

        MemoryAccessor(Unsafe unsafe) {
            this.f15265a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f15265a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f15265a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j8);

        public abstract byte d(Object obj, long j8);

        public abstract double e(Object obj, long j8);

        public abstract float f(Object obj, long j8);

        public final int g(Object obj, long j8) {
            return this.f15265a.getInt(obj, j8);
        }

        public final long h(Object obj, long j8) {
            return this.f15265a.getLong(obj, j8);
        }

        public final Object i(Object obj, long j8) {
            return this.f15265a.getObject(obj, j8);
        }

        public final long j(Field field) {
            return this.f15265a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j8, boolean z7);

        public abstract void l(Object obj, long j8, byte b8);

        public abstract void m(Object obj, long j8, double d8);

        public abstract void n(Object obj, long j8, float f8);

        public final void o(Object obj, long j8, int i8) {
            this.f15265a.putInt(obj, j8, i8);
        }

        public final void p(Object obj, long j8, long j9) {
            this.f15265a.putLong(obj, j8, j9);
        }

        public final void q(Object obj, long j8, Object obj2) {
            this.f15265a.putObject(obj, j8, obj2);
        }
    }

    static {
        boolean z7;
        long j8 = j(byte[].class);
        f15249i = j8;
        f15250j = j(boolean[].class);
        f15251k = k(boolean[].class);
        f15252l = j(int[].class);
        f15253m = k(int[].class);
        f15254n = j(long[].class);
        f15255o = k(long[].class);
        f15256p = j(float[].class);
        f15257q = k(float[].class);
        f15258r = j(double[].class);
        f15259s = k(double[].class);
        f15260t = j(Object[].class);
        f15261u = k(Object[].class);
        f15262v = o(l());
        f15263w = (int) (7 & j8);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z7 = true;
        } else {
            z7 = false;
        }
        f15264x = z7;
    }

    private UnsafeUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object A(Object obj, long j8) {
        return f15246f.i(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.crypto.tink.shaded.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a */
                public Unsafe run() throws Exception {
                    Field[] declaredFields;
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C() {
        return f15248h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean D() {
        return f15247g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(Object obj, long j8, boolean z7) {
        f15246f.k(obj, j8, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Object obj, long j8, boolean z7) {
        I(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Object obj, long j8, boolean z7) {
        J(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void H(byte[] bArr, long j8, byte b8) {
        f15246f.l(bArr, f15249i + j8, b8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int x7 = x(obj, j9);
        int i8 = ((~((int) j8)) & 3) << 3;
        M(obj, j9, ((255 & b8) << i8) | (x7 & (~(255 << i8))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int i8 = (((int) j8) & 3) << 3;
        M(obj, j9, ((255 & b8) << i8) | (x(obj, j9) & (~(255 << i8))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K(Object obj, long j8, double d8) {
        f15246f.m(obj, j8, d8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void L(Object obj, long j8, float f8) {
        f15246f.n(obj, j8, f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void M(Object obj, long j8, int i8) {
        f15246f.o(obj, j8, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(Object obj, long j8, long j9) {
        f15246f.p(obj, j8, j9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void O(Object obj, long j8, Object obj2) {
        f15246f.q(obj, j8, obj2);
    }

    private static boolean P() {
        Unsafe unsafe = f15242b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (Android.c()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f15241a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean Q() {
        Unsafe unsafe = f15242b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (l() == null) {
                return false;
            }
            if (Android.c()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = f15241a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T i(Class<T> cls) {
        try {
            return (T) f15242b.allocateInstance(cls);
        } catch (InstantiationException e8) {
            throw new IllegalStateException(e8);
        }
    }

    private static int j(Class<?> cls) {
        if (f15248h) {
            return f15246f.a(cls);
        }
        return -1;
    }

    private static int k(Class<?> cls) {
        if (f15248h) {
            return f15246f.b(cls);
        }
        return -1;
    }

    private static Field l() {
        Field n8;
        if (Android.c() && (n8 = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return n8;
        }
        Field n9 = n(Buffer.class, "address");
        if (n9 == null || n9.getType() != Long.TYPE) {
            return null;
        }
        return n9;
    }

    private static boolean m(Class<?> cls) {
        if (!Android.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f15243c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field n(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long o(Field field) {
        MemoryAccessor memoryAccessor;
        if (field != null && (memoryAccessor = f15246f) != null) {
            return memoryAccessor.j(field);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p(Object obj, long j8) {
        return f15246f.c(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Object obj, long j8) {
        if (t(obj, j8) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(Object obj, long j8) {
        if (u(obj, j8) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte s(byte[] bArr, long j8) {
        return f15246f.d(bArr, f15249i + j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte t(Object obj, long j8) {
        return (byte) ((x(obj, (-4) & j8) >>> ((int) (((~j8) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte u(Object obj, long j8) {
        return (byte) ((x(obj, (-4) & j8) >>> ((int) ((j8 & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double v(Object obj, long j8) {
        return f15246f.e(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float w(Object obj, long j8) {
        return f15246f.f(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(Object obj, long j8) {
        return f15246f.g(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long y(Object obj, long j8) {
        return f15246f.h(obj, j8);
    }

    private static MemoryAccessor z() {
        Unsafe unsafe = f15242b;
        if (unsafe == null) {
            return null;
        }
        if (Android.c()) {
            if (f15244d) {
                return new Android64MemoryAccessor(unsafe);
            }
            if (!f15245e) {
                return null;
            }
            return new Android32MemoryAccessor(unsafe);
        }
        return new JvmMemoryAccessor(unsafe);
    }
}
