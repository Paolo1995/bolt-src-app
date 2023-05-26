package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class za implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DesignTextfieldView f45844a;

    private za(@NonNull DesignTextfieldView designTextfieldView) {
        this.f45844a = designTextfieldView;
    }

    @NonNull
    public static za b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.item_text_input, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static za c(@NonNull View view) {
        if (view != null) {
            return new za((DesignTextfieldView) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public DesignTextfieldView getRoot() {
        return this.f45844a;
    }
}
