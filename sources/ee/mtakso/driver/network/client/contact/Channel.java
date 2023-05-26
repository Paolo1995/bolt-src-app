package ee.mtakso.driver.network.client.contact;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public enum Channel {
    CHAT("chat"),
    VOIP("voip"),
    PHONE_CALL("phone_call"),
    SIMPLE_MESSAGE("simple_message"),
    PHONE_CALL_SUPPORT("phone_call_support"),
    UNKNOWN("unknown_channel");
    
    private final String id;

    Channel(String str) {
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }
}
