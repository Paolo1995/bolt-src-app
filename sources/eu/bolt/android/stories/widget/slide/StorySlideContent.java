package eu.bolt.android.stories.widget.slide;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideContent.kt */
/* loaded from: classes5.dex */
public final class StorySlideContent {

    /* renamed from: a  reason: collision with root package name */
    private final Padding f37711a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37712b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37713c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Item> f37714d;

    /* compiled from: StorySlideContent.kt */
    /* loaded from: classes5.dex */
    public enum Align {
        START,
        CENTER,
        END
    }

    /* compiled from: StorySlideContent.kt */
    /* loaded from: classes5.dex */
    public static abstract class Item {

        /* renamed from: a  reason: collision with root package name */
        private final Align f37719a;

        /* compiled from: StorySlideContent.kt */
        /* loaded from: classes5.dex */
        public static final class Asset extends Item {

            /* renamed from: b  reason: collision with root package name */
            private final StorySlideAsset f37720b;

            /* renamed from: c  reason: collision with root package name */
            private final Align f37721c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Asset(StorySlideAsset image, Align align) {
                super(align, null);
                Intrinsics.f(image, "image");
                Intrinsics.f(align, "align");
                this.f37720b = image;
                this.f37721c = align;
            }

            public Align a() {
                return this.f37721c;
            }

            public final StorySlideAsset b() {
                return this.f37720b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Asset) {
                    Asset asset = (Asset) obj;
                    return Intrinsics.a(this.f37720b, asset.f37720b) && a() == asset.a();
                }
                return false;
            }

            public int hashCode() {
                return (this.f37720b.hashCode() * 31) + a().hashCode();
            }

            public String toString() {
                StorySlideAsset storySlideAsset = this.f37720b;
                Align a8 = a();
                return "Asset(image=" + storySlideAsset + ", align=" + a8 + ")";
            }
        }

        /* compiled from: StorySlideContent.kt */
        /* loaded from: classes5.dex */
        public static final class Text extends Item {

            /* renamed from: b  reason: collision with root package name */
            private final String f37722b;

            /* renamed from: c  reason: collision with root package name */
            private final String f37723c;

            /* renamed from: d  reason: collision with root package name */
            private final Align f37724d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Text(String str, String text, Align align) {
                super(align, null);
                Intrinsics.f(text, "text");
                Intrinsics.f(align, "align");
                this.f37722b = str;
                this.f37723c = text;
                this.f37724d = align;
            }

            public Align a() {
                return this.f37724d;
            }

            public final String b() {
                return this.f37722b;
            }

            public final String c() {
                return this.f37723c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Text) {
                    Text text = (Text) obj;
                    return Intrinsics.a(this.f37722b, text.f37722b) && Intrinsics.a(this.f37723c, text.f37723c) && a() == text.a();
                }
                return false;
            }

            public int hashCode() {
                String str = this.f37722b;
                return ((((str == null ? 0 : str.hashCode()) * 31) + this.f37723c.hashCode()) * 31) + a().hashCode();
            }

            public String toString() {
                String str = this.f37722b;
                String str2 = this.f37723c;
                Align a8 = a();
                return "Text(iconUrl=" + str + ", text=" + str2 + ", align=" + a8 + ")";
            }
        }

        private Item(Align align) {
            this.f37719a = align;
        }

        public /* synthetic */ Item(Align align, DefaultConstructorMarker defaultConstructorMarker) {
            this(align);
        }
    }

    /* compiled from: StorySlideContent.kt */
    /* loaded from: classes5.dex */
    public static final class Padding {

        /* renamed from: a  reason: collision with root package name */
        private final int f37725a;

        /* renamed from: b  reason: collision with root package name */
        private final int f37726b;

        /* renamed from: c  reason: collision with root package name */
        private final int f37727c;

        /* renamed from: d  reason: collision with root package name */
        private final int f37728d;

        public Padding(int i8, int i9, int i10, int i11) {
            this.f37725a = i8;
            this.f37726b = i9;
            this.f37727c = i10;
            this.f37728d = i11;
        }

        public final int a() {
            return this.f37727c;
        }

        public final int b() {
            return this.f37726b;
        }

        public final int c() {
            return this.f37728d;
        }

        public final int d() {
            return this.f37725a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Padding) {
                Padding padding = (Padding) obj;
                return this.f37725a == padding.f37725a && this.f37726b == padding.f37726b && this.f37727c == padding.f37727c && this.f37728d == padding.f37728d;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f37725a * 31) + this.f37726b) * 31) + this.f37727c) * 31) + this.f37728d;
        }

        public String toString() {
            int i8 = this.f37725a;
            int i9 = this.f37726b;
            int i10 = this.f37727c;
            int i11 = this.f37728d;
            return "Padding(top=" + i8 + ", left=" + i9 + ", bottom=" + i10 + ", right=" + i11 + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StorySlideContent(Padding padding, int i8, int i9, List<? extends Item> items) {
        Intrinsics.f(padding, "padding");
        Intrinsics.f(items, "items");
        this.f37711a = padding;
        this.f37712b = i8;
        this.f37713c = i9;
        this.f37714d = items;
    }

    public final int a() {
        return this.f37713c;
    }

    public final List<Item> b() {
        return this.f37714d;
    }

    public final int c() {
        return this.f37712b;
    }

    public final Padding d() {
        return this.f37711a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StorySlideContent) {
            StorySlideContent storySlideContent = (StorySlideContent) obj;
            return Intrinsics.a(this.f37711a, storySlideContent.f37711a) && this.f37712b == storySlideContent.f37712b && this.f37713c == storySlideContent.f37713c && Intrinsics.a(this.f37714d, storySlideContent.f37714d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f37711a.hashCode() * 31) + this.f37712b) * 31) + this.f37713c) * 31) + this.f37714d.hashCode();
    }

    public String toString() {
        Padding padding = this.f37711a;
        int i8 = this.f37712b;
        int i9 = this.f37713c;
        List<Item> list = this.f37714d;
        return "StorySlideContent(padding=" + padding + ", itemsSpacing=" + i8 + ", backgroundColor=" + i9 + ", items=" + list + ")";
    }
}
