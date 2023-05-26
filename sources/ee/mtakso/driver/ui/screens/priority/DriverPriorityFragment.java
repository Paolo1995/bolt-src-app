package ee.mtakso.driver.ui.screens.priority;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.GenericItem;
import ee.mtakso.driver.network.client.priority.ContentItem;
import ee.mtakso.driver.network.client.priority.DriverPriorityResponse;
import ee.mtakso.driver.network.client.priority.PreconditionItem;
import ee.mtakso.driver.network.client.priority.PriorityComponentItem;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebViewModel;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.HorizontalListDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SimpleTextDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.VerticalKeyValueDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPriorityFragment.kt */
/* loaded from: classes3.dex */
public final class DriverPriorityFragment extends BazeMvvmFragment<DriverPriorityViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f32503s = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final DeeplinkDelegate f32504o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f32505p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f32506q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f32507r;

    /* compiled from: DriverPriorityFragment.kt */
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
    public DriverPriorityFragment(BaseUiDependencies deps, DeeplinkDelegate deeplinkDelegate) {
        super(deps, R.layout.fragment_driver_priority, null, 4, null);
        List e8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        this.f32507r = new LinkedHashMap();
        this.f32504o = deeplinkDelegate;
        this.f32505p = LazyKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = DriverPriorityFragment.this.getActivity();
                Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
                return (Navigator) activity;
            }
        });
        DiffAdapter P = new DiffAdapter().P(new SimpleTextDelegate(new DriverPriorityFragment$diffAdapter$1(this))).P(new InfoBlockDelegate()).P(new TextCenteredDelegate(new Function1<TextCenteredDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment$diffAdapter$2
            public final void b(TextCenteredDelegate.Model it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextCenteredDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        })).P(new GenericItemDelegate(new Function1<GenericItemDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment$diffAdapter$3
            public final void b(GenericItemDelegate.Model it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GenericItemDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        }, null, 2, null)).P(new GenericTitleDelegate()).P(new VerticalKeyValueDelegate(new Function1<VerticalKeyValueDelegate.Model<GenericItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment$diffAdapter$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VerticalKeyValueDelegate.Model<GenericItem> model) {
                Intrinsics.f(model, "model");
                DriverPriorityFragment.this.c0(model.q());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerticalKeyValueDelegate.Model<GenericItem> model) {
                b(model);
                return Unit.f50853a;
            }
        }));
        e8 = CollectionsKt__CollectionsJVMKt.e(new DashboardItemDelegate(new DriverPriorityFragment$diffAdapter$5(this), new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment$diffAdapter$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                Intrinsics.f(it, "it");
                DriverPriorityFragment.this.g0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        }, 0, 4, null));
        this.f32506q = P.P(new HorizontalListDelegate(e8)).P(new DividerDelegate()).P(new TwoLinesItemDelegate(new DriverPriorityFragment$diffAdapter$7(this), new DriverPriorityFragment$diffAdapter$8(this), 0, null, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(DashboardItemDelegate.Model model) {
        PriorityComponentItem priorityComponentItem;
        Object s7 = model.s();
        String str = null;
        if (s7 instanceof PriorityComponentItem) {
            priorityComponentItem = (PriorityComponentItem) s7;
        } else {
            priorityComponentItem = null;
        }
        if (priorityComponentItem != null) {
            str = priorityComponentItem.a();
        }
        if (str != null) {
            g0(str);
        }
    }

    private final void a0(DriverPriorityViewModel.ScreenState screenState) {
        j0(screenState.a());
        k0(screenState.b());
    }

    private final Navigator b0() {
        return (Navigator) this.f32505p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c0(ee.mtakso.driver.network.client.generic.GenericItem r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r6.a()
            if (r0 == 0) goto L12
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L10
            goto L12
        L10:
            r0 = 0
            goto L13
        L12:
            r0 = 1
        L13:
            if (r0 == 0) goto L16
            return
        L16:
            ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog$Companion r0 = ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog.f28299n
            java.lang.String r1 = r6.c()
            ee.mtakso.driver.network.client.generic.GenericValue r2 = r6.d()
            java.lang.String r2 = r2.d()
            java.lang.String r3 = r6.a()
            ee.mtakso.driver.network.client.generic.GenericValue r6 = r6.d()
            java.lang.Boolean r6 = r6.a()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r4)
            ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog r6 = r0.a(r1, r2, r3, r6)
            java.lang.String r0 = "TAG_VALUE_DIALOG"
            ee.mtakso.driver.uicore.utils.FragmentUtils.b(r6, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment.c0(ee.mtakso.driver.network.client.generic.GenericItem):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(TwoLinesItemDelegate.Model<PreconditionItem> model) {
        boolean z7;
        PreconditionItem B = model.B();
        if (B != null) {
            if (B.a() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                B = null;
            }
            if (B != null) {
                InfoCopyDialog.Companion companion = InfoCopyDialog.f28299n;
                String e8 = B.e();
                String d8 = B.d();
                if (d8 == null) {
                    d8 = "";
                }
                InfoCopyDialog a8 = companion.a(e8, d8, B.a(), true);
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                FragmentUtils.c(a8, requireActivity, "TAG_VALUE_DIALOG");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(SimpleTextDelegate.Model model) {
        ContentItem.Link link;
        Object t7 = model.t();
        String str = null;
        if (t7 instanceof ContentItem.Link) {
            link = (ContentItem.Link) t7;
        } else {
            link = null;
        }
        if (link != null) {
            str = link.a();
        }
        if (str != null) {
            g0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(DriverPriorityFragment this$0, DriverPriorityViewModel.ScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.a0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(String str) {
        if (str == null) {
            return;
        }
        this.f32504o.e(str, new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment$openDeeplink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                Intrinsics.f(it, "it");
                DriverPriorityFragment.this.h0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                b(str2);
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(String str) {
        if (str == null) {
            return;
        }
        Bundle b8 = InfoWebFragment.Companion.b(InfoWebFragment.f30370s, new InfoWebViewModel.Config("", new InfoWebViewModel.WebContent.Link(str), null, 4, null), null, 2, null);
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        companion.l(requireContext, InfoWebFragment.class, b8, true);
    }

    private final void j0(DriverPriorityResponse driverPriorityResponse) {
        ((AppCompatTextView) S(R.id.gc)).setText(driverPriorityResponse.d().c());
        ImageManager b8 = ImageManager.Companion.b(ImageManager.f36075b, null, 1, null);
        ImageRequest imageRequest = new ImageRequest(driverPriorityResponse.d().a(), null, null, null, 14, null);
        AppCompatImageView priorityImage = (AppCompatImageView) S(R.id.priorityImage);
        Intrinsics.e(priorityImage, "priorityImage");
        b8.c(imageRequest, priorityImage);
    }

    private final void k0(List<? extends ListModel> list) {
        DiffAdapter.V(this.f32506q, list, null, 2, null);
    }

    private final void l0() {
        SimpleItemAnimator simpleItemAnimator;
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f32506q);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) S(i8)).getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    private final void m0() {
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f32507r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void G() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) S(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        String k8 = ApiExceptionUtils.k(error, requireContext);
        String string2 = getString(R.string.ok_lowercase);
        Intrinsics.e(string2, "getString(R.string.ok_lowercase)");
        FragmentUtils.b(NotificationDialog.Companion.d(companion, string, k8, string2, error, null, 16, null), this, "TAG_ERROR_DIALOG");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void I() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) S(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 3, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32507r;
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
    /* renamed from: i0 */
    public DriverPriorityViewModel Q() {
        return (DriverPriorityViewModel) new ViewModelProvider(this, BazeMvvmFragment.L(this).d()).a(DriverPriorityViewModel.class);
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
            m0();
            return true;
        }
        b0().c();
        return true;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        b0().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.priority_title, null, 2, null), false, null, null, null, null, null, null, 505, null));
        l0();
        M().J().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.priority.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverPriorityFragment.f0(DriverPriorityFragment.this, (DriverPriorityViewModel.ScreenState) obj);
            }
        });
    }
}
