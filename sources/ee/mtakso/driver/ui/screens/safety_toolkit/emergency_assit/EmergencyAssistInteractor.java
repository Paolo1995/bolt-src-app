package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistInteractor.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final EmergencyAssistManager f32718a;

    @Inject
    public EmergencyAssistInteractor(EmergencyAssistManager emergencyAssistManager) {
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        this.f32718a = emergencyAssistManager;
    }

    public final BehaviorSubject<Boolean> a() {
        return this.f32718a.y();
    }
}
