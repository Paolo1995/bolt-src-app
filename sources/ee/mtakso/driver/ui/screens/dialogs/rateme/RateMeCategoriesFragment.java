package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.interactor.rateme.RateMeCategory;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeCategoriesFragment.kt */
/* loaded from: classes3.dex */
public final class RateMeCategoriesFragment extends BazeMvvmFragment<RateMeCategoryViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final HtmlEngine f28330o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f28331p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f28332q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f28333r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RateMeCategoriesFragment(BaseUiDependencies deps, HtmlEngine htmlEngine) {
        super(deps, R.layout.dialog_rate_action_categories, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f28333r = new LinkedHashMap();
        this.f28330o = htmlEngine;
        this.f28331p = new DiffAdapter().P(new TwoLinesItemDelegate(new RateMeCategoriesFragment$diffAdapter$1(this), null, 0, null, 14, null)).P(new ItemHeaderDelegate());
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoriesFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = RateMeCategoriesFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f28332q = b8;
    }

    private final void W() {
        FragmentActivity requireActivity = requireActivity();
        requireActivity.setResult(-1);
        requireActivity.finish();
    }

    private final Navigator X() {
        return (Navigator) this.f28332q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(TwoLinesItemDelegate.Model<RateMeCategory> model) {
        M().H(model.B());
        Navigator X = X();
        if (X != null) {
            Navigator.DefaultImpls.b(X, RateMeReasonsFragment.class, null, false, 6, null);
        }
    }

    private final List<ListModel> Z(List<RateMeCategory> list) {
        int v7;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : list) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            RateMeCategory rateMeCategory = (RateMeCategory) obj;
            boolean z7 = true;
            if (i8 != list.size() - 1) {
                z7 = false;
            }
            arrayList.add(a0(rateMeCategory, z7));
            i8 = i9;
        }
        return arrayList;
    }

    private final ListModel a0(RateMeCategory rateMeCategory, boolean z7) {
        float c8;
        String a8 = rateMeCategory.a();
        Image.Res res = new Image.Res(rateMeCategory.b());
        Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
        Image.Res res2 = new Image.Res(R.drawable.ic_chevron_right);
        Text d8 = rateMeCategory.d();
        Color.Attr attr2 = new Color.Attr(R.attr.contentPrimary);
        Color.Attr attr3 = new Color.Attr(R.attr.backPrimary);
        Color.Attr attr4 = new Color.Attr(R.attr.backPrimary);
        Color.Attr attr5 = new Color.Attr(R.attr.dynamicNeutral01);
        if (z7) {
            c8 = 0.0f;
        } else {
            c8 = Dimens.c(1.0f);
        }
        return new TwoLinesItemDelegate.Model(a8, d8, null, attr2, null, null, null, null, attr, res, null, null, res2, null, null, null, attr3, null, rateMeCategory, false, 0, 0, false, attr5, attr4, Float.valueOf(c8), false, false, false, 477818100, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(RateMeCategoriesFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Navigator X = this$0.X();
        if (X != null) {
            X.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c0(RateMeCategoriesFragment this$0, MenuItem menuItem) {
        Intrinsics.f(this$0, "this$0");
        if (menuItem.getItemId() == R.id.actionClose) {
            this$0.W();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(RateMeCategoriesFragment this$0, RateMeCategoryViewModel.RateMeCategoryScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.g0(state);
    }

    private final void f0() {
        int i8 = R.id.H9;
        ((RecyclerView) U(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i8)).setAdapter(this.f28331p);
        ((RecyclerView) U(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) U(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    private final void g0(RateMeCategoryViewModel.RateMeCategoryScreenState rateMeCategoryScreenState) {
        DiffAdapter.V(this.f28331p, Z(rateMeCategoryScreenState.c()), null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28333r.clear();
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28333r;
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
    /* renamed from: e0 */
    public RateMeCategoryViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (RateMeCategoryViewModel) new ViewModelProvider(requireActivity, E.d()).a(RateMeCategoryViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().H(null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((AppCompatTextView) U(R.id.tb)).setText(this.f28330o.a(getString(R.string.rate_me_dislike_catgories_message_accent_v2)));
        f0();
        int i8 = R.id.kc;
        ((PopupToolbar) U(i8)).setNavigationOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeCategoriesFragment.b0(RateMeCategoriesFragment.this, view2);
            }
        });
        ((PopupToolbar) U(i8)).x(R.menu.close_menu);
        ((PopupToolbar) U(i8)).setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.c
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean c02;
                c02 = RateMeCategoriesFragment.c0(RateMeCategoriesFragment.this, menuItem);
                return c02;
            }
        });
        M().G().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RateMeCategoriesFragment.d0(RateMeCategoriesFragment.this, (RateMeCategoryViewModel.RateMeCategoryScreenState) obj);
            }
        });
    }
}
