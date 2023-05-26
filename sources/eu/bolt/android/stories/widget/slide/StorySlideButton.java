package eu.bolt.android.stories.widget.slide;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideButton.kt */
/* loaded from: classes5.dex */
public final class StorySlideButton {

    /* renamed from: a  reason: collision with root package name */
    private final String f37700a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37701b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37702c;

    /* renamed from: d  reason: collision with root package name */
    private final String f37703d;

    /* renamed from: e  reason: collision with root package name */
    private final StoryButtonType f37704e;

    /* renamed from: f  reason: collision with root package name */
    private final StoryButtonStyle f37705f;

    public StorySlideButton(String text, String str, String str2, String str3, StoryButtonType type, StoryButtonStyle style) {
        Intrinsics.f(text, "text");
        Intrinsics.f(type, "type");
        Intrinsics.f(style, "style");
        this.f37700a = text;
        this.f37701b = str;
        this.f37702c = str2;
        this.f37703d = str3;
        this.f37704e = type;
        this.f37705f = style;
    }

    public final String a() {
        return this.f37701b;
    }

    public final StoryButtonStyle b() {
        return this.f37705f;
    }

    public final String c() {
        return this.f37700a;
    }

    public final StoryButtonType d() {
        return this.f37704e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StorySlideButton) {
            StorySlideButton storySlideButton = (StorySlideButton) obj;
            return Intrinsics.a(this.f37700a, storySlideButton.f37700a) && Intrinsics.a(this.f37701b, storySlideButton.f37701b) && Intrinsics.a(this.f37702c, storySlideButton.f37702c) && Intrinsics.a(this.f37703d, storySlideButton.f37703d) && this.f37704e == storySlideButton.f37704e && Intrinsics.a(this.f37705f, storySlideButton.f37705f);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f37700a.hashCode() * 31;
        String str = this.f37701b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f37702c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f37703d;
        return ((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f37704e.hashCode()) * 31) + this.f37705f.hashCode();
    }

    public String toString() {
        String str = this.f37700a;
        String str2 = this.f37701b;
        String str3 = this.f37702c;
        String str4 = this.f37703d;
        StoryButtonType storyButtonType = this.f37704e;
        StoryButtonStyle storyButtonStyle = this.f37705f;
        return "StorySlideButton(text=" + str + ", link=" + str2 + ", shareText=" + str3 + ", shareFileName=" + str4 + ", type=" + storyButtonType + ", style=" + storyButtonStyle + ")";
    }
}
