package ee.mtakso.driver.ui.screens.earnings.v2.payout.request;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.common.mapping.FlatGenericSectionsMapper;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel;
import ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SimpleTextDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.StringUtilsKt;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutRequestFragment.kt */
/* loaded from: classes3.dex */
public final class PayoutRequestFragment extends BazeMvvmFragment<PayoutRequestViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f28731t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final FlatGenericSectionsMapper f28732o;

    /* renamed from: p  reason: collision with root package name */
    private MenuItem f28733p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f28734q;

    /* renamed from: r  reason: collision with root package name */
    private final DiffAdapter f28735r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f28736s;

    /* compiled from: PayoutRequestFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            return SimpleActivity.Companion.b(SimpleActivity.f27004l, PayoutRequestFragment.class, null, false, 0, 14, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PayoutRequestFragment(BaseUiDependencies deps, FlatGenericSectionsMapper genericSectionsMapper) {
        super(deps, R.layout.fragment_payout_request, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(genericSectionsMapper, "genericSectionsMapper");
        this.f28736s = new LinkedHashMap();
        this.f28732o = genericSectionsMapper;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = PayoutRequestFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f28734q = b8;
        this.f28735r = new DiffAdapter().P(new GenericTitleDelegate()).P(new GenericItemDelegate(new Function1<GenericItemDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment$diffAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GenericItemDelegate.Model it) {
                Intrinsics.f(it, "it");
                PayoutRequestFragment.this.k0(it.p());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GenericItemDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        }, new PayoutRequestFragment$diffAdapter$2(this))).P(new SimpleTextDelegate(null, 1, null));
    }

    private final ListModel Y(String str) {
        Text.Value value;
        CharSequence a8 = StringUtilsKt.a(str);
        if (a8 != null) {
            value = new Text.Value(a8);
        } else {
            value = null;
        }
        Color.Res res = new Color.Res(R.color.neutral500);
        return new SimpleTextDelegate.Model(null, value, new Color.Res(R.color.transparent), Dimens.d(24), Dimens.d(24), Dimens.d(16), Dimens.d(16), Dimens.c(12.0f), null, res, false, null, 3329, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator a0() {
        return (Navigator) this.f28734q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(PayoutRequestViewModel.Config config) {
        M().S();
        Z(config);
    }

    private final void c0(PayoutRequestViewModel.EventResult eventResult) {
        if (eventResult instanceof PayoutRequestViewModel.EventResult.Success) {
            l0((PayoutRequestViewModel.EventResult.Success) eventResult);
        } else if (eventResult instanceof PayoutRequestViewModel.EventResult.Error) {
            i0((PayoutRequestViewModel.EventResult.Error) eventResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PayoutRequestFragment this$0, PayoutRequestViewModel.EventResult event) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(event, "event");
        this$0.c0(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(PayoutRequestFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().L();
    }

    private final void h0() {
        SimpleItemAnimator simpleItemAnimator;
        RecyclerView recyclerView = (RecyclerView) U(R.id.H9);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f28735r);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    private final void i0(PayoutRequestViewModel.EventResult.Error error) {
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog a8 = companion.a(requireContext, error.a(), new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment$showErrorAndClose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Navigator a02;
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                a02 = PayoutRequestFragment.this.a0();
                if (a02 != null) {
                    a02.c();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        });
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(a8, requireActivity, "TAG_ERROR_DIALOG");
    }

    private final void j0() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(GenericItemDelegate.PopupInfo popupInfo) {
        if (popupInfo == null) {
            return;
        }
        InfoCopyDialog a8 = InfoCopyDialog.f28299n.a(popupInfo.e(), popupInfo.d(), popupInfo.a(), popupInfo.b());
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(a8, requireActivity, "TAG_VALUE_DIALOG");
        M().T();
    }

    private final void l0(PayoutRequestViewModel.EventResult.Success success) {
        Navigator a02 = a0();
        if (a02 != null) {
            OperationResultFragment.Companion companion = OperationResultFragment.f30958p;
            String b8 = success.b();
            String str = "";
            if (b8 == null) {
                b8 = "";
            }
            String a8 = success.a();
            if (a8 != null) {
                str = a8;
            }
            String string = getString(R.string.close);
            Intrinsics.e(string, "getString(R.string.close)");
            a02.d(OperationResultFragment.class, OperationResultFragment.Companion.b(companion, new OperationResultFragment.Config(R.drawable.ic_progress_big, b8, str, new OperationResultFragment.ButtonModel(string, null, 2, null)), null, 2, null), false);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28736s.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        ((RoundButton) U(R.id.confirmButton)).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "TAG_ERROR_DIALOG");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        ((RoundButton) U(R.id.confirmButton)).k();
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28736s;
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

    public final void Z(PayoutRequestViewModel.Config config) {
        boolean z7;
        ListModel listModel;
        List o8;
        List n02;
        Intrinsics.f(config, "config");
        int i8 = R.id.infoText;
        AppCompatTextView infoText = (AppCompatTextView) U(i8);
        Intrinsics.e(infoText, "infoText");
        String c8 = config.c();
        if (c8 != null && c8.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        ViewExtKt.e(infoText, !z7, 0, 2, null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) U(i8);
        String c9 = config.c();
        appCompatTextView.setText((c9 == null || (r1 = StringUtilsKt.a(c9)) == null) ? "" : "");
        List<ListModel> c10 = this.f28732o.c(config.d());
        String a8 = config.a();
        if (a8 != null) {
            listModel = Y(a8);
        } else {
            listModel = null;
        }
        DiffAdapter diffAdapter = this.f28735r;
        o8 = CollectionsKt__CollectionsKt.o(listModel);
        n02 = CollectionsKt___CollectionsKt.n0(c10, o8);
        DiffAdapter.V(diffAdapter, n02, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: g0 */
    public PayoutRequestViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PayoutRequestViewModel) new ViewModelProvider(this, E.d()).a(PayoutRequestViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.f(menu, "menu");
        Intrinsics.f(menuInflater, "menuInflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.payout_history_view_menu, menu);
        MenuItem findItem = menu.findItem(R.id.actionHelp);
        this.f28733p = findItem;
        if (findItem != null) {
            findItem.setVisible(false);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.actionHelp) {
                return false;
            }
            j0();
            return true;
        }
        Navigator a02 = a0();
        if (a02 == null) {
            return true;
        }
        a02.c();
        return true;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator a02 = a0();
        if (a02 != null) {
            a02.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.early_cahout, null, 2, null), true, null, null, null, null, null, null, 505, null));
        }
        h0();
        M().P().i(getViewLifecycleOwner(), new Observer() { // from class: r3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutRequestFragment.d0(PayoutRequestFragment.this, (PayoutRequestViewModel.EventResult) obj);
            }
        });
        LiveData<PayoutRequestViewModel.Config> O = M().O();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<PayoutRequestViewModel.Config, Unit> function1 = new Function1<PayoutRequestViewModel.Config, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PayoutRequestViewModel.Config config) {
                PayoutRequestFragment payoutRequestFragment = PayoutRequestFragment.this;
                Intrinsics.e(config, "config");
                payoutRequestFragment.b0(config);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayoutRequestViewModel.Config config) {
                b(config);
                return Unit.f50853a;
            }
        };
        O.i(viewLifecycleOwner, new Observer() { // from class: r3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutRequestFragment.e0(Function1.this, obj);
            }
        });
        ((RoundButton) U(R.id.confirmButton)).setOnClickListener(new View.OnClickListener() { // from class: r3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayoutRequestFragment.f0(PayoutRequestFragment.this, view2);
            }
        });
    }
}
