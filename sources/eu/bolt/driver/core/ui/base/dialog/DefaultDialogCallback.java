package eu.bolt.driver.core.ui.base.dialog;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultDialogCallback.kt */
/* loaded from: classes5.dex */
public class DefaultDialogCallback implements DialogCallback {
    @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
    public void a(BaseDialogFragment dialog, View view, Object payload) {
        Intrinsics.f(dialog, "dialog");
        Intrinsics.f(view, "view");
        Intrinsics.f(payload, "payload");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
    public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
        Intrinsics.f(dialog, "dialog");
        Intrinsics.f(event, "event");
    }
}
