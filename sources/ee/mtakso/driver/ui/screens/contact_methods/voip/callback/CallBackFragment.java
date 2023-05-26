package ee.mtakso.driver.ui.screens.contact_methods.voip.callback;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.OutgoingCallInfo;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.PermissionsDialogDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.permission.PermissionCallback;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallBackFragment.kt */
/* loaded from: classes3.dex */
public final class CallBackFragment extends ContactMethodsBaseBottomSheetDialog<CallBackViewModel> {
    public static final Companion C = new Companion(null);
    private final Function0<Unit> A;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public VoipPermissionDialogFactory f27825v;

    /* renamed from: x  reason: collision with root package name */
    private final Lazy f27827x;

    /* renamed from: y  reason: collision with root package name */
    private PermissionsDialogDelegate f27828y;

    /* renamed from: z  reason: collision with root package name */
    private final Function0<Unit> f27829z;
    public Map<Integer, View> B = new LinkedHashMap();

    /* renamed from: w  reason: collision with root package name */
    private final int f27826w = R.layout.fragment_call_back;

    /* compiled from: CallBackFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(NoAnswerIncomingCall call) {
            Intrinsics.f(call, "call");
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_call", call);
            return bundle;
        }
    }

    public CallBackFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<CallBackViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CallBackViewModel invoke() {
                CallBackFragment callBackFragment = CallBackFragment.this;
                return (CallBackViewModel) new ViewModelProvider(callBackFragment, callBackFragment.Q()).a(CallBackViewModel.class);
            }
        });
        this.f27827x = b8;
        this.f27829z = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment$onPermissionRequestedClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                PermissionManager N = CallBackFragment.this.N();
                final CallBackFragment callBackFragment = CallBackFragment.this;
                N.k("android.permission.RECORD_AUDIO", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment$onPermissionRequestedClick$1.1
                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                        Intrinsics.f(permission, "permission");
                        Intrinsics.f(initiator, "initiator");
                        Intrinsics.f(rationalStatus, "rationalStatus");
                        Kalev.b("Permission denied");
                        CallBackFragment.this.dismissAllowingStateLoss();
                    }

                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void b(String permission) {
                        Function0 function0;
                        Intrinsics.f(permission, "permission");
                        function0 = CallBackFragment.this.A;
                        function0.invoke();
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
        this.A = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment$onBluetoothPermissionRequestedClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                if (Build.VERSION.SDK_INT < 31) {
                    CallBackFragment.this.g0();
                    return;
                }
                PermissionManager N = CallBackFragment.this.N();
                final CallBackFragment callBackFragment = CallBackFragment.this;
                N.k("android.permission.BLUETOOTH_CONNECT", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment$onBluetoothPermissionRequestedClick$1.1
                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                        Intrinsics.f(permission, "permission");
                        Intrinsics.f(initiator, "initiator");
                        Intrinsics.f(rationalStatus, "rationalStatus");
                        Kalev.b("Permission denied");
                        CallBackFragment.this.dismissAllowingStateLoss();
                    }

                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void b(String permission) {
                        Intrinsics.f(permission, "permission");
                        CallBackFragment.this.g0();
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        NoAnswerIncomingCall noAnswerIncomingCall;
        Bundle arguments = getArguments();
        NoAnswerIncomingCall noAnswerIncomingCall2 = null;
        if (arguments != null) {
            noAnswerIncomingCall = (NoAnswerIncomingCall) arguments.getParcelable("arg_call");
        } else {
            noAnswerIncomingCall = null;
        }
        if (noAnswerIncomingCall instanceof NoAnswerIncomingCall) {
            noAnswerIncomingCall2 = noAnswerIncomingCall;
        }
        if (noAnswerIncomingCall2 == null) {
            Kalev.l("argument arg_call is required");
            dismissAllowingStateLoss();
            return;
        }
        P().G(noAnswerIncomingCall2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(CallBackFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(CallBackFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        AppCompatImageButton closeImageButton = (AppCompatImageButton) this$0.d0(R.id.closeImageButton);
        Intrinsics.e(closeImageButton, "closeImageButton");
        ViewExtKt.e(closeImageButton, false, 0, 2, null);
        View errorContainer = this$0.d0(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, false, 0, 2, null);
        this$0.g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.B.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f27826w;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().w(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void W(Throwable error) {
        Intrinsics.f(error, "error");
        ConstraintLayout container = (ConstraintLayout) d0(R.id.M2);
        Intrinsics.e(container, "container");
        ViewExtKt.e(container, true, 0, 2, null);
        AppCompatImageButton closeImageButton = (AppCompatImageButton) d0(R.id.closeImageButton);
        Intrinsics.e(closeImageButton, "closeImageButton");
        ViewExtKt.e(closeImageButton, true, 0, 2, null);
        View errorContainer = d0(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, true, 0, 2, null);
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.B;
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
    /* renamed from: h0 */
    public CallBackViewModel P() {
        return (CallBackViewModel) this.f27827x.getValue();
    }

    public final VoipPermissionDialogFactory i0() {
        VoipPermissionDialogFactory voipPermissionDialogFactory = this.f27825v;
        if (voipPermissionDialogFactory != null) {
            return voipPermissionDialogFactory;
        }
        Intrinsics.w("voipPermissionDialogFactory");
        return null;
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        PermissionsDialogDelegate permissionsDialogDelegate = new PermissionsDialogDelegate(requireContext, i0(), getChildFragmentManager(), N());
        this.f27828y = permissionsDialogDelegate;
        permissionsDialogDelegate.d(this.f27829z, new CallBackFragment$onCreate$1(this));
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
        PermissionsDialogDelegate permissionsDialogDelegate = this.f27828y;
        if (permissionsDialogDelegate == null) {
            Intrinsics.w("permissionsDialogDelegate");
            permissionsDialogDelegate = null;
        }
        if (!permissionsDialogDelegate.c()) {
            PermissionsDialogDelegate permissionsDialogDelegate2 = this.f27828y;
            if (permissionsDialogDelegate2 == null) {
                Intrinsics.w("permissionsDialogDelegate");
                permissionsDialogDelegate2 = null;
            }
            permissionsDialogDelegate2.f();
        } else {
            g0();
        }
        int i8 = R.id.closeImageButton;
        ((AppCompatImageButton) d0(i8)).setOnClickListener(new View.OnClickListener() { // from class: c3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CallBackFragment.j0(CallBackFragment.this, view2);
            }
        });
        ((RoundButton) d0(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: c3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CallBackFragment.k0(CallBackFragment.this, view2);
            }
        });
        AppCompatImageButton closeImageButton = (AppCompatImageButton) d0(i8);
        Intrinsics.e(closeImageButton, "closeImageButton");
        ViewExtKt.e(closeImageButton, false, 0, 2, null);
        View errorContainer = d0(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, false, 0, 2, null);
        LiveData<OutgoingCallInfo> J = P().J();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<OutgoingCallInfo, Unit> function1 = new Function1<OutgoingCallInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OutgoingCallInfo outgoingCallInfo) {
                CallBackFragment.this.dismissAllowingStateLoss();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OutgoingCallInfo outgoingCallInfo) {
                b(outgoingCallInfo);
                return Unit.f50853a;
            }
        };
        J.i(viewLifecycleOwner, new Observer() { // from class: c3.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CallBackFragment.l0(Function1.this, obj);
            }
        });
    }
}
