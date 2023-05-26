package ee.mtakso.driver.ui.screens.order.scheduled;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.network.client.order.modal.ModalWithList;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderLinkDelegate;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.common.dialog.ActionDialog;
import eu.bolt.driver.core.ui.common.dialog.CancellationDialog;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsFragment extends BazeMvvmFragment<ScheduledOrderDetailsViewModel> {

    /* renamed from: y  reason: collision with root package name */
    public static final Companion f31679y = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final CompositeUrlLauncher f31680o;

    /* renamed from: p  reason: collision with root package name */
    private final FragmentFactory f31681p;

    /* renamed from: q  reason: collision with root package name */
    private final ScheduledOrderButtonAppearanceMapper f31682q;

    /* renamed from: r  reason: collision with root package name */
    private final HtmlEngine f31683r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f31684s;

    /* renamed from: t  reason: collision with root package name */
    private final DiffAdapter f31685t;

    /* renamed from: u  reason: collision with root package name */
    private final ScheduledOrderDetailsFragment$confirmActionCallback$1 f31686u;

    /* renamed from: v  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f31687v;

    /* renamed from: w  reason: collision with root package name */
    private final int f31688w;

    /* renamed from: x  reason: collision with root package name */
    public Map<Integer, View> f31689x;

    /* compiled from: ScheduledOrderDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(OrderHandle orderHandle) {
            Intrinsics.f(orderHandle, "orderHandle");
            Bundle bundle = new Bundle();
            OrderHandleKt.e(orderHandle, bundle);
            return bundle;
        }
    }

    /* compiled from: ScheduledOrderDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31690a;

        static {
            int[] iArr = new int[ScheduledRideDetailsComponent.ButtonAction.values().length];
            try {
                iArr[ScheduledRideDetailsComponent.ButtonAction.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.ButtonAction.START_DRIVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.ButtonAction.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31690a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v10, types: [ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$confirmActionCallback$1] */
    @Inject
    public ScheduledOrderDetailsFragment(BaseUiDependencies deps, MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory, CompositeUrlLauncher utlLauncher, FragmentFactory fragmentFactory, ScheduledOrderButtonAppearanceMapper buttonAppearanceMapper, HtmlEngine htmlEngine) {
        super(deps, R.layout.fragment_scheduled_order_details, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(themeManager, "themeManager");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(utlLauncher, "utlLauncher");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(buttonAppearanceMapper, "buttonAppearanceMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f31689x = new LinkedHashMap();
        this.f31680o = utlLauncher;
        this.f31681p = fragmentFactory;
        this.f31682q = buttonAppearanceMapper;
        this.f31683r = htmlEngine;
        b8 = LazyKt__LazyJVMKt.b(new Function0<LoadingDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$loadingDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LoadingDialogDelegate invoke() {
                FragmentActivity requireActivity = ScheduledOrderDetailsFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                return new LoadingDialogDelegate(requireActivity);
            }
        });
        this.f31684s = b8;
        this.f31685t = new DiffAdapter().P(new ScheduledOrderHeaderDelegate(mapProvider, themeManager, markerParamsFactory)).P(new TwoLinesItemDelegate(new Function1<TwoLinesItemDelegate.Model<ScheduledRideDetailsComponent.ListItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$adapter$1
            public final void b(TwoLinesItemDelegate.Model<ScheduledRideDetailsComponent.ListItem> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<ScheduledRideDetailsComponent.ListItem> model) {
                b(model);
                return Unit.f50853a;
            }
        }, new Function1<TwoLinesItemDelegate.Model<ScheduledRideDetailsComponent.ListItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$adapter$2
            public final void b(TwoLinesItemDelegate.Model<ScheduledRideDetailsComponent.ListItem> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<ScheduledRideDetailsComponent.ListItem> model) {
                b(model);
                return Unit.f50853a;
            }
        }, 0, null, 12, null)).P(new DividerDelegate()).P(new ScheduledOrderTextDelegate()).P(new ScheduledOrderLinkDelegate(new ScheduledOrderDetailsFragment$adapter$3(this))).P(new ButtonItemDelegate(new ScheduledOrderDetailsFragment$adapter$4(this)));
        this.f31686u = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$confirmActionCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                String tag;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "positive") && (tag = dialog.getTag()) != null) {
                    int hashCode = tag.hashCode();
                    if (hashCode != -1631367765) {
                        if (hashCode != -790533834) {
                            if (hashCode == 1318847522 && tag.equals("confirm_cancellation")) {
                                ScheduledOrderDetailsFragment.this.k0(ScheduledRideDetailsComponent.ButtonAction.CANCEL);
                            }
                        } else if (tag.equals("confirm_acceptance")) {
                            ScheduledOrderDetailsFragment.this.k0(ScheduledRideDetailsComponent.ButtonAction.ACCEPT);
                        }
                    } else if (tag.equals("confirm_start_driving")) {
                        ScheduledOrderDetailsFragment.this.k0(ScheduledRideDetailsComponent.ButtonAction.START_DRIVING);
                    }
                }
            }
        };
        this.f31687v = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$errorDialogListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Navigator c02;
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                if (Intrinsics.a("dismiss", obj)) {
                    c02 = ScheduledOrderDetailsFragment.this.c0();
                    c02.c();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f31688w = 2132017818;
    }

    private final LoadingDialogDelegate b0() {
        return (LoadingDialogDelegate) this.f31684s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator c0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final OrderHandle d0() {
        Bundle requireArguments = requireArguments();
        Intrinsics.e(requireArguments, "requireArguments()");
        return OrderHandleKt.a(requireArguments);
    }

    private final void e0(ScheduledRideDetailsComponent.Button button) {
        ScheduledRideDetailsComponent.ConfirmationDialog confirmationDialog;
        ScheduledRideDetailsComponent.ButtonAction buttonAction = null;
        if (button != null) {
            confirmationDialog = button.c();
        } else {
            confirmationDialog = null;
        }
        if (confirmationDialog != null) {
            int i8 = WhenMappings.f31690a[button.a().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        String str = "Unsupported action type: " + button.a();
                        Kalev.m(new IllegalArgumentException(str), str);
                        return;
                    }
                    CancellationDialog.Companion companion = CancellationDialog.f41073m;
                    String b8 = button.c().b();
                    if (b8 == null) {
                        b8 = "";
                    }
                    CharSequence a8 = this.f31683r.a(button.c().a());
                    String string = getString(R.string.confirm_lowercase);
                    Intrinsics.e(string, "getString(R.string.confirm_lowercase)");
                    String string2 = getString(R.string.action_cancel);
                    Intrinsics.e(string2, "getString(R.string.action_cancel)");
                    FragmentUtils.b(companion.a(b8, a8, string, string2, this.f31686u), this, "confirm_cancellation");
                    return;
                }
                o0(button.c(), "confirm_start_driving");
                return;
            }
            o0(button.c(), "confirm_acceptance");
            return;
        }
        if (button != null) {
            buttonAction = button.a();
        }
        k0(buttonAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(ButtonItemDelegate.Model<ScheduledRideDetailsComponent.Button> model) {
        e0(model.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(ScheduledOrderLinkDelegate.Model model) {
        this.f31680o.a(model.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ScheduledOrderDetailsFragment this$0, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        int max = Math.max(((ConstraintLayout) this$0.V(R.id.actionContainer)).getHeight(), Dimens.d(16));
        int i16 = R.id.H9;
        if (((RecyclerView) this$0.V(i16)).getPaddingBottom() != max) {
            RecyclerView recyclerView = (RecyclerView) this$0.V(i16);
            Intrinsics.e(recyclerView, "recyclerView");
            recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), max);
        }
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
    public final void k0(ScheduledRideDetailsComponent.ButtonAction buttonAction) {
        int i8;
        if (buttonAction == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f31690a[buttonAction.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    String str = "Unsupported action type: " + buttonAction;
                    Kalev.m(new IllegalArgumentException(str), str);
                    return;
                }
                p0();
                return;
            }
            M().S(d0());
            return;
        }
        M().H(d0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(final ScheduledOrderDetailsState scheduledOrderDetailsState) {
        boolean z7;
        ScheduledRideDetailsComponent.ButtonAppearance b8;
        c0().x(new PopupToolbarAppearance(0, scheduledOrderDetailsState.c(), false, null, null, null, null, null, null, 509, null));
        String str = null;
        DiffAdapter.V(this.f31685t, scheduledOrderDetailsState.b(), null, 2, null);
        ConstraintLayout actionContainer = (ConstraintLayout) V(R.id.actionContainer);
        Intrinsics.e(actionContainer, "actionContainer");
        if (scheduledOrderDetailsState.a() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(actionContainer, z7, 0, 2, null);
        int i8 = R.id.actionButton;
        RoundButton roundButton = (RoundButton) V(i8);
        ScheduledRideDetailsComponent.Button a8 = scheduledOrderDetailsState.a();
        if (a8 != null) {
            str = a8.d();
        }
        roundButton.setText(str);
        ScheduledRideDetailsComponent.Button a9 = scheduledOrderDetailsState.a();
        if (a9 != null && (b8 = a9.b()) != null) {
            RoundButton actionButton = (RoundButton) V(i8);
            Intrinsics.e(actionButton, "actionButton");
            UiKitRoundButtonTypeKt.b(actionButton, this.f31682q.a(b8));
        }
        ((RoundButton) V(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduledOrderDetailsFragment.n0(ScheduledOrderDetailsFragment.this, scheduledOrderDetailsState, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(ScheduledOrderDetailsFragment this$0, ScheduledOrderDetailsState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.e0(state.a());
    }

    private final void o0(ScheduledRideDetailsComponent.ConfirmationDialog confirmationDialog, String str) {
        ActionDialog.Companion companion = ActionDialog.f41071m;
        String b8 = confirmationDialog.b();
        if (b8 == null) {
            b8 = "";
        }
        CharSequence a8 = this.f31683r.a(confirmationDialog.a());
        String string = getString(R.string.confirm_lowercase);
        Intrinsics.e(string, "getString(R.string.confirm_lowercase)");
        String string2 = getString(R.string.action_cancel);
        Intrinsics.e(string2, "getString(R.string.action_cancel)");
        FragmentUtils.b(companion.a(b8, a8, string, string2, this.f31686u), this, str);
    }

    private final void p0() {
        FragmentFactory fragmentFactory = this.f31681p;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b((TripCancellationBottomSheetFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, TripCancellationBottomSheetFragment.class, TripCancellationBottomSheetFragment.f31228x.a(d0())), this, "cancellation");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31689x.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f31688w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        b0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(companion.a(requireContext, error, this.f31687v), this, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        b0().b();
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31689x;
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
    /* renamed from: l0 */
    public ScheduledOrderDetailsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (ScheduledOrderDetailsViewModel) new ViewModelProvider(this, E.d()).a(ScheduledOrderDetailsViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseDialogFragment.Companion companion = BaseDialogFragment.f41026i;
        companion.a(getChildFragmentManager(), "confirm_acceptance", this.f31686u);
        companion.a(getChildFragmentManager(), "confirm_cancellation", this.f31686u);
        companion.a(getChildFragmentManager(), "confirm_start_driving", this.f31686u);
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, getChildFragmentManager(), "error", this.f31687v, null, 8, null);
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
        c0().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.request, null, 2, null), false, null, null, null, null, null, null, 509, null));
        int i8 = R.id.H9;
        ((RecyclerView) V(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) V(i8)).setAdapter(this.f31685t);
        ((RecyclerView) V(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        int i9 = R.id.actionContainer;
        ((ConstraintLayout) V(i9)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ScheduledOrderDetailsFragment.h0(ScheduledOrderDetailsFragment.this, view2, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        ConstraintLayout actionContainer = (ConstraintLayout) V(i9);
        Intrinsics.e(actionContainer, "actionContainer");
        ViewExtKt.d(actionContainer, false, 0, 2, null);
        LiveData<ScheduledOrderDetailsState> R = M().R();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ScheduledOrderDetailsState, Unit> function1 = new Function1<ScheduledOrderDetailsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ScheduledOrderDetailsState state) {
                ScheduledOrderDetailsFragment scheduledOrderDetailsFragment = ScheduledOrderDetailsFragment.this;
                Intrinsics.e(state, "state");
                scheduledOrderDetailsFragment.m0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrderDetailsState scheduledOrderDetailsState) {
                b(scheduledOrderDetailsState);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScheduledOrderDetailsFragment.i0(Function1.this, obj);
            }
        });
        LiveData<ModalWithList> Q = M().Q();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ModalWithList, Unit> function12 = new Function1<ModalWithList, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ModalWithList accept) {
                Navigator c02;
                c02 = ScheduledOrderDetailsFragment.this.c0();
                c02.c();
                SimpleActivity.Companion companion = SimpleActivity.f27004l;
                FragmentActivity requireActivity = ScheduledOrderDetailsFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                OrderModalFragment.Companion companion2 = OrderModalFragment.f31506r;
                Intrinsics.e(accept, "accept");
                SimpleActivity.Companion.m(companion, requireActivity, OrderModalFragment.class, companion2.a(accept), false, 8, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModalWithList modalWithList) {
                b(modalWithList);
                return Unit.f50853a;
            }
        };
        Q.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScheduledOrderDetailsFragment.j0(Function1.this, obj);
            }
        });
        M().N(d0());
    }
}
