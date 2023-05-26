package ee.mtakso.driver.ui.screens.login.v3.common;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.ui.screens.splash.DisabledBannerDelegate;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.ActionDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeprecatedAppDelegate.kt */
/* loaded from: classes3.dex */
public final class DeprecatedAppDelegate {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f30638g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f30639a;

    /* renamed from: b  reason: collision with root package name */
    private final AppResolver f30640b;

    /* renamed from: c  reason: collision with root package name */
    private final PlatformManager f30641c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f30642d;

    /* renamed from: e  reason: collision with root package name */
    private final Function0<AppVersionState> f30643e;

    /* renamed from: f  reason: collision with root package name */
    private final DeprecatedAppDelegate$deprecationDialogCallback$1 f30644f;

    /* compiled from: DeprecatedAppDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DeprecatedAppDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30645a;

        static {
            int[] iArr = new int[AppVersionState.values().length];
            try {
                iArr[AppVersionState.DEPRECATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppVersionState.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppVersionState.INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppVersionState.OK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30645a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [ee.mtakso.driver.ui.screens.login.v3.common.DeprecatedAppDelegate$deprecationDialogCallback$1] */
    public DeprecatedAppDelegate(Fragment fragment, AppResolver appResolver, PlatformManager platformManager, Function0<Unit> skipDeprecatedApp, Function0<? extends AppVersionState> appStateProvider) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(platformManager, "platformManager");
        Intrinsics.f(skipDeprecatedApp, "skipDeprecatedApp");
        Intrinsics.f(appStateProvider, "appStateProvider");
        this.f30639a = fragment;
        this.f30640b = appResolver;
        this.f30641c = platformManager;
        this.f30642d = skipDeprecatedApp;
        this.f30643e = appStateProvider;
        this.f30644f = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.login.v3.common.DeprecatedAppDelegate$deprecationDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                PlatformManager platformManager2;
                Function0 function0;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "negative")) {
                    dialog.dismissAllowingStateLoss();
                    function0 = DeprecatedAppDelegate.this.f30642d;
                    function0.invoke();
                } else if (Intrinsics.a(payload, "positive")) {
                    platformManager2 = DeprecatedAppDelegate.this.f30641c;
                    PlatformManager.DefaultImpls.a(platformManager2, null, 1, null);
                }
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Function0 function0;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
                if (event == DialogLifecycleEvent.CANCELLED) {
                    DeprecatedAppDelegate deprecatedAppDelegate = DeprecatedAppDelegate.this;
                    function0 = deprecatedAppDelegate.f30643e;
                    deprecatedAppDelegate.f((AppVersionState) function0.invoke());
                }
            }
        };
    }

    private final AppBarLayout d() {
        View view;
        View view2 = this.f30639a.getView();
        if (view2 != null) {
            view = view2.findViewById(R.id.appbar);
        } else {
            view = null;
        }
        AppBarLayout appBarLayout = (AppBarLayout) view;
        Intrinsics.e(appBarLayout, "fragment.appbar");
        return appBarLayout;
    }

    public final void e() {
        BaseDialogFragment.f41026i.a(this.f30639a.getChildFragmentManager(), "TAG_DEPRECTAED", this.f30644f);
    }

    public final void f(AppVersionState state) {
        Intrinsics.f(state, "state");
        Context requireContext = this.f30639a.requireContext();
        Intrinsics.e(requireContext, "fragment.requireContext()");
        int i8 = WhenMappings.f30645a[state.ordinal()];
        if (i8 != 1) {
            View view = null;
            if (i8 != 2) {
                if (i8 == 3) {
                    Toast.makeText(requireContext, "ERROR: INVALID VERSION!", 0).show();
                    PlatformManager.DefaultImpls.a(this.f30641c, null, 1, null);
                    return;
                }
                return;
            }
            FragmentActivity requireActivity = this.f30639a.requireActivity();
            Intrinsics.e(requireActivity, "fragment.requireActivity()");
            View view2 = this.f30639a.getView();
            if (view2 != null) {
                view = view2.findViewById(R.id.disabledBannerRoot);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            Intrinsics.e(constraintLayout, "fragment.disabledBannerRoot");
            new DisabledBannerDelegate(requireActivity, constraintLayout, this.f30640b).e();
            ViewExtKt.d(d(), false, 4);
            return;
        }
        ActionDialog.Companion companion = ActionDialog.f41071m;
        String string = requireContext.getString(R.string.deprecated_dialog_title);
        Intrinsics.e(string, "context.getString(R.stri….deprecated_dialog_title)");
        String string2 = requireContext.getString(R.string.deprecated_dialog_content);
        Intrinsics.e(string2, "context.getString(R.stri…eprecated_dialog_content)");
        String string3 = requireContext.getString(R.string.deprecated_dialog_positive_button);
        Intrinsics.e(string3, "context.getString(R.stri…d_dialog_positive_button)");
        String string4 = requireContext.getString(R.string.deprecated_dialog_negative_button);
        Intrinsics.e(string4, "context.getString(R.stri…d_dialog_negative_button)");
        ActionDialog a8 = companion.a(string, string2, string3, string4, this.f30644f);
        FragmentActivity requireActivity2 = this.f30639a.requireActivity();
        Intrinsics.e(requireActivity2, "fragment.requireActivity()");
        FragmentUtils.c(a8, requireActivity2, "TAG_DEPRECTAED");
    }
}
