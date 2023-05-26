package ee.mtakso.driver.deeplink;

import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class RidesParser implements DeepLinkParameterParser {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20022a = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static final UriMatcher f20023b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeepLinkParameterParser.kt */
    /* loaded from: classes3.dex */
    public enum Code {
        DETAILS("orderDetails"),
        START_DRIVING("start-driving"),
        REJECT("reject"),
        UPCOMING_LIST("upcoming/list"),
        UPCOMING_DETAILS("upcoming/details");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f20030f;

        Code(String str) {
            this.f20030f = str;
        }

        public final String c() {
            return this.f20030f;
        }
    }

    /* compiled from: DeepLinkParameterParser.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Code[] values;
        UriMatcher uriMatcher = new UriMatcher(-1);
        for (Code code : Code.values()) {
            uriMatcher.addURI("rides", code.c(), code.ordinal());
        }
        f20023b = uriMatcher;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.o(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.o(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final ee.mtakso.driver.network.client.OrderHandle c(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "order_system"
            java.lang.String r2 = r8.getQueryParameter(r0)
            r0 = 0
            if (r2 != 0) goto La
            return r0
        La:
            java.lang.String r1 = "city_id"
            java.lang.String r1 = r8.getQueryParameter(r1)
            if (r1 == 0) goto L35
            java.lang.Long r1 = kotlin.text.StringsKt.o(r1)
            if (r1 == 0) goto L35
            long r3 = r1.longValue()
            java.lang.String r1 = "order_id"
            java.lang.String r8 = r8.getQueryParameter(r1)
            if (r8 == 0) goto L35
            java.lang.Long r8 = kotlin.text.StringsKt.o(r8)
            if (r8 == 0) goto L35
            long r5 = r8.longValue()
            ee.mtakso.driver.network.client.OrderHandle r8 = new ee.mtakso.driver.network.client.OrderHandle
            r1 = r8
            r1.<init>(r2, r3, r5)
            return r8
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.deeplink.RidesParser.c(android.net.Uri):ee.mtakso.driver.network.client.OrderHandle");
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall a(Intent intent) {
        boolean z7;
        Intrinsics.f(intent, "intent");
        String stringExtra = intent.getStringExtra("action");
        if (stringExtra != null) {
            if (stringExtra.length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                stringExtra = null;
            }
            if (stringExtra != null) {
                Uri parse = Uri.parse(stringExtra);
                Intrinsics.e(parse, "parse(action)");
                return b(parse);
            }
        }
        return null;
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        OrderHandle c8;
        Intrinsics.f(uri, "uri");
        int match = f20023b.match(uri);
        if (match == Code.DETAILS.ordinal()) {
            OrderHandle c9 = c(uri);
            if (c9 == null) {
                return null;
            }
            return new DeeplinkCall.RideDetails(c9);
        } else if (match == Code.START_DRIVING.ordinal()) {
            OrderHandle c10 = c(uri);
            if (c10 == null) {
                return null;
            }
            return new DeeplinkCall.RideStartDriving(c10);
        } else if (match == Code.REJECT.ordinal()) {
            OrderHandle c11 = c(uri);
            if (c11 == null) {
                return null;
            }
            return new DeeplinkCall.RideReject(c11);
        } else if (match == Code.UPCOMING_LIST.ordinal()) {
            return new DeeplinkCall.UpcomingRides();
        } else {
            if (match != Code.UPCOMING_DETAILS.ordinal() || (c8 = c(uri)) == null) {
                return null;
            }
            return new DeeplinkCall.UpcomingRideDetails(c8);
        }
    }
}
