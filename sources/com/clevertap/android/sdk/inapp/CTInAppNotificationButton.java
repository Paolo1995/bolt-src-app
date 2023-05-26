package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTInAppNotificationButton implements Parcelable {
    public static final Parcelable.Creator<CTInAppNotificationButton> CREATOR = new Parcelable.Creator<CTInAppNotificationButton>() { // from class: com.clevertap.android.sdk.inapp.CTInAppNotificationButton.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CTInAppNotificationButton createFromParcel(Parcel parcel) {
            return new CTInAppNotificationButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CTInAppNotificationButton[] newArray(int i8) {
            return new CTInAppNotificationButton[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f11387f;

    /* renamed from: g  reason: collision with root package name */
    private String f11388g;

    /* renamed from: h  reason: collision with root package name */
    private String f11389h;

    /* renamed from: i  reason: collision with root package name */
    private String f11390i;

    /* renamed from: j  reason: collision with root package name */
    private String f11391j;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f11392k;

    /* renamed from: l  reason: collision with root package name */
    private HashMap<String, String> f11393l;

    /* renamed from: m  reason: collision with root package name */
    private String f11394m;

    /* renamed from: n  reason: collision with root package name */
    private String f11395n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotificationButton() {
    }

    private boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("type") && "kv".equalsIgnoreCase(jSONObject.getString("type")) && jSONObject.has("kv")) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.f11387f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f11388g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f11389h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f11390i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HashMap<String, String> e() {
        return this.f11393l;
    }

    public String f() {
        return this.f11394m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f11395n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getError() {
        return this.f11391j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotificationButton h(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Iterator<String> keys;
        try {
            this.f11392k = jSONObject;
            String str5 = "";
            if (!jSONObject.has("text")) {
                str = "";
            } else {
                str = jSONObject.getString("text");
            }
            this.f11394m = str;
            if (jSONObject.has("color")) {
                str2 = jSONObject.getString("color");
            } else {
                str2 = "#0000FF";
            }
            this.f11395n = str2;
            String str6 = "#FFFFFF";
            if (!jSONObject.has("bg")) {
                str3 = "#FFFFFF";
            } else {
                str3 = jSONObject.getString("bg");
            }
            this.f11388g = str3;
            if (jSONObject.has("border")) {
                str6 = jSONObject.getString("border");
            }
            this.f11389h = str6;
            if (!jSONObject.has("radius")) {
                str4 = "";
            } else {
                str4 = jSONObject.getString("radius");
            }
            this.f11390i = str4;
            if (jSONObject.has("actions")) {
                jSONObject2 = jSONObject.getJSONObject("actions");
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                if (jSONObject2.has("android")) {
                    str5 = jSONObject2.getString("android");
                }
                if (!str5.isEmpty()) {
                    this.f11387f = str5;
                }
            }
            if (i(jSONObject2) && (jSONObject3 = jSONObject2.getJSONObject("kv")) != null && (keys = jSONObject3.keys()) != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject3.getString(next);
                    if (!TextUtils.isEmpty(next)) {
                        if (this.f11393l == null) {
                            this.f11393l = new HashMap<>();
                        }
                        this.f11393l.put(next, string);
                    }
                }
            }
        } catch (JSONException unused) {
            this.f11391j = "Invalid JSON";
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11394m);
        parcel.writeString(this.f11395n);
        parcel.writeString(this.f11388g);
        parcel.writeString(this.f11387f);
        parcel.writeString(this.f11389h);
        parcel.writeString(this.f11390i);
        if (this.f11392k == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11392k.toString());
        }
        parcel.writeString(this.f11391j);
        parcel.writeMap(this.f11393l);
    }

    protected CTInAppNotificationButton(Parcel parcel) {
        this.f11394m = parcel.readString();
        this.f11395n = parcel.readString();
        this.f11388g = parcel.readString();
        this.f11387f = parcel.readString();
        this.f11389h = parcel.readString();
        this.f11390i = parcel.readString();
        try {
            this.f11392k = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        this.f11391j = parcel.readString();
        this.f11393l = parcel.readHashMap(null);
    }
}
