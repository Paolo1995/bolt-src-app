package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideDetailInfoBlock.kt */
/* loaded from: classes3.dex */
public final class RideDetailInfoBlock {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final Type f22540a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f22541b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f22542c;
    @SerializedName("show_icon")

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22543d;

    /* compiled from: RideDetailInfoBlock.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        SUCCESS,
        ALERT,
        WARNING,
        INFO
    }

    public final boolean a() {
        return this.f22543d;
    }

    public final String b() {
        return this.f22542c;
    }

    public final String c() {
        return this.f22541b;
    }

    public final Type d() {
        return this.f22540a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RideDetailInfoBlock) {
            RideDetailInfoBlock rideDetailInfoBlock = (RideDetailInfoBlock) obj;
            return this.f22540a == rideDetailInfoBlock.f22540a && Intrinsics.a(this.f22541b, rideDetailInfoBlock.f22541b) && Intrinsics.a(this.f22542c, rideDetailInfoBlock.f22542c) && this.f22543d == rideDetailInfoBlock.f22543d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f22540a.hashCode() * 31) + this.f22541b.hashCode()) * 31;
        String str = this.f22542c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z7 = this.f22543d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        Type type = this.f22540a;
        String str = this.f22541b;
        String str2 = this.f22542c;
        boolean z7 = this.f22543d;
        return "RideDetailInfoBlock(type=" + type + ", text=" + str + ", subtitle=" + str2 + ", showIcon=" + z7 + ")";
    }
}
