package ee.mtakso.driver.deeplink;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public abstract class NoIntentDeeplinkParser implements DeepLinkParameterParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall a(Intent intent) {
        Intrinsics.f(intent, "intent");
        return null;
    }
}
