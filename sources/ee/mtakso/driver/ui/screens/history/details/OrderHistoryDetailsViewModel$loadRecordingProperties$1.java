package ee.mtakso.driver.ui.screens.history.details;

import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import eu.bolt.android.audio_recording_engine.engine.OrderData;
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
@DebugMetadata(c = "ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadRecordingProperties$1", f = "OrderHistoryDetailsViewModel.kt", l = {304}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsViewModel$loadRecordingProperties$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f29494g;

    /* renamed from: h  reason: collision with root package name */
    int f29495h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderHistoryDetailsViewModel f29496i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ OrderHandle f29497j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderHistoryDetailsViewModel$loadRecordingProperties$1(OrderHistoryDetailsViewModel orderHistoryDetailsViewModel, OrderHandle orderHandle, Continuation<? super OrderHistoryDetailsViewModel$loadRecordingProperties$1> continuation) {
        super(2, continuation);
        this.f29496i = orderHistoryDetailsViewModel;
        this.f29497j = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrderHistoryDetailsViewModel$loadRecordingProperties$1(this.f29496i, this.f29497j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrderHistoryDetailsViewModel$loadRecordingProperties$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        MutableLiveData mutableLiveData;
        AudioRecordingManager audioRecordingManager;
        AudioRecordingMapper audioRecordingMapper;
        MutableLiveData mutableLiveData2;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f29495h;
        if (i8 != 0) {
            if (i8 == 1) {
                mutableLiveData2 = (MutableLiveData) this.f29494g;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            mutableLiveData = this.f29496i.E;
            audioRecordingManager = this.f29496i.f29461f;
            audioRecordingMapper = this.f29496i.f29462g;
            OrderData b8 = audioRecordingMapper.b(this.f29497j);
            this.f29494g = mutableLiveData;
            this.f29495h = 1;
            Object c8 = audioRecordingManager.c(b8, this);
            if (c8 == d8) {
                return d8;
            }
            mutableLiveData2 = mutableLiveData;
            obj = c8;
        }
        mutableLiveData2.o(obj);
        return Unit.f50853a;
    }
}
