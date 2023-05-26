package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import org.simpleframework.xml.Serializer;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideSerializerFactory implements Factory<Serializer> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20811a;

    public NetworkModule_ProvideSerializerFactory(NetworkModule networkModule) {
        this.f20811a = networkModule;
    }

    public static NetworkModule_ProvideSerializerFactory a(NetworkModule networkModule) {
        return new NetworkModule_ProvideSerializerFactory(networkModule);
    }

    public static Serializer c(NetworkModule networkModule) {
        return (Serializer) Preconditions.checkNotNullFromProvides(networkModule.p());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Serializer get() {
        return c(this.f20811a);
    }
}
