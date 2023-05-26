package ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help;

import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DidYouGetHelpInteractor.kt */
/* loaded from: classes3.dex */
public final class DidYouGetHelpInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final EmergencyAssistManager f32622a;

    @Inject
    public DidYouGetHelpInteractor(EmergencyAssistManager emergencyAssistManager) {
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        this.f32622a = emergencyAssistManager;
    }

    public final PublishSubject<DidYouGetHelpType> a() {
        return this.f32622a.x();
    }
}
