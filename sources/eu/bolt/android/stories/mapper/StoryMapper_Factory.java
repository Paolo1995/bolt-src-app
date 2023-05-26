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
public final class StoryMapper_Factory implements Factory<StoryMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StorySlideAssetMapper> f37553a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StoryButtonStyleMapper> f37554b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<StorySlideContentMapper> f37555c;

    public StoryMapper_Factory(Provider<StorySlideAssetMapper> provider, Provider<StoryButtonStyleMapper> provider2, Provider<StorySlideContentMapper> provider3) {
        this.f37553a = provider;
        this.f37554b = provider2;
        this.f37555c = provider3;
    }

    public static StoryMapper_Factory a(Provider<StorySlideAssetMapper> provider, Provider<StoryButtonStyleMapper> provider2, Provider<StorySlideContentMapper> provider3) {
        return new StoryMapper_Factory(provider, provider2, provider3);
    }

    public static StoryMapper c(StorySlideAssetMapper storySlideAssetMapper, StoryButtonStyleMapper storyButtonStyleMapper, StorySlideContentMapper storySlideContentMapper) {
        return new StoryMapper(storySlideAssetMapper, storyButtonStyleMapper, storySlideContentMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryMapper get() {
        return c(this.f37553a.get(), this.f37554b.get(), this.f37555c.get());
    }
}
