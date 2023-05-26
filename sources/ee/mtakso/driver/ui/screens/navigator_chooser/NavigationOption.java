package ee.mtakso.driver.ui.screens.navigator_chooser;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationOption.kt */
@Keep
/* loaded from: classes3.dex */
public final class NavigationOption {
    private final String darkIconUrl;
    private final IntentDataHolder intentDataHolder;
    private final String lightIconUrl;
    private final String name;
    private final boolean recommended;

    public NavigationOption(String name, String str, String str2, boolean z7, IntentDataHolder intentDataHolder) {
        Intrinsics.f(name, "name");
        this.name = name;
        this.lightIconUrl = str;
        this.darkIconUrl = str2;
        this.recommended = z7;
        this.intentDataHolder = intentDataHolder;
    }

    public static /* synthetic */ NavigationOption copy$default(NavigationOption navigationOption, String str, String str2, String str3, boolean z7, IntentDataHolder intentDataHolder, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = navigationOption.name;
        }
        if ((i8 & 2) != 0) {
            str2 = navigationOption.lightIconUrl;
        }
        String str4 = str2;
        if ((i8 & 4) != 0) {
            str3 = navigationOption.darkIconUrl;
        }
        String str5 = str3;
        if ((i8 & 8) != 0) {
            z7 = navigationOption.recommended;
        }
        boolean z8 = z7;
        if ((i8 & 16) != 0) {
            intentDataHolder = navigationOption.intentDataHolder;
        }
        return navigationOption.copy(str, str4, str5, z8, intentDataHolder);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.lightIconUrl;
    }

    public final String component3() {
        return this.darkIconUrl;
    }

    public final boolean component4() {
        return this.recommended;
    }

    public final IntentDataHolder component5() {
        return this.intentDataHolder;
    }

    public final NavigationOption copy(String name, String str, String str2, boolean z7, IntentDataHolder intentDataHolder) {
        Intrinsics.f(name, "name");
        return new NavigationOption(name, str, str2, z7, intentDataHolder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigationOption) {
            NavigationOption navigationOption = (NavigationOption) obj;
            return Intrinsics.a(this.name, navigationOption.name) && Intrinsics.a(this.lightIconUrl, navigationOption.lightIconUrl) && Intrinsics.a(this.darkIconUrl, navigationOption.darkIconUrl) && this.recommended == navigationOption.recommended && Intrinsics.a(this.intentDataHolder, navigationOption.intentDataHolder);
        }
        return false;
    }

    public final String getDarkIconUrl() {
        return this.darkIconUrl;
    }

    public final IntentDataHolder getIntentDataHolder() {
        return this.intentDataHolder;
    }

    public final String getLightIconUrl() {
        return this.lightIconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRecommended() {
        return this.recommended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.lightIconUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.darkIconUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z7 = this.recommended;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode3 + i8) * 31;
        IntentDataHolder intentDataHolder = this.intentDataHolder;
        return i9 + (intentDataHolder != null ? intentDataHolder.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.lightIconUrl;
        String str3 = this.darkIconUrl;
        boolean z7 = this.recommended;
        IntentDataHolder intentDataHolder = this.intentDataHolder;
        return "NavigationOption(name=" + str + ", lightIconUrl=" + str2 + ", darkIconUrl=" + str3 + ", recommended=" + z7 + ", intentDataHolder=" + intentDataHolder + ")";
    }

    /* compiled from: NavigationOption.kt */
    @Keep
    /* loaded from: classes3.dex */
    public static final class IntentDataHolder {
        private final String action;
        private final Map<String, Object> extra;
        private final Long launchesLimit;
        private final String packageName;
        private final String startNavigationLink;
        private final String type;
        private final String url;

        public IntentDataHolder(String str, String str2, Long l8, String str3, String str4, String str5, Map<String, ? extends Object> map) {
            this.packageName = str;
            this.startNavigationLink = str2;
            this.launchesLimit = l8;
            this.action = str3;
            this.type = str4;
            this.url = str5;
            this.extra = map;
        }

        public static /* synthetic */ IntentDataHolder copy$default(IntentDataHolder intentDataHolder, String str, String str2, Long l8, String str3, String str4, String str5, Map map, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = intentDataHolder.packageName;
            }
            if ((i8 & 2) != 0) {
                str2 = intentDataHolder.startNavigationLink;
            }
            String str6 = str2;
            if ((i8 & 4) != 0) {
                l8 = intentDataHolder.launchesLimit;
            }
            Long l9 = l8;
            if ((i8 & 8) != 0) {
                str3 = intentDataHolder.action;
            }
            String str7 = str3;
            if ((i8 & 16) != 0) {
                str4 = intentDataHolder.type;
            }
            String str8 = str4;
            if ((i8 & 32) != 0) {
                str5 = intentDataHolder.url;
            }
            String str9 = str5;
            Map<String, Object> map2 = map;
            if ((i8 & 64) != 0) {
                map2 = intentDataHolder.extra;
            }
            return intentDataHolder.copy(str, str6, l9, str7, str8, str9, map2);
        }

        public final String component1() {
            return this.packageName;
        }

        public final String component2() {
            return this.startNavigationLink;
        }

        public final Long component3() {
            return this.launchesLimit;
        }

        public final String component4() {
            return this.action;
        }

        public final String component5() {
            return this.type;
        }

        public final String component6() {
            return this.url;
        }

        public final Map<String, Object> component7() {
            return this.extra;
        }

        public final IntentDataHolder copy(String str, String str2, Long l8, String str3, String str4, String str5, Map<String, ? extends Object> map) {
            return new IntentDataHolder(str, str2, l8, str3, str4, str5, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IntentDataHolder) {
                IntentDataHolder intentDataHolder = (IntentDataHolder) obj;
                return Intrinsics.a(this.packageName, intentDataHolder.packageName) && Intrinsics.a(this.startNavigationLink, intentDataHolder.startNavigationLink) && Intrinsics.a(this.launchesLimit, intentDataHolder.launchesLimit) && Intrinsics.a(this.action, intentDataHolder.action) && Intrinsics.a(this.type, intentDataHolder.type) && Intrinsics.a(this.url, intentDataHolder.url) && Intrinsics.a(this.extra, intentDataHolder.extra);
            }
            return false;
        }

        public final String getAction() {
            return this.action;
        }

        public final Map<String, Object> getExtra() {
            return this.extra;
        }

        public final Long getLaunchesLimit() {
            return this.launchesLimit;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getStartNavigationLink() {
            return this.startNavigationLink;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.packageName;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.startNavigationLink;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l8 = this.launchesLimit;
            int hashCode3 = (hashCode2 + (l8 == null ? 0 : l8.hashCode())) * 31;
            String str3 = this.action;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.type;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.url;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Map<String, Object> map = this.extra;
            return hashCode6 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            String str = this.packageName;
            String str2 = this.startNavigationLink;
            Long l8 = this.launchesLimit;
            String str3 = this.action;
            String str4 = this.type;
            String str5 = this.url;
            Map<String, Object> map = this.extra;
            return "IntentDataHolder(packageName=" + str + ", startNavigationLink=" + str2 + ", launchesLimit=" + l8 + ", action=" + str3 + ", type=" + str4 + ", url=" + str5 + ", extra=" + map + ")";
        }

        public /* synthetic */ IntentDataHolder(String str, String str2, Long l8, String str3, String str4, String str5, Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : str, str2, l8, str3, str4, str5, map);
        }
    }
}
