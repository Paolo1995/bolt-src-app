package eu.bolt.android.stories.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryPreview.kt */
/* loaded from: classes5.dex */
public final class StoryPreview {
    @SerializedName("story_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f37564a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f37565b;
    @SerializedName("background_color")

    /* renamed from: c  reason: collision with root package name */
    private final String f37566c;
    @SerializedName("thumbnail_url")

    /* renamed from: d  reason: collision with root package name */
    private final String f37567d;

    public final String a() {
        return this.f37566c;
    }

    public final String b() {
        return this.f37564a;
    }

    public final String c() {
        return this.f37567d;
    }

    public final String d() {
        return this.f37565b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StoryPreview) {
            StoryPreview storyPreview = (StoryPreview) obj;
            return Intrinsics.a(this.f37564a, storyPreview.f37564a) && Intrinsics.a(this.f37565b, storyPreview.f37565b) && Intrinsics.a(this.f37566c, storyPreview.f37566c) && Intrinsics.a(this.f37567d, storyPreview.f37567d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f37564a.hashCode() * 31) + this.f37565b.hashCode()) * 31) + this.f37566c.hashCode()) * 31) + this.f37567d.hashCode();
    }

    public String toString() {
        String str = this.f37564a;
        String str2 = this.f37565b;
        String str3 = this.f37566c;
        String str4 = this.f37567d;
        return "StoryPreview(storyId=" + str + ", title=" + str2 + ", backgroundHexColor=" + str3 + ", thumbnailUrl=" + str4 + ")";
    }
}
