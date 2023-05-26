package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class EarningsParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        boolean v7;
        boolean v8;
        boolean v9;
        boolean v10;
        Intrinsics.f(uri, "uri");
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        v7 = StringsKt__StringsJVMKt.v(path, "balance", false, 2, null);
        if (v7) {
            return new DeeplinkCall.Balance();
        }
        v8 = StringsKt__StringsJVMKt.v(path, "breakdown", false, 2, null);
        if (v8) {
            return new DeeplinkCall.EarningsBreakdown();
        }
        v9 = StringsKt__StringsJVMKt.v(path, "goal", false, 2, null);
        if (v9) {
            return new DeeplinkCall.EarningsGoal();
        }
        v10 = StringsKt__StringsJVMKt.v(path, "goal/keep", false, 2, null);
        if (v10) {
            return new DeeplinkCall.EarningsGoalKeep();
        }
        return new DeeplinkCall.Earnings();
    }
}
