package ee.mtakso.driver.uicore.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SignUpUtils.kt */
/* loaded from: classes5.dex */
public final class SignUpUtilsKt {
    public static final String a(String str) {
        boolean Q;
        int b02;
        int b03;
        int length;
        CharSequence Y0;
        if (str != null) {
            Q = StringsKt__StringsKt.Q(str, "taxifyDriverPortal_lastKnownHash=", false, 2, null);
            if (Q) {
                b02 = StringsKt__StringsKt.b0(str, "taxifyDriverPortal_lastKnownHash=", 0, false, 6, null);
                String substring = str.substring(b02);
                Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                b03 = StringsKt__StringsKt.b0(substring, ";", 0, false, 6, null);
                if (b03 > 0) {
                    length = StringsKt__StringsKt.b0(substring, ";", 0, false, 6, null);
                } else {
                    length = substring.length();
                }
                String substring2 = substring.substring(33, length);
                Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                Y0 = StringsKt__StringsKt.Y0(new Regex("%22").g(substring2, ""));
                return Y0.toString();
            }
        }
        return null;
    }

    public static final String b(String token) {
        Intrinsics.f(token, "token");
        return "taxifyDriverPortal_lastKnownHash=" + token;
    }
}
