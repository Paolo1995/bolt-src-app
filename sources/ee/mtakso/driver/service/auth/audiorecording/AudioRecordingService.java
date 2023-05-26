package ee.mtakso.driver.service.auth.audiorecording;

import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import ee.mtakso.driver.utils.coroutines.ScopeProvider;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: AudioRecordingService.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f23751a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioRecordingManager f23752b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineScope f23753c;

    @Inject
    public AudioRecordingService(ScopeProvider scopeProvider, DispatcherProvider dispatcherProvider, OrderProvider orderProvider, AudioRecordingManager audioRecordingManager) {
        Intrinsics.f(scopeProvider, "scopeProvider");
        Intrinsics.f(dispatcherProvider, "dispatcherProvider");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        this.f23751a = orderProvider;
        this.f23752b = audioRecordingManager;
        this.f23753c = scopeProvider.a(dispatcherProvider.a());
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        BuildersKt__Builders_commonKt.d(this.f23753c, null, null, new AudioRecordingService$start$1(this, null), 3, null);
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        CoroutineScopeKt.d(this.f23753c, null, 1, null);
    }
}
