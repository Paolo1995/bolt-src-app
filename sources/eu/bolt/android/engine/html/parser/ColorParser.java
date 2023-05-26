package eu.bolt.android.engine.html.parser;

import android.graphics.Color;
import eu.bolt.android.engine.html.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorParser.kt */
/* loaded from: classes5.dex */
public final class ColorParser {

    /* renamed from: a  reason: collision with root package name */
    public static final ColorParser f36879a = new ColorParser();

    private ColorParser() {
    }

    public static /* synthetic */ Integer b(ColorParser colorParser, String str, Logger logger, int i8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = -1;
        }
        return colorParser.a(str, logger, i8);
    }

    private final int c(String str, Logger logger, int i8) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            Logger.DefaultImpls.a(logger, "Wrong encoded RGB color string provided " + str, null, 2, null);
            return i8;
        }
    }

    private final int d(String str, Logger logger, int i8) {
        try {
            if (str != null) {
                String substring = str.substring(0, 6);
                Intrinsics.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(6);
                Intrinsics.e(substring2, "(this as java.lang.String).substring(startIndex)");
                return Color.parseColor("#" + substring2 + substring);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable unused) {
            Logger.DefaultImpls.a(logger, "Wrong encoded RGBA color string provided " + str, null, 2, null);
            return i8;
        }
    }

    public final Integer a(String str, Logger logger, int i8) {
        Intrinsics.f(logger, "logger");
        if (str == null) {
            return null;
        }
        if (str.length() == 9) {
            String substring = str.substring(1);
            Intrinsics.e(substring, "(this as java.lang.String).substring(startIndex)");
            return Integer.valueOf(d(substring, logger, i8));
        }
        return Integer.valueOf(c(str, logger, i8));
    }
}
