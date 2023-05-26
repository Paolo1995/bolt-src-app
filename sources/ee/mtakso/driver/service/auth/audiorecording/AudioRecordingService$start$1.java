package ee.mtakso.driver.service.auth.audiorecording;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import eu.bolt.kalev.Kalev;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.rx2.RxConvertKt;

/* compiled from: AudioRecordingService.kt */
@DebugMetadata(c = "ee.mtakso.driver.service.auth.audiorecording.AudioRecordingService$start$1", f = "AudioRecordingService.kt", l = {29, 38}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class AudioRecordingService$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f23754g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AudioRecordingService f23755h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingService$start$1(AudioRecordingService audioRecordingService, Continuation<? super AudioRecordingService$start$1> continuation) {
        super(2, continuation);
        this.f23755h = audioRecordingService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRecordingService$start$1(this.f23755h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioRecordingService$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AudioRecordingManager audioRecordingManager;
        OrderProvider orderProvider;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f23754g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            audioRecordingManager = this.f23755h.f23752b;
            this.f23754g = 1;
            if (audioRecordingManager.e(this) == d8) {
                return d8;
            }
        }
        orderProvider = this.f23755h.f23751a;
        Flow b8 = RxConvertKt.b(OrderProviderUtils.n(orderProvider, OrderState.ORDER_STATE_CLIENT_CANCELLED, OrderState.ORDER_STATE_DRIVER_REJECTED, OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW, OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED, OrderState.ORDER_STATE_FINISHED));
        final AudioRecordingService audioRecordingService = this.f23755h;
        FlowCollector flowCollector = new FlowCollector() { // from class: ee.mtakso.driver.service.auth.audiorecording.AudioRecordingService$start$1.1
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a */
            public final Object b(OrderDetails orderDetails, Continuation<? super Unit> continuation) {
                AudioRecordingManager audioRecordingManager2;
                Object d9;
                Kalev.b("Stop Recording called");
                audioRecordingManager2 = AudioRecordingService.this.f23752b;
                Object i9 = audioRecordingManager2.i(orderDetails.a(), continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (i9 == d9) {
                    return i9;
                }
                return Unit.f50853a;
            }
        };
        this.f23754g = 2;
        if (b8.a(flowCollector, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
