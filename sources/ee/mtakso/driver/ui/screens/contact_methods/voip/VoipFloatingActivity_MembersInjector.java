package ee.mtakso.driver.ui.screens.contact_methods.voip;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipFloatingActivity_MembersInjector implements MembersInjector<VoipFloatingActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity.appThemeManager")
    public static void a(VoipFloatingActivity voipFloatingActivity, AppThemeManager appThemeManager) {
        voipFloatingActivity.f27823n = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity.voipActiveWindowManager")
    public static void b(VoipFloatingActivity voipFloatingActivity, VoipActiveWindowTracker voipActiveWindowTracker) {
        voipFloatingActivity.f27819j = voipActiveWindowTracker;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity.voipNotificationDrawer")
    public static void c(VoipFloatingActivity voipFloatingActivity, VoipNotificationDrawer voipNotificationDrawer) {
        voipFloatingActivity.f27820k = voipNotificationDrawer;
    }
}
