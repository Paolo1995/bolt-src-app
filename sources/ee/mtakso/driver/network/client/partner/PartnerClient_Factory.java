package ee.mtakso.driver.network.client.partner;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PartnerClient_Factory implements Factory<PartnerClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PartnerApi> f22645a;

    public PartnerClient_Factory(Provider<PartnerApi> provider) {
        this.f22645a = provider;
    }

    public static PartnerClient_Factory a(Provider<PartnerApi> provider) {
        return new PartnerClient_Factory(provider);
    }

    public static PartnerClient c(PartnerApi partnerApi) {
        return new PartnerClient(partnerApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PartnerClient get() {
        return c(this.f22645a.get());
    }
}
