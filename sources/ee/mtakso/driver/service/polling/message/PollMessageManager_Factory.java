package ee.mtakso.driver.service.polling.message;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollMessageManager_Factory implements Factory<PollMessageManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollMessageCache> f25580a;

    public PollMessageManager_Factory(Provider<PollMessageCache> provider) {
        this.f25580a = provider;
    }

    public static PollMessageManager_Factory a(Provider<PollMessageCache> provider) {
        return new PollMessageManager_Factory(provider);
    }

    public static PollMessageManager c(PollMessageCache pollMessageCache) {
        return new PollMessageManager(pollMessageCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollMessageManager get() {
        return c(this.f25580a.get());
    }
}
