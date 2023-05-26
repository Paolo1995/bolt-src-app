package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedStaffModule_BindVoipOrderInfoProviderFactory implements Factory<CurrentOrderInfoProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedStaffModule f20367a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipOrderInformationDelegate> f20368b;

    public AuthorisedStaffModule_BindVoipOrderInfoProviderFactory(AuthorisedStaffModule authorisedStaffModule, Provider<VoipOrderInformationDelegate> provider) {
        this.f20367a = authorisedStaffModule;
        this.f20368b = provider;
    }

    public static CurrentOrderInfoProvider a(AuthorisedStaffModule authorisedStaffModule, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        return (CurrentOrderInfoProvider) Preconditions.checkNotNullFromProvides(authorisedStaffModule.a(voipOrderInformationDelegate));
    }

    public static AuthorisedStaffModule_BindVoipOrderInfoProviderFactory b(AuthorisedStaffModule authorisedStaffModule, Provider<VoipOrderInformationDelegate> provider) {
        return new AuthorisedStaffModule_BindVoipOrderInfoProviderFactory(authorisedStaffModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public CurrentOrderInfoProvider get() {
        return a(this.f20367a, this.f20368b.get());
    }
}
