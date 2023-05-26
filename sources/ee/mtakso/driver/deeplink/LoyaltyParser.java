package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class LoyaltyParser extends NoIntentDeeplinkParser {
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
            int hashCode = lastPathSegment.hashCode();
            if (hashCode != 3322014) {
                if (hashCode == 1557721666 && lastPathSegment.equals("details")) {
                    Long c8 = c(uri);
                    if (c8 != null) {
                        return new DeeplinkCall.LoyaltyOfferDetails(c8.longValue());
                    }
                    return null;
                }
            } else if (lastPathSegment.equals("list")) {
                return new DeeplinkCall.LoyaltyOfferList();
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Loyalty offer deeplink without correct last segment");
        Kalev.e(illegalArgumentException, "Loyalty segment should be presented in the campaign deeplink uri: " + uri);
        return new DeeplinkCall.LoyaltyOfferList();
    }
}
