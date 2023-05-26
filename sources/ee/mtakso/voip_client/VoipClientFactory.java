package ee.mtakso.voip_client;

import android.content.Context;
import ee.mtakso.voip_client.sinch.PushProfileData;
import ee.mtakso.voip_client.sinch.SinchCallClient;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipClientFactory.kt */
/* loaded from: classes5.dex */
public final class VoipClientFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36534a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipLogger f36535b;

    public VoipClientFactory(Context context, VoipLogger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(logger, "logger");
        this.f36534a = context;
        this.f36535b = logger;
    }

    public final VoipClient a(String userId, String applicationKey, String jwt, VoipPushServiceType voipPushServiceType, PushProfileData pushProfileData) {
        Intrinsics.f(userId, "userId");
        Intrinsics.f(applicationKey, "applicationKey");
        Intrinsics.f(jwt, "jwt");
        Intrinsics.f(voipPushServiceType, "voipPushServiceType");
        Intrinsics.f(pushProfileData, "pushProfileData");
        Context context = this.f36534a;
        VoipLogger voipLogger = this.f36535b;
        return new SinchCallClient(context, userId, applicationKey, "ocra-bolt.api.sinch.com", jwt, new VoipAudioManager(context, voipLogger), voipPushServiceType, pushProfileData, voipLogger);
    }
}
