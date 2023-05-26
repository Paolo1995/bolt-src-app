package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.dashboard.DashboardContentItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverHomeScreenResponse.kt */
/* loaded from: classes3.dex */
public abstract class HomeScreenItemPayload {

    /* compiled from: DriverHomeScreenResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Banner extends HomeScreenItemPayload {
        @SerializedName("icon")

        /* renamed from: a  reason: collision with root package name */
        private final DashboardContentItem.Icon f21844a;
        @SerializedName("title")

        /* renamed from: b  reason: collision with root package name */
        private final String f21845b;
        @SerializedName("description")

        /* renamed from: c  reason: collision with root package name */
        private final String f21846c;
        @SerializedName("action_url")

        /* renamed from: d  reason: collision with root package name */
        private final String f21847d;

        public final String a() {
            return this.f21847d;
        }

        public final String b() {
            return this.f21846c;
        }

        public final DashboardContentItem.Icon c() {
            return this.f21844a;
        }

        public final String d() {
            return this.f21845b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Banner) {
                Banner banner = (Banner) obj;
                return Intrinsics.a(this.f21844a, banner.f21844a) && Intrinsics.a(this.f21845b, banner.f21845b) && Intrinsics.a(this.f21846c, banner.f21846c) && Intrinsics.a(this.f21847d, banner.f21847d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f21844a.hashCode() * 31) + this.f21845b.hashCode()) * 31) + this.f21846c.hashCode()) * 31) + this.f21847d.hashCode();
        }

        public String toString() {
            DashboardContentItem.Icon icon = this.f21844a;
            String str = this.f21845b;
            String str2 = this.f21846c;
            String str3 = this.f21847d;
            return "Banner(icon=" + icon + ", title=" + str + ", description=" + str2 + ", actionUrl=" + str3 + ")";
        }
    }

    /* compiled from: DriverHomeScreenResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Title extends HomeScreenItemPayload {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f21848a;
        @SerializedName("title_appearance")

        /* renamed from: b  reason: collision with root package name */
        private final TitleAppearance f21849b;
        @SerializedName("value_text")

        /* renamed from: c  reason: collision with root package name */
        private final String f21850c;
        @SerializedName("value_icon_url")

        /* renamed from: d  reason: collision with root package name */
        private final String f21851d;
        @SerializedName("action_url")

        /* renamed from: e  reason: collision with root package name */
        private final String f21852e;
        @SerializedName("description")

        /* renamed from: f  reason: collision with root package name */
        private final String f21853f;
        @SerializedName("content")

        /* renamed from: g  reason: collision with root package name */
        private final List<DashboardContentItem> f21854g;

        public final String a() {
            return this.f21852e;
        }

        public final List<DashboardContentItem> b() {
            return this.f21854g;
        }

        public final String c() {
            return this.f21853f;
        }

        public final String d() {
            return this.f21848a;
        }

        public final TitleAppearance e() {
            return this.f21849b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Title) {
                Title title = (Title) obj;
                return Intrinsics.a(this.f21848a, title.f21848a) && Intrinsics.a(this.f21849b, title.f21849b) && Intrinsics.a(this.f21850c, title.f21850c) && Intrinsics.a(this.f21851d, title.f21851d) && Intrinsics.a(this.f21852e, title.f21852e) && Intrinsics.a(this.f21853f, title.f21853f) && Intrinsics.a(this.f21854g, title.f21854g);
            }
            return false;
        }

        public final String f() {
            return this.f21851d;
        }

        public final String g() {
            return this.f21850c;
        }

        public int hashCode() {
            int hashCode = this.f21848a.hashCode() * 31;
            TitleAppearance titleAppearance = this.f21849b;
            int hashCode2 = (((hashCode + (titleAppearance == null ? 0 : titleAppearance.hashCode())) * 31) + this.f21850c.hashCode()) * 31;
            String str = this.f21851d;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f21852e;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f21853f;
            return ((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f21854g.hashCode();
        }

        public String toString() {
            String str = this.f21848a;
            TitleAppearance titleAppearance = this.f21849b;
            String str2 = this.f21850c;
            String str3 = this.f21851d;
            String str4 = this.f21852e;
            String str5 = this.f21853f;
            List<DashboardContentItem> list = this.f21854g;
            return "Title(title=" + str + ", titleAppearance=" + titleAppearance + ", valueText=" + str2 + ", valueIconUrl=" + str3 + ", actionUrl=" + str4 + ", description=" + str5 + ", content=" + list + ")";
        }
    }

    /* compiled from: DriverHomeScreenResponse.kt */
    /* loaded from: classes3.dex */
    public static final class TitleAppearance {
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final TitleAppearanceType f21855a;
        @SerializedName("bg_color")

        /* renamed from: b  reason: collision with root package name */
        private final TitleAppearanceColor f21856b;

        public final TitleAppearanceColor a() {
            return this.f21856b;
        }

        public final TitleAppearanceType b() {
            return this.f21855a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TitleAppearance) {
                TitleAppearance titleAppearance = (TitleAppearance) obj;
                return this.f21855a == titleAppearance.f21855a && this.f21856b == titleAppearance.f21856b;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f21855a.hashCode() * 31;
            TitleAppearanceColor titleAppearanceColor = this.f21856b;
            return hashCode + (titleAppearanceColor == null ? 0 : titleAppearanceColor.hashCode());
        }

        public String toString() {
            TitleAppearanceType titleAppearanceType = this.f21855a;
            TitleAppearanceColor titleAppearanceColor = this.f21856b;
            return "TitleAppearance(type=" + titleAppearanceType + ", bgColor=" + titleAppearanceColor + ")";
        }
    }

    /* compiled from: DriverHomeScreenResponse.kt */
    /* loaded from: classes3.dex */
    public enum TitleAppearanceColor {
        ACTION,
        WARNING
    }

    /* compiled from: DriverHomeScreenResponse.kt */
    /* loaded from: classes3.dex */
    public enum TitleAppearanceType {
        TEXT,
        CHIP
    }

    private HomeScreenItemPayload() {
    }
}
