package ee.mtakso.driver.ui.screens.countypicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.country.Country;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.countrypicker.mapper.CountryCodeMapper;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment;
import ee.mtakso.driver.ui.screens.countypicker.item.CountryDividerDelegate;
import ee.mtakso.driver.ui.screens.countypicker.item.CountryItemDelegate;
import ee.mtakso.driver.ui.screens.countypicker.item.CountryLetterDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountryPickerFragment.kt */
/* loaded from: classes3.dex */
public final class CountryPickerFragment extends BazeMvvmFragment<CountryPickerViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f28112t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f28113o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f28114p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f28115q;

    /* renamed from: r  reason: collision with root package name */
    private int f28116r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f28117s;

    /* compiled from: CountryPickerFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CountryPickerFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_country_picker, 2132017818);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        this.f28117s = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = CountryPickerFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f28113o = b8;
        this.f28114p = new DiffAdapter().P(new CountryItemDelegate(new CountryPickerFragment$diffAdapter$1(this))).P(new CountryDividerDelegate()).P(new CountryLetterDelegate());
        b9 = LazyKt__LazyJVMKt.b(new Function0<LinearLayoutManager>() { // from class: ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment$layoutManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LinearLayoutManager invoke() {
                return new LinearLayoutManager(CountryPickerFragment.this.requireContext());
            }
        });
        this.f28115q = b9;
        this.f28116r = 2132017818;
    }

    private final ErrorDialogDelegate W() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new ErrorDialogDelegate(requireActivity);
    }

    private final LinearLayoutManager X() {
        return (LinearLayoutManager) this.f28115q.getValue();
    }

    private final LoadingDialogDelegate Y() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new LoadingDialogDelegate(requireActivity);
    }

    private final Navigator Z() {
        return (Navigator) this.f28113o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(CountryItemDelegate.Model model) {
        Intent putExtra = new Intent().putExtra("RESULT_EXTRA_COUNTRY", model.n());
        Intrinsics.e(putExtra, "Intent().putExtra(RESULT…A_COUNTRY, model.country)");
        FragmentActivity requireActivity = requireActivity();
        requireActivity.setResult(-1, putExtra);
        requireActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(CountryPickerFragment this$0, List state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.d0(state);
    }

    private final void d0(List<? extends Pair<? extends Country, String>> list) {
        int v7;
        List<ListModel> d8 = CountryCodeMapper.f28108a.d(list);
        ArrayList<CountryLetterDelegate.Model> arrayList = new ArrayList();
        for (Object obj : d8) {
            if (obj instanceof CountryLetterDelegate.Model) {
                arrayList.add(obj);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        final ArrayList arrayList2 = new ArrayList(v7);
        for (CountryLetterDelegate.Model model : arrayList) {
            arrayList2.add(TuplesKt.a(Integer.valueOf(d8.indexOf(model)), model));
        }
        DiffAdapter.V(this.f28114p, d8, null, 2, null);
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).u();
        ((RecyclerView) S(i8)).l(new RecyclerView.OnScrollListener() { // from class: ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment$renderState$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(RecyclerView recyclerView, int i9) {
                Intrinsics.f(recyclerView, "recyclerView");
                super.a(recyclerView, i9);
                CountryPickerFragment.this.f0(arrayList2);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView r7, int i9, int i10) {
                Intrinsics.f(r7, "r");
                CountryPickerFragment.this.f0(arrayList2);
            }
        });
    }

    private final void e0() {
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(X());
        ((RecyclerView) S(i8)).setAdapter(this.f28114p);
        ((RecyclerView) S(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(List<Pair<Integer, CountryLetterDelegate.Model>> list) {
        TextView textView;
        Pair<Integer, CountryLetterDelegate.Model> pair;
        CountryLetterDelegate.Model model;
        boolean z7;
        int k22 = X().k2();
        ListIterator<Pair<Integer, CountryLetterDelegate.Model>> listIterator = list.listIterator(list.size());
        while (true) {
            textView = null;
            if (listIterator.hasPrevious()) {
                pair = listIterator.previous();
                if (pair.d().intValue() <= k22) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                pair = null;
                break;
            }
        }
        Pair<Integer, CountryLetterDelegate.Model> pair2 = pair;
        if (pair2 != null) {
            model = pair2.e();
        } else {
            model = null;
        }
        if (model != null) {
            ((FrameLayout) S(R.id.headerTopOverlayHost)).setVisibility(0);
            View S = S(R.id.headerTopOverlay);
            if (S instanceof TextView) {
                textView = (TextView) S;
            }
            if (textView != null) {
                TextViewExtKt.h(textView, model.n());
                return;
            }
            return;
        }
        ((FrameLayout) S(R.id.headerTopOverlayHost)).setVisibility(4);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28117s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f28116r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        Y().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        W().a(error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        Y().b();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28117s;
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
    /* renamed from: c0 */
    public CountryPickerViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (CountryPickerViewModel) new ViewModelProvider(this, E.d()).a(CountryPickerViewModel.class);
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
        e0();
        Navigator Z = Z();
        if (Z != null) {
            Z.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.country_code, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
        M().D().i(getViewLifecycleOwner(), new Observer() { // from class: f3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CountryPickerFragment.b0(CountryPickerFragment.this, (List) obj);
            }
        });
        int i8 = R.id.Ga;
        ((TextInputView) S(i8)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String text) {
                CountryPickerViewModel M;
                Intrinsics.f(text, "text");
                M = CountryPickerFragment.this.M();
                M.F(text.toString());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((TextInputView) S(i8)).setStartDrawableWithIntrinsicBounds(R.drawable.ic_search_grey);
        ((TextInputView) S(i8)).setCompoundDrawablePadding(Dimens.d(8));
    }
}
