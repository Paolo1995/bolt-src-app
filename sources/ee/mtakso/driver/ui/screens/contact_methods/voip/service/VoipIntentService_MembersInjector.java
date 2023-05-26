package ee.mtakso.driver.ui.screens.contact_methods.voip.service;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.service.voip.VoipService;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipIntentService_MembersInjector implements MembersInjector<VoipIntentService> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.service.VoipIntentService.voipService")
    public static void a(VoipIntentService voipIntentService, VoipService voipService) {
        voipIntentService.f28107f = voipService;
    }
}
