package com.clevertap.android.sdk.displayunits.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.Logger;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CleverTapDisplayUnitContent implements Parcelable {
    public static final Parcelable.Creator<CleverTapDisplayUnitContent> CREATOR = new Parcelable.Creator<CleverTapDisplayUnitContent>() { // from class: com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CleverTapDisplayUnitContent createFromParcel(Parcel parcel) {
            return new CleverTapDisplayUnitContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CleverTapDisplayUnitContent[] newArray(int i8) {
            return new CleverTapDisplayUnitContent[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f11150f;

    /* renamed from: g  reason: collision with root package name */
    private String f11151g;

    /* renamed from: h  reason: collision with root package name */
    private String f11152h;

    /* renamed from: i  reason: collision with root package name */
    private String f11153i;

    /* renamed from: j  reason: collision with root package name */
    private String f11154j;

    /* renamed from: k  reason: collision with root package name */
    private String f11155k;

    /* renamed from: l  reason: collision with root package name */
    private String f11156l;

    /* renamed from: m  reason: collision with root package name */
    private String f11157m;

    /* renamed from: n  reason: collision with root package name */
    private String f11158n;

    /* renamed from: o  reason: collision with root package name */
    private String f11159o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CleverTapDisplayUnitContent a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String str;
        String str2;
        JSONObject jSONObject3;
        String str3;
        String str4;
        JSONObject jSONObject4;
        String str5;
        JSONObject jSONObject5;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        try {
            JSONObject jSONObject8 = null;
            if (jSONObject.has("title")) {
                jSONObject2 = jSONObject.getJSONObject("title");
            } else {
                jSONObject2 = null;
            }
            String str17 = "";
            if (jSONObject2 == null) {
                str = "";
                str2 = str;
            } else {
                if (!jSONObject2.has("text")) {
                    str15 = "";
                } else {
                    str15 = jSONObject2.getString("text");
                }
                if (!jSONObject2.has("color")) {
                    str16 = "";
                } else {
                    str16 = jSONObject2.getString("color");
                }
                str2 = str16;
                str = str15;
            }
            if (jSONObject.has("message")) {
                jSONObject3 = jSONObject.getJSONObject("message");
            } else {
                jSONObject3 = null;
            }
            if (jSONObject3 == null) {
                str3 = "";
                str4 = str3;
            } else {
                if (!jSONObject3.has("text")) {
                    str13 = "";
                } else {
                    str13 = jSONObject3.getString("text");
                }
                if (!jSONObject3.has("color")) {
                    str14 = "";
                } else {
                    str14 = jSONObject3.getString("color");
                }
                str4 = str14;
                str3 = str13;
            }
            if (jSONObject.has("icon")) {
                jSONObject4 = jSONObject.getJSONObject("icon");
            } else {
                jSONObject4 = null;
            }
            if (jSONObject4 == null) {
                str5 = "";
            } else {
                if (!jSONObject4.has(ImagesContract.URL)) {
                    str12 = "";
                } else {
                    str12 = jSONObject4.getString(ImagesContract.URL);
                }
                str5 = str12;
            }
            if (jSONObject.has("media")) {
                jSONObject5 = jSONObject.getJSONObject("media");
            } else {
                jSONObject5 = null;
            }
            if (jSONObject5 == null) {
                str6 = "";
                str7 = str6;
                str8 = str7;
            } else {
                if (!jSONObject5.has(ImagesContract.URL)) {
                    str9 = "";
                } else {
                    str9 = jSONObject5.getString(ImagesContract.URL);
                }
                if (!jSONObject5.has("content_type")) {
                    str10 = "";
                } else {
                    str10 = jSONObject5.getString("content_type");
                }
                if (!jSONObject5.has("poster")) {
                    str11 = "";
                } else {
                    str11 = jSONObject5.getString("poster");
                }
                str8 = str11;
                str7 = str10;
                str6 = str9;
            }
            if (jSONObject.has("action")) {
                jSONObject6 = jSONObject.getJSONObject("action");
            } else {
                jSONObject6 = null;
            }
            if (jSONObject6 != null) {
                if (jSONObject6.has(ImagesContract.URL)) {
                    jSONObject7 = jSONObject6.getJSONObject(ImagesContract.URL);
                } else {
                    jSONObject7 = null;
                }
                if (jSONObject7 != null) {
                    if (jSONObject7.has("android")) {
                        jSONObject8 = jSONObject7.getJSONObject("android");
                    }
                    if (jSONObject8 != null && jSONObject8.has("text")) {
                        str17 = jSONObject8.getString("text");
                    }
                }
            }
            return new CleverTapDisplayUnitContent(str, str2, str3, str4, str5, str6, str7, str8, str17, null);
        } catch (Exception e8) {
            Logger.b("DisplayUnit : ", "Unable to init CleverTapDisplayUnitContent with JSON - " + e8.getLocalizedMessage());
            return new CleverTapDisplayUnitContent("", "", "", "", "", "", "", "", "", "Error Creating DisplayUnit Content from JSON : " + e8.getLocalizedMessage());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getError() {
        return this.f11152h;
    }

    @NonNull
    public String toString() {
        return "[ title:" + this.f11158n + ", titleColor:" + this.f11159o + " message:" + this.f11155k + ", messageColor:" + this.f11156l + ", media:" + this.f11154j + ", contentType:" + this.f11151g + ", posterUrl:" + this.f11157m + ", actionUrl:" + this.f11150f + ", icon:" + this.f11153i + ", error:" + this.f11152h + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11158n);
        parcel.writeString(this.f11159o);
        parcel.writeString(this.f11155k);
        parcel.writeString(this.f11156l);
        parcel.writeString(this.f11153i);
        parcel.writeString(this.f11154j);
        parcel.writeString(this.f11151g);
        parcel.writeString(this.f11157m);
        parcel.writeString(this.f11150f);
        parcel.writeString(this.f11152h);
    }

    private CleverTapDisplayUnitContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.f11158n = str;
        this.f11159o = str2;
        this.f11155k = str3;
        this.f11156l = str4;
        this.f11153i = str5;
        this.f11154j = str6;
        this.f11151g = str7;
        this.f11157m = str8;
        this.f11150f = str9;
        this.f11152h = str10;
    }

    private CleverTapDisplayUnitContent(Parcel parcel) {
        this.f11158n = parcel.readString();
        this.f11159o = parcel.readString();
        this.f11155k = parcel.readString();
        this.f11156l = parcel.readString();
        this.f11153i = parcel.readString();
        this.f11154j = parcel.readString();
        this.f11151g = parcel.readString();
        this.f11157m = parcel.readString();
        this.f11150f = parcel.readString();
        this.f11152h = parcel.readString();
    }
}
