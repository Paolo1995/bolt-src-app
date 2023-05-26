package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipOrderInformationDelegate_Factory implements Factory<VoipOrderInformationDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipCache> f27954a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f27955b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipRxLifecycleTransfromer> f27956c;

    public VoipOrderInformationDelegate_Factory(Provider<VoipCache> provider, Provider<OrderProvider> provider2, Provider<VoipRxLifecycleTransfromer> provider3) {
        this.f27954a = provider;
        this.f27955b = provider2;
        this.f27956c = provider3;
    }

    public static VoipOrderInformationDelegate_Factory a(Provider<VoipCache> provider, Provider<OrderProvider> provider2, Provider<VoipRxLifecycleTransfromer> provider3) {
        return new VoipOrderInformationDelegate_Factory(provider, provider2, provider3);
    }

    public static VoipOrderInformationDelegate c(VoipCache voipCache, OrderProvider orderProvider, VoipRxLifecycleTransfromer voipRxLifecycleTransfromer) {
        return new VoipOrderInformationDelegate(voipCache, orderProvider, voipRxLifecycleTransfromer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipOrderInformationDelegate get() {
        return c(this.f27954a.get(), this.f27955b.get(), this.f27956c.get());
    }
}
