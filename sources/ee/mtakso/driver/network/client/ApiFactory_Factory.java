package ee.mtakso.driver.network.client;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ApiFactory_Factory implements Factory<ApiFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GsonConverterFactory> f21313a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SimpleXmlConverterFactory> f21314b;

    public ApiFactory_Factory(Provider<GsonConverterFactory> provider, Provider<SimpleXmlConverterFactory> provider2) {
        this.f21313a = provider;
        this.f21314b = provider2;
    }

    public static ApiFactory_Factory a(Provider<GsonConverterFactory> provider, Provider<SimpleXmlConverterFactory> provider2) {
        return new ApiFactory_Factory(provider, provider2);
    }

    public static ApiFactory c(GsonConverterFactory gsonConverterFactory, SimpleXmlConverterFactory simpleXmlConverterFactory) {
        return new ApiFactory(gsonConverterFactory, simpleXmlConverterFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ApiFactory get() {
        return c(this.f21313a.get(), this.f21314b.get());
    }
}
