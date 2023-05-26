package eu.bolt.verification.sdk.internal;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u8 extends CustomViewTarget<ImageView, Drawable> {

    /* renamed from: l  reason: collision with root package name */
    private final Integer f45341l;

    /* renamed from: m  reason: collision with root package name */
    private final Integer f45342m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u8(ImageView imageView, Integer num, Integer num2) {
        super(imageView);
        Intrinsics.f(imageView, "imageView");
        this.f45341l = num;
        this.f45342m = num2;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void i(Drawable drawable) {
        if (drawable != null) {
            ImageView h8 = h();
            Intrinsics.e(h8, "getView()");
            h8.setImageDrawable(drawable);
        }
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    protected void m(Drawable drawable) {
        if (drawable != null) {
            ImageView h8 = h();
            Intrinsics.e(h8, "getView()");
            h8.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.CustomViewTarget
    public void n(Drawable drawable) {
        Integer num;
        if (drawable != null && (num = this.f45342m) != null) {
            drawable = a6.a(drawable, num.intValue());
        }
        if (drawable != null) {
            ImageView h8 = h();
            Intrinsics.e(h8, "getView()");
            h8.setImageDrawable(drawable);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: p */
    public void e(Drawable resource, Transition<? super Drawable> transition) {
        Intrinsics.f(resource, "resource");
        Integer num = this.f45341l;
        if (num != null) {
            resource = a6.a(resource, num.intValue());
        }
        h().setImageDrawable(resource);
    }
}
