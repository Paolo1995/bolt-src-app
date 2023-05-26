package ee.mtakso.driver.ui.screens.order.lookup.orderdestination;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddressDetails;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDestinationFragment.kt */
/* loaded from: classes3.dex */
public final class OrderDestinationFragment extends BazeMvvmFragment<OrderDestinationViewModel> {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f31468q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f31469o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f31470p;

    /* compiled from: OrderDestinationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(Long l8, Long l9) {
            return BundleKt.a(TuplesKt.a("stop_id", l8), TuplesKt.a("user_id", l9));
        }

        public final OrderDestinationResult b(Intent data) {
            Intrinsics.f(data, "data");
            return (OrderDestinationResult) data.getParcelableExtra("extra_address_result");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderDestinationFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_driver_destination_search, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f31470p = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment$adapter$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: OrderDestinationFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment$adapter$2$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<ExternalSourceAddress>, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, OrderDestinationFragment.class, "handleSuggestionClick", "handleSuggestionClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<ExternalSourceAddress> model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(TwoLinesItemDelegate.Model<ExternalSourceAddress> p02) {
                    Intrinsics.f(p02, "p0");
                    ((OrderDestinationFragment) this.f50989g).Z(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                return new DiffAdapter().P(new TwoLinesItemDelegate(new AnonymousClass1(OrderDestinationFragment.this), new Function1<TwoLinesItemDelegate.Model<ExternalSourceAddress>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment$adapter$2.2
                    public final void b(TwoLinesItemDelegate.Model<ExternalSourceAddress> it) {
                        Intrinsics.f(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<ExternalSourceAddress> model) {
                        b(model);
                        return Unit.f50853a;
                    }
                }, 0, null, 12, null));
            }
        });
        this.f31469o = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiffAdapter Y() {
        return (DiffAdapter) this.f31469o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(TwoLinesItemDelegate.Model<ExternalSourceAddress> model) {
        ExternalSourceAddress B = model.B();
        if (B != null) {
            M().M(B);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(OrderDestinationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        KeyboardUtils.f34304a.a(((TextInputLayout) this$0.U(R.id.searchBar)).getEditText());
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31470p.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        CircularProgressIndicator loadingView = (CircularProgressIndicator) U(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        loadingView.setVisibility(8);
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
        FragmentUtils.c(c8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        CircularProgressIndicator loadingView = (CircularProgressIndicator) U(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        loadingView.setVisibility(0);
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31470p;
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
    /* renamed from: d0 */
    public OrderDestinationViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (OrderDestinationViewModel) new ViewModelProvider(this, E.d()).a(OrderDestinationViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Long l8;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        OrderDestinationViewModel M = M();
        Bundle arguments = getArguments();
        if (arguments != null) {
            l8 = Long.valueOf(arguments.getLong("user_id"));
        } else {
            l8 = null;
        }
        M.S(l8);
        int i8 = R.id.searchBar;
        EditText editText = ((TextInputLayout) U(i8)).getEditText();
        if (editText != null) {
            KeyboardUtils.c(KeyboardUtils.f34304a, editText, false, 2, null);
        }
        EditText editText2 = ((TextInputLayout) U(i8)).getEditText();
        if (editText2 != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment$onViewCreated$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    OrderDestinationViewModel M2;
                    M2 = OrderDestinationFragment.this.M();
                    M2.R(String.valueOf(editable));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                }
            });
        }
        ((TextInputLayout) U(i8)).setPlaceholderText(getString(R.string.enter_address_hint));
        ((TextInputLayout) U(i8)).setStartIconOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderDestinationFragment.a0(OrderDestinationFragment.this, view2);
            }
        });
        int i9 = R.id.recyclerViewSuggestions;
        ((RecyclerView) U(i9)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i9)).setAdapter(Y());
        ((RecyclerView) U(i9)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ObservableLiveData<OrderDestinationState> L = M().L();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<OrderDestinationState, Unit> function1 = new Function1<OrderDestinationState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderDestinationState orderDestinationState) {
                DiffAdapter Y;
                Y = OrderDestinationFragment.this.Y();
                DiffAdapter.V(Y, orderDestinationState.a(), null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderDestinationState orderDestinationState) {
                b(orderDestinationState);
                return Unit.f50853a;
            }
        };
        L.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderDestinationFragment.b0(Function1.this, obj);
            }
        });
        LiveData<ExternalSourceAddressDetails> K = M().K();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ExternalSourceAddressDetails, Unit> function12 = new Function1<ExternalSourceAddressDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalSourceAddressDetails externalSourceAddressDetails) {
                Long l9;
                KeyboardUtils.f34304a.a(((TextInputLayout) OrderDestinationFragment.this.U(R.id.searchBar)).getEditText());
                Bundle arguments2 = OrderDestinationFragment.this.getArguments();
                if (arguments2 != null) {
                    l9 = Long.valueOf(arguments2.getLong("stop_id"));
                } else {
                    l9 = null;
                }
                Intent putExtra = new Intent().putExtra("extra_address_result", new OrderDestinationResult(l9, externalSourceAddressDetails.a(), externalSourceAddressDetails.b(), externalSourceAddressDetails.c()));
                Intrinsics.e(putExtra, "Intent().putExtra(EXTRA_…, orderDestinationResult)");
                FragmentActivity requireActivity = OrderDestinationFragment.this.requireActivity();
                requireActivity.setResult(-1, putExtra);
                requireActivity.finish();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalSourceAddressDetails externalSourceAddressDetails) {
                b(externalSourceAddressDetails);
                return Unit.f50853a;
            }
        };
        K.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderDestinationFragment.c0(Function1.this, obj);
            }
        });
    }
}
