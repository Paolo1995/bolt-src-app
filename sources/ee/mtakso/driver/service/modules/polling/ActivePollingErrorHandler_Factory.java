package ee.mtakso.driver.service.modules.polling;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.auth.AuthManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ActivePollingErrorHandler_Factory implements Factory<ActivePollingErrorHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthManager> f25095a;

    public ActivePollingErrorHandler_Factory(Provider<AuthManager> provider) {
        this.f25095a = provider;
    }

    public static ActivePollingErrorHandler_Factory a(Provider<AuthManager> provider) {
        return new ActivePollingErrorHandler_Factory(provider);
    }

    public static ActivePollingErrorHandler c(AuthManager authManager) {
        return new ActivePollingErrorHandler(authManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActivePollingErrorHandler get() {
        return c(this.f25095a.get());
    }
}
