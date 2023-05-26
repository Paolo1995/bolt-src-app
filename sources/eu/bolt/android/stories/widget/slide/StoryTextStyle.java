package eu.bolt.android.stories.widget.slide;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryTextStyle.kt */
/* loaded from: classes5.dex */
public final class StoryTextStyle {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f37738a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37739b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37740c;

    /* renamed from: d  reason: collision with root package name */
    private final int f37741d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f37742e;

    public StoryTextStyle(CharSequence text, int i8, int i9, int i10, Integer num) {
        Intrinsics.f(text, "text");
        this.f37738a = text;
        this.f37739b = i8;
        this.f37740c = i9;
        this.f37741d = i10;
        this.f37742e = num;
    }

    public final int a() {
        return this.f37739b;
    }

    public final int b() {
        return this.f37741d;
    }

    public final Integer c() {
        return this.f37742e;
    }

    public final int d() {
        return this.f37740c;
    }

    public final CharSequence e() {
        return this.f37738a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StoryTextStyle) {
            StoryTextStyle storyTextStyle = (StoryTextStyle) obj;
            return Intrinsics.a(this.f37738a, storyTextStyle.f37738a) && this.f37739b == storyTextStyle.f37739b && this.f37740c == storyTextStyle.f37740c && this.f37741d == storyTextStyle.f37741d && Intrinsics.a(this.f37742e, storyTextStyle.f37742e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f37738a.hashCode() * 31) + this.f37739b) * 31) + this.f37740c) * 31) + this.f37741d) * 31;
        Integer num = this.f37742e;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        CharSequence charSequence = this.f37738a;
        int i8 = this.f37739b;
        int i9 = this.f37740c;
        int i10 = this.f37741d;
        Integer num = this.f37742e;
        return "StoryTextStyle(text=" + ((Object) charSequence) + ", backgroundColor=" + i8 + ", horizontalPadding=" + i9 + ", backgroundRadius=" + i10 + ", highlightColor=" + num + ")";
    }
}
