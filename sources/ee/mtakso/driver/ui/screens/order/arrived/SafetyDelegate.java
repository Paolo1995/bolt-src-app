package ee.mtakso.driver.ui.screens.order.arrived;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.finish.RightButtonState;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyDelegate.kt */
/* loaded from: classes3.dex */
public final class SafetyDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f31075a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f31076b;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentFactory f31077c;

    /* renamed from: d  reason: collision with root package name */
    private final RoundButton f31078d;

    /* renamed from: e  reason: collision with root package name */
    private final RoundButton f31079e;

    /* renamed from: f  reason: collision with root package name */
    private final LottieAnimationView f31080f;

    /* renamed from: g  reason: collision with root package name */
    private final AppCompatImageView f31081g;

    /* renamed from: h  reason: collision with root package name */
    private final Lazy f31082h;

    /* renamed from: i  reason: collision with root package name */
    private final Lazy f31083i;

    /* compiled from: SafetyDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31084a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31085b;

        static {
            int[] iArr = new int[SafetyFABButtonType.values().length];
            try {
                iArr[SafetyFABButtonType.ACTIVE_INCIDENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SafetyFABButtonType.RECORDING_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SafetyFABButtonType.RECORDING_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SafetyFABButtonType.DEFAULT_TOOLKIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f31084a = iArr;
            int[] iArr2 = new int[DidYouGetHelpType.values().length];
            try {
                iArr2[DidYouGetHelpType.NO_HELP_NEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DidYouGetHelpType.REQUEST_HELP_FROM_BOLT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f31085b = iArr2;
        }
    }

    public SafetyDelegate(Fragment fragment, ViewGroup parentView, FragmentFactory fragmentFactory, RoundButton sosButton, RoundButton safetyToolkitButton, LottieAnimationView animationView, AppCompatImageView newBadgeIndicator) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(parentView, "parentView");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(sosButton, "sosButton");
        Intrinsics.f(safetyToolkitButton, "safetyToolkitButton");
        Intrinsics.f(animationView, "animationView");
        Intrinsics.f(newBadgeIndicator, "newBadgeIndicator");
        this.f31075a = fragment;
        this.f31076b = parentView;
        this.f31077c = fragmentFactory;
        this.f31078d = sosButton;
        this.f31079e = safetyToolkitButton;
        this.f31080f = animationView;
        this.f31081g = newBadgeIndicator;
        b8 = LazyKt__LazyJVMKt.b(new Function0<SnackBarDelegate>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.SafetyDelegate$snackBarDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SnackBarDelegate invoke() {
                ViewGroup viewGroup;
                viewGroup = SafetyDelegate.this.f31076b;
                return new SnackBarDelegate(viewGroup, null, 2, null);
            }
        });
        this.f31082h = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<SosButtonDelegate>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.SafetyDelegate$sosButtonDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SosButtonDelegate invoke() {
                RoundButton roundButton;
                Fragment fragment2;
                FragmentFactory fragmentFactory2;
                roundButton = SafetyDelegate.this.f31078d;
                fragment2 = SafetyDelegate.this.f31075a;
                FragmentManager childFragmentManager = fragment2.getChildFragmentManager();
                Intrinsics.e(childFragmentManager, "fragment.childFragmentManager");
                fragmentFactory2 = SafetyDelegate.this.f31077c;
                return new SosButtonDelegate(roundButton, childFragmentManager, fragmentFactory2);
            }
        });
        this.f31083i = b9;
    }

    private final SnackBarDelegate e() {
        return (SnackBarDelegate) this.f31082h.getValue();
    }

    private final SosButtonDelegate f() {
        return (SosButtonDelegate) this.f31083i.getValue();
    }

    private final void h(Integer num, Integer num2, Integer num3, int i8) {
        if (num != null) {
            this.f31079e.b(num.intValue());
        }
        if (num2 != null) {
            this.f31079e.b(num2.intValue());
        }
        this.f31079e.setIconTint(num3);
        this.f31079e.setBgColor(i8);
    }

    public final void g(int i8) {
        this.f31081g.setVisibility(i8);
    }

    public final void i(DidYouGetHelpType didYouGetHelpType) {
        Text resource;
        Intrinsics.f(didYouGetHelpType, "didYouGetHelpType");
        Fragment findFragmentByTag = this.f31075a.getParentFragmentManager().findFragmentByTag("DidYouGetHelpFragment");
        Intrinsics.d(findFragmentByTag, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment");
        ((DidYouGetHelpFragment) findFragmentByTag).dismissAllowingStateLoss();
        int i8 = WhenMappings.f31085b[didYouGetHelpType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                resource = new Text.Value("");
            } else {
                resource = new Text.Resource(R.string.request_help_from_bolt, null, 2, null);
            }
        } else {
            resource = new Text.Resource(R.string.thanks_for_letting_us_know, null, 2, null);
        }
        Text text = resource;
        if (didYouGetHelpType != DidYouGetHelpType.INITIAL) {
            e().b(new SnackBarModel(0, text, null, null, null, null, 60, null));
        }
    }

    public final void j() {
        if (this.f31075a.getParentFragmentManager().findFragmentByTag("safetyToolkitBottomSheet") == null) {
            FragmentFactory fragmentFactory = this.f31077c;
            Context requireContext = this.f31075a.requireContext();
            Intrinsics.e(requireContext, "fragment.requireContext()");
            FragmentActivity requireActivity = this.f31075a.requireActivity();
            Intrinsics.e(requireActivity, "fragment.requireActivity()");
            FragmentUtils.c((SafetyToolkitBottomSheetFragment) FragmentFactoryUtils.c(fragmentFactory, requireContext, SafetyToolkitBottomSheetFragment.class, null, 4, null), requireActivity, "safetyToolkitBottomSheet");
        }
    }

    public final void k(RightButtonState rightButtonState) {
        Intrinsics.f(rightButtonState, "rightButtonState");
        f().e(rightButtonState.b());
        ViewExtKt.e(this.f31079e, rightButtonState.a(), 0, 2, null);
    }

    public final void l(SafetyFABButtonType safetyFABButtonUIType) {
        Intrinsics.f(safetyFABButtonUIType, "safetyFABButtonUIType");
        int i8 = WhenMappings.f31084a[safetyFABButtonUIType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        Context context = this.f31079e.getContext();
                        Intrinsics.e(context, "safetyToolkitButton.context");
                        Integer valueOf = Integer.valueOf(ContextUtilsKt.d(context, R.attr.safetyToolkitIcon));
                        Context context2 = this.f31079e.getContext();
                        Intrinsics.e(context2, "safetyToolkitButton.context");
                        h(null, valueOf, null, ContextUtilsKt.b(context2, R.attr.backSecondary));
                        SafetyUIUtils.f32878a.b(this.f31080f, 8);
                        return;
                    }
                    return;
                }
                Context context3 = this.f31079e.getContext();
                Intrinsics.e(context3, "safetyToolkitButton.context");
                Integer valueOf2 = Integer.valueOf(ContextUtilsKt.d(context3, R.attr.safetyToolkitAudioRecordingIcon));
                Context context4 = this.f31079e.getContext();
                Intrinsics.e(context4, "safetyToolkitButton.context");
                h(null, valueOf2, null, ContextUtilsKt.b(context4, R.attr.backSecondary));
                SafetyUIUtils.f32878a.b(this.f31080f, 8);
                return;
            }
            Context context5 = this.f31079e.getContext();
            Intrinsics.e(context5, "safetyToolkitButton.context");
            Integer valueOf3 = Integer.valueOf(ContextUtilsKt.d(context5, R.attr.safetyToolkitAudioRecordingIcon));
            Context context6 = this.f31079e.getContext();
            Intrinsics.e(context6, "safetyToolkitButton.context");
            h(null, valueOf3, null, ContextUtilsKt.b(context6, R.attr.backSecondary));
            SafetyUIUtils.f32878a.b(this.f31080f, 0);
            return;
        }
        Integer valueOf4 = Integer.valueOf((int) R.drawable.ic_emergency_assist_24);
        Context context7 = this.f31079e.getContext();
        Intrinsics.e(context7, "safetyToolkitButton.context");
        Integer valueOf5 = Integer.valueOf(ContextUtilsKt.d(context7, R.attr.dynamicSafetyCritical));
        Context context8 = this.f31079e.getContext();
        Intrinsics.e(context8, "safetyToolkitButton.context");
        h(valueOf4, null, valueOf5, ContextUtilsKt.b(context8, R.attr.backSafetyCritical));
        SafetyUIUtils.f32878a.b(this.f31080f, 8);
    }
}
