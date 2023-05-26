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
import eu.bolt.client.design.progress.DesignCircleProgressView;
import eu.bolt.client.design.text.DesignNewIndicatorTextView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class s4 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f44930a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final View f44931b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f44932c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignTextView f44933d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final DesignImageView f44934e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DesignNewIndicatorTextView f44935f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DesignCircleProgressView f44936g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f44937h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final DesignImageView f44938i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final DesignTextView f44939j;

    private s4(@NonNull View view, @NonNull View view2, @NonNull ConstraintLayout constraintLayout, @NonNull DesignTextView designTextView, @NonNull DesignImageView designImageView, @NonNull DesignNewIndicatorTextView designNewIndicatorTextView, @NonNull DesignCircleProgressView designCircleProgressView, @NonNull FrameLayout frameLayout, @NonNull DesignImageView designImageView2, @NonNull DesignTextView designTextView2) {
        this.f44930a = view;
        this.f44931b = view2;
        this.f44932c = constraintLayout;
        this.f44933d = designTextView;
        this.f44934e = designImageView;
        this.f44935f = designNewIndicatorTextView;
        this.f44936g = designCircleProgressView;
        this.f44937h = frameLayout;
        this.f44938i = designImageView2;
        this.f44939j = designTextView2;
    }

    @NonNull
    public static s4 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_fab, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static s4 b(@NonNull View view) {
        int i8 = R$id.f41721e;
        View a8 = ViewBindings.a(view, i8);
        if (a8 != null) {
            i8 = R$id.f41733s;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i8);
            if (constraintLayout != null) {
                i8 = R$id.counter;
                DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
                if (designTextView != null) {
                    i8 = R$id.f41724j0;
                    DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
                    if (designImageView != null) {
                        i8 = R$id.f41729m0;
                        DesignNewIndicatorTextView designNewIndicatorTextView = (DesignNewIndicatorTextView) ViewBindings.a(view, i8);
                        if (designNewIndicatorTextView != null) {
                            i8 = R$id.D0;
                            DesignCircleProgressView designCircleProgressView = (DesignCircleProgressView) ViewBindings.a(view, i8);
                            if (designCircleProgressView != null) {
                                i8 = R$id.roundContainer;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i8);
                                if (frameLayout != null) {
                                    i8 = R$id.K0;
                                    DesignImageView designImageView2 = (DesignImageView) ViewBindings.a(view, i8);
                                    if (designImageView2 != null) {
                                        i8 = R$id.f41722e1;
                                        DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                                        if (designTextView2 != null) {
                                            return new s4(view, a8, constraintLayout, designTextView, designImageView, designNewIndicatorTextView, designCircleProgressView, frameLayout, designImageView2, designTextView2);
                                        }
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
        return this.f44930a;
    }
}
