package ee.mtakso.driver.deeplink;

import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class SupportParser implements DeepLinkParameterParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    /* renamed from: c */
    public DeeplinkCall.Support a(Intent intent) {
        Intrinsics.f(intent, "intent");
        String stringExtra = intent.getStringExtra("webapp_launch_token");
        if (stringExtra == null) {
            return null;
        }
        return new DeeplinkCall.Support(stringExtra);
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    /* renamed from: d */
    public DeeplinkCall.Support b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String queryParameter = uri.getQueryParameter("webapp_launch_token");
        if (queryParameter != null) {
            return new DeeplinkCall.Support(queryParameter);
        }
        return null;
    }
}
