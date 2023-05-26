package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.PhoneOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOptionsData;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallErrorFragment.kt */
/* loaded from: classes3.dex */
public final class VoipCallErrorFragment extends ContactMethodsBaseBottomSheetDialog<VoipCallErrorViewModel> {

    /* renamed from: z  reason: collision with root package name */
    public static final Companion f27851z = new Companion(null);

    /* renamed from: v  reason: collision with root package name */
    private final Lazy f27852v;

    /* renamed from: w  reason: collision with root package name */
    private final int f27853w;

    /* renamed from: x  reason: collision with root package name */
    private final Lazy f27854x;

    /* renamed from: y  reason: collision with root package name */
    public Map<Integer, View> f27855y = new LinkedHashMap();

    /* compiled from: VoipCallErrorFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(VoipCallErrorConfig config) {
            Intrinsics.f(config, "config");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_CONFIG", config);
            return bundle;
        }
    }

    public VoipCallErrorFragment() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<VoipCallErrorConfig>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final VoipCallErrorConfig invoke() {
                Parcelable parcelable = VoipCallErrorFragment.this.requireArguments().getParcelable("ARG_CONFIG");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorConfig");
                return (VoipCallErrorConfig) parcelable;
            }
        });
        this.f27852v = b8;
        this.f27853w = R.layout.fragment_voip_error;
        b9 = LazyKt__LazyJVMKt.b(new Function0<VoipCallErrorViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final VoipCallErrorViewModel invoke() {
                VoipCallErrorFragment voipCallErrorFragment = VoipCallErrorFragment.this;
                return (VoipCallErrorViewModel) new ViewModelProvider(voipCallErrorFragment, voipCallErrorFragment.Q()).a(VoipCallErrorViewModel.class);
            }
        });
        this.f27854x = b9;
    }

    private final VoipCallErrorConfig h0() {
        return (VoipCallErrorConfig) this.f27852v.getValue();
    }

    private final void j0(PhoneOptionsData phoneOptionsData) {
        Utils.b(requireActivity(), phoneOptionsData.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(VoipCallErrorFragment this$0, ContactOptionsData contactOptionsData) {
        Intrinsics.f(this$0, "this$0");
        RoundButton tryAgainButton = (RoundButton) this$0.g0(R.id.tryAgainButton);
        Intrinsics.e(tryAgainButton, "tryAgainButton");
        ViewExtKt.e(tryAgainButton, contactOptionsData.g(), 0, 2, null);
        RoundButton callByPhoneButton = (RoundButton) this$0.g0(R.id.callByPhoneButton);
        Intrinsics.e(callByPhoneButton, "callByPhoneButton");
        ViewExtKt.e(callByPhoneButton, contactOptionsData.f(), 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(VoipCallErrorFragment this$0, Throwable th) {
        Intrinsics.f(this$0, "this$0");
        IndeterminateProgressView loadingView = (IndeterminateProgressView) this$0.g0(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(VoipCallErrorFragment this$0, PhoneOptionsData it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.j0(it);
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(VoipCallErrorFragment this$0, VoipOptionsData voipOptionsData) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(VoipCallErrorFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(VoipCallErrorFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().P();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f27855y.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f27853w;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void R() {
        IndeterminateProgressView loadingView = (IndeterminateProgressView) g0(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().t(this);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void X() {
        IndeterminateProgressView loadingView = (IndeterminateProgressView) g0(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 3, null);
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog
    protected boolean Z() {
        return true;
    }

    public View g0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27855y;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: i0 */
    public VoipCallErrorViewModel P() {
        return (VoipCallErrorViewModel) this.f27854x.getValue();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        P().O(h0());
        P().S().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoipCallErrorFragment.k0(VoipCallErrorFragment.this, (ContactOptionsData) obj);
            }
        });
        P().w().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoipCallErrorFragment.l0(VoipCallErrorFragment.this, (Throwable) obj);
            }
        });
        P().T().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoipCallErrorFragment.m0(VoipCallErrorFragment.this, (PhoneOptionsData) obj);
            }
        });
        P().U().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoipCallErrorFragment.n0(VoipCallErrorFragment.this, (VoipOptionsData) obj);
            }
        });
        ((RoundButton) g0(R.id.tryAgainButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VoipCallErrorFragment.o0(VoipCallErrorFragment.this, view2);
            }
        });
        ((RoundButton) g0(R.id.callByPhoneButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VoipCallErrorFragment.p0(VoipCallErrorFragment.this, view2);
            }
        });
    }
}
