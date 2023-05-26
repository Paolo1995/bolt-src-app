package ee.mtakso.driver.ui.screens.contact_methods.voip.callback;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CallBackViewModel_Factory implements Factory<CallBackViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipCallDelegate> f27840a;

    public CallBackViewModel_Factory(Provider<VoipCallDelegate> provider) {
        this.f27840a = provider;
    }

    public static CallBackViewModel_Factory a(Provider<VoipCallDelegate> provider) {
        return new CallBackViewModel_Factory(provider);
    }

    public static CallBackViewModel c(VoipCallDelegate voipCallDelegate) {
        return new CallBackViewModel(voipCallDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CallBackViewModel get() {
        return c(this.f27840a.get());
    }
}
