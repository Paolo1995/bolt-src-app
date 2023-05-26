package ee.mtakso.driver.service.integration.clevertap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CleverTapManager_Factory implements Factory<CleverTapManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final CleverTapManager_Factory f24545a = new CleverTapManager_Factory();

        private InstanceHolder() {
        }
    }

    public static CleverTapManager_Factory a() {
        return InstanceHolder.f24545a;
    }

    public static CleverTapManager c() {
        return new CleverTapManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CleverTapManager get() {
        return c();
    }
}
