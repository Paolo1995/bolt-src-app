package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class InAppButton implements Parcelable {
    public static final Parcelable.Creator<InAppButton> CREATOR = new Parcelable.Creator<InAppButton>() { // from class: com.mixpanel.android.mpmetrics.InAppButton.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InAppButton createFromParcel(Parcel parcel) {
            return new InAppButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InAppButton[] newArray(int i8) {
            return new InAppButton[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f19131f;

    /* renamed from: g  reason: collision with root package name */
    private String f19132g;

    /* renamed from: h  reason: collision with root package name */
    private int f19133h;

    /* renamed from: i  reason: collision with root package name */
    private int f19134i;

    /* renamed from: j  reason: collision with root package name */
    private int f19135j;

    /* renamed from: k  reason: collision with root package name */
    private String f19136k;

    public InAppButton(Parcel parcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
            Log.e("MixpanelAPI.InAppButton", "Error reading JSON when creating InAppButton from Parcel");
        }
        this.f19131f = jSONObject;
        this.f19132g = parcel.readString();
        this.f19133h = parcel.readInt();
        this.f19134i = parcel.readInt();
        this.f19135j = parcel.readInt();
        this.f19136k = parcel.readString();
    }

    public int a() {
        return this.f19134i;
    }

    public int b() {
        return this.f19135j;
    }

    public String c() {
        return this.f19136k;
    }

    public String d() {
        return this.f19132g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f19133h;
    }

    public String toString() {
        return this.f19131f.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f19131f.toString());
        parcel.writeString(this.f19132g);
        parcel.writeInt(this.f19133h);
        parcel.writeInt(this.f19134i);
        parcel.writeInt(this.f19135j);
        parcel.writeString(this.f19136k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InAppButton(JSONObject jSONObject) throws JSONException {
        this.f19131f = jSONObject;
        this.f19132g = jSONObject.getString("text");
        this.f19133h = jSONObject.getInt("text_color");
        this.f19134i = jSONObject.getInt("bg_color");
        this.f19135j = jSONObject.getInt("border_color");
        this.f19136k = jSONObject.getString("cta_url");
    }
}
