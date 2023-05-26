package ee.mtakso.driver.network.client.campaign;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class CircleKLoyaltySignUpMagicLink {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f21627a;

    public final String a() {
        return this.f21627a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CircleKLoyaltySignUpMagicLink) && Intrinsics.a(this.f21627a, ((CircleKLoyaltySignUpMagicLink) obj).f21627a);
    }

    public int hashCode() {
        return this.f21627a.hashCode();
    }

    public String toString() {
        String str = this.f21627a;
        return "CircleKLoyaltySignUpMagicLink(url=" + str + ")";
    }
}
