package ee.mtakso.driver.ui.screens.work;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns;
import ee.mtakso.driver.network.client.campaign.DriverCampaign;
import ee.mtakso.driver.network.client.campaign.OptInGroupSummary;
import ee.mtakso.driver.network.client.generic.HighlightType;
import ee.mtakso.driver.network.client.order.DriverStatisticsSummary;
import ee.mtakso.driver.network.client.score.DriverScoreLabel;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.ui.interactor.score.DriverScoreItem;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignPeriodBadgesConditionsDelegateKt;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.ui.views.campaigns.tile.ActiveCampaignTileViewDelegate;
import ee.mtakso.driver.uicore.components.views.ExpandableTextView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: WorkStatisticsInnerLayoutDelegate.kt */
/* loaded from: classes5.dex */
public final class WorkStatisticsInnerLayoutDelegate implements LoadingView {

    /* renamed from: a  reason: collision with root package name */
    private final View f33762a;

    /* renamed from: b  reason: collision with root package name */
    private final DateTimeConverter f33763b;

    /* renamed from: c  reason: collision with root package name */
    private final CampaignAnalytics f33764c;

    /* renamed from: d  reason: collision with root package name */
    private final OptInCampaignAnalytics f33765d;

    /* renamed from: e  reason: collision with root package name */
    private final ReferralCampaignsAnalytics f33766e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverReferralCampaignManager f33767f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f33768g;

    /* renamed from: h  reason: collision with root package name */
    private ActiveAndFutureCampaigns f33769h;

    /* renamed from: i  reason: collision with root package name */
    private DriverFeaturesConfig.CircleKLoyaltyCampaignStatus f33770i;

    /* renamed from: j  reason: collision with root package name */
    private OptInGroupSummary f33771j;

    /* renamed from: k  reason: collision with root package name */
    private ActiveCampaignTileType f33772k;

    /* renamed from: l  reason: collision with root package name */
    private ActiveCampaignTileViewDelegate.LeftActionMode f33773l;

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f33774m;

    /* renamed from: n  reason: collision with root package name */
    private Function2<? super ActiveCampaignTileType, ? super Long, Unit> f33775n;

    /* renamed from: o  reason: collision with root package name */
    private Function1<? super DriverCampaign, Unit> f33776o;

    /* renamed from: p  reason: collision with root package name */
    private Function0<Unit> f33777p;

    /* renamed from: q  reason: collision with root package name */
    private Function0<Unit> f33778q;

    /* renamed from: r  reason: collision with root package name */
    private Function0<Unit> f33779r;

    /* renamed from: s  reason: collision with root package name */
    private Function0<Unit> f33780s;

    /* renamed from: t  reason: collision with root package name */
    private Function0<Unit> f33781t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f33782u;

    /* compiled from: WorkStatisticsInnerLayoutDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33783a;

        static {
            int[] iArr = new int[HighlightType.values().length];
            try {
                iArr[HighlightType.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HighlightType.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HighlightType.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HighlightType.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HighlightType.ALERT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f33783a = iArr;
        }
    }

    public WorkStatisticsInnerLayoutDelegate(View containerView, DateTimeConverter dateTimeConverter, CampaignAnalytics campaignAnalytics, OptInCampaignAnalytics optInCampaignAnalytics, ReferralCampaignsAnalytics referralCampaignsAnalytics, DriverReferralCampaignManager driverReferralCampaignManager, Function0<Unit> requestLayoutUpdate) {
        Lazy b8;
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(campaignAnalytics, "campaignAnalytics");
        Intrinsics.f(optInCampaignAnalytics, "optInCampaignAnalytics");
        Intrinsics.f(referralCampaignsAnalytics, "referralCampaignsAnalytics");
        Intrinsics.f(driverReferralCampaignManager, "driverReferralCampaignManager");
        Intrinsics.f(requestLayoutUpdate, "requestLayoutUpdate");
        this.f33782u = new LinkedHashMap();
        this.f33762a = containerView;
        this.f33763b = dateTimeConverter;
        this.f33764c = campaignAnalytics;
        this.f33765d = optInCampaignAnalytics;
        this.f33766e = referralCampaignsAnalytics;
        this.f33767f = driverReferralCampaignManager;
        this.f33768g = requestLayoutUpdate;
        this.f33770i = DriverFeaturesConfig.CircleKLoyaltyCampaignStatus.NOT_AVAILABLE;
        this.f33773l = ActiveCampaignTileViewDelegate.LeftActionMode.DISMISS;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ActiveCampaignTileViewDelegate>() { // from class: ee.mtakso.driver.ui.screens.work.WorkStatisticsInnerLayoutDelegate$activeCampaignTileViewDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ActiveCampaignTileViewDelegate invoke() {
                ActiveCampaignTileViewDelegate.LeftActionMode leftActionMode;
                View tileActiveCampaign = WorkStatisticsInnerLayoutDelegate.this.k(R.id.tileActiveCampaign);
                Intrinsics.e(tileActiveCampaign, "tileActiveCampaign");
                ActiveCampaignTileViewDelegate.ViewMode viewMode = ActiveCampaignTileViewDelegate.ViewMode.TILE;
                leftActionMode = WorkStatisticsInnerLayoutDelegate.this.f33773l;
                return new ActiveCampaignTileViewDelegate(tileActiveCampaign, viewMode, leftActionMode);
            }
        });
        this.f33774m = b8;
        ((LinearLayout) k(R.id.workStatisticsViewAllCampaignsContainer)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.l(WorkStatisticsInnerLayoutDelegate.this, view);
            }
        });
        ((ConstraintLayout) k(R.id.workStatisticsEarningsLayout)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.m(WorkStatisticsInnerLayoutDelegate.this, view);
            }
        });
        ((ConstraintLayout) k(R.id.workStatisticsActivityLayout)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.n(WorkStatisticsInnerLayoutDelegate.this, view);
            }
        });
        ((ConstraintLayout) k(R.id.workStatisticsRatingsLayout)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.o(WorkStatisticsInnerLayoutDelegate.this, view);
            }
        });
        ((ConstraintLayout) k(R.id.workStatisticsDriverScoreLayout)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.p(WorkStatisticsInnerLayoutDelegate.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(WorkStatisticsInnerLayoutDelegate this$0, DriverCampaign driverCampaign, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(driverCampaign, "$driverCampaign");
        Function1<? super DriverCampaign, Unit> function1 = this$0.f33776o;
        if (function1 != null) {
            function1.invoke(driverCampaign);
        }
    }

    private final void J() {
        Context context = v().getContext();
        this.f33772k = ActiveCampaignTileType.CIRCLE_K;
        this.f33773l = ActiveCampaignTileViewDelegate.LeftActionMode.CHEVRON;
        u().k(context.getString(R.string.circle_k_loyalty_program_title));
        u().i(context.getString(R.string.circle_k_loyalty_program_description));
        u().j(ContextCompat.getColor(context, R.color.neutral900));
        u().e(ContextCompat.getDrawable(context, R.drawable.round_transparent));
        u().d(Integer.valueOf((int) R.drawable.ic_circle_k));
        u().g(R.color.transparent);
        u().f(0);
    }

    private final void K(final ActiveAndFutureCampaigns activeAndFutureCampaigns) {
        Context context = v().getContext();
        this.f33772k = ActiveCampaignTileType.DRIVER_REFERRAL;
        this.f33773l = ActiveCampaignTileViewDelegate.LeftActionMode.DISMISS;
        u().k(context.getString(R.string.earn_amount, this.f33767f.c()));
        u().i(context.getString(R.string.invite_friends_drive));
        u().j(ContextCompat.getColor(context, R.color.neutral900));
        u().e(ContextCompat.getDrawable(context, R.drawable.circle_purple500));
        u().d(Integer.valueOf((int) R.drawable.ic_gift));
        u().g(R.color.white);
        u().f(8);
        u().h(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.L(WorkStatisticsInnerLayoutDelegate.this, activeAndFutureCampaigns, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(WorkStatisticsInnerLayoutDelegate this$0, ActiveAndFutureCampaigns driverCampaigns, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(driverCampaigns, "$driverCampaigns");
        this$0.f33767f.f(DriverReferralCampaignManager.TileScreen.WORK);
        O(this$0, driverCampaigns, null, 2, null);
    }

    private final void M(OptInGroupSummary optInGroupSummary) {
        Context context = v().getContext();
        this.f33772k = ActiveCampaignTileType.OPT_IN;
        this.f33773l = ActiveCampaignTileViewDelegate.LeftActionMode.CHEVRON;
        u().k(context.getString(R.string.choose_bonus_campaign));
        ActiveCampaignTileViewDelegate u7 = u();
        Intrinsics.e(context, "context");
        u7.i(context.getString(R.string.respond_by_date, CampaignPeriodBadgesConditionsDelegateKt.u(context, optInGroupSummary.a(), false, this.f33763b)));
        u().j(ContextCompat.getColor(context, R.color.neutral900));
        u().e(ContextCompat.getDrawable(context, R.drawable.circle_yellow900));
        u().d(Integer.valueOf((int) R.drawable.ic_opt_in_campaign));
        u().g(R.color.white);
        u().f(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void N(ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns r6, eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig.CircleKLoyaltyCampaignStatus r7) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            r5.f33769h = r6
            r5.f33770i = r7
            r5.r(r6)
            java.util.List r7 = r6.a()
            boolean r7 = r7.isEmpty()
            r0 = 1
            r7 = r7 ^ r0
            r1 = 0
            if (r7 == 0) goto L26
            java.util.List r7 = r6.a()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.W(r7)
            ee.mtakso.driver.network.client.campaign.DriverCampaign r7 = (ee.mtakso.driver.network.client.campaign.DriverCampaign) r7
            r5.z(r7)
            r7 = 1
            goto L27
        L26:
            r7 = 0
        L27:
            java.util.List r2 = r6.c()
            if (r2 == 0) goto L36
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L34
            goto L36
        L34:
            r2 = 0
            goto L37
        L36:
            r2 = 1
        L37:
            if (r2 != 0) goto L53
            java.util.List r7 = r6.c()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.W(r7)
            ee.mtakso.driver.network.client.campaign.OptInGroupSummary r7 = (ee.mtakso.driver.network.client.campaign.OptInGroupSummary) r7
            r5.f33771j = r7
            ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics r2 = r5.f33765d
            long r3 = r7.b()
            r2.t1(r3)
            r5.M(r7)
        L51:
            r7 = 1
            goto L78
        L53:
            boolean r2 = r5.x()
            if (r2 == 0) goto L5d
            r5.J()
            goto L51
        L5d:
            boolean r2 = r5.y(r6)
            if (r2 == 0) goto L78
            ee.mtakso.driver.param.DriverReferralCampaignManager r7 = r5.f33767f
            java.lang.Long r7 = r7.a()
            if (r7 == 0) goto L74
            long r2 = r7.longValue()
            ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics r7 = r5.f33766e
            r7.h0(r2)
        L74:
            r5.K(r6)
            goto L51
        L78:
            int r2 = ee.mtakso.driver.R.id.tileActiveCampaign
            android.view.View r2 = r5.k(r2)
            ee.mtakso.driver.ui.screens.work.t1 r3 = new ee.mtakso.driver.ui.screens.work.t1
            r3.<init>()
            r2.setOnClickListener(r3)
            int r2 = ee.mtakso.driver.R.id.workStatisticsViewAllCampaignsActiveCount
            android.view.View r2 = r5.k(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.view.View r3 = r5.v()
            android.content.Context r3 = r3.getContext()
            r4 = 2131951749(0x7f130085, float:1.9539921E38)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.util.List r6 = r6.a()
            int r6 = r6.size()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0[r1] = r6
            java.lang.String r6 = r3.getString(r4, r0)
            r2.setText(r6)
            if (r7 != 0) goto Lb7
            ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics r6 = r5.f33764c
            r6.d1()
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.work.WorkStatisticsInnerLayoutDelegate.N(ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns, eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig$CircleKLoyaltyCampaignStatus):void");
    }

    static /* synthetic */ void O(WorkStatisticsInnerLayoutDelegate workStatisticsInnerLayoutDelegate, ActiveAndFutureCampaigns activeAndFutureCampaigns, DriverFeaturesConfig.CircleKLoyaltyCampaignStatus circleKLoyaltyCampaignStatus, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            activeAndFutureCampaigns = workStatisticsInnerLayoutDelegate.f33769h;
        }
        if ((i8 & 2) != 0) {
            circleKLoyaltyCampaignStatus = workStatisticsInnerLayoutDelegate.f33770i;
        }
        workStatisticsInnerLayoutDelegate.N(activeAndFutureCampaigns, circleKLoyaltyCampaignStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(WorkStatisticsInnerLayoutDelegate this$0, View view) {
        Long a8;
        Function2<? super ActiveCampaignTileType, ? super Long, Unit> function2;
        Long l8;
        Intrinsics.f(this$0, "this$0");
        ActiveCampaignTileType activeCampaignTileType = this$0.f33772k;
        if (activeCampaignTileType == ActiveCampaignTileType.OPT_IN) {
            OptInGroupSummary optInGroupSummary = this$0.f33771j;
            if (optInGroupSummary != null) {
                this$0.f33765d.s3(optInGroupSummary.b());
            }
        } else if (activeCampaignTileType == ActiveCampaignTileType.DRIVER_REFERRAL && (a8 = this$0.f33767f.a()) != null) {
            this$0.f33766e.I2(a8.longValue());
        }
        ActiveCampaignTileType activeCampaignTileType2 = this$0.f33772k;
        if (activeCampaignTileType2 != null && (function2 = this$0.f33775n) != null) {
            OptInGroupSummary optInGroupSummary2 = this$0.f33771j;
            if (optInGroupSummary2 != null) {
                l8 = Long.valueOf(optInGroupSummary2.b());
            } else {
                l8 = null;
            }
            function2.s(activeCampaignTileType2, l8);
        }
    }

    private final void R(DriverStatisticsSummary driverStatisticsSummary, boolean z7) {
        double b8;
        ((TextView) k(R.id.workStatisticsEarningsText)).setText(driverStatisticsSummary.d());
        if (z7) {
            Double a8 = driverStatisticsSummary.a();
            if (a8 != null) {
                b8 = a8.doubleValue();
            } else {
                b8 = 0.0d;
            }
        } else {
            b8 = driverStatisticsSummary.b();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.getDefault(), "%.0f%%", Arrays.copyOf(new Object[]{Double.valueOf(b8)}, 1));
        Intrinsics.e(format, "format(locale, format, *args)");
        ((TextView) k(R.id.workStatisticsActivityText)).setText(format);
        String format2 = String.format(Locale.UK, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(driverStatisticsSummary.c())}, 1));
        Intrinsics.e(format2, "format(locale, format, *args)");
        ((AppCompatTextView) k(R.id.workStatisticsRatingText)).setText(format2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(WorkStatisticsInnerLayoutDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33764c.x2();
        Function0<Unit> function0 = this$0.f33777p;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(WorkStatisticsInnerLayoutDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function0<Unit> function0 = this$0.f33778q;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(WorkStatisticsInnerLayoutDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function0<Unit> function0 = this$0.f33779r;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(WorkStatisticsInnerLayoutDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function0<Unit> function0 = this$0.f33780s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WorkStatisticsInnerLayoutDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function0<Unit> function0 = this$0.f33781t;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void r(ActiveAndFutureCampaigns activeAndFutureCampaigns) {
        int i8;
        List<OptInGroupSummary> c8 = activeAndFutureCampaigns.c();
        if (c8 != null && !c8.isEmpty()) {
            i8 = 0;
        } else {
            i8 = 1;
        }
        int i9 = i8 ^ 1;
        if (y(activeAndFutureCampaigns)) {
            i9++;
        }
        if (x()) {
            i9++;
        }
        if (!activeAndFutureCampaigns.a().isEmpty()) {
            ConstraintLayout workStatisticsCampaignsLayout = (ConstraintLayout) k(R.id.workStatisticsCampaignsLayout);
            Intrinsics.e(workStatisticsCampaignsLayout, "workStatisticsCampaignsLayout");
            ViewExtKt.e(workStatisticsCampaignsLayout, false, 0, 3, null);
            Group groupDriverCampaigns = (Group) k(R.id.groupDriverCampaigns);
            Intrinsics.e(groupDriverCampaigns, "groupDriverCampaigns");
            ViewExtKt.e(groupDriverCampaigns, false, 0, 3, null);
            if (i9 > 0) {
                View tileActiveCampaign = k(R.id.tileActiveCampaign);
                Intrinsics.e(tileActiveCampaign, "tileActiveCampaign");
                ViewExtKt.e(tileActiveCampaign, false, 0, 3, null);
            } else {
                View tileActiveCampaign2 = k(R.id.tileActiveCampaign);
                Intrinsics.e(tileActiveCampaign2, "tileActiveCampaign");
                ViewExtKt.e(tileActiveCampaign2, false, 0, 2, null);
            }
            if (activeAndFutureCampaigns.a().size() > 1) {
                TextView workStatisticsViewAllCampaignsActiveCount = (TextView) k(R.id.workStatisticsViewAllCampaignsActiveCount);
                Intrinsics.e(workStatisticsViewAllCampaignsActiveCount, "workStatisticsViewAllCampaignsActiveCount");
                ViewExtKt.e(workStatisticsViewAllCampaignsActiveCount, false, 0, 3, null);
            }
        } else {
            Group groupDriverCampaigns2 = (Group) k(R.id.groupDriverCampaigns);
            Intrinsics.e(groupDriverCampaigns2, "groupDriverCampaigns");
            ViewExtKt.e(groupDriverCampaigns2, false, 0, 2, null);
            if (i9 > 0) {
                ConstraintLayout workStatisticsCampaignsLayout2 = (ConstraintLayout) k(R.id.workStatisticsCampaignsLayout);
                Intrinsics.e(workStatisticsCampaignsLayout2, "workStatisticsCampaignsLayout");
                ViewExtKt.e(workStatisticsCampaignsLayout2, false, 0, 3, null);
                View tileActiveCampaign3 = k(R.id.tileActiveCampaign);
                Intrinsics.e(tileActiveCampaign3, "tileActiveCampaign");
                ViewExtKt.e(tileActiveCampaign3, false, 0, 3, null);
                if (i9 > 1) {
                    LinearLayout workStatisticsViewAllCampaignsContainer = (LinearLayout) k(R.id.workStatisticsViewAllCampaignsContainer);
                    Intrinsics.e(workStatisticsViewAllCampaignsContainer, "workStatisticsViewAllCampaignsContainer");
                    ViewExtKt.e(workStatisticsViewAllCampaignsContainer, false, 0, 3, null);
                    View seeAllCampaignSeparator = k(R.id.seeAllCampaignSeparator);
                    Intrinsics.e(seeAllCampaignSeparator, "seeAllCampaignSeparator");
                    ViewExtKt.e(seeAllCampaignSeparator, true, 0, 2, null);
                } else {
                    LinearLayout workStatisticsViewAllCampaignsContainer2 = (LinearLayout) k(R.id.workStatisticsViewAllCampaignsContainer);
                    Intrinsics.e(workStatisticsViewAllCampaignsContainer2, "workStatisticsViewAllCampaignsContainer");
                    ViewExtKt.e(workStatisticsViewAllCampaignsContainer2, false, 0, 2, null);
                }
            } else {
                ConstraintLayout workStatisticsCampaignsLayout3 = (ConstraintLayout) k(R.id.workStatisticsCampaignsLayout);
                Intrinsics.e(workStatisticsCampaignsLayout3, "workStatisticsCampaignsLayout");
                ViewExtKt.e(workStatisticsCampaignsLayout3, false, 0, 2, null);
            }
        }
        this.f33768g.invoke();
    }

    private final ActiveCampaignTileViewDelegate u() {
        return (ActiveCampaignTileViewDelegate) this.f33774m.getValue();
    }

    private final boolean x() {
        if (this.f33770i == DriverFeaturesConfig.CircleKLoyaltyCampaignStatus.AVAILABLE) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean y(ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns r4) {
        /*
            r3 = this;
            ee.mtakso.driver.param.DriverReferralCampaignManager r0 = r3.f33767f
            ee.mtakso.driver.param.DriverReferralCampaignManager$TileScreen r1 = ee.mtakso.driver.param.DriverReferralCampaignManager.TileScreen.WORK
            boolean r0 = r0.g(r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L27
            boolean r4 = r4.b()
            if (r4 == 0) goto L27
            ee.mtakso.driver.param.DriverReferralCampaignManager r4 = r3.f33767f
            java.lang.String r4 = r4.c()
            if (r4 == 0) goto L23
            boolean r4 = kotlin.text.StringsKt.y(r4)
            if (r4 == 0) goto L21
            goto L23
        L21:
            r4 = 0
            goto L24
        L23:
            r4 = 1
        L24:
            if (r4 != 0) goto L27
            goto L28
        L27:
            r1 = 0
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.work.WorkStatisticsInnerLayoutDelegate.y(ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns):boolean");
    }

    private final void z(final DriverCampaign driverCampaign) {
        Context context = v().getContext();
        View k8 = k(R.id.workStatisticsCampaignsDetails);
        TextView campaignTitle = (TextView) k(R.id.campaignTitle);
        ExpandableTextView campaignPeriod = (ExpandableTextView) k(R.id.campaignPeriod);
        LinearLayout campaignBadgeContainer = (LinearLayout) k(R.id.campaignBadgeContainer);
        LinearLayout campaignConditionContainer = (LinearLayout) k(R.id.campaignConditionContainer);
        DateTimeConverter dateTimeConverter = this.f33763b;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkStatisticsInnerLayoutDelegate.A(WorkStatisticsInnerLayoutDelegate.this, driverCampaign, view);
            }
        };
        Intrinsics.e(context, "context");
        Intrinsics.e(campaignTitle, "campaignTitle");
        Intrinsics.e(campaignPeriod, "campaignPeriod");
        Intrinsics.e(campaignBadgeContainer, "campaignBadgeContainer");
        Intrinsics.e(campaignConditionContainer, "campaignConditionContainer");
        CampaignPeriodBadgesConditionsDelegateKt.f(context, k8, campaignTitle, campaignPeriod, (TextView) k(R.id.campaignStatusShortExplanation), (TextView) k(R.id.campaignSpecialLocationText), campaignBadgeContainer, campaignConditionContainer, driverCampaign, dateTimeConverter, onClickListener, (r35 & 2048) != 0 ? false : true, (r35 & 4096) != 0 ? false : false, (r35 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? null : null, (r35 & 16384) != 0 ? null : null, (r35 & 32768) != 0 ? null : null);
    }

    public final void B(Function2<? super ActiveCampaignTileType, ? super Long, Unit> function2) {
        this.f33775n = function2;
    }

    public final void C(Function0<Unit> function0) {
        this.f33777p = function0;
    }

    public final void D(Function1<? super DriverCampaign, Unit> function1) {
        this.f33776o = function1;
    }

    public final void E(Function0<Unit> function0) {
        this.f33779r = function0;
    }

    public final void F(Function0<Unit> function0) {
        this.f33778q = function0;
    }

    public final void G(Function0<Unit> function0) {
        this.f33780s = function0;
    }

    public final void H(Function0<Unit> function0) {
        this.f33781t = function0;
    }

    public final void I(boolean z7, boolean z8) {
        if (z7) {
            t(z8);
        } else {
            s(z8);
        }
    }

    public final void Q(DriverScoreItem driverScoreItem) {
        if (driverScoreItem == null) {
            return;
        }
        ((TextView) k(R.id.driverScoreText)).setText(driverScoreItem.a());
        DriverScoreLabel b8 = driverScoreItem.b();
        int i8 = R.color.purple500;
        if (b8 != null) {
            int i9 = R.id.driverScoreLabel;
            ((TextView) k(i9)).setText(driverScoreItem.b().a());
            int i10 = WhenMappings.f33783a[driverScoreItem.b().b().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                i8 = R.color.white;
                            } else {
                                i8 = R.color.red500;
                            }
                        } else {
                            i8 = R.color.yellow900;
                        }
                    } else {
                        i8 = R.color.green500;
                    }
                }
            } else {
                i8 = R.color.neutral600;
            }
            DrawableCompat.n(((TextView) k(i9)).getBackground(), ResourcesCompat.d(((TextView) k(i9)).getContext().getResources(), i8, ((TextView) k(i9)).getContext().getTheme()));
        } else if (driverScoreItem.c()) {
            int i11 = R.id.driverScoreLabel;
            TextView driverScoreLabel = (TextView) k(i11);
            Intrinsics.e(driverScoreLabel, "driverScoreLabel");
            ViewExtKt.e(driverScoreLabel, true, 0, 2, null);
            ((TextView) k(i11)).setText(((TextView) k(i11)).getContext().getString(R.string.driver_statistic_new_label));
            DrawableCompat.n(((TextView) k(i11)).getBackground(), ResourcesCompat.d(((TextView) k(i11)).getContext().getResources(), R.color.purple500, ((TextView) k(i11)).getContext().getTheme()));
        } else {
            TextView driverScoreLabel2 = (TextView) k(R.id.driverScoreLabel);
            Intrinsics.e(driverScoreLabel2, "driverScoreLabel");
            ViewExtKt.e(driverScoreLabel2, false, 0, 2, null);
        }
    }

    public final void S(DashboardState.Static workState) {
        Intrinsics.f(workState, "workState");
        N(workState.b(), workState.a());
        R(workState.e(), workState.d());
        Q(workState.c());
    }

    @Override // ee.mtakso.driver.ui.screens.work.LoadingView
    public void a() {
        View workStatisticsContentLayout = k(R.id.workStatisticsContentLayout);
        Intrinsics.e(workStatisticsContentLayout, "workStatisticsContentLayout");
        ViewExtKt.e(workStatisticsContentLayout, false, 0, 3, null);
    }

    @Override // ee.mtakso.driver.ui.screens.work.LoadingView
    public void b() {
        View workStatisticsContentLayout = k(R.id.workStatisticsContentLayout);
        Intrinsics.e(workStatisticsContentLayout, "workStatisticsContentLayout");
        ViewExtKt.e(workStatisticsContentLayout, false, 0, 2, null);
    }

    public View k(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33782u;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View v7 = v();
            if (v7 == null || (findViewById = v7.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void s(boolean z7) {
        TextView earningsTextView = (TextView) k(R.id.earningsTextView);
        Intrinsics.e(earningsTextView, "earningsTextView");
        ViewExtKt.e(earningsTextView, z7, 0, 2, null);
        ImageView earningsArrow = (ImageView) k(R.id.earningsArrow);
        Intrinsics.e(earningsArrow, "earningsArrow");
        ViewExtKt.e(earningsArrow, z7, 0, 2, null);
        ConstraintLayout workStatisticsDriverScoreLayout = (ConstraintLayout) k(R.id.workStatisticsDriverScoreLayout);
        Intrinsics.e(workStatisticsDriverScoreLayout, "workStatisticsDriverScoreLayout");
        ViewExtKt.e(workStatisticsDriverScoreLayout, false, 0, 2, null);
        ((TextView) k(R.id.workStatisticsActivityTitle)).setText(R.string.activity_score);
        int i8 = R.id.workStatisticsActivityText;
        ((TextView) k(i8)).setTextColor(ResourcesCompat.d(((TextView) k(i8)).getContext().getResources(), R.color.purple300, ((TextView) k(i8)).getContext().getTheme()));
        TextView workStatisticsActivityLabel = (TextView) k(R.id.workStatisticsActivityLabel);
        Intrinsics.e(workStatisticsActivityLabel, "workStatisticsActivityLabel");
        ViewExtKt.e(workStatisticsActivityLabel, true, 0, 2, null);
        ConstraintLayout workStatisticsRatingsLayout = (ConstraintLayout) k(R.id.workStatisticsRatingsLayout);
        Intrinsics.e(workStatisticsRatingsLayout, "workStatisticsRatingsLayout");
        ViewExtKt.e(workStatisticsRatingsLayout, true, 0, 2, null);
    }

    public final void t(boolean z7) {
        TextView earningsTextView = (TextView) k(R.id.earningsTextView);
        Intrinsics.e(earningsTextView, "earningsTextView");
        ViewExtKt.e(earningsTextView, false, 0, 2, null);
        ImageView earningsArrow = (ImageView) k(R.id.earningsArrow);
        Intrinsics.e(earningsArrow, "earningsArrow");
        ViewExtKt.e(earningsArrow, z7, 0, 2, null);
        ConstraintLayout workStatisticsDriverScoreLayout = (ConstraintLayout) k(R.id.workStatisticsDriverScoreLayout);
        Intrinsics.e(workStatisticsDriverScoreLayout, "workStatisticsDriverScoreLayout");
        ViewExtKt.e(workStatisticsDriverScoreLayout, true, 0, 2, null);
        ((TextView) k(R.id.workStatisticsActivityTitle)).setText(R.string.acceptance_rate);
        int i8 = R.id.workStatisticsActivityText;
        ((TextView) k(i8)).setTextColor(ResourcesCompat.d(((TextView) k(i8)).getContext().getResources(), R.color.neutral800, ((TextView) k(i8)).getContext().getTheme()));
        TextView workStatisticsActivityLabel = (TextView) k(R.id.workStatisticsActivityLabel);
        Intrinsics.e(workStatisticsActivityLabel, "workStatisticsActivityLabel");
        ViewExtKt.e(workStatisticsActivityLabel, false, 0, 2, null);
        ConstraintLayout workStatisticsRatingsLayout = (ConstraintLayout) k(R.id.workStatisticsRatingsLayout);
        Intrinsics.e(workStatisticsRatingsLayout, "workStatisticsRatingsLayout");
        ViewExtKt.e(workStatisticsRatingsLayout, false, 0, 2, null);
    }

    public View v() {
        return this.f33762a;
    }

    public final boolean w() {
        ConstraintLayout workStatisticsCampaignsLayout = (ConstraintLayout) k(R.id.workStatisticsCampaignsLayout);
        Intrinsics.e(workStatisticsCampaignsLayout, "workStatisticsCampaignsLayout");
        if (workStatisticsCampaignsLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
