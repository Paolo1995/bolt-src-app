package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.client.design.input.DesignDateInputView;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class va implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DesignDateInputView f45441a;

    private va(@NonNull DesignDateInputView designDateInputView) {
        this.f45441a = designDateInputView;
    }

    @NonNull
    public static va b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.item_date_input, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static va c(@NonNull View view) {
        if (view != null) {
            return new va((DesignDateInputView) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public DesignDateInputView getRoot() {
        return this.f45441a;
    }
}
