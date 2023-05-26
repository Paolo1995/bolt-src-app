package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class IdentityVerificationParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        String queryParameter;
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || lastPathSegment.hashCode() != 109757538 || !lastPathSegment.equals("start") || (queryParameter = uri.getQueryParameter("flow_run_id")) == null) {
            return null;
        }
        return new DeeplinkCall.IdentityVerification(queryParameter, false, 2, null);
    }
}
