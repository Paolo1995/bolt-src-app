package ee.mtakso.driver.ui.screens.contact_methods.voip.callback;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CallBackFragment_MembersInjector implements MembersInjector<CallBackFragment> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment.voipPermissionDialogFactory")
    public static void a(CallBackFragment callBackFragment, VoipPermissionDialogFactory voipPermissionDialogFactory) {
        callBackFragment.f27825v = voipPermissionDialogFactory;
    }
}
