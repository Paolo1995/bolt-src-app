package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public class CTInboxMessage implements Parcelable {
    public static final Parcelable.Creator<CTInboxMessage> CREATOR = new Parcelable.Creator<CTInboxMessage>() { // from class: com.clevertap.android.sdk.inbox.CTInboxMessage.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CTInboxMessage createFromParcel(Parcel parcel) {
            return new CTInboxMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CTInboxMessage[] newArray(int i8) {
            return new CTInboxMessage[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f11543f;

    /* renamed from: g  reason: collision with root package name */
    private String f11544g;

    /* renamed from: h  reason: collision with root package name */
    private String f11545h;

    /* renamed from: i  reason: collision with root package name */
    private String f11546i;

    /* renamed from: j  reason: collision with root package name */
    private JSONObject f11547j;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f11548k;

    /* renamed from: l  reason: collision with root package name */
    private long f11549l;

    /* renamed from: m  reason: collision with root package name */
    private long f11550m;

    /* renamed from: n  reason: collision with root package name */
    private String f11551n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<CTInboxMessageContent> f11552o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11553p;

    /* renamed from: q  reason: collision with root package name */
    private String f11554q;

    /* renamed from: r  reason: collision with root package name */
    private String f11555r;

    /* renamed from: s  reason: collision with root package name */
    private List<String> f11556s;

    /* renamed from: t  reason: collision with root package name */
    private String f11557t;

    /* renamed from: u  reason: collision with root package name */
    private CTInboxMessageType f11558u;

    /* renamed from: v  reason: collision with root package name */
    private JSONObject f11559v;

    public String a() {
        return this.f11544g;
    }

    public String b() {
        return this.f11545h;
    }

    public ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CTInboxMessageContent> it = f().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().n());
        }
        return arrayList;
    }

    public long d() {
        return this.f11549l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f11551n;
    }

    public ArrayList<CTInboxMessageContent> f() {
        return this.f11552o;
    }

    public String g() {
        return this.f11554q;
    }

    public String h() {
        return this.f11555r;
    }

    public List<String> i() {
        return this.f11556s;
    }

    public String j() {
        return this.f11557t;
    }

    public CTInboxMessageType l() {
        return this.f11558u;
    }

    public JSONObject n() {
        JSONObject jSONObject = this.f11559v;
        if (jSONObject == null) {
            return new JSONObject();
        }
        return jSONObject;
    }

    public boolean o() {
        return this.f11553p;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11557t);
        parcel.writeString(this.f11545h);
        parcel.writeString(this.f11551n);
        parcel.writeString(this.f11543f);
        parcel.writeLong(this.f11549l);
        parcel.writeLong(this.f11550m);
        parcel.writeString(this.f11554q);
        if (this.f11548k == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11548k.toString());
        }
        if (this.f11547j == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11547j.toString());
        }
        parcel.writeByte(this.f11553p ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.f11558u);
        if (this.f11556s == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f11556s);
        }
        parcel.writeString(this.f11544g);
        if (this.f11552o == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f11552o);
        }
        parcel.writeString(this.f11555r);
        parcel.writeString(this.f11546i);
        if (this.f11559v == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeString(this.f11559v.toString());
    }

    public CTInboxMessage(JSONObject jSONObject) {
        this.f11552o = new ArrayList<>();
        this.f11556s = new ArrayList();
        this.f11548k = jSONObject;
        try {
            this.f11554q = jSONObject.has(Name.MARK) ? jSONObject.getString(Name.MARK) : "0";
            this.f11546i = jSONObject.has("wzrk_id") ? jSONObject.getString("wzrk_id") : "0_0";
            this.f11549l = jSONObject.has("date") ? jSONObject.getLong("date") : System.currentTimeMillis() / 1000;
            this.f11550m = jSONObject.has("wzrk_ttl") ? jSONObject.getLong("wzrk_ttl") : System.currentTimeMillis() + 86400000;
            this.f11553p = jSONObject.has("isRead") && jSONObject.getBoolean("isRead");
            JSONArray jSONArray = jSONObject.has("tags") ? jSONObject.getJSONArray("tags") : null;
            if (jSONArray != null) {
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    this.f11556s.add(jSONArray.getString(i8));
                }
            }
            JSONObject jSONObject2 = jSONObject.has("msg") ? jSONObject.getJSONObject("msg") : null;
            if (jSONObject2 != null) {
                this.f11558u = jSONObject2.has("type") ? CTInboxMessageType.a(jSONObject2.getString("type")) : CTInboxMessageType.a("");
                this.f11544g = jSONObject2.has("bg") ? jSONObject2.getString("bg") : "";
                JSONArray jSONArray2 = jSONObject2.has("content") ? jSONObject2.getJSONArray("content") : null;
                if (jSONArray2 != null) {
                    for (int i9 = 0; i9 < jSONArray2.length(); i9++) {
                        this.f11552o.add(new CTInboxMessageContent().t(jSONArray2.getJSONObject(i9)));
                    }
                }
                this.f11555r = jSONObject2.has("orientation") ? jSONObject2.getString("orientation") : "";
            }
            this.f11559v = jSONObject.has("wzrkParams") ? jSONObject.getJSONObject("wzrkParams") : null;
        } catch (JSONException e8) {
            Logger.n("Unable to init CTInboxMessage with JSON - " + e8.getLocalizedMessage());
        }
    }

    private CTInboxMessage(Parcel parcel) {
        this.f11552o = new ArrayList<>();
        this.f11556s = new ArrayList();
        try {
            this.f11557t = parcel.readString();
            this.f11545h = parcel.readString();
            this.f11551n = parcel.readString();
            this.f11543f = parcel.readString();
            this.f11549l = parcel.readLong();
            this.f11550m = parcel.readLong();
            this.f11554q = parcel.readString();
            JSONObject jSONObject = null;
            this.f11548k = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            this.f11547j = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            this.f11553p = parcel.readByte() != 0;
            this.f11558u = (CTInboxMessageType) parcel.readValue(CTInboxMessageType.class.getClassLoader());
            if (parcel.readByte() == 1) {
                List arrayList = new ArrayList();
                this.f11556s = arrayList;
                parcel.readList(arrayList, String.class.getClassLoader());
            } else {
                this.f11556s = null;
            }
            this.f11544g = parcel.readString();
            if (parcel.readByte() == 1) {
                ArrayList<CTInboxMessageContent> arrayList2 = new ArrayList<>();
                this.f11552o = arrayList2;
                parcel.readList(arrayList2, CTInboxMessageContent.class.getClassLoader());
            } else {
                this.f11552o = null;
            }
            this.f11555r = parcel.readString();
            this.f11546i = parcel.readString();
            if (parcel.readByte() != 0) {
                jSONObject = new JSONObject(parcel.readString());
            }
            this.f11559v = jSONObject;
        } catch (JSONException e8) {
            Logger.n("Unable to parse CTInboxMessage from parcel - " + e8.getLocalizedMessage());
        }
    }
}
