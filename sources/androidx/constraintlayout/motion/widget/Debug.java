package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

@SuppressLint({"LogConditional"})
/* loaded from: classes.dex */
public class Debug {
    public static String a(Context context, int i8) {
        if (i8 != -1) {
            try {
                return context.getResources().getResourceEntryName(i8);
            } catch (Exception unused) {
                return "?" + i8;
            }
        }
        return "UNKNOWN";
    }

    public static String b(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
