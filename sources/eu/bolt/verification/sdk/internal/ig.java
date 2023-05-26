package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class ig implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43566a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignToolbarView f43567b;

    private ig(@NonNull View view, @NonNull DesignToolbarView designToolbarView) {
        this.f43566a = view;
        this.f43567b = designToolbarView;
    }

    @NonNull
    public static ig a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.rib_full_screen_error, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static ig b(@NonNull View view) {
        int i8 = R$id.fullScreenErrorToolbar;
        DesignToolbarView designToolbarView = (DesignToolbarView) ViewBindings.a(view, i8);
        if (designToolbarView != null) {
            return new ig(view, designToolbarView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f43566a;
    }
}
