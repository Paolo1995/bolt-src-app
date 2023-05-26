package io.netty.util;

import java.util.Arrays;

@Deprecated
/* loaded from: classes5.dex */
public class ResourceLeakException extends RuntimeException {
    private final StackTraceElement[] cachedStackTrace = getStackTrace();

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceLeakException)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException) obj).cachedStackTrace);
    }

    public int hashCode() {
        int i8 = 0;
        for (StackTraceElement stackTraceElement : this.cachedStackTrace) {
            i8 = (i8 * 31) + stackTraceElement.hashCode();
        }
        return i8;
    }
}
