package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.NestedScrollView;
import eu.bolt.client.design.button.DesignButton;
import eu.bolt.client.design.button.a;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;
import eu.bolt.verification.sdk.internal.bk;
import eu.bolt.verification.sdk.internal.oi;
import eu.bolt.verification.sdk.internal.ri;
import eu.bolt.verification.sdk.internal.sj;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class rl extends hk<sj.a> {

    /* renamed from: t  reason: collision with root package name */
    public static final a f44847t = new a(null);

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f44848h;

    /* renamed from: i  reason: collision with root package name */
    private DesignTextView f44849i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f44850j;

    /* renamed from: k  reason: collision with root package name */
    private NestedScrollView f44851k;

    /* renamed from: l  reason: collision with root package name */
    private eu.bolt.client.design.button.a f44852l;

    /* renamed from: m  reason: collision with root package name */
    private final float f44853m;

    /* renamed from: n  reason: collision with root package name */
    private final LinkedHashMap<DesignImageView, tj> f44854n;

    /* renamed from: o  reason: collision with root package name */
    private final LinkedHashMap<View, ViewGroup.LayoutParams> f44855o;

    /* renamed from: p  reason: collision with root package name */
    private final ah f44856p;

    /* renamed from: q  reason: collision with root package name */
    private Function0<Unit> f44857q;

    /* renamed from: r  reason: collision with root package name */
    private Function1<? super PointF, Unit> f44858r;

    /* renamed from: s  reason: collision with root package name */
    private final GestureDetectorCompat f44859s;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44860a;

        static {
            int[] iArr = new int[bk.a.values().length];
            try {
                iArr[bk.a.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[bk.a.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[bk.a.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f44860a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.f(view, "view");
            Intrinsics.f(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), rl.this.f44853m);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends qa {

        /* renamed from: f  reason: collision with root package name */
        private final ViewConfiguration f44862f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ rl f44863g;

        d(Context context, rl rlVar) {
            this.f44863g = rlVar;
            this.f44862f = ViewConfiguration.get(context);
        }

        @Override // eu.bolt.verification.sdk.internal.qa, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
            NestedScrollView nestedScrollView = this.f44863g.f44851k;
            if (nestedScrollView == null) {
                Intrinsics.w("scrollView");
                nestedScrollView = null;
            }
            if (nestedScrollView.getScrollY() == 0 && f9 >= 0.0f && f9 >= this.f44862f.getScaledMinimumFlingVelocity()) {
                Function0 function0 = this.f44863g.f44857q;
                if (function0 != null) {
                    function0.invoke();
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e8) {
            Intrinsics.f(e8, "e");
            Function1 function1 = this.f44863g.f44858r;
            if (function1 != null) {
                function1.invoke(new PointF(e8.getX(), e8.getY()));
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rl(Context context, ik listener) {
        super(listener);
        Intrinsics.f(context, "context");
        Intrinsics.f(listener, "listener");
        this.f44853m = f2.i(context, 12.0f);
        this.f44854n = new LinkedHashMap<>();
        this.f44855o = new LinkedHashMap<>();
        this.f44856p = new ah(0.0f, 1, null);
        this.f44859s = new GestureDetectorCompat(context, new d(context, this));
    }

    private final int A(bk.a aVar) {
        int i8 = b.f44860a[aVar.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return 8388613;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 17;
        }
        return 8388611;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final eu.bolt.client.design.button.a B(yj yjVar, final sj sjVar) {
        DesignButton.b bVar;
        ri d8 = yjVar.d();
        if (Intrinsics.a(d8, ri.b.f44837g)) {
            bVar = DesignButton.b.Primary;
        } else if (Intrinsics.a(d8, ri.c.f44838g)) {
            bVar = DesignButton.b.Secondary;
        } else if (Intrinsics.a(d8, ri.d.f44839g)) {
            bVar = DesignButton.b.Text;
        } else if (!Intrinsics.a(d8, ri.a.f44836g)) {
            throw new NoWhenBranchMatchedException();
        } else {
            bVar = DesignButton.b.Danger;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        LinearLayout linearLayout = this.f44850j;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        Context context = linearLayout.getContext();
        Intrinsics.e(context, "buttonContainer.context");
        int i8 = R$dimen.f41699b;
        int n8 = f2.n(context, i8);
        LinearLayout linearLayout3 = this.f44850j;
        if (linearLayout3 == null) {
            Intrinsics.w("buttonContainer");
            linearLayout3 = null;
        }
        Context context2 = linearLayout3.getContext();
        Intrinsics.e(context2, "buttonContainer.context");
        int i9 = R$dimen.f41700i;
        int n9 = f2.n(context2, i9);
        LinearLayout linearLayout4 = this.f44850j;
        if (linearLayout4 == null) {
            Intrinsics.w("buttonContainer");
            linearLayout4 = null;
        }
        Context context3 = linearLayout4.getContext();
        Intrinsics.e(context3, "buttonContainer.context");
        int n10 = f2.n(context3, i8);
        LinearLayout linearLayout5 = this.f44850j;
        if (linearLayout5 == null) {
            Intrinsics.w("buttonContainer");
            linearLayout5 = null;
        }
        Context context4 = linearLayout5.getContext();
        Intrinsics.e(context4, "buttonContainer.context");
        marginLayoutParams.setMargins(n8, n9, n10, f2.n(context4, i9));
        a.C0024a c0024a = eu.bolt.client.design.button.a.f39995x;
        LinearLayout linearLayout6 = this.f44850j;
        if (linearLayout6 == null) {
            Intrinsics.w("buttonContainer");
        } else {
            linearLayout2 = linearLayout6;
        }
        Context context5 = linearLayout2.getContext();
        Intrinsics.e(context5, "buttonContainer.context");
        eu.bolt.client.design.button.a a8 = c0024a.a(context5, bVar);
        a8.setLayoutParams(marginLayoutParams);
        a8.setId(R$id.T0);
        a8.setText(yjVar.e());
        a8.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.zv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rl.E(rl.this, sjVar, view);
            }
        });
        return a8;
    }

    private final void C(bk.b.a aVar, int i8) {
        LinearLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f44848h;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        Context context = viewGroup.getContext();
        Intrinsics.e(context, "slideContentContainer.context");
        DesignImageView designImageView = new DesignImageView(context, null, 0, 6, null);
        this.f44854n.put(designImageView, aVar.b());
        oi a8 = aVar.b().a();
        if (a8 instanceof oi.b) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            designImageView.setAdjustViewBounds(true);
        } else if (a8 instanceof oi.a) {
            Context context2 = designImageView.getContext();
            Intrinsics.e(context2, "view.context");
            oi.a aVar2 = (oi.a) a8;
            int a9 = f2.a(context2, aVar2.b());
            Context context3 = designImageView.getContext();
            Intrinsics.e(context3, "view.context");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a9, f2.a(context3, aVar2.a()));
            layoutParams2.gravity = A(aVar.a());
            layoutParams = layoutParams2;
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = A(aVar.a());
            layoutParams = layoutParams3;
        }
        layoutParams.topMargin = i8;
        this.f44855o.put(designImageView, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void D(eu.bolt.verification.sdk.internal.bk.b.C0037b r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            eu.bolt.client.design.listitem.DesignListItemView r7 = new eu.bolt.client.design.listitem.DesignListItemView
            android.view.ViewGroup r1 = r0.f44848h
            r8 = 0
            if (r1 != 0) goto Lf
            java.lang.String r1 = "slideContentContainer"
            kotlin.jvm.internal.Intrinsics.w(r1)
            r1 = r8
        Lf:
            android.content.Context r2 = r1.getContext()
            java.lang.String r1 = "slideContentContainer.context"
            kotlin.jvm.internal.Intrinsics.e(r2, r1)
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.String r1 = r20.b()
            r2 = 0
            if (r1 == 0) goto L30
            boolean r1 = kotlin.text.StringsKt.y(r1)
            if (r1 == 0) goto L2e
            goto L30
        L2e:
            r1 = 0
            goto L31
        L30:
            r1 = 1
        L31:
            if (r1 != 0) goto L4c
            eu.bolt.verification.sdk.internal.aa$g r1 = new eu.bolt.verification.sdk.internal.aa$g
            java.lang.String r10 = r20.b()
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 126(0x7e, float:1.77E-43)
            r18 = 0
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r7.setIconImageModel(r1)
            goto L50
        L4c:
            r1 = 2
            eu.bolt.client.design.listitem.DesignListItemView.K(r7, r8, r8, r1, r8)
        L50:
            java.lang.String r1 = r20.c()
            eu.bolt.verification.sdk.internal.ll$b r1 = eu.bolt.verification.sdk.internal.il.a(r1)
            r7.setTitleTextModel(r1)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r7.setTitleMaxLines(r1)
            r7.setMinimumHeight(r2)
            android.content.res.Resources r1 = r7.getResources()
            int r3 = eu.bolt.verification.R$dimen.big_margin
            int r1 = r1.getDimensionPixelSize(r3)
            r7.setPadding(r1, r2, r1, r2)
            eu.bolt.verification.sdk.internal.z4 r1 = r7.getBinding()
            eu.bolt.client.design.text.DesignTextView r1 = r1.f45815r
            eu.bolt.verification.sdk.internal.bk$a r2 = r20.a()
            int r2 = r0.K(r2)
            r1.setTextAlignment(r2)
            eu.bolt.verification.sdk.internal.z4 r1 = r7.getBinding()
            eu.bolt.client.design.text.DesignTextView r1 = r1.f45814q
            java.lang.String r2 = "binding.subtitle"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            r2 = 8
            r1.setVisibility(r2)
            android.view.ViewGroup$MarginLayoutParams r1 = new android.view.ViewGroup$MarginLayoutParams
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)
            r2 = r21
            r1.topMargin = r2
            java.util.LinkedHashMap<android.view.View, android.view.ViewGroup$LayoutParams> r2 = r0.f44855o
            r2.put(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.rl.D(eu.bolt.verification.sdk.internal.bk$b$b, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(rl this$0, sj slide, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(slide, "$slide");
        this$0.p().b(slide, this$0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void H(java.lang.String r6) {
        /*
            r5 = this;
            eu.bolt.client.design.text.DesignTextView r0 = r5.f44849i
            r1 = 0
            java.lang.String r2 = "slideFooterTextView"
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.w(r2)
            r0 = r1
        Lb:
            r3 = 1
            if (r6 == 0) goto L17
            boolean r4 = kotlin.text.StringsKt.y(r6)
            if (r4 == 0) goto L15
            goto L17
        L15:
            r4 = 0
            goto L18
        L17:
            r4 = 1
        L18:
            r3 = r3 ^ r4
            eu.bolt.verification.sdk.internal.uq.C(r0, r3)
            eu.bolt.client.design.text.DesignTextView r0 = r5.f44849i
            if (r0 != 0) goto L24
            kotlin.jvm.internal.Intrinsics.w(r2)
            goto L25
        L24:
            r1 = r0
        L25:
            r1.setText(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.rl.H(java.lang.String):void");
    }

    private final void I(List<? extends bk.b> list, int i8) {
        int i9 = 0;
        for (Object obj : list) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            bk.b bVar = (bk.b) obj;
            int i11 = i9 > 0 ? i8 : 0;
            if (bVar instanceof bk.b.C0037b) {
                D((bk.b.C0037b) bVar, i11);
            } else if (!(bVar instanceof bk.b.a)) {
                throw new NoWhenBranchMatchedException();
            } else {
                C((bk.b.a) bVar, i11);
            }
            Unit unit = Unit.f50853a;
            i9 = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(rl this$0, View view, MotionEvent motionEvent) {
        Intrinsics.f(this$0, "this$0");
        this$0.f44859s.a(motionEvent);
        return false;
    }

    private final int K(bk.a aVar) {
        int i8 = b.f44860a[aVar.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return 3;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 4;
        }
        return 2;
    }

    private final void P(sj sjVar) {
        LinearLayout linearLayout = this.f44850j;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        if (sjVar.d() == null) {
            this.f44852l = null;
            return;
        }
        this.f44852l = B(sjVar.d(), sjVar);
        LinearLayout linearLayout3 = this.f44850j;
        if (linearLayout3 == null) {
            Intrinsics.w("buttonContainer");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(this.f44852l);
    }

    public void F(sj.a slide) {
        Intrinsics.f(slide, "slide");
        ViewGroup viewGroup = this.f44848h;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        for (Map.Entry<View, ViewGroup.LayoutParams> entry : this.f44855o.entrySet()) {
            ViewGroup viewGroup3 = this.f44848h;
            if (viewGroup3 == null) {
                Intrinsics.w("slideContentContainer");
                viewGroup3 = null;
            }
            viewGroup3.addView(entry.getKey(), entry.getValue());
        }
        ViewGroup viewGroup4 = this.f44848h;
        if (viewGroup4 == null) {
            Intrinsics.w("slideContentContainer");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.setVisibility(0);
        H(slide.h());
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    /* renamed from: G */
    public void j(sj.a slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        View findViewById = view.findViewById(R$id.Q0);
        Intrinsics.e(findViewById, "view.findViewById(R.id.slideFooterTextView)");
        this.f44849i = (DesignTextView) findViewById;
        View findViewById2 = view.findViewById(R$id.O0);
        Intrinsics.e(findViewById2, "view.findViewById(R.id.slideContentContainer)");
        this.f44848h = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R$id.f41723i);
        Intrinsics.e(findViewById3, "view.findViewById(R.id.buttonContainer)");
        this.f44850j = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R$id.I0);
        Intrinsics.e(findViewById4, "view.findViewById(R.id.scrollContainer)");
        this.f44851k = (NestedScrollView) findViewById4;
        ViewGroup viewGroup = this.f44848h;
        LinearLayout linearLayout = null;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        viewGroup.setClipToOutline(true);
        ViewGroup viewGroup2 = this.f44848h;
        if (viewGroup2 == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup2 = null;
        }
        viewGroup2.setOutlineProvider(new c());
        ah ahVar = this.f44856p;
        NestedScrollView nestedScrollView = this.f44851k;
        if (nestedScrollView == null) {
            Intrinsics.w("scrollView");
            nestedScrollView = null;
        }
        LinearLayout linearLayout2 = this.f44850j;
        if (linearLayout2 == null) {
            Intrinsics.w("buttonContainer");
        } else {
            linearLayout = linearLayout2;
        }
        ahVar.c(nestedScrollView, linearLayout);
        super.j(slide, view);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    /* renamed from: M */
    public void k(sj.a slide) {
        List<? extends DesignImageView> H0;
        Intrinsics.f(slide, "slide");
        super.k(slide);
        ViewGroup viewGroup = this.f44848h;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        this.f44854n.clear();
        this.f44855o.clear();
        viewGroup.removeAllViews();
        viewGroup.setBackgroundColor(slide.g().a());
        bk.c d8 = slide.g().d();
        Context context = viewGroup.getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, d8.b());
        Context context2 = viewGroup.getContext();
        Intrinsics.e(context2, "context");
        int a9 = f2.a(context2, d8.d());
        Context context3 = viewGroup.getContext();
        Intrinsics.e(context3, "context");
        int a10 = f2.a(context3, d8.c());
        Context context4 = viewGroup.getContext();
        Intrinsics.e(context4, "context");
        viewGroup.setPadding(a8, a9, a10, f2.a(context4, d8.a()));
        LinearLayout linearLayout = this.f44850j;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        linearLayout.setBackgroundColor(slide.c());
        ViewGroup viewGroup3 = this.f44848h;
        if (viewGroup3 == null) {
            Intrinsics.w("slideContentContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        Context context5 = viewGroup2.getContext();
        Intrinsics.e(context5, "slideContentContainer.context");
        I(slide.g().b(), f2.a(context5, slide.g().c()));
        Set<DesignImageView> keySet = this.f44854n.keySet();
        Intrinsics.e(keySet, "slideImageAssets.keys");
        H0 = CollectionsKt___CollectionsKt.H0(keySet);
        h(H0);
        if (this.f44854n.isEmpty()) {
            F(slide);
            return;
        }
        for (Map.Entry<DesignImageView, tj> entry : this.f44854n.entrySet()) {
            g(entry.getValue(), entry.getKey());
        }
    }

    @Override // eu.bolt.verification.sdk.internal.jf
    public void a() {
        eu.bolt.client.design.button.a aVar = this.f44852l;
        if (aVar != null) {
            eu.bolt.client.design.button.a.v(aVar, true, false, 2, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.jf
    public void b() {
        eu.bolt.client.design.button.a aVar = this.f44852l;
        if (aVar != null) {
            eu.bolt.client.design.button.a.v(aVar, false, false, 2, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void c() {
        LinearLayout linearLayout = this.f44850j;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        this.f44852l = null;
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void c(sj slide) {
        Intrinsics.f(slide, "slide");
        P(slide);
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void d(sj slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        P(slide);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    @SuppressLint({"ClickableViewAccessibility"})
    public void e(ConstraintLayout view, Function0<Unit> onDownFling, Function1<? super PointF, Unit> onSingleTap) {
        Intrinsics.f(view, "view");
        Intrinsics.f(onDownFling, "onDownFling");
        Intrinsics.f(onSingleTap, "onSingleTap");
        this.f44857q = onDownFling;
        this.f44858r = onSingleTap;
        NestedScrollView nestedScrollView = this.f44851k;
        if (nestedScrollView == null) {
            Intrinsics.w("scrollView");
            nestedScrollView = null;
        }
        nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.verification.sdk.internal.aw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean J;
                J = rl.J(rl.this, view2, motionEvent);
                return J;
            }
        });
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    public void l() {
        super.l();
        this.f44854n.clear();
        this.f44855o.clear();
        DesignTextView designTextView = this.f44849i;
        ViewGroup viewGroup = null;
        if (designTextView == null) {
            Intrinsics.w("slideFooterTextView");
            designTextView = null;
        }
        designTextView.setText((CharSequence) null);
        ViewGroup viewGroup2 = this.f44848h;
        if (viewGroup2 == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup2 = null;
        }
        viewGroup2.removeAllViews();
        ViewGroup viewGroup3 = this.f44848h;
        if (viewGroup3 == null) {
            Intrinsics.w("slideContentContainer");
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setVisibility(8);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    public int o() {
        return R$layout.I;
    }
}
