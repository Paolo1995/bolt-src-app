package ee.mtakso.driver.network.client.applog;

import com.google.gson.annotations.SerializedName;
import i0.a;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplogEntry.kt */
/* loaded from: classes3.dex */
public final class ApplogEntry {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f21359a;
    @SerializedName("level")

    /* renamed from: b  reason: collision with root package name */
    private final String f21360b;
    @SerializedName("message")

    /* renamed from: c  reason: collision with root package name */
    private final String f21361c;
    @SerializedName("app_timestamp_ms")

    /* renamed from: d  reason: collision with root package name */
    private final long f21362d;

    public ApplogEntry(Map<String, ? extends Object> data, String level, String message, long j8) {
        Intrinsics.f(data, "data");
        Intrinsics.f(level, "level");
        Intrinsics.f(message, "message");
        this.f21359a = data;
        this.f21360b = level;
        this.f21361c = message;
        this.f21362d = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApplogEntry) {
            ApplogEntry applogEntry = (ApplogEntry) obj;
            return Intrinsics.a(this.f21359a, applogEntry.f21359a) && Intrinsics.a(this.f21360b, applogEntry.f21360b) && Intrinsics.a(this.f21361c, applogEntry.f21361c) && this.f21362d == applogEntry.f21362d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f21359a.hashCode() * 31) + this.f21360b.hashCode()) * 31) + this.f21361c.hashCode()) * 31) + a.a(this.f21362d);
    }

    public String toString() {
        Map<String, Object> map = this.f21359a;
        String str = this.f21360b;
        String str2 = this.f21361c;
        long j8 = this.f21362d;
        return "ApplogEntry(data=" + map + ", level=" + str + ", message=" + str2 + ", timestamp=" + j8 + ")";
    }
}
