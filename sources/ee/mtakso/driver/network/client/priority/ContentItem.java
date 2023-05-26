package ee.mtakso.driver.network.client.priority;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentItem.kt */
/* loaded from: classes3.dex */
public abstract class ContentItem {

    /* compiled from: ContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Link extends ContentItem {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f22665a;
        @SerializedName("action_url")

        /* renamed from: b  reason: collision with root package name */
        private final String f22666b;

        public final String a() {
            return this.f22666b;
        }

        public final String b() {
            return this.f22665a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Link) {
                Link link = (Link) obj;
                return Intrinsics.a(this.f22665a, link.f22665a) && Intrinsics.a(this.f22666b, link.f22666b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f22665a.hashCode() * 31) + this.f22666b.hashCode();
        }

        public String toString() {
            String str = this.f22665a;
            String str2 = this.f22666b;
            return "Link(text=" + str + ", actionUrl=" + str2 + ")";
        }
    }

    /* compiled from: ContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Separator extends ContentItem {
        public Separator() {
            super(null);
        }
    }

    /* compiled from: ContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Text extends ContentItem {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f22667a;

        public final String a() {
            return this.f22667a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Text) && Intrinsics.a(this.f22667a, ((Text) obj).f22667a);
        }

        public int hashCode() {
            return this.f22667a.hashCode();
        }

        public String toString() {
            String str = this.f22667a;
            return "Text(text=" + str + ")";
        }
    }

    /* compiled from: ContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Unknown extends ContentItem {

        /* renamed from: a  reason: collision with root package name */
        public static final Unknown f22668a = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    private ContentItem() {
    }

    public /* synthetic */ ContentItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
