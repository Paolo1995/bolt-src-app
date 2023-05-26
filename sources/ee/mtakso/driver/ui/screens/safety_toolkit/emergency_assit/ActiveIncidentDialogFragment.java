package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveIncidentDialogFragment.kt */
/* loaded from: classes3.dex */
public final class ActiveIncidentDialogFragment extends BazeMvvmFragment<EmergencyAssistHelpViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f32656s = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final DriverSettings f32657o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f32658p;

    /* renamed from: q  reason: collision with root package name */
    private final int f32659q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f32660r;

    /* compiled from: ActiveIncidentDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ActiveIncidentDialogFragment(BaseUiDependencies deps, DriverSettings driverSettings) {
        super(deps, R.layout.fragment_active_incident_prompt, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(driverSettings, "driverSettings");
        this.f32660r = new LinkedHashMap();
        this.f32657o = driverSettings;
        this.f32659q = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator a0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ActiveIncidentDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.a0().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void g0(boolean z7) {
        AppCompatImageView logo = (AppCompatImageView) V(R.id.logo);
        Intrinsics.e(logo, "logo");
        ViewExtKt.d(logo, z7, 0, 2, null);
        AppCompatTextView keyText = (AppCompatTextView) V(R.id.f19836t6);
        Intrinsics.e(keyText, "keyText");
        ViewExtKt.d(keyText, z7, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(EmergencyAssistUIData emergencyAssistUIData) {
        EmergencyAssistFooterData b8 = emergencyAssistUIData.b();
        if (b8 != null) {
            if (b8.b() != null) {
                AppCompatTextView keyText = (AppCompatTextView) V(R.id.f19836t6);
                Intrinsics.e(keyText, "keyText");
                TextViewExtKt.h(keyText, b8.a());
                Image b9 = b8.b();
                AppCompatImageView logo = (AppCompatImageView) V(R.id.logo);
                Intrinsics.e(logo, "logo");
                ImageKt.b(b9, logo, null, 2, null);
                g0(true);
                return;
            }
            g0(false);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f32660r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f32659q);
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32660r;
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
    /* renamed from: f0 */
    public EmergencyAssistHelpViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (EmergencyAssistHelpViewModel) new ViewModelProvider(requireActivity, E.d()).a(EmergencyAssistHelpViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f32658p;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
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
        LiveData<EmergencyAssistUIData> R = M().R();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<EmergencyAssistUIData, Unit> function1 = new Function1<EmergencyAssistUIData, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmergencyAssistUIData it) {
                ActiveIncidentDialogFragment activeIncidentDialogFragment = ActiveIncidentDialogFragment.this;
                Intrinsics.e(it, "it");
                activeIncidentDialogFragment.h0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmergencyAssistUIData emergencyAssistUIData) {
                b(emergencyAssistUIData);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveIncidentDialogFragment.b0(Function1.this, obj);
            }
        });
        ((AppCompatImageView) V(R.id.close_button)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActiveIncidentDialogFragment.c0(ActiveIncidentDialogFragment.this, view2);
            }
        });
        LiveData<ExternalHelpProviderResponse> T = M().T();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ExternalHelpProviderResponse, Unit> function12 = new Function1<ExternalHelpProviderResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalHelpProviderResponse externalHelpProviderResponse) {
                EmergencyAssistHelpViewModel M;
                DriverSettings driverSettings;
                if (externalHelpProviderResponse != null) {
                    ActiveIncidentDialogFragment activeIncidentDialogFragment = ActiveIncidentDialogFragment.this;
                    if (externalHelpProviderResponse.a() != null) {
                        M = activeIncidentDialogFragment.M();
                        String b8 = externalHelpProviderResponse.a().b();
                        driverSettings = activeIncidentDialogFragment.f32657o;
                        M.g0(b8, driverSettings.b());
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalHelpProviderResponse externalHelpProviderResponse) {
                b(externalHelpProviderResponse);
                return Unit.f50853a;
            }
        };
        T.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveIncidentDialogFragment.d0(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> S = M().S();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                Navigator a02;
                if (!bool.booleanValue()) {
                    a02 = ActiveIncidentDialogFragment.this.a0();
                    a02.c();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        S.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveIncidentDialogFragment.e0(Function1.this, obj);
            }
        });
    }
}
