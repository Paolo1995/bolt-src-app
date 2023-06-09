package io.netty.util.internal;

import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class NativeLibraryLoader {
    private static final boolean DELETE_NATIVE_LIB_AFTER_LOADING;
    private static final boolean TRY_TO_PATCH_SHADED_ID;
    private static final byte[] UNIQUE_ID_BYTES;
    private static final File WORKDIR;
    private static final InternalLogger logger;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class NoexecVolumeDetector {
        private NoexecVolumeDetector() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean canExecuteExecutable(File file) throws IOException {
            Path path;
            Path path2;
            if (PlatformDependent.javaVersion() < 7 || file.canExecute()) {
                return true;
            }
            path = file.toPath();
            Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, new LinkOption[0]);
            EnumSet of = EnumSet.of(PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE);
            if (posixFilePermissions.containsAll(of)) {
                return false;
            }
            EnumSet copyOf = EnumSet.copyOf((Collection) posixFilePermissions);
            copyOf.addAll(of);
            path2 = file.toPath();
            Files.setPosixFilePermissions(path2, copyOf);
            return file.canExecute();
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(NativeLibraryLoader.class);
        logger = internalLoggerFactory;
        UNIQUE_ID_BYTES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes(CharsetUtil.US_ASCII);
        String str = SystemPropertyUtil.get("io.netty.native.workdir");
        if (str != null) {
            File file = new File(str);
            file.mkdirs();
            try {
                file = file.getAbsoluteFile();
            } catch (Exception unused) {
            }
            WORKDIR = file;
            InternalLogger internalLogger = logger;
            internalLogger.debug("-Dio.netty.native.workdir: " + file);
        } else {
            File tmpdir = PlatformDependent.tmpdir();
            WORKDIR = tmpdir;
            internalLoggerFactory.debug("-Dio.netty.native.workdir: " + tmpdir + " (io.netty.tmpdir)");
        }
        boolean z7 = SystemPropertyUtil.getBoolean("io.netty.native.deleteLibAfterLoading", true);
        DELETE_NATIVE_LIB_AFTER_LOADING = z7;
        InternalLogger internalLogger2 = logger;
        internalLogger2.debug("-Dio.netty.native.deleteLibAfterLoading: {}", Boolean.valueOf(z7));
        boolean z8 = SystemPropertyUtil.getBoolean("io.netty.native.tryPatchShadedId", true);
        TRY_TO_PATCH_SHADED_ID = z8;
        internalLogger2.debug("-Dio.netty.native.tryPatchShadedId: {}", Boolean.valueOf(z8));
    }

    private NativeLibraryLoader() {
    }

    private static String calculatePackagePrefix() {
        String name = NativeLibraryLoader.class.getName();
        String replace = "io!netty!util!internal!NativeLibraryLoader".replace('!', '.');
        if (name.endsWith(replace)) {
            return name.substring(0, name.length() - replace.length());
        }
        throw new UnsatisfiedLinkError(String.format("Could not find prefix added to %s to get %s. When shading, only adding a package prefix is supported", replace, name));
    }

    private static byte[] classToByteArray(Class<?> cls) throws ClassNotFoundException {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            name = name.substring(lastIndexOf + 1);
        }
        URL resource = cls.getResource(name + ".class");
        if (resource != null) {
            byte[] bArr = new byte[Spliterator.IMMUTABLE];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
            InputStream inputStream = null;
            try {
                try {
                    inputStream = FirebasePerfUrlConnection.openStream(resource);
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    }
                } catch (IOException e8) {
                    throw new ClassNotFoundException(cls.getName(), e8);
                }
            } finally {
                closeQuietly(inputStream);
                closeQuietly(byteArrayOutputStream);
            }
        } else {
            throw new ClassNotFoundException(cls.getName());
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void load(java.lang.String r11, java.lang.ClassLoader r12) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.NativeLibraryLoader.load(java.lang.String, java.lang.ClassLoader):void");
    }

    public static void loadFirstAvailable(ClassLoader classLoader, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            try {
                load(str, classLoader);
                return;
            } catch (Throwable th) {
                arrayList.add(th);
                logger.debug("Unable to load the library '{}', trying next name...", str, th);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to load any of the given libraries: " + Arrays.toString(strArr));
        ThrowableUtil.addSuppressedAndClear(illegalArgumentException, arrayList);
        throw illegalArgumentException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.netty.util.internal.logging.InternalLogger] */
    private static void loadLibrary(ClassLoader classLoader, String str, boolean z7) {
        try {
            try {
                loadLibraryByHelper(tryToLoadClass(classLoader, NativeLibraryUtil.class), str, z7);
                classLoader = logger;
                classLoader.debug("Successfully loaded the library {}", str);
            } catch (Exception e8) {
                logger.debug("Unable to load the library '{}', trying other loading mechanism.", str, e8);
                NativeLibraryUtil.loadLibrary(str, z7);
                logger.debug("Successfully loaded the library {}", str);
            } catch (UnsatisfiedLinkError e9) {
                logger.debug("Unable to load the library '{}', trying other loading mechanism.", str, e9);
                NativeLibraryUtil.loadLibrary(str, z7);
                logger.debug("Successfully loaded the library {}", str);
            }
        } catch (UnsatisfiedLinkError e10) {
            ThrowableUtil.addSuppressed(e10, (Throwable) classLoader);
            throw e10;
        }
    }

    private static void loadLibraryByHelper(final Class<?> cls, final String str, final boolean z7) throws UnsatisfiedLinkError {
        Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.NativeLibraryLoader.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    Method method = cls.getMethod("loadLibrary", String.class, Boolean.TYPE);
                    method.setAccessible(true);
                    return method.invoke(null, str, Boolean.valueOf(z7));
                } catch (Exception e8) {
                    return e8;
                }
            }
        });
        if (doPrivileged instanceof Throwable) {
            Throwable th = (Throwable) doPrivileged;
            Throwable cause = th.getCause();
            if (cause instanceof UnsatisfiedLinkError) {
                throw ((UnsatisfiedLinkError) cause);
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(th.getMessage());
            unsatisfiedLinkError.initCause(th);
            throw unsatisfiedLinkError;
        }
    }

    static boolean patchShadedLibraryId(InputStream inputStream, OutputStream outputStream, String str, String str2) throws IOException {
        boolean z7;
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byteArrayOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (patchShadedLibraryId(byteArray, str, str2)) {
            z7 = true;
        } else {
            String str3 = "_" + PlatformDependent.normalizedOs() + "_" + PlatformDependent.normalizedArch();
            z7 = str.endsWith(str3) ? patchShadedLibraryId(byteArray, str.substring(0, str.length() - str3.length()), str2) : false;
        }
        outputStream.write(byteArray, 0, byteArray.length);
        return z7;
    }

    private static boolean shouldShadedLibraryIdBePatched(String str) {
        if (TRY_TO_PATCH_SHADED_ID && PlatformDependent.isOsx() && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    private static Class<?> tryToLoadClass(final ClassLoader classLoader, final Class<?> cls) throws ClassNotFoundException {
        try {
            return Class.forName(cls.getName(), false, classLoader);
        } catch (ClassNotFoundException e8) {
            if (classLoader != null) {
                try {
                    final byte[] classToByteArray = classToByteArray(cls);
                    return (Class) AccessController.doPrivileged(new PrivilegedAction<Class<?>>() { // from class: io.netty.util.internal.NativeLibraryLoader.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.security.PrivilegedAction
                        public Class<?> run() {
                            try {
                                Class cls2 = Integer.TYPE;
                                Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls2, cls2);
                                declaredMethod.setAccessible(true);
                                return (Class) declaredMethod.invoke(classLoader, cls.getName(), classToByteArray, 0, Integer.valueOf(classToByteArray.length));
                            } catch (Exception e9) {
                                throw new IllegalStateException("Define class failed!", e9);
                            }
                        }
                    });
                } catch (ClassNotFoundException e9) {
                    ThrowableUtil.addSuppressed(e9, e8);
                    throw e9;
                } catch (Error e10) {
                    ThrowableUtil.addSuppressed(e10, e8);
                    throw e10;
                } catch (RuntimeException e11) {
                    ThrowableUtil.addSuppressed(e11, e8);
                    throw e11;
                }
            }
            throw e8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0028, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean patchShadedLibraryId(byte[] r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.nio.charset.Charset r0 = io.netty.util.CharsetUtil.UTF_8
            byte[] r0 = r9.getBytes(r0)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r8.length
            r4 = -1
            if (r2 >= r3) goto L2b
            int r3 = r8.length
            int r3 = r3 - r2
            int r5 = r0.length
            if (r3 < r5) goto L2b
            r5 = r2
            r3 = 0
        L13:
            int r6 = r0.length
            if (r3 >= r6) goto L28
            int r6 = r5 + 1
            r5 = r8[r5]
            int r7 = r3 + 1
            r3 = r0[r3]
            if (r5 == r3) goto L21
            goto L28
        L21:
            int r3 = r0.length
            if (r7 != r3) goto L25
            goto L2c
        L25:
            r5 = r6
            r3 = r7
            goto L13
        L28:
            int r2 = r2 + 1
            goto L8
        L2b:
            r2 = -1
        L2c:
            if (r2 != r4) goto L36
            io.netty.util.internal.logging.InternalLogger r8 = io.netty.util.internal.NativeLibraryLoader.logger
            java.lang.String r9 = "Was not able to find the ID of the shaded native library {}, can't adjust it."
            r8.debug(r9, r10)
            return r1
        L36:
            r3 = 0
        L37:
            int r4 = r0.length
            if (r3 >= r4) goto L4e
            int r4 = r2 + r3
            byte[] r5 = io.netty.util.internal.NativeLibraryLoader.UNIQUE_ID_BYTES
            java.util.Random r6 = io.netty.util.internal.PlatformDependent.threadLocalRandom()
            int r7 = r5.length
            int r6 = r6.nextInt(r7)
            r5 = r5[r6]
            r8[r4] = r5
            int r3 = r3 + 1
            goto L37
        L4e:
            io.netty.util.internal.logging.InternalLogger r3 = io.netty.util.internal.NativeLibraryLoader.logger
            boolean r4 = r3.isDebugEnabled()
            r5 = 1
            if (r4 == 0) goto L6e
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r10
            r4[r5] = r9
            r9 = 2
            java.lang.String r10 = new java.lang.String
            int r0 = r0.length
            java.nio.charset.Charset r1 = io.netty.util.CharsetUtil.UTF_8
            r10.<init>(r8, r2, r0, r1)
            r4[r9] = r10
            java.lang.String r8 = "Found the ID of the shaded native library {}. Replacing ID part {} with {}"
            r3.debug(r8, r4)
        L6e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.NativeLibraryLoader.patchShadedLibraryId(byte[], java.lang.String, java.lang.String):boolean");
    }
}
