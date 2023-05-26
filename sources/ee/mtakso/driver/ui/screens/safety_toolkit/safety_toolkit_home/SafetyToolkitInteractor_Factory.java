package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SafetyToolkitInteractor_Factory implements Factory<SafetyToolkitInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f32817a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverConfig> f32818b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverSettings> f32819c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OrderProvider> f32820d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f32821e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PermissionManager> f32822f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<AudioRecordingManager> f32823g;

    public SafetyToolkitInteractor_Factory(Provider<DriverProvider> provider, Provider<DriverConfig> provider2, Provider<DriverSettings> provider3, Provider<OrderProvider> provider4, Provider<EmergencyAssistManager> provider5, Provider<PermissionManager> provider6, Provider<AudioRecordingManager> provider7) {
        this.f32817a = provider;
        this.f32818b = provider2;
        this.f32819c = provider3;
        this.f32820d = provider4;
        this.f32821e = provider5;
        this.f32822f = provider6;
        this.f32823g = provider7;
    }

    public static SafetyToolkitInteractor_Factory a(Provider<DriverProvider> provider, Provider<DriverConfig> provider2, Provider<DriverSettings> provider3, Provider<OrderProvider> provider4, Provider<EmergencyAssistManager> provider5, Provider<PermissionManager> provider6, Provider<AudioRecordingManager> provider7) {
        return new SafetyToolkitInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SafetyToolkitInteractor c(DriverProvider driverProvider, DriverConfig driverConfig, DriverSettings driverSettings, OrderProvider orderProvider, EmergencyAssistManager emergencyAssistManager, PermissionManager permissionManager, AudioRecordingManager audioRecordingManager) {
        return new SafetyToolkitInteractor(driverProvider, driverConfig, driverSettings, orderProvider, emergencyAssistManager, permissionManager, audioRecordingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SafetyToolkitInteractor get() {
        return c(this.f32817a.get(), this.f32818b.get(), this.f32819c.get(), this.f32820d.get(), this.f32821e.get(), this.f32822f.get(), this.f32823g.get());
    }
}
