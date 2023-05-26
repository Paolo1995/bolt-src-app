package ee.mtakso.driver.network.client.earnings;

/* compiled from: ReportMode.kt */
/* loaded from: classes3.dex */
public enum EarningsScreenType {
    FULL("full"),
    BALANCE("balance"),
    EARNINGS("earnings");
    
    private final String internalId;

    EarningsScreenType(String str) {
        this.internalId = str;
    }

    public final String getInternalId() {
        return this.internalId;
    }
}
