package ee.mtakso.driver.ui.screens.contact_methods.voip.rate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateCallViewModel_Factory implements Factory<RateCallViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RateCallInteractor> f28099a;

    public RateCallViewModel_Factory(Provider<RateCallInteractor> provider) {
        this.f28099a = provider;
    }

    public static RateCallViewModel_Factory a(Provider<RateCallInteractor> provider) {
        return new RateCallViewModel_Factory(provider);
    }

    public static RateCallViewModel c(RateCallInteractor rateCallInteractor) {
        return new RateCallViewModel(rateCallInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateCallViewModel get() {
        return c(this.f28099a.get());
    }
}
