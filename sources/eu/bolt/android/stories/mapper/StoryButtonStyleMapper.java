package eu.bolt.android.stories.mapper;

import eu.bolt.android.stories.widget.slide.StoryButtonStyle;
import eu.bolt.kalev.Kalev;

/* compiled from: StoryButtonStyleMapper.kt */
/* loaded from: classes5.dex */
public final class StoryButtonStyleMapper {
    public final StoryButtonStyle a(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1339091421:
                    if (str.equals("danger")) {
                        return StoryButtonStyle.Danger.f37671h;
                    }
                    break;
                case -817598092:
                    if (str.equals("secondary")) {
                        return StoryButtonStyle.Secondary.f37673h;
                    }
                    break;
                case -314765822:
                    if (str.equals("primary")) {
                        return StoryButtonStyle.Primary.f37672h;
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        return StoryButtonStyle.TextButton.f37674h;
                    }
                    break;
            }
        }
        Kalev.d("Unknown error button style: " + str);
        return StoryButtonStyle.Secondary.f37673h;
    }
}
