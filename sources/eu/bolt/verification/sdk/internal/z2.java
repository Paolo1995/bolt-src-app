package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class z2 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DesignTextView f45794a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignTextView f45795b;

    private z2(@NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2) {
        this.f45794a = designTextView;
        this.f45795b = designTextView2;
    }

    @NonNull
    public static z2 b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.country_picker_section_header, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static z2 c(@NonNull View view) {
        if (view != null) {
            DesignTextView designTextView = (DesignTextView) view;
            return new z2(designTextView, designTextView);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public DesignTextView getRoot() {
        return this.f45794a;
    }
}
