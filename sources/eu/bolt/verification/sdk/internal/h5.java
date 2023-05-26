package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class h5 implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f43339a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final DesignTextView f43340b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewStub f43341c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ViewStub f43342d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ViewStub f43343e;

    private h5(@NonNull View view, @NonNull DesignTextView designTextView, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3) {
        this.f43339a = view;
        this.f43340b = designTextView;
        this.f43341c = viewStub;
        this.f43342d = viewStub2;
        this.f43343e = viewStub3;
    }

    @NonNull
    public static h5 a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.design_textfield, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static h5 b(@NonNull View view) {
        int i8 = R$id.hint;
        DesignTextView designTextView = (DesignTextView) ViewBindings.a(view, i8);
        if (designTextView != null) {
            i8 = R$id.textfieldEndIcon;
            ViewStub viewStub = (ViewStub) ViewBindings.a(view, i8);
            if (viewStub != null) {
                i8 = R$id.textfieldInput;
                ViewStub viewStub2 = (ViewStub) ViewBindings.a(view, i8);
                if (viewStub2 != null) {
                    i8 = R$id.textfieldStartIcon;
                    ViewStub viewStub3 = (ViewStub) ViewBindings.a(view, i8);
                    if (viewStub3 != null) {
                        return new h5(view, designTextView, viewStub, viewStub2, viewStub3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f43339a;
    }
}
