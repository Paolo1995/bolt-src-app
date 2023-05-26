package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class wa implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DesignImageView f45539a;

    private wa(@NonNull DesignImageView designImageView) {
        this.f45539a = designImageView;
    }

    @NonNull
    public static wa b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.item_image, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static wa c(@NonNull View view) {
        if (view != null) {
            return new wa((DesignImageView) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public DesignImageView getRoot() {
        return this.f45539a;
    }
}
