package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import eu.bolt.driver.core.ui.routing.RoutingManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ContactOptionsFragment_MembersInjector implements MembersInjector<ContactOptionsFragment> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment.features")
    public static void a(ContactOptionsFragment contactOptionsFragment, Features features) {
        contactOptionsFragment.f27773w = features;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment.routingManager")
    public static void b(ContactOptionsFragment contactOptionsFragment, RoutingManager routingManager) {
        contactOptionsFragment.f27774x = routingManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment.voipPermissionDialogFactory")
    public static void c(ContactOptionsFragment contactOptionsFragment, VoipPermissionDialogFactory voipPermissionDialogFactory) {
        contactOptionsFragment.f27772v = voipPermissionDialogFactory;
    }
}
