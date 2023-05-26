package ee.mtakso.driver.deeplink;

import android.content.Intent;
import android.net.Uri;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public interface DeepLinkParameterParser {
    DeeplinkCall a(Intent intent);

    DeeplinkCall b(Uri uri);
}
