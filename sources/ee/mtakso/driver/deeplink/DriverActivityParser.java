package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class DriverActivityParser extends NoIntentDeeplinkParser {
    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            int hashCode = lastPathSegment.hashCode();
            if (hashCode != 99469071) {
                if (hashCode != 110629102) {
                    if (hashCode == 550215993 && lastPathSegment.equals("cancels")) {
                        return new DeeplinkCall.ActivityCancels();
                    }
                } else if (lastPathSegment.equals("trips")) {
                    return new DeeplinkCall.ActivityTrips();
                }
            } else if (lastPathSegment.equals("hours")) {
                return new DeeplinkCall.ActivityHours();
            }
        }
        return new DeeplinkCall.Activity();
    }
}
