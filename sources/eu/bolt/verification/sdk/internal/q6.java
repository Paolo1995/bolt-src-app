package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import eu.bolt.android.rib.BaseViewRibPresenterExtKt;
import eu.bolt.client.design.button.a;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.coroutines.flows.PublishFlow;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$id;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.k6;
import eu.bolt.verification.sdk.internal.l6;
import eu.bolt.verification.sdk.internal.p6;
import eu.bolt.verification.sdk.internal.s6;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class q6 implements p6 {

    /* renamed from: d  reason: collision with root package name */
    private static final a f44624d = new a(null);
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    private static final cc f44625e = new cc(16.0f, 0.0f, 16.0f, 16.0f);

    /* renamed from: a  reason: collision with root package name */
    private final s6 f44626a;

    /* renamed from: b  reason: collision with root package name */
    private final w6 f44627b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishFlow<p6.b> f44628c;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44629a;

        static {
            int[] iArr = new int[s6.a.values().length];
            try {
                iArr[s6.a.Large.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[s6.a.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f44629a = iArr;
        }
    }

    @Inject
    public q6(s6 args, w6 view) {
        Intrinsics.f(args, "args");
        Intrinsics.f(view, "view");
        this.f44626a = args;
        this.f44627b = view;
        this.f44628c = BaseViewRibPresenterExtKt.a(this);
    }

    private final void A(j6 j6Var, String str, p6.b bVar, int i8) {
        this.f44627b.a(C(j6Var, str, bVar, i8));
    }

    private final void B(String str, k6 k6Var) {
        eu.bolt.client.design.button.a aVar = (eu.bolt.client.design.button.a) this.f44627b.findViewWithTag(str);
        if (aVar != null) {
            eu.bolt.client.design.button.a.v(aVar, Intrinsics.a(k6Var, k6.b.f43822a), false, 2, null);
        }
    }

    private final eu.bolt.client.design.button.a C(final j6 j6Var, String str, final p6.b bVar, int i8) {
        int n8;
        a.c cVar;
        a.C0024a c0024a = eu.bolt.client.design.button.a.f39995x;
        Context context = this.f44627b.getContext();
        Intrinsics.e(context, "view.context");
        eu.bolt.client.design.button.a b8 = c0024a.b(context, j6Var.c().a());
        b8.setId(i8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Context context2 = b8.getContext();
        Intrinsics.e(context2, "this.context");
        int i9 = R$dimen.f41699b;
        int n9 = f2.n(context2, i9);
        if (i8 == R$id.dialogButtonFirst) {
            Context context3 = b8.getContext();
            Intrinsics.e(context3, "context");
            n8 = f2.n(context3, i9);
        } else {
            Context context4 = b8.getContext();
            Intrinsics.e(context4, "context");
            n8 = f2.n(context4, R$dimen.f41700i);
        }
        Context context5 = b8.getContext();
        Intrinsics.e(context5, "this.context");
        layoutParams.setMargins(n9, n8, f2.n(context5, i9), 0);
        b8.setLayoutParams(layoutParams);
        b8.setTag(str);
        b8.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.lv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q6.z(j6.this, this, bVar, view);
            }
        });
        b8.setText(il.c(b8, j6Var.b()));
        int i10 = b.f44629a[this.f44626a.b().ordinal()];
        if (i10 == 1) {
            cVar = a.c.Large;
        } else if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            cVar = a.c.Small;
        }
        b8.setSize(cVar);
        return b8;
    }

    private final void D(x6 x6Var) {
        Unit unit;
        aa eVar = (x6Var.d() == null && x6Var.m()) ? new aa.e(R$drawable.il_general_error, null, null, 6, null) : x6Var.d();
        DesignImageView designImageView = this.f44627b.getBinding().f43140b;
        Intrinsics.e(designImageView, "view.binding.errorImage");
        designImageView.setVisibility(eVar != null ? 0 : 8);
        DesignImageView designImageView2 = this.f44627b.getBinding().f43140b;
        Intrinsics.e(designImageView2, "view.binding.errorImage");
        DesignImageView.K(designImageView2, eVar, false, null, 6, null);
        cc e8 = x6Var.e();
        if (e8 != null) {
            b(e8);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            b(f44625e);
        }
    }

    private final void E(x6 x6Var) {
        w6 w6Var = this.f44627b;
        int i8 = R$id.dialogButtonFirst;
        View findViewById = w6Var.findViewById(i8);
        if (findViewById != null) {
            this.f44627b.removeView(findViewById);
        }
        j6 c8 = x6Var.c();
        if (c8 != null) {
            A(c8, "first_action_button", p6.b.c.f44506a, i8);
        }
    }

    private final void F(x6 x6Var) {
        DesignTextView designTextView = this.f44627b.getBinding().f43141c;
        Intrinsics.e(designTextView, "view.binding.errorText");
        il.f(designTextView, x6Var.f());
        Integer i8 = x6Var.i();
        if (i8 != null) {
            this.f44627b.getBinding().f43141c.setTextColor(i8.intValue());
        }
    }

    private final void G(x6 x6Var) {
        u4 g8 = x6Var.g();
        if (g8 != null) {
            this.f44627b.getBinding().f43141c.setFontStyle(g8);
        }
    }

    private final void H(x6 x6Var) {
        w6 w6Var = this.f44627b;
        int i8 = R$id.dialogButtonSecond;
        View findViewById = w6Var.findViewById(i8);
        if (findViewById != null) {
            this.f44627b.removeView(findViewById);
        }
        j6 j8 = x6Var.j();
        if (j8 != null) {
            A(j8, "second_action_button", p6.b.f.f44509a, i8);
        }
    }

    private final void I(x6 x6Var) {
        DesignTextView designTextView = this.f44627b.getBinding().f43142d;
        Intrinsics.e(designTextView, "view.binding.errorTitle");
        il.f(designTextView, x6Var.k());
    }

    private final void J(x6 x6Var) {
        u4 l8 = x6Var.l();
        if (l8 != null) {
            this.f44627b.getBinding().f43142d.setFontStyle(l8);
        }
    }

    private final void b(cc ccVar) {
        DesignImageView designImageView = this.f44627b.getBinding().f43140b;
        Intrinsics.e(designImageView, "view.binding.errorImage");
        ViewGroup.MarginLayoutParams a02 = uq.a0(designImageView);
        if (a02 != null) {
            Context context = this.f44627b.getContext();
            Intrinsics.e(context, "view.context");
            int a8 = f2.a(context, ccVar.d());
            Context context2 = this.f44627b.getContext();
            Intrinsics.e(context2, "view.context");
            int a9 = f2.a(context2, ccVar.b());
            Context context3 = this.f44627b.getContext();
            Intrinsics.e(context3, "view.context");
            int a10 = f2.a(context3, ccVar.a());
            Context context4 = this.f44627b.getContext();
            Intrinsics.e(context4, "view.context");
            uq.E(a02, a9, a8, f2.a(context4, ccVar.c()), a10, null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(j6 actionButtonData, q6 this$0, p6.b customEvent, View view) {
        PublishFlow<p6.b> publishFlow;
        p6.b c0082b;
        Intrinsics.f(actionButtonData, "$actionButtonData");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(customEvent, "$customEvent");
        l6 a8 = actionButtonData.a();
        if (a8 instanceof l6.a) {
            this$0.f44628c.f(p6.b.a.f44504a);
        } else if (a8 instanceof l6.b) {
            this$0.f44628c.f(customEvent);
        } else {
            if (a8 instanceof l6.e) {
                publishFlow = this$0.f44628c;
                c0082b = new p6.b.e(((l6.e) actionButtonData.a()).a());
            } else if (a8 instanceof l6.d) {
                publishFlow = this$0.f44628c;
                c0082b = new p6.b.d(((l6.d) actionButtonData.a()).a());
            } else if (!(a8 instanceof l6.c)) {
                return;
            } else {
                publishFlow = this$0.f44628c;
                c0082b = new p6.b.C0082b(((l6.c) actionButtonData.a()).a());
            }
            publishFlow.f(c0082b);
        }
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Observable<p6.b> h() {
        return p6.a.a(this);
    }

    @Override // eu.bolt.verification.sdk.internal.p6
    public void m(k6 state) {
        Intrinsics.f(state, "state");
        B("second_action_button", state);
    }

    @Override // eu.bolt.verification.sdk.internal.p6
    public void n(s6.b textGravity) {
        Intrinsics.f(textGravity, "textGravity");
        if (textGravity == s6.b.Start) {
            this.f44627b.getBinding().f43141c.setTextAlignment(5);
            this.f44627b.getBinding().f43142d.setTextAlignment(5);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.p6
    public void o(k6 state) {
        Intrinsics.f(state, "state");
        B("first_action_button", state);
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Flow<p6.b> p() {
        return this.f44628c;
    }

    @Override // eu.bolt.verification.sdk.internal.p6
    public void y(x6 errorContent) {
        Intrinsics.f(errorContent, "errorContent");
        D(errorContent);
        I(errorContent);
        J(errorContent);
        F(errorContent);
        G(errorContent);
        E(errorContent);
        H(errorContent);
    }
}
