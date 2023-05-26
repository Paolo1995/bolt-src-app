package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersState.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersState {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListModel> f31800a;

    /* renamed from: b  reason: collision with root package name */
    private final Filter f31801b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31802c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31803d;

    /* compiled from: ScheduledOrdersState.kt */
    /* loaded from: classes3.dex */
    public enum Filter {
        SCHEDULED(new Text.Resource(R.string.no_scheduled_requests, null, 2, null), new Text.Resource(R.string.no_scheduled_requests_description, null, 2, null)),
        ACCEPTED(new Text.Resource(R.string.no_accepted_rides, null, 2, null), new Text.Resource(R.string.accepted_requests_will_be_shown_here, null, 2, null));
        

        /* renamed from: f  reason: collision with root package name */
        private final Text f31807f;

        /* renamed from: g  reason: collision with root package name */
        private final Text f31808g;

        Filter(Text text, Text text2) {
            this.f31807f = text;
            this.f31808g = text2;
        }

        public final Text c() {
            return this.f31808g;
        }

        public final Text e() {
            return this.f31807f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduledOrdersState(List<? extends ListModel> models, Filter filter, boolean z7, int i8) {
        Intrinsics.f(models, "models");
        Intrinsics.f(filter, "filter");
        this.f31800a = models;
        this.f31801b = filter;
        this.f31802c = z7;
        this.f31803d = i8;
    }

    public final int a() {
        return this.f31803d;
    }

    public final Filter b() {
        return this.f31801b;
    }

    public final boolean c() {
        return this.f31802c;
    }

    public final List<ListModel> d() {
        return this.f31800a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScheduledOrdersState) {
            ScheduledOrdersState scheduledOrdersState = (ScheduledOrdersState) obj;
            return Intrinsics.a(this.f31800a, scheduledOrdersState.f31800a) && this.f31801b == scheduledOrdersState.f31801b && this.f31802c == scheduledOrdersState.f31802c && this.f31803d == scheduledOrdersState.f31803d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f31800a.hashCode() * 31) + this.f31801b.hashCode()) * 31;
        boolean z7 = this.f31802c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((hashCode + i8) * 31) + this.f31803d;
    }

    public String toString() {
        List<ListModel> list = this.f31800a;
        Filter filter = this.f31801b;
        boolean z7 = this.f31802c;
        int i8 = this.f31803d;
        return "ScheduledOrdersState(models=" + list + ", filter=" + filter + ", loaded=" + z7 + ", acceptedNumber=" + i8 + ")";
    }
}
