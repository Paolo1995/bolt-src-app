package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class TypedArrayUtils {
    private TypedArrayUtils() {
    }

    public static boolean a(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8, boolean z7) {
        if (!j(xmlPullParser, str)) {
            return z7;
        }
        return typedArray.getBoolean(i8, z7);
    }

    public static int b(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8, int i9) {
        if (!j(xmlPullParser, str)) {
            return i9;
        }
        return typedArray.getColor(i8, i9);
    }

    public static ColorStateList c(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, Resources.Theme theme, @NonNull String str, int i8) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i8, typedValue);
            int i9 = typedValue.type;
            if (i9 != 2) {
                if (i9 >= 28 && i9 <= 31) {
                    return d(typedValue);
                }
                return ColorStateListInflaterCompat.d(typedArray.getResources(), typedArray.getResourceId(i8, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i8 + ": " + typedValue);
        }
        return null;
    }

    @NonNull
    private static ColorStateList d(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat e(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, Resources.Theme theme, @NonNull String str, int i8, int i9) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i8, typedValue);
            int i10 = typedValue.type;
            if (i10 >= 28 && i10 <= 31) {
                return ComplexColorCompat.b(typedValue.data);
            }
            ComplexColorCompat g8 = ComplexColorCompat.g(typedArray.getResources(), typedArray.getResourceId(i8, 0), theme);
            if (g8 != null) {
                return g8;
            }
        }
        return ComplexColorCompat.b(i9);
    }

    public static float f(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8, float f8) {
        if (!j(xmlPullParser, str)) {
            return f8;
        }
        return typedArray.getFloat(i8, f8);
    }

    public static int g(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8, int i9) {
        if (!j(xmlPullParser, str)) {
            return i9;
        }
        return typedArray.getInt(i8, i9);
    }

    public static int h(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8, int i9) {
        if (!j(xmlPullParser, str)) {
            return i9;
        }
        return typedArray.getResourceId(i8, i9);
    }

    public static String i(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i8);
    }

    public static boolean j(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static TypedArray k(@NonNull Resources resources, Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue l(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i8);
    }
}
