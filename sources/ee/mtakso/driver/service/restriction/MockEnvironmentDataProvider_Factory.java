package ee.mtakso.driver.service.restriction;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MockEnvironmentDataProvider_Factory implements Factory<MockEnvironmentDataProvider> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MockEnvironmentDataProvider_Factory f25852a = new MockEnvironmentDataProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static MockEnvironmentDataProvider_Factory a() {
        return InstanceHolder.f25852a;
    }

    public static MockEnvironmentDataProvider c() {
        return new MockEnvironmentDataProvider();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MockEnvironmentDataProvider get() {
        return c();
    }
}
