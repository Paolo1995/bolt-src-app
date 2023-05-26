package eu.bolt.driver.stories.network;

import com.google.gson.annotations.SerializedName;
import eu.bolt.android.stories.model.StoryPreview;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoriesPreviewsResponse.kt */
/* loaded from: classes5.dex */
public final class StoriesPreviewsResponse {
    @SerializedName("story_previews")

    /* renamed from: a  reason: collision with root package name */
    private final List<StoryPreview> f41549a;

    public final List<StoryPreview> a() {
        return this.f41549a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StoriesPreviewsResponse) && Intrinsics.a(this.f41549a, ((StoriesPreviewsResponse) obj).f41549a);
    }

    public int hashCode() {
        return this.f41549a.hashCode();
    }

    public String toString() {
        List<StoryPreview> list = this.f41549a;
        return "StoriesPreviewsResponse(storiesPreviews=" + list + ")";
    }
}
