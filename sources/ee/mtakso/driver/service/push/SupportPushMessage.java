package ee.mtakso.driver.service.push;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushMessage.kt */
/* loaded from: classes3.dex */
public final class SupportPushMessage extends PushMessage {
    public static final Parcelable.Creator<SupportPushMessage> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f25659f;

    /* compiled from: PushMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SupportPushMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SupportPushMessage createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new SupportPushMessage(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final SupportPushMessage[] newArray(int i8) {
            return new SupportPushMessage[i8];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportPushMessage(String webAppLaunchToken) {
        super(null);
        Intrinsics.f(webAppLaunchToken, "webAppLaunchToken");
        this.f25659f = webAppLaunchToken;
    }

    public final String a() {
        return this.f25659f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SupportPushMessage) && Intrinsics.a(this.f25659f, ((SupportPushMessage) obj).f25659f);
    }

    public int hashCode() {
        return this.f25659f.hashCode();
    }

    public String toString() {
        String str = this.f25659f;
        return "SupportPushMessage(webAppLaunchToken=" + str + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f25659f);
    }
}
