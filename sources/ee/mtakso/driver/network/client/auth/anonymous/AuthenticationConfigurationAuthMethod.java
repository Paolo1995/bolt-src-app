package ee.mtakso.driver.network.client.auth.anonymous;

/* compiled from: AuthenticationConfigurationAuthMethod.kt */
/* loaded from: classes3.dex */
public enum AuthenticationConfigurationAuthMethod {
    USERNAME_PASSWORD("username_password"),
    MAGIC_LINK("magic_link"),
    PHONE("phone");
    
    private final String value;

    AuthenticationConfigurationAuthMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
