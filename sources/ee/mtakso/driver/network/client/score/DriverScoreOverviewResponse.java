package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class DriverScoreOverviewResponse {
    @SerializedName("score_details")

    /* renamed from: a  reason: collision with root package name */
    private final ScoreDetails f22726a;
    @SerializedName("actions")

    /* renamed from: b  reason: collision with root package name */
    private final List<Action> f22727b;
    @SerializedName("score_reducing_issues")

    /* renamed from: c  reason: collision with root package name */
    private final ScoreReducingIssues f22728c;
    @SerializedName("rating_shown_to_riders")

    /* renamed from: d  reason: collision with root package name */
    private final RatingShownToRiders f22729d;
    @SerializedName("tips")

    /* renamed from: e  reason: collision with root package name */
    private final TipsSection f22730e;

    public final List<Action> a() {
        return this.f22727b;
    }

    public final RatingShownToRiders b() {
        return this.f22729d;
    }

    public final ScoreDetails c() {
        return this.f22726a;
    }

    public final ScoreReducingIssues d() {
        return this.f22728c;
    }

    public final TipsSection e() {
        return this.f22730e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverScoreOverviewResponse) {
            DriverScoreOverviewResponse driverScoreOverviewResponse = (DriverScoreOverviewResponse) obj;
            return Intrinsics.a(this.f22726a, driverScoreOverviewResponse.f22726a) && Intrinsics.a(this.f22727b, driverScoreOverviewResponse.f22727b) && Intrinsics.a(this.f22728c, driverScoreOverviewResponse.f22728c) && Intrinsics.a(this.f22729d, driverScoreOverviewResponse.f22729d) && Intrinsics.a(this.f22730e, driverScoreOverviewResponse.f22730e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22726a.hashCode() * 31;
        List<Action> list = this.f22727b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        ScoreReducingIssues scoreReducingIssues = this.f22728c;
        int hashCode3 = (hashCode2 + (scoreReducingIssues == null ? 0 : scoreReducingIssues.hashCode())) * 31;
        RatingShownToRiders ratingShownToRiders = this.f22729d;
        int hashCode4 = (hashCode3 + (ratingShownToRiders == null ? 0 : ratingShownToRiders.hashCode())) * 31;
        TipsSection tipsSection = this.f22730e;
        return hashCode4 + (tipsSection != null ? tipsSection.hashCode() : 0);
    }

    public String toString() {
        ScoreDetails scoreDetails = this.f22726a;
        List<Action> list = this.f22727b;
        ScoreReducingIssues scoreReducingIssues = this.f22728c;
        RatingShownToRiders ratingShownToRiders = this.f22729d;
        TipsSection tipsSection = this.f22730e;
        return "DriverScoreOverviewResponse(scoreDetails=" + scoreDetails + ", actions=" + list + ", scoreReducingIssues=" + scoreReducingIssues + ", ratingShownToRiders=" + ratingShownToRiders + ", tips=" + tipsSection + ")";
    }
}
