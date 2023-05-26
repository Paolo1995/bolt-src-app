package eu.bolt.logger.ext;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggingExtension.kt */
/* loaded from: classes5.dex */
public final class LoggingExtensionKt {
    public static final String a(Object obj) {
        Intrinsics.f(obj, "<this>");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.e(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    public static final String b(Object obj) {
        Intrinsics.f(obj, "<this>");
        String hexString = Integer.toHexString(obj.hashCode());
        Intrinsics.e(hexString, "toHexString(this.hashCode())");
        return hexString;
    }

    public static final String c(Object obj) {
        Intrinsics.f(obj, "<this>");
        return a(obj) + '#' + b(obj);
    }
}
