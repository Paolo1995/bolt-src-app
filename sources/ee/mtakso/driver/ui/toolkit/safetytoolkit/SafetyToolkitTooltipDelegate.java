package ee.mtakso.driver.ui.toolkit.safetytoolkit;

import android.animation.Animator;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Utils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import eu.bolt.driver.core.util.PermissionUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitTooltipDelegate.kt */
/* loaded from: classes5.dex */
public final class SafetyToolkitTooltipDelegate {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f34266k = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f34267a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f34268b;

    /* renamed from: c  reason: collision with root package name */
    private final PermissionManager f34269c;

    /* renamed from: d  reason: collision with root package name */
    private final Fragment f34270d;

    /* renamed from: e  reason: collision with root package name */
    private final DialogCallback f34271e;

    /* renamed from: f  reason: collision with root package name */
    private final MicrophonePermissionDialogProvider f34272f;

    /* renamed from: g  reason: collision with root package name */
    private final PermissionAnalytics f34273g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f34274h;

    /* renamed from: i  reason: collision with root package name */
    private final Lazy f34275i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f34276j;

    /* compiled from: SafetyToolkitTooltipDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SafetyToolkitTooltipDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34277a;

        static {
            int[] iArr = new int[TooltipType.values().length];
            try {
                iArr[TooltipType.SAFETY_TOOLKIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TooltipType.AUDIO_RECORDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34277a = iArr;
        }
    }

    public SafetyToolkitTooltipDelegate(ViewGroup rootLayout, ViewGroup anchor, PermissionManager permissionManager, Fragment fragment, DialogCallback confirmPermissionDialogCallback, MicrophonePermissionDialogProvider microphonePermissionDialogProvider, PermissionAnalytics permissionAnalytics) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(rootLayout, "rootLayout");
        Intrinsics.f(anchor, "anchor");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(confirmPermissionDialogCallback, "confirmPermissionDialogCallback");
        Intrinsics.f(microphonePermissionDialogProvider, "microphonePermissionDialogProvider");
        Intrinsics.f(permissionAnalytics, "permissionAnalytics");
        this.f34267a = rootLayout;
        this.f34268b = anchor;
        this.f34269c = permissionManager;
        this.f34270d = fragment;
        this.f34271e = confirmPermissionDialogCallback;
        this.f34272f = microphonePermissionDialogProvider;
        this.f34273g = permissionAnalytics;
        b8 = LazyKt__LazyJVMKt.b(new Function0<AlertDialog>() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate$safetyAlertDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AlertDialog invoke() {
                ViewGroup viewGroup;
                viewGroup = SafetyToolkitTooltipDelegate.this.f34268b;
                AlertDialog a8 = new AlertDialog.Builder(viewGroup.getContext()).p(R.layout.safety_toolkit_tooltip).a();
                Intrinsics.e(a8, "Builder(anchor.context)\n…ip)\n            .create()");
                return a8;
            }
        });
        this.f34275i = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<AlertDialog>() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate$audioAlertDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AlertDialog invoke() {
                ViewGroup viewGroup;
                viewGroup = SafetyToolkitTooltipDelegate.this.f34268b;
                AlertDialog a8 = new AlertDialog.Builder(viewGroup.getContext()).p(R.layout.audio_recording_tooltip).a();
                Intrinsics.e(a8, "Builder(anchor.context)\n…ip)\n            .create()");
                return a8;
            }
        });
        this.f34276j = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(SafetyToolkitTooltipDelegate this$0, DialogInterface dialogInterface) {
        Intrinsics.f(this$0, "this$0");
        this$0.r(this$0.u(), R.id.safetyToolkitPopupContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(SafetyToolkitTooltipDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.r(this$0.t(), R.id.audioRecordingPopUpContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(SafetyToolkitTooltipDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.r(this$0.t(), R.id.audioRecordingPopUpContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(SafetyToolkitTooltipDelegate this$0, DialogInterface dialogInterface) {
        Intrinsics.f(this$0, "this$0");
        this$0.r(this$0.t(), R.id.audioRecordingPopUpContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(SafetyToolkitTooltipDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.q();
        this$0.n();
    }

    private final void F(AlertDialog alertDialog, int i8) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        alertDialog.show();
        ViewGroup viewGroup = (ViewGroup) alertDialog.findViewById(i8);
        if (viewGroup != null && (animate = viewGroup.animate()) != null && (alpha = animate.alpha(1.0f)) != null && (duration = alpha.setDuration(300L)) != null) {
            duration.start();
        }
    }

    private final void G(boolean z7) {
        if (z7) {
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) t().findViewById(R.id.topAudioCloseToolTip);
            if (appCompatImageButton != null) {
                ViewExtKt.e(appCompatImageButton, false, 0, 3, null);
            }
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) t().findViewById(R.id.bottomCloseAudioToolTip);
            if (appCompatImageButton2 != null) {
                ViewExtKt.e(appCompatImageButton2, false, 0, 2, null);
            }
            View findViewById = t().findViewById(R.id.divider);
            if (findViewById != null) {
                ViewExtKt.e(findViewById, false, 0, 2, null);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) t().findViewById(R.id.allowRecording);
            if (appCompatTextView != null) {
                ViewExtKt.e(appCompatTextView, false, 0, 2, null);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) t().findViewById(R.id.text);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(this.f34267a.getContext().getString(R.string.trip_audio_tooltip_description_permission_granted));
                return;
            }
            return;
        }
        AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) t().findViewById(R.id.topAudioCloseToolTip);
        if (appCompatImageButton3 != null) {
            ViewExtKt.e(appCompatImageButton3, false, 0, 2, null);
        }
        AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) t().findViewById(R.id.bottomCloseAudioToolTip);
        if (appCompatImageButton4 != null) {
            ViewExtKt.e(appCompatImageButton4, false, 0, 3, null);
        }
        View findViewById2 = t().findViewById(R.id.divider);
        if (findViewById2 != null) {
            ViewExtKt.e(findViewById2, false, 0, 3, null);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) t().findViewById(R.id.allowRecording);
        if (appCompatTextView3 != null) {
            ViewExtKt.e(appCompatTextView3, false, 0, 3, null);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) t().findViewById(R.id.text);
        if (appCompatTextView4 != null) {
            appCompatTextView4.setText(this.f34267a.getContext().getString(R.string.trip_audio_tooltip_description));
        }
    }

    private final void H(AlertDialog alertDialog, ViewGroup viewGroup, int i8) {
        WindowManager.LayoutParams layoutParams;
        w(viewGroup);
        Window window = alertDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (!Utils.g(alertDialog.getContext())) {
            if (layoutParams != null) {
                layoutParams.width = -1;
            }
        } else if (layoutParams != null) {
            layoutParams.width = -2;
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        if (layoutParams != null) {
            layoutParams.y = viewGroup.getTop() + viewGroup.getMeasuredHeight();
        }
        Window window2 = alertDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) alertDialog.findViewById(i8);
        if (!Utils.g(alertDialog.getContext())) {
            if (constraintLayout != null) {
                ee.mtakso.driver.uikit.utils.ViewExtKt.g(constraintLayout, Integer.valueOf(Dimens.c(10)), Integer.valueOf(Dimens.c(8)), Integer.valueOf(Dimens.c(0)), Integer.valueOf(Dimens.c(0)));
            }
        } else if (constraintLayout != null) {
            ee.mtakso.driver.uikit.utils.ViewExtKt.g(constraintLayout, Integer.valueOf(Dimens.c(0)), Integer.valueOf(Dimens.c(10)), Integer.valueOf(Dimens.c(0)), Integer.valueOf(Dimens.c(0)));
        }
    }

    private final void n() {
        Single l8 = PermissionManager.l(this.f34269c, "android.permission.RECORD_AUDIO", null, 2, null);
        final Function1<PermissionManager.PermissionInfo, Unit> function1 = new Function1<PermissionManager.PermissionInfo, Unit>() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate$checkAndLaunchPermission$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PermissionManager.PermissionInfo permissionInfo) {
                PermissionAnalytics permissionAnalytics;
                MicrophonePermissionDialogProvider microphonePermissionDialogProvider;
                DialogCallback dialogCallback;
                Fragment fragment;
                Kalev.b("Permission result " + permissionInfo);
                if (permissionInfo.d() != PermissionManager.PermissionStatus.GRANTED && permissionInfo.a() == PermissionManager.DenyInitiator.AUTOMATIC_DENY) {
                    permissionAnalytics = SafetyToolkitTooltipDelegate.this.f34273g;
                    permissionAnalytics.u3("trip audio recording");
                    microphonePermissionDialogProvider = SafetyToolkitTooltipDelegate.this.f34272f;
                    dialogCallback = SafetyToolkitTooltipDelegate.this.f34271e;
                    ConfirmationWithIconDialog a8 = microphonePermissionDialogProvider.a(dialogCallback);
                    fragment = SafetyToolkitTooltipDelegate.this.f34270d;
                    FragmentUtils.b(a8, fragment, "permission_denied_dialog");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PermissionManager.PermissionInfo permissionInfo) {
                b(permissionInfo);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitTooltipDelegate.o(Function1.this, obj);
            }
        };
        final SafetyToolkitTooltipDelegate$checkAndLaunchPermission$2 safetyToolkitTooltipDelegate$checkAndLaunchPermission$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate$checkAndLaunchPermission$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Audio recording Permission error");
            }
        };
        this.f34274h = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitTooltipDelegate.p(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void r(final AlertDialog alertDialog, int i8) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator s7;
        ViewGroup viewGroup = (ViewGroup) alertDialog.findViewById(i8);
        if (viewGroup != null && (animate = viewGroup.animate()) != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(300L)) != null && (s7 = s(duration, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate$dismissWithAnimation$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                AlertDialog.this.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        })) != null) {
            s7.start();
        }
    }

    private final ViewPropertyAnimator s(ViewPropertyAnimator viewPropertyAnimator, final Function0<Unit> function0) {
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate$doOnEnd$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.f(animation, "animation");
                function0.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.f(animation, "animation");
            }
        });
        return viewPropertyAnimator;
    }

    private final AlertDialog t() {
        return (AlertDialog) this.f34276j.getValue();
    }

    private final AlertDialog u() {
        return (AlertDialog) this.f34275i.getValue();
    }

    private final void v(AlertDialog alertDialog) {
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.clearFlags(2);
            if (!Utils.g(alertDialog.getContext())) {
                window.getAttributes().gravity = 8388659;
            } else {
                window.getAttributes().gravity = 8388661;
            }
        }
    }

    private final void w(View view) {
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SafetyToolkitTooltipDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.r(this$0.u(), R.id.safetyToolkitPopupContent);
    }

    public final void q() {
        u().dismiss();
        t().dismiss();
    }

    public final void x() {
        Disposable disposable = this.f34274h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    public final void y(TooltipType tooltipType) {
        Intrinsics.f(tooltipType, "tooltipType");
        int[] iArr = WhenMappings.f34277a;
        int i8 = iArr[tooltipType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                v(t());
                F(t(), R.id.audioRecordingPopUpContent);
            }
        } else {
            v(u());
            F(u(), R.id.safetyToolkitPopupContent);
        }
        int i9 = iArr[tooltipType.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                H(t(), this.f34267a, R.id.audioRecordingPopUpContent);
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) t().findViewById(R.id.topAudioCloseToolTip);
                if (appCompatImageButton != null) {
                    appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SafetyToolkitTooltipDelegate.B(SafetyToolkitTooltipDelegate.this, view);
                        }
                    });
                }
                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) t().findViewById(R.id.bottomCloseAudioToolTip);
                if (appCompatImageButton2 != null) {
                    appCompatImageButton2.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SafetyToolkitTooltipDelegate.C(SafetyToolkitTooltipDelegate.this, view);
                        }
                    });
                }
                t().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.e
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        SafetyToolkitTooltipDelegate.D(SafetyToolkitTooltipDelegate.this, dialogInterface);
                    }
                });
                G(PermissionUtils.f41314a.b(this.f34269c));
                AppCompatTextView appCompatTextView = (AppCompatTextView) t().findViewById(R.id.allowRecording);
                if (appCompatTextView != null) {
                    appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SafetyToolkitTooltipDelegate.E(SafetyToolkitTooltipDelegate.this, view);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        H(u(), this.f34267a, R.id.safetyToolkitPopupContent);
        AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) u().findViewById(R.id.closeToolTip);
        if (appCompatImageButton3 != null) {
            appCompatImageButton3.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SafetyToolkitTooltipDelegate.z(SafetyToolkitTooltipDelegate.this, view);
                }
            });
        }
        u().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ee.mtakso.driver.ui.toolkit.safetytoolkit.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SafetyToolkitTooltipDelegate.A(SafetyToolkitTooltipDelegate.this, dialogInterface);
            }
        });
    }
}
