package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.clevertap.android.sdk.Logger;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class CTInboxMessageContent implements Parcelable {
    public static final Parcelable.Creator<CTInboxMessageContent> CREATOR = new Parcelable.Creator<CTInboxMessageContent>() { // from class: com.clevertap.android.sdk.inbox.CTInboxMessageContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CTInboxMessageContent createFromParcel(Parcel parcel) {
            return new CTInboxMessageContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CTInboxMessageContent[] newArray(int i8) {
            return new CTInboxMessageContent[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f11563f;

    /* renamed from: g  reason: collision with root package name */
    private String f11564g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f11565h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f11566i;

    /* renamed from: j  reason: collision with root package name */
    private String f11567j;

    /* renamed from: k  reason: collision with root package name */
    private JSONArray f11568k;

    /* renamed from: l  reason: collision with root package name */
    private String f11569l;

    /* renamed from: m  reason: collision with root package name */
    private String f11570m;

    /* renamed from: n  reason: collision with root package name */
    private String f11571n;

    /* renamed from: o  reason: collision with root package name */
    private String f11572o;

    /* renamed from: p  reason: collision with root package name */
    private String f11573p;

    /* renamed from: q  reason: collision with root package name */
    private String f11574q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxMessageContent() {
    }

    public String a() {
        return this.f11563f;
    }

    public String b() {
        return this.f11564g;
    }

    public String c() {
        return this.f11567j;
    }

    public String d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has("bg")) {
                return jSONObject.getString("bg");
            }
            return "";
        } catch (JSONException e8) {
            Logger.n("Unable to get Link Text Color with JSON - " + e8.getLocalizedMessage());
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has("color")) {
                return jSONObject.getString("color");
            }
            return "";
        } catch (JSONException e8) {
            Logger.n("Unable to get Link Text Color with JSON - " + e8.getLocalizedMessage());
            return null;
        }
    }

    public String f(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return "";
        }
        try {
            if (jSONObject.has("copyText")) {
                jSONObject2 = jSONObject.getJSONObject("copyText");
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 == null || !jSONObject2.has("text")) {
                return "";
            }
            return jSONObject2.getString("text");
        } catch (JSONException e8) {
            Logger.n("Unable to get Link Text with JSON - " + e8.getLocalizedMessage());
            return "";
        }
    }

    public HashMap<String, String> g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("kv")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("kv");
                Iterator<String> keys = jSONObject2.keys();
                HashMap<String, String> hashMap = new HashMap<>();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject2.getString(next);
                    if (!TextUtils.isEmpty(next)) {
                        hashMap.put(next, string);
                    }
                }
                if (hashMap.isEmpty()) {
                    return null;
                }
                return hashMap;
            } catch (JSONException e8) {
                Logger.n("Unable to get Link Key Value with JSON - " + e8.getLocalizedMessage());
            }
        }
        return null;
    }

    public String h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has("text")) {
                return jSONObject.getString("text");
            }
            return "";
        } catch (JSONException e8) {
            Logger.n("Unable to get Link Text with JSON - " + e8.getLocalizedMessage());
            return null;
        }
    }

    public String i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(ImagesContract.URL)) {
                jSONObject2 = jSONObject.getJSONObject(ImagesContract.URL);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 == null) {
                return null;
            }
            if (jSONObject2.has("android")) {
                jSONObject3 = jSONObject2.getJSONObject("android");
            } else {
                jSONObject3 = null;
            }
            if (jSONObject3 == null || !jSONObject3.has("text")) {
                return "";
            }
            return jSONObject3.getString("text");
        } catch (JSONException e8) {
            Logger.n("Unable to get Link URL with JSON - " + e8.getLocalizedMessage());
            return null;
        }
    }

    public JSONArray j() {
        return this.f11568k;
    }

    public String l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has("type")) {
                return jSONObject.getString("type");
            }
            return "";
        } catch (JSONException e8) {
            Logger.n("Unable to get Link Type with JSON - " + e8.getLocalizedMessage());
            return null;
        }
    }

    public String n() {
        return this.f11569l;
    }

    public String o() {
        return this.f11570m;
    }

    public String p() {
        return this.f11571n;
    }

    public String q() {
        return this.f11572o;
    }

    public String r() {
        return this.f11573p;
    }

    public String s() {
        return this.f11574q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxMessageContent t(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        boolean z7;
        JSONObject jSONObject7;
        JSONArray jSONArray;
        JSONObject jSONObject8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            if (jSONObject.has("title")) {
                jSONObject2 = jSONObject.getJSONObject("title");
            } else {
                jSONObject2 = null;
            }
            String str9 = "";
            if (jSONObject2 != null) {
                if (!jSONObject2.has("text")) {
                    str7 = "";
                } else {
                    str7 = jSONObject2.getString("text");
                }
                this.f11573p = str7;
                if (!jSONObject2.has("color")) {
                    str8 = "";
                } else {
                    str8 = jSONObject2.getString("color");
                }
                this.f11574q = str8;
            }
            if (jSONObject.has("message")) {
                jSONObject3 = jSONObject.getJSONObject("message");
            } else {
                jSONObject3 = null;
            }
            if (jSONObject3 != null) {
                if (!jSONObject3.has("text")) {
                    str5 = "";
                } else {
                    str5 = jSONObject3.getString("text");
                }
                this.f11570m = str5;
                if (!jSONObject3.has("color")) {
                    str6 = "";
                } else {
                    str6 = jSONObject3.getString("color");
                }
                this.f11571n = str6;
            }
            if (jSONObject.has("icon")) {
                jSONObject4 = jSONObject.getJSONObject("icon");
            } else {
                jSONObject4 = null;
            }
            if (jSONObject4 != null) {
                if (!jSONObject4.has(ImagesContract.URL)) {
                    str4 = "";
                } else {
                    str4 = jSONObject4.getString(ImagesContract.URL);
                }
                this.f11567j = str4;
            }
            if (jSONObject.has("media")) {
                jSONObject5 = jSONObject.getJSONObject("media");
            } else {
                jSONObject5 = null;
            }
            if (jSONObject5 != null) {
                if (!jSONObject5.has(ImagesContract.URL)) {
                    str = "";
                } else {
                    str = jSONObject5.getString(ImagesContract.URL);
                }
                this.f11569l = str;
                if (!jSONObject5.has("content_type")) {
                    str2 = "";
                } else {
                    str2 = jSONObject5.getString("content_type");
                }
                this.f11564g = str2;
                if (!jSONObject5.has("poster")) {
                    str3 = "";
                } else {
                    str3 = jSONObject5.getString("poster");
                }
                this.f11572o = str3;
            }
            if (jSONObject.has("action")) {
                jSONObject6 = jSONObject.getJSONObject("action");
            } else {
                jSONObject6 = null;
            }
            if (jSONObject6 != null) {
                boolean z8 = true;
                if (jSONObject6.has("hasUrl") && jSONObject6.getBoolean("hasUrl")) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.f11566i = Boolean.valueOf(z7);
                if (!jSONObject6.has("hasLinks") || !jSONObject6.getBoolean("hasLinks")) {
                    z8 = false;
                }
                this.f11565h = Boolean.valueOf(z8);
                if (jSONObject6.has(ImagesContract.URL)) {
                    jSONObject7 = jSONObject6.getJSONObject(ImagesContract.URL);
                } else {
                    jSONObject7 = null;
                }
                if (jSONObject7 != null && this.f11566i.booleanValue()) {
                    if (jSONObject7.has("android")) {
                        jSONObject8 = jSONObject7.getJSONObject("android");
                    } else {
                        jSONObject8 = null;
                    }
                    if (jSONObject8 != null) {
                        if (jSONObject8.has("text")) {
                            str9 = jSONObject8.getString("text");
                        }
                        this.f11563f = str9;
                    }
                }
                if (jSONObject7 != null && this.f11565h.booleanValue()) {
                    if (jSONObject6.has("links")) {
                        jSONArray = jSONObject6.getJSONArray("links");
                    } else {
                        jSONArray = null;
                    }
                    this.f11568k = jSONArray;
                }
            }
        } catch (JSONException e8) {
            Logger.n("Unable to init CTInboxMessageContent with JSON - " + e8.getLocalizedMessage());
        }
        return this;
    }

    public boolean u() {
        String b8 = b();
        if (b8 != null && this.f11569l != null && b8.startsWith(MediaStreamTrack.AUDIO_TRACK_KIND)) {
            return true;
        }
        return false;
    }

    public boolean v() {
        String b8 = b();
        if (b8 != null && this.f11569l != null && b8.equals("image/gif")) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11573p);
        parcel.writeString(this.f11574q);
        parcel.writeString(this.f11570m);
        parcel.writeString(this.f11571n);
        parcel.writeString(this.f11569l);
        parcel.writeByte(this.f11566i.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11565h.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f11563f);
        parcel.writeString(this.f11567j);
        if (this.f11568k == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11568k.toString());
        }
        parcel.writeString(this.f11564g);
        parcel.writeString(this.f11572o);
    }

    public boolean x() {
        String b8 = b();
        if (b8 != null && this.f11569l != null && b8.startsWith("image") && !b8.equals("image/gif")) {
            return true;
        }
        return false;
    }

    public boolean z() {
        String b8 = b();
        if (b8 != null && this.f11569l != null && b8.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND)) {
            return true;
        }
        return false;
    }

    protected CTInboxMessageContent(Parcel parcel) {
        this.f11573p = parcel.readString();
        this.f11574q = parcel.readString();
        this.f11570m = parcel.readString();
        this.f11571n = parcel.readString();
        this.f11569l = parcel.readString();
        this.f11566i = Boolean.valueOf(parcel.readByte() != 0);
        this.f11565h = Boolean.valueOf(parcel.readByte() != 0);
        this.f11563f = parcel.readString();
        this.f11567j = parcel.readString();
        try {
            this.f11568k = parcel.readByte() == 0 ? null : new JSONArray(parcel.readString());
        } catch (JSONException e8) {
            Logger.n("Unable to init CTInboxMessageContent with Parcel - " + e8.getLocalizedMessage());
        }
        this.f11564g = parcel.readString();
        this.f11572o = parcel.readString();
    }
}
