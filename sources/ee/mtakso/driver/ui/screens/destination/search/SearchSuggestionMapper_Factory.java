package ee.mtakso.driver.ui.screens.destination.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SearchSuggestionMapper_Factory implements Factory<SearchSuggestionMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SearchSuggestionMapper_Factory f28244a = new SearchSuggestionMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SearchSuggestionMapper_Factory a() {
        return InstanceHolder.f28244a;
    }

    public static SearchSuggestionMapper c() {
        return new SearchSuggestionMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SearchSuggestionMapper get() {
        return c();
    }
}
