package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class PlatformDependent0 {
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    private static final Object INTERNAL_UNSAFE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    private static final int JAVA_VERSION;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static {
        final ByteBuffer allocateDirect;
        final Unsafe unsafe;
        Field field;
        long j8;
        Constructor<?> constructor;
        boolean z7;
        Method method;
        String str;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(PlatformDependent0.class);
        logger = internalLoggerFactory;
        Throwable explicitNoUnsafeCause0 = explicitNoUnsafeCause0();
        EXPLICIT_NO_UNSAFE_CAUSE = explicitNoUnsafeCause0;
        JAVA_VERSION = javaVersion0();
        IS_ANDROID = isAndroid0();
        IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = explicitTryReflectionSetAccessible0();
        Method method2 = null;
        if (explicitNoUnsafeCause0 != null) {
            allocateDirect = null;
            unsafe = null;
            field = null;
        } else {
            allocateDirect = ByteBuffer.allocateDirect(1);
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField, false);
                        if (trySetAccessible != null) {
                            return trySetAccessible;
                        }
                        return declaredField.get(null);
                    } catch (IllegalAccessException e8) {
                        return e8;
                    } catch (NoClassDefFoundError e9) {
                        return e9;
                    } catch (NoSuchFieldException e10) {
                        return e10;
                    } catch (SecurityException e11) {
                        return e11;
                    }
                }
            });
            if (doPrivileged instanceof Throwable) {
                explicitNoUnsafeCause0 = (Throwable) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: unavailable", explicitNoUnsafeCause0);
                unsafe = null;
            } else {
                unsafe = (Unsafe) doPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: available");
            }
            if (unsafe != null) {
                Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = unsafe.getClass();
                            Class<?> cls2 = Long.TYPE;
                            cls.getDeclaredMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                            return null;
                        } catch (NoSuchMethodException e8) {
                            return e8;
                        } catch (SecurityException e9) {
                            return e9;
                        }
                    }
                });
                if (doPrivileged2 == null) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: available");
                } else {
                    explicitNoUnsafeCause0 = (Throwable) doPrivileged2;
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: unavailable", explicitNoUnsafeCause0);
                    unsafe = null;
                }
            }
            if (unsafe != null) {
                Object doPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Field declaredField = Buffer.class.getDeclaredField("address");
                            if (unsafe.getLong(allocateDirect, unsafe.objectFieldOffset(declaredField)) == 0) {
                                return null;
                            }
                            return declaredField;
                        } catch (NoSuchFieldException e8) {
                            return e8;
                        } catch (SecurityException e9) {
                            return e9;
                        }
                    }
                });
                if (doPrivileged3 instanceof Field) {
                    field = (Field) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: available");
                } else {
                    Throwable th = (Throwable) doPrivileged3;
                    internalLoggerFactory.debug("java.nio.Buffer.address: unavailable", th);
                    unsafe = null;
                    explicitNoUnsafeCause0 = th;
                    field = null;
                }
            } else {
                field = null;
            }
            if (unsafe != null) {
                long arrayIndexScale = unsafe.arrayIndexScale(byte[].class);
                if (arrayIndexScale != 1) {
                    internalLoggerFactory.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", Long.valueOf(arrayIndexScale));
                    explicitNoUnsafeCause0 = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                    unsafe = null;
                }
            }
        }
        UNSAFE_UNAVAILABILITY_CAUSE = explicitNoUnsafeCause0;
        UNSAFE = unsafe;
        if (unsafe == null) {
            ADDRESS_FIELD_OFFSET = -1L;
            BYTE_ARRAY_BASE_OFFSET = -1L;
            UNALIGNED = false;
            DIRECT_BUFFER_CONSTRUCTOR = null;
            ALLOCATE_ARRAY_METHOD = null;
        } else {
            try {
                Object doPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.4
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Constructor<?> declaredConstructor = allocateDirect.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredConstructor, true);
                            if (trySetAccessible != null) {
                                return trySetAccessible;
                            }
                            return declaredConstructor;
                        } catch (NoSuchMethodException e8) {
                            return e8;
                        } catch (SecurityException e9) {
                            return e9;
                        }
                    }
                });
                if (doPrivileged4 instanceof Constructor) {
                    j8 = unsafe.allocateMemory(1L);
                    try {
                        ((Constructor) doPrivileged4).newInstance(Long.valueOf(j8), 1);
                        constructor = (Constructor) doPrivileged4;
                        internalLoggerFactory.debug("direct buffer constructor: available");
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        constructor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (j8 != -1) {
                            UNSAFE.freeMemory(j8);
                        }
                        throw th;
                    }
                } else {
                    internalLoggerFactory.debug("direct buffer constructor: unavailable", (Throwable) doPrivileged4);
                    constructor = null;
                    j8 = -1;
                }
                if (j8 != -1) {
                    UNSAFE.freeMemory(j8);
                }
                DIRECT_BUFFER_CONSTRUCTOR = constructor;
                ADDRESS_FIELD_OFFSET = objectFieldOffset(field);
                BYTE_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
                Object doPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.5
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        String str2;
                        try {
                            Class<?> cls = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader());
                            int javaVersion = PlatformDependent0.javaVersion();
                            if (javaVersion >= 9) {
                                if (javaVersion < 11) {
                                    str2 = "unaligned";
                                } else {
                                    str2 = "UNALIGNED";
                                }
                                try {
                                    Field declaredField = cls.getDeclaredField(str2);
                                    if (declaredField.getType() == Boolean.TYPE) {
                                        Unsafe unsafe2 = PlatformDependent0.UNSAFE;
                                        return Boolean.valueOf(unsafe2.getBoolean(unsafe2.staticFieldBase(declaredField), unsafe2.staticFieldOffset(declaredField)));
                                    }
                                } catch (NoSuchFieldException unused2) {
                                }
                            }
                            Method declaredMethod = cls.getDeclaredMethod("unaligned", new Class[0]);
                            Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredMethod, true);
                            if (trySetAccessible != null) {
                                return trySetAccessible;
                            }
                            return declaredMethod.invoke(null, new Object[0]);
                        } catch (ClassNotFoundException e8) {
                            return e8;
                        } catch (IllegalAccessException e9) {
                            return e9;
                        } catch (NoSuchMethodException e10) {
                            return e10;
                        } catch (SecurityException e11) {
                            return e11;
                        } catch (InvocationTargetException e12) {
                            return e12;
                        }
                    }
                });
                if (doPrivileged5 instanceof Boolean) {
                    z7 = ((Boolean) doPrivileged5).booleanValue();
                    logger.debug("java.nio.Bits.unaligned: available, {}", Boolean.valueOf(z7));
                } else {
                    boolean matches = SystemPropertyUtil.get("os.arch", "").matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                    logger.debug("java.nio.Bits.unaligned: unavailable {}", Boolean.valueOf(matches), (Throwable) doPrivileged5);
                    z7 = matches;
                }
                UNALIGNED = z7;
                if (javaVersion() >= 9) {
                    final Object doPrivileged6 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.6
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                return PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe").getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
                            } catch (Throwable th3) {
                                return th3;
                            }
                        }
                    });
                    if (!(doPrivileged6 instanceof Throwable)) {
                        Object e8 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.7
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                try {
                                    return doPrivileged6.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, Integer.TYPE);
                                } catch (NoSuchMethodException e9) {
                                    return e9;
                                } catch (SecurityException e10) {
                                    return e10;
                                }
                            }
                        });
                        if (e8 instanceof Method) {
                            try {
                                Method method3 = (Method) e8;
                                byte[] bArr = (byte[]) method3.invoke(doPrivileged6, Byte.TYPE, 8);
                                method2 = method3;
                            } catch (IllegalAccessException e9) {
                                e8 = e9;
                            } catch (InvocationTargetException e10) {
                                e8 = e10;
                            }
                        }
                        Object obj = e8;
                        method = doPrivileged6;
                        doPrivileged6 = obj;
                    } else {
                        method = null;
                    }
                    if (doPrivileged6 instanceof Throwable) {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable", (Throwable) doPrivileged6);
                    } else {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available");
                    }
                } else {
                    logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
                    method = null;
                }
                ALLOCATE_ARRAY_METHOD = method2;
                method2 = method;
            } catch (Throwable th3) {
                th = th3;
                j8 = -1;
            }
        }
        INTERNAL_UNSAFE = method2;
        InternalLogger internalLogger = logger;
        if (DIRECT_BUFFER_CONSTRUCTOR != null) {
            str = "available";
        } else {
            str = "unavailable";
        }
        internalLogger.debug("java.nio.DirectByteBuffer.<init>(long, int): {}", str);
    }

    private PlatformDependent0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addressSize() {
        return UNSAFE.addressSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer allocateDirectNoCleaner(int i8) {
        return newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, i8)), i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] allocateUninitializedArray(int i8) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(i8));
        } catch (IllegalAccessException e8) {
            throw new Error(e8);
        } catch (InvocationTargetException e9) {
            throw new Error(e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMemory(long j8, long j9, long j10) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(j8, j9, j10);
        } else {
            UNSAFE.copyMemory(j8, j9, j10);
        }
    }

    private static void copyMemoryWithSafePointPolling(long j8, long j9, long j10) {
        while (j10 > 0) {
            long min = Math.min(j10, 1048576L);
            UNSAFE.copyMemory(j8, j9, min);
            j10 -= min;
            j8 += min;
            j9 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        int i11 = i10 & 7;
        long j8 = BYTE_ARRAY_BASE_OFFSET + i8;
        long j9 = i9 - i8;
        if (i10 >= 8) {
            long j10 = i11 + j8;
            long j11 = (j8 - 8) + i10;
            while (j11 >= j10) {
                Unsafe unsafe = UNSAFE;
                long j12 = j10;
                if (unsafe.getLong(bArr, j11) != unsafe.getLong(bArr2, j11 + j9)) {
                    return false;
                }
                j11 -= 8;
                j10 = j12;
            }
        }
        if (i11 >= 4) {
            i11 -= 4;
            long j13 = i11 + j8;
            Unsafe unsafe2 = UNSAFE;
            if (unsafe2.getInt(bArr, j13) != unsafe2.getInt(bArr2, j13 + j9)) {
                return false;
            }
        }
        long j14 = j9 + j8;
        if (i11 >= 2) {
            Unsafe unsafe3 = UNSAFE;
            if (unsafe3.getChar(bArr, j8) != unsafe3.getChar(bArr2, j14)) {
                return false;
            }
            if (i11 != 2 && unsafe3.getByte(bArr, j8 + 2) != unsafe3.getByte(bArr2, j14 + 2)) {
                return false;
            }
            return true;
        }
        if (i11 != 0) {
            Unsafe unsafe4 = UNSAFE;
            if (unsafe4.getByte(bArr, j8) != unsafe4.getByte(bArr2, j14)) {
                return false;
            }
        }
        return true;
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean z7 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z7));
        if (z7) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        String str = "io.netty.tryUnsafe";
        if (!SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            str = "org.jboss.netty.tryUnsafe";
        }
        if (!SystemPropertyUtil.getBoolean(str, true)) {
            String str2 = "sun.misc.Unsafe: unavailable (" + str + ")";
            internalLogger.debug(str2);
            return new UnsupportedOperationException(str2);
        }
        return null;
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        boolean z7;
        if (javaVersion() < 9) {
            z7 = true;
        } else {
            z7 = false;
        }
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeMemory(long j8) {
        UNSAFE.freeMemory(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j8) {
        return UNSAFE.getByte(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(Object obj, long j8) {
        return UNSAFE.getInt(obj, j8);
    }

    private static long getLong(Object obj, long j8) {
        return UNSAFE.getLong(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getObject(Object obj, long j8) {
        return UNSAFE.getObject(obj, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(long j8) {
        return UNSAFE.getShort(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasAllocateArrayMethod() {
        if (ALLOCATE_ARRAY_METHOD != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasDirectBufferNoCleanerConstructor() {
        if (DIRECT_BUFFER_CONSTRUCTOR != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasUnsafe() {
        if (UNSAFE != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAscii(byte[] bArr, int i8, int i9) {
        boolean z7;
        boolean z8;
        boolean z9;
        int i10;
        boolean z10;
        boolean z11;
        long j8 = BYTE_ARRAY_BASE_OFFSET + i8;
        int i11 = i9 & 7;
        long j9 = i11 + j8;
        int i12 = -1028477387;
        for (long j10 = (j8 - 8) + i9; j10 >= j9; j10 -= 8) {
            i12 = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j10), i12);
        }
        if (i11 == 0) {
            return i12;
        }
        boolean z12 = false;
        if (i11 != 2) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i11 != 4) {
            z8 = true;
        } else {
            z8 = false;
        }
        boolean z13 = z7 & z8;
        if (i11 != 6) {
            z9 = true;
        } else {
            z9 = false;
        }
        boolean z14 = z13 & z9;
        int i13 = 461845907;
        if (z14) {
            i12 = (i12 * (-862048943)) + hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j8));
            j8++;
            i10 = 461845907;
        } else {
            i10 = -862048943;
        }
        if (i11 != 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 != 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z15 = z10 & z11;
        if (i11 != 5) {
            z12 = true;
        }
        if (z12 & z15) {
            i12 = (i12 * i10) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j8));
            if (i10 != -862048943) {
                i13 = -862048943;
            }
            j8 += 2;
            i10 = i13;
        }
        if (i11 >= 4) {
            return (i12 * i10) + hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j8));
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiCompute(long j8, int i8) {
        return (i8 * (-862048943)) + (hashCodeAsciiSanitize((int) j8) * 461845907) + ((int) ((j8 & 2242545357458243584L) >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(byte b8) {
        return b8 & 31;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(int i8) {
        return i8 & 522133279;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCodeAsciiSanitize(short s7) {
        return s7 & 7967;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean equals = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (equals) {
            logger.debug("Platform: Android");
        }
        return equals;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExplicitNoUnsafe() {
        if (EXPLICIT_NO_UNSAFE_CAUSE != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUnaligned() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isZero(byte[] bArr, int i8, int i9) {
        if (i9 <= 0) {
            return true;
        }
        long j8 = BYTE_ARRAY_BASE_OFFSET + i8;
        int i10 = i9 & 7;
        long j9 = i10 + j8;
        for (long j10 = (j8 - 8) + i9; j10 >= j9; j10 -= 8) {
            if (UNSAFE.getLong(bArr, j10) != 0) {
                return false;
            }
        }
        if (i10 >= 4) {
            i10 -= 4;
            if (UNSAFE.getInt(bArr, i10 + j8) != 0) {
                return false;
            }
        }
        if (i10 >= 2) {
            if (UNSAFE.getChar(bArr, j8) == 0 && (i10 == 2 || bArr[i8 + 2] == 0)) {
                return true;
            }
            return false;
        } else if (bArr[i8] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersionFromJavaSpecificationVersion;
        if (isAndroid0()) {
            majorVersionFromJavaSpecificationVersion = 6;
        } else {
            majorVersionFromJavaSpecificationVersion = majorVersionFromJavaSpecificationVersion();
        }
        logger.debug("Java version: {}", Integer.valueOf(majorVersionFromJavaSpecificationVersion));
        return majorVersionFromJavaSpecificationVersion;
    }

    static int majorVersion(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i8 = 0; i8 < split.length; i8++) {
            iArr[i8] = Integer.parseInt(split[i8]);
        }
        int i9 = iArr[0];
        if (i9 == 1) {
            return iArr[1];
        }
        return i9;
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    static ByteBuffer newDirectBuffer(long j8, int i8) {
        ObjectUtil.checkPositiveOrZero(i8, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j8), Integer.valueOf(i8));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(long j8, byte b8) {
        UNSAFE.putByte(j8, b8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(long j8, int i8) {
        UNSAFE.putInt(j8, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(long j8, long j9) {
        UNSAFE.putLong(j8, j9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putObject(Object obj, long j8, Object obj2) {
        UNSAFE.putObject(obj, j8, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(long j8, short s7) {
        UNSAFE.putShort(j8, s7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i8) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i8), i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMemory(long j8, long j9, byte b8) {
        UNSAFE.setMemory(j8, j9, b8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean unalignedAccess() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i8) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(long j8) {
        return UNSAFE.getInt(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j8) {
        return UNSAFE.getLong(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i8) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(byte[] bArr, int i8, byte b8) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + i8, b8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(byte[] bArr, int i8, int i9) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(byte[] bArr, int i8, long j8) {
        UNSAFE.putLong(bArr, BYTE_ARRAY_BASE_OFFSET + i8, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(byte[] bArr, int i8, short s7) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + i8, s7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMemory(Object obj, long j8, long j9, byte b8) {
        UNSAFE.setMemory(obj, j8, j9, b8);
    }

    private static void copyMemoryWithSafePointPolling(Object obj, long j8, Object obj2, long j9, long j10) {
        long j11 = j8;
        long j12 = j9;
        long j13 = j10;
        while (j13 > 0) {
            long min = Math.min(j13, 1048576L);
            UNSAFE.copyMemory(obj, j11, obj2, j12, min);
            j13 -= min;
            j11 += min;
            j12 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i8) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i8) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMemory(Object obj, long j8, Object obj2, long j9, long j10) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(obj, j8, obj2, j9, j10);
        } else {
            UNSAFE.copyMemory(obj, j8, obj2, j9, j10);
        }
    }
}
