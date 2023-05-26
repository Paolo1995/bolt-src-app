package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordingInfo.kt */
/* loaded from: classes3.dex */
public final class RecordingInfo {
    @SerializedName("is_shared")

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22524a;
    @SerializedName("shared_at")

    /* renamed from: b  reason: collision with root package name */
    private final Long f22525b;
    @SerializedName("is_expired")

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f22526c;
    @SerializedName("cs_ticket_web_app_launch_params")

    /* renamed from: d  reason: collision with root package name */
    private final WebAppLaunchParams f22527d;

    public final Long a() {
        return this.f22525b;
    }

    public final WebAppLaunchParams b() {
        return this.f22527d;
    }

    public final Boolean c() {
        return this.f22526c;
    }

    public final boolean d() {
        return this.f22524a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecordingInfo) {
            RecordingInfo recordingInfo = (RecordingInfo) obj;
            return this.f22524a == recordingInfo.f22524a && Intrinsics.a(this.f22525b, recordingInfo.f22525b) && Intrinsics.a(this.f22526c, recordingInfo.f22526c) && Intrinsics.a(this.f22527d, recordingInfo.f22527d);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z7 = this.f22524a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        Long l8 = this.f22525b;
        int hashCode = (i8 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Boolean bool = this.f22526c;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        WebAppLaunchParams webAppLaunchParams = this.f22527d;
        return hashCode2 + (webAppLaunchParams != null ? webAppLaunchParams.hashCode() : 0);
    }

    public String toString() {
        boolean z7 = this.f22524a;
        Long l8 = this.f22525b;
        Boolean bool = this.f22526c;
        WebAppLaunchParams webAppLaunchParams = this.f22527d;
        return "RecordingInfo(isShared=" + z7 + ", sharedAt=" + l8 + ", isExpired=" + bool + ", webAppLaunchParams=" + webAppLaunchParams + ")";
    }
}
