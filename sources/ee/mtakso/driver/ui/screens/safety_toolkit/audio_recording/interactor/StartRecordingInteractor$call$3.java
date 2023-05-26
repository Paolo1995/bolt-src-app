package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient;
import ee.mtakso.driver.network.client.audio_recording.GetCryptoKeyResponse;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import eu.bolt.driver.core.util.Optional;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartRecordingInteractor.kt */
/* loaded from: classes3.dex */
public final class StartRecordingInteractor$call$3 extends Lambda implements Function1<Optional<ActiveOrderDetails>, SingleSource<? extends OrderHandleWithCryptoKey>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ StartRecordingInteractor f32586f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartRecordingInteractor$call$3(StartRecordingInteractor startRecordingInteractor) {
        super(1);
        this.f32586f = startRecordingInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderHandleWithCryptoKey d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderHandleWithCryptoKey) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final SingleSource<? extends OrderHandleWithCryptoKey> invoke(Optional<ActiveOrderDetails> it) {
        AudioRecordingClient audioRecordingClient;
        Intrinsics.f(it, "it");
        final OrderHandle a8 = it.a().a();
        audioRecordingClient = this.f32586f.f32582b;
        Single<GetCryptoKeyResponse> b8 = audioRecordingClient.b(a8);
        final Function1<GetCryptoKeyResponse, OrderHandleWithCryptoKey> function1 = new Function1<GetCryptoKeyResponse, OrderHandleWithCryptoKey>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor$call$3.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderHandleWithCryptoKey invoke(GetCryptoKeyResponse getCryptoKeyResponse) {
                Intrinsics.f(getCryptoKeyResponse, "getCryptoKeyResponse");
                return new OrderHandleWithCryptoKey(OrderHandle.this, getCryptoKeyResponse.a());
            }
        };
        return b8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderHandleWithCryptoKey d8;
                d8 = StartRecordingInteractor$call$3.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
