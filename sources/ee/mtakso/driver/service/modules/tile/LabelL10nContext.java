package ee.mtakso.driver.service.modules.tile;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabelL10nContext.kt */
/* loaded from: classes3.dex */
public final class LabelL10nContext {
    @SerializedName("variables")

    /* renamed from: a  reason: collision with root package name */
    private final List<Integer> f25350a;

    public final List<Integer> a() {
        return this.f25350a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LabelL10nContext) && Intrinsics.a(this.f25350a, ((LabelL10nContext) obj).f25350a);
    }

    public int hashCode() {
        return this.f25350a.hashCode();
    }

    public String toString() {
        List<Integer> list = this.f25350a;
        return "LabelL10nContext(variables=" + list + ")";
    }
}
