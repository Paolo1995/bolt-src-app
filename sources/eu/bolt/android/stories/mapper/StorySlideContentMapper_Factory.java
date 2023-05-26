package eu.bolt.android.stories.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StorySlideContentMapper_Factory implements Factory<StorySlideContentMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StorySlideContentItemMapper> f37561a;

    public StorySlideContentMapper_Factory(Provider<StorySlideContentItemMapper> provider) {
        this.f37561a = provider;
    }

    public static StorySlideContentMapper_Factory a(Provider<StorySlideContentItemMapper> provider) {
        return new StorySlideContentMapper_Factory(provider);
    }

    public static StorySlideContentMapper c(StorySlideContentItemMapper storySlideContentItemMapper) {
        return new StorySlideContentMapper(storySlideContentItemMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorySlideContentMapper get() {
        return c(this.f37561a.get());
    }
}
