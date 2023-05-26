package eu.bolt.verification.sdk.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.button.DesignButton;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;

/* loaded from: classes5.dex */
public final class xq implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f45695a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignTextView f45696b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignImageView f45697c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignButton f45698d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final DesignTextView f45699e;

    private xq(@NonNull ConstraintLayout constraintLayout, @NonNull DesignTextView designTextView, @NonNull DesignImageView designImageView, @NonNull DesignButton designButton, @NonNull DesignTextView designTextView2) {
        this.f45695a = constraintLayout;
        this.f45696b = designTextView;
        this.f45697c = designImageView;
        this.f45698d = designButton;
        this.f45699e = designTextView2;
    }

    @NonNull
    public static xq b(@NonNull View view) {
        int i8 = R$id.errorDescription;
        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
        if (designTextView != null) {
            i8 = R$id.X;
            DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
            if (designImageView != null) {
                i8 = R$id.errorRetryButton;
                DesignButton designButton = (DesignButton) ViewBindings.a(view, i8);
                if (designButton != null) {
                    i8 = R$id.f41718b0;
                    DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                    if (designTextView2 != null) {
                        return new xq((ConstraintLayout) view, designTextView, designImageView, designButton, designTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f45695a;
    }
}
