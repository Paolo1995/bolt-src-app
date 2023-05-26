package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.camera.view.PreviewView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;
import eu.bolt.verification.core.rib.camera.view.CameraOverlayView;

/* loaded from: classes5.dex */
public final class kg implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43860a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f43861b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignImageView f43862c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CameraOverlayView f43863d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final PreviewView f43864e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DesignTextView f43865f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageButton f43866g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f43867h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final View f43868i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final DesignToolbarView f43869j;

    private kg(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull DesignImageView designImageView, @NonNull CameraOverlayView cameraOverlayView, @NonNull PreviewView previewView, @NonNull DesignTextView designTextView, @NonNull ImageButton imageButton, @NonNull FrameLayout frameLayout2, @NonNull View view2, @NonNull DesignToolbarView designToolbarView) {
        this.f43860a = view;
        this.f43861b = frameLayout;
        this.f43862c = designImageView;
        this.f43863d = cameraOverlayView;
        this.f43864e = previewView;
        this.f43865f = designTextView;
        this.f43866g = imageButton;
        this.f43867h = frameLayout2;
        this.f43868i = view2;
        this.f43869j = designToolbarView;
    }

    @NonNull
    public static kg a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.rib_verification_camera, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static kg b(@NonNull View view) {
        View a8;
        int i8 = R$id.bottomPanel;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i8);
        if (frameLayout != null) {
            i8 = R$id.cameraOverlayImageView;
            DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
            if (designImageView != null) {
                i8 = R$id.cameraOverlayView;
                CameraOverlayView cameraOverlayView = (CameraOverlayView) ViewBindings.a(view, i8);
                if (cameraOverlayView != null) {
                    i8 = R$id.cameraPreview;
                    PreviewView previewView = (PreviewView) ViewBindings.a(view, i8);
                    if (previewView != null) {
                        i8 = R$id.A;
                        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
                        if (designTextView != null) {
                            i8 = R$id.flashlight;
                            ImageButton imageButton = (ImageButton) ViewBindings.a(view, i8);
                            if (imageButton != null) {
                                i8 = R$id.progressContainer;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.a(view, i8);
                                if (frameLayout2 != null && (a8 = ViewBindings.a(view, (i8 = R$id.takePicture))) != null) {
                                    i8 = R$id.f41726k1;
                                    DesignToolbarView designToolbarView = (DesignToolbarView) ViewBindings.a(view, i8);
                                    if (designToolbarView != null) {
                                        return new kg(view, frameLayout, designImageView, cameraOverlayView, previewView, designTextView, imageButton, frameLayout2, a8, designToolbarView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f43860a;
    }
}
