package ee.mtakso.driver.service.push;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.param.RateMeModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushMessage.kt */
/* loaded from: classes3.dex */
public final class RateRequestPushMessage extends PushMessage {
    public static final Parcelable.Creator<RateRequestPushMessage> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final RateMeModel f25658f;

    /* compiled from: PushMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RateRequestPushMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RateRequestPushMessage createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new RateRequestPushMessage((RateMeModel) parcel.readParcelable(RateRequestPushMessage.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RateRequestPushMessage[] newArray(int i8) {
            return new RateRequestPushMessage[i8];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RateRequestPushMessage(RateMeModel rateMeModel) {
        super(null);
        Intrinsics.f(rateMeModel, "rateMeModel");
        this.f25658f = rateMeModel;
    }

    public final RateMeModel a() {
        return this.f25658f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RateRequestPushMessage) && Intrinsics.a(this.f25658f, ((RateRequestPushMessage) obj).f25658f);
    }

    public int hashCode() {
        return this.f25658f.hashCode();
    }

    public String toString() {
        RateMeModel rateMeModel = this.f25658f;
        return "RateRequestPushMessage(rateMeModel=" + rateMeModel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeParcelable(this.f25658f, i8);
    }
}
