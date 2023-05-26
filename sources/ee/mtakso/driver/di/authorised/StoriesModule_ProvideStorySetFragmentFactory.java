package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.Fragment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StoriesModule_ProvideStorySetFragmentFactory implements Factory<Fragment> {

    /* renamed from: a  reason: collision with root package name */
    private final StoriesModule f20729a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StorySetFragment> f20730b;

    public StoriesModule_ProvideStorySetFragmentFactory(StoriesModule storiesModule, Provider<StorySetFragment> provider) {
        this.f20729a = storiesModule;
        this.f20730b = provider;
    }

    public static StoriesModule_ProvideStorySetFragmentFactory a(StoriesModule storiesModule, Provider<StorySetFragment> provider) {
        return new StoriesModule_ProvideStorySetFragmentFactory(storiesModule, provider);
    }

    public static Fragment c(StoriesModule storiesModule, StorySetFragment storySetFragment) {
        return (Fragment) Preconditions.checkNotNullFromProvides(storiesModule.b(storySetFragment));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Fragment get() {
        return c(this.f20729a, this.f20730b.get());
    }
}
