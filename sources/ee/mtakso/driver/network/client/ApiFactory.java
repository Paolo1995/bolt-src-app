package ee.mtakso.driver.network.client;

import ee.mtakso.driver.network.client.analytics.AnalyticsApi;
import ee.mtakso.driver.network.client.analytics.LeadAnalyticsApi;
import ee.mtakso.driver.network.client.applog.DriverAppLogAnonymousApi;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingNetworkAPI;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.boltclub.BoltClubApi;
import ee.mtakso.driver.network.client.campaign.CampaignApi;
import ee.mtakso.driver.network.client.campaign.CircleKApi;
import ee.mtakso.driver.network.client.contact.ContactApi;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationApi;
import ee.mtakso.driver.network.client.driver.WaybillApi;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationApi;
import ee.mtakso.driver.network.client.earnings.PayoutApi;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistApi;
import ee.mtakso.driver.network.client.geo.GeoApi;
import ee.mtakso.driver.network.client.incident.IncidentReportingApi;
import ee.mtakso.driver.network.client.modal.ModalApi;
import ee.mtakso.driver.network.client.order.RideHistoryApi;
import ee.mtakso.driver.network.client.partner.PartnerApi;
import ee.mtakso.driver.network.client.payments.EarningsPaymentApi;
import ee.mtakso.driver.network.client.price.PriceReviewApi;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingApi;
import ee.mtakso.driver.network.client.score.DriverScoreApi;
import ee.mtakso.driver.network.client.search.SearchApi;
import ee.mtakso.driver.network.client.support.SupportApi;
import ee.mtakso.driver.network.client.training.TrainingApi;
import ee.mtakso.driver.network.client.translations.TranslationApi;
import ee.mtakso.driver.network.client.vehicle.CarApplicationApi;
import ee.mtakso.driver.network.client.voip.VoipApi;
import ee.mtakso.driver.network.client.work_time.DriverWorkTimeApi;
import eu.bolt.driver.chat.network.ChatApi;
import eu.bolt.driver.earnings.network.EarningsApi;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import eu.bolt.driver.stories.network.StoriesApi;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/* compiled from: ApiFactory.kt */
/* loaded from: classes3.dex */
public final class ApiFactory {

    /* renamed from: a  reason: collision with root package name */
    private final GsonConverterFactory f21310a;

    /* renamed from: b  reason: collision with root package name */
    private final SimpleXmlConverterFactory f21311b;

    /* renamed from: c  reason: collision with root package name */
    private final RxJava2CallAdapterFactory f21312c;

    @Inject
    public ApiFactory(GsonConverterFactory jsonConverterFactory, SimpleXmlConverterFactory xmlConverterFactory) {
        Intrinsics.f(jsonConverterFactory, "jsonConverterFactory");
        Intrinsics.f(xmlConverterFactory, "xmlConverterFactory");
        this.f21310a = jsonConverterFactory;
        this.f21311b = xmlConverterFactory;
        this.f21312c = RxJava2CallAdapterFactory.create();
    }

    public static /* synthetic */ Object d(ApiFactory apiFactory, OkHttpClient okHttpClient, Class cls, String str, Converter.Factory factory, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str = "https://node.bolt.eu/";
        }
        if ((i8 & 8) != 0) {
            factory = apiFactory.f21310a;
        }
        return apiFactory.c(okHttpClient, cls, str, factory);
    }

    public final GeoApi A(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (GeoApi) d(this, okHttpClient, GeoApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final IncidentReportingApi B(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (IncidentReportingApi) d(this, okHttpClient, IncidentReportingApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final LeadAnalyticsApi C(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (LeadAnalyticsApi) d(this, okHttpClient, LeadAnalyticsApi.class, null, null, 12, null);
    }

    public final ModalApi D(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (ModalApi) d(this, okHttpClient, ModalApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final EarningsApi E(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (EarningsApi) d(this, okHttpClient, EarningsApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final PartnerApi F(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (PartnerApi) d(this, okHttpClient, PartnerApi.class, null, null, 12, null);
    }

    public final EarningsPaymentApi G(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (EarningsPaymentApi) d(this, okHttpClient, EarningsPaymentApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final PayoutApi H(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (PayoutApi) d(this, okHttpClient, PayoutApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final PriceReviewApi I(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (PriceReviewApi) d(this, okHttpClient, PriceReviewApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final RideHistoryApi J(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (RideHistoryApi) d(this, okHttpClient, RideHistoryApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final RouteSharingApi K(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (RouteSharingApi) d(this, okHttpClient, RouteSharingApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final SearchApi L(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (SearchApi) d(this, okHttpClient, SearchApi.class, null, null, 12, null);
    }

    public final StoriesApi M(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (StoriesApi) d(this, okHttpClient, StoriesApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final SupportApi N(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (SupportApi) d(this, okHttpClient, SupportApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final TrainingApi O(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (TrainingApi) d(this, okHttpClient, TrainingApi.class, null, null, 12, null);
    }

    public final TranslationApi P(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (TranslationApi) d(this, okHttpClient, TranslationApi.class, null, this.f21311b, 4, null);
    }

    public final VoipApi Q(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (VoipApi) d(this, okHttpClient, VoipApi.class, null, null, 12, null);
    }

    public final WaybillApi R(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (WaybillApi) d(this, okHttpClient, WaybillApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final AnalyticsApi a(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (AnalyticsApi) d(this, okHttpClient, AnalyticsApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final AnonymousAuthApi b(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (AnonymousAuthApi) d(this, okHttpClient, AnonymousAuthApi.class, null, null, 12, null);
    }

    public final <T> T c(OkHttpClient okHttpClient, Class<T> apiClass, String baseUrl, Converter.Factory converterFactory) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Intrinsics.f(apiClass, "apiClass");
        Intrinsics.f(baseUrl, "baseUrl");
        Intrinsics.f(converterFactory, "converterFactory");
        return (T) new Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl).addCallAdapterFactory(this.f21312c).addConverterFactory(converterFactory).validateEagerly(false).build().create(apiClass);
    }

    public final AudioRecordingNetworkAPI e(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (AudioRecordingNetworkAPI) d(this, okHttpClient, AudioRecordingNetworkAPI.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final AudioRecordingUploadAPI f(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Object create = new Retrofit.Builder().client(okHttpClient).baseUrl("https://driver.live.boltsvc.net/").build().create(AudioRecordingUploadAPI.class);
        Intrinsics.e(create, "retrofit.create(AudioRec…ingUploadAPI::class.java)");
        return (AudioRecordingUploadAPI) create;
    }

    public final AuthenticatedAuthApi g(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (AuthenticatedAuthApi) d(this, okHttpClient, AuthenticatedAuthApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final BoltClubApi h(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (BoltClubApi) d(this, okHttpClient, BoltClubApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final Retrofit.Builder i(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Retrofit.Builder client = new Retrofit.Builder().client(okHttpClient);
        Intrinsics.e(client, "Builder()\n            .client(okHttpClient)");
        return client;
    }

    public final CampaignApi j(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (CampaignApi) d(this, okHttpClient, CampaignApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final CarApplicationApi k(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (CarApplicationApi) d(this, okHttpClient, CarApplicationApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final ChatApi l(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (ChatApi) d(this, okHttpClient, ChatApi.class, null, null, 12, null);
    }

    public final CircleKApi m(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (CircleKApi) d(this, okHttpClient, CircleKApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final ContactApi n(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (ContactApi) d(this, okHttpClient, ContactApi.class, null, null, 12, null);
    }

    public final DeviceInfoApi o(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DeviceInfoApi) d(this, okHttpClient, DeviceInfoApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final DriverAppLogAnonymousApi p(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        GsonConverterFactory create = GsonConverterFactory.create();
        Intrinsics.e(create, "create()");
        return (DriverAppLogAnonymousApi) c(okHttpClient, DriverAppLogAnonymousApi.class, "https://driver.live.boltsvc.net/", create);
    }

    public final DriverAuthAnonymousApi q(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DriverAuthAnonymousApi) d(this, okHttpClient, DriverAuthAnonymousApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final DriverNavigationConfigurationApi r(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DriverNavigationConfigurationApi) d(this, okHttpClient, DriverNavigationConfigurationApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final DriverPricingConfigurationApi s(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DriverPricingConfigurationApi) d(this, okHttpClient, DriverPricingConfigurationApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final DriverRegistrationApi t(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DriverRegistrationApi) d(this, okHttpClient, DriverRegistrationApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final DriverScoreApi u(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DriverScoreApi) d(this, okHttpClient, DriverScoreApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final DriverWorkTimeApi v(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (DriverWorkTimeApi) d(this, okHttpClient, DriverWorkTimeApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final ee.mtakso.driver.network.client.earnings.EarningsApi w(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (ee.mtakso.driver.network.client.earnings.EarningsApi) d(this, okHttpClient, ee.mtakso.driver.network.client.earnings.EarningsApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final EarningsBalanceApi x(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (EarningsBalanceApi) d(this, okHttpClient, EarningsBalanceApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final EarningsGoalApi y(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (EarningsGoalApi) d(this, okHttpClient, EarningsGoalApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    public final EmergencyAssistApi z(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        return (EmergencyAssistApi) d(this, okHttpClient, EmergencyAssistApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }
}
