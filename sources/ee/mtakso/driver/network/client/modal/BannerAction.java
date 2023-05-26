package ee.mtakso.driver.network.client.modal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: BannerAction.kt */
/* loaded from: classes3.dex */
public final class BannerAction {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f22275a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f22276b;
    @SerializedName("link")

    /* renamed from: c  reason: collision with root package name */
    private final String f22277c;

    public final String a() {
        return this.f22275a;
    }

    public final String b() {
        return this.f22277c;
    }

    public final String c() {
        return this.f22276b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BannerAction) {
            BannerAction bannerAction = (BannerAction) obj;
            return Intrinsics.a(this.f22275a, bannerAction.f22275a) && Intrinsics.a(this.f22276b, bannerAction.f22276b) && Intrinsics.a(this.f22277c, bannerAction.f22277c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f22275a.hashCode() * 31) + this.f22276b.hashCode()) * 31;
        String str = this.f22277c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f22275a;
        String str2 = this.f22276b;
        String str3 = this.f22277c;
        return "BannerAction(id=" + str + ", text=" + str2 + ", link=" + str3 + ")";
    }
}
