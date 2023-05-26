package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.order.FifoQueueDispatchAreaState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueMap.kt */
/* loaded from: classes3.dex */
public final class FifoQueueMap {

    /* renamed from: a  reason: collision with root package name */
    private final TileCollectionConfig f26474a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26475b;

    /* renamed from: c  reason: collision with root package name */
    private final FifoQueueDispatchAreaState f26476c;

    public FifoQueueMap(TileCollectionConfig tileCollectionConfig, String str, FifoQueueDispatchAreaState fifoQueueDispatchAreaState) {
        this.f26474a = tileCollectionConfig;
        this.f26475b = str;
        this.f26476c = fifoQueueDispatchAreaState;
    }

    public final TileCollectionConfig a() {
        return this.f26474a;
    }

    public final String b() {
        return this.f26475b;
    }

    public final FifoQueueDispatchAreaState c() {
        return this.f26476c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FifoQueueMap) {
            FifoQueueMap fifoQueueMap = (FifoQueueMap) obj;
            return Intrinsics.a(this.f26474a, fifoQueueMap.f26474a) && Intrinsics.a(this.f26475b, fifoQueueMap.f26475b) && this.f26476c == fifoQueueMap.f26476c;
        }
        return false;
    }

    public int hashCode() {
        TileCollectionConfig tileCollectionConfig = this.f26474a;
        int hashCode = (tileCollectionConfig == null ? 0 : tileCollectionConfig.hashCode()) * 31;
        String str = this.f26475b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        FifoQueueDispatchAreaState fifoQueueDispatchAreaState = this.f26476c;
        return hashCode2 + (fifoQueueDispatchAreaState != null ? fifoQueueDispatchAreaState.hashCode() : 0);
    }

    public String toString() {
        TileCollectionConfig tileCollectionConfig = this.f26474a;
        String str = this.f26475b;
        FifoQueueDispatchAreaState fifoQueueDispatchAreaState = this.f26476c;
        return "FifoQueueMap(config=" + tileCollectionConfig + ", dispatchAreaId=" + str + ", dispatchAreaState=" + fifoQueueDispatchAreaState + ")";
    }
}
