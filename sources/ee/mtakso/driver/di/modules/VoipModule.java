package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractorFactory;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractorFactoryImpl;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipProximityManager;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.IncomingWindowManager;
import ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.OutgoingWindowManager;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;

/* compiled from: VoipModule.kt */
@Module
/* loaded from: classes3.dex */
public interface VoipModule {
    @Binds
    @IntoSet
    VoipLifecycleObserver a(IncomingWindowManager incomingWindowManager);

    @Binds
    @IntoSet
    VoipLifecycleObserver b(VoipActiveWindowTracker voipActiveWindowTracker);

    @Binds
    @IntoSet
    VoipLifecycleObserver c(VoipRxLifecycleTransfromer voipRxLifecycleTransfromer);

    @Binds
    @IntoSet
    VoipLifecycleObserver d(OutgoingWindowManager outgoingWindowManager);

    @Binds
    @IntoSet
    VoipLifecycleObserver e(VoipProximityManager voipProximityManager);

    @Binds
    @IntoSet
    VoipLifecycleObserver f(VoipProximityManager voipProximityManager);

    @Binds
    @IntoSet
    VoipLifecycleObserver g(VoipActiveWindowTracker voipActiveWindowTracker);

    @Binds
    VoipNotificationDrawer h(UiNotificationManager uiNotificationManager);

    @Binds
    VoipInfoExtractorFactory i(VoipInfoExtractorFactoryImpl voipInfoExtractorFactoryImpl);

    @Binds
    @IntoSet
    VoipLifecycleObserver j(VoipRxLifecycleTransfromer voipRxLifecycleTransfromer);
}
