package eu.bolt.android.stories.mapper;

import eu.bolt.android.stories.model.StorySlide;
import eu.bolt.android.stories.widget.slide.StoryAssetDimensions;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideAssetMapper.kt */
/* loaded from: classes5.dex */
public final class StorySlideAssetMapper {

    /* renamed from: a  reason: collision with root package name */
    private final StoryAssetDimensionMapper f37556a;

    @Inject
    public StorySlideAssetMapper(StoryAssetDimensionMapper dimensionMapper) {
        Intrinsics.f(dimensionMapper, "dimensionMapper");
        this.f37556a = dimensionMapper;
    }

    public final StorySlideAsset a(StorySlide.StorySlideAsset storySlideAsset) {
        StoryAssetDimensions storyAssetDimensions;
        String str;
        StorySlide.StorySlideDimensions a8;
        if (storySlideAsset != null && (a8 = storySlideAsset.a()) != null) {
            storyAssetDimensions = this.f37556a.a(a8);
        } else {
            storyAssetDimensions = null;
        }
        if (storySlideAsset != null) {
            str = storySlideAsset.b();
        } else {
            str = null;
        }
        if (Intrinsics.a(str, "image")) {
            return new StorySlideAsset.Drawable(storySlideAsset.c(), storyAssetDimensions);
        }
        if (Intrinsics.a(str, "lottie")) {
            return new StorySlideAsset.Lottie(storySlideAsset.c(), storyAssetDimensions);
        }
        if (str == null) {
            return null;
        }
        Kalev.d("Unknown asset type in story slide: " + storySlideAsset);
        return null;
    }
}
