package ee.mtakso.driver.network.client.applog;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogUploadRequest.kt */
/* loaded from: classes3.dex */
public final class LogUploadRequest {
    @SerializedName("entries")

    /* renamed from: a  reason: collision with root package name */
    private final List<ApplogEntry> f21367a;

    public LogUploadRequest(List<ApplogEntry> entries) {
        Intrinsics.f(entries, "entries");
        this.f21367a = entries;
    }

    public final List<ApplogEntry> a() {
        return this.f21367a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LogUploadRequest) && Intrinsics.a(this.f21367a, ((LogUploadRequest) obj).f21367a);
    }

    public int hashCode() {
        return this.f21367a.hashCode();
    }

    public String toString() {
        List<ApplogEntry> list = this.f21367a;
        return "LogUploadRequest(entries=" + list + ")";
    }
}
