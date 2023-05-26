package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import eu.bolt.verification.sdk.internal.jc;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes5.dex */
public final class kc implements jc {

    /* renamed from: g  reason: collision with root package name */
    private static final a f43845g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Activity f43846a;

    /* renamed from: b  reason: collision with root package name */
    private final kb f43847b;

    /* renamed from: c  reason: collision with root package name */
    private final jc.b f43848c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f43849d;

    /* renamed from: e  reason: collision with root package name */
    private final MutableStateFlow<Integer> f43850e;

    /* renamed from: f  reason: collision with root package name */
    private jc.a f43851f;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Flow<Integer> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f43852f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ kc f43853g;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f43854f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ kc f43855g;

            @DebugMetadata(c = "eu.bolt.client.design.controller.overlay.implementation.NavigationBarControllerImpl$observeBottomInsetsFlow$$inlined$map$1$2", f = "NavigationBarControllerImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.kc$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0068a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f43856f;

                /* renamed from: g  reason: collision with root package name */
                int f43857g;

                public C0068a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f43856f = obj;
                    this.f43857g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector, kc kcVar) {
                this.f43854f = flowCollector;
                this.f43855g = kcVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.kc.b.a.C0068a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.kc$b$a$a r0 = (eu.bolt.verification.sdk.internal.kc.b.a.C0068a) r0
                    int r1 = r0.f43857g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f43857g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.kc$b$a$a r0 = new eu.bolt.verification.sdk.internal.kc$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f43856f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f43857g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L53
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f43854f
                    java.lang.Number r5 = (java.lang.Number) r5
                    int r5 = r5.intValue()
                    eu.bolt.verification.sdk.internal.kc r2 = r4.f43855g
                    boolean r2 = eu.bolt.verification.sdk.internal.kc.j(r2)
                    if (r2 == 0) goto L45
                    goto L46
                L45:
                    r5 = 0
                L46:
                    java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.b(r5)
                    r0.f43857g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L53
                    return r1
                L53:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.kc.b.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public b(Flow flow, kc kcVar) {
            this.f43852f = flow;
            this.f43853g = kcVar;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f43852f.a(new a(flowCollector, this.f43853g), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    @Inject
    public kc(Activity activity, kb keyboardStateProvider) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(keyboardStateProvider, "keyboardStateProvider");
        this.f43846a = activity;
        this.f43847b = keyboardStateProvider;
        jc.b bVar = activity instanceof jc.b ? (jc.b) activity : null;
        this.f43848c = bVar;
        this.f43849d = bVar != null;
        this.f43850e = StateFlowKt.a(0);
        this.f43851f = new jc.a(false, n(), k(), 0);
    }

    private final void c(int i8) {
        Integer value;
        View m8 = m();
        m8.setPadding(m8.getPaddingLeft(), m8.getPaddingTop(), m8.getPaddingRight(), this.f43851f.f() ? 0 : i8);
        this.f43851f = jc.a.a(this.f43851f, false, 0, false, i8, 7, null);
        MutableStateFlow<Integer> mutableStateFlow = this.f43850e;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.g(value, Integer.valueOf(i8)));
    }

    private final void f(Window window, boolean z7) {
        WindowCompat.a(window, window.getDecorView()).c(z7);
    }

    private final boolean k() {
        Window window = this.f43846a.getWindow();
        return Build.VERSION.SDK_INT >= 26 && !WindowCompat.a(window, window.getDecorView()).a();
    }

    private final View m() {
        View decorView = this.f43846a.getWindow().getDecorView();
        Intrinsics.e(decorView, "activity.window.decorView");
        return decorView;
    }

    private final int n() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f43846a.getWindow().getNavigationBarColor();
        }
        return -16777216;
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public void a() {
        if (!this.f43849d) {
            if (this.f43848c == null) {
                t3.c("NavigationBarController enableTransparentNavigationBar should be used in Delegate activity", null, 2, null);
                Unit unit = Unit.f50853a;
                return;
            }
            return;
        }
        jc.b bVar = this.f43848c;
        if (bVar != null) {
            bVar.a();
        }
        m().requestApplyInsets();
        this.f43851f = jc.a.a(this.f43851f, true, 0, false, 0, 14, null);
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public Flow<Integer> b() {
        return new b(this.f43850e, this);
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public int c() {
        return this.f43851f.e();
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public jc.a d() {
        return this.f43851f;
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public int e() {
        return this.f43850e.getValue().intValue();
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public boolean g() {
        return this.f43849d;
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public void h(int i8, boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (!this.f43849d || !this.f43851f.f()) {
                this.f43846a.getWindow().setNavigationBarColor(i8);
            }
            Window window = this.f43846a.getWindow();
            Intrinsics.e(window, "activity.window");
            f(window, z7);
        }
        this.f43851f = jc.a.a(this.f43851f, false, i8, z7, 0, 9, null);
    }

    @Override // eu.bolt.verification.sdk.internal.jc
    public void i(jc.a config) {
        Intrinsics.f(config, "config");
        if (this.f43849d) {
            if (config.f()) {
                a();
            } else {
                l();
            }
            c(config.e());
        }
        h(config.d(), config.c());
    }

    public void l() {
        if (this.f43849d) {
            m().requestApplyInsets();
            this.f43851f = jc.a.a(this.f43851f, false, 0, false, 0, 14, null);
        } else if (this.f43848c == null) {
            t3.c("NavigationBarController disableTransparentNavigationBar should be used in Delegate activity", null, 2, null);
            Unit unit = Unit.f50853a;
        }
    }
}
