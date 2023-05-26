package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.interactor.rateme.RateMeItem;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeReasonsFragment.kt */
/* loaded from: classes3.dex */
public final class RateMeReasonsFragment extends BazeMvvmFragment<RateMeCategoryViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f28386o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f28387p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f28388q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RateMeReasonsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.dialog_rate_action_items, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f28388q = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = RateMeReasonsFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f28386o = b8;
        this.f28387p = new DiffAdapter().P(new TwoLinesItemDelegate(new RateMeReasonsFragment$diffAdapter$1(this), null, 0, null, 14, null)).P(new ItemHeaderDelegate());
    }

    private final void X() {
        FragmentActivity requireActivity = requireActivity();
        requireActivity.setResult(-1);
        requireActivity.finish();
    }

    private final Navigator Y() {
        return (Navigator) this.f28386o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(TwoLinesItemDelegate.Model<RateMeItem> model) {
        M().I(model.B());
    }

    private final ListModel a0(RateMeItem rateMeItem, boolean z7, boolean z8) {
        int i8;
        float c8;
        String a8 = rateMeItem.a();
        if (z7) {
            i8 = R.drawable.ic_radio_alternative_on;
        } else {
            i8 = R.drawable.ic_radio_off;
        }
        Image.Res res = new Image.Res(i8);
        Text b8 = rateMeItem.b();
        Color.Res res2 = new Color.Res(R.color.white);
        Color.Res res3 = new Color.Res(R.color.neutral900);
        Color.Res res4 = new Color.Res(R.color.neutral900);
        Color.Res res5 = new Color.Res(R.color.neutral800);
        if (z8) {
            c8 = 0.0f;
        } else {
            c8 = Dimens.c(1.0f);
        }
        return new TwoLinesItemDelegate.Model(a8, b8, null, res2, null, null, null, null, null, res, null, null, null, null, null, null, res3, null, rateMeItem, false, 0, 0, false, res5, res4, Float.valueOf(c8), false, false, false, 477822452, null);
    }

    private final List<ListModel> b0(List<RateMeItem> list, RateMeItem rateMeItem) {
        int v7;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : list) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            RateMeItem rateMeItem2 = (RateMeItem) obj;
            boolean a8 = Intrinsics.a(rateMeItem2, rateMeItem);
            boolean z7 = true;
            if (i8 != list.size() - 1) {
                z7 = false;
            }
            arrayList.add(a0(rateMeItem2, a8, z7));
            i8 = i9;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(RateMeReasonsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().L();
        this$0.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(RateMeReasonsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Navigator Y = this$0.Y();
        if (Y != null) {
            Y.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e0(RateMeReasonsFragment this$0, MenuItem menuItem) {
        Intrinsics.f(this$0, "this$0");
        if (menuItem.getItemId() == R.id.actionClose) {
            this$0.X();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003d, code lost:
        if (r2 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f0(ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment r2, ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel.RateMeCategoryScreenState r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.e(r3, r0)
            r2.i0(r3)
            int r0 = ee.mtakso.driver.R.id.actionButton
            android.view.View r0 = r2.V(r0)
            ee.mtakso.driver.uikit.widgets.RoundButton r0 = (ee.mtakso.driver.uikit.widgets.RoundButton) r0
            boolean r1 = r3.d()
            r0.setEnabled(r1)
            int r0 = ee.mtakso.driver.R.id.kc
            android.view.View r0 = r2.V(r0)
            ee.mtakso.driver.uicore.components.views.PopupToolbar r0 = (ee.mtakso.driver.uicore.components.views.PopupToolbar) r0
            ee.mtakso.driver.ui.interactor.rateme.RateMeCategory r3 = r3.e()
            if (r3 == 0) goto L3f
            ee.mtakso.driver.uikit.utils.Text r3 = r3.d()
            if (r3 == 0) goto L3f
            android.content.Context r2 = r2.requireContext()
            java.lang.String r1 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.e(r2, r1)
            java.lang.CharSequence r2 = ee.mtakso.driver.uikit.utils.TextKt.a(r3, r2)
            if (r2 != 0) goto L41
        L3f:
            java.lang.String r2 = ""
        L41:
            r0.setTitle(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment.f0(ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment, ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel$RateMeCategoryScreenState):void");
    }

    private final void h0() {
        int i8 = R.id.H9;
        ((RecyclerView) V(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) V(i8)).setAdapter(this.f28387p);
        ((RecyclerView) V(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) V(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((RecyclerView) V(i8)).l(new RecyclerView.OnScrollListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment$setupRecycler$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(RecyclerView recyclerView, int i9) {
                Intrinsics.f(recyclerView, "recyclerView");
                super.a(recyclerView, i9);
                View scrollableShadowIndicator = RateMeReasonsFragment.this.V(R.id.scrollableShadowIndicator);
                Intrinsics.e(scrollableShadowIndicator, "scrollableShadowIndicator");
                ViewExtKt.e(scrollableShadowIndicator, recyclerView.canScrollVertically(1), 0, 2, null);
            }
        });
    }

    private final void i0(RateMeCategoryViewModel.RateMeCategoryScreenState rateMeCategoryScreenState) {
        if (rateMeCategoryScreenState.e() == null) {
            return;
        }
        DiffAdapter.V(this.f28387p, b0(rateMeCategoryScreenState.e().c(), rateMeCategoryScreenState.f()), null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28388q.clear();
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28388q;
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
    /* renamed from: g0 */
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) V(R.id.H9);
        Intrinsics.e(recyclerView, "recyclerView");
        int i8 = R.id.f19828c1;
        ee.mtakso.driver.uikit.utils.ViewExtKt.f(recyclerView, null, null, null, Integer.valueOf(((FrameLayout) V(i8)).getHeight()), 7, null);
        FrameLayout buttonPanel = (FrameLayout) V(i8);
        Intrinsics.e(buttonPanel, "buttonPanel");
        ViewExtKt.c(buttonPanel, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                RecyclerView recyclerView2 = (RecyclerView) RateMeReasonsFragment.this.V(R.id.H9);
                Intrinsics.e(recyclerView2, "recyclerView");
                ee.mtakso.driver.uikit.utils.ViewExtKt.f(recyclerView2, null, null, null, Integer.valueOf(((FrameLayout) RateMeReasonsFragment.this.V(R.id.f19828c1)).getHeight()), 7, null);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        int i9 = R.id.actionButton;
        RoundButton actionButton = (RoundButton) V(i9);
        Intrinsics.e(actionButton, "actionButton");
        ViewExtKt.e(actionButton, false, 0, 3, null);
        ((RoundButton) V(i9)).setText(R.string.rate_me_dislike_button);
        ((RoundButton) V(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeReasonsFragment.c0(RateMeReasonsFragment.this, view2);
            }
        });
        int i10 = R.id.kc;
        ((PopupToolbar) V(i10)).setNavigationOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeReasonsFragment.d0(RateMeReasonsFragment.this, view2);
            }
        });
        ((PopupToolbar) V(i10)).x(R.menu.close_menu);
        ((PopupToolbar) V(i10)).setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.p
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean e02;
                e02 = RateMeReasonsFragment.e0(RateMeReasonsFragment.this, menuItem);
                return e02;
            }
        });
        h0();
        M().G().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RateMeReasonsFragment.f0(RateMeReasonsFragment.this, (RateMeCategoryViewModel.RateMeCategoryScreenState) obj);
            }
        });
    }
}
