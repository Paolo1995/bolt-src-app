package ee.mtakso.driver.network.client.translations;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TranslationsClient_Factory implements Factory<TranslationsClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TranslationApi> f22890a;

    public TranslationsClient_Factory(Provider<TranslationApi> provider) {
        this.f22890a = provider;
    }

    public static TranslationsClient_Factory a(Provider<TranslationApi> provider) {
        return new TranslationsClient_Factory(provider);
    }

    public static TranslationsClient c(Lazy<TranslationApi> lazy) {
        return new TranslationsClient(lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TranslationsClient get() {
        return c(DoubleCheck.lazy(this.f22890a));
    }
}
