package eu.bolt.android.stories.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Story.kt */
/* loaded from: classes5.dex */
public final class Story {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f37562a;
    @SerializedName("slides")

    /* renamed from: b  reason: collision with root package name */
    private final List<StorySlide> f37563b;

    public final String a() {
        return this.f37562a;
    }

    public final List<StorySlide> b() {
        return this.f37563b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Story) {
            Story story = (Story) obj;
            return Intrinsics.a(this.f37562a, story.f37562a) && Intrinsics.a(this.f37563b, story.f37563b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f37562a.hashCode() * 31) + this.f37563b.hashCode();
    }

    public String toString() {
        String str = this.f37562a;
        List<StorySlide> list = this.f37563b;
        return "Story(id=" + str + ", slides=" + list + ")";
    }
}
