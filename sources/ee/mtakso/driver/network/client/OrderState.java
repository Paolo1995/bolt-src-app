package ee.mtakso.driver.network.client;

/* compiled from: OrderState.kt */
/* loaded from: classes3.dex */
public enum OrderState {
    ORDER_STATE_WAITING_DRIVER_CONFIRMATION(0),
    ORDER_STATE_ARRIVED_TO_DESTINATION(1),
    ORDER_STATE_DRIVING_WITH_CLIENT(1),
    ORDER_STATE_WAITING_ON_STOP(1),
    ORDER_STATE_DRIVER_ACCEPTED(2),
    ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT(2),
    ORDER_STATE_CLIENT_CANCELLED(3),
    ORDER_STATE_DRIVER_DID_NOT_RESPOND(3),
    ORDER_STATE_DRIVER_REJECTED(3),
    ORDER_STATE_CLIENT_DID_NOT_SHOW(3),
    ORDER_STATE_PAYMENT_BOOKING_FAILED(3),
    ORDER_STATE_FINISHED(3),
    ORDER_STATE_UNKNOWN(10);
    
    private final int priority;

    OrderState(int i8) {
        this.priority = i8;
    }

    public final int getPriority() {
        return this.priority;
    }
}
