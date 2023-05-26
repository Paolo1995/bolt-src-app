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
public final class StorySlideContentItemMapper_Factory implements Factory<StorySlideContentItemMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StorySlideAssetMapper> f37559a;

    public StorySlideContentItemMapper_Factory(Provider<StorySlideAssetMapper> provider) {
        this.f37559a = provider;
    }

    public static StorySlideContentItemMapper_Factory a(Provider<StorySlideAssetMapper> provider) {
        return new StorySlideContentItemMapper_Factory(provider);
    }

    public static StorySlideContentItemMapper c(StorySlideAssetMapper storySlideAssetMapper) {
        return new StorySlideContentItemMapper(storySlideAssetMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorySlideContentItemMapper get() {
        return c(this.f37559a.get());
    }
}
