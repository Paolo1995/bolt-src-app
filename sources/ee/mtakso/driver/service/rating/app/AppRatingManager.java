package ee.mtakso.driver.service.rating.app;

import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CampaignV2Group;
import ee.mtakso.driver.network.client.campaign.PastCampaignsV2;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.param.RateMeModel;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppRatingManager.kt */
/* loaded from: classes3.dex */
public final class AppRatingManager {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f25792h = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final RateMePrefsManager f25793a;

    /* renamed from: b  reason: collision with root package name */
    private final CampaignClient f25794b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverDestinationsManager f25795c;

    /* renamed from: d  reason: collision with root package name */
    private final GeoLocationManager f25796d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverStatusProvider f25797e;

    /* renamed from: f  reason: collision with root package name */
    private final OrderHistoryManager f25798f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishSubject<RateMeModel> f25799g;

    /* compiled from: AppRatingManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AppRatingManager(RateMePrefsManager rateMePrefsManager, CampaignClient campaignClient, DriverDestinationsManager destinationsManager, GeoLocationManager locationManager, DriverStatusProvider driverStatusProvider, OrderHistoryManager orderHistoryManager) {
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        Intrinsics.f(campaignClient, "campaignClient");
        Intrinsics.f(destinationsManager, "destinationsManager");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(orderHistoryManager, "orderHistoryManager");
        this.f25793a = rateMePrefsManager;
        this.f25794b = campaignClient;
        this.f25795c = destinationsManager;
        this.f25796d = locationManager;
        this.f25797e = driverStatusProvider;
        this.f25798f = orderHistoryManager;
        PublishSubject<RateMeModel> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<RateMeModel>()");
        this.f25799g = e8;
    }

    private final RateMeModel h() {
        if (this.f25793a.p()) {
            return null;
        }
        return this.f25793a.j();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(RateMeModel rateMeModel) {
        this.f25799g.onNext(rateMeModel);
    }

    public final boolean g() {
        if (this.f25793a.l()) {
            return false;
        }
        return true;
    }

    public final Observable<RateMeModel> i() {
        PublishSubject<RateMeModel> publishSubject = this.f25799g;
        RateMeModel h8 = h();
        if (DriverStatusKt.a(this.f25797e.n()) && h8 != null) {
            publishSubject.startWith((PublishSubject<RateMeModel>) h8);
        }
        return publishSubject;
    }

    public final void j() {
        if (!g()) {
            return;
        }
        if (!this.f25793a.m()) {
            Single d8 = SingleExtKt.d(this.f25794b.v(true, 0, 20));
            final Function1<PastCampaignsV2, Unit> function1 = new Function1<PastCampaignsV2, Unit>() { // from class: ee.mtakso.driver.service.rating.app.AppRatingManager$onBecameOffline$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(PastCampaignsV2 pastCampaignsV2) {
                    List<CampaignV2Group> a8 = pastCampaignsV2.a();
                    boolean z7 = false;
                    if (a8 != null && !a8.isEmpty()) {
                        Iterator<T> it = a8.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (!((CampaignV2Group) it.next()).c().isEmpty()) {
                                z7 = true;
                                break;
                            }
                        }
                    }
                    if (z7) {
                        AppRatingManager.this.q(RateMeModel.Campaign.f23225f);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PastCampaignsV2 pastCampaignsV2) {
                    b(pastCampaignsV2);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.rating.app.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AppRatingManager.k(Function1.this, obj);
                }
            };
            final AppRatingManager$onBecameOffline$2 appRatingManager$onBecameOffline$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.rating.app.AppRatingManager$onBecameOffline$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to check past campaigns");
                }
            };
            d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.rating.app.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AppRatingManager.l(Function1.this, obj);
                }
            });
        }
        DriverDestination D = this.f25795c.D();
        Kalev.d("Driver destination: " + D);
        RateMeModel h8 = h();
        if (h8 != null) {
            q(h8);
        }
    }

    public final void m() {
        Double d8;
        GeoCoordinate geoCoordinate;
        if (!g()) {
            return;
        }
        DriverDestination D = this.f25795c.D();
        GeoCoordinate geoCoordinate2 = null;
        if (D != null) {
            d8 = D.c();
        } else {
            d8 = null;
        }
        if (d8 != null && D.d() != null) {
            geoCoordinate = new GeoCoordinate(D.c().doubleValue(), D.d().doubleValue());
        } else {
            geoCoordinate = null;
        }
        GeoLocation q8 = this.f25796d.q();
        if (q8 != null) {
            geoCoordinate2 = q8.e();
        }
        if (geoCoordinate != null && geoCoordinate2 != null && GeoUtils.f36938a.f(geoCoordinate, geoCoordinate2) <= 500.0d) {
            q(RateMeModel.DriveHome.f23226f);
        }
    }

    public final void n(Integer num) {
        if (!this.f25793a.l() && num != null && num.intValue() == 5) {
            Single<Integer> e8 = this.f25798f.e();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: ee.mtakso.driver.service.rating.app.AppRatingManager$onOrderFinished$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(Integer count) {
                    RateMePrefsManager rateMePrefsManager;
                    RateMePrefsManager rateMePrefsManager2;
                    Intrinsics.e(count, "count");
                    if (count.intValue() >= 100) {
                        rateMePrefsManager2 = AppRatingManager.this.f25793a;
                        if (!rateMePrefsManager2.n()) {
                            AppRatingManager.this.r(RateMeModel.HundredRides.f23227f);
                            return;
                        }
                    }
                    if (count.intValue() >= 10) {
                        rateMePrefsManager = AppRatingManager.this.f25793a;
                        if (!rateMePrefsManager.o()) {
                            AppRatingManager.this.r(RateMeModel.TenRides.f23228f);
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num2) {
                    b(num2);
                    return Unit.f50853a;
                }
            };
            Consumer<? super Integer> consumer = new Consumer() { // from class: ee.mtakso.driver.service.rating.app.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AppRatingManager.o(Function1.this, obj);
                }
            };
            final AppRatingManager$onOrderFinished$2 appRatingManager$onOrderFinished$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.rating.app.AppRatingManager$onOrderFinished$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to fetch orders count");
                }
            };
            e8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.rating.app.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AppRatingManager.p(Function1.this, obj);
                }
            });
        }
    }

    public final void r(RateMeModel model) {
        Intrinsics.f(model, "model");
        this.f25793a.r(model);
    }
}
