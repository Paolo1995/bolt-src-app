package eu.bolt.android.stories.widget.slide;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideAsset.kt */
/* loaded from: classes5.dex */
public abstract class StorySlideAsset {

    /* renamed from: a  reason: collision with root package name */
    private final String f37694a;

    /* renamed from: b  reason: collision with root package name */
    private final StoryAssetDimensions f37695b;

    /* compiled from: StorySlideAsset.kt */
    /* loaded from: classes5.dex */
    public static final class Drawable extends StorySlideAsset {

        /* renamed from: c  reason: collision with root package name */
        private final String f37696c;

        /* renamed from: d  reason: collision with root package name */
        private final StoryAssetDimensions f37697d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drawable(String url, StoryAssetDimensions storyAssetDimensions) {
            super(url, storyAssetDimensions, null);
            Intrinsics.f(url, "url");
            this.f37696c = url;
            this.f37697d = storyAssetDimensions;
        }

        @Override // eu.bolt.android.stories.widget.slide.StorySlideAsset
        public StoryAssetDimensions a() {
            return this.f37697d;
        }

        @Override // eu.bolt.android.stories.widget.slide.StorySlideAsset
        public String b() {
            return this.f37696c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Drawable) {
                Drawable drawable = (Drawable) obj;
                return Intrinsics.a(b(), drawable.b()) && Intrinsics.a(a(), drawable.a());
            }
            return false;
        }

        public int hashCode() {
            return (b().hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String b8 = b();
            StoryAssetDimensions a8 = a();
            return "Drawable(url=" + b8 + ", dimensions=" + a8 + ")";
        }
    }

    /* compiled from: StorySlideAsset.kt */
    /* loaded from: classes5.dex */
    public static final class Lottie extends StorySlideAsset {

        /* renamed from: c  reason: collision with root package name */
        private final String f37698c;

        /* renamed from: d  reason: collision with root package name */
        private final StoryAssetDimensions f37699d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Lottie(String url, StoryAssetDimensions storyAssetDimensions) {
            super(url, storyAssetDimensions, null);
            Intrinsics.f(url, "url");
            this.f37698c = url;
            this.f37699d = storyAssetDimensions;
        }

        @Override // eu.bolt.android.stories.widget.slide.StorySlideAsset
        public StoryAssetDimensions a() {
            return this.f37699d;
        }

        @Override // eu.bolt.android.stories.widget.slide.StorySlideAsset
        public String b() {
            return this.f37698c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Lottie) {
                Lottie lottie = (Lottie) obj;
                return Intrinsics.a(b(), lottie.b()) && Intrinsics.a(a(), lottie.a());
            }
            return false;
        }

        public int hashCode() {
            return (b().hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String b8 = b();
            StoryAssetDimensions a8 = a();
            return "Lottie(url=" + b8 + ", dimensions=" + a8 + ")";
        }
    }

    private StorySlideAsset(String str, StoryAssetDimensions storyAssetDimensions) {
        this.f37694a = str;
        this.f37695b = storyAssetDimensions;
    }

    public /* synthetic */ StorySlideAsset(String str, StoryAssetDimensions storyAssetDimensions, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, storyAssetDimensions);
    }

    public StoryAssetDimensions a() {
        return this.f37695b;
    }

    public String b() {
        return this.f37694a;
    }
}
