package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes5.dex */
public final class SystemPropertyUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SystemPropertyUtil.class);

    private SystemPropertyUtil() {
    }

    public static boolean contains(String str) {
        if (get(str) != null) {
            return true;
        }
        return false;
    }

    public static String get(String str) {
        return get(str, null);
    }

    public static boolean getBoolean(String str, boolean z7) {
        String str2 = get(str);
        if (str2 == null) {
            return z7;
        }
        String lowerCase = str2.trim().toLowerCase();
        if (lowerCase.isEmpty()) {
            return z7;
        }
        if ("true".equals(lowerCase) || "yes".equals(lowerCase) || "1".equals(lowerCase)) {
            return true;
        }
        if ("false".equals(lowerCase) || "no".equals(lowerCase) || "0".equals(lowerCase)) {
            return false;
        }
        logger.warn("Unable to parse the boolean system property '{}':{} - using the default value: {}", str, lowerCase, Boolean.valueOf(z7));
        return z7;
    }

    public static int getInt(String str, int i8) {
        String str2 = get(str);
        if (str2 == null) {
            return i8;
        }
        String trim = str2.trim();
        try {
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the integer system property '{}':{} - using the default value: {}", str, trim, Integer.valueOf(i8));
            return i8;
        }
    }

    public static long getLong(String str, long j8) {
        String str2 = get(str);
        if (str2 == null) {
            return j8;
        }
        String trim = str2.trim();
        try {
            return Long.parseLong(trim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the long integer system property '{}':{} - using the default value: {}", str, trim, Long.valueOf(j8));
            return j8;
        }
    }

    public static String get(final String str, String str2) {
        ObjectUtil.checkNotNull(str, "key");
        if (!str.isEmpty()) {
            String str3 = null;
            try {
                if (System.getSecurityManager() == null) {
                    str = System.getProperty(str);
                    str3 = str;
                } else {
                    str3 = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.SystemPropertyUtil.1
                        @Override // java.security.PrivilegedAction
                        public String run() {
                            return System.getProperty(str);
                        }
                    });
                }
            } catch (SecurityException e8) {
                logger.warn("Unable to retrieve a system property '{}'; default values will be used.", str, e8);
            }
            return str3 == null ? str2 : str3;
        }
        throw new IllegalArgumentException("key must not be empty.");
    }
}
