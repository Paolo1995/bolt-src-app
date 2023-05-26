package ee.mtakso.driver.network.client.generic;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InformatioMessage.kt */
/* loaded from: classes3.dex */
public final class InformationMessage {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22229a;
    @SerializedName("type")

    /* renamed from: b  reason: collision with root package name */
    private final HighlightType f22230b;
    @SerializedName("text")

    /* renamed from: c  reason: collision with root package name */
    private final String f22231c;

    public final String a() {
        return this.f22231c;
    }

    public final String b() {
        return this.f22229a;
    }

    public final HighlightType c() {
        return this.f22230b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InformationMessage) {
            InformationMessage informationMessage = (InformationMessage) obj;
            return Intrinsics.a(this.f22229a, informationMessage.f22229a) && this.f22230b == informationMessage.f22230b && Intrinsics.a(this.f22231c, informationMessage.f22231c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22229a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.f22230b.hashCode()) * 31) + this.f22231c.hashCode();
    }

    public String toString() {
        String str = this.f22229a;
        HighlightType highlightType = this.f22230b;
        String str2 = this.f22231c;
        return "InformationMessage(title=" + str + ", type=" + highlightType + ", text=" + str2 + ")";
    }
}
