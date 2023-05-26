package io.netty.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/* loaded from: classes5.dex */
public final class ThrowableUtil {
    private ThrowableUtil() {
    }

    public static void addSuppressed(Throwable th, Throwable th2) {
        if (haveSuppressed()) {
            th.addSuppressed(th2);
        }
    }

    public static void addSuppressedAndClear(Throwable th, List<Throwable> list) {
        addSuppressed(th, list);
        list.clear();
    }

    public static boolean haveSuppressed() {
        if (PlatformDependent.javaVersion() >= 7) {
            return true;
        }
        return false;
    }

    public static String stackTraceToString(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        try {
            return new String(byteArrayOutputStream.toByteArray());
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static <T extends Throwable> T unknownStackTrace(T t7, Class<?> cls, String str) {
        t7.setStackTrace(new StackTraceElement[]{new StackTraceElement(cls.getName(), str, null, -1)});
        return t7;
    }

    public static void addSuppressed(Throwable th, List<Throwable> list) {
        for (Throwable th2 : list) {
            addSuppressed(th, th2);
        }
    }
}
