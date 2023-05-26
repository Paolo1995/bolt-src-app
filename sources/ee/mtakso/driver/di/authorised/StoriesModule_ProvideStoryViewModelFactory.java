package ee.mtakso.driver.di.authorised;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.stories.ui.screen.StoryViewModel;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StoriesModule_ProvideStoryViewModelFactory implements Factory<ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final StoriesModule f20733a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StoryViewModel> f20734b;

    public StoriesModule_ProvideStoryViewModelFactory(StoriesModule storiesModule, Provider<StoryViewModel> provider) {
        this.f20733a = storiesModule;
        this.f20734b = provider;
    }

    public static StoriesModule_ProvideStoryViewModelFactory a(StoriesModule storiesModule, Provider<StoryViewModel> provider) {
        return new StoriesModule_ProvideStoryViewModelFactory(storiesModule, provider);
    }

    public static ViewModel c(StoriesModule storiesModule, StoryViewModel storyViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(storiesModule.d(storyViewModel));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ViewModel get() {
        return c(this.f20733a, this.f20734b.get());
    }
}
