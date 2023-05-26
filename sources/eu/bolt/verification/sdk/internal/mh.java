package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class mh {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f44201a;
    @SerializedName("parameters")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f44202b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof mh) {
            mh mhVar = (mh) obj;
            return Intrinsics.a(this.f44201a, mhVar.f44201a) && Intrinsics.a(this.f44202b, mhVar.f44202b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f44201a.hashCode() * 31;
        Map<String, String> map = this.f44202b;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        String str = this.f44201a;
        Map<String, String> map = this.f44202b;
        return "StaticModalParamsResponse(id=" + str + ", parameters=" + map + ")";
    }
}
