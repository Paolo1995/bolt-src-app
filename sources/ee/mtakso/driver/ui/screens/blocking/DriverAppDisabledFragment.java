package ee.mtakso.driver.ui.screens.blocking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.restriction.RestrictionUtil;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.R$style;
import eu.bolt.kalev.Kalev;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAppDisabledFragment.kt */
/* loaded from: classes3.dex */
public final class DriverAppDisabledFragment extends BazeMvvmFragment<DriverAppDisabledViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f27050r = new Companion(null);

    /* renamed from: s  reason: collision with root package name */
    private static boolean f27051s;

    /* renamed from: o  reason: collision with root package name */
    private final PlatformManager f27052o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f27053p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f27054q;

    /* compiled from: DriverAppDisabledFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return DriverAppDisabledFragment.f27051s;
        }

        public final Bundle b(DriverAppDisabledReason driverAppDisabledReason) {
            Intrinsics.f(driverAppDisabledReason, "driverAppDisabledReason");
            return BundleKt.a(TuplesKt.a("arg_driver_app_disabled_reason", driverAppDisabledReason));
        }
    }

    /* compiled from: DriverAppDisabledFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27055a;

        static {
            int[] iArr = new int[DriverAppDisabledReason.values().length];
            try {
                iArr[DriverAppDisabledReason.MOCK_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverAppDisabledReason.LOCATION_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverAppDisabledReason.LOW_ACCURACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverAppDisabledReason.VERIFICATION_DEBUGGABLE_APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverAppDisabledReason.VERIFICATION_PACKAGE_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DriverAppDisabledReason.VERIFICATION_INSTALLER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DriverAppDisabledReason.VERIFICATION_SIGNATURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f27055a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverAppDisabledFragment(BaseUiDependencies deps, PlatformManager platformManager) {
        super(deps, R.layout.fragment_app_disabled, Integer.valueOf((int) R$style.Theme_Dark));
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(platformManager, "platformManager");
        this.f27054q = new LinkedHashMap();
        this.f27052o = platformManager;
        b8 = LazyKt__LazyJVMKt.b(new Function0<LoadingDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment$loadingDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LoadingDialogDelegate invoke() {
                FragmentActivity requireActivity = DriverAppDisabledFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                return new LoadingDialogDelegate(requireActivity);
            }
        });
        this.f27053p = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        requireActivity().finish();
        AppRoutingManager.Companion companion = AppRoutingManager.f25869b;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        companion.c(requireContext);
    }

    private final DriverAppDisabledReason e0() {
        Serializable serializable;
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("arg_driver_app_disabled_reason");
        } else {
            serializable = null;
        }
        if (!(serializable instanceof DriverAppDisabledReason)) {
            return null;
        }
        return (DriverAppDisabledReason) serializable;
    }

    private final LoadingDialogDelegate f0() {
        return (LoadingDialogDelegate) this.f27053p.getValue();
    }

    private final Navigator g0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(DriverAppDisabledFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.M().Q().f() != null) {
            ImageView btnHelpNotification = (ImageView) this$0.Z(R.id.btnHelpNotification);
            Intrinsics.e(btnHelpNotification, "btnHelpNotification");
            ViewExtKt.e(btnHelpNotification, false, 0, 2, null);
            SupportFragment.Companion companion = SupportFragment.f33440u;
            Context requireContext = this$0.requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            companion.e(requireContext, null, this$0.M().Q().f());
            return;
        }
        this$0.M().S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(GeoLocationIssue geoLocationIssue) {
        if (geoLocationIssue == null) {
            if (f27051s) {
                d0();
            }
            Kalev.e(new NullPointerException("issue is null"), "GeoLocationIssue is null from LocationManager!");
            return;
        }
        Kalev.h("Process issue " + geoLocationIssue);
        M().N().D(geoLocationIssue, this);
    }

    private final void o0(DriverAppDisabledReason driverAppDisabledReason) {
        switch (WhenMappings.f27055a[driverAppDisabledReason.ordinal()]) {
            case 1:
                RoundButton btnHelp = (RoundButton) Z(R.id.btnHelp);
                Intrinsics.e(btnHelp, "btnHelp");
                ViewExtKt.e(btnHelp, false, 0, 3, null);
                M().Y();
                ((ImageView) Z(R.id.T5)).setImageResource(R.drawable.ic_alert_72dp);
                ((TextView) Z(R.id.titleTextView)).setText(getString(R.string.driver_app_disabled_third_party_title));
                ((TextView) Z(R.id.messageTextView)).setText(getString(R.string.driver_app_disabled_third_party_message_long));
                RoundButton primaryButton = (RoundButton) Z(R.id.primaryButton);
                Intrinsics.e(primaryButton, "primaryButton");
                ViewExtKt.e(primaryButton, false, 0, 2, null);
                int i8 = R.id.secondaryButton;
                ((RoundButton) Z(i8)).setText(getString(R.string.close));
                ((RoundButton) Z(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DriverAppDisabledFragment.p0(DriverAppDisabledFragment.this, view);
                    }
                });
                return;
            case 2:
            case 3:
                ((ImageView) Z(R.id.T5)).setImageResource(R.drawable.ic_my_location_72dp);
                ((TextView) Z(R.id.titleTextView)).setText(getString(R.string.location_permission));
                ((TextView) Z(R.id.messageTextView)).setText(getString(R.string.location_permission_explain));
                int i9 = R.id.primaryButton;
                ((RoundButton) Z(i9)).setText(getString(R.string.permission_request_enable_location));
                ((RoundButton) Z(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DriverAppDisabledFragment.q0(DriverAppDisabledFragment.this, view);
                    }
                });
                RoundButton secondaryButton = (RoundButton) Z(R.id.secondaryButton);
                Intrinsics.e(secondaryButton, "secondaryButton");
                ViewExtKt.e(secondaryButton, false, 0, 2, null);
                return;
            case 4:
            case 5:
            case 6:
            case 7:
                RoundButton btnHelp2 = (RoundButton) Z(R.id.btnHelp);
                Intrinsics.e(btnHelp2, "btnHelp");
                ViewExtKt.e(btnHelp2, false, 0, 3, null);
                M().Y();
                ((ImageView) Z(R.id.T5)).setImageResource(R.drawable.ic_decline_72dp);
                ((TextView) Z(R.id.titleTextView)).setText(getString(R.string.driver_app_disabled__app_verification_title));
                ((TextView) Z(R.id.messageTextView)).setText(getString(R.string.driver_app_disabled__app_verification_message_long));
                int i10 = R.id.primaryButton;
                ((RoundButton) Z(i10)).setText(getString(R.string.install_application));
                ((RoundButton) Z(i10)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DriverAppDisabledFragment.r0(DriverAppDisabledFragment.this, view);
                    }
                });
                RoundButton secondaryButton2 = (RoundButton) Z(R.id.secondaryButton);
                Intrinsics.e(secondaryButton2, "secondaryButton");
                ViewExtKt.e(secondaryButton2, false, 0, 2, null);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(DriverAppDisabledFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(DriverAppDisabledFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(DriverAppDisabledFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        PlatformManager.DefaultImpls.a(this$0.f27052o, null, 1, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27054q.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        f0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        f0().b();
    }

    public View Z(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27054q;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: n0 */
    public DriverAppDisabledViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (DriverAppDisabledViewModel) new ViewModelProvider(this, E.d()).a(DriverAppDisabledViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 == 5599) {
            if (i9 == -1) {
                d0();
                return;
            }
            return;
        }
        super.onActivityResult(i8, i9, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f27051s = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f27051s = false;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        final DriverAppDisabledReason e02 = e0();
        if (e02 == null) {
            Kalev.e(new NullPointerException("appDisabledReason is null"), "App disabled data cannot be empty!");
            Toast.makeText(requireContext(), (int) R.string.something_went_wrong, 0).show();
            g0().c();
            return;
        }
        o0(e02);
        ((RoundButton) Z(R.id.btnHelp)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.blocking.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DriverAppDisabledFragment.h0(DriverAppDisabledFragment.this, view2);
            }
        });
        LiveData<GeoLocationIssue> P = M().P();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<GeoLocationIssue, Unit> function1 = new Function1<GeoLocationIssue, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationIssue geoLocationIssue) {
                DriverAppDisabledFragment.this.m0(geoLocationIssue);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationIssue geoLocationIssue) {
                b(geoLocationIssue);
                return Unit.f50853a;
            }
        };
        P.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.blocking.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverAppDisabledFragment.i0(Function1.this, obj);
            }
        });
        LiveData<String> Q = M().Q();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                ImageView btnHelpNotification = (ImageView) DriverAppDisabledFragment.this.Z(R.id.btnHelpNotification);
                Intrinsics.e(btnHelpNotification, "btnHelpNotification");
                ViewExtKt.e(btnHelpNotification, false, 0, 3, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Q.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.blocking.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverAppDisabledFragment.j0(Function1.this, obj);
            }
        });
        LiveData<String> R = M().R();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                SupportFragment.Companion companion = SupportFragment.f33440u;
                FragmentActivity requireActivity = DriverAppDisabledFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                companion.e(requireActivity, str, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.blocking.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverAppDisabledFragment.k0(Function1.this, obj);
            }
        });
        ObservableLiveData<GeoLocationManagerState> O = M().O();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<GeoLocationManagerState, Unit> function14 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState geoLocationManagerState) {
                if (geoLocationManagerState == GeoLocationManagerState.RUNNING && !RestrictionUtil.f25859a.a(DriverAppDisabledReason.this) && DriverAppDisabledFragment.f27050r.a()) {
                    this.d0();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        O.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.blocking.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverAppDisabledFragment.l0(Function1.this, obj);
            }
        });
    }
}
