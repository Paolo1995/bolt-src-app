package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.ui.utils.ThemedImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class Image implements ThemedImage {
    @SerializedName("light_url")

    /* renamed from: f  reason: collision with root package name */
    private final String f21684f;
    @SerializedName("dark_url")

    /* renamed from: g  reason: collision with root package name */
    private final String f21685g;

    @Override // ee.mtakso.driver.ui.utils.ThemedImage
    public String a() {
        return this.f21684f;
    }

    @Override // ee.mtakso.driver.ui.utils.ThemedImage
    public String b() {
        return this.f21685g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Image) {
            Image image = (Image) obj;
            return Intrinsics.a(a(), image.a()) && Intrinsics.a(b(), image.b());
        }
        return false;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + b().hashCode();
    }

    public String toString() {
        String a8 = a();
        String b8 = b();
        return "Image(lightUrl=" + a8 + ", darkUrl=" + b8 + ")";
    }
}
