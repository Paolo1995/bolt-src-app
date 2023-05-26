package eu.bolt.driver.voip;

import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallData.kt */
/* loaded from: classes5.dex */
public final class CallData {

    /* renamed from: a  reason: collision with root package name */
    private final VoipCall f41602a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipCall.EndReason f41603b;

    public CallData(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        this.f41602a = call;
        this.f41603b = endReason;
    }

    public final VoipCall a() {
        return this.f41602a;
    }

    public final VoipCall.EndReason b() {
        return this.f41603b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallData) {
            CallData callData = (CallData) obj;
            return Intrinsics.a(this.f41602a, callData.f41602a) && this.f41603b == callData.f41603b;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f41602a.hashCode() * 31;
        VoipCall.EndReason endReason = this.f41603b;
        return hashCode + (endReason == null ? 0 : endReason.hashCode());
    }

    public String toString() {
        VoipCall voipCall = this.f41602a;
        VoipCall.EndReason endReason = this.f41603b;
        return "CallData(call=" + voipCall + ", endReason=" + endReason + ")";
    }
}
