package ee.mtakso.driver.ui.interactor;

import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkTimeInteractor.kt */
/* loaded from: classes3.dex */
public final class WorkTimeInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final WorkingTimeManager f26412a;

    @Inject
    public WorkTimeInteractor(WorkingTimeManager workingTimeManager) {
        Intrinsics.f(workingTimeManager, "workingTimeManager");
        this.f26412a = workingTimeManager;
    }

    public final Observable<WorkingTimeInfo> a() {
        return this.f26412a.f();
    }
}
