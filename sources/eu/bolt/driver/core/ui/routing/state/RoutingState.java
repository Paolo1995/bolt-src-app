package eu.bolt.driver.core.ui.routing.state;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoutingState.kt */
/* loaded from: classes5.dex */
public final class RoutingState {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Activity> f41173a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Class<? extends Fragment>> f41174b;

    /* JADX WARN: Multi-variable type inference failed */
    public RoutingState(Class<? extends Activity> root, List<? extends Class<? extends Fragment>> fragments) {
        Intrinsics.f(root, "root");
        Intrinsics.f(fragments, "fragments");
        this.f41173a = root;
        this.f41174b = fragments;
    }

    public final Class<? extends Activity> a() {
        return this.f41173a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoutingState) {
            RoutingState routingState = (RoutingState) obj;
            return Intrinsics.a(this.f41173a, routingState.f41173a) && Intrinsics.a(this.f41174b, routingState.f41174b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f41173a.hashCode() * 31) + this.f41174b.hashCode();
    }

    public String toString() {
        Class<? extends Activity> cls = this.f41173a;
        List<Class<? extends Fragment>> list = this.f41174b;
        return "RoutingState(root=" + cls + ", fragments=" + list + ")";
    }

    public /* synthetic */ RoutingState(Class cls, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i8 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
