package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.card.MaterialCardView;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.f;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public class j4 extends MaterialCardView {

    /* renamed from: z  reason: collision with root package name */
    private static final b f43653z = new b(null);

    /* renamed from: x  reason: collision with root package name */
    private i4 f43654x;

    /* renamed from: y  reason: collision with root package name */
    private final k4 f43655y;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f43656f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ j4 f43657g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, j4 j4Var) {
            super(1);
            this.f43656f = context;
            this.f43657g = j4Var;
        }

        public final void b(TypedArray array) {
            Intrinsics.f(array, "array");
            String a8 = vl.a(array, R$styleable.f41882w0, this.f43656f);
            String a9 = vl.a(array, R$styleable.f41852r0, this.f43656f);
            int color = array.getColor(R$styleable.f41888x0, -1);
            int color2 = array.getColor(R$styleable.f41858s0, -1);
            int resourceId = array.getResourceId(R$styleable.f41876v0, -1);
            int i8 = array.getInt(R$styleable.f41864t0, -1);
            String a10 = vl.a(array, R$styleable.f41870u0, this.f43656f);
            this.f43657g.setTitle(a8);
            this.f43657g.setBody(a9);
            if (resourceId != -1) {
                this.f43657g.setImage(new aa.b(resourceId, null, null, 6, null));
            }
            if (color != -1) {
                this.f43657g.setTitleColor(color);
            }
            if (color2 != -1) {
                this.f43657g.setBodyColor(color2);
            }
            this.f43657g.setActionIcon(g4.f43098a.a(i8, a10));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        k4 a8 = k4.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f43655y = a8;
        int[] DesignCardView = R$styleable.f41846q0;
        Intrinsics.e(DesignCardView, "DesignCardView");
        uq.x(this, attributeSet, DesignCardView, new a(context, this));
        a8.f43817g.x();
        a8.f43817g.setRepeatCount(-1);
        setRadius(f2.i(context, 8.0f));
        setCardElevation(f2.i(context, 4.0f));
        setMinimumHeight(f2.a(context, 64.0f));
    }

    public /* synthetic */ j4(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final DesignImageView j(aa aaVar) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        DesignImageView designImageView = new DesignImageView(context, null, 0, 6, null);
        DesignImageView.K(designImageView, aaVar, false, null, 6, null);
        return designImageView;
    }

    private final void k() {
        DesignTextView designTextView = this.f43655y.f43812b;
        Intrinsics.e(designTextView, "binding.actionText");
        designTextView.setVisibility(8);
        p();
        o();
    }

    private final void l() {
        this.f43655y.f43816f.removeAllViews();
    }

    private final void m() {
        DesignTextView designTextView = this.f43655y.f43813c;
        Intrinsics.e(designTextView, "binding.body");
        uq.C(designTextView, false);
        p();
        o();
    }

    private final void n() {
        DesignTextView designTextView = this.f43655y.f43818h;
        Intrinsics.e(designTextView, "binding.title");
        uq.C(designTextView, false);
        p();
        o();
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if ((r2.getVisibility() == 0) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
        if ((r2.getVisibility() == 0) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        r2 = r1.f43818h;
        kotlin.jvm.internal.Intrinsics.e(r2, "title");
        r10 = eu.bolt.verification.sdk.internal.uq.a0(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r10 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
        r2 = getContext();
        kotlin.jvm.internal.Intrinsics.e(r2, "context");
        eu.bolt.verification.sdk.internal.uq.E(r10, 0, eu.bolt.verification.sdk.internal.f2.a(r2, 12.0f), 0, 0, null, 21, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0091, code lost:
        r2 = r1.f43813c;
        kotlin.jvm.internal.Intrinsics.e(r2, "body");
        r10 = eu.bolt.verification.sdk.internal.uq.a0(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
        if (r10 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
        eu.bolt.verification.sdk.internal.uq.E(r10, 0, 0, 0, 0, null, 21, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r1 = r1.f43812b;
        kotlin.jvm.internal.Intrinsics.e(r1, "actionText");
        r1 = eu.bolt.verification.sdk.internal.uq.a0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        if (r1 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void o() {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.j4.o():void");
    }

    private final void p() {
        DesignTextView designTextView;
        DesignTextView designTextView2 = this.f43655y.f43813c;
        Intrinsics.e(designTextView2, "binding.body");
        if (uq.X(designTextView2)) {
            DesignTextView designTextView3 = this.f43655y.f43818h;
            Intrinsics.e(designTextView3, "binding.title");
            if (uq.X(designTextView3)) {
                this.f43655y.f43813c.setMaxLines(1);
                designTextView = this.f43655y.f43818h;
                designTextView.setMaxLines(1);
                return;
            }
        }
        DesignTextView designTextView4 = this.f43655y.f43818h;
        Intrinsics.e(designTextView4, "binding.title");
        if (uq.X(designTextView4)) {
            DesignTextView designTextView5 = this.f43655y.f43813c;
            Intrinsics.e(designTextView5, "binding.body");
            if (!uq.X(designTextView5)) {
                this.f43655y.f43818h.setMaxLines(2);
                designTextView = this.f43655y.f43813c;
                designTextView.setMaxLines(1);
                return;
            }
        }
        DesignTextView designTextView6 = this.f43655y.f43813c;
        Intrinsics.e(designTextView6, "binding.body");
        if (uq.X(designTextView6)) {
            DesignTextView designTextView7 = this.f43655y.f43818h;
            Intrinsics.e(designTextView7, "binding.title");
            if (uq.X(designTextView7)) {
                return;
            }
            this.f43655y.f43818h.setMaxLines(1);
            this.f43655y.f43813c.setMaxLines(2);
        }
    }

    public final k4 getBinding() {
        return this.f43655y;
    }

    public final void setActionIcon(f fVar) {
        if (fVar instanceof f.a) {
            f4.f42947a.e(this, ((f.a) fVar).a());
        } else if (fVar instanceof f.c) {
            f4.f42947a.c(this);
        } else if (fVar instanceof f.d) {
            f4.f42947a.f(this);
        } else if (fVar instanceof f.e) {
            f4.f42947a.g(this);
        } else if (fVar instanceof f.b) {
            f4.f42947a.d(this, j(((f.b) fVar).a()));
        } else if (fVar != null) {
            throw new NoWhenBranchMatchedException();
        } else {
            l();
        }
    }

    public final void setActionIconClickListener(View.OnClickListener onClickListener) {
        this.f43655y.f43816f.setOnClickListener(onClickListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setActionText(java.lang.CharSequence r4) {
        /*
            r3 = this;
            eu.bolt.verification.sdk.internal.k4 r0 = r3.f43655y
            eu.bolt.client.design.text.DesignTextView r0 = r0.f43812b
            r0.setText(r4)
            eu.bolt.verification.sdk.internal.k4 r0 = r3.f43655y
            eu.bolt.client.design.text.DesignTextView r0 = r0.f43812b
            java.lang.String r1 = "binding.actionText"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r1 = 0
            r2 = 1
            if (r4 == 0) goto L1d
            boolean r4 = kotlin.text.StringsKt.y(r4)
            if (r4 == 0) goto L1b
            goto L1d
        L1b:
            r4 = 0
            goto L1e
        L1d:
            r4 = 1
        L1e:
            r4 = r4 ^ r2
            if (r4 == 0) goto L22
            goto L24
        L22:
            r1 = 8
        L24:
            r0.setVisibility(r1)
            r3.p()
            r3.o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.j4.setActionText(java.lang.CharSequence):void");
    }

    public final void setActionTextColor(int i8) {
        this.f43655y.f43812b.setTextColor(i8);
    }

    public final void setBody(CharSequence charSequence) {
        boolean z7;
        boolean y7;
        this.f43655y.f43813c.setText(charSequence);
        DesignTextView designTextView = this.f43655y.f43813c;
        Intrinsics.e(designTextView, "binding.body");
        if (charSequence != null) {
            y7 = StringsKt__StringsJVMKt.y(charSequence);
            if (!y7) {
                z7 = false;
                uq.C(designTextView, !z7);
                p();
                o();
            }
        }
        z7 = true;
        uq.C(designTextView, !z7);
        p();
        o();
    }

    public final void setBodyColor(int i8) {
        this.f43655y.f43813c.setTextColor(i8);
    }

    public final void setBodyColor(String hexColor) {
        Intrinsics.f(hexColor, "hexColor");
        setBodyColor(Color.parseColor(hexColor));
    }

    public final void setBodyColorResource(int i8) {
        this.f43655y.f43813c.setTextColor(uq.d(this, i8));
    }

    public final void setCardColor(int i8) {
        setCardBackgroundColor(i8);
    }

    public final void setCardColor(String hexColor) {
        Intrinsics.f(hexColor, "hexColor");
        setCardColor(Color.parseColor(hexColor));
    }

    public final void setImage(aa aaVar) {
        DesignImageView designImageView = this.f43655y.f43817g;
        Intrinsics.e(designImageView, "binding.startIcon");
        uq.C(designImageView, aaVar != null);
        DesignImageView designImageView2 = this.f43655y.f43817g;
        Intrinsics.e(designImageView2, "binding.startIcon");
        DesignImageView.K(designImageView2, aaVar, false, null, 6, null);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f43655y.f43814d.setOnClickListener(onClickListener);
        this.f43655y.f43814d.setBackgroundResource(onClickListener != null ? R$drawable.design_selectable_bg_with_corners : 0);
    }

    public final void setTitle(CharSequence charSequence) {
        boolean z7;
        boolean y7;
        this.f43655y.f43818h.setText(charSequence);
        DesignTextView designTextView = this.f43655y.f43818h;
        Intrinsics.e(designTextView, "binding.title");
        if (charSequence != null) {
            y7 = StringsKt__StringsJVMKt.y(charSequence);
            if (!y7) {
                z7 = false;
                uq.C(designTextView, !z7);
                p();
                o();
            }
        }
        z7 = true;
        uq.C(designTextView, !z7);
        p();
        o();
    }

    public final void setTitleColor(int i8) {
        this.f43655y.f43818h.setTextColor(i8);
    }

    public final void setTitleColor(String hexColor) {
        Intrinsics.f(hexColor, "hexColor");
        setTitleColor(Color.parseColor(hexColor));
    }

    public final void setTitleColorResource(int i8) {
        this.f43655y.f43818h.setTextColor(uq.d(this, i8));
    }

    public final void setUiModel(i4 model) {
        Intrinsics.f(model, "model");
        if (this.f43654x != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.n0(new AutoTransition());
            transitionSet.n0(new gl());
            TransitionManager.b(this, transitionSet);
        }
        model.i();
        n();
        model.d();
        m();
        model.b();
        k();
        setImage(model.f());
        setCardColor(model.c() != null ? model.c().intValue() : -1);
        setActionIcon(model.a());
        this.f43654x = model;
    }
}
