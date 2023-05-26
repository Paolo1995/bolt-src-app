package ee.mtakso.driver.service.voip.lifecycle.observers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.power.WakeLockManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipProximityManager_Factory implements Factory<VoipProximityManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WakeLockManager> f26167a;

    public VoipProximityManager_Factory(Provider<WakeLockManager> provider) {
        this.f26167a = provider;
    }

    public static VoipProximityManager_Factory a(Provider<WakeLockManager> provider) {
        return new VoipProximityManager_Factory(provider);
    }

    public static VoipProximityManager c(WakeLockManager wakeLockManager) {
        return new VoipProximityManager(wakeLockManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipProximityManager get() {
        return c(this.f26167a.get());
    }
}
