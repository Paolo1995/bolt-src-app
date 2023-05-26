package ee.mtakso.driver.ui.interactor.modaldialog;

/* compiled from: PromoDialogEvent.kt */
/* loaded from: classes3.dex */
public enum PromoDialogEvent {
    HOME_SCREEN("home_screen"),
    GO_ONLINE("go_online"),
    DRIVER_IN_WAITING_AREA("driver_in_waiting_area"),
    EARNINGS("earnings");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f26672f;

    PromoDialogEvent(String str) {
        this.f26672f = str;
    }

    public final String c() {
        return this.f26672f;
    }
}
