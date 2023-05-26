package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class fg implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f42985a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AppBarLayout f42986b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f42987c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignTextView f42988d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final DesignTextfieldView f42989e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DesignToolbarView f42990f;

    private fg(@NonNull View view, @NonNull AppBarLayout appBarLayout, @NonNull RecyclerView recyclerView, @NonNull DesignTextView designTextView, @NonNull DesignTextfieldView designTextfieldView, @NonNull DesignToolbarView designToolbarView) {
        this.f42985a = view;
        this.f42986b = appBarLayout;
        this.f42987c = recyclerView;
        this.f42988d = designTextView;
        this.f42989e = designTextfieldView;
        this.f42990f = designToolbarView;
    }

    @NonNull
    public static fg a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.rib_country_picker, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static fg b(@NonNull View view) {
        int i8 = R$id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.a(view, i8);
        if (appBarLayout != null) {
            i8 = R$id.countryList;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i8);
            if (recyclerView != null) {
                i8 = R$id.countryNotFound;
                DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
                if (designTextView != null) {
                    i8 = R$id.J0;
                    DesignTextfieldView designTextfieldView = (DesignTextfieldView) ViewBindings.a(view, i8);
                    if (designTextfieldView != null) {
                        i8 = R$id.f41726k1;
                        DesignToolbarView designToolbarView = (DesignToolbarView) ViewBindings.a(view, i8);
                        if (designToolbarView != null) {
                            return new fg(view, appBarLayout, recyclerView, designTextView, designTextfieldView, designToolbarView);
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
        return this.f42985a;
    }
}
