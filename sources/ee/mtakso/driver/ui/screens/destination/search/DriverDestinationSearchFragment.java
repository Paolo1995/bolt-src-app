package ee.mtakso.driver.ui.screens.destination.search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
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
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import eu.bolt.driver.core.ui.common.activity.NoToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverDestinationSearchFragment.kt */
/* loaded from: classes3.dex */
public final class DriverDestinationSearchFragment extends BazeMvvmFragment<DriverDestinationSearchViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f28206s = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f28207o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f28208p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f28209q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f28210r;

    /* compiled from: DriverDestinationSearchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(DriverDestination destination) {
            Intrinsics.f(destination, "destination");
            Bundle bundle = new Bundle();
            bundle.putParcelable("driverDestination", destination);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverDestinationSearchFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_driver_destination_search, null, 4, null);
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Intrinsics.f(deps, "deps");
        this.f28210r = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = DriverDestinationSearchFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f28207o = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$adapter$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DriverDestinationSearchFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$adapter$2$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<ExternalSourceAddress>, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, DriverDestinationSearchFragment.class, "handleSuggestionClick", "handleSuggestionClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<ExternalSourceAddress> model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(TwoLinesItemDelegate.Model<ExternalSourceAddress> p02) {
                    Intrinsics.f(p02, "p0");
                    ((DriverDestinationSearchFragment) this.f50989g).d0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                return new DiffAdapter().P(new TwoLinesItemDelegate(new AnonymousClass1(DriverDestinationSearchFragment.this), new Function1<TwoLinesItemDelegate.Model<ExternalSourceAddress>, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$adapter$2.2
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
        this.f28208p = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<DriverDestination>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$driverDestination$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DriverDestination invoke() {
                return (DriverDestination) DriverDestinationSearchFragment.this.requireArguments().getParcelable("driverDestination");
            }
        });
        this.f28209q = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiffAdapter a0() {
        return (DiffAdapter) this.f28208p.getValue();
    }

    private final DriverDestination b0() {
        return (DriverDestination) this.f28209q.getValue();
    }

    private final Navigator c0() {
        return (Navigator) this.f28207o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(TwoLinesItemDelegate.Model<ExternalSourceAddress> model) {
        if (b0() != null && model.B() != null) {
            DriverDestination b02 = b0();
            Intrinsics.c(b02);
            ExternalSourceAddress B = model.B();
            Intrinsics.c(B);
            M().T(new Pair<>(b02, B));
            return;
        }
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DriverDestinationSearchFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(final DriverDestinationSearchFragment this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        final Lifecycle.State state = Lifecycle.State.RESUMED;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$onViewCreated$lambda$6$$inlined$doAtState$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.f(source, "source");
                Intrinsics.f(event, "event");
                if (LifecycleOwner.this.getLifecycle().b().a(state)) {
                    FragmentActivity activity = this$0.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                    LifecycleOwner.this.getLifecycle().c(this);
                }
            }
        };
        if (this$0.getLifecycle().b().a(state)) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this$0.getLifecycle().a(lifecycleEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        KeyboardUtils.f34304a.a(((TextInputLayout) V(R.id.searchBar)).getEditText());
        Navigator c02 = c0();
        if (c02 != null) {
            c02.c();
        }
    }

    private final void k0() {
        String str;
        DriverDestination b02 = b0();
        String str2 = null;
        if (b02 != null) {
            str = b02.f();
        } else {
            str = null;
        }
        int i8 = R.string.set_destination;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1081415738) {
                if (hashCode != 3208415) {
                    if (hashCode == 1050790300 && str.equals("favorite")) {
                        EditText editText = ((TextInputLayout) V(R.id.searchBar)).getEditText();
                        if (editText != null) {
                            DriverDestination b03 = b0();
                            if (b03 != null) {
                                str2 = b03.a();
                            }
                            editText.setText(str2);
                        }
                        i8 = R.string.enter_favourite_address;
                    }
                } else if (str.equals("home")) {
                    EditText editText2 = ((TextInputLayout) V(R.id.searchBar)).getEditText();
                    if (editText2 != null) {
                        DriverDestination b04 = b0();
                        if (b04 != null) {
                            str2 = b04.a();
                        }
                        editText2.setText(str2);
                    }
                    i8 = R.string.enter_home_address;
                }
            } else {
                str.equals("manual");
            }
        }
        ((TextInputLayout) V(R.id.searchBar)).setPlaceholderText(getString(i8));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28210r.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        CircularProgressIndicator loadingView = (CircularProgressIndicator) V(R.id.V6);
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
        CircularProgressIndicator loadingView = (CircularProgressIndicator) V(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        loadingView.setVisibility(0);
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28210r;
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
    /* renamed from: j0 */
    public DriverDestinationSearchViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (DriverDestinationSearchViewModel) new ViewModelProvider(this, E.d()).a(DriverDestinationSearchViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) V(R.id.recyclerViewSuggestions)).setAdapter(null);
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.searchBar;
        EditText editText = ((TextInputLayout) V(i8)).getEditText();
        if (editText != null) {
            KeyboardUtils.c(KeyboardUtils.f34304a, editText, false, 2, null);
        }
        Navigator c02 = c0();
        if (c02 != null) {
            c02.x(new NoToolbarAppearance());
        }
        EditText editText2 = ((TextInputLayout) V(i8)).getEditText();
        if (editText2 != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$onViewCreated$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    DriverDestinationSearchViewModel M;
                    M = DriverDestinationSearchFragment.this.M();
                    M.U(String.valueOf(editable));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                }
            });
        }
        k0();
        ((TextInputLayout) V(i8)).setStartIconOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.destination.search.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DriverDestinationSearchFragment.e0(DriverDestinationSearchFragment.this, view2);
            }
        });
        int i9 = R.id.recyclerViewSuggestions;
        ((RecyclerView) V(i9)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) V(i9)).setAdapter(a0());
        ((RecyclerView) V(i9)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ObservableLiveData<SearchSuggestionState> S = M().S();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<SearchSuggestionState, Unit> function1 = new Function1<SearchSuggestionState, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SearchSuggestionState searchSuggestionState) {
                DiffAdapter a02;
                a02 = DriverDestinationSearchFragment.this.a0();
                DiffAdapter.V(a02, searchSuggestionState.a(), null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchSuggestionState searchSuggestionState) {
                b(searchSuggestionState);
                return Unit.f50853a;
            }
        };
        S.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.destination.search.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverDestinationSearchFragment.f0(Function1.this, obj);
            }
        });
        LiveData<DriverDestination> R = M().R();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<DriverDestination, Unit> function12 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestination it) {
                DriverDestinationSearchViewModel M;
                if (Intrinsics.a(it.f(), "manual")) {
                    M = DriverDestinationSearchFragment.this.M();
                    Intrinsics.e(it, "it");
                    M.M(it);
                    return;
                }
                DriverDestinationSearchFragment.this.i0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                b(driverDestination);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.destination.search.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverDestinationSearchFragment.g0(Function1.this, obj);
            }
        });
        M().Q().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.destination.search.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverDestinationSearchFragment.h0(DriverDestinationSearchFragment.this, obj);
            }
        });
    }
}
