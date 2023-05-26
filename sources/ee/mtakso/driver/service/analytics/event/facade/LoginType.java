package ee.mtakso.driver.service.analytics.event.facade;

/* compiled from: LoginType.kt */
/* loaded from: classes3.dex */
public enum LoginType {
    USERNAME("username"),
    PHONE("phone"),
    MAGIC_LINK("magicLink"),
    SAVED_CREDENTIALS("savedCredentials"),
    PARTNER_UPGRADE("partnerUpgrade");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f23504f;

    LoginType(String str) {
        this.f23504f = str;
    }

    public final String c() {
        return this.f23504f;
    }
}
