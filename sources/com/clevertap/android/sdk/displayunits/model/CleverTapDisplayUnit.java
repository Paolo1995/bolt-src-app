package com.clevertap.android.sdk.displayunits.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CleverTapDisplayUnit implements Parcelable {
    public static final Parcelable.Creator<CleverTapDisplayUnit> CREATOR = new Parcelable.Creator<CleverTapDisplayUnit>() { // from class: com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CleverTapDisplayUnit createFromParcel(Parcel parcel) {
            return new CleverTapDisplayUnit(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CleverTapDisplayUnit[] newArray(int i8) {
            return new CleverTapDisplayUnit[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f11143f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CleverTapDisplayUnitContent> f11144g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f11145h;

    /* renamed from: i  reason: collision with root package name */
    private String f11146i;

    /* renamed from: j  reason: collision with root package name */
    private JSONObject f11147j;

    /* renamed from: k  reason: collision with root package name */
    private CTDisplayUnitType f11148k;

    /* renamed from: l  reason: collision with root package name */
    private String f11149l;

    @NonNull
    public static CleverTapDisplayUnit c(JSONObject jSONObject) {
        String str;
        CTDisplayUnitType cTDisplayUnitType;
        String str2;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        try {
            if (jSONObject.has("wzrk_id")) {
                str = jSONObject.getString("wzrk_id");
            } else {
                str = "0_0";
            }
            String str3 = str;
            if (jSONObject.has("type")) {
                cTDisplayUnitType = CTDisplayUnitType.a(jSONObject.getString("type"));
            } else {
                cTDisplayUnitType = null;
            }
            if (jSONObject.has("bg")) {
                str2 = jSONObject.getString("bg");
            } else {
                str2 = "";
            }
            String str4 = str2;
            if (jSONObject.has("content")) {
                jSONArray = jSONObject.getJSONArray("content");
            } else {
                jSONArray = null;
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    CleverTapDisplayUnitContent a8 = CleverTapDisplayUnitContent.a(jSONArray.getJSONObject(i8));
                    if (TextUtils.isEmpty(a8.getError())) {
                        arrayList.add(a8);
                    }
                }
            }
            if (jSONObject.has("custom_kv")) {
                jSONObject2 = jSONObject.getJSONObject("custom_kv");
            } else {
                jSONObject2 = null;
            }
            return new CleverTapDisplayUnit(jSONObject, str3, cTDisplayUnitType, str4, arrayList, jSONObject2, null);
        } catch (Exception e8) {
            Logger.b("DisplayUnit : ", "Unable to init CleverTapDisplayUnit with JSON - " + e8.getLocalizedMessage());
            return new CleverTapDisplayUnit(null, "", null, null, null, null, "Error Creating Display Unit from JSON : " + e8.getLocalizedMessage());
        }
    }

    HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    HashMap<String, String> hashMap = null;
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject.getString(next);
                        if (!TextUtils.isEmpty(next)) {
                            if (hashMap == null) {
                                hashMap = new HashMap<>();
                            }
                            hashMap.put(next, string);
                        }
                    }
                    return hashMap;
                }
            } catch (Exception e8) {
                Logger.b("DisplayUnit : ", "Error in getting Key Value Pairs " + e8.getLocalizedMessage());
            }
        }
        return null;
    }

    public String b() {
        return this.f11149l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getError() {
        return this.f11146i;
    }

    @NonNull
    public String toString() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(" Unit id- ");
            sb.append(this.f11149l);
            sb.append(", Type- ");
            CTDisplayUnitType cTDisplayUnitType = this.f11148k;
            if (cTDisplayUnitType != null) {
                str = cTDisplayUnitType.toString();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(", bgColor- ");
            sb.append(this.f11143f);
            ArrayList<CleverTapDisplayUnitContent> arrayList = this.f11144g;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i8 = 0; i8 < this.f11144g.size(); i8++) {
                    CleverTapDisplayUnitContent cleverTapDisplayUnitContent = this.f11144g.get(i8);
                    if (cleverTapDisplayUnitContent != null) {
                        sb.append(", Content Item:");
                        sb.append(i8);
                        sb.append(" ");
                        sb.append(cleverTapDisplayUnitContent.toString());
                        sb.append("\n");
                    }
                }
            }
            if (this.f11145h != null) {
                sb.append(", Custom KV:");
                sb.append(this.f11145h);
            }
            sb.append(", JSON -");
            sb.append(this.f11147j);
            sb.append(", Error-");
            sb.append(this.f11146i);
            sb.append(" ]");
            return sb.toString();
        } catch (Exception e8) {
            Logger.b("DisplayUnit : ", "Exception in toString:" + e8);
            return super.toString();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11149l);
        parcel.writeValue(this.f11148k);
        parcel.writeString(this.f11143f);
        if (this.f11144g == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f11144g);
        }
        parcel.writeMap(this.f11145h);
        if (this.f11147j == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11147j.toString());
        }
        parcel.writeString(this.f11146i);
    }

    private CleverTapDisplayUnit(JSONObject jSONObject, String str, CTDisplayUnitType cTDisplayUnitType, String str2, ArrayList<CleverTapDisplayUnitContent> arrayList, JSONObject jSONObject2, String str3) {
        this.f11147j = jSONObject;
        this.f11149l = str;
        this.f11148k = cTDisplayUnitType;
        this.f11143f = str2;
        this.f11144g = arrayList;
        this.f11145h = a(jSONObject2);
        this.f11146i = str3;
    }

    private CleverTapDisplayUnit(Parcel parcel) {
        try {
            this.f11149l = parcel.readString();
            this.f11148k = (CTDisplayUnitType) parcel.readValue(CTDisplayUnitType.class.getClassLoader());
            this.f11143f = parcel.readString();
            JSONObject jSONObject = null;
            if (parcel.readByte() == 1) {
                ArrayList<CleverTapDisplayUnitContent> arrayList = new ArrayList<>();
                this.f11144g = arrayList;
                parcel.readList(arrayList, CleverTapDisplayUnitContent.class.getClassLoader());
            } else {
                this.f11144g = null;
            }
            this.f11145h = parcel.readHashMap(null);
            if (parcel.readByte() != 0) {
                jSONObject = new JSONObject(parcel.readString());
            }
            this.f11147j = jSONObject;
            this.f11146i = parcel.readString();
        } catch (Exception e8) {
            String str = "Error Creating Display Unit from parcel : " + e8.getLocalizedMessage();
            this.f11146i = str;
            Logger.b("DisplayUnit : ", str);
        }
    }
}
