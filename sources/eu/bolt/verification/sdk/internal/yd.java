package eu.bolt.verification.sdk.internal;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.core.rib.camera.view.CameraOverlayView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class yd {

    /* renamed from: a  reason: collision with root package name */
    private final CameraOverlayView f45742a;

    /* renamed from: b  reason: collision with root package name */
    private final DesignImageView f45743b;

    public yd(zd source) {
        Intrinsics.f(source, "source");
        this.f45742a = source.getOverlayView();
        this.f45743b = source.getOverlayImage();
    }

    private final void e(gh ghVar) {
        if (this.f45743b == null) {
            return;
        }
        RectF c8 = c(this.f45742a.getMeasuredWidth(), this.f45742a.getMeasuredHeight(), ghVar);
        ViewGroup.LayoutParams layoutParams = this.f45743b.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) c8.top;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = this.f45742a.getMeasuredHeight() - ((int) c8.bottom);
        int i8 = (int) c8.left;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i8;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = i8;
        this.f45743b.setLayoutParams(layoutParams2);
    }

    public abstract Path a(RectF rectF);

    public final Rect b(gh ghVar, Integer num) {
        RectF c8 = c(this.f45742a.getMeasuredWidth(), this.f45742a.getMeasuredHeight(), ghVar);
        Rect rect = new Rect();
        c8.round(rect);
        this.f45742a.setCutoffPath(a(c8));
        Drawable d8 = d(rect);
        if (d8 != null) {
            this.f45742a.setFrameDrawable(d8);
        }
        this.f45742a.setOverlayColor(num);
        e(ghVar);
        return rect;
    }

    public abstract RectF c(int i8, int i9, gh ghVar);

    public abstract Drawable d(Rect rect);
}
