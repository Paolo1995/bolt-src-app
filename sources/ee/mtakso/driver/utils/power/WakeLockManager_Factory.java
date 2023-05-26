package ee.mtakso.driver.utils.power;

import android.os.PowerManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class WakeLockManager_Factory implements Factory<WakeLockManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PowerManager> f36463a;

    public WakeLockManager_Factory(Provider<PowerManager> provider) {
        this.f36463a = provider;
    }

    public static WakeLockManager_Factory a(Provider<PowerManager> provider) {
        return new WakeLockManager_Factory(provider);
    }

    public static WakeLockManager c(PowerManager powerManager) {
        return new WakeLockManager(powerManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WakeLockManager get() {
        return c(this.f36463a.get());
    }
}
