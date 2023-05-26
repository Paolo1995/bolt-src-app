package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class OptInGroupV2 implements OptInCampaign {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21720a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21721b;
    @SerializedName("explanation")

    /* renamed from: c  reason: collision with root package name */
    private final String f21722c;
    @SerializedName("choose_before")

    /* renamed from: d  reason: collision with root package name */
    private final long f21723d;
    @SerializedName("choices")

    /* renamed from: e  reason: collision with root package name */
    private final List<OptInChoiceV2> f21724e;

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaign
    public List<OptInChoiceV2> a() {
        return this.f21724e;
    }

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaign
    public long b() {
        return this.f21723d;
    }

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaign
    public String c() {
        return this.f21722c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptInGroupV2) {
            OptInGroupV2 optInGroupV2 = (OptInGroupV2) obj;
            return getId() == optInGroupV2.getId() && Intrinsics.a(getTitle(), optInGroupV2.getTitle()) && Intrinsics.a(c(), optInGroupV2.c()) && b() == optInGroupV2.b() && Intrinsics.a(a(), optInGroupV2.a());
        }
        return false;
    }

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaign
    public long getId() {
        return this.f21720a;
    }

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaign
    public String getTitle() {
        return this.f21721b;
    }

    public int hashCode() {
        return (((((((i0.a.a(getId()) * 31) + getTitle().hashCode()) * 31) + c().hashCode()) * 31) + i0.a.a(b())) * 31) + a().hashCode();
    }

    public String toString() {
        long id = getId();
        String title = getTitle();
        String c8 = c();
        long b8 = b();
        List<OptInChoiceV2> a8 = a();
        return "OptInGroupV2(id=" + id + ", title=" + title + ", explanation=" + c8 + ", chooseBefore=" + b8 + ", choices=" + a8 + ")";
    }
}
