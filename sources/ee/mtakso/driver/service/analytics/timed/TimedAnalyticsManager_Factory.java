package ee.mtakso.driver.service.analytics.timed;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TimedAnalyticsManager_Factory implements Factory<TimedAnalyticsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Set<TimedConsumer>> f23534a;

    public TimedAnalyticsManager_Factory(Provider<Set<TimedConsumer>> provider) {
        this.f23534a = provider;
    }

    public static TimedAnalyticsManager_Factory a(Provider<Set<TimedConsumer>> provider) {
        return new TimedAnalyticsManager_Factory(provider);
    }

    public static TimedAnalyticsManager c(Set<TimedConsumer> set) {
        return new TimedAnalyticsManager(set);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TimedAnalyticsManager get() {
        return c(this.f23534a.get());
    }
}
