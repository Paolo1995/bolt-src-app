package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;

/* loaded from: classes.dex */
public final class PaintCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Pair<Rect, Rect>> f5741a = new ThreadLocal<>();

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean a(Paint paint, String str) {
            boolean hasGlyph;
            hasGlyph = paint.hasGlyph(str);
            return hasGlyph;
        }
    }

    private PaintCompat() {
    }

    public static boolean a(@NonNull Paint paint, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("\udfffd");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f8 = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i8 = 0;
            while (i8 < length) {
                int charCount = Character.charCount(str.codePointAt(i8)) + i8;
                f8 += paint.measureText(str, i8, charCount);
                i8 = charCount;
            }
            if (measureText3 >= f8) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> b8 = b();
        paint.getTextBounds("\udfffd", 0, 2, b8.f5908a);
        paint.getTextBounds(str, 0, length, b8.f5909b);
        return !b8.f5908a.equals(b8.f5909b);
    }

    private static Pair<Rect, Rect> b() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = f5741a;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        pair.f5908a.setEmpty();
        pair.f5909b.setEmpty();
        return pair;
    }
}
