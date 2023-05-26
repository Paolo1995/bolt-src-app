package ee.mtakso.driver.deeplink;

import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParser.kt */
/* loaded from: classes3.dex */
public final class DeepLinkParser {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19993a = new Companion(null);

    /* compiled from: DeepLinkParser.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final DeepLinkParameterParser a(String str) {
        if (Intrinsics.a(str, DeepLinkAction.MAGIC_LOGIN.c())) {
            return new MagicLoginParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.MAGIC_LOGIN_PARTNER.c())) {
            return new MagicLoginPartnerParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.PARTNER_SIGNUP_REFRESH_TOKEN.c())) {
            return new PartnerSignupRefreshTokenParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.PARTNER_CONVERT_LOGIN.c())) {
            return new EmptyParameterParser(new DeeplinkCall.PartnerConvertLogin());
        }
        if (Intrinsics.a(str, DeepLinkAction.SUPPORT_TICKET.c())) {
            return new SupportTicketParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.SUPPORT.c())) {
            return new SupportParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.RIDES.c())) {
            return new RidesParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.CHAT_MESSGAE.c())) {
            return new ChatParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.EARNINGS.c())) {
            return new EarningsParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.CAMPAIGNS.c())) {
            return new CampaignsParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.PAYOUTS.c())) {
            return new PayoutsParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.NEWS.c())) {
            return new NewsParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.DRIVER_SCORE.c())) {
            return new DriverScoreParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.TRAINING_SHOW.c())) {
            return new EmptyParameterParser(new DeeplinkCall.TrainingShow());
        }
        if (Intrinsics.a(str, DeepLinkAction.TRAINING_START.c())) {
            return new EmptyParameterParser(new DeeplinkCall.TrainingStart());
        }
        if (Intrinsics.a(str, DeepLinkAction.IDENTITY_VERIFICATION.c())) {
            return new IdentityVerificationParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.DRIVER_PRICING.c())) {
            return new EmptyParameterParser(new DeeplinkCall.DriverPricing());
        }
        if (Intrinsics.a(str, DeepLinkAction.SETTINGS.c())) {
            return new EmptyParameterParser(new DeeplinkCall.Settings());
        }
        if (Intrinsics.a(str, DeepLinkAction.DRIVER_PRIORITY.c())) {
            return new EmptyParameterParser(new DeeplinkCall.DriverPriority());
        }
        if (Intrinsics.a(str, DeepLinkAction.CIRCLE_K.c())) {
            return new EmptyParameterParser(new DeeplinkCall.CircleK());
        }
        if (Intrinsics.a(str, DeepLinkAction.DRIVER_PORTAL.c())) {
            return new DriverPortalParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.ACTIVITY.c())) {
            return new DriverActivityParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.BOLT_CLUB.c())) {
            return new LoyaltyParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.REQUEST_WEB_URL.c())) {
            return new RequestWebUrlParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.STORY.c())) {
            return new StoryParser();
        }
        if (Intrinsics.a(str, DeepLinkAction.HOME.c())) {
            return new HomeParser();
        }
        return null;
    }

    private final DeeplinkCall c(Intent intent) {
        DeepLinkAction deepLinkAction;
        String c8;
        DeepLinkParameterParser a8;
        DeeplinkCall a9;
        String stringExtra = intent.getStringExtra("type");
        if (stringExtra == null) {
            return null;
        }
        DeepLinkAction[] values = DeepLinkAction.values();
        int i8 = 0;
        int length = values.length;
        while (true) {
            if (i8 < length) {
                deepLinkAction = values[i8];
                if (Intrinsics.a(stringExtra, deepLinkAction.e().getId())) {
                    break;
                }
                i8++;
            } else {
                deepLinkAction = null;
                break;
            }
        }
        if (deepLinkAction == null || (c8 = deepLinkAction.c()) == null || (a8 = a(c8)) == null || (a9 = a8.a(intent)) == null) {
            return null;
        }
        Kalev.h("Handling intent deepLink");
        return a9;
    }

    private final DeeplinkCall e(Uri uri) {
        DeeplinkCall b8;
        if (uri.getPathSegments().size() != 3) {
            return null;
        }
        String action = uri.getPathSegments().get(1);
        Intrinsics.e(action, "action");
        DeepLinkParameterParser a8 = a(action);
        if (a8 == null || (b8 = a8.b(uri)) == null) {
            return null;
        }
        Kalev.h("Handling web deepLink");
        return b8;
    }

    private final DeeplinkCall f(Uri uri) {
        DeeplinkCall e8 = e(uri);
        if (e8 == null) {
            String uri2 = uri.toString();
            Intrinsics.e(uri2, "uri.toString()");
            return new DeeplinkCall.FallbackWebPage(uri2);
        }
        return e8;
    }

    public final DeeplinkCall b(Uri uri) {
        DeepLinkParameterParser a8;
        DeeplinkCall b8;
        Intrinsics.f(uri, "uri");
        String host = uri.getHost();
        if (host == null || (a8 = a(host)) == null || (b8 = a8.b(uri)) == null) {
            return null;
        }
        Kalev.h("Handling app deepLink");
        return b8;
    }

    public final DeeplinkCall d(Intent intent) {
        Intrinsics.f(intent, "intent");
        Uri data = intent.getData();
        if (data == null) {
            return c(intent);
        }
        if (Intrinsics.a(data.getScheme(), "boltdriverapp")) {
            return b(data);
        }
        if (Intrinsics.a(data.getScheme(), "taxifydriverapp")) {
            return b(data);
        }
        if (Intrinsics.a(data.getHost(), "bolt.eu")) {
            return f(data);
        }
        if (Intrinsics.a(data.getHost(), "taxify.eu")) {
            return e(data);
        }
        return null;
    }
}
