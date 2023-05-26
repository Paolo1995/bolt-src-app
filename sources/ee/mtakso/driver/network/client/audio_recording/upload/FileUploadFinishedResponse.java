package ee.mtakso.driver.network.client.audio_recording.upload;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUploadFinishedResponse.kt */
/* loaded from: classes3.dex */
public final class FileUploadFinishedResponse {
    @SerializedName("cs_ticket_web_app_launch_params")

    /* renamed from: a  reason: collision with root package name */
    private final WebAppLaunchParams f21392a;

    public final WebAppLaunchParams a() {
        return this.f21392a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FileUploadFinishedResponse) && Intrinsics.a(this.f21392a, ((FileUploadFinishedResponse) obj).f21392a);
    }

    public int hashCode() {
        return this.f21392a.hashCode();
    }

    public String toString() {
        WebAppLaunchParams webAppLaunchParams = this.f21392a;
        return "FileUploadFinishedResponse(webAppLaunchParams=" + webAppLaunchParams + ")";
    }
}
