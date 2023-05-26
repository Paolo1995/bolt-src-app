package ee.mtakso.driver.deeplink;

import ee.mtakso.driver.service.push.PushType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DeepLinkAction.kt */
/* loaded from: classes3.dex */
public enum DeepLinkAction {
    MAGIC_LOGIN("magic-login", null, 2, null),
    MAGIC_LOGIN_PARTNER("magic-login-partner", null, 2, null),
    PARTNER_SIGNUP_REFRESH_TOKEN("partner-signup-token", null, 2, null),
    PARTNER_CONVERT_LOGIN("partner-login", null, 2, null),
    TRAINING_SHOW("training", null, 2, null),
    TRAINING_START("start-training", null, 2, null),
    IDENTITY_VERIFICATION("identity-verification", null, 2, null),
    SUPPORT_TICKET("support-ticket", PushType.ZENDESK),
    SUPPORT("support", PushType.BEEHIVE),
    CHAT_MESSGAE("chat-message", PushType.CHAT),
    PAYOUTS("payouts", null, 2, null),
    SETTINGS("settings", null, 2, null),
    DRIVER_PRIORITY("driverPriority", null, 2, null),
    EARNINGS("earnings", null, 2, null),
    RIDES("rides", PushType.TIP_RECEIVED),
    NEWS("news", null, 2, null),
    DRIVER_SCORE("driverScore", null, 2, null),
    DRIVER_PRICING("driver-pricing", null, 2, null),
    CAMPAIGNS("campaigns", null, 2, null),
    ACTIVITY("activity", null, 2, null),
    CIRCLE_K("circleK", null, 2, null),
    DRIVER_PORTAL("driver-portal", null, 2, null),
    BOLT_CLUB("loyalty", null, 2, null),
    REQUEST_WEB_URL("request-web-url", null, 2, null),
    HOME("home", null, 2, null),
    STORY("openStory", null, 2, null);
    

    /* renamed from: f  reason: collision with root package name */
    private final String f19989f;

    /* renamed from: g  reason: collision with root package name */
    private final PushType f19990g;

    DeepLinkAction(String str, PushType pushType) {
        this.f19989f = str;
        this.f19990g = pushType;
    }

    public final String c() {
        return this.f19989f;
    }

    public final PushType e() {
        return this.f19990g;
    }

    /* synthetic */ DeepLinkAction(String str, PushType pushType, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? PushType.UNKNOWN : pushType);
    }
}
