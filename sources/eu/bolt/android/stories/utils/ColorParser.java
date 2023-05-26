package eu.bolt.android.stories.utils;

import android.graphics.Color;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorParser.kt */
/* loaded from: classes5.dex */
public final class ColorParser {

    /* renamed from: a  reason: collision with root package name */
    public static final ColorParser f37612a = new ColorParser();

    private ColorParser() {
    }

    public static /* synthetic */ Integer b(ColorParser colorParser, String str, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = -1;
        }
        return colorParser.a(str, i8);
    }

    private final int c(String str, int i8) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            Kalev.b("Wrong encoded RGB color string provided " + str);
            return i8;
        }
    }

    private final int d(String str, int i8) {
        try {
            String substring = str.substring(0, 6);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = str.substring(6);
            Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
            return Color.parseColor("#" + substring2 + substring);
        } catch (Throwable unused) {
            Kalev.b("Wrong encoded RGBA color string provided " + str);
            return i8;
        }
    }

    public final Integer a(String str, int i8) {
        if (str == null) {
            return null;
        }
        if (str.length() == 9) {
            String substring = str.substring(1);
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            return Integer.valueOf(d(substring, i8));
        }
        return Integer.valueOf(c(str, i8));
    }
}
