package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class TCMessage {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f21734a;

    public final String a() {
        return this.f21734a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TCMessage) && Intrinsics.a(this.f21734a, ((TCMessage) obj).f21734a);
    }

    public int hashCode() {
        return this.f21734a.hashCode();
    }

    public String toString() {
        String str = this.f21734a;
        return "TCMessage(text=" + str + ")";
    }
}
