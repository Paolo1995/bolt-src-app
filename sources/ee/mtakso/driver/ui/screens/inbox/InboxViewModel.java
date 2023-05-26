package ee.mtakso.driver.ui.screens.inbox;

import android.app.Activity;
import ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.interactor.inbox.InboxItem;
import ee.mtakso.driver.ui.interactor.inbox.InboxItemsInteractor;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersFragment;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InboxViewModel.kt */
/* loaded from: classes3.dex */
public final class InboxViewModel extends BaseViewModel {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f30359k = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final InboxItemsInteractor f30360f;

    /* renamed from: g  reason: collision with root package name */
    private final NewsAnalytics f30361g;

    /* renamed from: h  reason: collision with root package name */
    private final CleverTapManager f30362h;

    /* renamed from: i  reason: collision with root package name */
    private final PartnerOffersAnalytics f30363i;

    /* renamed from: j  reason: collision with root package name */
    private final ObservableLiveData<List<InboxItem>> f30364j;

    /* compiled from: InboxViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public InboxViewModel(InboxItemsInteractor itemsInteractor, NewsAnalytics newsAnalytics, CleverTapManager cleverTapManager, PartnerOffersAnalytics partnerOffersAnalytics) {
        Intrinsics.f(itemsInteractor, "itemsInteractor");
        Intrinsics.f(newsAnalytics, "newsAnalytics");
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        Intrinsics.f(partnerOffersAnalytics, "partnerOffersAnalytics");
        this.f30360f = itemsInteractor;
        this.f30361g = newsAnalytics;
        this.f30362h = cleverTapManager;
        this.f30363i = partnerOffersAnalytics;
        this.f30364j = new ObservableLiveData<>();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        ObservableLiveData.t(this.f30364j, this.f30360f.e(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.inbox.InboxViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                BaseViewModel.A(InboxViewModel.this, it, null, 2, null);
            }
        }, 2, null);
    }

    public final ObservableLiveData<List<InboxItem>> D() {
        return this.f30364j;
    }

    public final void E(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.f30363i.b("inbox page");
        SimpleActivity.Companion.m(SimpleActivity.f27004l, activity, BoltClubListingFragment.class, null, false, 12, null);
    }

    public final void F(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.f30361g.l2();
        SimpleActivity.Companion.m(SimpleActivity.f27004l, activity, ActiveCampaignsFragment.class, null, false, 12, null);
    }

    public final void G(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.f30361g.U1();
        this.f30362h.r(activity);
    }

    public final void H(Activity activity) {
        Intrinsics.f(activity, "activity");
        SimpleActivity.Companion.m(SimpleActivity.f27004l, activity, ScheduledOrdersFragment.class, null, false, 12, null);
    }

    public final void I() {
        this.f30361g.U3();
    }
}
