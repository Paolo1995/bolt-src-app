package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public final class AvailableContactOptions {
    @SerializedName("list")

    /* renamed from: a  reason: collision with root package name */
    private final List<ContactOption> f21754a;

    public final List<ContactOption> a() {
        return this.f21754a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AvailableContactOptions) && Intrinsics.a(this.f21754a, ((AvailableContactOptions) obj).f21754a);
    }

    public int hashCode() {
        return this.f21754a.hashCode();
    }

    public String toString() {
        List<ContactOption> list = this.f21754a;
        return "AvailableContactOptions(contactOptions=" + list + ")";
    }
}
