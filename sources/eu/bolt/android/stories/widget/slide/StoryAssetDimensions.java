package eu.bolt.android.stories.widget.slide;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoryAssetDimensions.kt */
/* loaded from: classes5.dex */
public abstract class StoryAssetDimensions {

    /* compiled from: StoryAssetDimensions.kt */
    /* loaded from: classes5.dex */
    public static final class Fixed extends StoryAssetDimensions {

        /* renamed from: a  reason: collision with root package name */
        private final int f37666a;

        /* renamed from: b  reason: collision with root package name */
        private final int f37667b;

        public Fixed(int i8, int i9) {
            super(null);
            this.f37666a = i8;
            this.f37667b = i9;
        }

        public final int a() {
            return this.f37667b;
        }

        public final int b() {
            return this.f37666a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                Fixed fixed = (Fixed) obj;
                return this.f37666a == fixed.f37666a && this.f37667b == fixed.f37667b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f37666a * 31) + this.f37667b;
        }

        public String toString() {
            int i8 = this.f37666a;
            int i9 = this.f37667b;
            return "Fixed(width=" + i8 + ", height=" + i9 + ")";
        }
    }

    /* compiled from: StoryAssetDimensions.kt */
    /* loaded from: classes5.dex */
    public static final class MatchWidth extends StoryAssetDimensions {

        /* renamed from: a  reason: collision with root package name */
        public static final MatchWidth f37668a = new MatchWidth();

        private MatchWidth() {
            super(null);
        }
    }

    private StoryAssetDimensions() {
    }

    public /* synthetic */ StoryAssetDimensions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
