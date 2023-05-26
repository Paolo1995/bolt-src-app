package ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CircleKLoyaltyStarterViewModel_Factory implements Factory<CircleKLoyaltyStarterViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CircleKClient> f27399a;

    public CircleKLoyaltyStarterViewModel_Factory(Provider<CircleKClient> provider) {
        this.f27399a = provider;
    }

    public static CircleKLoyaltyStarterViewModel_Factory a(Provider<CircleKClient> provider) {
        return new CircleKLoyaltyStarterViewModel_Factory(provider);
    }

    public static CircleKLoyaltyStarterViewModel c(CircleKClient circleKClient) {
        return new CircleKLoyaltyStarterViewModel(circleKClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CircleKLoyaltyStarterViewModel get() {
        return c(this.f27399a.get());
    }
}
