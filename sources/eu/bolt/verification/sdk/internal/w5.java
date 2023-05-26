package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class w5 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f45490a;

    private w5(@NonNull View view) {
        this.f45490a = view;
    }

    @NonNull
    public static w5 a(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z7) {
        View inflate = layoutInflater.inflate(R$layout.divider, viewGroup, false);
        if (z7) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    @NonNull
    public static w5 b(@NonNull View view) {
        if (view != null) {
            return new w5(view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f45490a;
    }
}
