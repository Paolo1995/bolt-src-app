package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.boltclub.delegates.SimpleFooterDelegate;
import ee.mtakso.driver.ui.screens.dialogs.InfoDialog;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistType;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeatureData;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemChipDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemTextDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public final class SafetyToolkitBottomSheetFragment extends BaseMvvmBottomSheetDialogFragment<SafetyToolkitViewModel> {
    public static final Companion B = new Companion(null);
    public Map<Integer, View> A;

    /* renamed from: r  reason: collision with root package name */
    private final SafetyToolkitMapper f32783r;

    /* renamed from: s  reason: collision with root package name */
    private final FragmentFactory f32784s;

    /* renamed from: t  reason: collision with root package name */
    private final MicrophonePermissionDialogProvider f32785t;

    /* renamed from: u  reason: collision with root package name */
    private Disposable f32786u;

    /* renamed from: v  reason: collision with root package name */
    private final DiffAdapter f32787v;

    /* renamed from: w  reason: collision with root package name */
    private final SafetyToolkitBottomSheetFragment$confirmPermissionDialogCallback$1 f32788w;

    /* renamed from: x  reason: collision with root package name */
    private final int f32789x;

    /* renamed from: y  reason: collision with root package name */
    private final Lazy f32790y;

    /* renamed from: z  reason: collision with root package name */
    private ExternalHelpProviderResponse f32791z;

    /* compiled from: SafetyToolkitBottomSheetFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$confirmPermissionDialogCallback$1] */
    @Inject
    public SafetyToolkitBottomSheetFragment(SafetyToolkitMapper safetyToolkitMapper, FragmentFactory fragmentFactory, MicrophonePermissionDialogProvider microphonePermissionDialogProvider) {
        Lazy b8;
        Intrinsics.f(safetyToolkitMapper, "safetyToolkitMapper");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(microphonePermissionDialogProvider, "microphonePermissionDialogProvider");
        this.A = new LinkedHashMap();
        this.f32783r = safetyToolkitMapper;
        this.f32784s = fragmentFactory;
        this.f32785t = microphonePermissionDialogProvider;
        this.f32787v = new DiffAdapter().P(new TwoLinesItemDelegate(new SafetyToolkitBottomSheetFragment$diffAdapter$1(this), new SafetyToolkitBottomSheetFragment$diffAdapter$2(this), 0, null, 12, null)).P(new TwoLinesItemChipDelegate(new SafetyToolkitBottomSheetFragment$diffAdapter$3(this), new SafetyToolkitBottomSheetFragment$diffAdapter$4(this))).P(new TwoLinesItemTextDelegate(new SafetyToolkitBottomSheetFragment$diffAdapter$5(this), new SafetyToolkitBottomSheetFragment$diffAdapter$6(this), null, 4, null)).P(new SimpleFooterDelegate());
        this.f32788w = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$confirmPermissionDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "ITEM_CONFIRM_TAG")) {
                    SafetyToolkitBottomSheetFragment.this.P().Z();
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", SafetyToolkitBottomSheetFragment.this.requireContext().getPackageName(), null));
                    SafetyToolkitBottomSheetFragment.this.requireContext().startActivity(intent);
                    return;
                }
                SafetyToolkitBottomSheetFragment.this.P().Y();
            }
        };
        this.f32789x = R.layout.fragment_safety_toolkit_bottomsheet;
        b8 = LazyKt__LazyJVMKt.b(new Function0<SafetyToolkitViewModel>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SafetyToolkitViewModel invoke() {
                SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment = SafetyToolkitBottomSheetFragment.this;
                return (SafetyToolkitViewModel) new ViewModelProvider(safetyToolkitBottomSheetFragment, safetyToolkitBottomSheetFragment.Q()).a(SafetyToolkitViewModel.class);
            }
        });
        this.f32790y = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ListModel> l0(List<SafetyFeature> list) {
        SafetyToolkitMapper safetyToolkitMapper = this.f32783r;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        return safetyToolkitMapper.d(list, requireContext);
    }

    private final void m0(final boolean z7) {
        Single l8 = PermissionManager.l(N(), "android.permission.RECORD_AUDIO", null, 2, null);
        final Function1<PermissionManager.PermissionInfo, Unit> function1 = new Function1<PermissionManager.PermissionInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$checkPermissionAndLaunch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(PermissionManager.PermissionInfo permissionInfo) {
                Kalev.b("Permission result " + permissionInfo);
                if (permissionInfo.d() == PermissionManager.PermissionStatus.GRANTED) {
                    SafetyToolkitBottomSheetFragment.this.s0(z7);
                } else if (permissionInfo.a() == PermissionManager.DenyInitiator.AUTOMATIC_DENY) {
                    SafetyToolkitBottomSheetFragment.this.P().a0();
                    SafetyToolkitBottomSheetFragment.this.t0();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PermissionManager.PermissionInfo permissionInfo) {
                b(permissionInfo);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitBottomSheetFragment.n0(Function1.this, obj);
            }
        };
        final SafetyToolkitBottomSheetFragment$checkPermissionAndLaunch$2 safetyToolkitBottomSheetFragment$checkPermissionAndLaunch$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$checkPermissionAndLaunch$2
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
        this.f32786u = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyToolkitBottomSheetFragment.o0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(TwoLinesItemDelegate.Model<SafetyFeature> model) {
        SafetyFeature B2 = model.B();
        if (B2 != null && model.o()) {
            SafetyFeatureData a8 = B2.a();
            if (!(a8 instanceof SafetyFeatureData.EmergencyAssist)) {
                if (a8 instanceof SafetyFeatureData.ShareRideDetails) {
                    x0();
                } else if (a8 instanceof SafetyFeatureData.TripAudioRecording) {
                    y0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(TwoLinesItemDelegate.Model<SafetyFeature> model) {
        SafetyFeature B2;
        if (model.o() && (B2 = model.B()) != null) {
            SafetyFeatureData a8 = B2.a();
            if (a8 instanceof SafetyFeatureData.EmergencyAssist) {
                ExternalHelpProviderResponse externalHelpProviderResponse = this.f32791z;
                if (externalHelpProviderResponse != null) {
                    if (externalHelpProviderResponse.a() == null) {
                        P().X("authority");
                    } else {
                        P().X(externalHelpProviderResponse.a().b());
                    }
                }
                dismissAllowingStateLoss();
                SafetyFeatureData.EmergencyAssist emergencyAssist = (SafetyFeatureData.EmergencyAssist) B2.a();
                if (emergencyAssist.e() == EmergencyAssistType.THIRD_PARTY && emergencyAssist.b()) {
                    SimpleActivity.Companion companion = SimpleActivity.f27004l;
                    Context requireContext = requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    SimpleActivity.Companion.m(companion, requireContext, ActiveIncidentDialogFragment.class, null, false, 4, null);
                    return;
                }
                FragmentFactory fragmentFactory = this.f32784s;
                Context requireContext2 = requireContext();
                Intrinsics.e(requireContext2, "requireContext()");
                ((EmergencyAssistHelpBottomSheetFragment) FragmentFactoryUtils.c(fragmentFactory, requireContext2, EmergencyAssistHelpBottomSheetFragment.class, null, 4, null)).show(getParentFragmentManager(), "emergencyAssistHelperDialog");
            } else if (a8 instanceof SafetyFeatureData.ShareRideDetails) {
                P().T();
            } else if (a8 instanceof SafetyFeatureData.TripAudioRecording) {
                P().W(((SafetyFeatureData.TripAudioRecording) B2.a()).d());
                SafetyFeature B3 = model.B();
                Intrinsics.d(B3, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeature");
                m0(B3.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(boolean z7) {
        if (z7) {
            P().c0();
            dismissAllowingStateLoss();
            FragmentFactory fragmentFactory = this.f32784s;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            ((AudioRecordingBottomSheetFragment) FragmentFactoryUtils.c(fragmentFactory, requireContext, AudioRecordingBottomSheetFragment.class, null, 4, null)).show(getParentFragmentManager(), "audioRecordingBottomSheet");
            return;
        }
        P().S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        FragmentUtils.b(this.f32785t.a(this.f32788w), this, "permission_denied_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(SafetyToolkitBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void x0() {
        InfoDialog.Companion companion = InfoDialog.f28307n;
        String string = getString(R.string.share_trip_details_title);
        String string2 = getString(R.string.share_trip_details_info_description);
        String string3 = getString(R.string.close);
        Intrinsics.e(string3, "getString(R.string.close)");
        FragmentUtils.b(InfoDialog.Companion.b(companion, string, string2, string3, null, null, 16, null), this, "dialog_tag_share_trip");
        P().O();
    }

    private final void y0() {
        InfoDialog.Companion companion = InfoDialog.f28307n;
        String string = getString(R.string.audio_recording_title);
        String string2 = getString(R.string.audio_recording_info_description);
        String string3 = getString(R.string.close);
        Intrinsics.e(string3, "getString(R.string.close)");
        FragmentUtils.b(InfoDialog.Companion.b(companion, string, string2, string3, null, null, 16, null), this, "dialog_tag_audio_recording");
        P().O();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.A.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f32789x;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().B(this);
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.A;
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

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        bottomSheetDialog.n().Q0(3);
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "permission_denied_dialog", this.f32788w);
        return bottomSheetDialog;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Disposable disposable = this.f32786u;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        H();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LiveData<ExternalHelpProviderResponse> M = P().M();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ExternalHelpProviderResponse, Unit> function1 = new Function1<ExternalHelpProviderResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalHelpProviderResponse externalHelpProviderResponse) {
                SafetyToolkitBottomSheetFragment.this.f32791z = externalHelpProviderResponse;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalHelpProviderResponse externalHelpProviderResponse) {
                b(externalHelpProviderResponse);
                return Unit.f50853a;
            }
        };
        M.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SafetyToolkitBottomSheetFragment.u0(Function1.this, obj);
            }
        });
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) d0(R.id.toolkitRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f32787v);
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((ImageView) d0(R.id.closeToolkit)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SafetyToolkitBottomSheetFragment.v0(SafetyToolkitBottomSheetFragment.this, view2);
            }
        });
        P().b0();
        LiveData<List<SafetyFeature>> N = P().N();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends SafetyFeature>, Unit> function1 = new Function1<List<? extends SafetyFeature>, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<SafetyFeature> it) {
                List l02;
                DiffAdapter diffAdapter;
                SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment = SafetyToolkitBottomSheetFragment.this;
                Intrinsics.e(it, "it");
                l02 = safetyToolkitBottomSheetFragment.l0(it);
                View loadingContainer = SafetyToolkitBottomSheetFragment.this.d0(R.id.loadingContainer);
                Intrinsics.e(loadingContainer, "loadingContainer");
                ViewExtKt.e(loadingContainer, false, 0, 2, null);
                diffAdapter = SafetyToolkitBottomSheetFragment.this.f32787v;
                DiffAdapter.V(diffAdapter, l02, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SafetyFeature> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        N.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SafetyToolkitBottomSheetFragment.w0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: p0 */
    public SafetyToolkitViewModel P() {
        return (SafetyToolkitViewModel) this.f32790y.getValue();
    }
}
