package kotlin.text;

import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes5.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public static BigDecimal j(String str) {
        Intrinsics.f(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.f51167b.f(str)) {
                return null;
            }
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Double k(String str) {
        Intrinsics.f(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.f51167b.f(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
