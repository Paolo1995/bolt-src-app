package ee.mtakso.driver.ui.screens.destination.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.destination.SelectDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.UpdateDriverDestinationInteractor;
import ee.mtakso.driver.ui.interactor.search.GetSuggestionsInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverDestinationSearchViewModel_Factory implements Factory<DriverDestinationSearchViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetSuggestionsInteractor> f28240a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UpdateDriverDestinationInteractor> f28241b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SelectDestinationInteractor> f28242c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SearchSuggestionMapper> f28243d;

    public DriverDestinationSearchViewModel_Factory(Provider<GetSuggestionsInteractor> provider, Provider<UpdateDriverDestinationInteractor> provider2, Provider<SelectDestinationInteractor> provider3, Provider<SearchSuggestionMapper> provider4) {
        this.f28240a = provider;
        this.f28241b = provider2;
        this.f28242c = provider3;
        this.f28243d = provider4;
    }

    public static DriverDestinationSearchViewModel_Factory a(Provider<GetSuggestionsInteractor> provider, Provider<UpdateDriverDestinationInteractor> provider2, Provider<SelectDestinationInteractor> provider3, Provider<SearchSuggestionMapper> provider4) {
        return new DriverDestinationSearchViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static DriverDestinationSearchViewModel c(GetSuggestionsInteractor getSuggestionsInteractor, UpdateDriverDestinationInteractor updateDriverDestinationInteractor, SelectDestinationInteractor selectDestinationInteractor, SearchSuggestionMapper searchSuggestionMapper) {
        return new DriverDestinationSearchViewModel(getSuggestionsInteractor, updateDriverDestinationInteractor, selectDestinationInteractor, searchSuggestionMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverDestinationSearchViewModel get() {
        return c(this.f28240a.get(), this.f28241b.get(), this.f28242c.get(), this.f28243d.get());
    }
}
