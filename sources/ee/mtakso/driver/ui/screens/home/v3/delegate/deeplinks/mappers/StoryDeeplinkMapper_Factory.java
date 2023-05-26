package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.stories.StoryManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StoryDeeplinkMapper_Factory implements Factory<StoryDeeplinkMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StoryManager> f29998a;

    public StoryDeeplinkMapper_Factory(Provider<StoryManager> provider) {
        this.f29998a = provider;
    }

    public static StoryDeeplinkMapper_Factory a(Provider<StoryManager> provider) {
        return new StoryDeeplinkMapper_Factory(provider);
    }

    public static StoryDeeplinkMapper c(StoryManager storyManager) {
        return new StoryDeeplinkMapper(storyManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryDeeplinkMapper get() {
        return c(this.f29998a.get());
    }
}
