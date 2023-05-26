package ee.mtakso.driver.ui.screens.work;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.dashboard.HomeScreenItemPayload;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.BaseDashboardHeightUpdater;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.LayoutListModel;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpanSize;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: WorkDashboardInnerLayoutDelegate.kt */
/* loaded from: classes5.dex */
public final class WorkDashboardInnerLayoutDelegate implements LoadingView {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f33667g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final View f33668a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f33669b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f33670c;

    /* renamed from: d  reason: collision with root package name */
    private final DiffAdapter f33671d;

    /* renamed from: e  reason: collision with root package name */
    private SpannedGridLayoutManager f33672e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f33673f;

    /* compiled from: WorkDashboardInnerLayoutDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkDashboardInnerLayoutDelegate(View containerView, Function0<Unit> requestLayoutUpdate, Function1<? super String, Unit> onLinkClicked) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(requestLayoutUpdate, "requestLayoutUpdate");
        Intrinsics.f(onLinkClicked, "onLinkClicked");
        this.f33673f = new LinkedHashMap();
        this.f33668a = containerView;
        this.f33669b = requestLayoutUpdate;
        this.f33670c = onLinkClicked;
        DiffAdapter diffAdapter = new DiffAdapter();
        diffAdapter.P(new DashboardBannerDelegate(new WorkDashboardInnerLayoutDelegate$diffAdapter$1$1(this), 0, 2, null));
        diffAdapter.P(new DashboardItemDelegate(new WorkDashboardInnerLayoutDelegate$diffAdapter$1$2(this), new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkDashboardInnerLayoutDelegate$diffAdapter$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                Function1 function1;
                Intrinsics.f(it, "it");
                function1 = WorkDashboardInnerLayoutDelegate.this.f33670c;
                function1.invoke(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        }, 0, 4, null));
        this.f33671d = diffAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(DashboardBannerDelegate.Model model) {
        HomeScreenItemPayload.Banner banner;
        Object q8 = model.q();
        String str = null;
        if (q8 instanceof HomeScreenItemPayload.Banner) {
            banner = (HomeScreenItemPayload.Banner) q8;
        } else {
            banner = null;
        }
        if (banner != null) {
            str = banner.a();
        }
        if (str != null) {
            this.f33670c.invoke(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(DashboardItemDelegate.Model model) {
        HomeScreenItemPayload.Title title;
        Object s7 = model.s();
        String str = null;
        if (s7 instanceof HomeScreenItemPayload.Title) {
            title = (HomeScreenItemPayload.Title) s7;
        } else {
            title = null;
        }
        if (title != null) {
            str = title.a();
        }
        if (str != null) {
            this.f33670c.invoke(str);
        }
    }

    @Override // ee.mtakso.driver.ui.screens.work.LoadingView
    public void a() {
        ViewExtKt.e(g(), false, 0, 3, null);
    }

    @Override // ee.mtakso.driver.ui.screens.work.LoadingView
    public void b() {
        ViewExtKt.e(g(), false, 0, 2, null);
    }

    public View g() {
        return this.f33668a;
    }

    public final void j(DashboardState.Dynamic workState) {
        final List<LayoutListModel> v02;
        int d8;
        int v7;
        Intrinsics.f(workState, "workState");
        final int a8 = workState.a();
        List<LayoutListModel> b8 = workState.b();
        v02 = CollectionsKt___CollectionsKt.v0(b8, new Comparator() { // from class: ee.mtakso.driver.ui.screens.work.WorkDashboardInnerLayoutDelegate$updateDashboardState$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a9;
                LayoutListModel layoutListModel = (LayoutListModel) t7;
                LayoutListModel layoutListModel2 = (LayoutListModel) t8;
                a9 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf((layoutListModel.d() * 2 * a8) + layoutListModel.a()), Integer.valueOf((layoutListModel2.d() * 2 * a8) + layoutListModel2.a()));
                return a9;
            }
        });
        boolean z7 = false;
        if (b8.isEmpty()) {
            d8 = 0;
        } else {
            Iterator<T> it = b8.iterator();
            if (it.hasNext()) {
                LayoutListModel layoutListModel = (LayoutListModel) it.next();
                d8 = layoutListModel.d() + layoutListModel.b();
                while (it.hasNext()) {
                    LayoutListModel layoutListModel2 = (LayoutListModel) it.next();
                    int b9 = layoutListModel2.b() + layoutListModel2.d();
                    if (d8 < b9) {
                        d8 = b9;
                    }
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        SpannedGridLayoutManager spannedGridLayoutManager = this.f33672e;
        if (spannedGridLayoutManager != null && spannedGridLayoutManager.j0() == v02.size()) {
            z7 = true;
        }
        if (!z7) {
            this.f33672e = new SpannedGridLayoutManager(SpannedGridLayoutManager.Orientation.VERTICAL, a8, Integer.valueOf(Dimens.d(80)), new BaseDashboardHeightUpdater(this.f33671d));
            RecyclerView recyclerView = (RecyclerView) g().findViewById(R.id.dashboardRecycler);
            if (recyclerView != null) {
                this.f33671d.Q();
                recyclerView.setAdapter(this.f33671d);
                recyclerView.setLayoutManager(this.f33672e);
                recyclerView.setNestedScrollingEnabled(true);
                SpannedGridLayoutManager spannedGridLayoutManager2 = this.f33672e;
                if (spannedGridLayoutManager2 != null) {
                    spannedGridLayoutManager2.C2(new WorkDashboardInnerLayoutDelegate$updateDashboardState$1$1(recyclerView, this));
                }
                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                layoutParams.height = (d8 * Dimens.d(80)) + recyclerView.getPaddingTop() + recyclerView.getPaddingBottom();
                recyclerView.setLayoutParams(layoutParams);
            }
        }
        SpannedGridLayoutManager spannedGridLayoutManager3 = this.f33672e;
        if (spannedGridLayoutManager3 != null) {
            spannedGridLayoutManager3.E2(new SpannedGridLayoutManager.SpanSizeLookup(new Function1<Integer, SpanSize>() { // from class: ee.mtakso.driver.ui.screens.work.WorkDashboardInnerLayoutDelegate$updateDashboardState$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final SpanSize b(int i8) {
                    Object Z;
                    int i9;
                    int d9;
                    int i10;
                    int d10;
                    Z = CollectionsKt___CollectionsKt.Z(v02, i8);
                    LayoutListModel layoutListModel3 = (LayoutListModel) Z;
                    if (layoutListModel3 != null) {
                        i9 = layoutListModel3.e();
                    } else {
                        i9 = 1;
                    }
                    d9 = RangesKt___RangesKt.d(i9, 1);
                    if (layoutListModel3 != null) {
                        i10 = layoutListModel3.b();
                    } else {
                        i10 = 1;
                    }
                    d10 = RangesKt___RangesKt.d(i10, 1);
                    return new SpanSize(d9, d10);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ SpanSize invoke(Integer num) {
                    return b(num.intValue());
                }
            }));
        }
        DiffAdapter diffAdapter = this.f33671d;
        v7 = CollectionsKt__IterablesKt.v(v02, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LayoutListModel layoutListModel3 : v02) {
            arrayList.add(layoutListModel3.c());
        }
        DiffAdapter.V(diffAdapter, arrayList, null, 2, null);
    }
}
