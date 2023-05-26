package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.pushnotification.PushNotificationUtil;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import com.sinch.android.rtc.internal.DefaultFcmPushConfigurationBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CleverTapInstanceConfig implements Parcelable {
    public static final Parcelable.Creator<CleverTapInstanceConfig> CREATOR = new Parcelable.Creator<CleverTapInstanceConfig>() { // from class: com.clevertap.android.sdk.CleverTapInstanceConfig.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CleverTapInstanceConfig createFromParcel(Parcel parcel) {
            return new CleverTapInstanceConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CleverTapInstanceConfig[] newArray(int i8) {
            return new CleverTapInstanceConfig[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f10905f;

    /* renamed from: g  reason: collision with root package name */
    private String f10906g;

    /* renamed from: h  reason: collision with root package name */
    private String f10907h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f10908i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10909j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10910k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10911l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10912m;

    /* renamed from: n  reason: collision with root package name */
    private int f10913n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10914o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10915p;

    /* renamed from: q  reason: collision with root package name */
    private String f10916q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10917r;

    /* renamed from: s  reason: collision with root package name */
    private Logger f10918s;

    /* renamed from: t  reason: collision with root package name */
    private String f10919t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10920u;

    /* renamed from: v  reason: collision with root package name */
    private String[] f10921v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10922w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10923x;

    /* JADX INFO: Access modifiers changed from: protected */
    public static CleverTapInstanceConfig a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        return new CleverTapInstanceConfig(context, str, str2, str3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CleverTapInstanceConfig b(@NonNull String str) {
        try {
            return new CleverTapInstanceConfig(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h(@NonNull String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!TextUtils.isEmpty(str)) {
            str2 = ":" + str;
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(":");
        sb.append(this.f10905f);
        sb.append("]");
        return sb.toString();
    }

    public void A(@NonNull String str, @NonNull String str2) {
        this.f10918s.s(h(str), str2);
    }

    public void B(@NonNull String str, @NonNull String str2, Throwable th) {
        this.f10918s.t(h(str), str2, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        this.f10912m = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String D() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accountId", c());
            jSONObject.put("accountToken", e());
            jSONObject.put("accountRegion", d());
            jSONObject.put(DefaultFcmPushConfigurationBuilder.FCM_SENDER_ID_KEY, j());
            jSONObject.put("analyticsOnly", p());
            jSONObject.put("isDefaultInstance", t());
            jSONObject.put("useGoogleAdId", z());
            jSONObject.put("disableAppLaunchedEvent", u());
            jSONObject.put("personalization", v());
            jSONObject.put("debugLevel", g());
            jSONObject.put("createdPostAppLaunch", s());
            jSONObject.put("sslPinning", x());
            jSONObject.put("backgroundSync", q());
            jSONObject.put("getEnableCustomCleverTapId", i());
            jSONObject.put("packageName", o());
            jSONObject.put("beta", r());
            jSONObject.put("allowedPushTypes", CTJsonConverter.i(this.f10908i));
            return jSONObject.toString();
        } catch (Throwable th) {
            Logger.q("Unable to convert config to JSON : ", th.getCause());
            return null;
        }
    }

    public String c() {
        return this.f10905f;
    }

    public String d() {
        return this.f10906g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f10907h;
    }

    @NonNull
    public ArrayList<String> f() {
        return this.f10908i;
    }

    public int g() {
        return this.f10913n;
    }

    public boolean i() {
        return this.f10915p;
    }

    public String j() {
        return this.f10916q;
    }

    public String[] l() {
        return this.f10921v;
    }

    public Logger n() {
        if (this.f10918s == null) {
            this.f10918s = new Logger(this.f10913n);
        }
        return this.f10918s;
    }

    public String o() {
        return this.f10919t;
    }

    public boolean p() {
        return this.f10909j;
    }

    public boolean q() {
        return this.f10910k;
    }

    public boolean r() {
        return this.f10911l;
    }

    public boolean s() {
        return this.f10912m;
    }

    public boolean t() {
        return this.f10917r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return this.f10914o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        return this.f10920u;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f10905f);
        parcel.writeString(this.f10907h);
        parcel.writeString(this.f10906g);
        parcel.writeByte(this.f10909j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10917r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10923x ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10914o ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10920u ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f10913n);
        parcel.writeByte(this.f10912m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10922w ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10910k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10915p ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10916q);
        parcel.writeString(this.f10919t);
        parcel.writeByte(this.f10911l ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f10908i);
        parcel.writeStringArray(this.f10921v);
    }

    public boolean x() {
        return this.f10922w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.f10923x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CleverTapInstanceConfig(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f10908i = PushNotificationUtil.a();
        this.f10921v = Constants.f10929e;
        this.f10905f = cleverTapInstanceConfig.f10905f;
        this.f10907h = cleverTapInstanceConfig.f10907h;
        this.f10906g = cleverTapInstanceConfig.f10906g;
        this.f10917r = cleverTapInstanceConfig.f10917r;
        this.f10909j = cleverTapInstanceConfig.f10909j;
        this.f10920u = cleverTapInstanceConfig.f10920u;
        this.f10913n = cleverTapInstanceConfig.f10913n;
        this.f10918s = cleverTapInstanceConfig.f10918s;
        this.f10923x = cleverTapInstanceConfig.f10923x;
        this.f10914o = cleverTapInstanceConfig.f10914o;
        this.f10912m = cleverTapInstanceConfig.f10912m;
        this.f10922w = cleverTapInstanceConfig.f10922w;
        this.f10910k = cleverTapInstanceConfig.f10910k;
        this.f10915p = cleverTapInstanceConfig.f10915p;
        this.f10916q = cleverTapInstanceConfig.f10916q;
        this.f10919t = cleverTapInstanceConfig.f10919t;
        this.f10911l = cleverTapInstanceConfig.f10911l;
        this.f10908i = cleverTapInstanceConfig.f10908i;
        this.f10921v = cleverTapInstanceConfig.f10921v;
    }

    private CleverTapInstanceConfig(Context context, String str, String str2, String str3, boolean z7) {
        this.f10908i = PushNotificationUtil.a();
        this.f10921v = Constants.f10929e;
        this.f10905f = str;
        this.f10907h = str2;
        this.f10906g = str3;
        this.f10917r = z7;
        this.f10909j = false;
        this.f10920u = true;
        int a8 = CleverTapAPI.LogLevel.INFO.a();
        this.f10913n = a8;
        this.f10918s = new Logger(a8);
        this.f10912m = false;
        ManifestInfo i8 = ManifestInfo.i(context);
        this.f10923x = i8.s();
        this.f10914o = i8.n();
        this.f10922w = i8.p();
        this.f10910k = i8.o();
        this.f10916q = i8.h();
        this.f10919t = i8.l();
        this.f10915p = i8.r();
        this.f10911l = i8.c();
        if (this.f10917r) {
            this.f10921v = i8.m();
            A("ON_USER_LOGIN", "Setting Profile Keys from Manifest: " + Arrays.toString(this.f10921v));
        }
    }

    private CleverTapInstanceConfig(String str) throws Throwable {
        this.f10908i = PushNotificationUtil.a();
        this.f10921v = Constants.f10929e;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("accountId")) {
                this.f10905f = jSONObject.getString("accountId");
            }
            if (jSONObject.has("accountToken")) {
                this.f10907h = jSONObject.getString("accountToken");
            }
            if (jSONObject.has("accountRegion")) {
                this.f10906g = jSONObject.getString("accountRegion");
            }
            if (jSONObject.has("analyticsOnly")) {
                this.f10909j = jSONObject.getBoolean("analyticsOnly");
            }
            if (jSONObject.has("isDefaultInstance")) {
                this.f10917r = jSONObject.getBoolean("isDefaultInstance");
            }
            if (jSONObject.has("useGoogleAdId")) {
                this.f10923x = jSONObject.getBoolean("useGoogleAdId");
            }
            if (jSONObject.has("disableAppLaunchedEvent")) {
                this.f10914o = jSONObject.getBoolean("disableAppLaunchedEvent");
            }
            if (jSONObject.has("personalization")) {
                this.f10920u = jSONObject.getBoolean("personalization");
            }
            if (jSONObject.has("debugLevel")) {
                this.f10913n = jSONObject.getInt("debugLevel");
            }
            this.f10918s = new Logger(this.f10913n);
            if (jSONObject.has("packageName")) {
                this.f10919t = jSONObject.getString("packageName");
            }
            if (jSONObject.has("createdPostAppLaunch")) {
                this.f10912m = jSONObject.getBoolean("createdPostAppLaunch");
            }
            if (jSONObject.has("sslPinning")) {
                this.f10922w = jSONObject.getBoolean("sslPinning");
            }
            if (jSONObject.has("backgroundSync")) {
                this.f10910k = jSONObject.getBoolean("backgroundSync");
            }
            if (jSONObject.has("getEnableCustomCleverTapId")) {
                this.f10915p = jSONObject.getBoolean("getEnableCustomCleverTapId");
            }
            if (jSONObject.has(DefaultFcmPushConfigurationBuilder.FCM_SENDER_ID_KEY)) {
                this.f10916q = jSONObject.getString(DefaultFcmPushConfigurationBuilder.FCM_SENDER_ID_KEY);
            }
            if (jSONObject.has("beta")) {
                this.f10911l = jSONObject.getBoolean("beta");
            }
            if (jSONObject.has("allowedPushTypes")) {
                this.f10908i = CTJsonConverter.l(jSONObject.getJSONArray("allowedPushTypes"));
            }
            if (jSONObject.has("identityTypes")) {
                this.f10921v = (String[]) CTJsonConverter.h(jSONObject.getJSONArray("identityTypes"));
            }
        } catch (Throwable th) {
            Logger.q("Error constructing CleverTapInstanceConfig from JSON: " + str + ": ", th.getCause());
            throw th;
        }
    }

    private CleverTapInstanceConfig(Parcel parcel) {
        this.f10908i = PushNotificationUtil.a();
        this.f10921v = Constants.f10929e;
        this.f10905f = parcel.readString();
        this.f10907h = parcel.readString();
        this.f10906g = parcel.readString();
        this.f10909j = parcel.readByte() != 0;
        this.f10917r = parcel.readByte() != 0;
        this.f10923x = parcel.readByte() != 0;
        this.f10914o = parcel.readByte() != 0;
        this.f10920u = parcel.readByte() != 0;
        this.f10913n = parcel.readInt();
        this.f10912m = parcel.readByte() != 0;
        this.f10922w = parcel.readByte() != 0;
        this.f10910k = parcel.readByte() != 0;
        this.f10915p = parcel.readByte() != 0;
        this.f10916q = parcel.readString();
        this.f10919t = parcel.readString();
        this.f10918s = new Logger(this.f10913n);
        this.f10911l = parcel.readByte() != 0;
        ArrayList<String> arrayList = new ArrayList<>();
        this.f10908i = arrayList;
        parcel.readList(arrayList, String.class.getClassLoader());
        this.f10921v = parcel.createStringArray();
    }
}
