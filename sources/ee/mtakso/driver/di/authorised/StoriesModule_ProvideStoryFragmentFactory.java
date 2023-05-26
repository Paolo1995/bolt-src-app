package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.Fragment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.stories.ui.screen.StoryFragment;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StoriesModule_ProvideStoryFragmentFactory implements Factory<Fragment> {

    /* renamed from: a  reason: collision with root package name */
    private final StoriesModule f20727a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StoryFragment> f20728b;

    public StoriesModule_ProvideStoryFragmentFactory(StoriesModule storiesModule, Provider<StoryFragment> provider) {
        this.f20727a = storiesModule;
        this.f20728b = provider;
    }

    public static StoriesModule_ProvideStoryFragmentFactory a(StoriesModule storiesModule, Provider<StoryFragment> provider) {
        return new StoriesModule_ProvideStoryFragmentFactory(storiesModule, provider);
    }

    public static Fragment c(StoriesModule storiesModule, StoryFragment storyFragment) {
        return (Fragment) Preconditions.checkNotNullFromProvides(storiesModule.a(storyFragment));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Fragment get() {
        return c(this.f20727a, this.f20728b.get());
    }
}
