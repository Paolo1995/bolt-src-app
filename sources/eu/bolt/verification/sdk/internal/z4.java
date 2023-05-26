package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.progress.DesignCircleProgressView;
import eu.bolt.client.design.selection.DesignCheckBox;
import eu.bolt.client.design.selection.DesignRadioButton;
import eu.bolt.client.design.text.DesignNewIndicatorTextView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class z4 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f45798a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignCheckBox f45799b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Barrier f45800c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Space f45801d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final DesignImageView f45802e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DesignTextView f45803f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DesignTextView f45804g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Barrier f45805h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final Barrier f45806i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final Space f45807j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final DesignNewIndicatorTextView f45808k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final Space f45809l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final DesignCircleProgressView f45810m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final DesignRadioButton f45811n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    public final DesignCheckBox f45812o;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final DesignImageView f45813p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final DesignTextView f45814q;
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    public final DesignTextView f45815r;

    private z4(@NonNull View view, @NonNull DesignCheckBox designCheckBox, @NonNull Barrier barrier, @NonNull Space space, @NonNull DesignImageView designImageView, @NonNull DesignTextView designTextView, @NonNull DesignTextView designTextView2, @NonNull Barrier barrier2, @NonNull Barrier barrier3, @NonNull Space space2, @NonNull DesignNewIndicatorTextView designNewIndicatorTextView, @NonNull Space space3, @NonNull DesignCircleProgressView designCircleProgressView, @NonNull DesignRadioButton designRadioButton, @NonNull DesignCheckBox designCheckBox2, @NonNull DesignImageView designImageView2, @NonNull DesignTextView designTextView3, @NonNull DesignTextView designTextView4) {
        this.f45798a = view;
        this.f45799b = designCheckBox;
        this.f45800c = barrier;
        this.f45801d = space;
        this.f45802e = designImageView;
        this.f45803f = designTextView;
        this.f45804g = designTextView2;
        this.f45805h = barrier2;
        this.f45806i = barrier3;
        this.f45807j = space2;
        this.f45808k = designNewIndicatorTextView;
        this.f45809l = space3;
        this.f45810m = designCircleProgressView;
        this.f45811n = designRadioButton;
        this.f45812o = designCheckBox2;
        this.f45813p = designImageView2;
        this.f45814q = designTextView3;
        this.f45815r = designTextView4;
    }

    @NonNull
    public static z4 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_list_item, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static z4 b(@NonNull View view) {
        int i8 = R$id.endCheckbox;
        DesignCheckBox designCheckBox = (DesignCheckBox) ViewBindings.a(view, i8);
        if (designCheckBox != null) {
            i8 = R$id.endContentBarrier;
            Barrier barrier = (Barrier) ViewBindings.a(view, i8);
            if (barrier != null) {
                i8 = R$id.endContentSpace;
                Space space = (Space) ViewBindings.a(view, i8);
                if (space != null) {
                    i8 = R$id.endIcon;
                    DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
                    if (designImageView != null) {
                        i8 = R$id.endSubtitle;
                        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
                        if (designTextView != null) {
                            i8 = R$id.endTitle;
                            DesignTextView designTextView2 = (DesignTextView) ViewBindings.a(view, i8);
                            if (designTextView2 != null) {
                                i8 = R$id.iconBarrier;
                                Barrier barrier2 = (Barrier) ViewBindings.a(view, i8);
                                if (barrier2 != null) {
                                    i8 = R$id.middleContentBarrier;
                                    Barrier barrier3 = (Barrier) ViewBindings.a(view, i8);
                                    if (barrier3 != null) {
                                        i8 = R$id.middleEndContentSpace;
                                        Space space2 = (Space) ViewBindings.a(view, i8);
                                        if (space2 != null) {
                                            i8 = R$id.middleNewIndicator;
                                            DesignNewIndicatorTextView designNewIndicatorTextView = (DesignNewIndicatorTextView) ViewBindings.a(view, i8);
                                            if (designNewIndicatorTextView != null) {
                                                i8 = R$id.middleStartContentSpace;
                                                Space space3 = (Space) ViewBindings.a(view, i8);
                                                if (space3 != null) {
                                                    i8 = R$id.D0;
                                                    DesignCircleProgressView designCircleProgressView = (DesignCircleProgressView) ViewBindings.a(view, i8);
                                                    if (designCircleProgressView != null) {
                                                        i8 = R$id.F0;
                                                        DesignRadioButton designRadioButton = (DesignRadioButton) ViewBindings.a(view, i8);
                                                        if (designRadioButton != null) {
                                                            i8 = R$id.startCheckbox;
                                                            DesignCheckBox designCheckBox2 = (DesignCheckBox) ViewBindings.a(view, i8);
                                                            if (designCheckBox2 != null) {
                                                                i8 = R$id.startIcon;
                                                                DesignImageView designImageView2 = (DesignImageView) ViewBindings.a(view, i8);
                                                                if (designImageView2 != null) {
                                                                    i8 = R$id.f41719b1;
                                                                    DesignTextView designTextView3 = (DesignTextView) ViewBindings.a(view, i8);
                                                                    if (designTextView3 != null) {
                                                                        i8 = R$id.f41725j1;
                                                                        DesignTextView designTextView4 = (DesignTextView) ViewBindings.a(view, i8);
                                                                        if (designTextView4 != null) {
                                                                            return new z4(view, designCheckBox, barrier, space, designImageView, designTextView, designTextView2, barrier2, barrier3, space2, designNewIndicatorTextView, space3, designCircleProgressView, designRadioButton, designCheckBox2, designImageView2, designTextView3, designTextView4);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
        return this.f45798a;
    }
}
