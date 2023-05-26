package ee.mtakso.driver.network.client.emergencyassist.help_provider;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalHelpResponder.kt */
/* loaded from: classes3.dex */
public final class ExternalHelpResponder {
    @SerializedName("name")

    /* renamed from: a  reason: collision with root package name */
    private final String f22178a;
    @SerializedName("logo")

    /* renamed from: b  reason: collision with root package name */
    private final DriverImage f22179b;

    public final DriverImage a() {
        return this.f22179b;
    }

    public final String b() {
        return this.f22178a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExternalHelpResponder) {
            ExternalHelpResponder externalHelpResponder = (ExternalHelpResponder) obj;
            return Intrinsics.a(this.f22178a, externalHelpResponder.f22178a) && Intrinsics.a(this.f22179b, externalHelpResponder.f22179b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22178a.hashCode() * 31;
        DriverImage driverImage = this.f22179b;
        return hashCode + (driverImage == null ? 0 : driverImage.hashCode());
    }

    public String toString() {
        String str = this.f22178a;
        DriverImage driverImage = this.f22179b;
        return "ExternalHelpResponder(name=" + str + ", logo=" + driverImage + ")";
    }
}
