package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MicrophonePermissionDialogProvider.kt */
/* loaded from: classes3.dex */
public final class MicrophonePermissionDialogProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f32599a;

    @Inject
    public MicrophonePermissionDialogProvider(Context context) {
        Intrinsics.f(context, "context");
        this.f32599a = context;
    }

    public final ConfirmationWithIconDialog a(DialogCallback confirmPermissionDialogCallback) {
        ConfirmationWithIconDialog a8;
        Intrinsics.f(confirmPermissionDialogCallback, "confirmPermissionDialogCallback");
        ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
        String string = this.f32599a.getString(R.string.audio_recording_permission_record_audio_dialog_title);
        Intrinsics.e(string, "context.getString(R.stri…ecord_audio_dialog_title)");
        String string2 = this.f32599a.getString(R.string.audio_recording_permission_record_audio_dialog_subtitle);
        Intrinsics.e(string2, "context.getString(R.stri…rd_audio_dialog_subtitle)");
        String string3 = this.f32599a.getString(R.string.action_go_to_settings);
        Intrinsics.e(string3, "context.getString(R.string.action_go_to_settings)");
        String string4 = this.f32599a.getString(R.string.action_cancel);
        Intrinsics.e(string4, "context.getString(R.string.action_cancel)");
        a8 = companion.a(R.drawable.ic_audio_recording_mic_72, string, string2, string3, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : null, string4, confirmPermissionDialogCallback, (r20 & 128) != 0 ? null : null);
        return a8;
    }
}
