package eu.bolt.android.stories.mapper;

import eu.bolt.android.stories.model.StorySlide;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideContent;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideContentItemMapper.kt */
/* loaded from: classes5.dex */
public final class StorySlideContentItemMapper {

    /* renamed from: a  reason: collision with root package name */
    private final StorySlideAssetMapper f37558a;

    @Inject
    public StorySlideContentItemMapper(StorySlideAssetMapper storySlideAssetMapper) {
        Intrinsics.f(storySlideAssetMapper, "storySlideAssetMapper");
        this.f37558a = storySlideAssetMapper;
    }

    private final StorySlideContent.Item a(StorySlide.StorySlideContentItem storySlideContentItem) {
        String e8 = storySlideContentItem.e();
        if (Intrinsics.a(e8, "text")) {
            String c8 = storySlideContentItem.c();
            String d8 = storySlideContentItem.d();
            if (d8 != null) {
                String a8 = storySlideContentItem.a();
                if (a8 != null) {
                    return new StorySlideContent.Item.Text(c8, d8, c(a8));
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (Intrinsics.a(e8, "asset")) {
            StorySlideAssetMapper storySlideAssetMapper = this.f37558a;
            StorySlide.StorySlideAsset b8 = storySlideContentItem.b();
            if (b8 != null) {
                StorySlideAsset a9 = storySlideAssetMapper.a(b8);
                if (a9 == null) {
                    StorySlide.StorySlideAsset b9 = storySlideContentItem.b();
                    Kalev.d("Unknown asset type in story item: " + b9);
                    return null;
                }
                String a10 = storySlideContentItem.a();
                if (a10 != null) {
                    return new StorySlideContent.Item.Asset(a9, c(a10));
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } else {
            Kalev.d("Unknown content type in story item: " + storySlideContentItem);
            return null;
        }
    }

    private final StorySlideContent.Align c(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 100571) {
                if (hashCode == 109757538 && str.equals("start")) {
                    return StorySlideContent.Align.START;
                }
            } else if (str.equals("end")) {
                return StorySlideContent.Align.END;
            }
        } else if (str.equals("center")) {
            return StorySlideContent.Align.CENTER;
        }
        Kalev.d("Unknown align type in story content item: " + str);
        return StorySlideContent.Align.START;
    }

    public final List<StorySlideContent.Item> b(List<StorySlide.StorySlideContentItem> from) {
        int v7;
        Intrinsics.f(from, "from");
        v7 = CollectionsKt__IterablesKt.v(from, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (StorySlide.StorySlideContentItem storySlideContentItem : from) {
            arrayList.add(a(storySlideContentItem));
        }
        return arrayList;
    }
}
