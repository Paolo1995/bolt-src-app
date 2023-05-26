package org.slf4j.helpers;

import java.io.PrintStream;

/* loaded from: classes5.dex */
public final class Util {

    /* renamed from: a  reason: collision with root package name */
    private static ClassContextSecurityManager f52855a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f52856b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ClassContextSecurityManager extends SecurityManager {
        private ClassContextSecurityManager() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private Util() {
    }

    public static Class<?> a() {
        int i8;
        ClassContextSecurityManager b8 = b();
        if (b8 == null) {
            return null;
        }
        Class<?>[] classContext = b8.getClassContext();
        String name = Util.class.getName();
        int i9 = 0;
        while (i9 < classContext.length && !name.equals(classContext[i9].getName())) {
            i9++;
        }
        if (i9 < classContext.length && (i8 = i9 + 2) < classContext.length) {
            return classContext[i8];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    private static ClassContextSecurityManager b() {
        ClassContextSecurityManager classContextSecurityManager = f52855a;
        if (classContextSecurityManager != null) {
            return classContextSecurityManager;
        }
        if (f52856b) {
            return null;
        }
        ClassContextSecurityManager e8 = e();
        f52855a = e8;
        f52856b = true;
        return e8;
    }

    public static final void c(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void d(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    private static ClassContextSecurityManager e() {
        try {
            return new ClassContextSecurityManager();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean f(String str) {
        String g8 = g(str);
        if (g8 == null) {
            return false;
        }
        return g8.equalsIgnoreCase("true");
    }

    public static String g(String str) {
        if (str != null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("null input");
    }
}
