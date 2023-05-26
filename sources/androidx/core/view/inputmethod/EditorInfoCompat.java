package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class EditorInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6075a = new String[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static void a(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i8) {
            editorInfo.setInitialSurroundingSubText(charSequence, i8);
        }
    }

    @NonNull
    public static String[] a(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            if (strArr == null) {
                return f6075a;
            }
            return strArr;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f6075a;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        if (stringArray == null) {
            return f6075a;
        }
        return stringArray;
    }

    private static boolean b(CharSequence charSequence, int i8, int i9) {
        if (i9 != 0) {
            if (i9 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i8));
        }
        return Character.isLowSurrogate(charSequence.charAt(i8));
    }

    private static boolean c(int i8) {
        int i9 = i8 & 4095;
        return i9 == 129 || i9 == 225 || i9 == 18;
    }

    public static void d(@NonNull EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static void e(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i8) {
        int i9;
        int i10;
        Preconditions.g(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(editorInfo, charSequence, i8);
            return;
        }
        int i11 = editorInfo.initialSelStart;
        int i12 = editorInfo.initialSelEnd;
        if (i11 > i12) {
            i9 = i12 - i8;
        } else {
            i9 = i11 - i8;
        }
        if (i11 > i12) {
            i10 = i11 - i8;
        } else {
            i10 = i12 - i8;
        }
        int length = charSequence.length();
        if (i8 >= 0 && i9 >= 0 && i10 <= length) {
            if (c(editorInfo.inputType)) {
                g(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                g(editorInfo, charSequence, i9, i10);
                return;
            } else {
                h(editorInfo, charSequence, i9, i10);
                return;
            }
        }
        g(editorInfo, null, 0, 0);
    }

    public static void f(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(editorInfo, charSequence, 0);
        } else {
            e(editorInfo, charSequence, 0);
        }
    }

    private static void g(EditorInfo editorInfo, CharSequence charSequence, int i8, int i9) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i8);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i9);
    }

    private static void h(EditorInfo editorInfo, CharSequence charSequence, int i8, int i9) {
        int i10;
        CharSequence subSequence;
        int i11 = i9 - i8;
        if (i11 > 1024) {
            i10 = 0;
        } else {
            i10 = i11;
        }
        int i12 = 2048 - i10;
        int min = Math.min(charSequence.length() - i9, i12 - Math.min(i8, (int) (i12 * 0.8d)));
        int min2 = Math.min(i8, i12 - min);
        int i13 = i8 - min2;
        if (b(charSequence, i13, 0)) {
            i13++;
            min2--;
        }
        if (b(charSequence, (i9 + min) - 1, 1)) {
            min--;
        }
        int i14 = min2 + i10 + min;
        if (i10 != i11) {
            subSequence = TextUtils.concat(charSequence.subSequence(i13, i13 + min2), charSequence.subSequence(i9, min + i9));
        } else {
            subSequence = charSequence.subSequence(i13, i14 + i13);
        }
        int i15 = min2 + 0;
        g(editorInfo, subSequence, i15, i10 + i15);
    }
}
