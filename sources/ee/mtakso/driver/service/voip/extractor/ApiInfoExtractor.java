package ee.mtakso.driver.service.voip.extractor;

import com.sinch.android.rtc.internal.client.DefaultSinchClient;
import ee.mtakso.driver.network.client.contact.VoipConfiguration;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiInfoExtractor.kt */
/* loaded from: classes3.dex */
public class ApiInfoExtractor implements VoipInfoExtractor {

    /* renamed from: a  reason: collision with root package name */
    private static final Companion f26140a = new Companion(null);

    /* compiled from: ApiInfoExtractor.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean b(VoipConfiguration voipConfiguration) {
        return Intrinsics.a(voipConfiguration.c(), DefaultSinchClient.PAYLOAD_TAG_SINCH);
    }

    @Override // ee.mtakso.driver.service.voip.extractor.VoipInfoExtractor
    public VoipInfoExtractor.Info a(VoipConfiguration config) {
        String e8;
        String b8;
        String d8;
        Intrinsics.f(config, "config");
        if (!b(config) || (e8 = config.e()) == null || (b8 = config.b()) == null || (d8 = config.d()) == null) {
            return null;
        }
        return new VoipInfoExtractor.Info(e8, b8, d8, null);
    }
}
