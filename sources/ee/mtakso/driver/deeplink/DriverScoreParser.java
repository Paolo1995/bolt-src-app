package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class DriverScoreParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null && lastPathSegment.hashCode() == 1557721666 && lastPathSegment.equals("details")) {
            return new DeeplinkCall.DriverScoreDetails();
        }
        return null;
    }
}
