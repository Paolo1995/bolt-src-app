package ee.mtakso.driver.network.client.contact;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public enum RecipientType {
    RIDER("rider"),
    DRIVER("driver"),
    SUPPORT("support");
    
    private final String id;

    RecipientType(String str) {
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }
}
