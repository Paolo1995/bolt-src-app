package ee.mtakso.driver.network.client.voip;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipClient_Factory implements Factory<VoipClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipApi> f22911a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22912b;

    public VoipClient_Factory(Provider<VoipApi> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f22911a = provider;
        this.f22912b = provider2;
    }

    public static VoipClient_Factory a(Provider<VoipApi> provider, Provider<ResponseErrorProcessor> provider2) {
        return new VoipClient_Factory(provider, provider2);
    }

    public static VoipClient c(VoipApi voipApi, ResponseErrorProcessor responseErrorProcessor) {
        return new VoipClient(voipApi, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipClient get() {
        return c(this.f22911a.get(), this.f22912b.get());
    }
}
