package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;
import eu.bolt.verification.core.rib.camera.view.CameraOverlayView;

/* loaded from: classes5.dex */
public final class xa implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f45639a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CameraOverlayView f45640b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignImageView f45641c;

    private xa(@NonNull FrameLayout frameLayout, @NonNull CameraOverlayView cameraOverlayView, @NonNull DesignImageView designImageView) {
        this.f45639a = frameLayout;
        this.f45640b = cameraOverlayView;
        this.f45641c = designImageView;
    }

    @NonNull
    public static xa b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.item_media_preview, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static xa c(@NonNull View view) {
        int i8 = R$id.cameraOverlayView;
        CameraOverlayView cameraOverlayView = (CameraOverlayView) ViewBindings.a(view, i8);
        if (cameraOverlayView != null) {
            i8 = R$id.f41727l0;
            DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
            if (designImageView != null) {
                return new xa((FrameLayout) view, cameraOverlayView, designImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f45639a;
    }
}
