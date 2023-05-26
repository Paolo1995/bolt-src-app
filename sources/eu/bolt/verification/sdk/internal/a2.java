package eu.bolt.verification.sdk.internal;

import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a2 {

    /* renamed from: a */
    public static final a2 f41941a = new a2();

    private a2() {
    }

    public static /* synthetic */ Integer a(a2 a2Var, String str, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = -1;
        }
        return a2Var.b(str, i8);
    }

    private final int c(String str, int i8) {
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            t3.c("Wrong encoded RGB color string provided " + str, null, 2, null);
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
            t3.c("Wrong encoded RGBA color string provided " + str, null, 2, null);
            return i8;
        }
    }

    public final Integer b(String str, int i8) {
        int c8;
        if (str == null) {
            return null;
        }
        if (str.length() == 9) {
            String substring = str.substring(1);
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            c8 = d(substring, i8);
        } else {
            c8 = c(str, i8);
        }
        return Integer.valueOf(c8);
    }
}
