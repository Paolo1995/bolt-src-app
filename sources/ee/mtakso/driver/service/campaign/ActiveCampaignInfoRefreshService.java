package ee.mtakso.driver.service.campaign;

import ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignInfo;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveCampaignInfoRefreshService.kt */
/* loaded from: classes3.dex */
public final class ActiveCampaignInfoRefreshService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final CampaignManager f23950b;

    @Inject
    public ActiveCampaignInfoRefreshService(CampaignManager campaignManager) {
        Intrinsics.f(campaignManager, "campaignManager");
        this.f23950b = campaignManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Single j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Single) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<Long> interval = Observable.interval(1L, TimeUnit.MINUTES);
        Intrinsics.e(interval, "interval(1, TimeUnit.MINUTES)");
        Observable g8 = ObservableExtKt.g(interval);
        final Function1<Long, Single<Notification<ActiveAndPendingCampaignInfo>>> function1 = new Function1<Long, Single<Notification<ActiveAndPendingCampaignInfo>>>() { // from class: ee.mtakso.driver.service.campaign.ActiveCampaignInfoRefreshService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Single<Notification<ActiveAndPendingCampaignInfo>> invoke(Long it) {
                CampaignManager campaignManager;
                Intrinsics.f(it, "it");
                campaignManager = ActiveCampaignInfoRefreshService.this.f23950b;
                return campaignManager.v();
            }
        };
        Observable map = g8.map(new Function() { // from class: ee.mtakso.driver.service.campaign.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Single j8;
                j8 = ActiveCampaignInfoRefreshService.j(Function1.this, obj);
                return j8;
            }
        });
        final ActiveCampaignInfoRefreshService$doStart$2 activeCampaignInfoRefreshService$doStart$2 = new Function1<Single<Notification<ActiveAndPendingCampaignInfo>>, Unit>() { // from class: ee.mtakso.driver.service.campaign.ActiveCampaignInfoRefreshService$doStart$2
            public final void b(Single<Notification<ActiveAndPendingCampaignInfo>> single) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Single<Notification<ActiveAndPendingCampaignInfo>> single) {
                b(single);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.campaign.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActiveCampaignInfoRefreshService.k(Function1.this, obj);
            }
        };
        final ActiveCampaignInfoRefreshService$doStart$3 activeCampaignInfoRefreshService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.campaign.ActiveCampaignInfoRefreshService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on ActiveCampaignInfoRefreshService!");
            }
        };
        Disposable subscribe = map.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.campaign.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActiveCampaignInfoRefreshService.l(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …nInfoRefreshService!\") })");
        return subscribe;
    }
}
