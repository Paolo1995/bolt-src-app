package ee.mtakso.driver.service.analytics.event;

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
public final class AnalyticsManager_Factory implements Factory<AnalyticsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Set<AnalyticsConsumer>> f23470a;

    public AnalyticsManager_Factory(Provider<Set<AnalyticsConsumer>> provider) {
        this.f23470a = provider;
    }

    public static AnalyticsManager_Factory a(Provider<Set<AnalyticsConsumer>> provider) {
        return new AnalyticsManager_Factory(provider);
    }

    public static AnalyticsManager c(Set<AnalyticsConsumer> set) {
        return new AnalyticsManager(set);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnalyticsManager get() {
        return c(this.f23470a.get());
    }
}
