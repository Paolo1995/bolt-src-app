package ee.mtakso.driver.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: StringUtils.kt */
/* loaded from: classes5.dex */
public final class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final StringUtils f36325a = new StringUtils();

    private StringUtils() {
    }

    public static final String a(String str, String str2) {
        boolean z7;
        boolean v7;
        if (str != null) {
            boolean z8 = true;
            if (str.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7 && str2 != null) {
                if (str2.length() != 0) {
                    z8 = false;
                }
                if (!z8) {
                    v7 = StringsKt__StringsJVMKt.v(str, str2, false, 2, null);
                    if (v7) {
                        String substring = str.substring(0, str.length() - str2.length());
                        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        return substring;
                    }
                    return str;
                }
                return str;
            }
            return str;
        }
        return str;
    }
}
