package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.client.design.listitem.DesignListItemView;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class ta implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DesignListItemView f45153a;

    private ta(@NonNull DesignListItemView designListItemView) {
        this.f45153a = designListItemView;
    }

    @NonNull
    public static ta b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.item_check_box, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return c(inflate);
    }

    @NonNull
    public static ta c(@NonNull View view) {
        if (view != null) {
            return new ta((DesignListItemView) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public DesignListItemView getRoot() {
        return this.f45153a;
    }
}
