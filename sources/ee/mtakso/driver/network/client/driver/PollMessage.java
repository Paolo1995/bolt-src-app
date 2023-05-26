package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Polling.kt */
/* loaded from: classes3.dex */
public final class PollMessage {
    @SerializedName("severity")

    /* renamed from: a  reason: collision with root package name */
    private final PollMessageSeverity f21974a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f21975b;

    public final String a() {
        return this.f21975b;
    }

    public final PollMessageSeverity b() {
        return this.f21974a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PollMessage) {
            PollMessage pollMessage = (PollMessage) obj;
            return this.f21974a == pollMessage.f21974a && Intrinsics.a(this.f21975b, pollMessage.f21975b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21974a.hashCode() * 31) + this.f21975b.hashCode();
    }

    public String toString() {
        PollMessageSeverity pollMessageSeverity = this.f21974a;
        String str = this.f21975b;
        return "PollMessage(severity=" + pollMessageSeverity + ", message=" + str + ")";
    }
}
