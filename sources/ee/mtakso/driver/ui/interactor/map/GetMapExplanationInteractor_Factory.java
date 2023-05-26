package ee.mtakso.driver.ui.interactor.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import eu.bolt.driver.core.theme.ThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetMapExplanationInteractor_Factory implements Factory<GetMapExplanationInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f26627a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ThemeManager> f26628b;

    public GetMapExplanationInteractor_Factory(Provider<DriverClient> provider, Provider<ThemeManager> provider2) {
        this.f26627a = provider;
        this.f26628b = provider2;
    }

    public static GetMapExplanationInteractor_Factory a(Provider<DriverClient> provider, Provider<ThemeManager> provider2) {
        return new GetMapExplanationInteractor_Factory(provider, provider2);
    }

    public static GetMapExplanationInteractor c(DriverClient driverClient, ThemeManager themeManager) {
        return new GetMapExplanationInteractor(driverClient, themeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetMapExplanationInteractor get() {
        return c(this.f26627a.get(), this.f26628b.get());
    }
}
