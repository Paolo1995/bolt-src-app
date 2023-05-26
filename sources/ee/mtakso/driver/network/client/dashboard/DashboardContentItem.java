package ee.mtakso.driver.network.client.dashboard;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardContentItem.kt */
/* loaded from: classes3.dex */
public abstract class DashboardContentItem {

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class BadgeGroup extends DashboardContentItem {
        @SerializedName("badges")

        /* renamed from: a  reason: collision with root package name */
        private final List<ContentItemBadge> f21824a;

        public final List<ContentItemBadge> a() {
            return this.f21824a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BadgeGroup) && Intrinsics.a(this.f21824a, ((BadgeGroup) obj).f21824a);
        }

        public int hashCode() {
            return this.f21824a.hashCode();
        }

        public String toString() {
            List<ContentItemBadge> list = this.f21824a;
            return "BadgeGroup(badges=" + list + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Bonus extends DashboardContentItem {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f21825a;

        public final String a() {
            return this.f21825a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Bonus) && Intrinsics.a(this.f21825a, ((Bonus) obj).f21825a);
        }

        public int hashCode() {
            return this.f21825a.hashCode();
        }

        public String toString() {
            String str = this.f21825a;
            return "Bonus(text=" + str + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Button extends DashboardContentItem {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f21826a;
        @SerializedName("appearance")

        /* renamed from: b  reason: collision with root package name */
        private final ButtonAppearance f21827b;
        @SerializedName("action_url")

        /* renamed from: c  reason: collision with root package name */
        private final String f21828c;

        public final String a() {
            return this.f21828c;
        }

        public final ButtonAppearance b() {
            return this.f21827b;
        }

        public final String c() {
            return this.f21826a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Button) {
                Button button = (Button) obj;
                return Intrinsics.a(this.f21826a, button.f21826a) && this.f21827b == button.f21827b && Intrinsics.a(this.f21828c, button.f21828c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f21826a.hashCode() * 31) + this.f21827b.hashCode()) * 31) + this.f21828c.hashCode();
        }

        public String toString() {
            String str = this.f21826a;
            ButtonAppearance buttonAppearance = this.f21827b;
            String str2 = this.f21828c;
            return "Button(title=" + str + ", appearance=" + buttonAppearance + ", actionUrl=" + str2 + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Counters extends DashboardContentItem {
        @SerializedName("label")

        /* renamed from: a  reason: collision with root package name */
        private final String f21829a;
        @SerializedName("counters")

        /* renamed from: b  reason: collision with root package name */
        private final List<ContentItemCounter> f21830b;

        public final List<ContentItemCounter> a() {
            return this.f21830b;
        }

        public final String b() {
            return this.f21829a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Counters) {
                Counters counters = (Counters) obj;
                return Intrinsics.a(this.f21829a, counters.f21829a) && Intrinsics.a(this.f21830b, counters.f21830b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f21829a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f21830b.hashCode();
        }

        public String toString() {
            String str = this.f21829a;
            List<ContentItemCounter> list = this.f21830b;
            return "Counters(label=" + str + ", counters=" + list + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Icon extends DashboardContentItem {
        @SerializedName(ImagesContract.URL)

        /* renamed from: a  reason: collision with root package name */
        private final String f21831a;

        public final String a() {
            return this.f21831a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Icon) && Intrinsics.a(this.f21831a, ((Icon) obj).f21831a);
        }

        public int hashCode() {
            return this.f21831a.hashCode();
        }

        public String toString() {
            String str = this.f21831a;
            return "Icon(url=" + str + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Link extends DashboardContentItem {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f21832a;
        @SerializedName("action_url")

        /* renamed from: b  reason: collision with root package name */
        private final String f21833b;

        public final String a() {
            return this.f21833b;
        }

        public final String b() {
            return this.f21832a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Link) {
                Link link = (Link) obj;
                return Intrinsics.a(this.f21832a, link.f21832a) && Intrinsics.a(this.f21833b, link.f21833b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f21832a.hashCode() * 31) + this.f21833b.hashCode();
        }

        public String toString() {
            String str = this.f21832a;
            String str2 = this.f21833b;
            return "Link(text=" + str + ", actionUrl=" + str2 + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Separator extends DashboardContentItem {
        public Separator() {
            super(null);
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Tags extends DashboardContentItem {
        @SerializedName("tags")

        /* renamed from: a  reason: collision with root package name */
        private final List<ContentItemTag> f21834a;

        public final List<ContentItemTag> a() {
            return this.f21834a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tags) && Intrinsics.a(this.f21834a, ((Tags) obj).f21834a);
        }

        public int hashCode() {
            return this.f21834a.hashCode();
        }

        public String toString() {
            List<ContentItemTag> list = this.f21834a;
            return "Tags(tags=" + list + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Text extends DashboardContentItem {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f21835a;

        public final String a() {
            return this.f21835a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Text) && Intrinsics.a(this.f21835a, ((Text) obj).f21835a);
        }

        public int hashCode() {
            return this.f21835a.hashCode();
        }

        public String toString() {
            String str = this.f21835a;
            return "Text(text=" + str + ")";
        }
    }

    /* compiled from: DashboardContentItem.kt */
    /* loaded from: classes3.dex */
    public static final class Unknown extends DashboardContentItem {

        /* renamed from: a  reason: collision with root package name */
        public static final Unknown f21836a = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    private DashboardContentItem() {
    }

    public /* synthetic */ DashboardContentItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
