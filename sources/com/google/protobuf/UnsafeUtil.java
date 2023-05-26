package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class UnsafeUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f17632a = H();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f17633b = Android.b();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f17634c = q(Long.TYPE);

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f17635d = q(Integer.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final MemoryAccessor f17636e = F();

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f17637f = X();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f17638g = W();

    /* renamed from: h  reason: collision with root package name */
    static final long f17639h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f17640i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f17641j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f17642k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f17643l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f17644m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f17645n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f17646o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f17647p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f17648q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f17649r;

    /* renamed from: s  reason: collision with root package name */
    private static final long f17650s;

    /* renamed from: t  reason: collision with root package name */
    private static final long f17651t;

    /* renamed from: u  reason: collision with root package name */
    private static final long f17652u;

    /* renamed from: v  reason: collision with root package name */
    private static final int f17653v;

    /* renamed from: w  reason: collision with root package name */
    static final boolean f17654w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Android32MemoryAccessor extends MemoryAccessor {
        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j8, byte[] bArr, long j9, long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean d(Object obj, long j8) {
            return UnsafeUtil.f17654w ? UnsafeUtil.u(obj, j8) : UnsafeUtil.v(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte e(long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(Object obj, long j8) {
            return UnsafeUtil.f17654w ? UnsafeUtil.y(obj, j8) : UnsafeUtil.z(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double g(Object obj, long j8) {
            return Double.longBitsToDouble(k(obj, j8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float h(Object obj, long j8) {
            return Float.intBitsToFloat(i(obj, j8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long j(long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void n(Object obj, long j8, boolean z7) {
            if (UnsafeUtil.f17654w) {
                UnsafeUtil.M(obj, j8, z7);
            } else {
                UnsafeUtil.N(obj, j8, z7);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j8, byte b8) {
            if (UnsafeUtil.f17654w) {
                UnsafeUtil.P(obj, j8, b8);
            } else {
                UnsafeUtil.Q(obj, j8, b8);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void p(Object obj, long j8, double d8) {
            s(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j8, float f8) {
            r(obj, j8, Float.floatToIntBits(f8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j8, byte[] bArr, long j9, long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean d(Object obj, long j8) {
            return UnsafeUtil.f17654w ? UnsafeUtil.u(obj, j8) : UnsafeUtil.v(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte e(long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(Object obj, long j8) {
            return UnsafeUtil.f17654w ? UnsafeUtil.y(obj, j8) : UnsafeUtil.z(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double g(Object obj, long j8) {
            return Double.longBitsToDouble(k(obj, j8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float h(Object obj, long j8) {
            return Float.intBitsToFloat(i(obj, j8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long j(long j8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void n(Object obj, long j8, boolean z7) {
            if (UnsafeUtil.f17654w) {
                UnsafeUtil.M(obj, j8, z7);
            } else {
                UnsafeUtil.N(obj, j8, z7);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j8, byte b8) {
            if (UnsafeUtil.f17654w) {
                UnsafeUtil.P(obj, j8, b8);
            } else {
                UnsafeUtil.Q(obj, j8, b8);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void p(Object obj, long j8, double d8) {
            s(obj, j8, Double.doubleToLongBits(d8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j8, float f8) {
            r(obj, j8, Float.floatToIntBits(f8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j8, byte[] bArr, long j9, long j10) {
            this.f17655a.copyMemory((Object) null, j8, bArr, UnsafeUtil.f17639h + j9, j10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean d(Object obj, long j8) {
            return this.f17655a.getBoolean(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte e(long j8) {
            return this.f17655a.getByte(j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(Object obj, long j8) {
            return this.f17655a.getByte(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double g(Object obj, long j8) {
            return this.f17655a.getDouble(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float h(Object obj, long j8) {
            return this.f17655a.getFloat(obj, j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long j(long j8) {
            return this.f17655a.getLong(j8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void n(Object obj, long j8, boolean z7) {
            this.f17655a.putBoolean(obj, j8, z7);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j8, byte b8) {
            this.f17655a.putByte(obj, j8, b8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void p(Object obj, long j8, double d8) {
            this.f17655a.putDouble(obj, j8, d8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j8, float f8) {
            this.f17655a.putFloat(obj, j8, f8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f17655a.getClass();
                Class<?> cls2 = Long.TYPE;
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
                UnsafeUtil.K(th);
                return false;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f17655a.getClass();
                Class<?> cls2 = Long.TYPE;
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
                UnsafeUtil.K(th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class MemoryAccessor {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f17655a;

        MemoryAccessor(Unsafe unsafe) {
            this.f17655a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f17655a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f17655a.arrayIndexScale(cls);
        }

        public abstract void c(long j8, byte[] bArr, long j9, long j10);

        public abstract boolean d(Object obj, long j8);

        public abstract byte e(long j8);

        public abstract byte f(Object obj, long j8);

        public abstract double g(Object obj, long j8);

        public abstract float h(Object obj, long j8);

        public final int i(Object obj, long j8) {
            return this.f17655a.getInt(obj, j8);
        }

        public abstract long j(long j8);

        public final long k(Object obj, long j8) {
            return this.f17655a.getLong(obj, j8);
        }

        public final Object l(Object obj, long j8) {
            return this.f17655a.getObject(obj, j8);
        }

        public final long m(java.lang.reflect.Field field) {
            return this.f17655a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j8, boolean z7);

        public abstract void o(Object obj, long j8, byte b8);

        public abstract void p(Object obj, long j8, double d8);

        public abstract void q(Object obj, long j8, float f8);

        public final void r(Object obj, long j8, int i8) {
            this.f17655a.putInt(obj, j8, i8);
        }

        public final void s(Object obj, long j8, long j9) {
            this.f17655a.putLong(obj, j8, j9);
        }

        public final void t(Object obj, long j8, Object obj2) {
            this.f17655a.putObject(obj, j8, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f17655a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f17655a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                if (UnsafeUtil.b() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                UnsafeUtil.K(th);
                return false;
            }
        }
    }

    static {
        boolean z7;
        long m8 = m(byte[].class);
        f17639h = m8;
        f17640i = m(boolean[].class);
        f17641j = n(boolean[].class);
        f17642k = m(int[].class);
        f17643l = n(int[].class);
        f17644m = m(long[].class);
        f17645n = n(long[].class);
        f17646o = m(float[].class);
        f17647p = n(float[].class);
        f17648q = m(double[].class);
        f17649r = n(double[].class);
        f17650s = m(Object[].class);
        f17651t = n(Object[].class);
        f17652u = s(o());
        f17653v = (int) (7 & m8);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z7 = true;
        } else {
            z7 = false;
        }
        f17654w = z7;
    }

    private UnsafeUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double A(Object obj, long j8) {
        return f17636e.g(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float B(Object obj, long j8) {
        return f17636e.h(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(Object obj, long j8) {
        return f17636e.i(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long D(long j8) {
        return f17636e.j(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long E(Object obj, long j8) {
        return f17636e.k(obj, j8);
    }

    private static MemoryAccessor F() {
        Unsafe unsafe = f17632a;
        if (unsafe == null) {
            return null;
        }
        if (Android.c()) {
            if (f17634c) {
                return new Android64MemoryAccessor(unsafe);
            }
            if (!f17635d) {
                return null;
            }
            return new Android32MemoryAccessor(unsafe);
        }
        return new JvmMemoryAccessor(unsafe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object G(Object obj, long j8) {
        return f17636e.l(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a */
                public Unsafe run() throws Exception {
                    java.lang.reflect.Field[] declaredFields;
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
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
    public static boolean I() {
        return f17638g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return f17637f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(Throwable th) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void L(Object obj, long j8, boolean z7) {
        f17636e.n(obj, j8, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(Object obj, long j8, boolean z7) {
        P(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(Object obj, long j8, boolean z7) {
        Q(obj, j8, z7 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void O(byte[] bArr, long j8, byte b8) {
        f17636e.o(bArr, f17639h + j8, b8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int C = C(obj, j9);
        int i8 = ((~((int) j8)) & 3) << 3;
        T(obj, j9, ((255 & b8) << i8) | (C & (~(255 << i8))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Object obj, long j8, byte b8) {
        long j9 = (-4) & j8;
        int i8 = (((int) j8) & 3) << 3;
        T(obj, j9, ((255 & b8) << i8) | (C(obj, j9) & (~(255 << i8))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(Object obj, long j8, double d8) {
        f17636e.p(obj, j8, d8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void S(Object obj, long j8, float f8) {
        f17636e.q(obj, j8, f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void T(Object obj, long j8, int i8) {
        f17636e.r(obj, j8, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Object obj, long j8, long j9) {
        f17636e.s(obj, j8, j9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Object obj, long j8, Object obj2) {
        f17636e.t(obj, j8, obj2);
    }

    private static boolean W() {
        MemoryAccessor memoryAccessor = f17636e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.u();
    }

    private static boolean X() {
        MemoryAccessor memoryAccessor = f17636e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.v();
    }

    static /* synthetic */ java.lang.reflect.Field b() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(ByteBuffer byteBuffer) {
        return f17636e.k(byteBuffer, f17652u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T l(Class<T> cls) {
        try {
            return (T) f17632a.allocateInstance(cls);
        } catch (InstantiationException e8) {
            throw new IllegalStateException(e8);
        }
    }

    private static int m(Class<?> cls) {
        if (f17638g) {
            return f17636e.a(cls);
        }
        return -1;
    }

    private static int n(Class<?> cls) {
        if (f17638g) {
            return f17636e.b(cls);
        }
        return -1;
    }

    private static java.lang.reflect.Field o() {
        java.lang.reflect.Field r7;
        if (Android.c() && (r7 = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return r7;
        }
        java.lang.reflect.Field r8 = r(Buffer.class, "address");
        if (r8 == null || r8.getType() != Long.TYPE) {
            return null;
        }
        return r8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(long j8, byte[] bArr, long j9, long j10) {
        f17636e.c(j8, bArr, j9, j10);
    }

    static boolean q(Class<?> cls) {
        if (!Android.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f17633b;
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

    private static java.lang.reflect.Field r(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(java.lang.reflect.Field field) {
        MemoryAccessor memoryAccessor;
        if (field != null && (memoryAccessor = f17636e) != null) {
            return memoryAccessor.m(field);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(Object obj, long j8) {
        return f17636e.d(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Object obj, long j8) {
        if (y(obj, j8) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j8) {
        if (z(obj, j8) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte w(long j8) {
        return f17636e.e(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte x(byte[] bArr, long j8) {
        return f17636e.f(bArr, f17639h + j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte y(Object obj, long j8) {
        return (byte) ((C(obj, (-4) & j8) >>> ((int) (((~j8) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j8) {
        return (byte) ((C(obj, (-4) & j8) >>> ((int) ((j8 & 3) << 3))) & 255);
    }
}
