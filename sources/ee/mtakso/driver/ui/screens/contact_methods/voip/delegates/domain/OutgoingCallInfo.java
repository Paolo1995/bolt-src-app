package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallDelegate.kt */
/* loaded from: classes3.dex */
public final class OutgoingCallInfo {

    /* renamed from: a  reason: collision with root package name */
    private final VoipOptionsData f27921a;

    public OutgoingCallInfo(VoipOptionsData voipOptionsData) {
        this.f27921a = voipOptionsData;
    }

    public final VoipOptionsData a() {
        return this.f27921a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OutgoingCallInfo) && Intrinsics.a(this.f27921a, ((OutgoingCallInfo) obj).f27921a);
    }

    public int hashCode() {
        VoipOptionsData voipOptionsData = this.f27921a;
        if (voipOptionsData == null) {
            return 0;
        }
        return voipOptionsData.hashCode();
    }

    public String toString() {
        VoipOptionsData voipOptionsData = this.f27921a;
        return "OutgoingCallInfo(voipCallInfo=" + voipOptionsData + ")";
    }
}
