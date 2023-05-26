package ee.mtakso.driver.di.authorised;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.stories.ui.screen.StorySetViewModel;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StoriesModule_ProvideStorySetViewModelFactory implements Factory<ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final StoriesModule f20731a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StorySetViewModel> f20732b;

    public StoriesModule_ProvideStorySetViewModelFactory(StoriesModule storiesModule, Provider<StorySetViewModel> provider) {
        this.f20731a = storiesModule;
        this.f20732b = provider;
    }

    public static StoriesModule_ProvideStorySetViewModelFactory a(StoriesModule storiesModule, Provider<StorySetViewModel> provider) {
        return new StoriesModule_ProvideStorySetViewModelFactory(storiesModule, provider);
    }

    public static ViewModel c(StoriesModule storiesModule, StorySetViewModel storySetViewModel) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(storiesModule.c(storySetViewModel));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ViewModel get() {
        return c(this.f20731a, this.f20732b.get());
    }
}
