package ee.mtakso.driver.network.client.emergencyassist.help_provider;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalHelpProviderResponse.kt */
/* loaded from: classes3.dex */
public final class ExternalHelpProviderResponse {
    @SerializedName("external_help_provider")

    /* renamed from: a  reason: collision with root package name */
    private final ExternalHelpResponder f22177a;

    public final ExternalHelpResponder a() {
        return this.f22177a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExternalHelpProviderResponse) && Intrinsics.a(this.f22177a, ((ExternalHelpProviderResponse) obj).f22177a);
    }

    public int hashCode() {
        ExternalHelpResponder externalHelpResponder = this.f22177a;
        if (externalHelpResponder == null) {
            return 0;
        }
        return externalHelpResponder.hashCode();
    }

    public String toString() {
        ExternalHelpResponder externalHelpResponder = this.f22177a;
        return "ExternalHelpProviderResponse(externalHelpProvider=" + externalHelpResponder + ")";
    }
}
