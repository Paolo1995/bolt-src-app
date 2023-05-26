package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class n4 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f44289a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignTextView f44290b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignToolbarView f44291c;

    private n4(@NonNull View view, @NonNull DesignTextView designTextView, @NonNull DesignToolbarView designToolbarView) {
        this.f44289a = view;
        this.f44290b = designTextView;
        this.f44291c = designToolbarView;
    }

    @NonNull
    public static n4 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_collapsing_toolbar, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static n4 b(@NonNull View view) {
        int i8 = R$id.expandedTitlePlaceholder;
        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
        if (designTextView != null) {
            i8 = R$id.f41726k1;
            DesignToolbarView designToolbarView = (DesignToolbarView) ViewBindings.a(view, i8);
            if (designToolbarView != null) {
                return new n4(view, designTextView, designToolbarView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f44289a;
    }
}
