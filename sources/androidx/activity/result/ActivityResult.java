package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: androidx.activity.result.ActivityResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ActivityResult[] newArray(int i8) {
            return new ActivityResult[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f780f;

    /* renamed from: g  reason: collision with root package name */
    private final Intent f781g;

    public ActivityResult(int i8, Intent intent) {
        this.f780f = i8;
        this.f781g = intent;
    }

    @NonNull
    public static String c(int i8) {
        if (i8 != -1) {
            if (i8 != 0) {
                return String.valueOf(i8);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public Intent a() {
        return this.f781g;
    }

    public int b() {
        return this.f780f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f780f) + ", data=" + this.f781g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int i9;
        parcel.writeInt(this.f780f);
        if (this.f781g == null) {
            i9 = 0;
        } else {
            i9 = 1;
        }
        parcel.writeInt(i9);
        Intent intent = this.f781g;
        if (intent != null) {
            intent.writeToParcel(parcel, i8);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f780f = parcel.readInt();
        this.f781g = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
