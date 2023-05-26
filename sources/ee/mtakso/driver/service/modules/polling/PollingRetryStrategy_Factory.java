package ee.mtakso.driver.service.modules.polling;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollingRetryStrategy_Factory implements Factory<PollingRetryStrategy> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PollingRetryStrategy_Factory f25137a = new PollingRetryStrategy_Factory();

        private InstanceHolder() {
        }
    }

    public static PollingRetryStrategy_Factory a() {
        return InstanceHolder.f25137a;
    }

    public static PollingRetryStrategy c() {
        return new PollingRetryStrategy();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollingRetryStrategy get() {
        return c();
    }
}
