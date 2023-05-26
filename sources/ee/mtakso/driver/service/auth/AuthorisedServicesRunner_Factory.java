package ee.mtakso.driver.service.auth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.BaseService;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class AuthorisedServicesRunner_Factory implements Factory<AuthorisedServicesRunner> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Set<BaseService>> f23702a;

    public AuthorisedServicesRunner_Factory(Provider<Set<BaseService>> provider) {
        this.f23702a = provider;
    }

    public static AuthorisedServicesRunner_Factory a(Provider<Set<BaseService>> provider) {
        return new AuthorisedServicesRunner_Factory(provider);
    }

    public static AuthorisedServicesRunner c(Set<BaseService> set) {
        return new AuthorisedServicesRunner(set);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthorisedServicesRunner get() {
        return c(this.f23702a.get());
    }
}
