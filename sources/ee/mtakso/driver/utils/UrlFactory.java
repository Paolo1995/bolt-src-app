package ee.mtakso.driver.utils;

import ee.mtakso.driver.model.DeviceInfo;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* compiled from: UrlFactory.kt */
/* loaded from: classes5.dex */
public final class UrlFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f36332c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DeviceInfo f36333a;

    /* renamed from: b  reason: collision with root package name */
    private final LanguageManager f36334b;

    /* compiled from: UrlFactory.kt */
    /* loaded from: classes5.dex */
    public static final class AttributionData {

        /* renamed from: a  reason: collision with root package name */
        private final String f36335a;

        /* renamed from: b  reason: collision with root package name */
        private final String f36336b;

        public AttributionData(String str, String appsflyerId) {
            Intrinsics.f(appsflyerId, "appsflyerId");
            this.f36335a = str;
            this.f36336b = appsflyerId;
        }

        public final String a() {
            return this.f36335a;
        }

        public final String b() {
            return this.f36336b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AttributionData) {
                AttributionData attributionData = (AttributionData) obj;
                return Intrinsics.a(this.f36335a, attributionData.f36335a) && Intrinsics.a(this.f36336b, attributionData.f36336b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f36335a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f36336b.hashCode();
        }

        public String toString() {
            String str = this.f36335a;
            String str2 = this.f36336b;
            return "AttributionData(advertisingId=" + str + ", appsflyerId=" + str2 + ")";
        }
    }

    /* compiled from: UrlFactory.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public UrlFactory(DeviceInfo deviceInfo, LanguageManager languageManager) {
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(languageManager, "languageManager");
        this.f36333a = deviceInfo;
        this.f36334b = languageManager;
    }

    private final HttpUrl.Builder b(HttpUrl.Builder builder, AttributionData attributionData) {
        if (attributionData.a() != null) {
            builder.addQueryParameter("advertising_id", attributionData.a());
        }
        return builder.addQueryParameter("appsflyer_id", attributionData.b()).addQueryParameter("os_version", this.f36333a.d()).addQueryParameter("app_version", this.f36333a.a());
    }

    public final String a(String url, String key, String value) {
        Intrinsics.f(url, "url");
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        return HttpUrl.Companion.get(url).newBuilder().addQueryParameter(key, value).build().toString();
    }

    public final String c(String source) {
        Intrinsics.f(source, "source");
        return HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("documents").addQueryParameter("utm_source", "driver-app").addQueryParameter("utm_medium", source).build().toString();
    }

    public final String d(String section, String source) {
        Intrinsics.f(section, "section");
        Intrinsics.f(source, "source");
        return HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegments(section).addQueryParameter("utm_source", "driver-app").addQueryParameter("utm_medium", source).build().toString();
    }

    public final String e(String token, long j8) {
        Intrinsics.f(token, "token");
        return HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("v2").addPathSegment("vehicles").addPathSegment("application").addPathSegment(String.valueOf(j8)).addQueryParameter("t", token).build().toString();
    }

    public final String f() {
        return HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("login").addQueryParameter("utm_source", "driver-app").addQueryParameter("utm_medium", "menu-link").addQueryParameter("utm_campaign", "driver-app").build().toString();
    }

    public final String g(AttributionData attributionData) {
        Intrinsics.f(attributionData, "attributionData");
        return b(HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("driver-signup"), attributionData).addQueryParameter("utm_source", "driver-app").addQueryParameter("utm_medium", "menu-link").addQueryParameter("utm_campaign", "driver-app").addQueryParameter("new_signup", "true").build().toString();
    }

    public final String h(String token) {
        Intrinsics.f(token, "token");
        return HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("vehicles").addPathSegment("add").addQueryParameter("t", token).build().toString();
    }

    public final String i() {
        return "https://partners.taxify.eu/";
    }

    public final String j() {
        return "https://partnerDriver.live.boltsvc.net/";
    }

    public final String k() {
        return HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("forgotPassword").addQueryParameter("utm_source", "driver-app").addQueryParameter("utm_medium", "home-link").addQueryParameter("utm_campaign", "driver-app").addQueryParameter("lang", this.f36334b.e()).build().toString();
    }

    public final String l() {
        return "https://bolt.onelink.me/CgkX/9e720037";
    }

    public final String m(String token, AttributionData attributionData) {
        Intrinsics.f(token, "token");
        Intrinsics.f(attributionData, "attributionData");
        HttpUrl.Builder b8 = b(HttpUrl.Companion.get("https://signup.bolt.eu/").newBuilder().addPathSegment("driver"), attributionData);
        return b8.fragment("partner=" + token).build().toString();
    }

    public final String n(AttributionData attributionData) {
        Intrinsics.f(attributionData, "attributionData");
        return b(HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("driver-signup"), attributionData).addQueryParameter("utm_source", "driver-app").addQueryParameter("utm_medium", "menu-link").addQueryParameter("utm_campaign", "driver-app").build().toString();
    }

    public final String o(String token, AttributionData attributionData) {
        Intrinsics.f(token, "token");
        Intrinsics.f(attributionData, "attributionData");
        return b(HttpUrl.Companion.get("https://partners.taxify.eu/").newBuilder().addPathSegment("driver-signup").addPathSegment(token), attributionData).build().toString();
    }

    public final String p(String collectionId, int i8, int i9, int i10) {
        Intrinsics.f(collectionId, "collectionId");
        return HttpUrl.Companion.get("https://driver.live.boltsvc.net/").newBuilder().addPathSegments("driver/v2/getTile").addQueryParameter("tiles_collection_id", collectionId).addQueryParameter("x", String.valueOf(i8)).addQueryParameter("y", String.valueOf(i9)).addQueryParameter("zoom", String.valueOf(i10)).build().toString();
    }

    public final String q() {
        return "https://driver.live.boltsvc.net/";
    }
}
