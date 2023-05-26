package ee.mtakso.driver.ui.screens.contact_methods.voip.incoming;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.PermissionsDialogDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.VoipAddressLineDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import ee.mtakso.driver.uicore.components.views.CircularWavingButton;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.effects.Effect;
import ee.mtakso.driver.utils.effects.EffectRequest;
import ee.mtakso.driver.utils.effects.EffectsFactory;
import ee.mtakso.driver.utils.effects.SoundEffect;
import ee.mtakso.driver.utils.effects.VibrateEffect;
import eu.bolt.driver.core.permission.PermissionCallback;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.voip.service.call.CallState;
import eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallData;
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

/* compiled from: IncomingCallFragment.kt */
/* loaded from: classes3.dex */
public final class IncomingCallFragment extends ContactMethodsBaseBottomSheetDialog<IncomingCallViewModel> {
    public static final Companion G = new Companion(null);
    private final Lazy D;
    private final Lazy E;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public VoipPermissionDialogFactory f27987v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public EffectsFactory f27988w;

    /* renamed from: x  reason: collision with root package name */
    private VoipAddressLineDelegate f27989x;

    /* renamed from: y  reason: collision with root package name */
    private PermissionsDialogDelegate f27990y;

    /* renamed from: z  reason: collision with root package name */
    private Effect f27991z;
    public Map<Integer, View> F = new LinkedHashMap();
    private final Function0<Unit> A = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$onPermissionRequestedClick$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        public final void b() {
            PermissionManager N = IncomingCallFragment.this.N();
            final IncomingCallFragment incomingCallFragment = IncomingCallFragment.this;
            N.k("android.permission.RECORD_AUDIO", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$onPermissionRequestedClick$1.1
                @Override // eu.bolt.driver.core.permission.PermissionCallback
                public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                    Intrinsics.f(permission, "permission");
                    Intrinsics.f(initiator, "initiator");
                    Intrinsics.f(rationalStatus, "rationalStatus");
                    Kalev.b("Permission denied");
                    IncomingCallFragment.this.l0();
                }

                @Override // eu.bolt.driver.core.permission.PermissionCallback
                public void b(String permission) {
                    Function0 function0;
                    Intrinsics.f(permission, "permission");
                    Kalev.b("Permission granted");
                    function0 = IncomingCallFragment.this.B;
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
    private final Function0<Unit> B = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$onBluetoothPermissionRequestedClick$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        public final void b() {
            if (Build.VERSION.SDK_INT < 31) {
                IncomingCallFragment.this.e0();
                return;
            }
            PermissionManager N = IncomingCallFragment.this.N();
            final IncomingCallFragment incomingCallFragment = IncomingCallFragment.this;
            N.k("android.permission.BLUETOOTH_CONNECT", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$onBluetoothPermissionRequestedClick$1.1
                @Override // eu.bolt.driver.core.permission.PermissionCallback
                public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                    Intrinsics.f(permission, "permission");
                    Intrinsics.f(initiator, "initiator");
                    Intrinsics.f(rationalStatus, "rationalStatus");
                    Kalev.b("Permission denied");
                    IncomingCallFragment.this.l0();
                }

                @Override // eu.bolt.driver.core.permission.PermissionCallback
                public void b(String permission) {
                    Intrinsics.f(permission, "permission");
                    Kalev.b("Permission granted");
                    IncomingCallFragment.this.e0();
                }
            });
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };
    private final int C = R.layout.fragment_incoming_call;

    /* compiled from: IncomingCallFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IncomingCallFragment() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<IncomingCallViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final IncomingCallViewModel invoke() {
                IncomingCallFragment incomingCallFragment = IncomingCallFragment.this;
                return (IncomingCallViewModel) new ViewModelProvider(incomingCallFragment, incomingCallFragment.Q()).a(IncomingCallViewModel.class);
            }
        });
        this.D = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$newViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel invoke() {
                IncomingCallFragment incomingCallFragment = IncomingCallFragment.this;
                return (eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel) new ViewModelProvider(incomingCallFragment, incomingCallFragment.Q()).a(eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel.class);
            }
        });
        this.E = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        PermissionsDialogDelegate permissionsDialogDelegate = this.f27990y;
        PermissionsDialogDelegate permissionsDialogDelegate2 = null;
        if (permissionsDialogDelegate == null) {
            Intrinsics.w("permissionDialogDelegate");
            permissionsDialogDelegate = null;
        }
        if (!permissionsDialogDelegate.c()) {
            PermissionsDialogDelegate permissionsDialogDelegate3 = this.f27990y;
            if (permissionsDialogDelegate3 == null) {
                Intrinsics.w("permissionDialogDelegate");
            } else {
                permissionsDialogDelegate2 = permissionsDialogDelegate3;
            }
            permissionsDialogDelegate2.f();
            return;
        }
        n0().u();
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        if (isAdded()) {
            dismissAllowingStateLoss();
        } else {
            AssertUtils.a("Fragment was not added but was dismissed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        n0().G();
        k0();
    }

    private final eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel n0() {
        return (eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel) this.E.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(IncomingCallFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(IncomingCallFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.l0();
    }

    private final void t0() {
        if (this.f27991z != null) {
            return;
        }
        Effect a8 = m0().a(new EffectRequest.Builder().d(SoundEffect.Source.RING.f36414a).e(VibrateEffect.Type.f36420j).a());
        this.f27991z = a8;
        if (a8 != null) {
            a8.a();
        }
    }

    private final void u0() {
        Effect effect = this.f27991z;
        if (effect != null) {
            effect.cancel();
        }
        this.f27991z = null;
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.F.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.C;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().n(this);
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.F;
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

    public final EffectsFactory m0() {
        EffectsFactory effectsFactory = this.f27988w;
        if (effectsFactory != null) {
            return effectsFactory;
        }
        Intrinsics.w("effectsFactory");
        return null;
    }

    public final VoipPermissionDialogFactory o0() {
        VoipPermissionDialogFactory voipPermissionDialogFactory = this.f27987v;
        if (voipPermissionDialogFactory != null) {
            return voipPermissionDialogFactory;
        }
        Intrinsics.w("permissionsDialogFactory");
        return null;
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        PermissionsDialogDelegate permissionsDialogDelegate = new PermissionsDialogDelegate(requireContext, o0(), getChildFragmentManager(), N());
        this.f27990y = permissionsDialogDelegate;
        PermissionsDialogDelegate.e(permissionsDialogDelegate, this.A, null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onDismiss(dialog);
        u0();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        TextView passengerAddress = (TextView) d0(R.id.passengerAddress);
        Intrinsics.e(passengerAddress, "passengerAddress");
        this.f27989x = new VoipAddressLineDelegate(requireContext, passengerAddress);
        t0();
        Kalev.d("IncomingcallVM newViewModel onStart called");
        n0().o();
        LiveData<IncomingCallData> y7 = n0().y();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<IncomingCallData, Unit> function1 = new Function1<IncomingCallData, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(IncomingCallData incomingCallData) {
                VoipAddressLineDelegate voipAddressLineDelegate;
                if (incomingCallData.b() == CallState.ENDED) {
                    IncomingCallFragment.this.k0();
                    return;
                }
                ((TextView) IncomingCallFragment.this.d0(R.id.passengerName)).setText(incomingCallData.c());
                voipAddressLineDelegate = IncomingCallFragment.this.f27989x;
                if (voipAddressLineDelegate == null) {
                    Intrinsics.w("voipAddressLineDelegate");
                    voipAddressLineDelegate = null;
                }
                voipAddressLineDelegate.c(incomingCallData.a(), incomingCallData.d());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IncomingCallData incomingCallData) {
                b(incomingCallData);
                return Unit.f50853a;
            }
        };
        y7.i(viewLifecycleOwner, new Observer() { // from class: d3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingCallFragment.q0(Function1.this, obj);
            }
        });
        ((CircularWavingButton) d0(R.id.acceptButton)).setOnClickListener(new View.OnClickListener() { // from class: d3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IncomingCallFragment.r0(IncomingCallFragment.this, view2);
            }
        });
        ((CircularWavingButton) d0(R.id.declineButton)).setOnClickListener(new View.OnClickListener() { // from class: d3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IncomingCallFragment.s0(IncomingCallFragment.this, view2);
            }
        });
        Bundle arguments = getArguments();
        boolean z7 = false;
        if (arguments != null) {
            z7 = arguments.getBoolean("should_accept_on_start", false);
        }
        if (z7) {
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: p0 */
    public IncomingCallViewModel P() {
        return (IncomingCallViewModel) this.D.getValue();
    }
}
