package ee.mtakso.driver.ui.screens.safety_toolkit.utils;

import com.airbnb.lottie.LottieAnimationView;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyUIUtils.kt */
/* loaded from: classes3.dex */
public final class SafetyUIUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SafetyUIUtils f32878a = new SafetyUIUtils();

    private SafetyUIUtils() {
    }

    public final SafetyFABButtonType a(boolean z7, RecorderState recorderState) {
        Intrinsics.f(recorderState, "recorderState");
        if (z7) {
            return SafetyFABButtonType.ACTIVE_INCIDENT;
        }
        if (recorderState instanceof RecorderState.InProgress) {
            return SafetyFABButtonType.RECORDING_IN_PROGRESS;
        }
        if (recorderState instanceof RecorderState.Paused) {
            return SafetyFABButtonType.RECORDING_PAUSED;
        }
        return SafetyFABButtonType.DEFAULT_TOOLKIT;
    }

    public final void b(LottieAnimationView animationView, int i8) {
        Intrinsics.f(animationView, "animationView");
        if (i8 == 0) {
            animationView.setVisibility(i8);
            animationView.x();
            return;
        }
        if (animationView.s()) {
            animationView.l();
        }
        animationView.setVisibility(i8);
    }
}
