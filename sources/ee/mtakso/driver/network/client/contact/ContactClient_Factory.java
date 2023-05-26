package ee.mtakso.driver.network.client.contact;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ContactClient_Factory implements Factory<ContactClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ContactApi> f21778a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f21779b;

    public ContactClient_Factory(Provider<ContactApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f21778a = provider;
        this.f21779b = provider2;
    }

    public static ContactClient_Factory a(Provider<ContactApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new ContactClient_Factory(provider, provider2);
    }

    public static ContactClient c(Lazy<ContactApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new ContactClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ContactClient get() {
        return c(DoubleCheck.lazy(this.f21778a), this.f21779b.get());
    }
}
