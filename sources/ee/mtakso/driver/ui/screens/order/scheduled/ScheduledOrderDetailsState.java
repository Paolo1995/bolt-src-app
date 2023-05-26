package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderDetailsState.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsState {

    /* renamed from: a  reason: collision with root package name */
    private final Text f31706a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ListModel> f31707b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledRideDetailsComponent.Button f31708c;

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduledOrderDetailsState(Text toolbarTitle, List<? extends ListModel> content, ScheduledRideDetailsComponent.Button button) {
        Intrinsics.f(toolbarTitle, "toolbarTitle");
        Intrinsics.f(content, "content");
        this.f31706a = toolbarTitle;
        this.f31707b = content;
        this.f31708c = button;
    }

    public final ScheduledRideDetailsComponent.Button a() {
        return this.f31708c;
    }

    public final List<ListModel> b() {
        return this.f31707b;
    }

    public final Text c() {
        return this.f31706a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScheduledOrderDetailsState) {
            ScheduledOrderDetailsState scheduledOrderDetailsState = (ScheduledOrderDetailsState) obj;
            return Intrinsics.a(this.f31706a, scheduledOrderDetailsState.f31706a) && Intrinsics.a(this.f31707b, scheduledOrderDetailsState.f31707b) && Intrinsics.a(this.f31708c, scheduledOrderDetailsState.f31708c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f31706a.hashCode() * 31) + this.f31707b.hashCode()) * 31;
        ScheduledRideDetailsComponent.Button button = this.f31708c;
        return hashCode + (button == null ? 0 : button.hashCode());
    }

    public String toString() {
        Text text = this.f31706a;
        List<ListModel> list = this.f31707b;
        ScheduledRideDetailsComponent.Button button = this.f31708c;
        return "ScheduledOrderDetailsState(toolbarTitle=" + text + ", content=" + list + ", action=" + button + ")";
    }
}
