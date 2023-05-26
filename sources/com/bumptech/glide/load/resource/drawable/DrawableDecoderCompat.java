package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f10515a = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable a(Context context, int i8, Resources.Theme theme) {
        return c(context, context, i8, theme);
    }

    public static Drawable b(Context context, Context context2, int i8) {
        return c(context, context2, i8, null);
    }

    private static Drawable c(Context context, Context context2, int i8, Resources.Theme theme) {
        try {
            if (f10515a) {
                return e(context2, i8, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e8) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i8);
            }
            throw e8;
        } catch (NoClassDefFoundError unused2) {
            f10515a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i8, theme);
    }

    private static Drawable d(Context context, int i8, Resources.Theme theme) {
        return ResourcesCompat.f(context.getResources(), i8, theme);
    }

    private static Drawable e(Context context, int i8, Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.b(context, i8);
    }
}
