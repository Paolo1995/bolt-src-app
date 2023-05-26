package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.contact.VoipContactDetails;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsData.kt */
/* loaded from: classes3.dex */
public final class VoipOptionsData {

    /* renamed from: a  reason: collision with root package name */
    private final VoipContactDetails f27935a;

    public VoipOptionsData(VoipContactDetails details) {
        Intrinsics.f(details, "details");
        this.f27935a = details;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VoipOptionsData) && Intrinsics.a(this.f27935a, ((VoipOptionsData) obj).f27935a);
    }

    public int hashCode() {
        return this.f27935a.hashCode();
    }

    public String toString() {
        VoipContactDetails voipContactDetails = this.f27935a;
        return "VoipOptionsData(details=" + voipContactDetails + ")";
    }
}
