package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.selection.PaymentProfileSwitch;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class f5 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f42956a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignImageView f42957b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DesignTextView f42958c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DesignImageView f42959d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final DesignImageView f42960e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Barrier f42961f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DesignTextView f42962g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final PaymentProfileSwitch f42963h;

    private f5(@NonNull View view, @NonNull DesignImageView designImageView, @NonNull DesignTextView designTextView, @NonNull DesignImageView designImageView2, @NonNull DesignImageView designImageView3, @NonNull Barrier barrier, @NonNull DesignTextView designTextView2, @NonNull PaymentProfileSwitch paymentProfileSwitch) {
        this.f42956a = view;
        this.f42957b = designImageView;
        this.f42958c = designTextView;
        this.f42959d = designImageView2;
        this.f42960e = designImageView3;
        this.f42961f = barrier;
        this.f42962g = designTextView2;
        this.f42963h = paymentProfileSwitch;
    }

    @NonNull
    public static f5 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_selected_payment_view, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static f5 b(@NonNull View view) {
        int i8 = R$id.arrowImage;
        DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
        if (designImageView != null) {
            i8 = R$id.cardNumber;
            DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
            if (designTextView != null) {
                i8 = R$id.endIcon;
                DesignImageView designImageView2 = (DesignImageView) ViewBindings.a(view, i8);
                if (designImageView2 != null) {
                    i8 = R$id.paymentMethodIcon;
                    DesignImageView designImageView3 = (DesignImageView) ViewBindings.a(view, i8);
                    if (designImageView3 != null) {
                        i8 = R$id.paymentMethodStartBarrier;
                        Barrier barrier = (Barrier) ViewBindings.a(view, i8);
                        if (barrier != null) {
                            i8 = R$id.paymentName;
                            DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                            if (designTextView2 != null) {
                                i8 = R$id.paymentProfileSwitch;
                                PaymentProfileSwitch paymentProfileSwitch = (PaymentProfileSwitch) ViewBindings.a(view, i8);
                                if (paymentProfileSwitch != null) {
                                    return new f5(view, designImageView, designTextView, designImageView2, designImageView3, barrier, designTextView2, paymentProfileSwitch);
                                }
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
        return this.f42956a;
    }
}
