package eu.bolt.android.stories.mapper;

import eu.bolt.android.stories.model.StorySlide;
import eu.bolt.android.stories.widget.slide.StoryAssetDimensions;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryAssetDimensionMapper.kt */
/* loaded from: classes5.dex */
public final class StoryAssetDimensionMapper {
    public final StoryAssetDimensions a(StorySlide.StorySlideDimensions from) {
        Intrinsics.f(from, "from");
        String b8 = from.b();
        if (Intrinsics.a(b8, "match_width")) {
            return StoryAssetDimensions.MatchWidth.f37668a;
        }
        if (Intrinsics.a(b8, "fixed")) {
            StorySlide.StoryDimensionFixedParams a8 = from.a();
            if (a8 != null) {
                int b9 = a8.b();
                StorySlide.StoryDimensionFixedParams a9 = from.a();
                if (a9 != null) {
                    return new StoryAssetDimensions.Fixed(b9, a9.a());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String b10 = from.b();
        Kalev.d("Unsupported dimension type [" + b10 + "]");
        return StoryAssetDimensions.MatchWidth.f37668a;
    }
}
