package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OnlineCheckInteractor_Factory implements Factory<OnlineCheckInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f26515a;

    public OnlineCheckInteractor_Factory(Provider<PollerSource> provider) {
        this.f26515a = provider;
    }

    public static OnlineCheckInteractor_Factory a(Provider<PollerSource> provider) {
        return new OnlineCheckInteractor_Factory(provider);
    }

    public static OnlineCheckInteractor c(PollerSource pollerSource) {
        return new OnlineCheckInteractor(pollerSource);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OnlineCheckInteractor get() {
        return c(this.f26515a.get());
    }
}
