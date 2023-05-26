package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class k4 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43811a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignTextView f43812b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignTextView f43813c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f43814d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f43815e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f43816f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DesignImageView f43817g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final DesignTextView f43818h;

    private k4(@NonNull View view, @NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2, @NonNull View view2, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull DesignImageView designImageView, @NonNull DesignTextView designTextView3) {
        this.f43811a = view;
        this.f43812b = designTextView;
        this.f43813c = designTextView2;
        this.f43814d = view2;
        this.f43815e = constraintLayout;
        this.f43816f = frameLayout;
        this.f43817g = designImageView;
        this.f43818h = designTextView3;
    }

    @NonNull
    public static k4 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_card_view, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static k4 b(@NonNull View view) {
        View a8;
        int i8 = R$id.actionText;
        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
        if (designTextView != null) {
            i8 = R$id.body;
            DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
            if (designTextView2 != null && (a8 = ViewBindings.a(view, (i8 = R$id.clickableArea))) != null) {
                i8 = R$id.f41732r;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i8);
                if (constraintLayout != null) {
                    i8 = R$id.endIconContainer;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i8);
                    if (frameLayout != null) {
                        i8 = R$id.startIcon;
                        DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
                        if (designImageView != null) {
                            i8 = R$id.f41725j1;
                            DesignTextView designTextView3 = (DesignTextView) ViewBindings.a(view, i8);
                            if (designTextView3 != null) {
                                return new k4(view, designTextView, designTextView2, a8, constraintLayout, frameLayout, designImageView, designTextView3);
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
        return this.f43811a;
    }
}
