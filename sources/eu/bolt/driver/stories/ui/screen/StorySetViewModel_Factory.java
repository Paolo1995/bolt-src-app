package eu.bolt.driver.stories.ui.screen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.stories.network.StoriesClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StorySetViewModel_Factory implements Factory<StorySetViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StoriesClient> f41575a;

    public StorySetViewModel_Factory(Provider<StoriesClient> provider) {
        this.f41575a = provider;
    }

    public static StorySetViewModel_Factory a(Provider<StoriesClient> provider) {
        return new StorySetViewModel_Factory(provider);
    }

    public static StorySetViewModel c(StoriesClient storiesClient) {
        return new StorySetViewModel(storiesClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorySetViewModel get() {
        return c(this.f41575a.get());
    }
}
