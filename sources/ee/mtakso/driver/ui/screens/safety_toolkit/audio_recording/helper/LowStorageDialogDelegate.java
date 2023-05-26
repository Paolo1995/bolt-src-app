package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationDialog;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LowStorageDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class LowStorageDialogDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f32574c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f32575a;

    /* renamed from: b  reason: collision with root package name */
    private final DialogCallback f32576b;

    /* compiled from: LowStorageDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LowStorageDialogDelegate(Context context) {
        Intrinsics.f(context, "context");
        this.f32575a = context;
        this.f32576b = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate$lowStorageDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Context context2;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "ITEM_CONFIRM_TAG")) {
                    context2 = LowStorageDialogDelegate.this.f32575a;
                    dialog.requireContext().startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", context2.getPackageName(), null)));
                }
            }
        };
    }

    public final void b(FragmentActivity fragment) {
        Intrinsics.f(fragment, "fragment");
        ConfirmationDialog.Companion companion = ConfirmationDialog.f41075m;
        String string = this.f32575a.getString(R.string.not_enough_storage_space_title);
        Intrinsics.e(string, "context.getString(R.stri…ough_storage_space_title)");
        String string2 = this.f32575a.getString(R.string.not_enough_storage_space_description);
        Intrinsics.e(string2, "context.getString(R.stri…torage_space_description)");
        String string3 = this.f32575a.getString(R.string.go_to_settings);
        Intrinsics.e(string3, "context.getString(R.string.go_to_settings)");
        String string4 = this.f32575a.getString(R.string.close);
        Intrinsics.e(string4, "context.getString(R.string.close)");
        FragmentUtils.c(ConfirmationDialog.Companion.b(companion, string, string2, string3, null, string4, this.f32576b, null, 72, null), fragment, "lowStorageDialog");
    }

    public final void c(FragmentActivity fragment) {
        Intrinsics.f(fragment, "fragment");
        ConfirmationDialog.Companion companion = ConfirmationDialog.f41075m;
        String string = this.f32575a.getString(R.string.storage_space_running_low_title);
        Intrinsics.e(string, "context.getString(R.stri…_space_running_low_title)");
        String string2 = this.f32575a.getString(R.string.storage_space_running_low_description);
        Intrinsics.e(string2, "context.getString(R.stri…_running_low_description)");
        String string3 = this.f32575a.getString(R.string.go_to_settings);
        Intrinsics.e(string3, "context.getString(R.string.go_to_settings)");
        String string4 = this.f32575a.getString(R.string.close);
        Intrinsics.e(string4, "context.getString(R.string.close)");
        FragmentUtils.c(ConfirmationDialog.Companion.b(companion, string, string2, string3, null, string4, this.f32576b, null, 72, null), fragment, "lowStorageDialog");
    }

    public final void d(FragmentManager fragmentManager) {
        Intrinsics.f(fragmentManager, "fragmentManager");
        BaseDialogFragment.f41026i.a(fragmentManager, "lowStorageDialog", this.f32576b);
    }
}
