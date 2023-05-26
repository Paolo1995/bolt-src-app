package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MiniInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<MiniInAppNotification> CREATOR = new Parcelable.Creator<MiniInAppNotification>() { // from class: com.mixpanel.android.mpmetrics.MiniInAppNotification.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MiniInAppNotification createFromParcel(Parcel parcel) {
            return new MiniInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MiniInAppNotification[] newArray(int i8) {
            return new MiniInAppNotification[i8];
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private final String f19226q;

    /* renamed from: r  reason: collision with root package name */
    private final int f19227r;

    /* renamed from: s  reason: collision with root package name */
    private final int f19228s;

    public MiniInAppNotification(Parcel parcel) {
        super(parcel);
        this.f19226q = parcel.readString();
        this.f19227r = parcel.readInt();
        this.f19228s = parcel.readInt();
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public InAppNotification.Type n() {
        return InAppNotification.Type.MINI;
    }

    public int t() {
        return this.f19228s;
    }

    public String u() {
        return this.f19226q;
    }

    public int v() {
        return this.f19227r;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        parcel.writeString(this.f19226q);
        parcel.writeInt(this.f19227r);
        parcel.writeInt(this.f19228s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniInAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        super(jSONObject);
        try {
            this.f19226q = JSONUtils.a(jSONObject, "cta_url");
            this.f19227r = jSONObject.getInt("image_tint_color");
            this.f19228s = jSONObject.getInt("border_color");
        } catch (JSONException e8) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e8);
        }
    }
}
