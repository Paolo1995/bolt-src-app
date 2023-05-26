package ee.mtakso.driver.service.voip.noanswer;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.voip_client.VoipConnection;
import ee.mtakso.voip_client.VoipPeer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerIncomingCall.kt */
/* loaded from: classes3.dex */
public final class NoAnswerIncomingCall implements Parcelable {
    public static final Parcelable.Creator<NoAnswerIncomingCall> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final OrderHandle f26193f;

    /* renamed from: g  reason: collision with root package name */
    private final VoipPeer f26194g;

    /* renamed from: h  reason: collision with root package name */
    private final VoipConnection f26195h;

    /* compiled from: NoAnswerIncomingCall.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<NoAnswerIncomingCall> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final NoAnswerIncomingCall createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new NoAnswerIncomingCall(parcel.readInt() == 0 ? null : OrderHandle.CREATOR.createFromParcel(parcel), (VoipPeer) parcel.readParcelable(NoAnswerIncomingCall.class.getClassLoader()), (VoipConnection) parcel.readParcelable(NoAnswerIncomingCall.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final NoAnswerIncomingCall[] newArray(int i8) {
            return new NoAnswerIncomingCall[i8];
        }
    }

    public NoAnswerIncomingCall(OrderHandle orderHandle, VoipPeer voipPeer, VoipConnection voipConnection) {
        Intrinsics.f(voipPeer, "voipPeer");
        Intrinsics.f(voipConnection, "voipConnection");
        this.f26193f = orderHandle;
        this.f26194g = voipPeer;
        this.f26195h = voipConnection;
    }

    public final OrderHandle a() {
        return this.f26193f;
    }

    public final VoipConnection b() {
        return this.f26195h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NoAnswerIncomingCall) {
            NoAnswerIncomingCall noAnswerIncomingCall = (NoAnswerIncomingCall) obj;
            return Intrinsics.a(this.f26193f, noAnswerIncomingCall.f26193f) && Intrinsics.a(this.f26194g, noAnswerIncomingCall.f26194g) && Intrinsics.a(this.f26195h, noAnswerIncomingCall.f26195h);
        }
        return false;
    }

    public int hashCode() {
        OrderHandle orderHandle = this.f26193f;
        return ((((orderHandle == null ? 0 : orderHandle.hashCode()) * 31) + this.f26194g.hashCode()) * 31) + this.f26195h.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f26193f;
        VoipPeer voipPeer = this.f26194g;
        VoipConnection voipConnection = this.f26195h;
        return "NoAnswerIncomingCall(orderHandle=" + orderHandle + ", voipPeer=" + voipPeer + ", voipConnection=" + voipConnection + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        OrderHandle orderHandle = this.f26193f;
        if (orderHandle == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            orderHandle.writeToParcel(out, i8);
        }
        out.writeParcelable(this.f26194g, i8);
        out.writeParcelable(this.f26195h, i8);
    }
}
