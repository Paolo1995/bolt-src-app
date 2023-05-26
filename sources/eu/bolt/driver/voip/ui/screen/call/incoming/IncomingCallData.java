package eu.bolt.driver.voip.ui.screen.call.incoming;

import eu.bolt.driver.voip.service.call.CallState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingCallData.kt */
/* loaded from: classes5.dex */
public final class IncomingCallData {

    /* renamed from: a  reason: collision with root package name */
    private final CallState f41653a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41654b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41655c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f41656d;

    public IncomingCallData(CallState callState, String str, String str2, Long l8) {
        Intrinsics.f(callState, "callState");
        this.f41653a = callState;
        this.f41654b = str;
        this.f41655c = str2;
        this.f41656d = l8;
    }

    public final String a() {
        return this.f41655c;
    }

    public final CallState b() {
        return this.f41653a;
    }

    public final String c() {
        return this.f41654b;
    }

    public final Long d() {
        return this.f41656d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncomingCallData) {
            IncomingCallData incomingCallData = (IncomingCallData) obj;
            return this.f41653a == incomingCallData.f41653a && Intrinsics.a(this.f41654b, incomingCallData.f41654b) && Intrinsics.a(this.f41655c, incomingCallData.f41655c) && Intrinsics.a(this.f41656d, incomingCallData.f41656d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f41653a.hashCode() * 31;
        String str = this.f41654b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f41655c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l8 = this.f41656d;
        return hashCode3 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        CallState callState = this.f41653a;
        String str = this.f41654b;
        String str2 = this.f41655c;
        Long l8 = this.f41656d;
        return "IncomingCallData(callState=" + callState + ", passengerName=" + str + ", address=" + str2 + ", timeToDestination=" + l8 + ")";
    }
}
