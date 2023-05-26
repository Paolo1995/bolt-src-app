package ee.mtakso.driver.di.authorised;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingNetworkAPI;
import ee.mtakso.driver.network.client.boltclub.BoltClubApi;
import ee.mtakso.driver.network.client.campaign.CampaignApi;
import ee.mtakso.driver.network.client.campaign.CircleKApi;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationApi;
import ee.mtakso.driver.network.client.driver.WaybillApi;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationApi;
import ee.mtakso.driver.network.client.earnings.EarningsApi;
import ee.mtakso.driver.network.client.earnings.PayoutApi;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistApi;
import ee.mtakso.driver.network.client.geo.GeoApi;
import ee.mtakso.driver.network.client.modal.ModalApi;
import ee.mtakso.driver.network.client.order.DriverOrderApi;
import ee.mtakso.driver.network.client.order.RideHistoryApi;
import ee.mtakso.driver.network.client.payments.EarningsPaymentApi;
import ee.mtakso.driver.network.client.price.PriceReviewApi;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingApi;
import ee.mtakso.driver.network.client.score.DriverScoreApi;
import ee.mtakso.driver.network.client.search.SearchApi;
import ee.mtakso.driver.network.client.training.TrainingApi;
import ee.mtakso.driver.network.client.vehicle.CarApplicationApi;
import ee.mtakso.driver.network.client.voip.VoipApi;
import eu.bolt.driver.stories.network.StoriesApi;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* compiled from: AuthorisedNetworkModule.kt */
@Module
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule {
    @Provides
    public final AudioRecordingNetworkAPI a(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.e(httpClient);
    }

    @Provides
    public final BoltClubApi b(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.h(httpClient);
    }

    @Provides
    public final Retrofit.Builder c(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.i(httpClient);
    }

    @Provides
    public final CarApplicationApi d(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.k(httpClient);
    }

    @Provides
    public final DriverNavigationConfigurationApi e(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.r(httpClient);
    }

    @Provides
    public final DriverOrderApi f(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return (DriverOrderApi) ApiFactory.d(factory, httpClient, DriverOrderApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    @Provides
    public final DriverPricingConfigurationApi g(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.s(httpClient);
    }

    @Provides
    public final EmergencyAssistApi h(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.z(httpClient);
    }

    @Provides
    public final EarningsPaymentApi i(OkHttpClient okhttpClient, ApiFactory factory) {
        Intrinsics.f(okhttpClient, "okhttpClient");
        Intrinsics.f(factory, "factory");
        return factory.G(okhttpClient);
    }

    @Provides
    public final RouteSharingApi j(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.K(httpClient);
    }

    @Provides
    public final VoipApi k(OkHttpClient okhttpClient, ApiFactory factory) {
        Intrinsics.f(okhttpClient, "okhttpClient");
        Intrinsics.f(factory, "factory");
        return factory.Q(okhttpClient);
    }

    @Provides
    public final WaybillApi l(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.R(httpClient);
    }

    @Provides
    public final CampaignApi m(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.j(httpClient);
    }

    @Provides
    public final CircleKApi n(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.m(httpClient);
    }

    @Provides
    public final DriverScoreApi o(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.u(httpClient);
    }

    @Provides
    public final GeoApi p(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.A(httpClient);
    }

    @Provides
    public final EarningsApi q(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.w(httpClient);
    }

    @Provides
    public final ModalApi r(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.D(httpClient);
    }

    @Provides
    public final PayoutApi s(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.H(httpClient);
    }

    @Provides
    public final PriceReviewApi t(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.I(httpClient);
    }

    @Provides
    public final RideHistoryApi u(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.J(httpClient);
    }

    @Provides
    public final SearchApi v(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.L(httpClient);
    }

    @Provides
    public final StoriesApi w(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.M(httpClient);
    }

    @Provides
    public final TrainingApi x(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.O(httpClient);
    }
}
