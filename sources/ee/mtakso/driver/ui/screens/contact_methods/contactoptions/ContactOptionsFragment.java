package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.PhoneOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.PermissionsDialogDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import ee.mtakso.driver.uicore.components.views.CustomListItem;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.Utils;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.R$style;
import eu.bolt.driver.core.permission.PermissionCallback;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsFragment.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsFragment extends ContactMethodsBaseBottomSheetDialog<ContactOptionsViewModel> {
    public static final Companion F = new Companion(null);
    private final Function0<Unit> A;
    private final Function0<Unit> B;
    private final int C;
    private final Lazy D;
    public Map<Integer, View> E = new LinkedHashMap();
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public VoipPermissionDialogFactory f27772v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public Features f27773w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public RoutingManager f27774x;

    /* renamed from: y  reason: collision with root package name */
    public PermissionsDialogDelegate f27775y;

    /* renamed from: z  reason: collision with root package name */
    private final Lazy f27776z;

    /* compiled from: ContactOptionsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(ContactOptionsConfig config) {
            Intrinsics.f(config, "config");
            Bundle bundle = new Bundle();
            bundle.putParcelable("config", config);
            return bundle;
        }
    }

    /* compiled from: ContactOptionsFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27777a;

        static {
            int[] iArr = new int[CancelTarget.values().length];
            try {
                iArr[CancelTarget.CHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f27777a = iArr;
        }
    }

    public ContactOptionsFragment() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ContactOptionsConfig>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$contactOptionsConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ContactOptionsConfig invoke() {
                ContactOptionsConfig contactOptionsConfig;
                Bundle arguments = ContactOptionsFragment.this.getArguments();
                ContactOptionsConfig contactOptionsConfig2 = null;
                if (arguments != null) {
                    contactOptionsConfig = (ContactOptionsConfig) arguments.getParcelable("config");
                } else {
                    contactOptionsConfig = null;
                }
                if (contactOptionsConfig instanceof ContactOptionsConfig) {
                    contactOptionsConfig2 = contactOptionsConfig;
                }
                if (contactOptionsConfig2 == null) {
                    return new ContactOptionsConfig(false, null, null, null, 15, null);
                }
                return contactOptionsConfig2;
            }
        });
        this.f27776z = b8;
        this.A = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$onPermissionRequestedClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                PermissionManager N = ContactOptionsFragment.this.N();
                final ContactOptionsFragment contactOptionsFragment = ContactOptionsFragment.this;
                N.k("android.permission.RECORD_AUDIO", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$onPermissionRequestedClick$1.1
                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                        Intrinsics.f(permission, "permission");
                        Intrinsics.f(initiator, "initiator");
                        Intrinsics.f(rationalStatus, "rationalStatus");
                        Kalev.b("Permission denied");
                    }

                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void b(String permission) {
                        Function0 function0;
                        Intrinsics.f(permission, "permission");
                        function0 = ContactOptionsFragment.this.B;
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
        this.B = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$onBluetoothPermissionRequestedClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                if (Build.VERSION.SDK_INT < 31) {
                    ContactOptionsFragment.this.P().e0();
                    return;
                }
                PermissionManager N = ContactOptionsFragment.this.N();
                final ContactOptionsFragment contactOptionsFragment = ContactOptionsFragment.this;
                N.k("android.permission.BLUETOOTH_CONNECT", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$onBluetoothPermissionRequestedClick$1.1
                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                        Intrinsics.f(permission, "permission");
                        Intrinsics.f(initiator, "initiator");
                        Intrinsics.f(rationalStatus, "rationalStatus");
                        Kalev.b("Permission denied");
                    }

                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void b(String permission) {
                        Intrinsics.f(permission, "permission");
                        ContactOptionsFragment.this.P().e0();
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
        this.C = R.layout.fragment_contact_options;
        b9 = LazyKt__LazyJVMKt.b(new Function0<ContactOptionsViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ContactOptionsViewModel invoke() {
                ContactOptionsFragment contactOptionsFragment = ContactOptionsFragment.this;
                return (ContactOptionsViewModel) new ViewModelProvider(contactOptionsFragment, contactOptionsFragment.Q()).a(ContactOptionsViewModel.class);
            }
        });
        this.D = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ContactOptionsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (WhenMappings.f27777a[this$0.m0().a().ordinal()] == 1) {
            this$0.P().Y();
        } else {
            this$0.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ContactOptionsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().h0();
    }

    private final ContactOptionsConfig m0() {
        return (ContactOptionsConfig) this.f27776z.getValue();
    }

    private final void r0(PhoneOptionsData phoneOptionsData) {
        Utils.b(requireActivity(), phoneOptionsData.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(final ContactOptionsFragment this$0, final ContactOptionsData contactOptionsData) {
        Intrinsics.f(this$0, "this$0");
        this$0.Y(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$onViewCreated$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                CustomListItem callInAppButton = (CustomListItem) ContactOptionsFragment.this.k0(R.id.callInAppButton);
                Intrinsics.e(callInAppButton, "callInAppButton");
                ViewExtKt.e(callInAppButton, contactOptionsData.g(), 0, 2, null);
                View chatButtonDivider = ContactOptionsFragment.this.k0(R.id.chatButtonDivider);
                Intrinsics.e(chatButtonDivider, "chatButtonDivider");
                ViewExtKt.e(chatButtonDivider, contactOptionsData.g(), 0, 2, null);
                CustomListItem callPhoneButton = (CustomListItem) ContactOptionsFragment.this.k0(R.id.callPhoneButton);
                Intrinsics.e(callPhoneButton, "callPhoneButton");
                ViewExtKt.e(callPhoneButton, contactOptionsData.f(), 0, 2, null);
                View callInAppButtonDivider = ContactOptionsFragment.this.k0(R.id.callInAppButtonDivider);
                Intrinsics.e(callInAppButtonDivider, "callInAppButtonDivider");
                ViewExtKt.e(callInAppButtonDivider, contactOptionsData.f(), 0, 2, null);
                CustomListItem chatButton = (CustomListItem) ContactOptionsFragment.this.k0(R.id.chatButton);
                Intrinsics.e(chatButton, "chatButton");
                ViewExtKt.e(chatButton, contactOptionsData.e(), 0, 2, null);
                TextView title = (TextView) ContactOptionsFragment.this.k0(R.id.cc);
                Intrinsics.e(title, "title");
                ViewExtKt.e(title, true, 0, 2, null);
                TextView description = (TextView) ContactOptionsFragment.this.k0(R.id.f19832m3);
                Intrinsics.e(description, "description");
                ViewExtKt.e(description, true, 0, 2, null);
                View controlsContainer = ContactOptionsFragment.this.k0(R.id.controlsContainer);
                Intrinsics.e(controlsContainer, "controlsContainer");
                ViewExtKt.e(controlsContainer, true, 0, 2, null);
                View loadingContainer = ContactOptionsFragment.this.k0(R.id.loadingContainer);
                Intrinsics.e(loadingContainer, "loadingContainer");
                ViewExtKt.e(loadingContainer, false, 0, 2, null);
                View errorContainer = ContactOptionsFragment.this.k0(R.id.errorContainer);
                Intrinsics.e(errorContainer, "errorContainer");
                ViewExtKt.e(errorContainer, false, 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(final ContactOptionsFragment this$0, final Throwable th) {
        Intrinsics.f(this$0, "this$0");
        this$0.Y(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment$onViewCreated$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                TextView title = (TextView) ContactOptionsFragment.this.k0(R.id.cc);
                Intrinsics.e(title, "title");
                ViewExtKt.e(title, false, 0, 2, null);
                TextView description = (TextView) ContactOptionsFragment.this.k0(R.id.f19832m3);
                Intrinsics.e(description, "description");
                ViewExtKt.e(description, false, 0, 2, null);
                View controlsContainer = ContactOptionsFragment.this.k0(R.id.controlsContainer);
                Intrinsics.e(controlsContainer, "controlsContainer");
                ViewExtKt.e(controlsContainer, false, 0, 2, null);
                View loadingContainer = ContactOptionsFragment.this.k0(R.id.loadingContainer);
                Intrinsics.e(loadingContainer, "loadingContainer");
                ViewExtKt.e(loadingContainer, false, 0, 2, null);
                View errorContainer = ContactOptionsFragment.this.k0(R.id.errorContainer);
                Intrinsics.e(errorContainer, "errorContainer");
                ViewExtKt.e(errorContainer, true, 0, 2, null);
                Throwable it = th;
                Intrinsics.e(it, "it");
                Context requireContext = ContactOptionsFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                ((TextView) ContactOptionsFragment.this.k0(R.id.f19829c4)).setText(ApiExceptionUtils.k(it, requireContext));
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ContactOptionsFragment this$0, PhoneOptionsData it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.r0(it);
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(ContactOptionsFragment this$0, VoipOptionsData voipOptionsData) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ContactOptionsFragment this$0, ChatOptionsData chatOptionsData) {
        Intrinsics.f(this$0, "this$0");
        this$0.o0().c(DriverChatSdk.f40388a.a());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(ContactOptionsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(ContactOptionsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (!this$0.n0().c()) {
            this$0.n0().f();
        } else {
            this$0.P().e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ContactOptionsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().Y();
    }

    public final void C0(PermissionsDialogDelegate permissionsDialogDelegate) {
        Intrinsics.f(permissionsDialogDelegate, "<set-?>");
        this.f27775y = permissionsDialogDelegate;
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.E.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void R() {
        super.R();
        ((RoundButton) k0(R.id.O9)).g();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void X() {
        super.X();
        ((RoundButton) k0(R.id.O9)).k();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog
    protected boolean Z() {
        return true;
    }

    public View k0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.E;
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

    public final PermissionsDialogDelegate n0() {
        PermissionsDialogDelegate permissionsDialogDelegate = this.f27775y;
        if (permissionsDialogDelegate != null) {
            return permissionsDialogDelegate;
        }
        Intrinsics.w("permissionsDialogDelegate");
        return null;
    }

    public final RoutingManager o0() {
        RoutingManager routingManager = this.f27774x;
        if (routingManager != null) {
            return routingManager;
        }
        Intrinsics.w("routingManager");
        return null;
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.Theme_ContactMethodsBottomSheetDialog);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        C0(new PermissionsDialogDelegate(requireContext, q0(), getChildFragmentManager(), N()));
        PermissionsDialogDelegate.e(n0(), this.A, null, 2, null);
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
        P().R(m0());
        P().S();
        P().U().i(getViewLifecycleOwner(), new Observer() { // from class: a3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactOptionsFragment.s0(ContactOptionsFragment.this, (ContactOptionsData) obj);
            }
        });
        P().w().i(getViewLifecycleOwner(), new Observer() { // from class: a3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactOptionsFragment.t0(ContactOptionsFragment.this, (Throwable) obj);
            }
        });
        P().W().i(getViewLifecycleOwner(), new Observer() { // from class: a3.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactOptionsFragment.u0(ContactOptionsFragment.this, (PhoneOptionsData) obj);
            }
        });
        P().X().i(getViewLifecycleOwner(), new Observer() { // from class: a3.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactOptionsFragment.v0(ContactOptionsFragment.this, (VoipOptionsData) obj);
            }
        });
        P().V().i(getViewLifecycleOwner(), new Observer() { // from class: a3.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactOptionsFragment.w0(ContactOptionsFragment.this, (ChatOptionsData) obj);
            }
        });
        ((CustomListItem) k0(R.id.callPhoneButton)).setOnClickListener(new View.OnClickListener() { // from class: a3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactOptionsFragment.x0(ContactOptionsFragment.this, view2);
            }
        });
        ((CustomListItem) k0(R.id.callInAppButton)).setOnClickListener(new View.OnClickListener() { // from class: a3.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactOptionsFragment.y0(ContactOptionsFragment.this, view2);
            }
        });
        ((CustomListItem) k0(R.id.chatButton)).setOnClickListener(new View.OnClickListener() { // from class: a3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactOptionsFragment.z0(ContactOptionsFragment.this, view2);
            }
        });
        ((AppCompatImageView) k0(R.id.A2)).setOnClickListener(new View.OnClickListener() { // from class: a3.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactOptionsFragment.A0(ContactOptionsFragment.this, view2);
            }
        });
        ((RoundButton) k0(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: a3.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactOptionsFragment.B0(ContactOptionsFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: p0 */
    public ContactOptionsViewModel P() {
        return (ContactOptionsViewModel) this.D.getValue();
    }

    public final VoipPermissionDialogFactory q0() {
        VoipPermissionDialogFactory voipPermissionDialogFactory = this.f27772v;
        if (voipPermissionDialogFactory != null) {
            return voipPermissionDialogFactory;
        }
        Intrinsics.w("voipPermissionDialogFactory");
        return null;
    }
}
