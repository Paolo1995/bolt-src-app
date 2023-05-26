package ee.mtakso.driver.ui.screens.history.details;

import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import eu.bolt.android.audio_recording_engine.engine.OrderData;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderHistoryDetailsViewModel.kt */
@DebugMetadata(c = "ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadUploadParams$1", f = "OrderHistoryDetailsViewModel.kt", l = {271}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsViewModel$loadUploadParams$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f29498g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ OrderHistoryDetailsViewModel f29499h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderHandle f29500i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderHistoryDetailsViewModel$loadUploadParams$1(OrderHistoryDetailsViewModel orderHistoryDetailsViewModel, OrderHandle orderHandle, Continuation<? super OrderHistoryDetailsViewModel$loadUploadParams$1> continuation) {
        super(2, continuation);
        this.f29499h = orderHistoryDetailsViewModel;
        this.f29500i = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrderHistoryDetailsViewModel$loadUploadParams$1(this.f29499h, this.f29500i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrderHistoryDetailsViewModel$loadUploadParams$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AudioRecordingManager audioRecordingManager;
        AudioRecordingMapper audioRecordingMapper;
        MutableLiveData mutableLiveData;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f29498g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            audioRecordingManager = this.f29499h.f29461f;
            audioRecordingMapper = this.f29499h.f29462g;
            OrderData b8 = audioRecordingMapper.b(this.f29500i);
            this.f29498g = 1;
            obj = audioRecordingManager.d(b8, this);
            if (obj == d8) {
                return d8;
            }
        }
        mutableLiveData = this.f29499h.F;
        mutableLiveData.o((List) obj);
        return Unit.f50853a;
    }
}
