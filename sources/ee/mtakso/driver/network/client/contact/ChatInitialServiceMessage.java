package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public final class ChatInitialServiceMessage {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f21769a;
    @SerializedName("date")

    /* renamed from: b  reason: collision with root package name */
    private final long f21770b;
    @SerializedName("text_html")

    /* renamed from: c  reason: collision with root package name */
    private final String f21771c;
    @SerializedName("silent")

    /* renamed from: d  reason: collision with root package name */
    private final boolean f21772d;

    public final long a() {
        return this.f21770b;
    }

    public final String b() {
        return this.f21769a;
    }

    public final String c() {
        return this.f21771c;
    }

    public final boolean d() {
        return this.f21772d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatInitialServiceMessage) {
            ChatInitialServiceMessage chatInitialServiceMessage = (ChatInitialServiceMessage) obj;
            return Intrinsics.a(this.f21769a, chatInitialServiceMessage.f21769a) && this.f21770b == chatInitialServiceMessage.f21770b && Intrinsics.a(this.f21771c, chatInitialServiceMessage.f21771c) && this.f21772d == chatInitialServiceMessage.f21772d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f21769a.hashCode() * 31) + i0.a.a(this.f21770b)) * 31) + this.f21771c.hashCode()) * 31;
        boolean z7 = this.f21772d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f21769a;
        long j8 = this.f21770b;
        String str2 = this.f21771c;
        boolean z7 = this.f21772d;
        return "ChatInitialServiceMessage(id=" + str + ", date=" + j8 + ", text=" + str2 + ", isSilent=" + z7 + ")";
    }
}
