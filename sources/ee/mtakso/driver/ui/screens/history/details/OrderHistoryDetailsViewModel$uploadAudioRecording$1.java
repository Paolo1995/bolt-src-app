package ee.mtakso.driver.ui.screens.history.details;

import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderHistoryDetailsViewModel.kt */
@DebugMetadata(c = "ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$uploadAudioRecording$1", f = "OrderHistoryDetailsViewModel.kt", l = {280}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsViewModel$uploadAudioRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f29504g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ OrderHistoryDetailsViewModel f29505h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderHandle f29506i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderHistoryDetailsViewModel$uploadAudioRecording$1(OrderHistoryDetailsViewModel orderHistoryDetailsViewModel, OrderHandle orderHandle, Continuation<? super OrderHistoryDetailsViewModel$uploadAudioRecording$1> continuation) {
        super(2, continuation);
        this.f29505h = orderHistoryDetailsViewModel;
        this.f29506i = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrderHistoryDetailsViewModel$uploadAudioRecording$1(this.f29505h, this.f29506i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrderHistoryDetailsViewModel$uploadAudioRecording$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        MutableLiveData mutableLiveData;
        UploadAudioRecordingManager uploadAudioRecordingManager;
        Object g8;
        MutableLiveData mutableLiveData2;
        LiveEvent liveEvent;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f29504g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
                g8 = ((Result) obj).j();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            mutableLiveData = this.f29505h.D;
            mutableLiveData.o(Boxing.a(true));
            uploadAudioRecordingManager = this.f29505h.f29471p;
            OrderHandle orderHandle = this.f29506i;
            this.f29504g = 1;
            g8 = uploadAudioRecordingManager.g(orderHandle, this);
            if (g8 == d8) {
                return d8;
            }
        }
        mutableLiveData2 = this.f29505h.D;
        mutableLiveData2.o(Boxing.a(false));
        liveEvent = this.f29505h.G;
        liveEvent.o(Result.a(g8));
        return Unit.f50853a;
    }
}
