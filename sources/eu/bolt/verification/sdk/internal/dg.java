package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class dg implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f42642a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f42643b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignTextView f42644c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignTextView f42645d;

    private dg(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2) {
        this.f42642a = linearLayout;
        this.f42643b = linearLayout2;
        this.f42644c = designTextView;
        this.f42645d = designTextView2;
    }

    @NonNull
    public static dg b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    @NonNull
    public static dg c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.rib_bottom_sheet_information, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return d(inflate);
    }

    @NonNull
    public static dg d(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i8 = R$id.informationMessage;
        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
        if (designTextView != null) {
            i8 = R$id.informationTitle;
            DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
            if (designTextView2 != null) {
                return new dg(linearLayout, linearLayout, designTextView, designTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f42642a;
    }
}
