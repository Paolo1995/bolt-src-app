package eu.bolt.android.stories.widget.story;

import com.google.gson.annotations.SerializedName;
import eu.bolt.android.stories.widget.slide.StorySlide;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Story.kt */
/* loaded from: classes5.dex */
public final class Story {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f37788a;
    @SerializedName("slides")

    /* renamed from: b  reason: collision with root package name */
    private final List<StorySlide> f37789b;

    /* JADX WARN: Multi-variable type inference failed */
    public Story(String id, List<? extends StorySlide> slides) {
        Intrinsics.f(id, "id");
        Intrinsics.f(slides, "slides");
        this.f37788a = id;
        this.f37789b = slides;
    }

    public final String a() {
        return this.f37788a;
    }

    public final List<StorySlide> b() {
        return this.f37789b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Story) {
            Story story = (Story) obj;
            return Intrinsics.a(this.f37788a, story.f37788a) && Intrinsics.a(this.f37789b, story.f37789b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f37788a.hashCode() * 31) + this.f37789b.hashCode();
    }

    public String toString() {
        String str = this.f37788a;
        List<StorySlide> list = this.f37789b;
        return "Story(id=" + str + ", slides=" + list + ")";
    }
}
