package ee.mtakso.driver.network.client.training;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Training.kt */
/* loaded from: classes3.dex */
public final class Training {
    @SerializedName("stories")

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f22873a;

    public final List<String> a() {
        return this.f22873a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Training) && Intrinsics.a(this.f22873a, ((Training) obj).f22873a);
    }

    public int hashCode() {
        List<String> list = this.f22873a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        List<String> list = this.f22873a;
        return "Training(stories=" + list + ")";
    }
}
