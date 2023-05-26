package ee.mtakso.driver.deeplink;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.contact_methods.chat.ChatFragment$ChatParams;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkCall.kt */
/* loaded from: classes3.dex */
public abstract class DeeplinkCall {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f19995a;

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Activity extends DeeplinkCall {
        public Activity() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class ActivityCancels extends DeeplinkCall {
        public ActivityCancels() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class ActivityHours extends DeeplinkCall {
        public ActivityHours() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class ActivityTrips extends DeeplinkCall {
        public ActivityTrips() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Balance extends DeeplinkCall {
        public Balance() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class CampaignDetails extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final long f19996b;

        public CampaignDetails(long j8) {
            super(null);
            this.f19996b = j8;
        }

        public final long b() {
            return this.f19996b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class CampaignList extends DeeplinkCall {
        public CampaignList() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class CampaignOptIn extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final long f19997b;

        public CampaignOptIn(long j8) {
            super(null);
            this.f19997b = j8;
        }

        public final long b() {
            return this.f19997b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class CampaignReferrals extends DeeplinkCall {
        public CampaignReferrals() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Chat extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final ChatFragment$ChatParams f19998b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Chat(ChatFragment$ChatParams chat) {
            super(null);
            Intrinsics.f(chat, "chat");
            this.f19998b = chat;
        }

        public final ChatFragment$ChatParams b() {
            return this.f19998b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class CircleK extends DeeplinkCall {
        public CircleK() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class DriverPortal extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f19999b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DriverPortal(String section) {
            super(null);
            Intrinsics.f(section, "section");
            this.f19999b = section;
        }

        public final String b() {
            return this.f19999b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class DriverPortalRoot extends DeeplinkCall {
        public DriverPortalRoot() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class DriverPortalWithHash extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20000b;

        /* renamed from: c  reason: collision with root package name */
        private final String f20001c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DriverPortalWithHash(String section, String hash) {
            super(null);
            Intrinsics.f(section, "section");
            Intrinsics.f(hash, "hash");
            this.f20000b = section;
            this.f20001c = hash;
        }

        public final String b() {
            return this.f20001c;
        }

        public final String c() {
            return this.f20000b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class DriverPricing extends DeeplinkCall {
        public DriverPricing() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class DriverPriority extends DeeplinkCall {
        public DriverPriority() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class DriverScoreDetails extends DeeplinkCall {
        public DriverScoreDetails() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Earnings extends DeeplinkCall {
        public Earnings() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class EarningsBreakdown extends DeeplinkCall {
        public EarningsBreakdown() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class EarningsGoal extends DeeplinkCall {
        public EarningsGoal() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class EarningsGoalKeep extends DeeplinkCall {
        public EarningsGoalKeep() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class FallbackWebPage extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20002b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FallbackWebPage(String url) {
            super(null);
            Intrinsics.f(url, "url");
            this.f20002b = url;
        }

        public final String b() {
            return this.f20002b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class HomeMapSettings extends DeeplinkCall {
        public HomeMapSettings() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class IdentityVerification extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20003b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f20004c;

        public /* synthetic */ IdentityVerification(String str, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? true : z7);
        }

        @Override // ee.mtakso.driver.deeplink.DeeplinkCall
        public boolean a() {
            return this.f20004c;
        }

        public final String b() {
            return this.f20003b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IdentityVerification) {
                IdentityVerification identityVerification = (IdentityVerification) obj;
                return Intrinsics.a(this.f20003b, identityVerification.f20003b) && a() == identityVerification.a();
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int hashCode = this.f20003b.hashCode() * 31;
            boolean a8 = a();
            ?? r12 = a8;
            if (a8) {
                r12 = 1;
            }
            return hashCode + r12;
        }

        public String toString() {
            String str = this.f20003b;
            boolean a8 = a();
            return "IdentityVerification(flowRunId=" + str + ", canHandleUnauthorized=" + a8 + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdentityVerification(String flowRunId, boolean z7) {
            super(null);
            Intrinsics.f(flowRunId, "flowRunId");
            this.f20003b = flowRunId;
            this.f20004c = z7;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class LoyaltyOfferDetails extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final long f20005b;

        public LoyaltyOfferDetails(long j8) {
            super(null);
            this.f20005b = j8;
        }

        public final long b() {
            return this.f20005b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class LoyaltyOfferList extends DeeplinkCall {
        public LoyaltyOfferList() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class MagicLogin extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20006b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f20007c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MagicLogin(String token, boolean z7) {
            super(null);
            Intrinsics.f(token, "token");
            this.f20006b = token;
            this.f20007c = z7;
        }

        public final boolean b() {
            return this.f20007c;
        }

        public final String c() {
            return this.f20006b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class News extends DeeplinkCall {
        public News() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class NewsInbox extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20008b;

        public NewsInbox(String str) {
            super(null);
            this.f20008b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NewsInbox) && Intrinsics.a(this.f20008b, ((NewsInbox) obj).f20008b);
        }

        public int hashCode() {
            String str = this.f20008b;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            String str = this.f20008b;
            return "NewsInbox(messageId=" + str + ")";
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class PartnerConvertLogin extends DeeplinkCall {
        public PartnerConvertLogin() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class PartnerSignupRefreshToken extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20009b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PartnerSignupRefreshToken(String partnerRefreshToken) {
            super(null);
            Intrinsics.f(partnerRefreshToken, "partnerRefreshToken");
            this.f20009b = partnerRefreshToken;
        }

        public final String b() {
            return this.f20009b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutConfirmation extends DeeplinkCall {
        public PayoutConfirmation() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutDetails extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final long f20010b;

        public PayoutDetails(long j8) {
            super(null);
            this.f20010b = j8;
        }

        public final long b() {
            return this.f20010b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutHistory extends DeeplinkCall {
        public PayoutHistory() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutRequirements extends DeeplinkCall {
        public PayoutRequirements() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class RequestWebUrl extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20011b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestWebUrl(String requestUrl) {
            super(null);
            Intrinsics.f(requestUrl, "requestUrl");
            this.f20011b = requestUrl;
        }

        public final String b() {
            return this.f20011b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestWebUrl) && Intrinsics.a(this.f20011b, ((RequestWebUrl) obj).f20011b);
        }

        public int hashCode() {
            return this.f20011b.hashCode();
        }

        public String toString() {
            String str = this.f20011b;
            return "RequestWebUrl(requestUrl=" + str + ")";
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class RideDetails extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final OrderHandle f20012b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RideDetails(OrderHandle orderHandle) {
            super(null);
            Intrinsics.f(orderHandle, "orderHandle");
            this.f20012b = orderHandle;
        }

        public final OrderHandle b() {
            return this.f20012b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class RideReject extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final OrderHandle f20013b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RideReject(OrderHandle orderHandle) {
            super(null);
            Intrinsics.f(orderHandle, "orderHandle");
            this.f20013b = orderHandle;
        }

        public final OrderHandle b() {
            return this.f20013b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class RideStartDriving extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final OrderHandle f20014b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RideStartDriving(OrderHandle orderHandle) {
            super(null);
            Intrinsics.f(orderHandle, "orderHandle");
            this.f20014b = orderHandle;
        }

        public final OrderHandle b() {
            return this.f20014b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Settings extends DeeplinkCall {
        public Settings() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Story extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20015b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Story(String id) {
            super(null);
            Intrinsics.f(id, "id");
            this.f20015b = id;
        }

        public final String b() {
            return this.f20015b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class Support extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20016b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Support(String webAppLaunchToken) {
            super(null);
            Intrinsics.f(webAppLaunchToken, "webAppLaunchToken");
            this.f20016b = webAppLaunchToken;
        }

        public final String b() {
            return this.f20016b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class SupportTicket extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final String f20017b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportTicket(String webAppLaunchToken) {
            super(null);
            Intrinsics.f(webAppLaunchToken, "webAppLaunchToken");
            this.f20017b = webAppLaunchToken;
        }

        public final String b() {
            return this.f20017b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class TrainingShow extends DeeplinkCall {
        public TrainingShow() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class TrainingStart extends DeeplinkCall {
        public TrainingStart() {
            super(null);
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class UpcomingRideDetails extends DeeplinkCall {

        /* renamed from: b  reason: collision with root package name */
        private final OrderHandle f20018b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpcomingRideDetails(OrderHandle orderHandle) {
            super(null);
            Intrinsics.f(orderHandle, "orderHandle");
            this.f20018b = orderHandle;
        }

        public final OrderHandle b() {
            return this.f20018b;
        }
    }

    /* compiled from: DeeplinkCall.kt */
    /* loaded from: classes3.dex */
    public static final class UpcomingRides extends DeeplinkCall {
        public UpcomingRides() {
            super(null);
        }
    }

    private DeeplinkCall() {
    }

    public /* synthetic */ DeeplinkCall(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean a() {
        return this.f19995a;
    }
}
