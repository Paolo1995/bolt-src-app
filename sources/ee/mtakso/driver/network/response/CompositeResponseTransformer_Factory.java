package ee.mtakso.driver.network.response;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CompositeResponseTransformer_Factory implements Factory<CompositeResponseTransformer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ExposeResponseTransformer> f22983a;

    public CompositeResponseTransformer_Factory(Provider<ExposeResponseTransformer> provider) {
        this.f22983a = provider;
    }

    public static CompositeResponseTransformer_Factory a(Provider<ExposeResponseTransformer> provider) {
        return new CompositeResponseTransformer_Factory(provider);
    }

    public static CompositeResponseTransformer c(ExposeResponseTransformer exposeResponseTransformer) {
        return new CompositeResponseTransformer(exposeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CompositeResponseTransformer get() {
        return c(this.f22983a.get());
    }
}
