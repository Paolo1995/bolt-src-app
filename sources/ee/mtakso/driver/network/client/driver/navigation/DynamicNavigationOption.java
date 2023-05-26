package ee.mtakso.driver.network.client.driver.navigation;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverImage;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicNavigationOption.kt */
@JsonAdapter(DynamicOptionDeserializer.class)
/* loaded from: classes3.dex */
public abstract class DynamicNavigationOption {

    /* compiled from: DynamicNavigationOption.kt */
    /* loaded from: classes3.dex */
    public enum DynamicNavigationType {
        UNKNOWN,
        NATIVE,
        THIRD_PARTY
    }

    /* compiled from: DynamicNavigationOption.kt */
    /* loaded from: classes3.dex */
    public static final class Native extends DynamicNavigationOption {
        @SerializedName("name")

        /* renamed from: a  reason: collision with root package name */
        private final String f22064a;
        @SerializedName("icon")

        /* renamed from: b  reason: collision with root package name */
        private final DriverImage f22065b;
        @SerializedName("recommended")

        /* renamed from: c  reason: collision with root package name */
        private final boolean f22066c;

        public final DriverImage a() {
            return this.f22065b;
        }

        public final String b() {
            return this.f22064a;
        }

        public final boolean c() {
            return this.f22066c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Native) {
                Native r52 = (Native) obj;
                return Intrinsics.a(this.f22064a, r52.f22064a) && Intrinsics.a(this.f22065b, r52.f22065b) && this.f22066c == r52.f22066c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f22064a.hashCode() * 31) + this.f22065b.hashCode()) * 31;
            boolean z7 = this.f22066c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f22064a;
            DriverImage driverImage = this.f22065b;
            boolean z7 = this.f22066c;
            return "Native(name=" + str + ", icon=" + driverImage + ", recommended=" + z7 + ")";
        }
    }

    /* compiled from: DynamicNavigationOption.kt */
    /* loaded from: classes3.dex */
    public static final class ThirdParty extends DynamicNavigationOption {
        @SerializedName("name")

        /* renamed from: a  reason: collision with root package name */
        private final String f22067a;
        @SerializedName("icon")

        /* renamed from: b  reason: collision with root package name */
        private final DriverImage f22068b;
        @SerializedName("recommended")

        /* renamed from: c  reason: collision with root package name */
        private final boolean f22069c;
        @SerializedName("package_name")

        /* renamed from: d  reason: collision with root package name */
        private final String f22070d;
        @SerializedName("intent")

        /* renamed from: e  reason: collision with root package name */
        private final Intent f22071e;
        @SerializedName("start_navigation_link")

        /* renamed from: f  reason: collision with root package name */
        private final String f22072f;
        @SerializedName("launches_limit")

        /* renamed from: g  reason: collision with root package name */
        private final Long f22073g;

        /* compiled from: DynamicNavigationOption.kt */
        /* loaded from: classes3.dex */
        public static final class Intent {
            @SerializedName("action")

            /* renamed from: a  reason: collision with root package name */
            private final String f22074a;
            @SerializedName("type")

            /* renamed from: b  reason: collision with root package name */
            private final String f22075b;
            @SerializedName(ImagesContract.URL)

            /* renamed from: c  reason: collision with root package name */
            private final String f22076c;
            @SerializedName("extra")

            /* renamed from: d  reason: collision with root package name */
            private final Map<String, Object> f22077d;

            public final String a() {
                return this.f22074a;
            }

            public final Map<String, Object> b() {
                return this.f22077d;
            }

            public final String c() {
                return this.f22075b;
            }

            public final String d() {
                return this.f22076c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Intent) {
                    Intent intent = (Intent) obj;
                    return Intrinsics.a(this.f22074a, intent.f22074a) && Intrinsics.a(this.f22075b, intent.f22075b) && Intrinsics.a(this.f22076c, intent.f22076c) && Intrinsics.a(this.f22077d, intent.f22077d);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f22074a.hashCode() * 31;
                String str = this.f22075b;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.f22076c;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                Map<String, Object> map = this.f22077d;
                return hashCode3 + (map != null ? map.hashCode() : 0);
            }

            public String toString() {
                String str = this.f22074a;
                String str2 = this.f22075b;
                String str3 = this.f22076c;
                Map<String, Object> map = this.f22077d;
                return "Intent(action=" + str + ", type=" + str2 + ", url=" + str3 + ", extra=" + map + ")";
            }
        }

        public final DriverImage a() {
            return this.f22068b;
        }

        public final Intent b() {
            return this.f22071e;
        }

        public final Long c() {
            return this.f22073g;
        }

        public final String d() {
            return this.f22067a;
        }

        public final String e() {
            return this.f22070d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThirdParty) {
                ThirdParty thirdParty = (ThirdParty) obj;
                return Intrinsics.a(this.f22067a, thirdParty.f22067a) && Intrinsics.a(this.f22068b, thirdParty.f22068b) && this.f22069c == thirdParty.f22069c && Intrinsics.a(this.f22070d, thirdParty.f22070d) && Intrinsics.a(this.f22071e, thirdParty.f22071e) && Intrinsics.a(this.f22072f, thirdParty.f22072f) && Intrinsics.a(this.f22073g, thirdParty.f22073g);
            }
            return false;
        }

        public final boolean f() {
            return this.f22069c;
        }

        public final String g() {
            return this.f22072f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f22067a.hashCode() * 31) + this.f22068b.hashCode()) * 31;
            boolean z7 = this.f22069c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int hashCode2 = (((hashCode + i8) * 31) + this.f22070d.hashCode()) * 31;
            Intent intent = this.f22071e;
            int hashCode3 = (hashCode2 + (intent == null ? 0 : intent.hashCode())) * 31;
            String str = this.f22072f;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Long l8 = this.f22073g;
            return hashCode4 + (l8 != null ? l8.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22067a;
            DriverImage driverImage = this.f22068b;
            boolean z7 = this.f22069c;
            String str2 = this.f22070d;
            Intent intent = this.f22071e;
            String str3 = this.f22072f;
            Long l8 = this.f22073g;
            return "ThirdParty(name=" + str + ", icon=" + driverImage + ", recommended=" + z7 + ", packageName=" + str2 + ", intent=" + intent + ", startNavigationLink=" + str3 + ", launchesLimit=" + l8 + ")";
        }
    }

    /* compiled from: DynamicNavigationOption.kt */
    /* loaded from: classes3.dex */
    public static final class Unknown extends DynamicNavigationOption {

        /* renamed from: a  reason: collision with root package name */
        public static final Unknown f22078a = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    private DynamicNavigationOption() {
    }

    public /* synthetic */ DynamicNavigationOption(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
