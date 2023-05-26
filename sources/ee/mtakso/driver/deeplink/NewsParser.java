package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class NewsParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null && lastPathSegment.hashCode() == 100344454 && lastPathSegment.equals("inbox")) {
            return new DeeplinkCall.NewsInbox(uri.getQueryParameter("message_id"));
        }
        return new DeeplinkCall.News();
    }
}
