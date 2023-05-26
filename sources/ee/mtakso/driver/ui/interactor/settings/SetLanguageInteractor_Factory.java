package ee.mtakso.driver.ui.interactor.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.driver.DriverClient;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SetLanguageInteractor_Factory implements Factory<SetLanguageInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LanguageManager> f26918a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TranslationManager> f26919b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverClient> f26920c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DateTimeConverter> f26921d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RoutingManager> f26922e;

    public SetLanguageInteractor_Factory(Provider<LanguageManager> provider, Provider<TranslationManager> provider2, Provider<DriverClient> provider3, Provider<DateTimeConverter> provider4, Provider<RoutingManager> provider5) {
        this.f26918a = provider;
        this.f26919b = provider2;
        this.f26920c = provider3;
        this.f26921d = provider4;
        this.f26922e = provider5;
    }

    public static SetLanguageInteractor_Factory a(Provider<LanguageManager> provider, Provider<TranslationManager> provider2, Provider<DriverClient> provider3, Provider<DateTimeConverter> provider4, Provider<RoutingManager> provider5) {
        return new SetLanguageInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SetLanguageInteractor c(LanguageManager languageManager, TranslationManager translationManager, DriverClient driverClient, DateTimeConverter dateTimeConverter, RoutingManager routingManager) {
        return new SetLanguageInteractor(languageManager, translationManager, driverClient, dateTimeConverter, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SetLanguageInteractor get() {
        return c(this.f26918a.get(), this.f26919b.get(), this.f26920c.get(), this.f26921d.get(), this.f26922e.get());
    }
}
