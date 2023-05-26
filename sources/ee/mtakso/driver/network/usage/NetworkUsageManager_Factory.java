package ee.mtakso.driver.network.usage;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkUsageManager_Factory implements Factory<NetworkUsageManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final NetworkUsageManager_Factory f23027a = new NetworkUsageManager_Factory();

        private InstanceHolder() {
        }
    }

    public static NetworkUsageManager_Factory a() {
        return InstanceHolder.f23027a;
    }

    public static NetworkUsageManager c() {
        return new NetworkUsageManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NetworkUsageManager get() {
        return c();
    }
}
