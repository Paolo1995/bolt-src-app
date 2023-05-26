package ee.mtakso.driver.ui.screens.contact_methods.voip.incoming;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import ee.mtakso.driver.utils.effects.EffectsFactory;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingCallFragment_MembersInjector implements MembersInjector<IncomingCallFragment> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment.effectsFactory")
    public static void a(IncomingCallFragment incomingCallFragment, EffectsFactory effectsFactory) {
        incomingCallFragment.f27988w = effectsFactory;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment.permissionsDialogFactory")
    public static void b(IncomingCallFragment incomingCallFragment, VoipPermissionDialogFactory voipPermissionDialogFactory) {
        incomingCallFragment.f27987v = voipPermissionDialogFactory;
    }
}
