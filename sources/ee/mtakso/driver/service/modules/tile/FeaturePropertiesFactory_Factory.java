package ee.mtakso.driver.service.modules.tile;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FeaturePropertiesFactory_Factory implements Factory<FeaturePropertiesFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Gson> f25349a;

    public FeaturePropertiesFactory_Factory(Provider<Gson> provider) {
        this.f25349a = provider;
    }

    public static FeaturePropertiesFactory_Factory a(Provider<Gson> provider) {
        return new FeaturePropertiesFactory_Factory(provider);
    }

    public static FeaturePropertiesFactory c(Gson gson) {
        return new FeaturePropertiesFactory(gson);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FeaturePropertiesFactory get() {
        return c(this.f25349a.get());
    }
}
