package ee.mtakso.driver.service.push;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class AuthPushService_Factory implements Factory<AuthPushService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushManagerImpl> f25594a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Set<PushHandler>> f25595b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Set<PushTokenHandler>> f25596c;

    public AuthPushService_Factory(Provider<PushManagerImpl> provider, Provider<Set<PushHandler>> provider2, Provider<Set<PushTokenHandler>> provider3) {
        this.f25594a = provider;
        this.f25595b = provider2;
        this.f25596c = provider3;
    }

    public static AuthPushService_Factory a(Provider<PushManagerImpl> provider, Provider<Set<PushHandler>> provider2, Provider<Set<PushTokenHandler>> provider3) {
        return new AuthPushService_Factory(provider, provider2, provider3);
    }

    public static AuthPushService c(PushManagerImpl pushManagerImpl, Set<PushHandler> set, Set<PushTokenHandler> set2) {
        return new AuthPushService(pushManagerImpl, set, set2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthPushService get() {
        return c(this.f25594a.get(), this.f25595b.get(), this.f25596c.get());
    }
}
