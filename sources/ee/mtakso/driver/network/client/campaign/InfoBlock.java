package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class InfoBlock {
    @SerializedName("appearance")

    /* renamed from: a  reason: collision with root package name */
    private final Appearance f21686a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f21687b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f21688c;
    @SerializedName("show_icon")

    /* renamed from: d  reason: collision with root package name */
    private final boolean f21689d;

    /* compiled from: CampaignV2.kt */
    /* loaded from: classes3.dex */
    public enum Appearance {
        NONE,
        SUCCESS,
        ALERT,
        WARNING,
        INFO
    }

    public final Appearance a() {
        return this.f21686a;
    }

    public final boolean b() {
        return this.f21689d;
    }

    public final String c() {
        return this.f21688c;
    }

    public final String d() {
        return this.f21687b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InfoBlock) {
            InfoBlock infoBlock = (InfoBlock) obj;
            return this.f21686a == infoBlock.f21686a && Intrinsics.a(this.f21687b, infoBlock.f21687b) && Intrinsics.a(this.f21688c, infoBlock.f21688c) && this.f21689d == infoBlock.f21689d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f21686a.hashCode() * 31) + this.f21687b.hashCode()) * 31;
        String str = this.f21688c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z7 = this.f21689d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        Appearance appearance = this.f21686a;
        String str = this.f21687b;
        String str2 = this.f21688c;
        boolean z7 = this.f21689d;
        return "InfoBlock(appearance=" + appearance + ", text=" + str + ", subtitle=" + str2 + ", show_icon=" + z7 + ")";
    }
}
