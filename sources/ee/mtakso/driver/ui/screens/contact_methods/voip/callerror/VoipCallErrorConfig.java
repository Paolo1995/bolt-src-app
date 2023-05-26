package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallErrorViewModel.kt */
/* loaded from: classes3.dex */
public final class VoipCallErrorConfig implements Parcelable {
    public static final Parcelable.Creator<VoipCallErrorConfig> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final VoipCall.Type f27841f;

    /* compiled from: VoipCallErrorViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<VoipCallErrorConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final VoipCallErrorConfig createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new VoipCallErrorConfig(VoipCall.Type.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final VoipCallErrorConfig[] newArray(int i8) {
            return new VoipCallErrorConfig[i8];
        }
    }

    public VoipCallErrorConfig(VoipCall.Type callType) {
        Intrinsics.f(callType, "callType");
        this.f27841f = callType;
    }

    public final VoipCall.Type a() {
        return this.f27841f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VoipCallErrorConfig) && this.f27841f == ((VoipCallErrorConfig) obj).f27841f;
    }

    public int hashCode() {
        return this.f27841f.hashCode();
    }

    public String toString() {
        VoipCall.Type type = this.f27841f;
        return "VoipCallErrorConfig(callType=" + type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f27841f.name());
    }
}
