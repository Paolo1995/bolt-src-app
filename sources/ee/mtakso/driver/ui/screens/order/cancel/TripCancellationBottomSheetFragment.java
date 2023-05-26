package ee.mtakso.driver.ui.screens.order.cancel;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.network.client.order.RejectReason;
import ee.mtakso.driver.network.client.order.RejectResponseType;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.order.cancel.WhyCancelError;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.CancellationDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TripCancellationBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public final class TripCancellationBottomSheetFragment extends BaseMvvmBottomSheetDialogFragment<TripCancellationViewModel> {

    /* renamed from: x  reason: collision with root package name */
    public static final Companion f31228x = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f31229r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f31230s;

    /* renamed from: t  reason: collision with root package name */
    private final DiffAdapter f31231t;

    /* renamed from: u  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f31232u;

    /* renamed from: v  reason: collision with root package name */
    private final TripCancellationBottomSheetFragment$cancelDialogCallback$1 f31233v;

    /* renamed from: w  reason: collision with root package name */
    public Map<Integer, View> f31234w = new LinkedHashMap();

    /* compiled from: TripCancellationBottomSheetFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(OrderHandle orderHandle) {
            Intrinsics.f(orderHandle, "orderHandle");
            return OrderHandleKt.d(orderHandle);
        }

        public final Bundle b(ArrayList<RejectReason> list) {
            Intrinsics.f(list, "list");
            return BundleKt.a(TuplesKt.a("arg_reasons_list", list));
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$cancelDialogCallback$1] */
    @Inject
    public TripCancellationBottomSheetFragment() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<List<? extends RejectReason>>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$reasonList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends RejectReason> invoke() {
                List<? extends RejectReason> k8;
                ArrayList parcelableArrayList = TripCancellationBottomSheetFragment.this.requireArguments().getParcelableArrayList("arg_reasons_list");
                if (parcelableArrayList == null) {
                    k8 = CollectionsKt__CollectionsKt.k();
                    return k8;
                }
                return parcelableArrayList;
            }
        });
        this.f31229r = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<OrderHandle>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$orderHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OrderHandle invoke() {
                Bundle requireArguments = TripCancellationBottomSheetFragment.this.requireArguments();
                Intrinsics.e(requireArguments, "requireArguments()");
                return OrderHandleKt.b(requireArguments);
            }
        });
        this.f31230s = b9;
        this.f31231t = new DiffAdapter().P(new ItemOneLineDelegate(new TripCancellationBottomSheetFragment$adapter$1(this)));
        this.f31232u = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$errorDialogListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                if (Intrinsics.a("dismiss", obj)) {
                    TripCancellationBottomSheetFragment.this.dismissAllowingStateLoss();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f31233v = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$cancelDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "negative")) {
                    TripCancellationBottomSheetFragment.this.dismissAllowingStateLoss();
                }
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
                if (event == DialogLifecycleEvent.CANCELLED) {
                    TripCancellationBottomSheetFragment.this.dismissAllowingStateLoss();
                }
            }
        };
    }

    private final String g0(long j8) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String string = getString(R.string.contact_and_wait);
        Intrinsics.e(string, "getString(R.string.contact_and_wait)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf((int) (j8 / 60))}, 1));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final OrderHandle h0() {
        return (OrderHandle) this.f31230s.getValue();
    }

    private final List<RejectReason> i0() {
        return (List) this.f31229r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(RejectReason rejectReason) {
        P().a0(rejectReason.b());
    }

    private final List<ListModel> l0(List<RejectReason> list) {
        int v7;
        int m8;
        DividerModel divider;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : list) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            RejectReason rejectReason = (RejectReason) obj;
            String str = rejectReason.a() + " " + rejectReason.b();
            Text.Value value = new Text.Value(rejectReason.a());
            Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
            m8 = CollectionsKt__CollectionsKt.m(list);
            if (m8 == i8) {
                divider = NoDivider.f34829a;
            } else {
                divider = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), null, null, 55, null);
            }
            arrayList.add(new ItemOneLineDelegate.Model(str, null, null, value, 2132017735, attr, false, null, null, null, null, null, null, null, 0, 0, true, rejectReason, divider, 0, 589766, null));
            i8 = i9;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(TripCancellationState tripCancellationState) {
        boolean z7;
        View loadingContainer = c0(R.id.loadingContainer);
        Intrinsics.e(loadingContainer, "loadingContainer");
        List<RejectReason> h8 = tripCancellationState.h();
        if (h8 != null && !h8.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        ViewExtKt.e(loadingContainer, z7, 0, 2, null);
        DiffAdapter diffAdapter = this.f31231t;
        List<RejectReason> h9 = tripCancellationState.h();
        if (h9 == null) {
            h9 = CollectionsKt__CollectionsKt.k();
        }
        DiffAdapter.V(diffAdapter, l0(h9), null, 2, null);
        if (tripCancellationState.f()) {
            q0();
        }
        WhyCancelError e8 = tripCancellationState.e();
        if (Intrinsics.a(e8, WhyCancelError.EmptyNotAllowed.f31276a)) {
            String string = getString(R.string.comment_cannot_be_empty);
            Intrinsics.e(string, "getString(R.string.comment_cannot_be_empty)");
            s0(string);
        } else if (e8 instanceof WhyCancelError.CantCancel) {
            s0(g0(((WhyCancelError.CantCancel) e8).a()));
            dismissAllowingStateLoss();
        } else {
            Intrinsics.a(e8, WhyCancelError.None.f31277a);
        }
        if (tripCancellationState.c() == RejectResponseType.SUCCESS) {
            dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(TripCancellationBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void q0() {
        RecyclerView tripCancellationRecyclerView = (RecyclerView) c0(R.id.tripCancellationRecyclerView);
        Intrinsics.e(tripCancellationRecyclerView, "tripCancellationRecyclerView");
        tripCancellationRecyclerView.setVisibility(8);
        Group cancellationReason = (Group) c0(R.id.cancellationReason);
        Intrinsics.e(cancellationReason, "cancellationReason");
        cancellationReason.setVisibility(0);
        KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
        ConstraintLayout root = (ConstraintLayout) c0(R.id.root);
        Intrinsics.e(root, "root");
        KeyboardUtils.c(keyboardUtils, root, false, 2, null);
        ((TextInputView) c0(R.id.cancellationReasonTextInput)).requestFocus();
        ((RoundButton) c0(R.id.submitBtn)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.cancel.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TripCancellationBottomSheetFragment.r0(TripCancellationBottomSheetFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(TripCancellationBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().c0(((TextInputView) this$0.c0(R.id.cancellationReasonTextInput)).getText());
        this$0.P().V();
    }

    private final void s0(String str) {
        Toast.makeText(getContext(), str, 1).show();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f31234w.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return R.layout.fragment_trip_cancellation;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    public void W(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(companion.a(requireContext, error, this.f31232u), this, "error");
    }

    public View c0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31234w;
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
    /* renamed from: j0 */
    public TripCancellationViewModel P() {
        return (TripCancellationViewModel) new ViewModelProvider(this, Q()).a(TripCancellationViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017806);
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "confirm_cancellation", this.f31233v);
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, getChildFragmentManager(), "error", this.f31232u, null, 8, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        P().Z();
        KeyboardUtils.f34304a.a((ConstraintLayout) c0(R.id.root));
        super.onDismiss(dialog);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.tripCancellationRecyclerView;
        ((RecyclerView) c0(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) c0(i8)).h(new ListItemDividerDecoration(Dimens.b(24.0f)));
        ((RecyclerView) c0(i8)).setAdapter(this.f31231t);
        ((ImageView) c0(R.id.cancelAction)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.cancel.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripCancellationBottomSheetFragment.n0(TripCancellationBottomSheetFragment.this, view2);
            }
        });
        MutableLiveData<TripCancellationState> T = P().T();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<TripCancellationState, Unit> function1 = new Function1<TripCancellationState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(TripCancellationState screenState) {
                TripCancellationBottomSheetFragment tripCancellationBottomSheetFragment = TripCancellationBottomSheetFragment.this;
                Intrinsics.e(screenState, "screenState");
                tripCancellationBottomSheetFragment.m0(screenState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TripCancellationState tripCancellationState) {
                b(tripCancellationState);
                return Unit.f50853a;
            }
        };
        T.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.cancel.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripCancellationBottomSheetFragment.o0(Function1.this, obj);
            }
        });
        LiveEvent<CharSequence> S = P().S();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<CharSequence, Unit> function12 = new Function1<CharSequence, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CharSequence confirmationHtml) {
                TripCancellationBottomSheetFragment$cancelDialogCallback$1 tripCancellationBottomSheetFragment$cancelDialogCallback$1;
                CancellationDialog.Companion companion = CancellationDialog.f41073m;
                String string = TripCancellationBottomSheetFragment.this.getString(R.string.cancel_warning_title);
                Intrinsics.e(string, "getString(R.string.cancel_warning_title)");
                Intrinsics.e(confirmationHtml, "confirmationHtml");
                String string2 = TripCancellationBottomSheetFragment.this.getString(R.string.cancel_order_warning_confirm);
                Intrinsics.e(string2, "getString(R.string.cancel_order_warning_confirm)");
                String string3 = TripCancellationBottomSheetFragment.this.getString(R.string.cancel_order_warning_dont_cancel);
                Intrinsics.e(string3, "getString(R.string.cance…rder_warning_dont_cancel)");
                tripCancellationBottomSheetFragment$cancelDialogCallback$1 = TripCancellationBottomSheetFragment.this.f31233v;
                FragmentUtils.b(companion.a(string, confirmationHtml, string2, string3, tripCancellationBottomSheetFragment$cancelDialogCallback$1), TripCancellationBottomSheetFragment.this, "confirm_cancellation");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                b(charSequence);
                return Unit.f50853a;
            }
        };
        S.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.cancel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripCancellationBottomSheetFragment.p0(Function1.this, obj);
            }
        });
        OrderHandle h02 = h0();
        if (h02 == null) {
            P().P(i0());
        } else {
            P().L(h02);
        }
    }
}
