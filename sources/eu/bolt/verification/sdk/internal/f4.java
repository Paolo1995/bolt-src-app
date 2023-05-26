package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import eu.bolt.client.design.button.DesignSmallButton;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.progress.DesignCircleProgressView;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f4 {

    /* renamed from: a  reason: collision with root package name */
    public static final f4 f42947a = new f4();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: e  reason: collision with root package name */
        public static final b f42948e = new b(null);

        /* renamed from: a  reason: collision with root package name */
        private final float f42949a;

        /* renamed from: b  reason: collision with root package name */
        private final float f42950b;

        /* renamed from: c  reason: collision with root package name */
        private final float f42951c;

        /* renamed from: d  reason: collision with root package name */
        private final float f42952d;

        /* renamed from: eu.bolt.verification.sdk.internal.f4$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0053a extends a {

            /* renamed from: f  reason: collision with root package name */
            public static final C0053a f42953f = new C0053a();

            private C0053a() {
                super(16.0f, 16.0f, 18.0f, 18.0f, null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends a {

            /* renamed from: f  reason: collision with root package name */
            public static final c f42954f = new c();

            private c() {
                super(0.0f, 16.0f, 18.0f, 18.0f, 1, null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class d extends a {

            /* renamed from: f  reason: collision with root package name */
            public static final d f42955f = new d();

            private d() {
                super(0.0f, 16.0f, 20.0f, 20.0f, 1, null);
            }
        }

        private a(float f8, float f9, float f10, float f11) {
            this.f42949a = f8;
            this.f42950b = f9;
            this.f42951c = f10;
            this.f42952d = f11;
        }

        public /* synthetic */ a(float f8, float f9, float f10, float f11, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? 0.0f : f8, (i8 & 2) != 0 ? 0.0f : f9, (i8 & 4) != 0 ? 0.0f : f10, (i8 & 8) != 0 ? 0.0f : f11, null);
        }

        public /* synthetic */ a(float f8, float f9, float f10, float f11, DefaultConstructorMarker defaultConstructorMarker) {
            this(f8, f9, f10, f11);
        }

        public final float a() {
            return this.f42952d;
        }

        public final float b() {
            return this.f42949a;
        }

        public final float c() {
            return this.f42950b;
        }

        public final float d() {
            return this.f42951c;
        }
    }

    private f4() {
    }

    static /* synthetic */ FrameLayout a(f4 f4Var, j4 j4Var, View view, a aVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            aVar = a.c.f42954f;
        }
        return f4Var.b(j4Var, view, aVar);
    }

    private final FrameLayout b(j4 j4Var, View view, a aVar) {
        FrameLayout addEndViewWithMargins$lambda$6 = j4Var.getBinding().f43816f;
        Intrinsics.e(addEndViewWithMargins$lambda$6, "addEndViewWithMargins$lambda$6");
        ViewGroup.LayoutParams layoutParams = addEndViewWithMargins$lambda$6.getLayoutParams();
        if (layoutParams != null) {
            Context context = addEndViewWithMargins$lambda$6.getContext();
            Intrinsics.e(context, "context");
            int a8 = f2.a(context, aVar.b());
            Context context2 = addEndViewWithMargins$lambda$6.getContext();
            Intrinsics.e(context2, "context");
            int a9 = f2.a(context2, aVar.d());
            Context context3 = addEndViewWithMargins$lambda$6.getContext();
            Intrinsics.e(context3, "context");
            int a10 = f2.a(context3, aVar.c());
            Context context4 = addEndViewWithMargins$lambda$6.getContext();
            Intrinsics.e(context4, "context");
            addEndViewWithMargins$lambda$6.setPaddingRelative(a8, a9, a10, f2.a(context4, aVar.a()));
            addEndViewWithMargins$lambda$6.setLayoutParams((ConstraintLayout.LayoutParams) layoutParams);
            addEndViewWithMargins$lambda$6.removeAllViews();
            view.setDuplicateParentStateEnabled(true);
            view.setClickable(false);
            addEndViewWithMargins$lambda$6.addView(view);
            addEndViewWithMargins$lambda$6.requestLayout();
            Intrinsics.e(addEndViewWithMargins$lambda$6, "binding.endIconContainer…    requestLayout()\n    }");
            return addEndViewWithMargins$lambda$6;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void c(j4 j4Var) {
        Intrinsics.f(j4Var, "<this>");
        Context context = j4Var.getContext();
        Intrinsics.e(context, "context");
        DesignCircleProgressView designCircleProgressView = new DesignCircleProgressView(context, null, 0, 6, null);
        designCircleProgressView.setId(R$id.endProgressBar);
        designCircleProgressView.setSize(DesignCircleProgressView.b.MEDIUM_SMALL);
        a(this, j4Var, designCircleProgressView, null, 2, null);
    }

    public final void d(j4 j4Var, DesignImageView customActionIcon) {
        Intrinsics.f(j4Var, "<this>");
        Intrinsics.f(customActionIcon, "customActionIcon");
        customActionIcon.setId(R$id.endCustomIcon);
        a(this, j4Var, customActionIcon, null, 2, null);
    }

    public final void e(j4 j4Var, String str) {
        Intrinsics.f(j4Var, "<this>");
        Context context = j4Var.getContext();
        Intrinsics.e(context, "context");
        DesignSmallButton designSmallButton = new DesignSmallButton(context, null, 0, 6, null);
        designSmallButton.setId(R$id.endActionButton);
        designSmallButton.setText(str);
        b(j4Var, designSmallButton, a.C0053a.f42953f);
    }

    public final void f(j4 j4Var) {
        Intrinsics.f(j4Var, "<this>");
        Context context = j4Var.getContext();
        Intrinsics.e(context, "context");
        DesignImageView designImageView = new DesignImageView(context, null, 0, 6, null);
        designImageView.setId(R$id.endRefreshButton);
        designImageView.setImageDrawable(ContextCompat.getDrawable(designImageView.getContext(), R$drawable.ic_refresh));
        b(j4Var, designImageView, a.d.f42955f);
    }

    public final void g(j4 j4Var) {
        Intrinsics.f(j4Var, "<this>");
        Context context = j4Var.getContext();
        Intrinsics.e(context, "context");
        DesignImageView designImageView = new DesignImageView(context, null, 0, 6, null);
        designImageView.setId(R$id.endSuccessTick);
        designImageView.setImageDrawable(ContextCompat.getDrawable(designImageView.getContext(), R$drawable.ic_tick));
        Context context2 = designImageView.getContext();
        Intrinsics.e(context2, "context");
        int a8 = f2.a(context2, 28.0f);
        Context context3 = designImageView.getContext();
        Intrinsics.e(context3, "context");
        designImageView.setLayoutParams(new FrameLayout.LayoutParams(a8, f2.a(context3, 28.0f)));
        a(this, j4Var, designImageView, null, 2, null);
    }
}
