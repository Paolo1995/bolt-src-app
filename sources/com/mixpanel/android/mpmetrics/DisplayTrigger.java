package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.util.MPLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DisplayTrigger implements Parcelable {
    public static final Parcelable.Creator<DisplayTrigger> CREATOR = new Parcelable.Creator<DisplayTrigger>() { // from class: com.mixpanel.android.mpmetrics.DisplayTrigger.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DisplayTrigger createFromParcel(Parcel parcel) {
            return new DisplayTrigger(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DisplayTrigger[] newArray(int i8) {
            return new DisplayTrigger[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final String f19123f;

    /* renamed from: g  reason: collision with root package name */
    private final JSONObject f19124g;

    /* renamed from: h  reason: collision with root package name */
    private final SelectorEvaluator f19125h;

    public DisplayTrigger(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.f19123f = jSONObject.getString("event");
            JSONObject optJSONObject = jSONObject.optJSONObject("selector");
            this.f19124g = optJSONObject;
            this.f19125h = optJSONObject != null ? new SelectorEvaluator(optJSONObject) : null;
        } catch (JSONException e8) {
            throw new BadDecideObjectException("Event triggered notification JSON was unexpected or bad", e8);
        }
    }

    public boolean a(AnalyticsMessages.EventDescription eventDescription) {
        if (eventDescription == null || (!this.f19123f.equals("$any_event") && !eventDescription.c().equals(this.f19123f))) {
            return false;
        }
        SelectorEvaluator selectorEvaluator = this.f19125h;
        if (selectorEvaluator != null) {
            try {
                return selectorEvaluator.b(eventDescription.d());
            } catch (Exception e8) {
                MPLog.d("MixpanelAPI.DisplayTrigger", "Error evaluating selector", e8);
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f19123f);
        parcel.writeString(this.f19124g.toString());
    }

    public DisplayTrigger(Parcel parcel) {
        JSONObject jSONObject;
        this.f19123f = parcel.readString();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException e8) {
            MPLog.d("MixpanelAPI.DisplayTrigger", "Error parsing selector from display_trigger", e8);
            jSONObject = null;
        }
        this.f19124g = jSONObject;
        this.f19125h = jSONObject != null ? new SelectorEvaluator(jSONObject) : null;
    }
}
