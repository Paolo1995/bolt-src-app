package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MagicTokenRequestInteractor_Factory implements Factory<MagicTokenRequestInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f26483a;

    public MagicTokenRequestInteractor_Factory(Provider<AnonymousAuthClient> provider) {
        this.f26483a = provider;
    }

    public static MagicTokenRequestInteractor_Factory a(Provider<AnonymousAuthClient> provider) {
        return new MagicTokenRequestInteractor_Factory(provider);
    }

    public static MagicTokenRequestInteractor c(AnonymousAuthClient anonymousAuthClient) {
        return new MagicTokenRequestInteractor(anonymousAuthClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MagicTokenRequestInteractor get() {
        return c(this.f26483a.get());
    }
}
