package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.Utils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.CancellationDialog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistHelpBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistHelpBottomSheetFragment extends BaseMvvmBottomSheetDialogFragment<EmergencyAssistHelpViewModel> {
    public static final Companion A = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final EmergencyAssistDataMapper f32674r;

    /* renamed from: s  reason: collision with root package name */
    private final FragmentFactory f32675s;

    /* renamed from: t  reason: collision with root package name */
    private final DriverSettings f32676t;

    /* renamed from: u  reason: collision with root package name */
    private Disposable f32677u;

    /* renamed from: v  reason: collision with root package name */
    private ExternalHelpProviderResponse f32678v;

    /* renamed from: w  reason: collision with root package name */
    private final DiffAdapter f32679w;

    /* renamed from: x  reason: collision with root package name */
    private final EmergencyAssistHelpBottomSheetFragment$dialogActionCallback$1 f32680x;

    /* renamed from: y  reason: collision with root package name */
    private final int f32681y;

    /* renamed from: z  reason: collision with root package name */
    public Map<Integer, View> f32682z;

    /* compiled from: EmergencyAssistHelpBottomSheetFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmergencyAssistHelpBottomSheetFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32683a;

        static {
            int[] iArr = new int[EmergencyAssistType.values().length];
            try {
                iArr[EmergencyAssistType.THIRD_PARTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EmergencyAssistType.LOCAL_AUTHORITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f32683a = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$dialogActionCallback$1] */
    @Inject
    public EmergencyAssistHelpBottomSheetFragment(EmergencyAssistDataMapper emergencyAssistDataMapper, FragmentFactory fragmentFactory, DriverSettings driverSettings) {
        Intrinsics.f(emergencyAssistDataMapper, "emergencyAssistDataMapper");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(driverSettings, "driverSettings");
        this.f32682z = new LinkedHashMap();
        this.f32674r = emergencyAssistDataMapper;
        this.f32675s = fragmentFactory;
        this.f32676t = driverSettings;
        DiffAdapter diffAdapter = new DiffAdapter();
        diffAdapter.P(new InfoBlockDelegate());
        diffAdapter.P(new TwoLinesItemDelegate(new Function1<TwoLinesItemDelegate.Model<EmergencyAssistUIData>, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$diffAdapter$1$1
            public final void b(TwoLinesItemDelegate.Model<EmergencyAssistUIData> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<EmergencyAssistUIData> model) {
                b(model);
                return Unit.f50853a;
            }
        }, null, 0, null, 14, null));
        diffAdapter.P(new ButtonItemDelegate(new Function1<ButtonItemDelegate.Model<EmergencyAssistUIData>, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$diffAdapter$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ButtonItemDelegate.Model<EmergencyAssistUIData> it) {
                Intrinsics.f(it, "it");
                EmergencyAssistHelpBottomSheetFragment.this.m0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<EmergencyAssistUIData> model) {
                b(model);
                return Unit.f50853a;
            }
        }));
        diffAdapter.P(new FooterEmergencyHelpDelegate());
        this.f32679w = diffAdapter;
        this.f32680x = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$dialogActionCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                String k02;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                k02 = EmergencyAssistHelpBottomSheetFragment.this.k0();
                if (Intrinsics.a(payload, "positive")) {
                    if (k02 != null) {
                        EmergencyAssistHelpBottomSheetFragment.this.P().e0(k02);
                    }
                    EmergencyAssistHelpBottomSheetFragment.this.q0(dialog);
                    return;
                }
                if (k02 != null) {
                    EmergencyAssistHelpBottomSheetFragment.this.P().f0(k02);
                }
                dialog.dismissAllowingStateLoss();
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                String k02;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
                k02 = EmergencyAssistHelpBottomSheetFragment.this.k0();
                if (event == DialogLifecycleEvent.CANCELLED && k02 != null) {
                    EmergencyAssistHelpBottomSheetFragment.this.P().f0(k02);
                }
            }
        };
        this.f32681y = R.layout.fragment_emergency_assist_bottomsheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k0() {
        ExternalHelpProviderResponse externalHelpProviderResponse = this.f32678v;
        if (externalHelpProviderResponse != null && externalHelpProviderResponse.a() != null) {
            return externalHelpProviderResponse.a().b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(ButtonItemDelegate.Model<EmergencyAssistUIData> model) {
        EmergencyAssistUIData t7 = model.t();
        if (t7 != null) {
            int i8 = WhenMappings.f32683a[t7.d().ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    P().c0();
                    Utils.b(requireActivity(), t7.c());
                    dismissAllowingStateLoss();
                    FragmentFactory fragmentFactory = this.f32675s;
                    Context requireContext = requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    ((DidYouGetHelpFragment) FragmentFactoryUtils.c(fragmentFactory, requireContext, DidYouGetHelpFragment.class, null, 4, null)).show(getParentFragmentManager(), "DidYouGetHelpFragment");
                    return;
                }
                return;
            }
            ExternalHelpProviderResponse externalHelpProviderResponse = this.f32678v;
            if (externalHelpProviderResponse != null && externalHelpProviderResponse.a() != null) {
                P().d0(externalHelpProviderResponse.a().b());
            }
            if (this.f32676t.b() != 0) {
                SimpleActivity.Companion companion = SimpleActivity.f27004l;
                Context requireContext2 = requireContext();
                Intrinsics.e(requireContext2, "requireContext()");
                SimpleActivity.Companion.m(companion, requireContext2, ActiveIncidentDialogFragment.class, null, false, 4, null);
                return;
            }
            t0();
        }
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
    public static final void p0(EmergencyAssistHelpBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(final BaseDialogFragment baseDialogFragment) {
        Observable<Boolean> Z = P().Z();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$requestExternalHelp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Boolean isSuccessful) {
                BaseDialogFragment.this.dismissAllowingStateLoss();
                Intrinsics.e(isSuccessful, "isSuccessful");
                if (isSuccessful.booleanValue()) {
                    SimpleActivity.Companion companion = SimpleActivity.f27004l;
                    Context requireContext = this.requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    SimpleActivity.Companion.m(companion, requireContext, ActiveIncidentDialogFragment.class, null, false, 4, null);
                    this.dismissAllowingStateLoss();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpBottomSheetFragment.r0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$requestExternalHelp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                EmergencyAssistHelpViewModel P = EmergencyAssistHelpBottomSheetFragment.this.P();
                Intrinsics.e(it, "it");
                BaseViewModel.A(P, it, null, 2, null);
                EmergencyAssistHelpBottomSheetFragment.this.P().Q();
            }
        };
        this.f32677u = Z.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpBottomSheetFragment.s0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void t0() {
        CancellationDialog.Companion companion = CancellationDialog.f41073m;
        String string = getString(R.string.request_emergency);
        Intrinsics.e(string, "getString(R.string.request_emergency)");
        String string2 = getString(R.string.request_emergency_dialog_message);
        Intrinsics.e(string2, "getString(R.string.reque…emergency_dialog_message)");
        String string3 = getString(R.string.request_emergency_dialog_continue);
        Intrinsics.e(string3, "getString(R.string.reque…mergency_dialog_continue)");
        String string4 = getString(R.string.action_cancel);
        Intrinsics.e(string4, "getString(R.string.action_cancel)");
        FragmentUtils.b(companion.a(string, string2, string3, string4, this.f32680x), this, "continue_request_emergency");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f32682z.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f32681y;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void W(Throwable error) {
        Intrinsics.f(error, "error");
        super.W(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32682z;
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
    /* renamed from: l0 */
    public EmergencyAssistHelpViewModel P() {
        return (EmergencyAssistHelpViewModel) new ViewModelProvider(this, Q()).a(EmergencyAssistHelpViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "continue_request_emergency", this.f32680x);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        bottomSheetDialog.n().Q0(3);
        return bottomSheetDialog;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<ExternalHelpProviderResponse> T = P().T();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ExternalHelpProviderResponse, Unit> function1 = new Function1<ExternalHelpProviderResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalHelpProviderResponse externalHelpProviderResponse) {
                EmergencyAssistHelpBottomSheetFragment.this.f32678v = externalHelpProviderResponse;
                if (externalHelpProviderResponse.a() == null) {
                    ((TextView) EmergencyAssistHelpBottomSheetFragment.this.d0(R.id.cc)).setText(R.string.emergency_call_title);
                } else {
                    ((TextView) EmergencyAssistHelpBottomSheetFragment.this.d0(R.id.cc)).setText(R.string.emergency_assist_title);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalHelpProviderResponse externalHelpProviderResponse) {
                b(externalHelpProviderResponse);
                return Unit.f50853a;
            }
        };
        T.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmergencyAssistHelpBottomSheetFragment.n0(Function1.this, obj);
            }
        });
        RecyclerView recyclerView = (RecyclerView) d0(R.id.emergencyAssistRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f32679w);
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        LiveData<EmergencyAssistUIData> R = P().R();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<EmergencyAssistUIData, Unit> function12 = new Function1<EmergencyAssistUIData, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(EmergencyAssistUIData it) {
                EmergencyAssistDataMapper emergencyAssistDataMapper;
                DiffAdapter diffAdapter;
                emergencyAssistDataMapper = EmergencyAssistHelpBottomSheetFragment.this.f32674r;
                Intrinsics.e(it, "it");
                List<ListModel> a8 = emergencyAssistDataMapper.a(it, view);
                View loadingContainer = EmergencyAssistHelpBottomSheetFragment.this.d0(R.id.loadingContainer);
                Intrinsics.e(loadingContainer, "loadingContainer");
                ViewExtKt.e(loadingContainer, false, 0, 2, null);
                diffAdapter = EmergencyAssistHelpBottomSheetFragment.this.f32679w;
                DiffAdapter.V(diffAdapter, a8, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmergencyAssistUIData emergencyAssistUIData) {
                b(emergencyAssistUIData);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmergencyAssistHelpBottomSheetFragment.o0(Function1.this, obj);
            }
        });
        ((ImageView) d0(R.id.closeToolkit)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EmergencyAssistHelpBottomSheetFragment.p0(EmergencyAssistHelpBottomSheetFragment.this, view2);
            }
        });
    }
}
