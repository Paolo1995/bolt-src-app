package ee.mtakso.driver.di;

import dagger.BindsInstance;
import dagger.Component;
import ee.mtakso.App;
import ee.mtakso.driver.di.application.CoroutinesDispatcherModule;
import ee.mtakso.driver.di.application.DriverChatApplicationModule;
import ee.mtakso.driver.di.module.ReleaseGeoModule;
import ee.mtakso.driver.di.modules.AnalyticsModule;
import ee.mtakso.driver.di.modules.AndroidModule;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.di.modules.LogsModule;
import ee.mtakso.driver.di.modules.MapModule;
import ee.mtakso.driver.di.modules.NavigationModule;
import ee.mtakso.driver.di.modules.OnBoardingModule;
import ee.mtakso.driver.di.modules.PushModule;
import ee.mtakso.driver.di.modules.ReleaseDeviceInfoModule;
import ee.mtakso.driver.di.modules.ReleaseNetworkModule;
import ee.mtakso.driver.di.modules.RxSchedulerModule;
import ee.mtakso.driver.di.modules.ServiceModule;
import ee.mtakso.driver.di.modules.TripAudioRecordingModule;
import ee.mtakso.driver.di.modules.UtilsModule;
import ee.mtakso.driver.di.modules.ViewModelModule;
import ee.mtakso.driver.di.modules.VoipModule;
import ee.mtakso.driver.di.modules.WorkerModule;
import eu.bolt.android.chat.ChatDependencyProvider;
import javax.inject.Singleton;

/* compiled from: ReleaseApplicationComponent.kt */
@Component(dependencies = {ChatDependencyProvider.class}, modules = {AnalyticsModule.class, AndroidModule.class, CoroutinesDispatcherModule.class, DriverChatApplicationModule.class, LogsModule.class, MapModule.class, NavigationModule.class, OnBoardingModule.class, PlatformModule.class, PushModule.class, ReleaseDeviceInfoModule.class, ReleaseGeoModule.class, ReleaseNetworkModule.class, RxSchedulerModule.class, ServiceModule.class, TripAudioRecordingModule.class, UtilsModule.class, ViewModelModule.class, VoipModule.class, WorkerModule.class})
@Singleton
/* loaded from: classes3.dex */
public interface ReleaseApplicationComponent extends ApplicationComponent {

    /* compiled from: ReleaseApplicationComponent.kt */
    @Component.Builder
    /* loaded from: classes3.dex */
    public interface Builder extends ApplicationComponent.Builder {
        @Override // ee.mtakso.driver.di.modules.ApplicationComponent.Builder
        @BindsInstance
        /* synthetic */ ApplicationComponent.Builder a(App app);
    }
}
