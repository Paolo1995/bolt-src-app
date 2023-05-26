package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class CampaignsParser extends NoIntentDeeplinkParser {
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
        DeeplinkCall campaignDetails;
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            switch (lastPathSegment.hashCode()) {
                case -1335224239:
                    if (lastPathSegment.equals("detail")) {
                        Long c8 = c(uri);
                        if (c8 == null) {
                            return null;
                        }
                        campaignDetails = new DeeplinkCall.CampaignDetails(c8.longValue());
                        return campaignDetails;
                    }
                    break;
                case -1010194817:
                    if (lastPathSegment.equals("opt-in")) {
                        Long c9 = c(uri);
                        if (c9 == null) {
                            return null;
                        }
                        campaignDetails = new DeeplinkCall.CampaignOptIn(c9.longValue());
                        return campaignDetails;
                    }
                    break;
                case 3322014:
                    if (lastPathSegment.equals("list")) {
                        return new DeeplinkCall.CampaignList();
                    }
                    break;
                case 218841809:
                    if (lastPathSegment.equals("invite-friends")) {
                        return new DeeplinkCall.CampaignReferrals();
                    }
                    break;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Campaign deeplink without correct last segment");
        Kalev.e(illegalArgumentException, "Campaign segment should be presented in the campaign deeplink uri: " + uri);
        return null;
    }
}
