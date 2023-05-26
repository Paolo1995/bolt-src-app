package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i8) {
            return new IntentSenderRequest[i8];
        }
    };
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final IntentSender f804f;

    /* renamed from: g  reason: collision with root package name */
    private final Intent f805g;

    /* renamed from: h  reason: collision with root package name */
    private final int f806h;

    /* renamed from: i  reason: collision with root package name */
    private final int f807i;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private IntentSender f808a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f809b;

        /* renamed from: c  reason: collision with root package name */
        private int f810c;

        /* renamed from: d  reason: collision with root package name */
        private int f811d;

        public Builder(@NonNull IntentSender intentSender) {
            this.f808a = intentSender;
        }

        @NonNull
        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f808a, this.f809b, this.f810c, this.f811d);
        }

        @NonNull
        public Builder b(Intent intent) {
            this.f809b = intent;
            return this;
        }

        @NonNull
        public Builder c(int i8, int i9) {
            this.f811d = i8;
            this.f810c = i9;
            return this;
        }
    }

    IntentSenderRequest(@NonNull IntentSender intentSender, Intent intent, int i8, int i9) {
        this.f804f = intentSender;
        this.f805g = intent;
        this.f806h = i8;
        this.f807i = i9;
    }

    public Intent a() {
        return this.f805g;
    }

    public int b() {
        return this.f806h;
    }

    public int c() {
        return this.f807i;
    }

    @NonNull
    public IntentSender d() {
        return this.f804f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        parcel.writeParcelable(this.f804f, i8);
        parcel.writeParcelable(this.f805g, i8);
        parcel.writeInt(this.f806h);
        parcel.writeInt(this.f807i);
    }

    IntentSenderRequest(@NonNull Parcel parcel) {
        this.f804f = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f805g = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f806h = parcel.readInt();
        this.f807i = parcel.readInt();
    }
}
