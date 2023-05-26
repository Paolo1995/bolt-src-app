package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import eu.bolt.client.design.toolbar.DesignCollapsingToolbarView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class hg implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43400a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AppBarLayout f43401b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f43402c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignCollapsingToolbarView f43403d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CoordinatorLayout f43404e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f43405f;

    private hg(@NonNull View view, @NonNull AppBarLayout appBarLayout, @NonNull LinearLayout linearLayout, @NonNull DesignCollapsingToolbarView designCollapsingToolbarView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.f43400a = view;
        this.f43401b = appBarLayout;
        this.f43402c = linearLayout;
        this.f43403d = designCollapsingToolbarView;
        this.f43404e = coordinatorLayout;
        this.f43405f = recyclerView;
    }

    @NonNull
    public static hg a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.rib_form_builder, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static hg b(@NonNull View view) {
        int i8 = R$id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.a(view, i8);
        if (appBarLayout != null) {
            i8 = R$id.f41723i;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i8);
            if (linearLayout != null) {
                i8 = R$id.collapsingToolbar;
                DesignCollapsingToolbarView designCollapsingToolbarView = (DesignCollapsingToolbarView) ViewBindings.a(view, i8);
                if (designCollapsingToolbarView != null) {
                    i8 = R$id.coordinatorLayout;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.a(view, i8);
                    if (coordinatorLayout != null) {
                        i8 = R$id.G0;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i8);
                        if (recyclerView != null) {
                            return new hg(view, appBarLayout, linearLayout, designCollapsingToolbarView, coordinatorLayout, recyclerView);
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
        return this.f43400a;
    }
}
