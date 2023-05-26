package ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer;

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
public final class NoAnswerInteractor_Factory implements Factory<NoAnswerInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipService> f28060a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipRxLifecycleTransfromer> f28061b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipOrderInformationDelegate> f28062c;

    public NoAnswerInteractor_Factory(Provider<VoipService> provider, Provider<VoipRxLifecycleTransfromer> provider2, Provider<VoipOrderInformationDelegate> provider3) {
        this.f28060a = provider;
        this.f28061b = provider2;
        this.f28062c = provider3;
    }

    public static NoAnswerInteractor_Factory a(Provider<VoipService> provider, Provider<VoipRxLifecycleTransfromer> provider2, Provider<VoipOrderInformationDelegate> provider3) {
        return new NoAnswerInteractor_Factory(provider, provider2, provider3);
    }

    public static NoAnswerInteractor c(VoipService voipService, VoipRxLifecycleTransfromer voipRxLifecycleTransfromer, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        return new NoAnswerInteractor(voipService, voipRxLifecycleTransfromer, voipOrderInformationDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NoAnswerInteractor get() {
        return c(this.f28060a.get(), this.f28061b.get(), this.f28062c.get());
    }
}
