package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.LoadingDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceState;
import ee.mtakso.driver.ui.screens.earnings.v3.common.BannerController;
import ee.mtakso.driver.ui.screens.earnings.v3.common.BannerData;
import ee.mtakso.driver.ui.screens.earnings.v3.common.ButtonData;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SubtitleItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.Paging;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.SegmentControlItemView;
import ee.mtakso.driver.uikit.widgets.SegmentControlView;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: EarningsBalanceFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceFragment extends BazeMvvmFragment<EarningsBalanceViewModel> {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f28776w = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final RoutingManager f28777o;

    /* renamed from: p  reason: collision with root package name */
    private final DeeplinkDelegate f28778p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f28779q;

    /* renamed from: r  reason: collision with root package name */
    private BannerController f28780r;

    /* renamed from: s  reason: collision with root package name */
    private InfoBlockController f28781s;

    /* renamed from: t  reason: collision with root package name */
    private Paging f28782t;

    /* renamed from: u  reason: collision with root package name */
    private final int f28783u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f28784v;

    /* compiled from: EarningsBalanceFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            return SimpleActivity.Companion.b(SimpleActivity.f27004l, EarningsBalanceFragment.class, null, false, 0, 14, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public EarningsBalanceFragment(BaseUiDependencies dependencies, RoutingManager routingManager, DeeplinkDelegate deeplinkDelegate) {
        super(dependencies, R.layout.fragment_earnings_balance, null, 4, null);
        Intrinsics.f(dependencies, "dependencies");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        this.f28784v = new LinkedHashMap();
        this.f28777o = routingManager;
        this.f28778p = deeplinkDelegate;
        this.f28779q = new DiffAdapter().P(new SubtitleItemDelegate()).P(new InfoBlockDelegate()).P(new EarningsBalanceHistoryDelegate(new EarningsBalanceFragment$adapter$1(this))).P(new LoadingDelegate()).P(new StaticItemDelegate(R.layout.delegate_item_earnings_balance_history_stub));
        this.f28783u = 2132017818;
    }

    private final Navigator h0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(DriverButtonAction driverButtonAction) {
        if (driverButtonAction instanceof DriverButtonAction.DeepLink) {
            DeeplinkDelegate.f(this.f28778p, ((DriverButtonAction.DeepLink) driverButtonAction).a(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String str) {
        DeeplinkDelegate.f(this.f28778p, str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(final String str) {
        PopupToolbarAppearance popupToolbarAppearance;
        boolean z7;
        if (str != null) {
            if (str.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                popupToolbarAppearance = new PopupToolbarAppearance(0, new Text.Resource(R.string.balance, null, 2, null), false, null, null, null, new Image.Res(R.drawable.ic_help_circle), new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$renderFaq$appearance$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final void b() {
                        RoutingManager routingManager;
                        routingManager = EarningsBalanceFragment.this.f28777o;
                        RoutingManager.d(routingManager, SupportFragment.Companion.b(SupportFragment.f33440u, str, null, 2, null), false, 2, null);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                }, new Color.Attr(R.attr.contentPrimary), 61, null);
                h0().x(popupToolbarAppearance);
            }
        }
        popupToolbarAppearance = new PopupToolbarAppearance(0, new Text.Resource(R.string.balance, null, 2, null), false, null, null, null, null, null, null, 509, null);
        h0().x(popupToolbarAppearance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q0(ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent<ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceState.History> r19) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment.q0(ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(EarningsBalanceContent<EarningsBalanceState.HistoryHeader> earningsBalanceContent) {
        Sequence n8;
        List D;
        IntRange o8;
        IntRange o9;
        Sequence w7;
        int i8 = 0;
        if (earningsBalanceContent instanceof EarningsBalanceContent.Loading) {
            View balanceSegmentsHeader = Y(R.id.balanceSegmentsHeader);
            Intrinsics.e(balanceSegmentsHeader, "balanceSegmentsHeader");
            ViewExtKt.d(balanceSegmentsHeader, false, 0, 2, null);
            View balanceSegmentsHeaderStub = Y(R.id.balanceSegmentsHeaderStub);
            Intrinsics.e(balanceSegmentsHeaderStub, "balanceSegmentsHeaderStub");
            ViewExtKt.d(balanceSegmentsHeaderStub, true, 0, 2, null);
        } else if (earningsBalanceContent instanceof EarningsBalanceContent.LoadingByRetry) {
            View balanceSegmentsHeader2 = Y(R.id.balanceSegmentsHeader);
            Intrinsics.e(balanceSegmentsHeader2, "balanceSegmentsHeader");
            ViewExtKt.d(balanceSegmentsHeader2, false, 0, 2, null);
            View balanceSegmentsHeaderStub2 = Y(R.id.balanceSegmentsHeaderStub);
            Intrinsics.e(balanceSegmentsHeaderStub2, "balanceSegmentsHeaderStub");
            ViewExtKt.d(balanceSegmentsHeaderStub2, false, 0, 2, null);
        } else if (earningsBalanceContent instanceof EarningsBalanceContent.Error) {
            View balanceSegmentsHeader3 = Y(R.id.balanceSegmentsHeader);
            Intrinsics.e(balanceSegmentsHeader3, "balanceSegmentsHeader");
            ViewExtKt.d(balanceSegmentsHeader3, false, 0, 2, null);
            View balanceSegmentsHeaderStub3 = Y(R.id.balanceSegmentsHeaderStub);
            Intrinsics.e(balanceSegmentsHeaderStub3, "balanceSegmentsHeaderStub");
            ViewExtKt.d(balanceSegmentsHeaderStub3, false, 0, 2, null);
        } else {
            EarningsBalanceState.HistoryHeader a8 = earningsBalanceContent.a();
            if (a8 == null) {
                View balanceSegmentsHeader4 = Y(R.id.balanceSegmentsHeader);
                Intrinsics.e(balanceSegmentsHeader4, "balanceSegmentsHeader");
                ViewExtKt.d(balanceSegmentsHeader4, false, 0, 2, null);
                View balanceSegmentsHeaderStub4 = Y(R.id.balanceSegmentsHeaderStub);
                Intrinsics.e(balanceSegmentsHeaderStub4, "balanceSegmentsHeaderStub");
                ViewExtKt.d(balanceSegmentsHeaderStub4, false, 0, 2, null);
                return;
            }
            View balanceSegmentsHeader5 = Y(R.id.balanceSegmentsHeader);
            Intrinsics.e(balanceSegmentsHeader5, "balanceSegmentsHeader");
            ViewExtKt.d(balanceSegmentsHeader5, true, 0, 2, null);
            View balanceSegmentsHeaderStub5 = Y(R.id.balanceSegmentsHeaderStub);
            Intrinsics.e(balanceSegmentsHeaderStub5, "balanceSegmentsHeaderStub");
            ViewExtKt.d(balanceSegmentsHeaderStub5, false, 0, 2, null);
            int i9 = R.id.balanceSegments;
            Context context = ((SegmentControlView) Y(i9)).getContext();
            SegmentControlView balanceSegments = (SegmentControlView) Y(i9);
            Intrinsics.e(balanceSegments, "balanceSegments");
            n8 = SequencesKt___SequencesKt.n(ViewGroupKt.a(balanceSegments), new Function1<View, Boolean>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$renderHistoryHeader$segmentViews$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(View it) {
                    Intrinsics.f(it, "it");
                    return Boolean.valueOf(it instanceof SegmentControlItemView);
                }
            });
            D = SequencesKt___SequencesKt.D(n8);
            o8 = RangesKt___RangesKt.o(D.size(), a8.c().size());
            Iterator<Integer> it = o8.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                Context requireContext = requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                ((SegmentControlView) Y(R.id.balanceSegments)).addView(new SegmentControlItemView(requireContext, null, 0, 6, null));
            }
            o9 = RangesKt___RangesKt.o(a8.c().size(), D.size());
            Iterator<Integer> it2 = o9.iterator();
            while (it2.hasNext()) {
                ((SegmentControlView) Y(R.id.balanceSegments)).removeView((View) D.get(((IntIterator) it2).nextInt()));
            }
            SegmentControlView balanceSegments2 = (SegmentControlView) Y(R.id.balanceSegments);
            Intrinsics.e(balanceSegments2, "balanceSegments");
            w7 = SequencesKt___SequencesKt.w(ViewGroupKt.a(balanceSegments2), new Function1<View, SegmentControlItemView>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$renderHistoryHeader$3
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final SegmentControlItemView invoke(View it3) {
                    Intrinsics.f(it3, "it");
                    if (it3 instanceof SegmentControlItemView) {
                        return (SegmentControlItemView) it3;
                    }
                    return null;
                }
            });
            for (Object obj : w7) {
                int i10 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                SegmentControlItemView segmentControlItemView = (SegmentControlItemView) obj;
                final EarningsBalanceState.HistorySection historySection = a8.c().get(i8);
                Text e8 = historySection.e();
                Intrinsics.e(context, "context");
                segmentControlItemView.setTitle(TextKt.a(e8, context));
                segmentControlItemView.setActivated(historySection.d());
                segmentControlItemView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EarningsBalanceFragment.s0(EarningsBalanceFragment.this, historySection, view);
                    }
                });
                i8 = i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(EarningsBalanceFragment this$0, EarningsBalanceState.HistorySection section, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(section, "$section");
        this$0.M().S(section);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(EarningsBalanceContent<EarningsBalanceState.PayoutHeader> earningsBalanceContent) {
        boolean z7;
        CharSequence charSequence;
        boolean z8;
        CharSequence charSequence2;
        Text c8;
        boolean z9 = true;
        TransitionManager.b((CoordinatorLayout) Y(R.id.balanceRoot), new AutoTransition().r((RecyclerView) Y(R.id.H9), true));
        CharSequence charSequence3 = null;
        if (earningsBalanceContent instanceof EarningsBalanceContent.Loading) {
            View balanceRetryView = Y(R.id.balanceRetryView);
            Intrinsics.e(balanceRetryView, "balanceRetryView");
            ViewExtKt.d(balanceRetryView, false, 0, 2, null);
            View balanceCollapsingHeader = Y(R.id.balanceCollapsingHeader);
            Intrinsics.e(balanceCollapsingHeader, "balanceCollapsingHeader");
            ViewExtKt.d(balanceCollapsingHeader, false, 0, 2, null);
            View balanceCollapsingHeaderStub = Y(R.id.balanceCollapsingHeaderStub);
            Intrinsics.e(balanceCollapsingHeaderStub, "balanceCollapsingHeaderStub");
            ViewExtKt.d(balanceCollapsingHeaderStub, true, 0, 2, null);
        } else if (earningsBalanceContent instanceof EarningsBalanceContent.LoadingByRetry) {
            ((RoundButton) Y(R.id.O9)).k();
            View balanceRetryView2 = Y(R.id.balanceRetryView);
            Intrinsics.e(balanceRetryView2, "balanceRetryView");
            ViewExtKt.d(balanceRetryView2, true, 0, 2, null);
            View balanceCollapsingHeader2 = Y(R.id.balanceCollapsingHeader);
            Intrinsics.e(balanceCollapsingHeader2, "balanceCollapsingHeader");
            ViewExtKt.d(balanceCollapsingHeader2, false, 0, 2, null);
            View balanceCollapsingHeaderStub2 = Y(R.id.balanceCollapsingHeaderStub);
            Intrinsics.e(balanceCollapsingHeaderStub2, "balanceCollapsingHeaderStub");
            ViewExtKt.d(balanceCollapsingHeaderStub2, false, 0, 2, null);
        } else if (earningsBalanceContent instanceof EarningsBalanceContent.Error) {
            int i8 = R.id.O9;
            ((RoundButton) Y(i8)).g();
            ((RoundButton) Y(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EarningsBalanceFragment.u0(EarningsBalanceFragment.this, view);
                }
            });
            View balanceRetryView3 = Y(R.id.balanceRetryView);
            Intrinsics.e(balanceRetryView3, "balanceRetryView");
            ViewExtKt.d(balanceRetryView3, true, 0, 2, null);
            View balanceCollapsingHeader3 = Y(R.id.balanceCollapsingHeader);
            Intrinsics.e(balanceCollapsingHeader3, "balanceCollapsingHeader");
            ViewExtKt.d(balanceCollapsingHeader3, false, 0, 2, null);
            View balanceCollapsingHeaderStub3 = Y(R.id.balanceCollapsingHeaderStub);
            Intrinsics.e(balanceCollapsingHeaderStub3, "balanceCollapsingHeaderStub");
            ViewExtKt.d(balanceCollapsingHeaderStub3, false, 0, 2, null);
        } else {
            final EarningsBalanceState.PayoutHeader a8 = earningsBalanceContent.a();
            if (a8 == null) {
                View balanceRetryView4 = Y(R.id.balanceRetryView);
                Intrinsics.e(balanceRetryView4, "balanceRetryView");
                ViewExtKt.d(balanceRetryView4, false, 0, 2, null);
                View balanceCollapsingHeader4 = Y(R.id.balanceCollapsingHeader);
                Intrinsics.e(balanceCollapsingHeader4, "balanceCollapsingHeader");
                ViewExtKt.d(balanceCollapsingHeader4, false, 0, 2, null);
                View balanceCollapsingHeaderStub4 = Y(R.id.balanceCollapsingHeaderStub);
                Intrinsics.e(balanceCollapsingHeaderStub4, "balanceCollapsingHeaderStub");
                ViewExtKt.d(balanceCollapsingHeaderStub4, false, 0, 2, null);
                return;
            }
            View balanceRetryView5 = Y(R.id.balanceRetryView);
            Intrinsics.e(balanceRetryView5, "balanceRetryView");
            ViewExtKt.d(balanceRetryView5, false, 0, 2, null);
            int i9 = R.id.balanceCollapsingHeader;
            View balanceCollapsingHeader5 = Y(i9);
            Intrinsics.e(balanceCollapsingHeader5, "balanceCollapsingHeader");
            ViewExtKt.d(balanceCollapsingHeader5, true, 0, 2, null);
            View balanceCollapsingHeaderStub5 = Y(R.id.balanceCollapsingHeaderStub);
            Intrinsics.e(balanceCollapsingHeaderStub5, "balanceCollapsingHeaderStub");
            ViewExtKt.d(balanceCollapsingHeaderStub5, false, 0, 2, null);
            Context context = Y(i9).getContext();
            int i10 = R.id.payoutTitle;
            TextView payoutTitle = (TextView) Y(i10);
            Intrinsics.e(payoutTitle, "payoutTitle");
            if (a8.f() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.d(payoutTitle, z7, 0, 2, null);
            TextView textView = (TextView) Y(i10);
            Text f8 = a8.f();
            if (f8 != null) {
                Intrinsics.e(context, "context");
                charSequence = TextKt.a(f8, context);
            } else {
                charSequence = null;
            }
            textView.setText(charSequence);
            Color c9 = a8.c();
            Intrinsics.e(context, "context");
            ((TextView) Y(i10)).setTextColor(ColorKt.b(c9, context));
            int i11 = R.id.payoutSubtitle;
            TextView payoutSubtitle = (TextView) Y(i11);
            Intrinsics.e(payoutSubtitle, "payoutSubtitle");
            if (a8.e() != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            ViewExtKt.d(payoutSubtitle, z8, 0, 2, null);
            TextView textView2 = (TextView) Y(i11);
            Text e8 = a8.e();
            if (e8 != null) {
                charSequence2 = TextKt.a(e8, context);
            } else {
                charSequence2 = null;
            }
            textView2.setText(charSequence2);
            int i12 = R.id.payoutButton;
            RoundButton payoutButton = (RoundButton) Y(i12);
            Intrinsics.e(payoutButton, "payoutButton");
            if (a8.b() == null) {
                z9 = false;
            }
            ViewExtKt.d(payoutButton, z9, 0, 2, null);
            if (a8.b() != null) {
                RoundButton payoutButton2 = (RoundButton) Y(i12);
                Intrinsics.e(payoutButton2, "payoutButton");
                UiKitRoundButtonTypeKt.a(payoutButton2, a8.b().b());
                RoundButton payoutButton3 = (RoundButton) Y(i12);
                Intrinsics.e(payoutButton3, "payoutButton");
                UiKitRoundButtonTypeKt.b(payoutButton3, a8.b().d());
            }
            RoundButton roundButton = (RoundButton) Y(i12);
            ButtonData<DriverButtonAction> b8 = a8.b();
            if (b8 != null && (c8 = b8.c()) != null) {
                charSequence3 = TextKt.a(c8, context);
            }
            roundButton.setText(charSequence3);
            ((RoundButton) Y(i12)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EarningsBalanceFragment.v0(EarningsBalanceFragment.this, a8, view);
                }
            });
            InfoBlockController infoBlockController = this.f28781s;
            if (infoBlockController != null) {
                infoBlockController.b(a8.d());
            }
            BannerController bannerController = this.f28780r;
            if (bannerController != null) {
                bannerController.c(a8.a(), new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$renderPayoutHeader$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final void b() {
                        DriverButtonAction driverButtonAction;
                        EarningsBalanceFragment earningsBalanceFragment = EarningsBalanceFragment.this;
                        BannerData<DriverButtonAction> a9 = a8.a();
                        if (a9 != null) {
                            driverButtonAction = a9.c();
                        } else {
                            driverButtonAction = null;
                        }
                        earningsBalanceFragment.i0(driverButtonAction);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(EarningsBalanceFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(EarningsBalanceFragment this$0, EarningsBalanceState.PayoutHeader payoutHeader, View view) {
        DriverButtonAction driverButtonAction;
        Intrinsics.f(this$0, "this$0");
        ButtonData<DriverButtonAction> b8 = payoutHeader.b();
        if (b8 != null) {
            driverButtonAction = b8.a();
        } else {
            driverButtonAction = null;
        }
        this$0.i0(driverButtonAction);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28784v.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f28783u);
    }

    public View Y(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28784v;
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
    /* renamed from: o0 */
    public EarningsBalanceViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (EarningsBalanceViewModel) new ViewModelProvider(this, E.d()).a(EarningsBalanceViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) Y(R.id.H9)).setAdapter(null);
        this.f28780r = null;
        this.f28781s = null;
        this.f28782t = null;
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        h0().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.balance, null, 2, null), false, null, null, null, null, null, null, 509, null));
        int i8 = R.id.H9;
        ((RecyclerView) Y(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) Y(i8)).setAdapter(this.f28779q);
        ((RecyclerView) Y(i8)).h(new ListItemDividerDecoration(Dimens.c(16.0f)));
        View payoutBanner = Y(R.id.payoutBanner);
        Intrinsics.e(payoutBanner, "payoutBanner");
        this.f28780r = new BannerController(payoutBanner);
        View payoutInfoblock = Y(R.id.payoutInfoblock);
        Intrinsics.e(payoutInfoblock, "payoutInfoblock");
        this.f28781s = new InfoBlockController(payoutInfoblock);
        RecyclerView recyclerView = (RecyclerView) Y(i8);
        Intrinsics.e(recyclerView, "recyclerView");
        this.f28782t = new Paging(recyclerView, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                EarningsBalanceViewModel M;
                M = EarningsBalanceFragment.this.M();
                M.N();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        Image.DarkLight darkLight = new Image.DarkLight(new Image.Res(R.drawable.ic_receipt_200dp_dark), new Image.Res(R.drawable.ic_receipt_200dp_light));
        ImageView emptyImage = (ImageView) Y(R.id.emptyImage);
        Intrinsics.e(emptyImage, "emptyImage");
        ImageKt.b(darkLight, emptyImage, null, 2, null);
        LiveData b8 = Transformations.b(M().Q(), new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$$inlined$map$1
            @Override // androidx.arch.core.util.Function
            public final String apply(EarningsBalanceState earningsBalanceState) {
                return earningsBalanceState.c();
            }
        });
        Intrinsics.e(b8, "crossinline transform: (…p(this) { transform(it) }");
        LiveData a8 = Transformations.a(b8);
        Intrinsics.e(a8, "distinctUntilChanged(this)");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                EarningsBalanceFragment.this.p0(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        a8.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsBalanceFragment.k0(Function1.this, obj);
            }
        });
        LiveData b9 = Transformations.b(M().Q(), new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$$inlined$map$2
            @Override // androidx.arch.core.util.Function
            public final EarningsBalanceContent<EarningsBalanceState.PayoutHeader> apply(EarningsBalanceState earningsBalanceState) {
                return earningsBalanceState.f();
            }
        });
        Intrinsics.e(b9, "crossinline transform: (…p(this) { transform(it) }");
        LiveData a9 = Transformations.a(b9);
        Intrinsics.e(a9, "distinctUntilChanged(this)");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<EarningsBalanceContent<EarningsBalanceState.PayoutHeader>, Unit> function12 = new Function1<EarningsBalanceContent<EarningsBalanceState.PayoutHeader>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsBalanceContent<EarningsBalanceState.PayoutHeader> it) {
                EarningsBalanceFragment earningsBalanceFragment = EarningsBalanceFragment.this;
                Intrinsics.e(it, "it");
                earningsBalanceFragment.t0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsBalanceContent<EarningsBalanceState.PayoutHeader> earningsBalanceContent) {
                b(earningsBalanceContent);
                return Unit.f50853a;
            }
        };
        a9.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsBalanceFragment.l0(Function1.this, obj);
            }
        });
        LiveData b10 = Transformations.b(M().Q(), new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$$inlined$map$3
            @Override // androidx.arch.core.util.Function
            public final EarningsBalanceContent<EarningsBalanceState.HistoryHeader> apply(EarningsBalanceState earningsBalanceState) {
                return earningsBalanceState.e();
            }
        });
        Intrinsics.e(b10, "crossinline transform: (…p(this) { transform(it) }");
        LiveData a10 = Transformations.a(b10);
        Intrinsics.e(a10, "distinctUntilChanged(this)");
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<EarningsBalanceContent<EarningsBalanceState.HistoryHeader>, Unit> function13 = new Function1<EarningsBalanceContent<EarningsBalanceState.HistoryHeader>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsBalanceContent<EarningsBalanceState.HistoryHeader> it) {
                EarningsBalanceFragment earningsBalanceFragment = EarningsBalanceFragment.this;
                Intrinsics.e(it, "it");
                earningsBalanceFragment.r0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsBalanceContent<EarningsBalanceState.HistoryHeader> earningsBalanceContent) {
                b(earningsBalanceContent);
                return Unit.f50853a;
            }
        };
        a10.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsBalanceFragment.m0(Function1.this, obj);
            }
        });
        LiveData b11 = Transformations.b(M().Q(), new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$$inlined$map$4
            @Override // androidx.arch.core.util.Function
            public final EarningsBalanceContent<EarningsBalanceState.History> apply(EarningsBalanceState earningsBalanceState) {
                return earningsBalanceState.d();
            }
        });
        Intrinsics.e(b11, "crossinline transform: (…p(this) { transform(it) }");
        LiveData a11 = Transformations.a(b11);
        Intrinsics.e(a11, "distinctUntilChanged(this)");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<EarningsBalanceContent<EarningsBalanceState.History>, Unit> function14 = new Function1<EarningsBalanceContent<EarningsBalanceState.History>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment$onViewCreated$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsBalanceContent<EarningsBalanceState.History> it) {
                EarningsBalanceFragment earningsBalanceFragment = EarningsBalanceFragment.this;
                Intrinsics.e(it, "it");
                earningsBalanceFragment.q0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsBalanceContent<EarningsBalanceState.History> earningsBalanceContent) {
                b(earningsBalanceContent);
                return Unit.f50853a;
            }
        };
        a11.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsBalanceFragment.n0(Function1.this, obj);
            }
        });
    }
}
