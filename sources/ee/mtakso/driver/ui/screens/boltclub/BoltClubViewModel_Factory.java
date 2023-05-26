package ee.mtakso.driver.ui.screens.boltclub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BoltClubViewModel_Factory implements Factory<BoltClubViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BoltClubClient> f27176a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BoltClubDataMapper> f27177b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LanguageManager> f27178c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f27179d;

    public BoltClubViewModel_Factory(Provider<BoltClubClient> provider, Provider<BoltClubDataMapper> provider2, Provider<LanguageManager> provider3, Provider<CompositeUrlLauncher> provider4) {
        this.f27176a = provider;
        this.f27177b = provider2;
        this.f27178c = provider3;
        this.f27179d = provider4;
    }

    public static BoltClubViewModel_Factory a(Provider<BoltClubClient> provider, Provider<BoltClubDataMapper> provider2, Provider<LanguageManager> provider3, Provider<CompositeUrlLauncher> provider4) {
        return new BoltClubViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static BoltClubViewModel c(BoltClubClient boltClubClient, BoltClubDataMapper boltClubDataMapper, LanguageManager languageManager, CompositeUrlLauncher compositeUrlLauncher) {
        return new BoltClubViewModel(boltClubClient, boltClubDataMapper, languageManager, compositeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubViewModel get() {
        return c(this.f27176a.get(), this.f27177b.get(), this.f27178c.get(), this.f27179d.get());
    }
}
