package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.core.rib.camera.view.CameraOverlayView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class jn extends ConstraintLayout implements zd {
    private final kg E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jn(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        kg a8 = kg.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.E = a8;
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        setKeepScreenOn(true);
        uq.L(this);
        uq.d0(this);
    }

    public /* synthetic */ jn(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final kg getBinding() {
        return this.E;
    }

    @Override // eu.bolt.verification.sdk.internal.zd
    public DesignImageView getOverlayImage() {
        DesignImageView designImageView = this.E.f43862c;
        Intrinsics.e(designImageView, "binding.cameraOverlayImageView");
        return designImageView;
    }

    @Override // eu.bolt.verification.sdk.internal.zd
    public CameraOverlayView getOverlayView() {
        CameraOverlayView cameraOverlayView = this.E.f43863d;
        Intrinsics.e(cameraOverlayView, "binding.cameraOverlayView");
        return cameraOverlayView;
    }
}
