package eu.bolt.driver.chat.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: TerminateChatEvent.kt */
/* loaded from: classes5.dex */
public final class TerminateChatEvent {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f40448a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f40449b;
    @SerializedName("reason")

    /* renamed from: c  reason: collision with root package name */
    private final String f40450c;
    @SerializedName("date")

    /* renamed from: d  reason: collision with root package name */
    private final long f40451d;

    public final long a() {
        return this.f40451d;
    }

    public final String b() {
        return this.f40448a;
    }

    public final String c() {
        return this.f40449b;
    }

    public final String d() {
        return this.f40450c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TerminateChatEvent) {
            TerminateChatEvent terminateChatEvent = (TerminateChatEvent) obj;
            return Intrinsics.a(this.f40448a, terminateChatEvent.f40448a) && Intrinsics.a(this.f40449b, terminateChatEvent.f40449b) && Intrinsics.a(this.f40450c, terminateChatEvent.f40450c) && this.f40451d == terminateChatEvent.f40451d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f40448a.hashCode() * 31) + this.f40449b.hashCode()) * 31) + this.f40450c.hashCode()) * 31) + i0.a.a(this.f40451d);
    }

    public String toString() {
        String str = this.f40448a;
        String str2 = this.f40449b;
        String str3 = this.f40450c;
        long j8 = this.f40451d;
        return "TerminateChatEvent(id=" + str + ", message=" + str2 + ", reason=" + str3 + ", date=" + j8 + ")";
    }
}
