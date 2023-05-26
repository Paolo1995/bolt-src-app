package ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InprogressCallInteractor_Factory implements Factory<InprogressCallInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipService> f28029a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipRxLifecycleTransfromer> f28030b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipOrderInformationDelegate> f28031c;

    public InprogressCallInteractor_Factory(Provider<VoipService> provider, Provider<VoipRxLifecycleTransfromer> provider2, Provider<VoipOrderInformationDelegate> provider3) {
        this.f28029a = provider;
        this.f28030b = provider2;
        this.f28031c = provider3;
    }

    public static InprogressCallInteractor_Factory a(Provider<VoipService> provider, Provider<VoipRxLifecycleTransfromer> provider2, Provider<VoipOrderInformationDelegate> provider3) {
        return new InprogressCallInteractor_Factory(provider, provider2, provider3);
    }

    public static InprogressCallInteractor c(VoipService voipService, VoipRxLifecycleTransfromer voipRxLifecycleTransfromer, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        return new InprogressCallInteractor(voipService, voipRxLifecycleTransfromer, voipOrderInformationDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InprogressCallInteractor get() {
        return c(this.f28029a.get(), this.f28030b.get(), this.f28031c.get());
    }
}
