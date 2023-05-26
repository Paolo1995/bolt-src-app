package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import org.simpleframework.xml.Serializer;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideJaxbConverterFactoryFactory implements Factory<SimpleXmlConverterFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20799a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Serializer> f20800b;

    public NetworkModule_ProvideJaxbConverterFactoryFactory(NetworkModule networkModule, Provider<Serializer> provider) {
        this.f20799a = networkModule;
        this.f20800b = provider;
    }

    public static NetworkModule_ProvideJaxbConverterFactoryFactory a(NetworkModule networkModule, Provider<Serializer> provider) {
        return new NetworkModule_ProvideJaxbConverterFactoryFactory(networkModule, provider);
    }

    public static SimpleXmlConverterFactory c(NetworkModule networkModule, Serializer serializer) {
        return (SimpleXmlConverterFactory) Preconditions.checkNotNullFromProvides(networkModule.l(serializer));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SimpleXmlConverterFactory get() {
        return c(this.f20799a, this.f20800b.get());
    }
}
