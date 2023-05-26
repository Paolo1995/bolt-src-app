package ee.mtakso.driver.onboarding.steps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.routing.command.PermissionCommand;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordAudioPermissionStep.kt */
/* loaded from: classes3.dex */
public final class RecordAudioPermissionStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final Context f23063g;

    /* renamed from: h  reason: collision with root package name */
    private final Features f23064h;

    /* renamed from: i  reason: collision with root package name */
    private final PermissionManager f23065i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RecordAudioPermissionStep(Context context, Features features, PermissionManager permissionManager) {
        super(OnBoardingStep.Type.PERMISSION_RECORD_AUDIO, null, R.string.onboarding_permission_record_audio_title, R.string.onboarding_permission_record_audio_description, null, null, 50, null);
        Intrinsics.f(context, "context");
        Intrinsics.f(features, "features");
        Intrinsics.f(permissionManager, "permissionManager");
        this.f23063g = context;
        this.f23064h = features;
        this.f23065i = permissionManager;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        if (this.f23065i.o("android.permission.RECORD_AUDIO").a() == PermissionManager.DenyInitiator.AUTOMATIC_DENY) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f23063g.getPackageName(), null));
            return new IntentFragmentNavigationCommand(intent, Integer.valueOf(i8), null, 4, null);
        }
        return new PermissionCommand("android.permission.RECORD_AUDIO", i8);
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        if (Build.VERSION.SDK_INT < 23 || this.f23065i.o("android.permission.RECORD_AUDIO").d() == PermissionManager.PermissionStatus.GRANTED) {
            return false;
        }
        return true;
    }
}
