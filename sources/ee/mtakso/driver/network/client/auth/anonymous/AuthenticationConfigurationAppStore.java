package ee.mtakso.driver.network.client.auth.anonymous;

/* compiled from: AuthenticationConfigurationAppStore.kt */
/* loaded from: classes3.dex */
public enum AuthenticationConfigurationAppStore {
    PLAY_STORE("google"),
    APP_GALLERY("huawei");
    
    private final String value;

    AuthenticationConfigurationAppStore(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
