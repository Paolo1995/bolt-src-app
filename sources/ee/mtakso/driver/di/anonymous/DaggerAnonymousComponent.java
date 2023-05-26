package ee.mtakso.driver.di.anonymous;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.di.modules.ThemeModule;
import ee.mtakso.driver.di.modules.ThemeModule_ProvideThemeHelperFactory;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient_Factory;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient_Factory;
import ee.mtakso.driver.network.client.driver.DriverConfigurationApi;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient_Factory;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient_Factory;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.CompositeResponseTransformer_Factory;
import ee.mtakso.driver.network.response.ExposeResponseTransformer_Factory;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DeviceFeatures_Factory;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthConfigurationBackoffStrategy;
import ee.mtakso.driver.service.auth.AuthConfigurationBackoffStrategy_Factory;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepFactory;
import ee.mtakso.driver.service.auth.AuthStepFactory_Factory;
import ee.mtakso.driver.service.auth.PhoneAuthFlow;
import ee.mtakso.driver.service.auth.PhoneAuthFlow_Factory;
import ee.mtakso.driver.service.auth.StoreVerificationBackoffStrategy_Factory;
import ee.mtakso.driver.service.auth.TempDriverConfigHolder;
import ee.mtakso.driver.service.auth.flow.OTPAuthFlow;
import ee.mtakso.driver.service.auth.flow.OTPAuthFlow_Factory;
import ee.mtakso.driver.service.auth.flow.PartnerConvertAuthFlow;
import ee.mtakso.driver.service.auth.flow.PartnerConvertAuthFlow_Factory;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow_Factory;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoService;
import ee.mtakso.driver.service.geo.GeoService_Factory;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.interactor.defaultcountry.DefaultCountryInteractor;
import ee.mtakso.driver.ui.interactor.defaultcountry.DefaultCountryInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.DriverSessionExpireMessageInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverSessionExpireMessageInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.MagicTokenRequestInteractor;
import ee.mtakso.driver.ui.interactor.driver.MagicTokenRequestInteractor_Factory;
import ee.mtakso.driver.ui.screens.AnonymousSimpleActivity;
import ee.mtakso.driver.ui.screens.AnonymousSimpleActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment_Factory;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel_Factory;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment_Factory;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerViewModel;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerViewModel_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingStepFragment;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingStepFragment_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingStepsResolver_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingViewModel_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.processing.DocumentsProcessingFragment;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.processing.DocumentsProcessingFragment_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceControllersFactory;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceControllersFactory_Factory;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment_Factory;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingFragment;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingFragment_Factory;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingViewModel;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment_Factory;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment_Factory;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v3.common.SharedLoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.common.SharedLoginV3ViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationFragment;
import ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationFragment_Factory;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3Fragment_Factory;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3ViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment_Factory;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment_Factory;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment_Factory;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel_Factory;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.signup.SignUpViewModel;
import ee.mtakso.driver.ui.screens.signup.SignUpViewModel_Factory;
import ee.mtakso.driver.ui.screens.update.MandatoryUpdateFragment;
import ee.mtakso.driver.ui.screens.update.MandatoryUpdateFragment_Factory;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.ui.views.webview.WebViewTracker_Factory;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.AppResolver_Factory;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import ee.mtakso.driver.utils.ChromeUrlLauncher;
import ee.mtakso.driver.utils.ChromeUrlLauncher_Factory;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher_Factory;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher_Factory;
import ee.mtakso.driver.utils.UrlFactory;
import ee.mtakso.driver.utils.UrlFactory_Factory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.theme.AppThemeManager_Factory;
import eu.bolt.driver.core.theme.ThemeHelper;
import eu.bolt.driver.core.time.SystemUptimeSource_Factory;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import java.util.Map;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@DaggerGenerated
/* loaded from: classes3.dex */
public final class DaggerAnonymousComponent {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class AnonymousComponentImpl implements AnonymousComponent {
        private Provider<CleverTapManager> A;
        private Provider<ThemeHelper> A0;
        private Provider<SignUpViewModel> B;
        private Provider<AppThemeManager> B0;
        private Provider<DeepLinkManager> C;
        private Provider<BaseUiDependencies> C0;
        private Provider<AnonymousAuthApi> D;
        private Provider<DocumentsOnBoardingStepFragment> D0;
        private Provider<CompositeResponseTransformer> E;
        private Provider<DocumentsProcessingFragment> E0;
        private Provider<DriverAuthAnonymousApi> F;
        private Provider<LandingFragment> F0;
        private Provider<StoreIntegrityVerificationResultToRequestMapper> G;
        private Provider<LandingV3Fragment> G0;
        private Provider<AnonymousAuthClient> H;
        private Provider<AppResolver> H0;
        private Provider<PartnerClient> I;
        private Provider<PasswordLoginFragment> I0;
        private Provider<AuthenticatedAuthApi> J;
        private Provider<LoginV3Fragment> J0;
        private Provider<ResponseErrorProcessor> K;
        private Provider<PasswordLoginV3Fragment> K0;
        private Provider<AuthenticatedAuthClient> L;
        private Provider<EmailLoginFragment> L0;
        private Provider<DriverRegistrationApi> M;
        private Provider<EmailVerificationFragment> M0;
        private Provider<DriverRegistrationClient> N;
        private Provider<VerificationFragment> N0;
        private Provider<TranslationManager> O;
        private Provider<FragmentFactory> O0;
        private Provider<DriverProvider> P;
        private Provider<VerificationV3Fragment> P0;
        private Provider<PlatformAvailabilityManager> Q;
        private Provider<CountryPickerFragment> Q0;
        private Provider<DeviceFeatures> R;
        private Provider<AuthenticateFragment> R0;
        private Provider<GeoLocationManager> S;
        private Provider<MandatoryUpdateFragment> S0;
        private Provider<CoroutineDispatcher> T;
        private Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> T0;
        private Provider<DriverConfigurationApi> U;
        private Provider<DriverConfigurationClient> V;
        private Provider<TempDriverConfigHolder> W;
        private Provider<StoreIntegrityCheck> X;
        private Provider<TrueTimeProvider> Y;
        private Provider<AuthConfigurationBackoffStrategy> Z;

        /* renamed from: a  reason: collision with root package name */
        private final ApplicationComponent f20182a;

        /* renamed from: a0  reason: collision with root package name */
        private Provider<PlatformManager> f20183a0;

        /* renamed from: b  reason: collision with root package name */
        private final AnonymousUiModule f20184b;

        /* renamed from: b0  reason: collision with root package name */
        private Provider<AuthStepFactory> f20185b0;

        /* renamed from: c  reason: collision with root package name */
        private final ThemeModule f20186c;

        /* renamed from: c0  reason: collision with root package name */
        private Provider<PartnerTokenManager> f20187c0;

        /* renamed from: d  reason: collision with root package name */
        private final AnonymousComponentImpl f20188d;

        /* renamed from: d0  reason: collision with root package name */
        private Provider<PasswordAuthFlow> f20189d0;

        /* renamed from: e  reason: collision with root package name */
        private Provider<LoginAnalytics> f20190e;

        /* renamed from: e0  reason: collision with root package name */
        private Provider<PasswordLoginViewModel> f20191e0;

        /* renamed from: f  reason: collision with root package name */
        private Provider<DeviceSettings> f20192f;

        /* renamed from: f0  reason: collision with root package name */
        private Provider<DefaultCountryInteractor> f20193f0;

        /* renamed from: g  reason: collision with root package name */
        private Provider<DriverSessionExpireMessageInteractor> f20194g;

        /* renamed from: g0  reason: collision with root package name */
        private Provider<PhoneAuthFlow> f20195g0;

        /* renamed from: h  reason: collision with root package name */
        private Provider<Context> f20196h;

        /* renamed from: h0  reason: collision with root package name */
        private Provider<LoginV3ViewModel> f20197h0;

        /* renamed from: i  reason: collision with root package name */
        private Provider<SystemUrlLauncher> f20198i;

        /* renamed from: i0  reason: collision with root package name */
        private Provider<PasswordLoginV3ViewModel> f20199i0;

        /* renamed from: j  reason: collision with root package name */
        private Provider<ChromeUrlLauncher> f20200j;

        /* renamed from: j0  reason: collision with root package name */
        private Provider<MagicTokenRequestInteractor> f20201j0;

        /* renamed from: k  reason: collision with root package name */
        private Provider<CompositeChromeFirstUrlLauncher> f20202k;

        /* renamed from: k0  reason: collision with root package name */
        private Provider<EmailLoginViewModel> f20203k0;

        /* renamed from: l  reason: collision with root package name */
        private Provider<DeviceInfo> f20204l;

        /* renamed from: l0  reason: collision with root package name */
        private Provider<FilesUriProvider> f20205l0;

        /* renamed from: m  reason: collision with root package name */
        private Provider<LanguageManager> f20206m;

        /* renamed from: m0  reason: collision with root package name */
        private Provider<SourceControllersFactory> f20207m0;

        /* renamed from: n  reason: collision with root package name */
        private Provider<UrlFactory> f20208n;

        /* renamed from: n0  reason: collision with root package name */
        private Provider<DocumentsScannerViewModel> f20209n0;

        /* renamed from: o  reason: collision with root package name */
        private Provider<StartUpTracing> f20210o;

        /* renamed from: o0  reason: collision with root package name */
        private Provider<DocumentsOnBoardingViewModel> f20211o0;

        /* renamed from: p  reason: collision with root package name */
        private Provider<LandingViewModel> f20212p;

        /* renamed from: p0  reason: collision with root package name */
        private Provider<ConfirmationCodeRetriever> f20213p0;

        /* renamed from: q  reason: collision with root package name */
        private Provider<RoutingManager> f20214q;

        /* renamed from: q0  reason: collision with root package name */
        private Provider<GeoService> f20215q0;

        /* renamed from: r  reason: collision with root package name */
        private Provider<AuthManager> f20216r;

        /* renamed from: r0  reason: collision with root package name */
        private Provider<VerificationViewModel> f20217r0;

        /* renamed from: s  reason: collision with root package name */
        private Provider<LandingV3ViewModel> f20218s;

        /* renamed from: s0  reason: collision with root package name */
        private Provider<OTPAuthFlow> f20219s0;

        /* renamed from: t  reason: collision with root package name */
        private Provider<PushManagerImpl> f20220t;

        /* renamed from: t0  reason: collision with root package name */
        private Provider<VerificationV3ViewModel> f20221t0;

        /* renamed from: u  reason: collision with root package name */
        private Provider<WebViewAnalytics> f20222u;

        /* renamed from: u0  reason: collision with root package name */
        private Provider<PartnerConvertAuthFlow> f20223u0;

        /* renamed from: v  reason: collision with root package name */
        private Provider<WebViewStrategy> f20224v;

        /* renamed from: v0  reason: collision with root package name */
        private Provider<AuthenticateViewModel> f20225v0;

        /* renamed from: w  reason: collision with root package name */
        private Provider<WebViewTracker> f20226w;

        /* renamed from: w0  reason: collision with root package name */
        private Provider<ScreenAnalytics> f20227w0;

        /* renamed from: x  reason: collision with root package name */
        private Provider<AppsflyerManager> f20228x;

        /* renamed from: x0  reason: collision with root package name */
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> f20229x0;

        /* renamed from: y  reason: collision with root package name */
        private Provider<AdvertiserIdProvider> f20230y;

        /* renamed from: y0  reason: collision with root package name */
        private Provider<ViewModelFactory> f20231y0;

        /* renamed from: z  reason: collision with root package name */
        private Provider<SignUpAnalytics> f20232z;

        /* renamed from: z0  reason: collision with root package name */
        private Provider<PermissionManager> f20233z0;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AdvertiserIdProviderProvider implements Provider<AdvertiserIdProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20234a;

            AdvertiserIdProviderProvider(ApplicationComponent applicationComponent) {
                this.f20234a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AdvertiserIdProvider get() {
                return (AdvertiserIdProvider) Preconditions.checkNotNullFromComponent(this.f20234a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AttributionProvider implements Provider<AppsflyerManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20235a;

            AttributionProvider(ApplicationComponent applicationComponent) {
                this.f20235a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AppsflyerManager get() {
                return (AppsflyerManager) Preconditions.checkNotNullFromComponent(this.f20235a.x1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AuthApi2Provider implements Provider<AuthenticatedAuthApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20236a;

            AuthApi2Provider(ApplicationComponent applicationComponent) {
                this.f20236a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AuthenticatedAuthApi get() {
                return (AuthenticatedAuthApi) Preconditions.checkNotNullFromComponent(this.f20236a.b0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AuthApi3Provider implements Provider<DriverAuthAnonymousApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20237a;

            AuthApi3Provider(ApplicationComponent applicationComponent) {
                this.f20237a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverAuthAnonymousApi get() {
                return (DriverAuthAnonymousApi) Preconditions.checkNotNullFromComponent(this.f20237a.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AuthApiProvider implements Provider<AnonymousAuthApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20238a;

            AuthApiProvider(ApplicationComponent applicationComponent) {
                this.f20238a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AnonymousAuthApi get() {
                return (AnonymousAuthApi) Preconditions.checkNotNullFromComponent(this.f20238a.o());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AuthManagerProvider implements Provider<AuthManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20239a;

            AuthManagerProvider(ApplicationComponent applicationComponent) {
                this.f20239a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AuthManager get() {
                return (AuthManager) Preconditions.checkNotNullFromComponent(this.f20239a.w0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class CleverTapProvider implements Provider<CleverTapManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20240a;

            CleverTapProvider(ApplicationComponent applicationComponent) {
                this.f20240a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CleverTapManager get() {
                return (CleverTapManager) Preconditions.checkNotNullFromComponent(this.f20240a.G1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ContextProvider implements Provider<Context> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20241a;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.f20241a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.f20241a.A0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DateTimeProviderProvider implements Provider<TrueTimeProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20242a;

            DateTimeProviderProvider(ApplicationComponent applicationComponent) {
                this.f20242a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TrueTimeProvider get() {
                return (TrueTimeProvider) Preconditions.checkNotNullFromComponent(this.f20242a.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeepLinkManagerProvider implements Provider<DeepLinkManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20243a;

            DeepLinkManagerProvider(ApplicationComponent applicationComponent) {
                this.f20243a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeepLinkManager get() {
                return (DeepLinkManager) Preconditions.checkNotNullFromComponent(this.f20243a.Z());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeviceProvider implements Provider<DeviceInfo> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20244a;

            DeviceProvider(ApplicationComponent applicationComponent) {
                this.f20244a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeviceInfo get() {
                return (DeviceInfo) Preconditions.checkNotNullFromComponent(this.f20244a.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeviceSettingsProvider implements Provider<DeviceSettings> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20245a;

            DeviceSettingsProvider(ApplicationComponent applicationComponent) {
                this.f20245a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeviceSettings get() {
                return (DeviceSettings) Preconditions.checkNotNullFromComponent(this.f20245a.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverConfigApiProvider implements Provider<DriverConfigurationApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20246a;

            DriverConfigApiProvider(ApplicationComponent applicationComponent) {
                this.f20246a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverConfigurationApi get() {
                return (DriverConfigurationApi) Preconditions.checkNotNullFromComponent(this.f20246a.l1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverProviderProvider implements Provider<DriverProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20247a;

            DriverProviderProvider(ApplicationComponent applicationComponent) {
                this.f20247a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverProvider get() {
                return (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20247a.t());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class HackProvider implements Provider<TempDriverConfigHolder> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20248a;

            HackProvider(ApplicationComponent applicationComponent) {
                this.f20248a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TempDriverConfigHolder get() {
                return (TempDriverConfigHolder) Preconditions.checkNotNullFromComponent(this.f20248a.U());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class IntegrityCheckProvider implements Provider<StoreIntegrityCheck> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20249a;

            IntegrityCheckProvider(ApplicationComponent applicationComponent) {
                this.f20249a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public StoreIntegrityCheck get() {
                return (StoreIntegrityCheck) Preconditions.checkNotNullFromComponent(this.f20249a.q1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class IntegrityResultMapperProvider implements Provider<StoreIntegrityVerificationResultToRequestMapper> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20250a;

            IntegrityResultMapperProvider(ApplicationComponent applicationComponent) {
                this.f20250a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public StoreIntegrityVerificationResultToRequestMapper get() {
                return (StoreIntegrityVerificationResultToRequestMapper) Preconditions.checkNotNullFromComponent(this.f20250a.H());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class IoDispatcherProvider implements Provider<CoroutineDispatcher> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20251a;

            IoDispatcherProvider(ApplicationComponent applicationComponent) {
                this.f20251a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.checkNotNullFromComponent(this.f20251a.O1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LanguageManagerProvider implements Provider<LanguageManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20252a;

            LanguageManagerProvider(ApplicationComponent applicationComponent) {
                this.f20252a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LanguageManager get() {
                return (LanguageManager) Preconditions.checkNotNullFromComponent(this.f20252a.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LocationManagerProvider implements Provider<GeoLocationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20253a;

            LocationManagerProvider(ApplicationComponent applicationComponent) {
                this.f20253a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public GeoLocationManager get() {
                return (GeoLocationManager) Preconditions.checkNotNullFromComponent(this.f20253a.o1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LoginAnalyticsV2Provider implements Provider<LoginAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20254a;

            LoginAnalyticsV2Provider(ApplicationComponent applicationComponent) {
                this.f20254a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LoginAnalytics get() {
                return (LoginAnalytics) Preconditions.checkNotNullFromComponent(this.f20254a.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PartnerClientProvider implements Provider<PartnerClient> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20255a;

            PartnerClientProvider(ApplicationComponent applicationComponent) {
                this.f20255a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PartnerClient get() {
                return (PartnerClient) Preconditions.checkNotNullFromComponent(this.f20255a.r0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PartnerTokenManagerProvider implements Provider<PartnerTokenManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20256a;

            PartnerTokenManagerProvider(ApplicationComponent applicationComponent) {
                this.f20256a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PartnerTokenManager get() {
                return (PartnerTokenManager) Preconditions.checkNotNullFromComponent(this.f20256a.e1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PermissionManagerProvider implements Provider<PermissionManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20257a;

            PermissionManagerProvider(ApplicationComponent applicationComponent) {
                this.f20257a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PermissionManager get() {
                return (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20257a.i0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PlatformCheckerProvider implements Provider<PlatformAvailabilityManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20258a;

            PlatformCheckerProvider(ApplicationComponent applicationComponent) {
                this.f20258a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PlatformAvailabilityManager get() {
                return (PlatformAvailabilityManager) Preconditions.checkNotNullFromComponent(this.f20258a.z1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PlatformManagerProvider implements Provider<PlatformManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20259a;

            PlatformManagerProvider(ApplicationComponent applicationComponent) {
                this.f20259a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PlatformManager get() {
                return (PlatformManager) Preconditions.checkNotNullFromComponent(this.f20259a.D1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PushManagerImplProvider implements Provider<PushManagerImpl> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20260a;

            PushManagerImplProvider(ApplicationComponent applicationComponent) {
                this.f20260a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PushManagerImpl get() {
                return (PushManagerImpl) Preconditions.checkNotNullFromComponent(this.f20260a.v());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class RegistrationProvider implements Provider<DriverRegistrationApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20261a;

            RegistrationProvider(ApplicationComponent applicationComponent) {
                this.f20261a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverRegistrationApi get() {
                return (DriverRegistrationApi) Preconditions.checkNotNullFromComponent(this.f20261a.Z0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ResponseProcessorProvider implements Provider<ResponseErrorProcessor> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20262a;

            ResponseProcessorProvider(ApplicationComponent applicationComponent) {
                this.f20262a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ResponseErrorProcessor get() {
                return (ResponseErrorProcessor) Preconditions.checkNotNullFromComponent(this.f20262a.Q1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class RouterProvider implements Provider<RoutingManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20263a;

            RouterProvider(ApplicationComponent applicationComponent) {
                this.f20263a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RoutingManager get() {
                return (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20263a.A());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ScreenAnalyticsProvider implements Provider<ScreenAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20264a;

            ScreenAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20264a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ScreenAnalytics get() {
                return (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20264a.J1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SignUpAnalyticsProvider implements Provider<SignUpAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20265a;

            SignUpAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20265a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SignUpAnalytics get() {
                return (SignUpAnalytics) Preconditions.checkNotNullFromComponent(this.f20265a.a0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SmsRetrieverProvider implements Provider<ConfirmationCodeRetriever> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20266a;

            SmsRetrieverProvider(ApplicationComponent applicationComponent) {
                this.f20266a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ConfirmationCodeRetriever get() {
                return (ConfirmationCodeRetriever) Preconditions.checkNotNullFromComponent(this.f20266a.Y());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class StartUpTracingProvider implements Provider<StartUpTracing> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20267a;

            StartUpTracingProvider(ApplicationComponent applicationComponent) {
                this.f20267a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public StartUpTracing get() {
                return (StartUpTracing) Preconditions.checkNotNullFromComponent(this.f20267a.m());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class TranslationManagerProvider implements Provider<TranslationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20268a;

            TranslationManagerProvider(ApplicationComponent applicationComponent) {
                this.f20268a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TranslationManager get() {
                return (TranslationManager) Preconditions.checkNotNullFromComponent(this.f20268a.X0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class WebViewAnalyticsProvider implements Provider<WebViewAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20269a;

            WebViewAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20269a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public WebViewAnalytics get() {
                return (WebViewAnalytics) Preconditions.checkNotNullFromComponent(this.f20269a.s1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class WebViewStrategyProvider implements Provider<WebViewStrategy> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20270a;

            WebViewStrategyProvider(ApplicationComponent applicationComponent) {
                this.f20270a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public WebViewStrategy get() {
                return (WebViewStrategy) Preconditions.checkNotNullFromComponent(this.f20270a.f0());
            }
        }

        private AnonymousComponentImpl(AnonymousUiModule anonymousUiModule, ThemeModule themeModule, AnonymousStaffModule anonymousStaffModule, ApplicationComponent applicationComponent) {
            this.f20188d = this;
            this.f20182a = applicationComponent;
            this.f20184b = anonymousUiModule;
            this.f20186c = themeModule;
            l(anonymousUiModule, themeModule, anonymousStaffModule, applicationComponent);
        }

        private AppThemeManager a() {
            return new AppThemeManager((Context) Preconditions.checkNotNullFromComponent(this.f20182a.A0()), (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20182a.A()), t());
        }

        private ChromeCustomTabsUrlLauncher i() {
            return new ChromeCustomTabsUrlLauncher((Context) Preconditions.checkNotNullFromComponent(this.f20182a.A0()));
        }

        private CompositeUrlLauncher j() {
            return new CompositeUrlLauncher(i(), s());
        }

        private DeviceFeatures k() {
            return new DeviceFeatures((Context) Preconditions.checkNotNullFromComponent(this.f20182a.A0()));
        }

        private void l(AnonymousUiModule anonymousUiModule, ThemeModule themeModule, AnonymousStaffModule anonymousStaffModule, ApplicationComponent applicationComponent) {
            this.f20190e = new LoginAnalyticsV2Provider(applicationComponent);
            DeviceSettingsProvider deviceSettingsProvider = new DeviceSettingsProvider(applicationComponent);
            this.f20192f = deviceSettingsProvider;
            this.f20194g = DriverSessionExpireMessageInteractor_Factory.a(deviceSettingsProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.f20196h = contextProvider;
            this.f20198i = SystemUrlLauncher_Factory.a(contextProvider);
            ChromeUrlLauncher_Factory a8 = ChromeUrlLauncher_Factory.a(this.f20196h);
            this.f20200j = a8;
            this.f20202k = CompositeChromeFirstUrlLauncher_Factory.a(this.f20198i, a8);
            this.f20204l = new DeviceProvider(applicationComponent);
            LanguageManagerProvider languageManagerProvider = new LanguageManagerProvider(applicationComponent);
            this.f20206m = languageManagerProvider;
            this.f20208n = UrlFactory_Factory.a(this.f20204l, languageManagerProvider);
            StartUpTracingProvider startUpTracingProvider = new StartUpTracingProvider(applicationComponent);
            this.f20210o = startUpTracingProvider;
            this.f20212p = LandingViewModel_Factory.a(this.f20190e, this.f20194g, this.f20202k, this.f20208n, startUpTracingProvider);
            this.f20214q = new RouterProvider(applicationComponent);
            AuthManagerProvider authManagerProvider = new AuthManagerProvider(applicationComponent);
            this.f20216r = authManagerProvider;
            this.f20218s = LandingV3ViewModel_Factory.a(this.f20190e, this.f20194g, this.f20192f, this.f20210o, this.f20214q, authManagerProvider);
            this.f20220t = new PushManagerImplProvider(applicationComponent);
            this.f20222u = new WebViewAnalyticsProvider(applicationComponent);
            WebViewStrategyProvider webViewStrategyProvider = new WebViewStrategyProvider(applicationComponent);
            this.f20224v = webViewStrategyProvider;
            this.f20226w = WebViewTracker_Factory.a(this.f20222u, webViewStrategyProvider);
            this.f20228x = new AttributionProvider(applicationComponent);
            this.f20230y = new AdvertiserIdProviderProvider(applicationComponent);
            this.f20232z = new SignUpAnalyticsProvider(applicationComponent);
            CleverTapProvider cleverTapProvider = new CleverTapProvider(applicationComponent);
            this.A = cleverTapProvider;
            this.B = SignUpViewModel_Factory.a(this.f20192f, this.f20208n, this.f20220t, this.f20216r, this.f20210o, this.f20226w, this.f20228x, this.f20230y, this.f20232z, cleverTapProvider);
            this.C = new DeepLinkManagerProvider(applicationComponent);
            this.D = new AuthApiProvider(applicationComponent);
            this.E = CompositeResponseTransformer_Factory.a(ExposeResponseTransformer_Factory.a());
            this.F = new AuthApi3Provider(applicationComponent);
            this.G = new IntegrityResultMapperProvider(applicationComponent);
            this.H = AnonymousAuthClient_Factory.a(this.f20204l, this.D, this.E, SystemUptimeSource_Factory.a(), this.F, this.G);
            this.I = new PartnerClientProvider(applicationComponent);
            this.J = new AuthApi2Provider(applicationComponent);
            ResponseProcessorProvider responseProcessorProvider = new ResponseProcessorProvider(applicationComponent);
            this.K = responseProcessorProvider;
            this.L = AuthenticatedAuthClient_Factory.a(this.f20204l, this.f20192f, this.J, this.E, responseProcessorProvider);
            RegistrationProvider registrationProvider = new RegistrationProvider(applicationComponent);
            this.M = registrationProvider;
            this.N = DriverRegistrationClient_Factory.a(registrationProvider, this.E);
            this.O = new TranslationManagerProvider(applicationComponent);
            this.P = new DriverProviderProvider(applicationComponent);
            this.Q = new PlatformCheckerProvider(applicationComponent);
            this.R = DeviceFeatures_Factory.a(this.f20196h);
            this.S = new LocationManagerProvider(applicationComponent);
            this.T = new IoDispatcherProvider(applicationComponent);
            DriverConfigApiProvider driverConfigApiProvider = new DriverConfigApiProvider(applicationComponent);
            this.U = driverConfigApiProvider;
            this.V = DriverConfigurationClient_Factory.a(this.T, driverConfigApiProvider);
            this.W = new HackProvider(applicationComponent);
            this.X = new IntegrityCheckProvider(applicationComponent);
            DateTimeProviderProvider dateTimeProviderProvider = new DateTimeProviderProvider(applicationComponent);
            this.Y = dateTimeProviderProvider;
            this.Z = AuthConfigurationBackoffStrategy_Factory.a(dateTimeProviderProvider);
            this.f20183a0 = new PlatformManagerProvider(applicationComponent);
            this.f20185b0 = AuthStepFactory_Factory.a(this.f20196h, this.C, this.H, this.I, this.L, this.N, this.O, this.f20216r, this.f20220t, this.P, this.f20192f, this.f20206m, this.Q, this.R, this.S, this.V, this.W, this.X, StoreVerificationBackoffStrategy_Factory.a(), this.Z, this.f20183a0);
            PartnerTokenManagerProvider partnerTokenManagerProvider = new PartnerTokenManagerProvider(applicationComponent);
            this.f20187c0 = partnerTokenManagerProvider;
            Provider<PasswordAuthFlow> provider = DoubleCheck.provider(PasswordAuthFlow_Factory.a(this.f20185b0, this.f20192f, partnerTokenManagerProvider));
            this.f20189d0 = provider;
            this.f20191e0 = PasswordLoginViewModel_Factory.a(provider, this.f20208n, this.f20198i, this.f20190e, this.f20216r, this.S, this.f20192f);
            this.f20193f0 = DefaultCountryInteractor_Factory.a(this.f20196h);
            this.f20195g0 = PhoneAuthFlow_Factory.a(this.f20185b0);
            this.f20197h0 = LoginV3ViewModel_Factory.a(this.f20190e, this.f20214q, SystemUptimeSource_Factory.a(), this.f20193f0, this.f20195g0, this.f20192f);
            this.f20199i0 = PasswordLoginV3ViewModel_Factory.a(this.f20189d0, this.f20208n, this.f20198i, this.f20190e, this.f20216r, this.S);
            MagicTokenRequestInteractor_Factory a9 = MagicTokenRequestInteractor_Factory.a(this.H);
            this.f20201j0 = a9;
            this.f20203k0 = EmailLoginViewModel_Factory.a(a9, this.f20190e);
            FilesUriProvider_Factory a10 = FilesUriProvider_Factory.a(this.f20196h);
            this.f20205l0 = a10;
            SourceControllersFactory_Factory a11 = SourceControllersFactory_Factory.a(a10);
            this.f20207m0 = a11;
            this.f20209n0 = DocumentsScannerViewModel_Factory.a(a11, this.f20205l0);
            this.f20211o0 = DocumentsOnBoardingViewModel_Factory.a(DocumentsOnBoardingStepsResolver_Factory.a());
            this.f20213p0 = new SmsRetrieverProvider(applicationComponent);
            this.f20215q0 = GeoService_Factory.a(this.S);
            this.f20217r0 = VerificationViewModel_Factory.a(this.f20189d0, SystemUptimeSource_Factory.a(), this.H, this.f20213p0, this.S, this.f20215q0);
            Provider<OTPAuthFlow> provider2 = DoubleCheck.provider(OTPAuthFlow_Factory.a(this.f20185b0, this.f20192f, this.f20187c0));
            this.f20219s0 = provider2;
            this.f20221t0 = VerificationV3ViewModel_Factory.a(provider2, SystemUptimeSource_Factory.a(), this.H, this.f20190e, this.f20216r, this.S, this.f20214q, this.f20213p0, this.f20215q0);
            Provider<PartnerConvertAuthFlow> provider3 = DoubleCheck.provider(PartnerConvertAuthFlow_Factory.a(this.f20185b0, this.f20192f, this.f20187c0));
            this.f20223u0 = provider3;
            this.f20225v0 = AuthenticateViewModel_Factory.a(provider3, this.H, this.f20190e, this.f20216r, this.S);
            this.f20227w0 = new ScreenAnalyticsProvider(applicationComponent);
            MapProviderFactory build = MapProviderFactory.builder(14).put((MapProviderFactory.Builder) LandingViewModel.class, (Provider) this.f20212p).put((MapProviderFactory.Builder) SharedLoginV3ViewModel.class, (Provider) SharedLoginV3ViewModel_Factory.a()).put((MapProviderFactory.Builder) LandingV3ViewModel.class, (Provider) this.f20218s).put((MapProviderFactory.Builder) SignUpViewModel.class, (Provider) this.B).put((MapProviderFactory.Builder) PasswordLoginViewModel.class, (Provider) this.f20191e0).put((MapProviderFactory.Builder) LoginV3ViewModel.class, (Provider) this.f20197h0).put((MapProviderFactory.Builder) PasswordLoginV3ViewModel.class, (Provider) this.f20199i0).put((MapProviderFactory.Builder) EmailLoginViewModel.class, (Provider) this.f20203k0).put((MapProviderFactory.Builder) DocumentsScannerViewModel.class, (Provider) this.f20209n0).put((MapProviderFactory.Builder) DocumentsOnBoardingViewModel.class, (Provider) this.f20211o0).put((MapProviderFactory.Builder) VerificationViewModel.class, (Provider) this.f20217r0).put((MapProviderFactory.Builder) VerificationV3ViewModel.class, (Provider) this.f20221t0).put((MapProviderFactory.Builder) CountryPickerViewModel.class, (Provider) CountryPickerViewModel_Factory.a()).put((MapProviderFactory.Builder) AuthenticateViewModel.class, (Provider) this.f20225v0).build();
            this.f20229x0 = build;
            this.f20231y0 = AnonymousUiModule_ProvideAnonViewModelFactoryFactory.a(anonymousUiModule, build);
            this.f20233z0 = new PermissionManagerProvider(applicationComponent);
            ThemeModule_ProvideThemeHelperFactory a12 = ThemeModule_ProvideThemeHelperFactory.a(themeModule, this.P);
            this.A0 = a12;
            AppThemeManager_Factory a13 = AppThemeManager_Factory.a(this.f20196h, this.f20214q, a12);
            this.B0 = a13;
            AnonymousStaffModule_ProvideAnonymousUiDependenciesFactory a14 = AnonymousStaffModule_ProvideAnonymousUiDependenciesFactory.a(anonymousStaffModule, this.f20227w0, this.f20231y0, this.f20233z0, a13);
            this.C0 = a14;
            this.D0 = DocumentsOnBoardingStepFragment_Factory.a(a14);
            this.E0 = DocumentsProcessingFragment_Factory.a(this.C0);
            this.F0 = LandingFragment_Factory.a(this.f20214q, this.f20227w0, this.f20231y0, this.f20233z0, this.B0);
            this.G0 = LandingV3Fragment_Factory.a(this.f20227w0, this.f20231y0, this.f20233z0, this.B0);
            AppResolver_Factory a15 = AppResolver_Factory.a(this.f20196h, this.f20183a0);
            this.H0 = a15;
            this.I0 = PasswordLoginFragment_Factory.a(this.f20227w0, this.f20231y0, this.f20233z0, this.B0, a15, this.f20183a0, this.f20214q);
            this.J0 = LoginV3Fragment_Factory.a(this.C0, this.f20214q);
            this.K0 = PasswordLoginV3Fragment_Factory.a(this.C0, this.H0, this.f20183a0, this.f20214q);
            this.L0 = EmailLoginFragment_Factory.a(this.C0);
            this.M0 = EmailVerificationFragment_Factory.a(this.C0);
            this.N0 = new DelegateFactory();
            DelegateFactory delegateFactory = new DelegateFactory();
            this.O0 = delegateFactory;
            this.P0 = VerificationV3Fragment_Factory.a(this.C0, delegateFactory, this.H0, this.f20183a0);
            this.Q0 = CountryPickerFragment_Factory.a(this.C0);
            this.R0 = AuthenticateFragment_Factory.a(this.C0, this.H0, this.f20183a0);
            this.S0 = MandatoryUpdateFragment_Factory.a(this.C0, this.f20198i, this.f20206m);
            MapProviderFactory build2 = MapProviderFactory.builder(14).put((MapProviderFactory.Builder) DocumentsOnBoardingStepFragment.class, (Provider) this.D0).put((MapProviderFactory.Builder) DocumentsProcessingFragment.class, (Provider) this.E0).put((MapProviderFactory.Builder) LandingFragment.class, (Provider) this.F0).put((MapProviderFactory.Builder) LandingV3Fragment.class, (Provider) this.G0).put((MapProviderFactory.Builder) PasswordLoginFragment.class, (Provider) this.I0).put((MapProviderFactory.Builder) LoginV3Fragment.class, (Provider) this.J0).put((MapProviderFactory.Builder) PasswordLoginV3Fragment.class, (Provider) this.K0).put((MapProviderFactory.Builder) EmailLoginFragment.class, (Provider) this.L0).put((MapProviderFactory.Builder) EmailVerificationFragment.class, (Provider) this.M0).put((MapProviderFactory.Builder) VerificationFragment.class, (Provider) this.N0).put((MapProviderFactory.Builder) VerificationV3Fragment.class, (Provider) this.P0).put((MapProviderFactory.Builder) CountryPickerFragment.class, (Provider) this.Q0).put((MapProviderFactory.Builder) AuthenticateFragment.class, (Provider) this.R0).put((MapProviderFactory.Builder) MandatoryUpdateFragment.class, (Provider) this.S0).build();
            this.T0 = build2;
            DelegateFactory.setDelegate(this.O0, AnonymousUiModule_ProvideAnonFragmentFactoryFactory.a(anonymousUiModule, build2));
            DelegateFactory.setDelegate(this.N0, VerificationFragment_Factory.a(this.f20227w0, this.f20231y0, this.f20233z0, this.B0, this.O0));
        }

        private AnonymousSimpleActivity m(AnonymousSimpleActivity anonymousSimpleActivity) {
            AnonymousSimpleActivity_MembersInjector.b(anonymousSimpleActivity, b());
            AnonymousSimpleActivity_MembersInjector.a(anonymousSimpleActivity, a());
            return anonymousSimpleActivity;
        }

        private DocumentsOnBoardingActivity n(DocumentsOnBoardingActivity documentsOnBoardingActivity) {
            BaseMvvmActivity_MembersInjector.c(documentsOnBoardingActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20182a.J1()));
            BaseMvvmActivity_MembersInjector.d(documentsOnBoardingActivity, u());
            BaseMvvmActivity_MembersInjector.b(documentsOnBoardingActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20182a.i0()));
            BaseMvvmActivity_MembersInjector.a(documentsOnBoardingActivity, b());
            return documentsOnBoardingActivity;
        }

        private DocumentsScannerActivity o(DocumentsScannerActivity documentsScannerActivity) {
            BaseMvvmActivity_MembersInjector.c(documentsScannerActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20182a.J1()));
            BaseMvvmActivity_MembersInjector.d(documentsScannerActivity, u());
            BaseMvvmActivity_MembersInjector.b(documentsScannerActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20182a.i0()));
            BaseMvvmActivity_MembersInjector.a(documentsScannerActivity, b());
            return documentsScannerActivity;
        }

        private SignUpActivity p(SignUpActivity signUpActivity) {
            SignUpActivity_MembersInjector.h(signUpActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20182a.J1()));
            SignUpActivity_MembersInjector.k(signUpActivity, u());
            SignUpActivity_MembersInjector.g(signUpActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20182a.i0()));
            SignUpActivity_MembersInjector.f(signUpActivity, b());
            SignUpActivity_MembersInjector.j(signUpActivity, j());
            SignUpActivity_MembersInjector.i(signUpActivity, s());
            SignUpActivity_MembersInjector.e(signUpActivity, (EnvironmentDataProvider) Preconditions.checkNotNullFromComponent(this.f20182a.I1()));
            SignUpActivity_MembersInjector.a(signUpActivity, new DeepLinkParser());
            SignUpActivity_MembersInjector.c(signUpActivity, k());
            SignUpActivity_MembersInjector.d(signUpActivity, (DeviceSettings) Preconditions.checkNotNullFromComponent(this.f20182a.M()));
            SignUpActivity_MembersInjector.b(signUpActivity, d());
            return signUpActivity;
        }

        private Map<Class<? extends Fragment>, Provider<Fragment>> q() {
            return MapBuilder.newMapBuilder(14).put(DocumentsOnBoardingStepFragment.class, this.D0).put(DocumentsProcessingFragment.class, this.E0).put(LandingFragment.class, this.F0).put(LandingV3Fragment.class, this.G0).put(PasswordLoginFragment.class, this.I0).put(LoginV3Fragment.class, this.J0).put(PasswordLoginV3Fragment.class, this.K0).put(EmailLoginFragment.class, this.L0).put(EmailVerificationFragment.class, this.M0).put(VerificationFragment.class, this.N0).put(VerificationV3Fragment.class, this.P0).put(CountryPickerFragment.class, this.Q0).put(AuthenticateFragment.class, this.R0).put(MandatoryUpdateFragment.class, this.S0).build();
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> r() {
            return MapBuilder.newMapBuilder(14).put(LandingViewModel.class, this.f20212p).put(SharedLoginV3ViewModel.class, SharedLoginV3ViewModel_Factory.a()).put(LandingV3ViewModel.class, this.f20218s).put(SignUpViewModel.class, this.B).put(PasswordLoginViewModel.class, this.f20191e0).put(LoginV3ViewModel.class, this.f20197h0).put(PasswordLoginV3ViewModel.class, this.f20199i0).put(EmailLoginViewModel.class, this.f20203k0).put(DocumentsScannerViewModel.class, this.f20209n0).put(DocumentsOnBoardingViewModel.class, this.f20211o0).put(VerificationViewModel.class, this.f20217r0).put(VerificationV3ViewModel.class, this.f20221t0).put(CountryPickerViewModel.class, CountryPickerViewModel_Factory.a()).put(AuthenticateViewModel.class, this.f20225v0).build();
        }

        private SystemUrlLauncher s() {
            return new SystemUrlLauncher((Context) Preconditions.checkNotNullFromComponent(this.f20182a.A0()));
        }

        private ThemeHelper t() {
            return ThemeModule_ProvideThemeHelperFactory.c(this.f20186c, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20182a.t()));
        }

        private ViewModelFactory u() {
            return AnonymousUiModule_ProvideAnonViewModelFactoryFactory.c(this.f20184b, r());
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public FragmentFactory b() {
            return AnonymousUiModule_ProvideAnonFragmentFactoryFactory.c(this.f20184b, q());
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public RoutingManager c() {
            return (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20182a.A());
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public DeeplinkDelegate d() {
            return new DeeplinkDelegate(new DeepLinkParser(), (DeepLinkManager) Preconditions.checkNotNullFromComponent(this.f20182a.Z()), j(), (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20182a.A()));
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public void e(AnonymousSimpleActivity anonymousSimpleActivity) {
            m(anonymousSimpleActivity);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public void f(DocumentsScannerActivity documentsScannerActivity) {
            o(documentsScannerActivity);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public void g(SignUpActivity signUpActivity) {
            p(signUpActivity);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousComponent
        public void h(DocumentsOnBoardingActivity documentsOnBoardingActivity) {
            n(documentsOnBoardingActivity);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private AnonymousUiModule f20271a;

        /* renamed from: b  reason: collision with root package name */
        private ThemeModule f20272b;

        /* renamed from: c  reason: collision with root package name */
        private AnonymousStaffModule f20273c;

        /* renamed from: d  reason: collision with root package name */
        private ApplicationComponent f20274d;

        private Builder() {
        }

        public Builder a(ApplicationComponent applicationComponent) {
            this.f20274d = (ApplicationComponent) Preconditions.checkNotNull(applicationComponent);
            return this;
        }

        public AnonymousComponent b() {
            if (this.f20271a == null) {
                this.f20271a = new AnonymousUiModule();
            }
            if (this.f20272b == null) {
                this.f20272b = new ThemeModule();
            }
            if (this.f20273c == null) {
                this.f20273c = new AnonymousStaffModule();
            }
            Preconditions.checkBuilderRequirement(this.f20274d, ApplicationComponent.class);
            return new AnonymousComponentImpl(this.f20271a, this.f20272b, this.f20273c, this.f20274d);
        }
    }

    private DaggerAnonymousComponent() {
    }

    public static Builder a() {
        return new Builder();
    }
}
