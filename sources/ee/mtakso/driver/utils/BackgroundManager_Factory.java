package ee.mtakso.driver.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class BackgroundManager_Factory implements Factory<BackgroundManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<NotRespondReporter> f36290a;

    public BackgroundManager_Factory(Provider<NotRespondReporter> provider) {
        this.f36290a = provider;
    }

    public static BackgroundManager_Factory a(Provider<NotRespondReporter> provider) {
        return new BackgroundManager_Factory(provider);
    }

    public static BackgroundManager c(NotRespondReporter notRespondReporter) {
        return new BackgroundManager(notRespondReporter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BackgroundManager get() {
        return c(this.f36290a.get());
    }
}
