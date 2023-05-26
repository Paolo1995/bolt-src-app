package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class k5 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43819a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f43820b;

    private k5(@NonNull View view, @NonNull LinearLayout linearLayout) {
        this.f43819a = view;
        this.f43820b = linearLayout;
    }

    @NonNull
    public static k5 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_toolbar, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static k5 b(@NonNull View view) {
        int i8 = R$id.buttonsContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i8);
        if (linearLayout != null) {
            return new k5(view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f43819a;
    }
}
