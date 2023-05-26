package ee.mtakso.driver.uikit.utils;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorParser.kt */
/* loaded from: classes5.dex */
public final class ColorParser {

    /* renamed from: a  reason: collision with root package name */
    public static final ColorParser f36034a = new ColorParser();

    private ColorParser() {
    }

    public final int a(String hexColor) {
        Intrinsics.f(hexColor, "hexColor");
        if (hexColor.charAt(0) == '#') {
            int length = hexColor.length();
            if (length != 7) {
                if (length == 9) {
                    String substring = hexColor.substring(1, 7);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String substring2 = hexColor.substring(7);
                    Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                    return android.graphics.Color.parseColor("#" + substring2 + substring);
                }
                throw new IllegalArgumentException("Color (" + hexColor + ") should start with '#'");
            }
            return android.graphics.Color.parseColor(hexColor);
        }
        throw new IllegalArgumentException("Color (" + hexColor + ") should start with '#'");
    }
}
