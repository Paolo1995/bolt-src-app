package ee.mtakso.driver.network.client.voip;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.contact.VoipContactDetails;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Voip.kt */
/* loaded from: classes3.dex */
public final class CallbackOptions {
    @SerializedName("voip_contact")

    /* renamed from: a  reason: collision with root package name */
    private final VoipContactDetails f22905a;

    public final VoipContactDetails a() {
        return this.f22905a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CallbackOptions) && Intrinsics.a(this.f22905a, ((CallbackOptions) obj).f22905a);
    }

    public int hashCode() {
        VoipContactDetails voipContactDetails = this.f22905a;
        if (voipContactDetails == null) {
            return 0;
        }
        return voipContactDetails.hashCode();
    }

    public String toString() {
        VoipContactDetails voipContactDetails = this.f22905a;
        return "CallbackOptions(voipContact=" + voipContactDetails + ")";
    }
}
