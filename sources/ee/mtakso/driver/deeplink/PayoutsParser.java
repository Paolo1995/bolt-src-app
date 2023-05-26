package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class PayoutsParser extends NoIntentDeeplinkParser {
    private final Long c(Uri uri) {
        Long o8;
        String queryParameter = uri.getQueryParameter(Name.MARK);
        if (queryParameter != null) {
            o8 = StringsKt__StringNumberConversionsKt.o(queryParameter);
            return o8;
        }
        return null;
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            switch (lastPathSegment.hashCode()) {
                case -1619874672:
                    if (lastPathSegment.equals("requirements")) {
                        return new DeeplinkCall.PayoutRequirements();
                    }
                    break;
                case 926934164:
                    if (lastPathSegment.equals("history")) {
                        return new DeeplinkCall.PayoutHistory();
                    }
                    break;
                case 1557721666:
                    if (lastPathSegment.equals("details")) {
                        Long c8 = c(uri);
                        if (c8 != null) {
                            return new DeeplinkCall.PayoutDetails(c8.longValue());
                        }
                        return null;
                    }
                    break;
                case 2099153973:
                    if (lastPathSegment.equals("confirmation")) {
                        return new DeeplinkCall.PayoutConfirmation();
                    }
                    break;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Campaign deeplink without correct last segment");
        Kalev.e(illegalArgumentException, "Campaign segment should be presented in the campaign deeplink uri: " + uri);
        return new DeeplinkCall.PayoutHistory();
    }
}
