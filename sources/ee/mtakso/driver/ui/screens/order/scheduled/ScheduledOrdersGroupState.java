package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersGroupState.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupState {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledOrdersGroupInfo f31787a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ListModel> f31788b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31789c;

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduledOrdersGroupState(ScheduledOrdersGroupInfo scheduledOrdersGroupInfo, List<? extends ListModel> models, int i8) {
        Intrinsics.f(models, "models");
        this.f31787a = scheduledOrdersGroupInfo;
        this.f31788b = models;
        this.f31789c = i8;
    }

    public final ScheduledOrdersGroupInfo a() {
        return this.f31787a;
    }

    public final List<ListModel> b() {
        return this.f31788b;
    }

    public final int c() {
        return this.f31789c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScheduledOrdersGroupState) {
            ScheduledOrdersGroupState scheduledOrdersGroupState = (ScheduledOrdersGroupState) obj;
            return Intrinsics.a(this.f31787a, scheduledOrdersGroupState.f31787a) && Intrinsics.a(this.f31788b, scheduledOrdersGroupState.f31788b) && this.f31789c == scheduledOrdersGroupState.f31789c;
        }
        return false;
    }

    public int hashCode() {
        ScheduledOrdersGroupInfo scheduledOrdersGroupInfo = this.f31787a;
        return ((((scheduledOrdersGroupInfo == null ? 0 : scheduledOrdersGroupInfo.hashCode()) * 31) + this.f31788b.hashCode()) * 31) + this.f31789c;
    }

    public String toString() {
        ScheduledOrdersGroupInfo scheduledOrdersGroupInfo = this.f31787a;
        List<ListModel> list = this.f31788b;
        int i8 = this.f31789c;
        return "ScheduledOrdersGroupState(groupInfo=" + scheduledOrdersGroupInfo + ", models=" + list + ", scrollToPosition=" + i8 + ")";
    }
}
