package ee.mtakso.driver.ui.screens.order.lookup.orderdestination;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDestinationState.kt */
/* loaded from: classes3.dex */
public final class OrderDestinationState {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListModel> f31481a;

    /* JADX WARN: Multi-variable type inference failed */
    public OrderDestinationState(List<? extends ListModel> searchSuggestions) {
        Intrinsics.f(searchSuggestions, "searchSuggestions");
        this.f31481a = searchSuggestions;
    }

    public final List<ListModel> a() {
        return this.f31481a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderDestinationState) && Intrinsics.a(this.f31481a, ((OrderDestinationState) obj).f31481a);
    }

    public int hashCode() {
        return this.f31481a.hashCode();
    }

    public String toString() {
        List<ListModel> list = this.f31481a;
        return "OrderDestinationState(searchSuggestions=" + list + ")";
    }
}
