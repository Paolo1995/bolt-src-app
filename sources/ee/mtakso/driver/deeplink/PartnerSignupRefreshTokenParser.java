package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class PartnerSignupRefreshTokenParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    /* renamed from: c */
    public DeeplinkCall.PartnerSignupRefreshToken b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String queryParameter = uri.getQueryParameter("token");
        if (queryParameter == null) {
            queryParameter = uri.getLastPathSegment();
        }
        if (queryParameter != null) {
            return new DeeplinkCall.PartnerSignupRefreshToken(queryParameter);
        }
        return null;
    }
}
