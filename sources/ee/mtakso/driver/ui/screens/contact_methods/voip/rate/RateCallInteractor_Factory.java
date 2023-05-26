package ee.mtakso.driver.ui.screens.contact_methods.voip.rate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.voip.VoipClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateCallInteractor_Factory implements Factory<RateCallInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipClient> f28090a;

    public RateCallInteractor_Factory(Provider<VoipClient> provider) {
        this.f28090a = provider;
    }

    public static RateCallInteractor_Factory a(Provider<VoipClient> provider) {
        return new RateCallInteractor_Factory(provider);
    }

    public static RateCallInteractor c(VoipClient voipClient) {
        return new RateCallInteractor(voipClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateCallInteractor get() {
        return c(this.f28090a.get());
    }
}
