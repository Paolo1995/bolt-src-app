package ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress;

import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InprogressCallDetails.kt */
/* loaded from: classes3.dex */
public final class InprogressCallDetails {

    /* renamed from: a  reason: collision with root package name */
    private final String f28000a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28001b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f28002c;

    /* renamed from: d  reason: collision with root package name */
    private final String f28003d;

    /* renamed from: e  reason: collision with root package name */
    private final VoipCall.State f28004e;

    /* renamed from: f  reason: collision with root package name */
    private final ConnectionState f28005f;

    /* renamed from: g  reason: collision with root package name */
    private final ConnectionType f28006g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f28007h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f28008i;

    /* compiled from: InprogressCallDetails.kt */
    /* loaded from: classes3.dex */
    public enum ConnectionState {
        ESTABLISHING,
        ESTABLISHED
    }

    /* compiled from: InprogressCallDetails.kt */
    /* loaded from: classes3.dex */
    public enum ConnectionType {
        INCOMING,
        OUTGOING
    }

    public InprogressCallDetails(String str, String str2, Long l8, String str3, VoipCall.State callState, ConnectionState connectionState, ConnectionType connectionType, boolean z7, boolean z8) {
        Intrinsics.f(callState, "callState");
        Intrinsics.f(connectionState, "connectionState");
        Intrinsics.f(connectionType, "connectionType");
        this.f28000a = str;
        this.f28001b = str2;
        this.f28002c = l8;
        this.f28003d = str3;
        this.f28004e = callState;
        this.f28005f = connectionState;
        this.f28006g = connectionType;
        this.f28007h = z7;
        this.f28008i = z8;
    }

    public final VoipCall.State a() {
        return this.f28004e;
    }

    public final String b() {
        return this.f28003d;
    }

    public final ConnectionState c() {
        return this.f28005f;
    }

    public final ConnectionType d() {
        return this.f28006g;
    }

    public final String e() {
        return this.f28001b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InprogressCallDetails) {
            InprogressCallDetails inprogressCallDetails = (InprogressCallDetails) obj;
            return Intrinsics.a(this.f28000a, inprogressCallDetails.f28000a) && Intrinsics.a(this.f28001b, inprogressCallDetails.f28001b) && Intrinsics.a(this.f28002c, inprogressCallDetails.f28002c) && Intrinsics.a(this.f28003d, inprogressCallDetails.f28003d) && this.f28004e == inprogressCallDetails.f28004e && this.f28005f == inprogressCallDetails.f28005f && this.f28006g == inprogressCallDetails.f28006g && this.f28007h == inprogressCallDetails.f28007h && this.f28008i == inprogressCallDetails.f28008i;
        }
        return false;
    }

    public final String f() {
        return this.f28000a;
    }

    public final Long g() {
        return this.f28002c;
    }

    public final boolean h() {
        return this.f28007h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f28000a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f28001b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l8 = this.f28002c;
        int hashCode3 = (hashCode2 + (l8 == null ? 0 : l8.hashCode())) * 31;
        String str3 = this.f28003d;
        int hashCode4 = (((((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f28004e.hashCode()) * 31) + this.f28005f.hashCode()) * 31) + this.f28006g.hashCode()) * 31;
        boolean z7 = this.f28007h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode4 + i8) * 31;
        boolean z8 = this.f28008i;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public final boolean i() {
        return this.f28008i;
    }

    public String toString() {
        String str = this.f28000a;
        String str2 = this.f28001b;
        Long l8 = this.f28002c;
        String str3 = this.f28003d;
        VoipCall.State state = this.f28004e;
        ConnectionState connectionState = this.f28005f;
        ConnectionType connectionType = this.f28006g;
        boolean z7 = this.f28007h;
        boolean z8 = this.f28008i;
        return "InprogressCallDetails(passengerName=" + str + ", passengerAddress=" + str2 + ", timeToDestination=" + l8 + ", callTime=" + str3 + ", callState=" + state + ", connectionState=" + connectionState + ", connectionType=" + connectionType + ", isMuted=" + z7 + ", isSpeakerOn=" + z8 + ")";
    }
}
