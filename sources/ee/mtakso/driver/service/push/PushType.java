package ee.mtakso.driver.service.push;

/* compiled from: PushType.kt */
/* loaded from: classes3.dex */
public enum PushType {
    ZENDESK("zendesk_push"),
    BEEHIVE("beehive_push"),
    CHAT("chat"),
    TIP_RECEIVED("tip_received"),
    ORDER_IS_AVAILABLE("order_is_available"),
    ORDER_CANCELLED("order_cancelled"),
    ORDER_FINISHED_EARLIER("order_finished_earlier"),
    ROUTE_UPDATED("destination_changed_by_client"),
    UPCOMING_SCHEDULED_RIDE_GO_ONLINE("upcoming_scheduled_ride_go_online"),
    UNKNOWN("");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f25657f;

    PushType(String str) {
        this.f25657f = str;
    }

    public final String getId() {
        return this.f25657f;
    }
}
