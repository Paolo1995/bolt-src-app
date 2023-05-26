package ee.mtakso.driver.service.polling.message;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollMessageService_Factory implements Factory<PollMessageService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f25585a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PollMessageCache> f25586b;

    public PollMessageService_Factory(Provider<PollerSource> provider, Provider<PollMessageCache> provider2) {
        this.f25585a = provider;
        this.f25586b = provider2;
    }

    public static PollMessageService_Factory a(Provider<PollerSource> provider, Provider<PollMessageCache> provider2) {
        return new PollMessageService_Factory(provider, provider2);
    }

    public static PollMessageService c(PollerSource pollerSource, PollMessageCache pollMessageCache) {
        return new PollMessageService(pollerSource, pollMessageCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollMessageService get() {
        return c(this.f25585a.get(), this.f25586b.get());
    }
}
