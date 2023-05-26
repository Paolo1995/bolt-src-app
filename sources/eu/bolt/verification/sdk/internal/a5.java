package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class a5 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f41950a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignImageView f41951b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignImageView f41952c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f41953d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f41954e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DesignImageView f41955f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DesignTextView f41956g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final DesignTextView f41957h;

    private a5(@NonNull View view, @NonNull DesignImageView designImageView, @NonNull DesignImageView designImageView2, @NonNull View view2, @NonNull LinearLayout linearLayout, @NonNull DesignImageView designImageView3, @NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2) {
        this.f41950a = view;
        this.f41951b = designImageView;
        this.f41952c = designImageView2;
        this.f41953d = view2;
        this.f41954e = linearLayout;
        this.f41955f = designImageView3;
        this.f41956g = designTextView;
        this.f41957h = designTextView2;
    }

    @NonNull
    public static a5 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_pin_circle, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static a5 b(@NonNull View view) {
        View a8;
        int i8 = R$id.f41720d;
        DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
        if (designImageView != null) {
            i8 = R$id.customLoader;
            DesignImageView designImageView2 = (DesignImageView) ViewBindings.a(view, i8);
            if (designImageView2 != null && (a8 = ViewBindings.a(view, (i8 = R$id.dot))) != null) {
                i8 = R$id.etaContainer;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i8);
                if (linearLayout != null) {
                    i8 = R$id.f41724j0;
                    DesignImageView designImageView3 = (DesignImageView) ViewBindings.a(view, i8);
                    if (designImageView3 != null) {
                        i8 = R$id.suffix;
                        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
                        if (designTextView != null) {
                            i8 = R$id.f41728l1;
                            DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                            if (designTextView2 != null) {
                                return new a5(view, designImageView, designImageView2, a8, linearLayout, designImageView3, designTextView, designTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f41950a;
    }
}
