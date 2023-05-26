package ee.mtakso.driver.di.authorised;

import dagger.BindsInstance;
import dagger.Component;
import ee.mtakso.driver.di.AuthorizedPlatformModule;
import ee.mtakso.driver.di.authorised.MainAuthorisedComponent;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.di.modules.PollerModule;
import ee.mtakso.driver.di.modules.TripAudioRecordingModule;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.deeplinks.ExecutableDeeplinkManager;
import eu.bolt.driver.chat.di.DriverChatAutorisedComponent;
import eu.bolt.driver.core.di.scope.authorized.AuthorizedCoreComponent;
import eu.bolt.driver.core.time.AnchoredTimeSource;

/* compiled from: AuthorisedComponent.kt */
@Component(dependencies = {ApplicationComponent.class}, modules = {AuthorisedAnalyticsModule.class, AuthorisedCoreModule.class, AuthorisedNetworkModule.class, AuthorisedServicesModule.class, AuthorisedStaffModule.class, AuthorisedUiModule.class, AuthorizedPlatformModule.class, DebugModule.class, DriverChatAuthorisedModule.class, PushBindings.class, StoriesModule.class, PollerModule.class, TripAudioRecordingModule.class})
/* loaded from: classes3.dex */
public interface AuthorisedComponent extends MainAuthorisedComponent, AuthorizedCoreComponent, DriverChatAutorisedComponent {

    /* compiled from: AuthorisedComponent.kt */
    @Component.Builder
    /* loaded from: classes3.dex */
    public interface Builder extends MainAuthorisedComponent.Builder {
        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        @BindsInstance
        /* synthetic */ MainAuthorisedComponent.Builder a(DriverFeatures driverFeatures);

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        @BindsInstance
        /* synthetic */ MainAuthorisedComponent.Builder b(DriverSettings driverSettings);

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        @BindsInstance
        /* synthetic */ MainAuthorisedComponent.Builder c(AnchoredTimeSource anchoredTimeSource);

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        @BindsInstance
        /* synthetic */ MainAuthorisedComponent.Builder d(DriverConfig driverConfig);
    }

    ExecutableDeeplinkManager y();
}
