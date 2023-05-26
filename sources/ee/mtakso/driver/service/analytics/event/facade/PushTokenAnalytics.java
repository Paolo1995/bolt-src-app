package ee.mtakso.driver.service.analytics.event.facade;

/* compiled from: PushTokenAnalytics.kt */
/* loaded from: classes3.dex */
public interface PushTokenAnalytics {

    /* compiled from: PushTokenAnalytics.kt */
    /* loaded from: classes3.dex */
    public enum TokenType {
        PARTNER,
        DRIVER,
        UNKNOWN
    }

    void A3(String str, TokenType tokenType);

    void K1(String str, TokenType tokenType);

    void W2(String str, TokenType tokenType);

    void x(String str, TokenType tokenType);
}
