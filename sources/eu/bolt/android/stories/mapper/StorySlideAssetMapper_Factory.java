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
public final class StorySlideAssetMapper_Factory implements Factory<StorySlideAssetMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StoryAssetDimensionMapper> f37557a;

    public StorySlideAssetMapper_Factory(Provider<StoryAssetDimensionMapper> provider) {
        this.f37557a = provider;
    }

    public static StorySlideAssetMapper_Factory a(Provider<StoryAssetDimensionMapper> provider) {
        return new StorySlideAssetMapper_Factory(provider);
    }

    public static StorySlideAssetMapper c(StoryAssetDimensionMapper storyAssetDimensionMapper) {
        return new StorySlideAssetMapper(storyAssetDimensionMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorySlideAssetMapper get() {
        return c(this.f37557a.get());
    }
}
