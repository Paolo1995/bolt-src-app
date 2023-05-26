package ee.mtakso.driver.service.integration.clevertap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CleverTapCoordinator_Factory implements Factory<CleverTapCoordinator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CleverTapManager> f24527a;

    public CleverTapCoordinator_Factory(Provider<CleverTapManager> provider) {
        this.f24527a = provider;
    }

    public static CleverTapCoordinator_Factory a(Provider<CleverTapManager> provider) {
        return new CleverTapCoordinator_Factory(provider);
    }

    public static CleverTapCoordinator c(CleverTapManager cleverTapManager) {
        return new CleverTapCoordinator(cleverTapManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CleverTapCoordinator get() {
        return c(this.f24527a.get());
    }
}
