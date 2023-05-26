package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class StoryParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String queryParameter = uri.getQueryParameter(Name.MARK);
        if (queryParameter != null) {
            return new DeeplinkCall.Story(queryParameter);
        }
        return null;
    }
}
