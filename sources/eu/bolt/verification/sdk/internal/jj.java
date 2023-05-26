package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class jj extends dh {
    @SerializedName(Name.MARK)

    /* renamed from: d  reason: collision with root package name */
    private final String f43707d;
    @SerializedName("slides")

    /* renamed from: e  reason: collision with root package name */
    private final List<jk> f43708e;

    public final String a() {
        return this.f43707d;
    }

    public final List<jk> b() {
        return this.f43708e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof jj) {
            jj jjVar = (jj) obj;
            return Intrinsics.a(this.f43707d, jjVar.f43707d) && Intrinsics.a(this.f43708e, jjVar.f43708e);
        }
        return false;
    }

    public int hashCode() {
        return (this.f43707d.hashCode() * 31) + this.f43708e.hashCode();
    }

    public String toString() {
        String str = this.f43707d;
        List<jk> list = this.f43708e;
        return "StoryResponse(id=" + str + ", slides=" + list + ")";
    }
}
