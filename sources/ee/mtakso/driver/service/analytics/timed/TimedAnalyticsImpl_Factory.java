package ee.mtakso.driver.service.analytics.timed;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TimedAnalyticsImpl_Factory implements Factory<TimedAnalyticsImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TimedAnalyticsManager> f23531a;

    public TimedAnalyticsImpl_Factory(Provider<TimedAnalyticsManager> provider) {
        this.f23531a = provider;
    }

    public static TimedAnalyticsImpl_Factory a(Provider<TimedAnalyticsManager> provider) {
        return new TimedAnalyticsImpl_Factory(provider);
    }

    public static TimedAnalyticsImpl c(TimedAnalyticsManager timedAnalyticsManager) {
        return new TimedAnalyticsImpl(timedAnalyticsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TimedAnalyticsImpl get() {
        return c(this.f23531a.get());
    }
}
