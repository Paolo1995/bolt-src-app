package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Logger;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class CTInAppNotificationMedia implements Parcelable {
    public static final Parcelable.Creator<CTInAppNotificationMedia> CREATOR = new Parcelable.Creator<CTInAppNotificationMedia>() { // from class: com.clevertap.android.sdk.inapp.CTInAppNotificationMedia.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CTInAppNotificationMedia createFromParcel(Parcel parcel) {
            return new CTInAppNotificationMedia(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CTInAppNotificationMedia[] newArray(int i8) {
            return new CTInAppNotificationMedia[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    int f11396f;

    /* renamed from: g  reason: collision with root package name */
    private String f11397g;

    /* renamed from: h  reason: collision with root package name */
    private String f11398h;

    /* renamed from: i  reason: collision with root package name */
    private String f11399i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f11397g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f11398h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f11399i;
    }

    public int d() {
        return this.f11396f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotificationMedia e(JSONObject jSONObject, int i8) {
        String str;
        this.f11396f = i8;
        try {
            String str2 = "";
            if (!jSONObject.has("content_type")) {
                str = "";
            } else {
                str = jSONObject.getString("content_type");
            }
            this.f11398h = str;
            if (jSONObject.has(ImagesContract.URL)) {
                str2 = jSONObject.getString(ImagesContract.URL);
            }
            if (!str2.isEmpty()) {
                if (this.f11398h.startsWith("image")) {
                    this.f11399i = str2;
                    if (jSONObject.has("key")) {
                        this.f11397g = UUID.randomUUID().toString() + jSONObject.getString("key");
                    } else {
                        this.f11397g = UUID.randomUUID().toString();
                    }
                } else {
                    this.f11399i = str2;
                }
            }
        } catch (JSONException e8) {
            Logger.n("Error parsing Media JSONObject - " + e8.getLocalizedMessage());
        }
        if (this.f11398h.isEmpty()) {
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        String b8 = b();
        if (b8 != null && this.f11399i != null && b8.startsWith(MediaStreamTrack.AUDIO_TRACK_KIND)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        String b8 = b();
        if (b8 != null && this.f11399i != null && b8.equals("image/gif")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        String b8 = b();
        if (b8 != null && this.f11399i != null && b8.startsWith("image") && !b8.equals("image/gif")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        String b8 = b();
        if (b8 != null && this.f11399i != null && b8.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        this.f11399i = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11399i);
        parcel.writeString(this.f11398h);
        parcel.writeString(this.f11397g);
        parcel.writeInt(this.f11396f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotificationMedia() {
    }

    private CTInAppNotificationMedia(Parcel parcel) {
        this.f11399i = parcel.readString();
        this.f11398h = parcel.readString();
        this.f11397g = parcel.readString();
        this.f11396f = parcel.readInt();
    }
}
