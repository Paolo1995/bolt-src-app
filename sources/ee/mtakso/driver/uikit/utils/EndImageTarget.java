package ee.mtakso.driver.uikit.utils;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import ee.mtakso.driver.uikit.utils.image.ImageCallback;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EndImageTarget.kt */
/* loaded from: classes5.dex */
public final class EndImageTarget implements ImageCallback<TextView> {

    /* renamed from: f  reason: collision with root package name */
    private final TextView f36035f;

    /* renamed from: g  reason: collision with root package name */
    private final int f36036g;

    /* renamed from: h  reason: collision with root package name */
    private final int f36037h;

    public EndImageTarget(TextView textView, int i8, int i9) {
        Intrinsics.f(textView, "textView");
        this.f36035f = textView;
        this.f36036g = i8;
        this.f36037h = i9;
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: e */
    public void b(TextView view, Drawable drawable, Exception exc) {
        Intrinsics.f(view, "view");
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: f */
    public void d(TextView view, Drawable drawable) {
        Intrinsics.f(view, "view");
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: g */
    public void a(TextView view, Drawable drawable) {
        Intrinsics.f(view, "view");
        Intrinsics.f(drawable, "drawable");
        TextViewExtKt.b(view, drawable, Integer.valueOf(this.f36036g), Integer.valueOf(this.f36037h));
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
    /* renamed from: h */
    public void c(TextView view, Drawable drawable) {
        Intrinsics.f(view, "view");
    }
}
