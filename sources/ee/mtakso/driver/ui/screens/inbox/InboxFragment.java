package ee.mtakso.driver.ui.screens.inbox;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.interactor.inbox.InboxItem;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainer;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeTab;
import ee.mtakso.driver.ui.screens.home.v3.footer.appearance.SelectedTabAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.PageAppearance;
import ee.mtakso.driver.ui.screens.inbox.InboxFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.HorizontalListDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemTextDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Padding;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.stories.model.StoryPreview;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.stories.StoryManager;
import eu.bolt.driver.stories.ui.story_preview.StoryPreviewDelegate;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InboxFragment.kt */
/* loaded from: classes3.dex */
public final class InboxFragment extends BazeMvvmFragment<InboxViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final StoryManager f30348o;

    /* renamed from: p  reason: collision with root package name */
    private final RoutingManager f30349p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f30350q;

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f30351r;

    /* renamed from: s  reason: collision with root package name */
    private final int f30352s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f30353t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public InboxFragment(BaseUiDependencies deps, StoryManager storyManager, RoutingManager routingManager) {
        super(deps, R.layout.fragment_inbox, null, 4, null);
        List e8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(storyManager, "storyManager");
        Intrinsics.f(routingManager, "routingManager");
        this.f30353t = new LinkedHashMap();
        this.f30348o = storyManager;
        this.f30349p = routingManager;
        DiffAdapter P = new DiffAdapter().P(new TwoLinesItemDelegate(new InboxFragment$diffAdapter$1(this), null, 0, null, 14, null)).P(new TwoLinesItemTextDelegate(new InboxFragment$diffAdapter$2(this), null, null, 6, null));
        e8 = CollectionsKt__CollectionsJVMKt.e(new StoryPreviewDelegate(0, new InboxFragment$diffAdapter$3(this), 1, null));
        this.f30350q = P.P(new HorizontalListDelegate(e8));
        this.f30351r = LazyKt.b(new Function0<HomeContainer>() { // from class: ee.mtakso.driver.ui.screens.inbox.InboxFragment$homeContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final HomeContainer invoke() {
                Fragment parentFragment = InboxFragment.this.getParentFragment();
                Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.home.v3.HomeContainer");
                return (HomeContainer) parentFragment;
            }
        });
        this.f30352s = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListModel X(InboxItem inboxItem, boolean z7) {
        Divider divider;
        int v7;
        if (z7) {
            divider = null;
        } else {
            divider = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
        }
        if (inboxItem instanceof InboxItem.News) {
            return Z(this, "news", inboxItem, new Text.Resource(R.string.inbox_news, null, 2, null), null, null, new Image.Res(R.drawable.ic_bell), null, null, null, divider, 472, null);
        }
        if (inboxItem instanceof InboxItem.Campaigns) {
            return Z(this, "campaigns", inboxItem, new Text.Resource(R.string.inbox_campaigns, null, 2, null), null, new Color.Attr(R.attr.accentNeutral), new Image.Res(R.drawable.ic_label_24), null, null, null, divider, 456, null);
        } else if (inboxItem instanceof InboxItem.BoltClub) {
            return Z(this, "bolt_club", inboxItem, new Text.Resource(R.string.inbox_loyalty_offers, null, 2, null), null, null, new Image.Res(R.drawable.ic_bolt_club_24), null, null, null, divider, 472, null);
        } else {
            if (inboxItem instanceof InboxItem.ScheduledRides) {
                return Z(this, "scheduled_rides", inboxItem, new Text.Resource(R.string.inbox_scheduled_rides, null, 2, null), null, null, new Image.Res(R.drawable.ic_calendar_clock), null, null, null, divider, 472, null);
            }
            if (inboxItem instanceof InboxItem.StoriesPreviews) {
                List<StoryPreview> a8 = ((InboxItem.StoriesPreviews) inboxItem).a();
                v7 = CollectionsKt__IterablesKt.v(a8, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (StoryPreview storyPreview : a8) {
                    arrayList.add(new StoryPreviewDelegate.Model(storyPreview.b(), storyPreview));
                }
                return new HorizontalListDelegate.Model("story_preview", arrayList, Dimens.d(164), null, new Background.Res(R.drawable.bg_bottom_rounded), new Text.Resource(R.string.what_is_new, null, 2, null), new Margins(0, 0, 0, Dimens.d(8), 7, null), new Padding(Dimens.d(24), 0, Dimens.d(24), 0, 10, null), 8, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final TwoLinesItemDelegate.Model<InboxItem> Y(String str, InboxItem inboxItem, Text text, Text text2, Color color, Image image, Color color2, Image image2, TwoLinesItemDelegate.Indicator indicator, DividerModel dividerModel) {
        boolean z7;
        Color color3;
        Color color4;
        boolean z8;
        boolean z9;
        Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
        Color.Attr attr2 = new Color.Attr(R.attr.contentSecondary);
        Color.Attr attr3 = new Color.Attr(R.attr.backPrimary);
        if (dividerModel != null) {
            z7 = dividerModel.e();
        } else {
            z7 = false;
        }
        Float f8 = null;
        if (dividerModel != null) {
            color3 = dividerModel.d();
        } else {
            color3 = null;
        }
        if (dividerModel != null) {
            color4 = dividerModel.f();
        } else {
            color4 = null;
        }
        if (dividerModel != null) {
            f8 = dividerModel.i();
        }
        Float f9 = f8;
        if (dividerModel != null) {
            z8 = dividerModel.j();
        } else {
            z8 = false;
        }
        if (dividerModel != null) {
            z9 = dividerModel.k();
        } else {
            z9 = false;
        }
        return new TwoLinesItemDelegate.Model<>(str, text, null, attr, null, text2, null, attr2, color, image, null, color2, image2, null, null, null, attr3, indicator, inboxItem, false, 0, 0, z7, color3, color4, f9, z8, z9, false, 272163924, null);
    }

    static /* synthetic */ TwoLinesItemDelegate.Model Z(InboxFragment inboxFragment, String str, InboxItem inboxItem, Text text, Text text2, Color color, Image image, Color color2, Image image2, TwoLinesItemDelegate.Indicator indicator, DividerModel dividerModel, int i8, Object obj) {
        return inboxFragment.Y(str, inboxItem, (i8 & 4) != 0 ? null : text, (i8 & 8) != 0 ? null : text2, (i8 & 16) != 0 ? new Color.Attr(R.attr.accentNeutral) : color, (i8 & 32) != 0 ? null : image, (i8 & 64) != 0 ? new Color.Attr(R.attr.dynamicNeutral04) : color2, (i8 & 128) != 0 ? new Image.Res(R.drawable.ic_chevron_right) : image2, (i8 & Spliterator.NONNULL) != 0 ? null : indicator, (i8 & 512) != 0 ? new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null) : dividerModel);
    }

    private final HomeContainer a0() {
        return (HomeContainer) this.f30351r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(String str) {
        List e8;
        RoutingManager routingManager = this.f30349p;
        StoryManager storyManager = this.f30348o;
        e8 = CollectionsKt__CollectionsJVMKt.e(str);
        routingManager.c(StoryManager.b(storyManager, e8, false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(TwoLinesItemDelegate.Model<InboxItem> model) {
        InboxItem B = model.B();
        if (B instanceof InboxItem.News) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            M().G(requireActivity);
        } else if (B instanceof InboxItem.Campaigns) {
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.e(requireActivity2, "requireActivity()");
            M().F(requireActivity2);
        } else if (B instanceof InboxItem.ScheduledRides) {
            FragmentActivity requireActivity3 = requireActivity();
            Intrinsics.e(requireActivity3, "requireActivity()");
            M().H(requireActivity3);
        } else if (B instanceof InboxItem.BoltClub) {
            FragmentActivity requireActivity4 = requireActivity();
            Intrinsics.e(requireActivity4, "requireActivity()");
            M().E(requireActivity4);
        } else {
            boolean z7 = B instanceof InboxItem.StoriesPreviews;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30353t.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f30352s);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30353t;
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
    public InboxViewModel Q() {
        return (InboxViewModel) new ViewModelProvider(this, BazeMvvmFragment.L(this).d()).a(InboxViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HomeContainer a02 = a0();
        String string = getString(R.string.inbox_title);
        Intrinsics.e(string, "getString(R.string.inbox_title)");
        a02.b(new PageAppearance(string), new SelectedTabAppearance(HomeTab.NEWS));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ObservableLiveData<List<InboxItem>> D = M().D();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends InboxItem>, Unit> function1 = new Function1<List<? extends InboxItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.inbox.InboxFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends InboxItem> items) {
                DiffAdapter diffAdapter;
                int v7;
                ListModel X;
                diffAdapter = InboxFragment.this.f30350q;
                Intrinsics.e(items, "items");
                InboxFragment inboxFragment = InboxFragment.this;
                v7 = CollectionsKt__IterablesKt.v(items, 10);
                ArrayList arrayList = new ArrayList(v7);
                int i8 = 0;
                for (Object obj : items) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    InboxItem inboxItem = (InboxItem) obj;
                    boolean z7 = true;
                    if (i8 != items.size() - 1) {
                        z7 = false;
                    }
                    X = inboxFragment.X(inboxItem, z7);
                    arrayList.add(X);
                    i8 = i9;
                }
                DiffAdapter.V(diffAdapter, arrayList, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends InboxItem> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        D.i(viewLifecycleOwner, new Observer() { // from class: c4.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InboxFragment.d0(Function1.this, obj);
            }
        });
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f30350q);
        ((RecyclerView) S(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        if (bundle == null) {
            M().I();
        }
    }
}
