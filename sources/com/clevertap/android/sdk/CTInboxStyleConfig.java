package com.clevertap.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CTInboxStyleConfig implements Parcelable {
    public static final Parcelable.Creator<CTInboxStyleConfig> CREATOR = new Parcelable.Creator<CTInboxStyleConfig>() { // from class: com.clevertap.android.sdk.CTInboxStyleConfig.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CTInboxStyleConfig createFromParcel(Parcel parcel) {
            return new CTInboxStyleConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CTInboxStyleConfig[] newArray(int i8) {
            return new CTInboxStyleConfig[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f10841f;

    /* renamed from: g  reason: collision with root package name */
    private String f10842g;

    /* renamed from: h  reason: collision with root package name */
    private String f10843h;

    /* renamed from: i  reason: collision with root package name */
    private String f10844i;

    /* renamed from: j  reason: collision with root package name */
    private String f10845j;

    /* renamed from: k  reason: collision with root package name */
    private String f10846k;

    /* renamed from: l  reason: collision with root package name */
    private String f10847l;

    /* renamed from: m  reason: collision with root package name */
    private String f10848m;

    /* renamed from: n  reason: collision with root package name */
    private String f10849n;

    /* renamed from: o  reason: collision with root package name */
    private String f10850o;

    /* renamed from: p  reason: collision with root package name */
    private String f10851p;

    /* renamed from: q  reason: collision with root package name */
    private String[] f10852q;

    /* renamed from: r  reason: collision with root package name */
    private String f10853r;

    public CTInboxStyleConfig() {
        this.f10844i = "#FFFFFF";
        this.f10845j = "App Inbox";
        this.f10846k = "#333333";
        this.f10843h = "#D3D4DA";
        this.f10841f = "#333333";
        this.f10849n = "#1C84FE";
        this.f10853r = "#808080";
        this.f10850o = "#1C84FE";
        this.f10851p = "#FFFFFF";
        this.f10852q = new String[0];
        this.f10847l = "No Message(s) to show";
        this.f10848m = "#000000";
        this.f10842g = "ALL";
    }

    public String a() {
        return this.f10841f;
    }

    public String b() {
        return this.f10842g;
    }

    public String c() {
        return this.f10843h;
    }

    public String d() {
        return this.f10844i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f10845j;
    }

    public String f() {
        return this.f10846k;
    }

    public String g() {
        return this.f10847l;
    }

    public String h() {
        return this.f10848m;
    }

    public String i() {
        return this.f10849n;
    }

    public String j() {
        return this.f10850o;
    }

    public String l() {
        return this.f10851p;
    }

    public ArrayList<String> n() {
        if (this.f10852q == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(this.f10852q));
    }

    public String o() {
        return this.f10853r;
    }

    public boolean p() {
        String[] strArr = this.f10852q;
        if (strArr != null && strArr.length > 0) {
            return true;
        }
        return false;
    }

    public void q(String str) {
        this.f10841f = str;
    }

    public void r(String str) {
        this.f10843h = str;
    }

    public void s(String str) {
        this.f10844i = str;
    }

    public void t(String str) {
        this.f10845j = str;
    }

    public void u(String str) {
        this.f10846k = str;
    }

    public void v(String str) {
        this.f10847l = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f10844i);
        parcel.writeString(this.f10845j);
        parcel.writeString(this.f10846k);
        parcel.writeString(this.f10843h);
        parcel.writeStringArray(this.f10852q);
        parcel.writeString(this.f10841f);
        parcel.writeString(this.f10849n);
        parcel.writeString(this.f10853r);
        parcel.writeString(this.f10850o);
        parcel.writeString(this.f10851p);
        parcel.writeString(this.f10847l);
        parcel.writeString(this.f10848m);
        parcel.writeString(this.f10842g);
    }

    public void x(String str) {
        this.f10848m = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxStyleConfig(CTInboxStyleConfig cTInboxStyleConfig) {
        this.f10844i = cTInboxStyleConfig.f10844i;
        this.f10845j = cTInboxStyleConfig.f10845j;
        this.f10846k = cTInboxStyleConfig.f10846k;
        this.f10843h = cTInboxStyleConfig.f10843h;
        this.f10841f = cTInboxStyleConfig.f10841f;
        this.f10849n = cTInboxStyleConfig.f10849n;
        this.f10853r = cTInboxStyleConfig.f10853r;
        this.f10850o = cTInboxStyleConfig.f10850o;
        this.f10851p = cTInboxStyleConfig.f10851p;
        String[] strArr = cTInboxStyleConfig.f10852q;
        this.f10852q = strArr == null ? new String[0] : (String[]) Arrays.copyOf(strArr, strArr.length);
        this.f10847l = cTInboxStyleConfig.f10847l;
        this.f10848m = cTInboxStyleConfig.f10848m;
        this.f10842g = cTInboxStyleConfig.f10842g;
    }

    protected CTInboxStyleConfig(Parcel parcel) {
        this.f10844i = parcel.readString();
        this.f10845j = parcel.readString();
        this.f10846k = parcel.readString();
        this.f10843h = parcel.readString();
        this.f10852q = parcel.createStringArray();
        this.f10841f = parcel.readString();
        this.f10849n = parcel.readString();
        this.f10853r = parcel.readString();
        this.f10850o = parcel.readString();
        this.f10851p = parcel.readString();
        this.f10847l = parcel.readString();
        this.f10848m = parcel.readString();
        this.f10842g = parcel.readString();
    }
}
