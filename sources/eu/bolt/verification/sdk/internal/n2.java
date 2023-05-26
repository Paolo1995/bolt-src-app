package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class n2 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f44236a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignImageView f44237b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignTextView f44238c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignTextView f44239d;

    private n2(@NonNull ConstraintLayout constraintLayout, @NonNull DesignImageView designImageView, @NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2) {
        this.f44236a = constraintLayout;
        this.f44237b = designImageView;
        this.f44238c = designTextView;
        this.f44239d = designTextView2;
    }

    @NonNull
    public static n2 b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.country_picker_item, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static n2 c(@NonNull View view) {
        int i8 = R$id.f41735v;
        DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
        if (designImageView != null) {
            i8 = R$id.f41736x;
            DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
            if (designTextView != null) {
                i8 = R$id.C0;
                DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                if (designTextView2 != null) {
                    return new n2((ConstraintLayout) view, designImageView, designTextView, designTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f44236a;
    }
}
