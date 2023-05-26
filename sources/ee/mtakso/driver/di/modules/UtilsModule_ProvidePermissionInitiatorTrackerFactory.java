package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import eu.bolt.driver.core.permission.PermissionInitiatorTracker;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UtilsModule_ProvidePermissionInitiatorTrackerFactory implements Factory<PermissionInitiatorTracker> {

    /* renamed from: a  reason: collision with root package name */
    private final UtilsModule f20879a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceSettings> f20880b;

    public UtilsModule_ProvidePermissionInitiatorTrackerFactory(UtilsModule utilsModule, Provider<DeviceSettings> provider) {
        this.f20879a = utilsModule;
        this.f20880b = provider;
    }

    public static UtilsModule_ProvidePermissionInitiatorTrackerFactory a(UtilsModule utilsModule, Provider<DeviceSettings> provider) {
        return new UtilsModule_ProvidePermissionInitiatorTrackerFactory(utilsModule, provider);
    }

    public static PermissionInitiatorTracker c(UtilsModule utilsModule, DeviceSettings deviceSettings) {
        return (PermissionInitiatorTracker) Preconditions.checkNotNullFromProvides(utilsModule.b(deviceSettings));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PermissionInitiatorTracker get() {
        return c(this.f20879a, this.f20880b.get());
    }
}
