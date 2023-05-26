package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.WindowInsetsCompat;
import eu.bolt.coroutines.extensions.FlowExtensionsKt;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.sdk.internal.c4;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class d4 implements c4 {

    /* renamed from: a  reason: collision with root package name */
    private final e4 f42593a;

    /* renamed from: b  reason: collision with root package name */
    private final jc f42594b;

    /* renamed from: c  reason: collision with root package name */
    private final z0 f42595c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f42596d;

    /* renamed from: e  reason: collision with root package name */
    private Function0<Integer> f42597e;

    /* renamed from: f  reason: collision with root package name */
    private Flow<Integer> f42598f;

    /* renamed from: g  reason: collision with root package name */
    private final s3 f42599g;

    /* renamed from: h  reason: collision with root package name */
    private int f42600h;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<WindowInsetsCompat, Unit> {
        a() {
            super(1);
        }

        public final void b(WindowInsetsCompat it) {
            Intrinsics.f(it, "it");
            d4.this.f42600h = it.l();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WindowInsetsCompat windowInsetsCompat) {
            b(windowInsetsCompat);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42602a;

        static {
            int[] iArr = new int[c4.b.values().length];
            try {
                iArr[c4.b.FULL_SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c4.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c4.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f42602a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f42603f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d4 f42604g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f42605h;

        public c(View view, d4 d4Var, int i8) {
            this.f42603f = view;
            this.f42604g = d4Var;
            this.f42605h = i8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f42604g.f42593a.setBottomOffset(this.f42605h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function0<Integer> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final Integer invoke() {
            return Integer.valueOf(d4.this.f42594b.e());
        }
    }

    /* loaded from: classes5.dex */
    static final class e extends Lambda implements Function0<Integer> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final Integer invoke() {
            return Integer.valueOf(d4.this.f42593a.getMeasuredHeight() / 2);
        }
    }

    @DebugMetadata(c = "eu.bolt.client.design.bottomsheet.DesignBottomSheetDelegateImpl$observeBottomOffset$2", f = "DesignBottomSheetDelegateImpl.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class f extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42608g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ int f42609h;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(continuation);
            fVar.f42609h = ((Number) obj).intValue();
            return fVar;
        }

        public final Object h(int i8, Continuation<? super Unit> continuation) {
            return ((f) create(Integer.valueOf(i8), continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42608g == 0) {
                ResultKt.b(obj);
                d4.this.k(this.f42609h);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object s(Integer num, Continuation<? super Unit> continuation) {
            return h(num.intValue(), continuation);
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f42611f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ View f42612g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ d4 f42613h;

        public g(View view, View view2, d4 d4Var) {
            this.f42611f = view;
            this.f42612g = view2;
            this.f42613h = d4Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            uq.M(this.f42612g, this.f42613h.r());
        }
    }

    public d4(e4 designBottomSheetPanel, jc navigationBarController, n9 hideMode, c4.b heightMode, f7 fadeBackgroundState, wd closeOnOutsideClick, boolean z7) {
        Lazy b8;
        Intrinsics.f(designBottomSheetPanel, "designBottomSheetPanel");
        Intrinsics.f(navigationBarController, "navigationBarController");
        Intrinsics.f(hideMode, "hideMode");
        Intrinsics.f(heightMode, "heightMode");
        Intrinsics.f(fadeBackgroundState, "fadeBackgroundState");
        Intrinsics.f(closeOnOutsideClick, "closeOnOutsideClick");
        this.f42593a = designBottomSheetPanel;
        this.f42594b = navigationBarController;
        this.f42595c = new z0(designBottomSheetPanel);
        b8 = LazyKt__LazyJVMKt.b(new e());
        this.f42596d = b8;
        this.f42597e = q();
        this.f42598f = j();
        this.f42599g = new s3();
        Context context = designBottomSheetPanel.getContext();
        o(hideMode);
        m(heightMode);
        s(z7);
        d(fadeBackgroundState);
        e(closeOnOutsideClick);
        Intrinsics.e(context, "context");
        designBottomSheetPanel.p0(f2.b(context, R$color.transparent_700), fadeBackgroundState);
        uq.B(designBottomSheetPanel, new a());
        t();
    }

    public /* synthetic */ d4(e4 e4Var, jc jcVar, n9 n9Var, c4.b bVar, f7 f7Var, wd wdVar, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(e4Var, jcVar, (i8 & 4) != 0 ? n9.HIDEABLE : n9Var, (i8 & 8) != 0 ? c4.b.WRAP_CONTENT : bVar, (i8 & 16) != 0 ? f7.NEVER : f7Var, (i8 & 32) != 0 ? wd.COLLAPSE_IF_EXPANDED : wdVar, (i8 & 64) != 0 ? false : z7);
    }

    private final int g(Context context) {
        return this.f42600h + f2.n(context, R$dimen.rounded_bottom_sheet_top_margin);
    }

    private final Flow<Integer> j() {
        return this.f42594b.b();
    }

    private final void l(View view) {
        if (this.f42593a.getHeight() != 0) {
            uq.M(view, r());
            return;
        }
        e4 e4Var = this.f42593a;
        Intrinsics.e(OneShotPreDrawListener.a(e4Var, new g(e4Var, view, this)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    }

    private final Function0<Integer> q() {
        return new d();
    }

    @Override // eu.bolt.verification.sdk.internal.j0
    public Object b(Continuation<? super Unit> continuation) {
        Object d8;
        Object e8 = FlowExtensionsKt.e(this.f42598f, new f(null), null, null, null, continuation, 14, null);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        return e8 == d8 ? e8 : Unit.f50853a;
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void c(boolean z7) {
        if (Intrinsics.a(null, Boolean.TRUE)) {
            return;
        }
        if (z7) {
            this.f42593a.setPanelStateInstant(ae.HIDDEN);
        } else {
            this.f42593a.M0();
        }
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void d(f7 state) {
        Intrinsics.f(state, "state");
        this.f42593a.setFadeBackgroundForState(state);
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void e(wd action) {
        Intrinsics.f(action, "action");
        this.f42593a.setCloseOnOutsideClickAction(action);
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void f(boolean z7) {
        k(this.f42597e.invoke().intValue());
        if (Intrinsics.a(null, Boolean.TRUE)) {
            return;
        }
        if (z7) {
            this.f42593a.setPanelStateInstant(ae.EXPANDED);
        } else {
            this.f42593a.G0();
        }
    }

    public void k(int i8) {
        e4 e4Var = this.f42593a;
        Intrinsics.e(OneShotPreDrawListener.a(e4Var, new c(e4Var, this, i8)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    }

    public void m(c4.b heightMode) {
        Intrinsics.f(heightMode, "heightMode");
        vd<View> slidingView = this.f42593a.getSlidingView();
        Intrinsics.e(slidingView, "designBottomSheetPanel.slidingView");
        if (slidingView.f()) {
            View it = slidingView.d();
            int i8 = b.f42602a[heightMode.ordinal()];
            if (i8 == 1) {
                Intrinsics.e(it, "it");
                l(it);
            } else if (i8 == 2) {
                Intrinsics.e(it, "it");
                uq.g0(it);
            } else if (i8 != 3) {
            } else {
                Intrinsics.e(it, "it");
                uq.e0(it);
            }
        }
    }

    public void o(n9 hideMode) {
        Intrinsics.f(hideMode, "hideMode");
        this.f42593a.setHideMode(hideMode);
    }

    public int r() {
        int g8 = uq.g(this.f42593a, 0, false, 3, null);
        Context context = this.f42593a.getContext();
        Intrinsics.e(context, "designBottomSheetPanel.context");
        return g8 - f2.n(context, R$dimen.rounded_bottom_sheet_top_margin);
    }

    public void s(boolean z7) {
        vd<View> slidingView = this.f42593a.getSlidingView();
        Intrinsics.e(slidingView, "designBottomSheetPanel.slidingView");
        if (slidingView.f()) {
            View d8 = slidingView.d();
            if (d8 instanceof b4) {
                ((b4) d8).setCloseButtonVisible(z7);
            }
        }
    }

    public void t() {
        e4 e4Var = this.f42593a;
        Context context = e4Var.getContext();
        Intrinsics.e(context, "designBottomSheetPanel.context");
        e4Var.setSlidingTopPadding(g(context));
    }
}
