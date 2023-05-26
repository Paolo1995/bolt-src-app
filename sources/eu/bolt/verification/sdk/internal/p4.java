package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class p4 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DesignTextfieldView f44500a;

    private p4(@NonNull DesignTextfieldView designTextfieldView) {
        this.f44500a = designTextfieldView;
    }

    @NonNull
    public static p4 b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.design_date_segment_field, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static p4 c(@NonNull View view) {
        if (view != null) {
            return new p4((DesignTextfieldView) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public DesignTextfieldView getRoot() {
        return this.f44500a;
    }
}
