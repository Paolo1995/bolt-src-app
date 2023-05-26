package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class gg implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43139a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignImageView f43140b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignTextView f43141c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignTextView f43142d;

    private gg(@NonNull View view, @NonNull DesignImageView designImageView, @NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2) {
        this.f43139a = view;
        this.f43140b = designImageView;
        this.f43141c = designTextView;
        this.f43142d = designTextView2;
    }

    @NonNull
    public static gg a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.rib_error_content, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static gg b(@NonNull View view) {
        int i8 = R$id.errorImage;
        DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
        if (designImageView != null) {
            i8 = R$id.f41716a0;
            DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
            if (designTextView != null) {
                i8 = R$id.f41718b0;
                DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                if (designTextView2 != null) {
                    return new gg(view, designImageView, designTextView, designTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f43139a;
    }
}
