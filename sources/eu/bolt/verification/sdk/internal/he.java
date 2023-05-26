package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class he implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43392a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Guideline f43393b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Guideline f43394c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageSwitcher f43395d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Space f43396e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f43397f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageSwitcher f43398g;

    private he(@NonNull View view, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull ImageSwitcher imageSwitcher, @NonNull Space space, @NonNull View view2, @NonNull ImageSwitcher imageSwitcher2) {
        this.f43392a = view;
        this.f43393b = guideline;
        this.f43394c = guideline2;
        this.f43395d = imageSwitcher;
        this.f43396e = space;
        this.f43397f = view2;
        this.f43398g = imageSwitcher2;
    }

    @NonNull
    public static he a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.payment_profile_switch, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static he b(@NonNull View view) {
        View a8;
        int i8 = R$id.guideEnd;
        Guideline guideline = (Guideline) ViewBindings.a(view, i8);
        if (guideline != null) {
            i8 = R$id.guideStart;
            Guideline guideline2 = (Guideline) ViewBindings.a(view, i8);
            if (guideline2 != null) {
                i8 = R$id.personalProfileImage;
                ImageSwitcher imageSwitcher = (ImageSwitcher) ViewBindings.a(view, i8);
                if (imageSwitcher != null) {
                    i8 = R$id.space;
                    Space space = (Space) ViewBindings.a(view, i8);
                    if (space != null && (a8 = ViewBindings.a(view, (i8 = R$id.thumb))) != null) {
                        i8 = R$id.workProfileImage;
                        ImageSwitcher imageSwitcher2 = (ImageSwitcher) ViewBindings.a(view, i8);
                        if (imageSwitcher2 != null) {
                            return new he(view, guideline, guideline2, imageSwitcher, space, a8, imageSwitcher2);
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
        return this.f43392a;
    }
}
