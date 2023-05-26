package eu.bolt.android.stories.mapper;

import eu.bolt.android.stories.model.StorySlide;
import eu.bolt.android.stories.utils.ColorParser;
import eu.bolt.android.stories.widget.slide.StorySlideContent;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideContentMapper.kt */
/* loaded from: classes5.dex */
public final class StorySlideContentMapper {

    /* renamed from: a  reason: collision with root package name */
    private final StorySlideContentItemMapper f37560a;

    @Inject
    public StorySlideContentMapper(StorySlideContentItemMapper storySlideContentItemMapper) {
        Intrinsics.f(storySlideContentItemMapper, "storySlideContentItemMapper");
        this.f37560a = storySlideContentItemMapper;
    }

    private final StorySlideContent.Padding b(StorySlide.StoryContentPadding storyContentPadding) {
        return new StorySlideContent.Padding(storyContentPadding.d(), storyContentPadding.b(), storyContentPadding.a(), storyContentPadding.c());
    }

    public final StorySlideContent a(StorySlide.StoryContent from) {
        int i8;
        List T;
        Intrinsics.f(from, "from");
        StorySlideContent.Padding b8 = b(from.d());
        int c8 = from.c();
        Integer b9 = ColorParser.b(ColorParser.f37612a, from.a(), 0, 2, null);
        if (b9 != null) {
            i8 = b9.intValue();
        } else {
            i8 = -1;
        }
        T = CollectionsKt___CollectionsKt.T(this.f37560a.b(from.b()));
        return new StorySlideContent(b8, c8, i8, T);
    }
}
