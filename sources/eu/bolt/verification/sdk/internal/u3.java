package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public enum u3 {
    ABOUT("/about"),
    ADD_CREDIT_CARD("/addCreditCard"),
    PROMO_CODE("/promoCode"),
    HISTORY("/history"),
    HISTORY_INTERNAL("/internal/history"),
    HISTORY_DETAILS("/historyDetails"),
    BOOK_A_RIDE("/bookaride"),
    PAYMENTS("/paymentMethods"),
    PROFILE("/profile"),
    BOLT_PLUS("/subscriptionOffer"),
    COMM_SETTINGS("/communication"),
    FREE_RIDES("/freeRides"),
    SUPPORT("/support"),
    WORK("/work"),
    OPEN_BROWSER("/openBrowser"),
    CLOSE_BROWSER("/closeBrowser"),
    ROUTE_TO_HOME("/routeToHome"),
    ROUTE_TO_WORK("/routeToWork"),
    SUBSCRIPTIONS("/rentalSubscriptionsList"),
    OPEN_STORY("/openStory"),
    SCOOTERS_SEARCH("/scootersSearch"),
    SCOOTER_SCANNED("/scooterscanned"),
    SCOOTER_SELECTED("/scooterselected"),
    SCOOTER_QR("qr"),
    RENTALS_ROTATED_UUID("/rentalsSelectVehicleByRotatedUuid"),
    CARSHARING("/carsharing"),
    OPEN_RIDEHAILING("/openRidehailing"),
    SHARE_ACTIVE_RIDE("/shareRideDetails"),
    RENTAL_RETRY_ORDER("/rentalRetryOrder"),
    RENTAL_VERIFICATION_INIT("/verification/init"),
    RENTAL_VERIFICATION_ADDRESS_REQUEST("/verification/address/request"),
    DYNAMIC_MODAL("internal/dynamicModal"),
    CHAT("internal/chat"),
    BUG_REPORT("internal/bugReport"),
    GEO("geo"),
    SCHEDULED_RIDES_PICKUP_DATE("/setPickupDate"),
    CLEAR_SCHEDULED_RIDE("/resetPickupDate"),
    SCHEDULED_RIDES_ONBOARDING("/scheduledRidesOnboarding"),
    PICKUP_DIRECTIONS("/pickupDirections"),
    CATEGORY_DETAILS("/rideHailingOrder/categoryDetails"),
    CATEGORIES("/internal/openCategories"),
    SYSTEM_NOTIFICATION_SETTINGS("/openNotificationPermissionSettings"),
    LOGOUT("/internal/logout"),
    STATIC_MODAL("/staticModal"),
    BLOCKS_MODAL("/blocksModal"),
    OPEN_DISCOUNT_DETAILS("/openDiscountDetails");
    

    /* renamed from: g  reason: collision with root package name */
    public static final a f45289g = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final String f45309f;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    u3(String str) {
        this.f45309f = str;
    }

    public final String c() {
        return this.f45309f;
    }
}
