package ee.mtakso.driver.ui.screens.destination;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationScreenState.kt */
/* loaded from: classes3.dex */
public final class DestinationScreenState {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListModel> f28173a;

    /* renamed from: b  reason: collision with root package name */
    private final ListModel f28174b;

    /* JADX WARN: Multi-variable type inference failed */
    public DestinationScreenState(List<? extends ListModel> destinations, ListModel spacer) {
        Intrinsics.f(destinations, "destinations");
        Intrinsics.f(spacer, "spacer");
        this.f28173a = destinations;
        this.f28174b = spacer;
    }

    public final List<ListModel> a() {
        return this.f28173a;
    }

    public final ListModel b() {
        return this.f28174b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DestinationScreenState) {
            DestinationScreenState destinationScreenState = (DestinationScreenState) obj;
            return Intrinsics.a(this.f28173a, destinationScreenState.f28173a) && Intrinsics.a(this.f28174b, destinationScreenState.f28174b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f28173a.hashCode() * 31) + this.f28174b.hashCode();
    }

    public String toString() {
        List<ListModel> list = this.f28173a;
        ListModel listModel = this.f28174b;
        return "DestinationScreenState(destinations=" + list + ", spacer=" + listModel + ")";
    }

    public /* synthetic */ DestinationScreenState(List list, ListModel listModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i8 & 2) != 0 ? new DividerDelegate.Model("0", Dimens.c(16), 0, null, null, 0, 0, 124, null) : listModel);
    }
}
