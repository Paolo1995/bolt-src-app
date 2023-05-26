package ee.mtakso.driver.ui.screens.permission_onboarding;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.ui.fragments.ProgressDialogFragment;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.SpannableUtilsKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import ee.mtakso.driver.utils.animations.AnimationUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import x1.a;
import x1.b;

/* compiled from: PermissionOnboardingFragment.kt */
/* loaded from: classes3.dex */
public final class PermissionOnboardingFragment extends Fragment {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f32486o = new Companion(null);
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public AnalyticsManager f32487f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public OnBoardingManager f32488g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    public DriverProvider f32489h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public PowerManager f32490i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public LoginAnalytics f32491j;

    /* renamed from: k  reason: collision with root package name */
    private OnBoardingStep f32492k;

    /* renamed from: l  reason: collision with root package name */
    private OnboardingStepListener f32493l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f32494m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f32495n = new LinkedHashMap();

    /* compiled from: PermissionOnboardingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PermissionOnboardingFragment a(OnBoardingStep.Type onboardingStep) {
            Intrinsics.f(onboardingStep, "onboardingStep");
            PermissionOnboardingFragment permissionOnboardingFragment = new PermissionOnboardingFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_onboarding_step", onboardingStep);
            permissionOnboardingFragment.setArguments(bundle);
            return permissionOnboardingFragment;
        }
    }

    /* compiled from: PermissionOnboardingFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32496a;

        static {
            int[] iArr = new int[OnBoardingStep.Type.values().length];
            try {
                iArr[OnBoardingStep.Type.PERMISSION_OVERLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OnBoardingStep.Type.PERMISSION_BATTERY_EXCLUSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f32496a = iArr;
        }
    }

    @SuppressLint({"NewApi"})
    private final Disposable S() {
        Single u7 = Single.u(new Callable() { // from class: z4.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean T;
                T = PermissionOnboardingFragment.T(PermissionOnboardingFragment.this);
                return T;
            }
        });
        final Function1<Boolean, SingleSource<? extends Boolean>> function1 = new Function1<Boolean, SingleSource<? extends Boolean>>() { // from class: ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment$checkPermissions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Boolean> invoke(Boolean it) {
                Single f02;
                Intrinsics.f(it, "it");
                f02 = PermissionOnboardingFragment.this.f0(it.booleanValue());
                return f02;
            }
        };
        Single z7 = u7.r(new Function() { // from class: z4.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource U;
                U = PermissionOnboardingFragment.U(Function1.this, obj);
                return U;
            }
        }).F(new RetryWithDelaySingle(3, 1000L)).K(Schedulers.a()).z(AndroidSchedulers.a());
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment$checkPermissions$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PermissionOnboardingFragment.this.l0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = z7.n(new Consumer() { // from class: z4.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PermissionOnboardingFragment.V(Function1.this, obj);
            }
        });
        final Function2<Boolean, Throwable, Unit> function2 = new Function2<Boolean, Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment$checkPermissions$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(Boolean bool, Throwable th) {
                PermissionOnboardingFragment.this.i0();
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Boolean bool, Throwable th) {
                b(bool, th);
                return Unit.f50853a;
            }
        };
        Single m8 = n8.m(new BiConsumer() { // from class: z4.h
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                PermissionOnboardingFragment.W(Function2.this, obj, obj2);
            }
        });
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment$checkPermissions$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                OnboardingStepListener onboardingStepListener;
                OnBoardingStep onBoardingStep;
                onboardingStepListener = PermissionOnboardingFragment.this.f32493l;
                if (onboardingStepListener != null) {
                    onBoardingStep = PermissionOnboardingFragment.this.f32492k;
                    if (onBoardingStep == null) {
                        Intrinsics.w("currentOnboardingStep");
                        onBoardingStep = null;
                    }
                    onboardingStepListener.h(onBoardingStep.f());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: z4.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PermissionOnboardingFragment.X(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment$checkPermissions$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                AnimationUtils.b((RoundButton) PermissionOnboardingFragment.this.M(R.id.onboarding_action_button));
            }
        };
        Disposable I = m8.I(consumer, new Consumer() { // from class: z4.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PermissionOnboardingFragment.Y(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "@SuppressLint(\"NewApi\") …\n                })\n    }");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean T(PermissionOnboardingFragment this$0) {
        Intrinsics.f(this$0, "this$0");
        return Boolean.valueOf(b.a(this$0.getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final ValueAnimator Z(View view) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.1f, 1.3f), PropertyValuesHolder.ofFloat("scaleY", 1.1f, 1.3f), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.5f));
        Intrinsics.e(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…a\", 1.0f, 0.5f)\n        )");
        ofPropertyValuesHolder.setDuration(1500L);
        ofPropertyValuesHolder.setStartDelay(500L);
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(2);
        return ofPropertyValuesHolder;
    }

    private final OnBoardingStep.Type e0() {
        Serializable serializable;
        Bundle arguments = getArguments();
        boolean z7 = false;
        if (arguments != null && !arguments.containsKey("extra_onboarding_step")) {
            z7 = true;
        }
        if (!z7) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                serializable = arguments2.getSerializable("extra_onboarding_step");
            } else {
                serializable = null;
            }
            Intrinsics.d(serializable, "null cannot be cast to non-null type ee.mtakso.driver.onboarding.steps.OnBoardingStep.Type");
            return (OnBoardingStep.Type) serializable;
        }
        throw new IllegalArgumentException("PermissionOnboardingFragment should be called with OnboardingStep arg!".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<Boolean> f0(boolean z7) {
        if (z7) {
            Single<Boolean> w7 = Single.w(Boolean.valueOf(z7));
            Intrinsics.e(w7, "just(isPermissionProvided)");
            return w7;
        }
        Single<Boolean> error = Single.error(new IllegalStateException(getString(R.string.error_draw_over_others_not_provided)));
        Intrinsics.e(error, "error<Boolean>(IllegalSt…er_others_not_provided)))");
        return error;
    }

    private final void h0(ActivityNotFoundException activityNotFoundException) {
        boolean w7;
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", requireContext().getPackageName());
        String str = Build.MANUFACTURER;
        w7 = StringsKt__StringsJVMKt.w(str, "xiaomi", true);
        if (w7 && intent.resolveActivity(requireContext().getPackageManager()) != null) {
            startActivityForResult(intent, 5501);
            return;
        }
        Kalev.e(activityNotFoundException, str + " There is not settings application to grant permission");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        if (!requireFragmentManager().isDestroyed()) {
            try {
                DialogFragment dialogFragment = (DialogFragment) requireFragmentManager().findFragmentByTag("loadingDialog");
                if (dialogFragment != null) {
                    dialogFragment.dismissAllowingStateLoss();
                }
                requireFragmentManager().executePendingTransactions();
            } catch (IllegalStateException e8) {
                Kalev.e(e8, "Exception while hiding loading");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(PermissionOnboardingFragment this$0, CompoundButton compoundButton, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        this$0.b0().t().E().b(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(PermissionOnboardingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        OnBoardingStep onBoardingStep = this$0.f32492k;
        if (onBoardingStep == null) {
            Intrinsics.w("currentOnboardingStep");
            onBoardingStep = null;
        }
        NavigationCommand<Fragment> g8 = onBoardingStep.g(5501);
        if (g8 != null) {
            try {
                g8.a(this$0);
            } catch (Exception e8) {
                OnBoardingStep onBoardingStep2 = this$0.f32492k;
                if (onBoardingStep2 == null) {
                    Intrinsics.w("currentOnboardingStep");
                    onBoardingStep2 = null;
                }
                Kalev.e(e8, "Not able to start intent for " + onBoardingStep2 + " step!");
                AnalyticsManager a02 = this$0.a0();
                Event event = new Event("Permission Guide Open Failed", null, null, null, 14, null);
                OnBoardingStep onBoardingStep3 = this$0.f32492k;
                if (onBoardingStep3 == null) {
                    Intrinsics.w("currentOnboardingStep");
                    onBoardingStep3 = null;
                }
                a02.c(event.a("step", onBoardingStep3.f()).a("error", e8.getMessage()));
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this$0.requireContext().getPackageName(), null));
                try {
                    this$0.startActivityForResult(intent, 5501);
                } catch (ActivityNotFoundException e9) {
                    this$0.h0(e9);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        if (requireFragmentManager().findFragmentByTag("loadingDialog") != null) {
            return;
        }
        try {
            ProgressDialogFragment.D().show(requireFragmentManager(), "loadingDialog");
            requireFragmentManager().executePendingTransactions();
        } catch (Exception e8) {
            Kalev.e(e8, "Exception while showing loading!");
        }
    }

    public void L() {
        this.f32495n.clear();
    }

    public View M(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32495n;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final AnalyticsManager a0() {
        AnalyticsManager analyticsManager = this.f32487f;
        if (analyticsManager != null) {
            return analyticsManager;
        }
        Intrinsics.w("analyticsManager");
        return null;
    }

    public final DriverProvider b0() {
        DriverProvider driverProvider = this.f32489h;
        if (driverProvider != null) {
            return driverProvider;
        }
        Intrinsics.w("driverProvider");
        return null;
    }

    public final LoginAnalytics c0() {
        LoginAnalytics loginAnalytics = this.f32491j;
        if (loginAnalytics != null) {
            return loginAnalytics;
        }
        Intrinsics.w("loginAnalytics");
        return null;
    }

    public final OnBoardingManager d0() {
        OnBoardingManager onBoardingManager = this.f32488g;
        if (onBoardingManager != null) {
            return onBoardingManager;
        }
        Intrinsics.w("onBoardingManager");
        return null;
    }

    public final PowerManager g0() {
        PowerManager powerManager = this.f32490i;
        if (powerManager != null) {
            return powerManager;
        }
        Intrinsics.w("powerManager");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        if (i8 == 5501) {
            OnBoardingStep onBoardingStep = this.f32492k;
            OnBoardingStep onBoardingStep2 = null;
            if (onBoardingStep == null) {
                Intrinsics.w("currentOnboardingStep");
                onBoardingStep = null;
            }
            int i10 = WhenMappings.f32496a[onBoardingStep.f().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    OnboardingStepListener onboardingStepListener = this.f32493l;
                    if (onboardingStepListener != null) {
                        OnBoardingStep onBoardingStep3 = this.f32492k;
                        if (onBoardingStep3 == null) {
                            Intrinsics.w("currentOnboardingStep");
                        } else {
                            onBoardingStep2 = onBoardingStep3;
                        }
                        onboardingStepListener.h(onBoardingStep2.f());
                        return;
                    }
                    return;
                }
                if (!a.a(g0(), requireContext().getPackageName())) {
                    AnimationUtils.b((RoundButton) M(R.id.onboarding_action_button));
                }
                OnboardingStepListener onboardingStepListener2 = this.f32493l;
                if (onboardingStepListener2 != null) {
                    OnBoardingStep onBoardingStep4 = this.f32492k;
                    if (onBoardingStep4 == null) {
                        Intrinsics.w("currentOnboardingStep");
                    } else {
                        onBoardingStep2 = onBoardingStep4;
                    }
                    onboardingStepListener2.h(onBoardingStep2.f());
                }
            } else if (DisposableExtKt.b(this.f32494m)) {
                this.f32494m = S();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        OnboardingStepListener onboardingStepListener;
        Intrinsics.f(context, "context");
        super.onAttach(context);
        if (context instanceof OnboardingStepListener) {
            onboardingStepListener = (OnboardingStepListener) context;
        } else {
            onboardingStepListener = null;
        }
        this.f32493l = onboardingStepListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Injector.f20166d.b().Y0(this);
        super.onCreate(bundle);
        OnBoardingStep a8 = d0().a(e0());
        this.f32492k = a8;
        if (a8 == null) {
            Intrinsics.w("currentOnboardingStep");
            a8 = null;
        }
        if (a8.f() == OnBoardingStep.Type.PERMISSION_OVERLAY) {
            c0().C2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_permission_onboarding, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        L();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        int E;
        Object F;
        OnboardingStepListener onboardingStepListener;
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        if (i8 == 5501 && permissions.length == 1 && grantResults.length == 1) {
            E = ArraysKt___ArraysKt.E(grantResults);
            if (E == 0) {
                OnBoardingStep onBoardingStep = this.f32492k;
                OnBoardingStep onBoardingStep2 = null;
                if (onBoardingStep == null) {
                    Intrinsics.w("currentOnboardingStep");
                    onBoardingStep = null;
                }
                if (onBoardingStep.f() == OnBoardingStep.Type.PERMISSION_RECORD_AUDIO) {
                    F = ArraysKt___ArraysKt.F(permissions);
                    if (Intrinsics.a(F, "android.permission.RECORD_AUDIO") && (onboardingStepListener = this.f32493l) != null) {
                        OnBoardingStep onBoardingStep3 = this.f32492k;
                        if (onBoardingStep3 == null) {
                            Intrinsics.w("currentOnboardingStep");
                        } else {
                            onBoardingStep2 = onBoardingStep3;
                        }
                        onboardingStepListener.h(onBoardingStep2.f());
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Spanned fromHtml;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        OnBoardingStep onBoardingStep = this.f32492k;
        OnBoardingStep onBoardingStep2 = null;
        if (onBoardingStep == null) {
            Intrinsics.w("currentOnboardingStep");
            onBoardingStep = null;
        }
        if (onBoardingStep.f() == OnBoardingStep.Type.PERMISSION_OVERLAY) {
            ((Group) M(R.id.quick_access_btn_group)).setVisibility(0);
            View taxifyHeadPulse_mini = M(R.id.taxifyHeadPulse_mini);
            Intrinsics.e(taxifyHeadPulse_mini, "taxifyHeadPulse_mini");
            Z(taxifyHeadPulse_mini).start();
            int i8 = R.id.quick_access_switch;
            ((SwitchCompat) M(i8)).setChecked(b0().t().E().a());
            ((SwitchCompat) M(i8)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: z4.c
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                    PermissionOnboardingFragment.j0(PermissionOnboardingFragment.this, compoundButton, z7);
                }
            });
        } else {
            ((Group) M(R.id.quick_access_btn_group)).setVisibility(8);
        }
        TextView textView = (TextView) M(R.id.onboarding_title_text);
        OnBoardingStep onBoardingStep3 = this.f32492k;
        if (onBoardingStep3 == null) {
            Intrinsics.w("currentOnboardingStep");
            onBoardingStep3 = null;
        }
        textView.setText(getString(onBoardingStep3.e()));
        TextView textView2 = (TextView) M(R.id.onboarding_desc_text);
        OnBoardingStep onBoardingStep4 = this.f32492k;
        if (onBoardingStep4 == null) {
            Intrinsics.w("currentOnboardingStep");
            onBoardingStep4 = null;
        }
        textView2.setText(getString(onBoardingStep4.a()));
        Color.Attr attr = new Color.Attr(R.attr.dynamicNeutral04);
        Context context = view.getContext();
        Intrinsics.e(context, "view.context");
        final int a8 = ColorKt.a(attr, context);
        try {
            OnBoardingStep onBoardingStep5 = this.f32492k;
            if (onBoardingStep5 == null) {
                Intrinsics.w("currentOnboardingStep");
                onBoardingStep5 = null;
            }
            Integer d8 = onBoardingStep5.d();
            if (d8 == null) {
                ((TextView) M(R.id.onboarding_steps_text)).setVisibility(8);
            } else {
                int i9 = R.id.onboarding_steps_text;
                ((TextView) M(i9)).setVisibility(0);
                if (Build.VERSION.SDK_INT >= 24) {
                    fromHtml = Html.fromHtml(getResources().getString(d8.intValue()), 0);
                } else {
                    fromHtml = Html.fromHtml(getResources().getString(d8.intValue()));
                }
                SpannableString spannableString = new SpannableString(fromHtml);
                spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, spannableString.length(), 33);
                SpannableUtilsKt.e(spannableString, BulletSpan.class, new Function0<Object>() { // from class: ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment$onViewCreated$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        if (Build.VERSION.SDK_INT >= 28) {
                            return new BulletSpan(Dimens.d(16), a8, Dimens.d(4));
                        }
                        return new BulletSpan(Dimens.d(16), a8);
                    }
                });
                ((TextView) M(i9)).setText(spannableString);
            }
        } catch (Exception e8) {
            Kalev.e(e8, "Error while displaying the formatted permission steps!");
            OnBoardingStep onBoardingStep6 = this.f32492k;
            if (onBoardingStep6 == null) {
                Intrinsics.w("currentOnboardingStep");
                onBoardingStep6 = null;
            }
            Integer b8 = onBoardingStep6.b();
            if (b8 == null) {
                ((TextView) M(R.id.onboarding_steps_text)).setVisibility(8);
            } else {
                ((TextView) M(R.id.onboarding_steps_text)).setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(b8.intValue()));
                int i10 = -1;
                do {
                    int i11 = i10 + 1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        spannableStringBuilder.setSpan(new BulletSpan(Dimens.d(16), a8, Dimens.d(4)), i11, i11 + 1, 17);
                    } else {
                        spannableStringBuilder.setSpan(new BulletSpan(Dimens.d(16), a8), i11, i11 + 1, 17);
                    }
                    i10 = StringsKt__StringsKt.X(spannableStringBuilder, "\n", i11 + 1, true);
                } while (i10 != -1);
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, spannableStringBuilder.length(), 33);
                ((TextView) M(R.id.onboarding_steps_text)).setText(spannableStringBuilder);
            }
        }
        OnBoardingStep onBoardingStep7 = this.f32492k;
        if (onBoardingStep7 == null) {
            Intrinsics.w("currentOnboardingStep");
            onBoardingStep7 = null;
        }
        if (onBoardingStep7.f() == OnBoardingStep.Type.PERMISSION_OVERLAY) {
            OnBoardingStep onBoardingStep8 = this.f32492k;
            if (onBoardingStep8 == null) {
                Intrinsics.w("currentOnboardingStep");
            } else {
                onBoardingStep2 = onBoardingStep8;
            }
            if (onBoardingStep2.f() == OnBoardingStep.Type.PERMISSION_RECORD_AUDIO) {
                ((RoundButton) M(R.id.onboarding_action_button)).setText(getString(R.string.allow));
                ((RoundButton) M(R.id.onboarding_action_button)).setOnClickListener(new View.OnClickListener() { // from class: z4.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PermissionOnboardingFragment.k0(PermissionOnboardingFragment.this, view2);
                    }
                });
            }
        }
        ((RoundButton) M(R.id.onboarding_action_button)).setText(getString(R.string.go_to_settings));
        ((RoundButton) M(R.id.onboarding_action_button)).setOnClickListener(new View.OnClickListener() { // from class: z4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionOnboardingFragment.k0(PermissionOnboardingFragment.this, view2);
            }
        });
    }
}
