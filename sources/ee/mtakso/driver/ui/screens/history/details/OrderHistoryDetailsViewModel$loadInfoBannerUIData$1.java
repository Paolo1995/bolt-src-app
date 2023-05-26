package ee.mtakso.driver.ui.screens.history.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.TripAudioRecordingData;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderHistoryDetailsViewModel.kt */
@DebugMetadata(c = "ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadInfoBannerUIData$1", f = "OrderHistoryDetailsViewModel.kt", l = {154, 176}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsViewModel$loadInfoBannerUIData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f29487g;

    /* renamed from: h  reason: collision with root package name */
    int f29488h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderHistoryDetailsViewModel f29489i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ OrderHandle f29490j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ TripAudioRecordingData f29491k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderHistoryDetailsViewModel$loadInfoBannerUIData$1(OrderHistoryDetailsViewModel orderHistoryDetailsViewModel, OrderHandle orderHandle, TripAudioRecordingData tripAudioRecordingData, Continuation<? super OrderHistoryDetailsViewModel$loadInfoBannerUIData$1> continuation) {
        super(2, continuation);
        this.f29489i = orderHistoryDetailsViewModel;
        this.f29490j = orderHandle;
        this.f29491k = tripAudioRecordingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrderHistoryDetailsViewModel$loadInfoBannerUIData$1(this.f29489i, this.f29490j, this.f29491k, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrderHistoryDetailsViewModel$loadInfoBannerUIData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
        r6 = r10.f29489i.i0(r6.longValue());
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadInfoBannerUIData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
