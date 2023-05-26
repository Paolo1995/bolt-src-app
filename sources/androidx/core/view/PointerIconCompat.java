package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class PointerIconCompat {

    /* renamed from: a  reason: collision with root package name */
    private final PointerIcon f5958a;

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static PointerIcon a(Bitmap bitmap, float f8, float f9) {
            return PointerIcon.create(bitmap, f8, f9);
        }

        static PointerIcon b(Context context, int i8) {
            return PointerIcon.getSystemIcon(context, i8);
        }

        static PointerIcon c(Resources resources, int i8) {
            return PointerIcon.load(resources, i8);
        }
    }

    private PointerIconCompat(PointerIcon pointerIcon) {
        this.f5958a = pointerIcon;
    }

    @NonNull
    public static PointerIconCompat b(@NonNull Context context, int i8) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(Api24Impl.b(context, i8));
        }
        return new PointerIconCompat(null);
    }

    public Object a() {
        return this.f5958a;
    }
}
