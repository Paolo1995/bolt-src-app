package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.order.FifoQueueDispatchAreaState;
import ee.mtakso.driver.network.client.order.FifoQueueStateForDriverResponse;
import ee.mtakso.driver.service.modules.fifo.FifoQueueDetails;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.map.MapsConfigs;
import ee.mtakso.driver.service.modules.map.MapsConfigsService;
import ee.mtakso.driver.service.modules.map.MapsConfigsTileCollectionsExt;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueMapInteractor.kt */
/* loaded from: classes3.dex */
public final class FifoQueueMapInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final MapsConfigsService f26477a;

    /* renamed from: b  reason: collision with root package name */
    private final FifoQueueManager f26478b;

    @Inject
    public FifoQueueMapInteractor(MapsConfigsService mapsConfigsService, FifoQueueManager fifoQueueManager) {
        Intrinsics.f(mapsConfigsService, "mapsConfigsService");
        Intrinsics.f(fifoQueueManager, "fifoQueueManager");
        this.f26477a = mapsConfigsService;
        this.f26478b = fifoQueueManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueMap c(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoQueueMap) tmp0.s(obj, obj2);
    }

    public final Observable<FifoQueueMap> b() {
        Observable<MapsConfigs> c8 = this.f26477a.c();
        Observable<FifoQueueDetails> p8 = this.f26478b.p();
        final FifoQueueMapInteractor$observeFifoQueueMap$1 fifoQueueMapInteractor$observeFifoQueueMap$1 = new Function2<MapsConfigs, FifoQueueDetails, FifoQueueMap>() { // from class: ee.mtakso.driver.ui.interactor.driver.FifoQueueMapInteractor$observeFifoQueueMap$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final FifoQueueMap s(MapsConfigs mapsConfigs, FifoQueueDetails fifoDetails) {
                FifoQueueDetails.InQueue inQueue;
                String str;
                FifoQueueDetails.InQueue inQueue2;
                FifoQueueStateForDriverResponse a8;
                FifoQueueStateForDriverResponse a9;
                Intrinsics.f(mapsConfigs, "mapsConfigs");
                Intrinsics.f(fifoDetails, "fifoDetails");
                TileCollectionConfig a10 = MapsConfigsTileCollectionsExt.f24862a.a(mapsConfigs.a().b());
                boolean z7 = fifoDetails instanceof FifoQueueDetails.InQueue;
                FifoQueueDispatchAreaState fifoQueueDispatchAreaState = null;
                if (z7) {
                    inQueue = (FifoQueueDetails.InQueue) fifoDetails;
                } else {
                    inQueue = null;
                }
                if (inQueue != null && (a9 = inQueue.a()) != null) {
                    str = a9.a();
                } else {
                    str = null;
                }
                if (z7) {
                    inQueue2 = (FifoQueueDetails.InQueue) fifoDetails;
                } else {
                    inQueue2 = null;
                }
                if (inQueue2 != null && (a8 = inQueue2.a()) != null) {
                    fifoQueueDispatchAreaState = a8.b();
                }
                return new FifoQueueMap(a10, str, fifoQueueDispatchAreaState);
            }
        };
        Observable<FifoQueueMap> combineLatest = Observable.combineLatest(c8, p8, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.driver.e
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                FifoQueueMap c9;
                c9 = FifoQueueMapInteractor.c(Function2.this, obj, obj2);
                return c9;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         …          )\n            }");
        return combineLatest;
    }
}
