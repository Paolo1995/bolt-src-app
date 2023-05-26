package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class b5 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f42284a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignTextView f42285b;

    private b5(@NonNull View view, @NonNull DesignTextView designTextView) {
        this.f42284a = view;
        this.f42285b = designTextView;
    }

    @NonNull
    public static b5 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_pin_label, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static b5 b(@NonNull View view) {
        int i8 = R$id.f41728l1;
        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
        if (designTextView != null) {
            return new b5(view, designTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f42284a;
    }
}
