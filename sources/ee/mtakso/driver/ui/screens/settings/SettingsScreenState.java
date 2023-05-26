package ee.mtakso.driver.ui.screens.settings;

import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.theme.AppThemeMode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScreenState.kt */
/* loaded from: classes5.dex */
public final class SettingsScreenState {

    /* renamed from: a  reason: collision with root package name */
    private final String f33092a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33093b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33094c;

    /* renamed from: d  reason: collision with root package name */
    private final String f33095d;

    /* renamed from: e  reason: collision with root package name */
    private final String f33096e;

    /* renamed from: f  reason: collision with root package name */
    private final ReferralConfig f33097f;

    /* renamed from: g  reason: collision with root package name */
    private final String f33098g;

    /* renamed from: h  reason: collision with root package name */
    private final Text f33099h;

    /* renamed from: i  reason: collision with root package name */
    private final LanguageConfig f33100i;

    /* renamed from: j  reason: collision with root package name */
    private final QuickAccessConfig f33101j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f33102k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f33103l;

    /* renamed from: m  reason: collision with root package name */
    private final String f33104m;

    /* renamed from: n  reason: collision with root package name */
    private final DocumentsExpiringWarning f33105n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f33106o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f33107p;

    /* renamed from: q  reason: collision with root package name */
    private final WorkingTimeInfo f33108q;

    /* renamed from: r  reason: collision with root package name */
    private final AutoAcceptanceState f33109r;

    /* renamed from: s  reason: collision with root package name */
    private final DriverPricing f33110s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f33111t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f33112u;

    /* renamed from: v  reason: collision with root package name */
    private final AppThemeMode f33113v;

    public SettingsScreenState(String appVersion, boolean z7, String str, String str2, String phoneNumber, ReferralConfig referralConfig, String str3, Text text, LanguageConfig languageConfig, QuickAccessConfig quickAccessConfig, boolean z8, boolean z9, String str4, DocumentsExpiringWarning documentsExpiringWarning, boolean z10, boolean z11, WorkingTimeInfo workingTimeInfo, AutoAcceptanceState autoAcceptanceState, DriverPricing driverPricing, boolean z12, boolean z13, AppThemeMode appThemeMode) {
        Intrinsics.f(appVersion, "appVersion");
        Intrinsics.f(phoneNumber, "phoneNumber");
        Intrinsics.f(referralConfig, "referralConfig");
        Intrinsics.f(languageConfig, "languageConfig");
        Intrinsics.f(appThemeMode, "appThemeMode");
        this.f33092a = appVersion;
        this.f33093b = z7;
        this.f33094c = str;
        this.f33095d = str2;
        this.f33096e = phoneNumber;
        this.f33097f = referralConfig;
        this.f33098g = str3;
        this.f33099h = text;
        this.f33100i = languageConfig;
        this.f33101j = quickAccessConfig;
        this.f33102k = z8;
        this.f33103l = z9;
        this.f33104m = str4;
        this.f33105n = documentsExpiringWarning;
        this.f33106o = z10;
        this.f33107p = z11;
        this.f33108q = workingTimeInfo;
        this.f33109r = autoAcceptanceState;
        this.f33110s = driverPricing;
        this.f33111t = z12;
        this.f33112u = z13;
        this.f33113v = appThemeMode;
    }

    public final AppThemeMode a() {
        return this.f33113v;
    }

    public final String b() {
        return this.f33092a;
    }

    public final boolean c() {
        return this.f33093b;
    }

    public final boolean d() {
        return this.f33106o;
    }

    public final AutoAcceptanceState e() {
        return this.f33109r;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsScreenState) {
            SettingsScreenState settingsScreenState = (SettingsScreenState) obj;
            return Intrinsics.a(this.f33092a, settingsScreenState.f33092a) && this.f33093b == settingsScreenState.f33093b && Intrinsics.a(this.f33094c, settingsScreenState.f33094c) && Intrinsics.a(this.f33095d, settingsScreenState.f33095d) && Intrinsics.a(this.f33096e, settingsScreenState.f33096e) && Intrinsics.a(this.f33097f, settingsScreenState.f33097f) && Intrinsics.a(this.f33098g, settingsScreenState.f33098g) && Intrinsics.a(this.f33099h, settingsScreenState.f33099h) && Intrinsics.a(this.f33100i, settingsScreenState.f33100i) && Intrinsics.a(this.f33101j, settingsScreenState.f33101j) && this.f33102k == settingsScreenState.f33102k && this.f33103l == settingsScreenState.f33103l && Intrinsics.a(this.f33104m, settingsScreenState.f33104m) && Intrinsics.a(this.f33105n, settingsScreenState.f33105n) && this.f33106o == settingsScreenState.f33106o && this.f33107p == settingsScreenState.f33107p && Intrinsics.a(this.f33108q, settingsScreenState.f33108q) && this.f33109r == settingsScreenState.f33109r && Intrinsics.a(this.f33110s, settingsScreenState.f33110s) && this.f33111t == settingsScreenState.f33111t && this.f33112u == settingsScreenState.f33112u && this.f33113v == settingsScreenState.f33113v;
        }
        return false;
    }

    public final String f() {
        return this.f33098g;
    }

    public final boolean g() {
        return this.f33111t;
    }

    public final boolean h() {
        return this.f33112u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f33092a.hashCode() * 31;
        boolean z7 = this.f33093b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        String str = this.f33094c;
        int hashCode2 = (i9 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f33095d;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f33096e.hashCode()) * 31) + this.f33097f.hashCode()) * 31;
        String str3 = this.f33098g;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Text text = this.f33099h;
        int hashCode5 = (((hashCode4 + (text == null ? 0 : text.hashCode())) * 31) + this.f33100i.hashCode()) * 31;
        QuickAccessConfig quickAccessConfig = this.f33101j;
        int hashCode6 = (hashCode5 + (quickAccessConfig == null ? 0 : quickAccessConfig.hashCode())) * 31;
        boolean z8 = this.f33102k;
        int i10 = z8;
        if (z8 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode6 + i10) * 31;
        boolean z9 = this.f33103l;
        int i12 = z9;
        if (z9 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        String str4 = this.f33104m;
        int hashCode7 = (i13 + (str4 == null ? 0 : str4.hashCode())) * 31;
        DocumentsExpiringWarning documentsExpiringWarning = this.f33105n;
        int hashCode8 = (hashCode7 + (documentsExpiringWarning == null ? 0 : documentsExpiringWarning.hashCode())) * 31;
        boolean z10 = this.f33106o;
        int i14 = z10;
        if (z10 != 0) {
            i14 = 1;
        }
        int i15 = (hashCode8 + i14) * 31;
        boolean z11 = this.f33107p;
        int i16 = z11;
        if (z11 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        WorkingTimeInfo workingTimeInfo = this.f33108q;
        int hashCode9 = (i17 + (workingTimeInfo == null ? 0 : workingTimeInfo.hashCode())) * 31;
        AutoAcceptanceState autoAcceptanceState = this.f33109r;
        int hashCode10 = (hashCode9 + (autoAcceptanceState == null ? 0 : autoAcceptanceState.hashCode())) * 31;
        DriverPricing driverPricing = this.f33110s;
        int hashCode11 = (hashCode10 + (driverPricing != null ? driverPricing.hashCode() : 0)) * 31;
        boolean z12 = this.f33111t;
        int i18 = z12;
        if (z12 != 0) {
            i18 = 1;
        }
        int i19 = (hashCode11 + i18) * 31;
        boolean z13 = this.f33112u;
        return ((i19 + (z13 ? 1 : z13 ? 1 : 0)) * 31) + this.f33113v.hashCode();
    }

    public final DocumentsExpiringWarning i() {
        return this.f33105n;
    }

    public final String j() {
        return this.f33104m;
    }

    public final DriverPricing k() {
        return this.f33110s;
    }

    public final LanguageConfig l() {
        return this.f33100i;
    }

    public final boolean m() {
        return this.f33102k;
    }

    public final boolean n() {
        return this.f33107p;
    }

    public final Text o() {
        return this.f33099h;
    }

    public final boolean p() {
        return this.f33103l;
    }

    public final String q() {
        return this.f33096e;
    }

    public final QuickAccessConfig r() {
        return this.f33101j;
    }

    public final ReferralConfig s() {
        return this.f33097f;
    }

    public final String t() {
        return this.f33095d;
    }

    public String toString() {
        String str = this.f33092a;
        boolean z7 = this.f33093b;
        String str2 = this.f33094c;
        String str3 = this.f33095d;
        String str4 = this.f33096e;
        ReferralConfig referralConfig = this.f33097f;
        String str5 = this.f33098g;
        Text text = this.f33099h;
        LanguageConfig languageConfig = this.f33100i;
        QuickAccessConfig quickAccessConfig = this.f33101j;
        boolean z8 = this.f33102k;
        boolean z9 = this.f33103l;
        String str6 = this.f33104m;
        DocumentsExpiringWarning documentsExpiringWarning = this.f33105n;
        boolean z10 = this.f33106o;
        boolean z11 = this.f33107p;
        WorkingTimeInfo workingTimeInfo = this.f33108q;
        AutoAcceptanceState autoAcceptanceState = this.f33109r;
        DriverPricing driverPricing = this.f33110s;
        boolean z12 = this.f33111t;
        boolean z13 = this.f33112u;
        AppThemeMode appThemeMode = this.f33113v;
        return "SettingsScreenState(appVersion=" + str + ", appVersionShouldUpgrade=" + z7 + ", userName=" + str2 + ", userFullName=" + str3 + ", phoneNumber=" + str4 + ", referralConfig=" + referralConfig + ", car=" + str5 + ", navigatorName=" + text + ", languageConfig=" + languageConfig + ", quickAccessConfig=" + quickAccessConfig + ", logoutVisible=" + z8 + ", permissionGuideVisible=" + z9 + ", driverOperatorName=" + str6 + ", documentsExpiringWarning=" + documentsExpiringWarning + ", autoNavigationEnabled=" + z10 + ", mapDarkModeEnabled=" + z11 + ", workingTimeInfo=" + workingTimeInfo + ", autoacceptanceState=" + autoAcceptanceState + ", driverPricing=" + driverPricing + ", carApplicationsEnabled=" + z12 + ", darkModeEnabled=" + z13 + ", appThemeMode=" + appThemeMode + ")";
    }

    public final String u() {
        return this.f33094c;
    }

    public final WorkingTimeInfo v() {
        return this.f33108q;
    }
}
