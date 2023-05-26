package ee.mtakso.driver.service.auth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PhoneAuthFlow_Factory implements Factory<PhoneAuthFlow> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthStepFactory> f23743a;

    public PhoneAuthFlow_Factory(Provider<AuthStepFactory> provider) {
        this.f23743a = provider;
    }

    public static PhoneAuthFlow_Factory a(Provider<AuthStepFactory> provider) {
        return new PhoneAuthFlow_Factory(provider);
    }

    public static PhoneAuthFlow c(AuthStepFactory authStepFactory) {
        return new PhoneAuthFlow(authStepFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PhoneAuthFlow get() {
        return c(this.f23743a.get());
    }
}
