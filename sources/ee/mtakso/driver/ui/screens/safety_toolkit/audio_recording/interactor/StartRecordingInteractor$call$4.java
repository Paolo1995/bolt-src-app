package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor;

import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartRecordingInteractor.kt */
/* loaded from: classes3.dex */
public final class StartRecordingInteractor$call$4 extends Lambda implements Function1<OrderHandleWithCryptoKey, CompletableSource> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ StartRecordingInteractor f32588f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartRecordingInteractor$call$4(StartRecordingInteractor startRecordingInteractor) {
        super(1);
        this.f32588f = startRecordingInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(StartRecordingInteractor this$0, OrderHandleWithCryptoKey it) {
        AudioRecordingManager audioRecordingManager;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "$it");
        audioRecordingManager = this$0.f32583c;
        audioRecordingManager.h(it.b(), it.a());
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final CompletableSource invoke(final OrderHandleWithCryptoKey it) {
        Intrinsics.f(it, "it");
        final StartRecordingInteractor startRecordingInteractor = this.f32588f;
        return Completable.u(new Action() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                StartRecordingInteractor$call$4.d(StartRecordingInteractor.this, it);
            }
        });
    }
}
