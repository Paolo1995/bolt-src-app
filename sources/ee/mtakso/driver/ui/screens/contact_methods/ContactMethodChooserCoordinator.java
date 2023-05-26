package ee.mtakso.driver.ui.screens.contact_methods;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseActivity;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.CancelTarget;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsConfig;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment;
import eu.bolt.driver.chat.ui.routing.ContactOptionsFromChatCommand;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.OrderHandleUi;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactMethodChooserCoordinator.kt */
/* loaded from: classes3.dex */
public final class ContactMethodChooserCoordinator extends DefaultActivityLifecycleCallback implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private Activity f27749f;

    private final OrderHandle c(OrderHandleUi orderHandleUi) {
        if (orderHandleUi == null) {
            return null;
        }
        return new OrderHandle(orderHandleUi.c(), orderHandleUi.a(), orderHandleUi.b());
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof ContactOptionsFromChatCommand)) {
            return false;
        }
        Activity activity = this.f27749f;
        if (activity != null) {
            ContactOptionsConfig contactOptionsConfig = new ContactOptionsConfig(true, CancelTarget.CHAT, null, c(((ContactOptionsFromChatCommand) command).c()), 4, null);
            ContactMethodsBaseActivity.Companion companion = ContactMethodsBaseActivity.f27750n;
            Bundle a8 = ContactOptionsFragment.F.a(contactOptionsConfig);
            Intent intent = new Intent(activity, ContactMethodsBaseActivity.class);
            intent.putExtra("dialog_class_argument", ContactOptionsFragment.class);
            if (a8 != null) {
                intent.putExtra("dialog_extra_params", a8);
            }
            intent.addFlags(268500992);
            activity.startActivity(intent);
            return true;
        }
        Kalev.e(new IllegalStateException("There are no activity to execute command"), "There are no activity to execute command");
        return false;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f27749f = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        this.f27749f = activity;
    }
}
