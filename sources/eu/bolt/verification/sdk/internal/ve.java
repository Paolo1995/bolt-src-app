package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class ve implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f45445a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignImageView f45446b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f45447c;

    private ve(@NonNull View view, @NonNull DesignImageView designImageView, @NonNull View view2) {
        this.f45445a = view;
        this.f45446b = designImageView;
        this.f45447c = view2;
    }

    @NonNull
    public static ve a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.pin_shadow, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static ve b(@NonNull View view) {
        View a8;
        int i8 = R$id.bigShadow;
        DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
        if (designImageView == null || (a8 = ViewBindings.a(view, (i8 = R$id.smallShadow))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
        }
        return new ve(view, designImageView, a8);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f45445a;
    }
}
