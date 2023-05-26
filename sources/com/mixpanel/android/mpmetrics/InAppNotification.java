package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes3.dex */
public abstract class InAppNotification implements Parcelable {

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f19152p = Pattern.compile("(\\.[^./]+$)");

    /* renamed from: f  reason: collision with root package name */
    protected final JSONObject f19153f;

    /* renamed from: g  reason: collision with root package name */
    protected final JSONObject f19154g;

    /* renamed from: h  reason: collision with root package name */
    protected final int f19155h;

    /* renamed from: i  reason: collision with root package name */
    protected final int f19156i;

    /* renamed from: j  reason: collision with root package name */
    private final int f19157j;

    /* renamed from: k  reason: collision with root package name */
    private final String f19158k;

    /* renamed from: l  reason: collision with root package name */
    private final int f19159l;

    /* renamed from: m  reason: collision with root package name */
    private final String f19160m;

    /* renamed from: n  reason: collision with root package name */
    private final List<DisplayTrigger> f19161n;

    /* renamed from: o  reason: collision with root package name */
    private Bitmap f19162o;

    /* loaded from: classes3.dex */
    public enum Type {
        UNKNOWN { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.1
            @Override // java.lang.Enum
            public String toString() {
                return "*unknown_type*";
            }
        },
        MINI { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.2
            @Override // java.lang.Enum
            public String toString() {
                return "mini";
            }
        },
        TAKEOVER { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.3
            @Override // java.lang.Enum
            public String toString() {
                return "takeover";
            }
        }
    }

    public InAppNotification() {
        this.f19153f = null;
        this.f19154g = null;
        this.f19155h = 0;
        this.f19156i = 0;
        this.f19157j = 0;
        this.f19158k = null;
        this.f19159l = 0;
        this.f19160m = null;
        this.f19161n = null;
    }

    static String s(String str, String str2) {
        Matcher matcher = f19152p.matcher(str);
        if (matcher.find()) {
            return matcher.replaceFirst(str2 + "$1");
        }
        return str;
    }

    public int a() {
        return this.f19157j;
    }

    public String b() {
        return this.f19158k;
    }

    public int c() {
        return this.f19159l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", f());
            jSONObject.put("message_id", l());
            jSONObject.put("message_type", "inapp");
            jSONObject.put("message_subtype", n().toString());
        } catch (JSONException e8) {
            MPLog.d("MixpanelAPI.InAppNotif", "Impossible JSON Exception", e8);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject e() {
        return this.f19154g;
    }

    public int f() {
        return this.f19155h;
    }

    public Bitmap g() {
        return this.f19162o;
    }

    public String h() {
        return s(this.f19160m, "@2x");
    }

    public String i() {
        return s(this.f19160m, "@4x");
    }

    public String j() {
        return this.f19160m;
    }

    public int l() {
        return this.f19156i;
    }

    public abstract Type n();

    public boolean o() {
        if (this.f19158k != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        List<DisplayTrigger> list = this.f19161n;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean q(AnalyticsMessages.EventDescription eventDescription) {
        if (p()) {
            for (DisplayTrigger displayTrigger : this.f19161n) {
                if (displayTrigger.a(eventDescription)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Bitmap bitmap) {
        this.f19162o = bitmap;
    }

    public String toString() {
        return this.f19153f.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f19153f.toString());
        parcel.writeString(this.f19154g.toString());
        parcel.writeInt(this.f19155h);
        parcel.writeInt(this.f19156i);
        parcel.writeInt(this.f19157j);
        parcel.writeString(this.f19158k);
        parcel.writeInt(this.f19159l);
        parcel.writeString(this.f19160m);
        parcel.writeParcelable(this.f19162o, i8);
        parcel.writeList(this.f19161n);
    }

    public InAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
        }
        try {
            jSONObject3 = new JSONObject(parcel.readString());
        } catch (JSONException unused2) {
            jSONObject2 = jSONObject;
            MPLog.c("MixpanelAPI.InAppNotif", "Error reading JSON when creating InAppNotification from Parcel");
            jSONObject = jSONObject2;
            this.f19153f = jSONObject;
            this.f19154g = jSONObject3;
            this.f19155h = parcel.readInt();
            this.f19156i = parcel.readInt();
            this.f19157j = parcel.readInt();
            this.f19158k = parcel.readString();
            this.f19159l = parcel.readInt();
            this.f19160m = parcel.readString();
            this.f19162o = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            this.f19161n = arrayList;
            parcel.readList(arrayList, null);
        }
        this.f19153f = jSONObject;
        this.f19154g = jSONObject3;
        this.f19155h = parcel.readInt();
        this.f19156i = parcel.readInt();
        this.f19157j = parcel.readInt();
        this.f19158k = parcel.readString();
        this.f19159l = parcel.readInt();
        this.f19160m = parcel.readString();
        this.f19162o = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.f19161n = arrayList2;
        parcel.readList(arrayList2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        this.f19161n = new ArrayList();
        try {
            this.f19153f = jSONObject;
            this.f19154g = jSONObject.getJSONObject("extras");
            this.f19155h = jSONObject.getInt(Name.MARK);
            this.f19156i = jSONObject.getInt("message_id");
            this.f19157j = jSONObject.getInt("bg_color");
            this.f19158k = JSONUtils.a(jSONObject, "body");
            this.f19159l = jSONObject.optInt("body_color");
            this.f19160m = jSONObject.getString("image_url");
            this.f19162o = Bitmap.createBitmap(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, Bitmap.Config.ARGB_8888);
            JSONArray optJSONArray = jSONObject.optJSONArray("display_triggers");
            int i8 = 0;
            while (optJSONArray != null) {
                if (i8 >= optJSONArray.length()) {
                    return;
                }
                this.f19161n.add(new DisplayTrigger(optJSONArray.getJSONObject(i8)));
                i8++;
            }
        } catch (JSONException e8) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e8);
        }
    }
}
