package eu.bolt.client.design.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageSwitcher;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$id;
import eu.bolt.verification.sdk.internal.a6;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.he;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class PaymentProfileSwitch extends ConstraintLayout implements ViewSwitcher.ViewFactory {
    private static final a I = new a(null);
    private final he E;
    private boolean F;
    private final Lazy G;
    private final Lazy H;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function0<Integer> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f40190f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.f40190f = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final Integer invoke() {
            return Integer.valueOf(f2.b(this.f40190f, R$color.neutral_700));
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function0<Integer> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f40191f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.f40191f = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final Integer invoke() {
            return Integer.valueOf(f2.b(this.f40191f, R$color.neutral_900));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaymentProfileSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentProfileSwitch(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(context, "context");
        he a8 = he.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.E = a8;
        this.F = true;
        b8 = LazyKt__LazyJVMKt.b(new c(context));
        this.G = b8;
        b9 = LazyKt__LazyJVMKt.b(new b(context));
        this.H = b9;
        a8.f43398g.setFactory(this);
        a8.f43395d.setFactory(this);
        C();
        D();
    }

    public /* synthetic */ PaymentProfileSwitch(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void C() {
        setBackgroundResource(R$drawable.bg_payment_profile_switch);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, 2.0f);
        setPadding(a8, a8, a8, a8);
        setClipToPadding(false);
        setClipChildren(false);
        setClipToOutline(true);
    }

    private final void D() {
        ImageSwitcher imageSwitcher;
        Drawable o8;
        int iconTintColorEnabled;
        TransitionManager.c(this);
        TransitionManager.b(this, new ChangeBounds().e0(new DecelerateInterpolator()).b(R$id.thumb).c0(250L));
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.g(this);
        constraintSet.e(this.E.f43397f.getId(), 6);
        constraintSet.e(this.E.f43397f.getId(), 7);
        int i8 = this.F ? 6 : 7;
        constraintSet.i(this.E.f43397f.getId(), i8, 0, i8);
        constraintSet.c(this);
        if (this.F) {
            ImageSwitcher imageSwitcher2 = this.E.f43395d;
            Context context = getContext();
            Intrinsics.e(context, "context");
            imageSwitcher2.setImageDrawable(a6.a(f2.o(context, R$drawable.ic_user), getIconTintColorEnabled()));
            imageSwitcher = this.E.f43398g;
            Context context2 = getContext();
            Intrinsics.e(context2, "context");
            o8 = f2.o(context2, R$drawable.ic_business);
            iconTintColorEnabled = getIconTintColorDisabled();
        } else {
            ImageSwitcher imageSwitcher3 = this.E.f43395d;
            Context context3 = getContext();
            Intrinsics.e(context3, "context");
            imageSwitcher3.setImageDrawable(a6.a(f2.o(context3, R$drawable.ic_user), getIconTintColorDisabled()));
            imageSwitcher = this.E.f43398g;
            Context context4 = getContext();
            Intrinsics.e(context4, "context");
            o8 = f2.o(context4, R$drawable.ic_business);
            iconTintColorEnabled = getIconTintColorEnabled();
        }
        imageSwitcher.setImageDrawable(a6.a(o8, iconTintColorEnabled));
    }

    private final int getIconTintColorDisabled() {
        return ((Number) this.H.getValue()).intValue();
    }

    private final int getIconTintColorEnabled() {
        return ((Number) this.G.getValue()).intValue();
    }

    public final boolean B() {
        return this.F;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        Context context = getContext();
        Intrinsics.e(context, "context");
        return new DesignImageView(context, null, 0, 6, null);
    }

    public final void setPersonalProfileEnabled(boolean z7) {
        if (this.F != z7) {
            this.F = z7;
            D();
        }
    }
}
