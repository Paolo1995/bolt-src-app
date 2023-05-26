package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class RequestWebUrlParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String queryParameter = uri.getQueryParameter("request-url");
        if (queryParameter == null) {
            Kalev.m(new IllegalArgumentException("Required parameter 'request-ur' is missed"), "Required parameter 'request-ur' is missed");
            return null;
        }
        return new DeeplinkCall.RequestWebUrl(queryParameter);
    }
}
