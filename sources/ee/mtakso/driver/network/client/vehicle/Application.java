package ee.mtakso.driver.network.client.vehicle;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: VehiclesAndApplications.kt */
/* loaded from: classes3.dex */
public final class Application {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f22891a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f22892b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f22893c;
    @SerializedName("state")

    /* renamed from: d  reason: collision with root package name */
    private final CarApplicationState f22894d;

    public final long a() {
        return this.f22891a;
    }

    public final CarApplicationState b() {
        return this.f22894d;
    }

    public final String c() {
        return this.f22893c;
    }

    public final String d() {
        return this.f22892b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Application) {
            Application application = (Application) obj;
            return this.f22891a == application.f22891a && Intrinsics.a(this.f22892b, application.f22892b) && Intrinsics.a(this.f22893c, application.f22893c) && this.f22894d == application.f22894d;
        }
        return false;
    }

    public int hashCode() {
        return (((((i0.a.a(this.f22891a) * 31) + this.f22892b.hashCode()) * 31) + this.f22893c.hashCode()) * 31) + this.f22894d.hashCode();
    }

    public String toString() {
        long j8 = this.f22891a;
        String str = this.f22892b;
        String str2 = this.f22893c;
        CarApplicationState carApplicationState = this.f22894d;
        return "Application(id=" + j8 + ", title=" + str + ", subtitle=" + str2 + ", state=" + carApplicationState + ")";
    }
}
