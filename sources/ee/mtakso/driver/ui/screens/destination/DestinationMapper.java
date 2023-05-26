package ee.mtakso.driver.ui.screens.destination;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DestinationMapper.kt */
/* loaded from: classes3.dex */
public final class DestinationMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f28171a = new Companion(null);

    /* compiled from: DestinationMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Text a(DriverDestination driverDestination) {
        boolean y7;
        Object Z;
        y7 = StringsKt__StringsJVMKt.y(driverDestination.a());
        if (y7) {
            return null;
        }
        if (Intrinsics.a(driverDestination.f(), "manual")) {
            boolean z7 = true;
            Z = CollectionsKt___CollectionsKt.Z(g(driverDestination.a()), 1);
            String str = (String) Z;
            if (str != null && str.length() != 0) {
                z7 = false;
            }
            if (z7) {
                return null;
            }
            return new Text.Value(str);
        }
        return new Text.Value(driverDestination.a());
    }

    private final Image b(DriverDestination driverDestination) {
        boolean y7;
        y7 = StringsKt__StringsJVMKt.y(driverDestination.a());
        if (y7) {
            return null;
        }
        String f8 = driverDestination.f();
        if (Intrinsics.a(f8, "home")) {
            return new Image.Res(R.drawable.ic_three_dot);
        }
        if (!Intrinsics.a(f8, "favorite")) {
            return null;
        }
        return new Image.Res(R.drawable.ic_three_dot);
    }

    private final Image c(DriverDestination driverDestination) {
        String f8 = driverDestination.f();
        if (Intrinsics.a(f8, "home")) {
            return new Image.Res(R.drawable.ic_home_fill_24dp);
        }
        if (Intrinsics.a(f8, "favorite")) {
            return new Image.Res(R.drawable.ic_star_filled);
        }
        return new Image.Res(R.drawable.ic_destinations_pin_below_filled);
    }

    private final Text d(DriverDestination driverDestination) {
        boolean y7;
        Object W;
        y7 = StringsKt__StringsJVMKt.y(driverDestination.a());
        if (y7) {
            String e8 = driverDestination.e();
            if (e8 == null) {
                e8 = "";
            }
            return new Text.Value(e8);
        }
        String f8 = driverDestination.f();
        if (Intrinsics.a(f8, "home")) {
            return new Text.Resource(R.string.destination_category_home, null, 2, null);
        }
        if (Intrinsics.a(f8, "favorite")) {
            return new Text.Resource(R.string.destination_category_favourite, null, 2, null);
        }
        W = CollectionsKt___CollectionsKt.W(g(driverDestination.a()));
        return new Text.Value((CharSequence) W);
    }

    private final boolean e(int i8, List<DriverDestination> list) {
        if (list.size() - 1 != i8) {
            return true;
        }
        return false;
    }

    private final List<String> g(String str) {
        List<String> C0;
        C0 = StringsKt__StringsKt.C0(str, new String[]{","}, false, 0, 6, null);
        return C0;
    }

    public final List<ListModel> f(List<DriverDestination> driverDestinations) {
        int v7;
        Intrinsics.f(driverDestinations, "driverDestinations");
        v7 = CollectionsKt__IterablesKt.v(driverDestinations, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : driverDestinations) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            DriverDestination driverDestination = (DriverDestination) obj;
            String valueOf = String.valueOf(driverDestination.b());
            Image c8 = c(driverDestination);
            arrayList.add(new TwoLinesItemDelegate.Model(valueOf, d(driverDestination), 2132018477, new Color.Attr(R.attr.contentPrimary), null, a(driverDestination), 2132018479, new Color.Attr(R.attr.contentSecondary), new Color.Attr(R.attr.dynamicNeutral04), c8, null, null, null, new Color.Attr(R.attr.contentPrimary), b(driverDestination), null, new Color.Attr(R.attr.backPrimary), null, driverDestination, false, 0, 0, e(i8, driverDestinations), new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 507157520, null));
            i8 = i9;
        }
        return arrayList;
    }
}
