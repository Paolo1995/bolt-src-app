package ee.mtakso.driver.service.modules.tile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VectorPropertiesFactory_Factory implements Factory<VectorPropertiesFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FeaturePropertiesFactory> f25374a;

    public VectorPropertiesFactory_Factory(Provider<FeaturePropertiesFactory> provider) {
        this.f25374a = provider;
    }

    public static VectorPropertiesFactory_Factory a(Provider<FeaturePropertiesFactory> provider) {
        return new VectorPropertiesFactory_Factory(provider);
    }

    public static VectorPropertiesFactory c(FeaturePropertiesFactory featurePropertiesFactory) {
        return new VectorPropertiesFactory(featurePropertiesFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VectorPropertiesFactory get() {
        return c(this.f25374a.get());
    }
}
