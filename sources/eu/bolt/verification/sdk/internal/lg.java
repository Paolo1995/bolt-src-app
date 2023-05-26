package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.client.design.webview.DesignWebView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class lg implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f44051a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignToolbarView f44052b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignWebView f44053c;

    private lg(@NonNull View view, @NonNull DesignToolbarView designToolbarView, @NonNull DesignWebView designWebView) {
        this.f44051a = view;
        this.f44052b = designToolbarView;
        this.f44053c = designWebView;
    }

    @NonNull
    public static lg a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.rib_web_view, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static lg b(@NonNull View view) {
        int i8 = R$id.f41726k1;
        DesignToolbarView designToolbarView = (DesignToolbarView) ViewBindings.a(view, i8);
        if (designToolbarView != null) {
            i8 = R$id.f41730m1;
            DesignWebView designWebView = (DesignWebView) ViewBindings.a(view, i8);
            if (designWebView != null) {
                return new lg(view, designToolbarView, designWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f44051a;
    }
}
