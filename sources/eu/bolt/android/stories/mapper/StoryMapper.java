package eu.bolt.android.stories.mapper;

import eu.bolt.android.stories.model.StorySlide;
import eu.bolt.android.stories.utils.ColorParser;
import eu.bolt.android.stories.widget.slide.StoryButtonType;
import eu.bolt.android.stories.widget.slide.StorySlide;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideButton;
import eu.bolt.android.stories.widget.story.Story;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryMapper.kt */
/* loaded from: classes5.dex */
public final class StoryMapper {

    /* renamed from: a  reason: collision with root package name */
    private final StorySlideAssetMapper f37550a;

    /* renamed from: b  reason: collision with root package name */
    private final StoryButtonStyleMapper f37551b;

    /* renamed from: c  reason: collision with root package name */
    private final StorySlideContentMapper f37552c;

    @Inject
    public StoryMapper(StorySlideAssetMapper storySlideAssetMapper, StoryButtonStyleMapper storyButtonStyleMapper, StorySlideContentMapper storySlideContentMapper) {
        Intrinsics.f(storySlideAssetMapper, "storySlideAssetMapper");
        Intrinsics.f(storyButtonStyleMapper, "storyButtonStyleMapper");
        Intrinsics.f(storySlideContentMapper, "storySlideContentMapper");
        this.f37550a = storySlideAssetMapper;
        this.f37551b = storyButtonStyleMapper;
        this.f37552c = storySlideContentMapper;
    }

    private final StorySlide.ArrayContentWithFooter b(eu.bolt.android.stories.model.StorySlide storySlide) {
        int i8;
        StorySlideButton storySlideButton;
        String g8 = storySlide.g();
        Integer b8 = ColorParser.b(ColorParser.f37612a, storySlide.b(), 0, 2, null);
        if (b8 != null) {
            i8 = b8.intValue();
        } else {
            i8 = -1;
        }
        StorySlide.StorySlideButtonContent j8 = storySlide.j();
        if (j8 != null) {
            storySlideButton = c(j8);
        } else {
            storySlideButton = null;
        }
        Long a8 = storySlide.a();
        String f8 = storySlide.f();
        StorySlideContentMapper storySlideContentMapper = this.f37552c;
        StorySlide.StoryContent c8 = storySlide.c();
        if (c8 != null) {
            return new StorySlide.ArrayContentWithFooter(g8, i8, storySlideButton, a8, f8, storySlideContentMapper.a(c8));
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final StorySlideButton c(StorySlide.StorySlideButtonContent storySlideButtonContent) {
        String str;
        StoryButtonType d8 = d(storySlideButtonContent.d());
        String str2 = null;
        if (d8 == null) {
            return null;
        }
        String b8 = storySlideButtonContent.b();
        String a8 = storySlideButtonContent.a();
        StorySlide.ShareParams c8 = storySlideButtonContent.c();
        if (c8 != null) {
            str = c8.b();
        } else {
            str = null;
        }
        StorySlide.ShareParams c9 = storySlideButtonContent.c();
        if (c9 != null) {
            str2 = c9.a();
        }
        return new StorySlideButton(b8, a8, str, str2, d8, this.f37551b.a(storySlideButtonContent.e()));
    }

    private final StoryButtonType d(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3321850) {
                if (hashCode != 94756344) {
                    if (hashCode == 109400031 && str.equals("share")) {
                        return StoryButtonType.SHARE;
                    }
                } else if (str.equals("close")) {
                    return StoryButtonType.CLOSE;
                }
            } else if (str.equals("link")) {
                return StoryButtonType.LINK;
            }
        }
        Kalev.d("Unknown button type in story slide: " + str);
        return null;
    }

    private final StorySlide.LeftContent e(eu.bolt.android.stories.model.StorySlide storySlide) {
        int i8;
        StorySlideButton storySlideButton;
        StorySlideAsset storySlideAsset;
        String g8 = storySlide.g();
        ColorParser colorParser = ColorParser.f37612a;
        Integer b8 = ColorParser.b(colorParser, storySlide.b(), 0, 2, null);
        if (b8 != null) {
            i8 = b8.intValue();
        } else {
            i8 = -1;
        }
        Integer b9 = ColorParser.b(colorParser, storySlide.k(), 0, 2, null);
        StorySlide.StorySlideButtonContent j8 = storySlide.j();
        if (j8 != null) {
            storySlideButton = c(j8);
        } else {
            storySlideButton = null;
        }
        Long a8 = storySlide.a();
        String l8 = storySlide.l();
        String m8 = storySlide.m();
        String d8 = storySlide.d();
        String e8 = storySlide.e();
        StorySlide.StorySlideAsset i9 = storySlide.i();
        if (i9 != null) {
            storySlideAsset = this.f37550a.a(i9);
        } else {
            storySlideAsset = null;
        }
        return new StorySlide.LeftContent(g8, i8, b9, storySlideButton, a8, l8, m8, d8, e8, storySlideAsset);
    }

    private final eu.bolt.android.stories.widget.slide.StorySlide f(eu.bolt.android.stories.model.StorySlide storySlide) {
        String h8 = storySlide.h();
        if (Intrinsics.a(h8, "top_left_content")) {
            return e(storySlide);
        }
        if (Intrinsics.a(h8, "top_array_content_with_footer")) {
            return b(storySlide);
        }
        String h9 = storySlide.h();
        Kalev.d("Unknown layout type in story slide: " + h9);
        return null;
    }

    public final Story a(eu.bolt.android.stories.model.Story from) {
        Intrinsics.f(from, "from");
        String a8 = from.a();
        List<eu.bolt.android.stories.model.StorySlide> b8 = from.b();
        ArrayList arrayList = new ArrayList();
        for (eu.bolt.android.stories.model.StorySlide storySlide : b8) {
            eu.bolt.android.stories.widget.slide.StorySlide f8 = f(storySlide);
            if (f8 != null) {
                arrayList.add(f8);
            }
        }
        return new Story(a8, arrayList);
    }
}
