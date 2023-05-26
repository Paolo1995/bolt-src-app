package eu.bolt.driver.voip.ui.screen.call.incoming;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class IncomingCallViewModel_Factory implements Factory<IncomingCallViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CurrentOrderInfoProvider> f41664a;

    public IncomingCallViewModel_Factory(Provider<CurrentOrderInfoProvider> provider) {
        this.f41664a = provider;
    }

    public static IncomingCallViewModel_Factory a(Provider<CurrentOrderInfoProvider> provider) {
        return new IncomingCallViewModel_Factory(provider);
    }

    public static IncomingCallViewModel c(CurrentOrderInfoProvider currentOrderInfoProvider) {
        return new IncomingCallViewModel(currentOrderInfoProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingCallViewModel get() {
        return c(this.f41664a.get());
    }
}
