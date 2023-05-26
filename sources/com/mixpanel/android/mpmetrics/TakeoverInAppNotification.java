package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.JSONUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TakeoverInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<TakeoverInAppNotification> CREATOR = new Parcelable.Creator<TakeoverInAppNotification>() { // from class: com.mixpanel.android.mpmetrics.TakeoverInAppNotification.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TakeoverInAppNotification createFromParcel(Parcel parcel) {
            return new TakeoverInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TakeoverInAppNotification[] newArray(int i8) {
            return new TakeoverInAppNotification[i8];
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<InAppButton> f19373q;

    /* renamed from: r  reason: collision with root package name */
    private final int f19374r;

    /* renamed from: s  reason: collision with root package name */
    private final String f19375s;

    /* renamed from: t  reason: collision with root package name */
    private final int f19376t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f19377u;

    public TakeoverInAppNotification(Parcel parcel) {
        super(parcel);
        this.f19373q = parcel.createTypedArrayList(InAppButton.CREATOR);
        this.f19374r = parcel.readInt();
        this.f19375s = parcel.readString();
        this.f19376t = parcel.readInt();
        this.f19377u = parcel.readByte() != 0;
    }

    public boolean A() {
        if (this.f19375s != null) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.f19377u;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public InAppNotification.Type n() {
        return InAppNotification.Type.TAKEOVER;
    }

    public InAppButton t(int i8) {
        if (this.f19373q.size() > i8) {
            return this.f19373q.get(i8);
        }
        return null;
    }

    public int u() {
        return this.f19374r;
    }

    public int v() {
        return this.f19373q.size();
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        parcel.writeTypedList(this.f19373q);
        parcel.writeInt(this.f19374r);
        parcel.writeString(this.f19375s);
        parcel.writeInt(this.f19376t);
        parcel.writeByte(this.f19377u ? (byte) 1 : (byte) 0);
    }

    public String x() {
        return this.f19375s;
    }

    public int z() {
        return this.f19376t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TakeoverInAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        super(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("buttons");
            this.f19373q = new ArrayList<>();
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                this.f19373q.add(new InAppButton((JSONObject) jSONArray.get(i8)));
            }
            this.f19374r = jSONObject.getInt("close_color");
            this.f19375s = JSONUtils.a(jSONObject, "title");
            this.f19376t = jSONObject.optInt("title_color");
            this.f19377u = e().getBoolean("image_fade");
        } catch (JSONException e8) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e8);
        }
    }
}
