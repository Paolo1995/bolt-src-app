package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.network.client.campaign.Bonus;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferralCampaignState.kt */
/* loaded from: classes3.dex */
public final class ReferralCampaignState {

    /* renamed from: a  reason: collision with root package name */
    private final Long f27550a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f27551b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f27552c;

    /* renamed from: d  reason: collision with root package name */
    private final Text f27553d;

    /* renamed from: e  reason: collision with root package name */
    private final Text f27554e;

    /* renamed from: f  reason: collision with root package name */
    private final Text f27555f;

    /* renamed from: g  reason: collision with root package name */
    private final Text f27556g;

    /* renamed from: h  reason: collision with root package name */
    private final String f27557h;

    /* renamed from: i  reason: collision with root package name */
    private final Bonus f27558i;

    /* renamed from: j  reason: collision with root package name */
    private final Text f27559j;

    /* renamed from: k  reason: collision with root package name */
    private final List<ListModel> f27560k;

    /* renamed from: l  reason: collision with root package name */
    private final Text f27561l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f27562m;

    /* JADX WARN: Multi-variable type inference failed */
    public ReferralCampaignState(Long l8, Text title, Text text, Text text2, Text text3, Text text4, Text inviteTitle, String str, Bonus bonus, Text text5, List<? extends ListModel> invitations, Text text6, boolean z7) {
        Intrinsics.f(title, "title");
        Intrinsics.f(inviteTitle, "inviteTitle");
        Intrinsics.f(invitations, "invitations");
        this.f27550a = l8;
        this.f27551b = title;
        this.f27552c = text;
        this.f27553d = text2;
        this.f27554e = text3;
        this.f27555f = text4;
        this.f27556g = inviteTitle;
        this.f27557h = str;
        this.f27558i = bonus;
        this.f27559j = text5;
        this.f27560k = invitations;
        this.f27561l = text6;
        this.f27562m = z7;
    }

    public final Bonus a() {
        return this.f27558i;
    }

    public final Text b() {
        return this.f27554e;
    }

    public final Text c() {
        return this.f27559j;
    }

    public final Text d() {
        return this.f27553d;
    }

    public final Long e() {
        return this.f27550a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReferralCampaignState) {
            ReferralCampaignState referralCampaignState = (ReferralCampaignState) obj;
            return Intrinsics.a(this.f27550a, referralCampaignState.f27550a) && Intrinsics.a(this.f27551b, referralCampaignState.f27551b) && Intrinsics.a(this.f27552c, referralCampaignState.f27552c) && Intrinsics.a(this.f27553d, referralCampaignState.f27553d) && Intrinsics.a(this.f27554e, referralCampaignState.f27554e) && Intrinsics.a(this.f27555f, referralCampaignState.f27555f) && Intrinsics.a(this.f27556g, referralCampaignState.f27556g) && Intrinsics.a(this.f27557h, referralCampaignState.f27557h) && Intrinsics.a(this.f27558i, referralCampaignState.f27558i) && Intrinsics.a(this.f27559j, referralCampaignState.f27559j) && Intrinsics.a(this.f27560k, referralCampaignState.f27560k) && Intrinsics.a(this.f27561l, referralCampaignState.f27561l) && this.f27562m == referralCampaignState.f27562m;
        }
        return false;
    }

    public final List<ListModel> f() {
        return this.f27560k;
    }

    public final String g() {
        return this.f27557h;
    }

    public final Text h() {
        return this.f27556g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Long l8 = this.f27550a;
        int hashCode = (((l8 == null ? 0 : l8.hashCode()) * 31) + this.f27551b.hashCode()) * 31;
        Text text = this.f27552c;
        int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
        Text text2 = this.f27553d;
        int hashCode3 = (hashCode2 + (text2 == null ? 0 : text2.hashCode())) * 31;
        Text text3 = this.f27554e;
        int hashCode4 = (hashCode3 + (text3 == null ? 0 : text3.hashCode())) * 31;
        Text text4 = this.f27555f;
        int hashCode5 = (((hashCode4 + (text4 == null ? 0 : text4.hashCode())) * 31) + this.f27556g.hashCode()) * 31;
        String str = this.f27557h;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Bonus bonus = this.f27558i;
        int hashCode7 = (hashCode6 + (bonus == null ? 0 : bonus.hashCode())) * 31;
        Text text5 = this.f27559j;
        int hashCode8 = (((hashCode7 + (text5 == null ? 0 : text5.hashCode())) * 31) + this.f27560k.hashCode()) * 31;
        Text text6 = this.f27561l;
        int hashCode9 = (hashCode8 + (text6 != null ? text6.hashCode() : 0)) * 31;
        boolean z7 = this.f27562m;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode9 + i8;
    }

    public final Text i() {
        return this.f27555f;
    }

    public final boolean j() {
        return this.f27562m;
    }

    public final Text k() {
        return this.f27561l;
    }

    public final Text l() {
        return this.f27551b;
    }

    public final Text m() {
        return this.f27552c;
    }

    public String toString() {
        Long l8 = this.f27550a;
        Text text = this.f27551b;
        Text text2 = this.f27552c;
        Text text3 = this.f27553d;
        Text text4 = this.f27554e;
        Text text5 = this.f27555f;
        Text text6 = this.f27556g;
        String str = this.f27557h;
        Bonus bonus = this.f27558i;
        Text text7 = this.f27559j;
        List<ListModel> list = this.f27560k;
        Text text8 = this.f27561l;
        boolean z7 = this.f27562m;
        return "ReferralCampaignState(id=" + l8 + ", title=" + text + ", validUntil=" + text2 + ", earnedAmount=" + text3 + ", category=" + text4 + ", location=" + text5 + ", inviteTitle=" + text6 + ", inviteCode=" + str + ", bonus=" + bonus + ", description=" + text7 + ", invitations=" + list + ", note=" + text8 + ", noCampaignState=" + z7 + ")";
    }

    public /* synthetic */ ReferralCampaignState(Long l8, Text text, Text text2, Text text3, Text text4, Text text5, Text text6, String str, Bonus bonus, Text text7, List list, Text text8, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(l8, text, text2, text3, text4, text5, text6, str, bonus, text7, list, text8, (i8 & 4096) != 0 ? false : z7);
    }
}
