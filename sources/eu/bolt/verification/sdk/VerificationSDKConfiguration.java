package eu.bolt.verification.sdk;

import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public interface VerificationSDKConfiguration {

    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static String a(VerificationSDKConfiguration verificationSDKConfiguration) {
            return "android";
        }

        public static VerificationStatusCallback b(VerificationSDKConfiguration verificationSDKConfiguration) {
            return null;
        }
    }

    boolean a();

    VerificationStatusCallback b();

    String c();

    ClientType d();

    String e();

    String f();

    Retrofit.Builder g();

    String h();

    String i();

    String j();

    String k();

    String l();

    VerificationAnalyticsManager m();
}
