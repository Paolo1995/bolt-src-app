package ee.mtakso.driver.network.client.targeting;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TargetingParameters.kt */
/* loaded from: classes3.dex */
public final class TargetingParameters {
    @SerializedName("features")

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f22865a;

    public TargetingParameters(Map<String, ? extends Object> parameters) {
        Intrinsics.f(parameters, "parameters");
        this.f22865a = parameters;
    }

    public final Map<String, Object> a() {
        return this.f22865a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TargetingParameters) && Intrinsics.a(this.f22865a, ((TargetingParameters) obj).f22865a);
    }

    public int hashCode() {
        return this.f22865a.hashCode();
    }

    public String toString() {
        Map<String, Object> map = this.f22865a;
        return "TargetingParameters(parameters=" + map + ")";
    }
}
