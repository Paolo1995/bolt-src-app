package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.utils.image.ImageSize;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
/* loaded from: classes5.dex */
public final class ImageKt {
    public static final void a(Image image, ImageView imageView, Drawable drawable) {
        Intrinsics.f(image, "<this>");
        Intrinsics.f(imageView, "imageView");
        if (image instanceof Image.Res) {
            imageView.setImageDrawable(AppCompatResources.b(imageView.getContext(), ((Image.Res) image).a()));
        } else if (image instanceof Image.Url) {
            ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).c(new ImageRequest(((Image.Url) image).a(), null, drawable, null, 10, null), imageView);
        } else if (image instanceof Image.DarkLight) {
            Context context = imageView.getContext();
            Intrinsics.e(context, "imageView.context");
            b(e((Image.DarkLight) image, context), imageView, null, 2, null);
        } else if (image instanceof Image.Attr) {
            Context context2 = imageView.getContext();
            Context context3 = imageView.getContext();
            Intrinsics.e(context3, "imageView.context");
            imageView.setImageDrawable(AppCompatResources.b(context2, ContextUtilsKt.d(context3, ((Image.Attr) image).a())));
        }
    }

    public static /* synthetic */ void b(Image image, ImageView imageView, Drawable drawable, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            drawable = null;
        }
        a(image, imageView, drawable);
    }

    public static final void c(Image image, TextView textView, int i8, int i9) {
        Intrinsics.f(image, "<this>");
        Intrinsics.f(textView, "textView");
        if (image instanceof Image.Res) {
            Drawable b8 = AppCompatResources.b(textView.getContext(), ((Image.Res) image).a());
            if (b8 != null) {
                TextViewExtKt.b(textView, b8, Integer.valueOf(i8), Integer.valueOf(i9));
                return;
            }
            throw new IllegalArgumentException("drawable resource not found");
        } else if (image instanceof Image.Url) {
            ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).b(new ImageRequest(((Image.Url) image).a(), new ImageSize(i8, i9), null, null, 12, null), textView, new EndImageTarget(textView, i8, i9));
        } else if (image instanceof Image.DarkLight) {
            Context context = textView.getContext();
            Intrinsics.e(context, "textView.context");
            c(e((Image.DarkLight) image, context), textView, i8, i9);
        } else if (image instanceof Image.Attr) {
            Context context2 = textView.getContext();
            Context context3 = textView.getContext();
            Intrinsics.e(context3, "textView.context");
            Drawable b9 = AppCompatResources.b(context2, ContextUtilsKt.d(context3, ((Image.Attr) image).a()));
            if (b9 != null) {
                TextViewExtKt.b(textView, b9, Integer.valueOf(i8), Integer.valueOf(i9));
                return;
            }
            throw new IllegalArgumentException("drawable resource not found");
        }
    }

    public static final void d(Image image, TextView textView, int i8, int i9) {
        Intrinsics.f(image, "<this>");
        Intrinsics.f(textView, "textView");
        if (image instanceof Image.Res) {
            Drawable b8 = AppCompatResources.b(textView.getContext(), ((Image.Res) image).a());
            if (b8 != null) {
                TextViewExtKt.f(textView, b8, Integer.valueOf(i8), Integer.valueOf(i9));
                return;
            }
            throw new IllegalArgumentException("drawable resource not found");
        } else if (image instanceof Image.Url) {
            ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).b(new ImageRequest(((Image.Url) image).a(), new ImageSize(i8, i9), null, null, 12, null), textView, new StartImageTarget(textView, i8, i9));
        } else if (image instanceof Image.DarkLight) {
            Context context = textView.getContext();
            Intrinsics.e(context, "textView.context");
            d(e((Image.DarkLight) image, context), textView, i8, i9);
        } else if (image instanceof Image.Attr) {
            Context context2 = textView.getContext();
            Context context3 = textView.getContext();
            Intrinsics.e(context3, "textView.context");
            Drawable b9 = AppCompatResources.b(context2, ContextUtilsKt.d(context3, ((Image.Attr) image).a()));
            if (b9 != null) {
                TextViewExtKt.f(textView, b9, Integer.valueOf(i8), Integer.valueOf(i9));
                return;
            }
            throw new IllegalArgumentException("drawable resource not found");
        }
    }

    public static final Image e(Image.DarkLight darkLight, Context context) {
        Intrinsics.f(darkLight, "<this>");
        Intrinsics.f(context, "context");
        if (ContextUtilsKt.a(context, R$attr.A)) {
            return darkLight.b();
        }
        return darkLight.a();
    }
}
