package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class a4 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f41947a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f41948b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f41949c;

    private a4(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull View view2) {
        this.f41947a = view;
        this.f41948b = frameLayout;
        this.f41949c = view2;
    }

    @NonNull
    public static a4 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_bottom_sheet_content_container, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static a4 b(@NonNull View view) {
        View a8;
        int i8 = R$id.f41731p;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i8);
        if (frameLayout == null || (a8 = ViewBindings.a(view, (i8 = R$id.dragIndicator))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
        }
        return new a4(view, frameLayout, a8);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f41947a;
    }
}
