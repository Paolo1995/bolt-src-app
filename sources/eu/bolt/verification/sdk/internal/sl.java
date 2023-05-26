package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.sj;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class sl extends hk<sj.c> {

    /* renamed from: h  reason: collision with root package name */
    private final Context f45001h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ ak f45002i;

    /* renamed from: j  reason: collision with root package name */
    private final int f45003j;

    /* renamed from: k  reason: collision with root package name */
    private final int f45004k;

    /* renamed from: l  reason: collision with root package name */
    private final int f45005l;

    /* renamed from: m  reason: collision with root package name */
    private Integer f45006m;

    /* renamed from: n  reason: collision with root package name */
    private DesignTextView f45007n;

    /* renamed from: o  reason: collision with root package name */
    private DesignTextView f45008o;

    /* renamed from: p  reason: collision with root package name */
    private DesignImageView f45009p;

    /* renamed from: q  reason: collision with root package name */
    private Function0<Unit> f45010q;

    /* renamed from: r  reason: collision with root package name */
    private Function1<? super PointF, Unit> f45011r;

    /* renamed from: s  reason: collision with root package name */
    private final GestureDetectorCompat f45012s;

    /* loaded from: classes5.dex */
    public static final class a extends qa {

        /* renamed from: f  reason: collision with root package name */
        private final ViewConfiguration f45013f;

        a() {
            this.f45013f = ViewConfiguration.get(sl.this.f45001h);
        }

        @Override // eu.bolt.verification.sdk.internal.qa, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
            if (f9 < 0.0f || f9 < this.f45013f.getScaledMinimumFlingVelocity()) {
                return false;
            }
            Function0 function0 = sl.this.f45010q;
            if (function0 != null) {
                function0.invoke();
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e8) {
            Intrinsics.f(e8, "e");
            Function1 function1 = sl.this.f45011r;
            if (function1 != null) {
                function1.invoke(new PointF(e8.getX(), e8.getY()));
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sl(Context context, ik listener) {
        super(listener);
        Intrinsics.f(context, "context");
        Intrinsics.f(listener, "listener");
        this.f45001h = context;
        this.f45002i = new ak(listener);
        this.f45003j = R$color.f41697y;
        this.f45004k = R$dimen.f41703l;
        this.f45005l = R$dimen.f41704m;
        this.f45006m = 0;
        this.f45012s = new GestureDetectorCompat(context, new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void B(eu.bolt.verification.sdk.internal.sj.c r4, android.widget.TextView r5) {
        /*
            r3 = this;
            java.lang.String r0 = r4.h()
            if (r0 != 0) goto La
            java.lang.String r0 = r4.g()
        La:
            r4 = 0
            r1 = 1
            if (r0 == 0) goto L17
            boolean r2 = kotlin.text.StringsKt.y(r0)
            if (r2 == 0) goto L15
            goto L17
        L15:
            r2 = 0
            goto L18
        L17:
            r2 = 1
        L18:
            r1 = r1 ^ r2
            if (r1 == 0) goto L1c
            goto L1e
        L1c:
            r4 = 8
        L1e:
            r5.setVisibility(r4)
            if (r0 == 0) goto L2a
            eu.bolt.verification.sdk.internal.mk r4 = r3.z(r0)
            eu.bolt.verification.sdk.internal.pl.a(r5, r4)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.sl.B(eu.bolt.verification.sdk.internal.sj$c, android.widget.TextView):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(sl this$0, View view, MotionEvent motionEvent) {
        Intrinsics.f(this$0, "this$0");
        this$0.f45012s.a(motionEvent);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void G(eu.bolt.verification.sdk.internal.sj.c r4, android.widget.TextView r5) {
        /*
            r3 = this;
            java.lang.String r0 = r4.k()
            if (r0 != 0) goto La
            java.lang.String r0 = r4.j()
        La:
            r4 = 0
            r1 = 1
            if (r0 == 0) goto L17
            boolean r2 = kotlin.text.StringsKt.y(r0)
            if (r2 == 0) goto L15
            goto L17
        L15:
            r2 = 0
            goto L18
        L17:
            r2 = 1
        L18:
            r1 = r1 ^ r2
            if (r1 == 0) goto L1c
            goto L1e
        L1c:
            r4 = 8
        L1e:
            r5.setVisibility(r4)
            if (r0 == 0) goto L2a
            eu.bolt.verification.sdk.internal.mk r4 = r3.z(r0)
            eu.bolt.verification.sdk.internal.pl.a(r5, r4)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.sl.G(eu.bolt.verification.sdk.internal.sj$c, android.widget.TextView):void");
    }

    private final mk z(String str) {
        nk nkVar = new nk();
        nkVar.c(il.b(this.f45001h, new ll.b(str)));
        nkVar.b(this.f45003j);
        nkVar.f(this.f45004k);
        nkVar.e(this.f45005l);
        nkVar.d(this.f45006m);
        return nkVar.a();
    }

    public void A(sj.c slide) {
        Intrinsics.f(slide, "slide");
        this.f45006m = slide.i();
        DesignTextView designTextView = this.f45007n;
        DesignTextView designTextView2 = null;
        if (designTextView == null) {
            Intrinsics.w("slideTitle");
            designTextView = null;
        }
        G(slide, designTextView);
        DesignTextView designTextView3 = this.f45008o;
        if (designTextView3 == null) {
            Intrinsics.w("slideDescription");
        } else {
            designTextView2 = designTextView3;
        }
        B(slide, designTextView2);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    /* renamed from: C */
    public void j(sj.c slide, ConstraintLayout view) {
        List<? extends DesignImageView> e8;
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        View findViewById = view.findViewById(R$id.R0);
        Intrinsics.e(findViewById, "view.findViewById(R.id.slideTitle)");
        this.f45007n = (DesignTextView) findViewById;
        View findViewById2 = view.findViewById(R$id.P0);
        Intrinsics.e(findViewById2, "view.findViewById(R.id.slideDescription)");
        this.f45008o = (DesignTextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.L0);
        Intrinsics.e(findViewById3, "view.findViewById(R.id.slideAssetLottie)");
        DesignImageView designImageView = (DesignImageView) findViewById3;
        this.f45009p = designImageView;
        if (designImageView == null) {
            Intrinsics.w("slideAssetLottie");
            designImageView = null;
        }
        e8 = CollectionsKt__CollectionsJVMKt.e(designImageView);
        h(e8);
        super.j(slide, view);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    /* renamed from: F */
    public void k(sj.c slide) {
        Intrinsics.f(slide, "slide");
        super.k(slide);
        tj a8 = slide.a();
        DesignImageView designImageView = this.f45009p;
        if (designImageView == null) {
            Intrinsics.w("slideAssetLottie");
            designImageView = null;
        }
        g(a8, designImageView);
    }

    @Override // eu.bolt.verification.sdk.internal.jf
    public void a() {
        this.f45002i.a();
    }

    @Override // eu.bolt.verification.sdk.internal.jf
    public void b() {
        this.f45002i.b();
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void c() {
        this.f45002i.c();
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void c(sj slide) {
        Intrinsics.f(slide, "slide");
        this.f45002i.c(slide);
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void d(sj slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f45002i.d(slide, view);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    @SuppressLint({"ClickableViewAccessibility"})
    public void e(ConstraintLayout view, Function0<Unit> onDownFling, Function1<? super PointF, Unit> onSingleTap) {
        Intrinsics.f(view, "view");
        Intrinsics.f(onDownFling, "onDownFling");
        Intrinsics.f(onSingleTap, "onSingleTap");
        this.f45011r = onSingleTap;
        this.f45010q = onDownFling;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.verification.sdk.internal.dw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean D;
                D = sl.D(sl.this, view2, motionEvent);
                return D;
            }
        });
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    public void l() {
        super.l();
        DesignTextView designTextView = this.f45007n;
        DesignTextView designTextView2 = null;
        if (designTextView == null) {
            Intrinsics.w("slideTitle");
            designTextView = null;
        }
        designTextView.setText((CharSequence) null);
        DesignTextView designTextView3 = this.f45007n;
        if (designTextView3 == null) {
            Intrinsics.w("slideTitle");
            designTextView3 = null;
        }
        designTextView3.setVisibility(8);
        DesignTextView designTextView4 = this.f45008o;
        if (designTextView4 == null) {
            Intrinsics.w("slideDescription");
            designTextView4 = null;
        }
        designTextView4.setText((CharSequence) null);
        DesignTextView designTextView5 = this.f45008o;
        if (designTextView5 == null) {
            Intrinsics.w("slideDescription");
        } else {
            designTextView2 = designTextView5;
        }
        designTextView2.setVisibility(8);
    }

    @Override // eu.bolt.verification.sdk.internal.hk
    public int o() {
        return R$layout.view_story_slide_top_left_content;
    }
}
