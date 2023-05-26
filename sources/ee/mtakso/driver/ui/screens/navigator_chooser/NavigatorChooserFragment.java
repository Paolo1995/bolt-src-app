package ee.mtakso.driver.ui.screens.navigator_chooser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserState;
import ee.mtakso.driver.ui.screens.navigator_chooser.list.NavigationDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorChooserFragment.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserFragment extends BazeMvvmFragment<NavigatorChooserViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f30914t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final DriverFeatures f30915o;

    /* renamed from: p  reason: collision with root package name */
    private final int f30916p;

    /* renamed from: q  reason: collision with root package name */
    private final NavigatorChooserAdapter f30917q;

    /* renamed from: r  reason: collision with root package name */
    private final DiffAdapter f30918r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f30919s;

    /* compiled from: NavigatorChooserFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.f(context, "context");
            Intent h8 = SimpleActivity.Companion.h(SimpleActivity.f27004l, context, NavigatorChooserFragment.class, null, false, 12, null);
            h8.addFlags(268435456);
            context.startActivity(h8);
        }

        public final void b(Activity activity, int i8) {
            Intrinsics.f(activity, "activity");
            activity.startActivityForResult(SimpleActivity.Companion.h(SimpleActivity.f27004l, activity, NavigatorChooserFragment.class, null, false, 12, null), i8);
        }

        public final void c(Fragment fragment, int i8) {
            Intrinsics.f(fragment, "fragment");
            FragmentActivity requireActivity = fragment.requireActivity();
            Intrinsics.e(requireActivity, "fragment.requireActivity()");
            fragment.startActivityForResult(SimpleActivity.Companion.h(SimpleActivity.f27004l, requireActivity, NavigatorChooserFragment.class, null, false, 12, null), i8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NavigatorChooserFragment(BaseUiDependencies deps, DriverFeatures driverFeatures) {
        super(deps, R.layout.activity_navigator_chooser, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f30919s = new LinkedHashMap();
        this.f30915o = driverFeatures;
        this.f30916p = 2132017818;
        this.f30917q = new NavigatorChooserAdapter(new Function1<NavigatorItem, Unit>() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment$navigatorAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NavigatorItem it) {
                NavigatorChooserViewModel M;
                Intrinsics.f(it, "it");
                M = NavigatorChooserFragment.this.M();
                M.N(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigatorItem navigatorItem) {
                b(navigatorItem);
                return Unit.f50853a;
            }
        });
        this.f30918r = new DiffAdapter().P(new NavigationDelegate(new NavigatorChooserFragment$diffAdapter$1(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ListModel> a0(DynamicNavigationState dynamicNavigationState) {
        int v7;
        int m8;
        DividerModel divider;
        List<NavigationOption> c8 = dynamicNavigationState.c();
        v7 = CollectionsKt__IterablesKt.v(c8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : c8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            NavigationOption navigationOption = (NavigationOption) obj;
            String name = navigationOption.getName();
            boolean a8 = Intrinsics.a(dynamicNavigationState.d(), navigationOption);
            m8 = CollectionsKt__CollectionsKt.m(dynamicNavigationState.c());
            if (i8 == m8) {
                divider = NoDivider.f34829a;
            } else {
                divider = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
            }
            arrayList.add(new NavigationDelegate.Model(name, a8, divider, navigationOption));
            i8 = i9;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(NavigatorChooserFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(NavigatorChooserFragment this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismiss();
    }

    private final void e0(NavigatorChooserState navigatorChooserState) {
        this.f30917q.W(navigatorChooserState.b());
    }

    private final void f0() {
        int i8 = R.id.navigatorChooserRecyclerView;
        ((RecyclerView) V(i8)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) V(i8)).setAdapter(this.f30918r);
        ((RecyclerView) V(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        LiveData<DynamicNavigationState> K = M().K();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<DynamicNavigationState, Unit> function1 = new Function1<DynamicNavigationState, Unit>() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment$setUpDynamicNavigationOptions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DynamicNavigationState it) {
                DiffAdapter diffAdapter;
                List a02;
                diffAdapter = NavigatorChooserFragment.this.f30918r;
                NavigatorChooserFragment navigatorChooserFragment = NavigatorChooserFragment.this;
                Intrinsics.e(it, "it");
                a02 = navigatorChooserFragment.a0(it);
                DiffAdapter.V(diffAdapter, a02, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DynamicNavigationState dynamicNavigationState) {
                b(dynamicNavigationState);
                return Unit.f50853a;
            }
        };
        K.i(viewLifecycleOwner, new Observer() { // from class: m4.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigatorChooserFragment.g0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void h0() {
        RecyclerView recyclerView = (RecyclerView) V(R.id.navigatorChooserRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f30917q);
        recyclerView.setItemAnimator(null);
        NavigatorChooserItemDivider navigatorChooserItemDivider = new NavigatorChooserItemDivider();
        Color.Attr attr = new Color.Attr(R.attr.dynamicNeutral01);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        navigatorChooserItemDivider.l(ColorKt.a(attr, requireContext));
        navigatorChooserItemDivider.m(Dimens.c(24.0f));
        recyclerView.h(navigatorChooserItemDivider);
        M().L().i(getViewLifecycleOwner(), new Observer() { // from class: m4.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigatorChooserFragment.i0(NavigatorChooserFragment.this, (NavigatorChooserState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(NavigatorChooserFragment this$0, NavigatorChooserState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.e0(state);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30919s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f30916p);
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30919s;
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

    public final void Z(NavigationOption navigationOption) {
        Intrinsics.f(navigationOption, "navigationOption");
        M().M(navigationOption);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: d0 */
    public NavigatorChooserViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (NavigatorChooserViewModel) new ViewModelProvider(this, E.d()).a(NavigatorChooserViewModel.class);
    }

    public final void dismiss() {
        FragmentActivity requireActivity = requireActivity();
        requireActivity.setResult(-1);
        requireActivity.finish();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().O();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.kc;
        ((PopupToolbar) V(i8)).setTitle(R.string.navigator_chooser_title_v2);
        ((PopupToolbar) V(i8)).setNavigationOnClickListener(new View.OnClickListener() { // from class: m4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NavigatorChooserFragment.b0(NavigatorChooserFragment.this, view2);
            }
        });
        if (this.f30915o.r()) {
            f0();
        } else {
            h0();
        }
        M().J().i(getViewLifecycleOwner(), new Observer() { // from class: m4.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigatorChooserFragment.c0(NavigatorChooserFragment.this, obj);
            }
        });
    }
}
