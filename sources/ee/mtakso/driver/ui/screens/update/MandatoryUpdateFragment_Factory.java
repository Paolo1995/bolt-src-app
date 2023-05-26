package ee.mtakso.driver.ui.screens.update;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MandatoryUpdateFragment_Factory implements Factory<MandatoryUpdateFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33503a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemUrlLauncher> f33504b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LanguageManager> f33505c;

    public MandatoryUpdateFragment_Factory(Provider<BaseUiDependencies> provider, Provider<SystemUrlLauncher> provider2, Provider<LanguageManager> provider3) {
        this.f33503a = provider;
        this.f33504b = provider2;
        this.f33505c = provider3;
    }

    public static MandatoryUpdateFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<SystemUrlLauncher> provider2, Provider<LanguageManager> provider3) {
        return new MandatoryUpdateFragment_Factory(provider, provider2, provider3);
    }

    public static MandatoryUpdateFragment c(BaseUiDependencies baseUiDependencies, SystemUrlLauncher systemUrlLauncher, LanguageManager languageManager) {
        return new MandatoryUpdateFragment(baseUiDependencies, systemUrlLauncher, languageManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MandatoryUpdateFragment get() {
        return c(this.f33503a.get(), this.f33504b.get(), this.f33505c.get());
    }
}
