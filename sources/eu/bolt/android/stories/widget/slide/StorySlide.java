package eu.bolt.android.stories.widget.slide;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlide.kt */
/* loaded from: classes5.dex */
public abstract class StorySlide {

    /* renamed from: a  reason: collision with root package name */
    private final String f37679a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37680b;

    /* renamed from: c  reason: collision with root package name */
    private final StorySlideButton f37681c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f37682d;

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class ArrayContentWithFooter extends StorySlide {

        /* renamed from: e  reason: collision with root package name */
        private final String f37683e;

        /* renamed from: f  reason: collision with root package name */
        private final StorySlideContent f37684f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayContentWithFooter(String id, int i8, StorySlideButton storySlideButton, Long l8, String str, StorySlideContent content) {
            super(id, i8, storySlideButton, l8, null);
            Intrinsics.f(id, "id");
            Intrinsics.f(content, "content");
            this.f37683e = str;
            this.f37684f = content;
        }

        public final StorySlideContent e() {
            return this.f37684f;
        }

        public final String f() {
            return this.f37683e;
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class BottomSheetLikeContent extends StorySlide {

        /* renamed from: e  reason: collision with root package name */
        private final String f37685e;

        /* renamed from: f  reason: collision with root package name */
        private final String f37686f;

        /* renamed from: g  reason: collision with root package name */
        private final StorySlideAsset f37687g;

        public final String e() {
            return this.f37686f;
        }

        public StorySlideAsset f() {
            return this.f37687g;
        }

        public final String g() {
            return this.f37685e;
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class LeftContent extends StorySlide {

        /* renamed from: e  reason: collision with root package name */
        private final Integer f37688e;

        /* renamed from: f  reason: collision with root package name */
        private final String f37689f;

        /* renamed from: g  reason: collision with root package name */
        private final String f37690g;

        /* renamed from: h  reason: collision with root package name */
        private final String f37691h;

        /* renamed from: i  reason: collision with root package name */
        private final String f37692i;

        /* renamed from: j  reason: collision with root package name */
        private final StorySlideAsset f37693j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LeftContent(String id, int i8, Integer num, StorySlideButton storySlideButton, Long l8, String str, String str2, String str3, String str4, StorySlideAsset storySlideAsset) {
            super(id, i8, storySlideButton, l8, null);
            Intrinsics.f(id, "id");
            this.f37688e = num;
            this.f37689f = str;
            this.f37690g = str2;
            this.f37691h = str3;
            this.f37692i = str4;
            this.f37693j = storySlideAsset;
        }

        public final String e() {
            return this.f37691h;
        }

        public final String f() {
            return this.f37692i;
        }

        public StorySlideAsset g() {
            return this.f37693j;
        }

        public final Integer h() {
            return this.f37688e;
        }

        public final String i() {
            return this.f37689f;
        }

        public final String j() {
            return this.f37690g;
        }
    }

    private StorySlide(String str, int i8, StorySlideButton storySlideButton, Long l8) {
        this.f37679a = str;
        this.f37680b = i8;
        this.f37681c = storySlideButton;
        this.f37682d = l8;
    }

    public /* synthetic */ StorySlide(String str, int i8, StorySlideButton storySlideButton, Long l8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i8, storySlideButton, l8);
    }

    public final Long a() {
        return this.f37682d;
    }

    public final int b() {
        return this.f37680b;
    }

    public final StorySlideButton c() {
        return this.f37681c;
    }

    public final String d() {
        return this.f37679a;
    }
}
