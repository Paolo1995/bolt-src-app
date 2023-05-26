package ee.mtakso.driver.uikit.utils.html;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import ee.mtakso.driver.uikit.utils.image.ImageCallback;
import ee.mtakso.driver.uikit.utils.image.ImageSize;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlImageGetterTarget.kt */
/* loaded from: classes5.dex */
public final class HtmlImageGetterTarget extends BitmapDrawable implements ImageCallback<TextView> {

    /* renamed from: f  reason: collision with root package name */
    private final ImageSize f36070f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f36071g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlImageGetterTarget(Resources resources, ImageSize imageSize) {
        super(resources, Bitmap.createBitmap(imageSize.d(), imageSize.c(), Bitmap.Config.ARGB_8888));
        Intrinsics.f(resources, "resources");
        Intrinsics.f(imageSize, "imageSize");
        this.f36070f = imageSize;
    }

    private final void i(TextView textView, Drawable drawable) {
        this.f36071g = drawable;
        int d8 = this.f36070f.d();
        int c8 = this.f36070f.c();
        drawable.setBounds(0, 0, d8, c8);
        setBounds(0, 0, d8, c8);
        textView.invalidate();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        Drawable drawable = this.f36071g;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: e */
    public void b(TextView view, Drawable drawable, Exception exc) {
        Intrinsics.f(view, "view");
        Kalev.d("Failed to download image " + exc);
        if (drawable != null) {
            i(view, drawable);
        }
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: f */
    public void d(TextView view, Drawable drawable) {
        Intrinsics.f(view, "view");
        if (drawable != null) {
            i(view, drawable);
        }
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: g */
    public void a(TextView view, Drawable drawable) {
        Intrinsics.f(view, "view");
        Intrinsics.f(drawable, "drawable");
        i(view, drawable);
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: h */
    public void c(TextView view, Drawable drawable) {
        Intrinsics.f(view, "view");
        if (drawable != null) {
            i(view, drawable);
        }
    }
}
