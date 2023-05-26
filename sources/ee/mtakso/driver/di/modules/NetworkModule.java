package ee.mtakso.driver.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.network.ClientFactory;
import ee.mtakso.driver.network.adapter.EnumTypeAdapterFactory;
import ee.mtakso.driver.network.adapter.RuntimeTypeAdapterFactory;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.analytics.AnalyticsApi;
import ee.mtakso.driver.network.client.analytics.LeadAnalyticsApi;
import ee.mtakso.driver.network.client.applog.DriverAppLogAnonymousApi;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.campaign.DriverCampaignCondition;
import ee.mtakso.driver.network.client.campaign.DriverCampaignProgressCondition;
import ee.mtakso.driver.network.client.campaign.DriverCampaignThresholdCondition;
import ee.mtakso.driver.network.client.contact.ContactApi;
import ee.mtakso.driver.network.client.contact.ContactOption;
import ee.mtakso.driver.network.client.contact.ContactOptionDeserializer;
import ee.mtakso.driver.network.client.contact.ContactOptionDetailsDeserializer;
import ee.mtakso.driver.network.client.contact.ContactOptionsDetails;
import ee.mtakso.driver.network.client.dashboard.DashboardContentItem;
import ee.mtakso.driver.network.client.dashboard.DashboardContentItemDeserializer;
import ee.mtakso.driver.network.client.dashboard.HomeScreenItem;
import ee.mtakso.driver.network.client.dashboard.HomeScreenItemDeserializer;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import ee.mtakso.driver.network.client.driver.DriverConfigurationApi;
import ee.mtakso.driver.network.client.incident.IncidentReportingApi;
import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponentDeserializer;
import ee.mtakso.driver.network.client.order.modal.ModalAction;
import ee.mtakso.driver.network.client.order.modal.ModalActionDeserializer;
import ee.mtakso.driver.network.client.order.modal.ModalItem;
import ee.mtakso.driver.network.client.order.modal.ModalItemDeserializer;
import ee.mtakso.driver.network.client.partner.PartnerApi;
import ee.mtakso.driver.network.client.priority.ContentItem;
import ee.mtakso.driver.network.client.priority.ContentItemDeserializer;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import ee.mtakso.driver.network.client.support.SupportApi;
import ee.mtakso.driver.network.client.translations.ServiceTranslations;
import ee.mtakso.driver.network.client.translations.TranslationApi;
import ee.mtakso.driver.network.client.translations.TranslationsClient;
import ee.mtakso.driver.network.client.work_time.DriverWorkTimeApi;
import ee.mtakso.driver.network.interceptor.AccessTokenInterceptor;
import ee.mtakso.driver.network.interceptor.LocationInterceptor;
import ee.mtakso.driver.network.interceptor.PartnerAccessTokenInterceptor;
import ee.mtakso.driver.service.translations.TranslationService;
import eu.bolt.driver.chat.network.ChatApi;
import eu.bolt.driver.core.ui.translation.TranslationUpdateProvider;
import eu.bolt.driver.earnings.network.EarningsApi;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/* compiled from: NetworkModule.kt */
@Module(includes = {NetworkBindings.class, LanguageBindings.class})
/* loaded from: classes3.dex */
public final class NetworkModule {
    @Provides
    @Singleton
    public final SupportApi A(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.N(httpClient);
    }

    @Provides
    @Singleton
    public final GsonConverterFactory B(Gson gson) {
        Intrinsics.f(gson, "gson");
        GsonConverterFactory create = GsonConverterFactory.create(gson);
        Intrinsics.e(create, "create(gson)");
        return create;
    }

    @Provides
    @Singleton
    public final IncidentReportingApi C(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.B(httpClient);
    }

    @Provides
    @Singleton
    public final LeadAnalyticsApi D(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.C(httpClient);
    }

    @Provides
    @Singleton
    public final TranslationApi E(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.P(httpClient);
    }

    @Provides
    @Singleton
    public final AudioRecordingUploadAPI F(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.f(httpClient);
    }

    @Provides
    @Singleton
    public final OkHttpClient a(ClientFactory clientFactory, OkHttpClient basic) {
        Intrinsics.f(clientFactory, "clientFactory");
        Intrinsics.f(basic, "basic");
        return clientFactory.a(basic);
    }

    @Provides
    @Singleton
    public final OkHttpClient b(ClientFactory clientFactory, OkHttpClient basic) {
        Intrinsics.f(clientFactory, "clientFactory");
        Intrinsics.f(basic, "basic");
        return clientFactory.b(basic);
    }

    @Provides
    @Singleton
    public final OkHttpClient c(ClientFactory clientFactory, OkHttpClient basic, LocationInterceptor locationInterceptor, AccessTokenInterceptor accessTokenInterceptor) {
        Intrinsics.f(clientFactory, "clientFactory");
        Intrinsics.f(basic, "basic");
        Intrinsics.f(locationInterceptor, "locationInterceptor");
        Intrinsics.f(accessTokenInterceptor, "accessTokenInterceptor");
        return clientFactory.d(basic, locationInterceptor, accessTokenInterceptor);
    }

    @Provides
    @Singleton
    public final ContactApi d(OkHttpClient okhttpClient, ApiFactory factory) {
        Intrinsics.f(okhttpClient, "okhttpClient");
        Intrinsics.f(factory, "factory");
        return factory.n(okhttpClient);
    }

    @Provides
    @Singleton
    public final DriverAppLogAnonymousApi e(OkHttpClient okHttpClient, ApiFactory factory) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Intrinsics.f(factory, "factory");
        return factory.p(okHttpClient);
    }

    @Provides
    @Singleton
    public final DriverAuthAnonymousApi f(ApiFactory factory, OkHttpClient okHttpClient) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(okHttpClient, "okHttpClient");
        return factory.q(okHttpClient);
    }

    @Provides
    @Singleton
    public final DriverConfigurationApi g(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return (DriverConfigurationApi) ApiFactory.d(factory, httpClient, DriverConfigurationApi.class, "https://driver.live.boltsvc.net/", null, 8, null);
    }

    @Provides
    @Singleton
    public final DriverWorkTimeApi h(OkHttpClient okHttpClient, ApiFactory factory) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Intrinsics.f(factory, "factory");
        return factory.v(okHttpClient);
    }

    @Provides
    @Singleton
    public final EarningsBalanceApi i(OkHttpClient okHttpClient, ApiFactory factory) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Intrinsics.f(factory, "factory");
        return factory.x(okHttpClient);
    }

    @Provides
    @Singleton
    public final EarningsGoalApi j(OkHttpClient okHttpClient, ApiFactory factory) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Intrinsics.f(factory, "factory");
        return factory.y(okHttpClient);
    }

    @Provides
    @Singleton
    public final Gson k() {
        Gson create = new GsonBuilder().registerTypeAdapterFactory(new EnumTypeAdapterFactory()).registerTypeAdapterFactory(RuntimeTypeAdapterFactory.e(DriverCampaignCondition.class, "type").f(DriverCampaignThresholdCondition.class, "threshold").f(DriverCampaignProgressCondition.class, "progress")).registerTypeAdapter(ContactOption.class, new ContactOptionDeserializer()).registerTypeAdapter(ContactOptionsDetails.class, new ContactOptionDetailsDeserializer()).registerTypeAdapter(HomeScreenItem.class, new HomeScreenItemDeserializer()).registerTypeAdapter(DashboardContentItem.class, new DashboardContentItemDeserializer()).registerTypeAdapter(ContentItem.class, new ContentItemDeserializer()).registerTypeAdapter(ScheduledRideDetailsComponent.class, new ScheduledRideDetailsComponentDeserializer()).registerTypeAdapter(ModalAction.class, new ModalActionDeserializer()).registerTypeAdapter(ModalItem.class, new ModalItemDeserializer()).create();
        Intrinsics.e(create, "GsonBuilder()\n          …())\n            .create()");
        return create;
    }

    @Provides
    public final SimpleXmlConverterFactory l(Serializer serializer) {
        Intrinsics.f(serializer, "serializer");
        SimpleXmlConverterFactory create = SimpleXmlConverterFactory.create(serializer);
        Intrinsics.e(create, "create(serializer)");
        return create;
    }

    @Provides
    @Singleton
    public final EarningsApi m(OkHttpClient okHttpClient, ApiFactory factory) {
        Intrinsics.f(okHttpClient, "okHttpClient");
        Intrinsics.f(factory, "factory");
        return factory.E(okHttpClient);
    }

    @Provides
    @Singleton
    public final OkHttpClient n(ClientFactory clientFactory, OkHttpClient basic, PartnerAccessTokenInterceptor accessTokenInterceptor) {
        Intrinsics.f(clientFactory, "clientFactory");
        Intrinsics.f(basic, "basic");
        Intrinsics.f(accessTokenInterceptor, "accessTokenInterceptor");
        return clientFactory.f(basic, accessTokenInterceptor);
    }

    @Provides
    @Singleton
    public final Retrofit.Builder o(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.i(httpClient);
    }

    @Provides
    public final Serializer p() {
        RegistryMatcher registryMatcher = new RegistryMatcher();
        registryMatcher.bind(ServiceTranslations.Quantity.class, new ServiceTranslations.QuantityTransform());
        return new Persister(registryMatcher);
    }

    @Provides
    @Singleton
    public final OkHttpClient q(ClientFactory clientFactory, OkHttpClient basic) {
        Intrinsics.f(clientFactory, "clientFactory");
        Intrinsics.f(basic, "basic");
        return clientFactory.g(basic);
    }

    @Provides
    public final TranslationUpdateProvider r(TranslationsClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        return new TranslationService(apiClient);
    }

    @Provides
    @Singleton
    public final OkHttpClient s(ClientFactory clientFactory) {
        Intrinsics.f(clientFactory, "clientFactory");
        return clientFactory.c();
    }

    @Provides
    @Singleton
    public final PartnerApi t(ApiFactory factory, OkHttpClient okhttpClient) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(okhttpClient, "okhttpClient");
        return factory.F(okhttpClient);
    }

    @Provides
    @Singleton
    public final AnonymousAuthApi u(ApiFactory factory, OkHttpClient okhttpClient) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(okhttpClient, "okhttpClient");
        return factory.b(okhttpClient);
    }

    @Provides
    @Singleton
    public final AuthenticatedAuthApi v(OkHttpClient httpClient, ApiFactory apiFactory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(apiFactory, "apiFactory");
        return apiFactory.g(httpClient);
    }

    @Provides
    @Singleton
    public final ChatApi w(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.l(httpClient);
    }

    @Provides
    @Singleton
    public final DeviceInfoApi x(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.o(httpClient);
    }

    @Provides
    @Singleton
    public final DriverRegistrationApi y(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.t(httpClient);
    }

    @Provides
    @Singleton
    public final AnalyticsApi z(OkHttpClient httpClient, ApiFactory factory) {
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(factory, "factory");
        return factory.a(httpClient);
    }
}
