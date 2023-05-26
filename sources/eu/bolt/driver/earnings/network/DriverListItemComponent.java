package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverListItemComponent.kt */
@JsonAdapter(DriverListItemComponentDeserializer.class)
/* loaded from: classes5.dex */
public abstract class DriverListItemComponent {

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public static final class Chip extends DriverListItemComponent {
        @SerializedName("chip")

        /* renamed from: a  reason: collision with root package name */
        private final DriverChip f41391a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Chip) && Intrinsics.a(this.f41391a, ((Chip) obj).f41391a);
        }

        public int hashCode() {
            return this.f41391a.hashCode();
        }

        public String toString() {
            DriverChip driverChip = this.f41391a;
            return "Chip(chip=" + driverChip + ")";
        }
    }

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public static final class Empty extends DriverListItemComponent {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f41392a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public static final class Image extends DriverListItemComponent {
        @SerializedName("image")

        /* renamed from: a  reason: collision with root package name */
        private final DriverImage f41393a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Image) && Intrinsics.a(this.f41393a, ((Image) obj).f41393a);
        }

        public int hashCode() {
            return this.f41393a.hashCode();
        }

        public String toString() {
            DriverImage driverImage = this.f41393a;
            return "Image(image=" + driverImage + ")";
        }
    }

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public static final class Text extends DriverListItemComponent {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f41394a;
        @SerializedName("text_type")

        /* renamed from: b  reason: collision with root package name */
        private final DriverContentType f41395b;

        public final String a() {
            return this.f41394a;
        }

        public final DriverContentType b() {
            return this.f41395b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Text) {
                Text text = (Text) obj;
                return Intrinsics.a(this.f41394a, text.f41394a) && this.f41395b == text.f41395b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f41394a.hashCode() * 31) + this.f41395b.hashCode();
        }

        public String toString() {
            String str = this.f41394a;
            DriverContentType driverContentType = this.f41395b;
            return "Text(text=" + str + ", textType=" + driverContentType + ")";
        }
    }

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public static final class TextImage extends DriverListItemComponent {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f41396a;
        @SerializedName("image")

        /* renamed from: b  reason: collision with root package name */
        private final DriverImage f41397b;

        public final DriverImage a() {
            return this.f41397b;
        }

        public final String b() {
            return this.f41396a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TextImage) {
                TextImage textImage = (TextImage) obj;
                return Intrinsics.a(this.f41396a, textImage.f41396a) && Intrinsics.a(this.f41397b, textImage.f41397b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f41396a.hashCode() * 31) + this.f41397b.hashCode();
        }

        public String toString() {
            String str = this.f41396a;
            DriverImage driverImage = this.f41397b;
            return "TextImage(text=" + str + ", image=" + driverImage + ")";
        }
    }

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public static final class TitleSubtitle extends DriverListItemComponent {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41398a;
        @SerializedName("title_type")

        /* renamed from: b  reason: collision with root package name */
        private final DriverContentType f41399b;
        @SerializedName("subtitle")

        /* renamed from: c  reason: collision with root package name */
        private final String f41400c;
        @SerializedName("subtitle_type")

        /* renamed from: d  reason: collision with root package name */
        private final DriverContentType f41401d;

        public final String a() {
            return this.f41400c;
        }

        public final DriverContentType b() {
            return this.f41401d;
        }

        public final String c() {
            return this.f41398a;
        }

        public final DriverContentType d() {
            return this.f41399b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TitleSubtitle) {
                TitleSubtitle titleSubtitle = (TitleSubtitle) obj;
                return Intrinsics.a(this.f41398a, titleSubtitle.f41398a) && this.f41399b == titleSubtitle.f41399b && Intrinsics.a(this.f41400c, titleSubtitle.f41400c) && this.f41401d == titleSubtitle.f41401d;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f41398a.hashCode() * 31;
            DriverContentType driverContentType = this.f41399b;
            int hashCode2 = (((hashCode + (driverContentType == null ? 0 : driverContentType.hashCode())) * 31) + this.f41400c.hashCode()) * 31;
            DriverContentType driverContentType2 = this.f41401d;
            return hashCode2 + (driverContentType2 != null ? driverContentType2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f41398a;
            DriverContentType driverContentType = this.f41399b;
            String str2 = this.f41400c;
            DriverContentType driverContentType2 = this.f41401d;
            return "TitleSubtitle(title=" + str + ", titleType=" + driverContentType + ", subtitle=" + str2 + ", subtitleType=" + driverContentType2 + ")";
        }
    }

    /* compiled from: DriverListItemComponent.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        UNKNOWN,
        IMAGE,
        TEXT,
        CHIP,
        TEXT_IMAGE
    }

    private DriverListItemComponent() {
    }

    public /* synthetic */ DriverListItemComponent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
