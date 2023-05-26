package ee.mtakso.driver.ui.screens.destination.search;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchSuggestionMapper.kt */
/* loaded from: classes3.dex */
public final class SearchSuggestionMapper {
    private final boolean a(int i8, ExternalSourceAddresses externalSourceAddresses) {
        if (externalSourceAddresses.a().size() - 1 != i8) {
            return true;
        }
        return false;
    }

    public final List<ListModel> b(ExternalSourceAddresses addresses) {
        int v7;
        boolean z7;
        Text.Value value;
        Intrinsics.f(addresses, "addresses");
        List<ExternalSourceAddress> a8 = addresses.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            ExternalSourceAddress externalSourceAddress = (ExternalSourceAddress) obj;
            String e8 = externalSourceAddress.e();
            Image.Res res = new Image.Res(R.drawable.ic_pin_fill_16dp);
            Color.Attr attr = new Color.Attr(R.attr.accentNeutral);
            Text.Value value2 = new Text.Value(externalSourceAddress.a());
            Color.Attr attr2 = new Color.Attr(R.attr.contentPrimary);
            if (externalSourceAddress.b().length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                value = new Text.Value(externalSourceAddress.b());
            } else {
                value = null;
            }
            arrayList.add(new TwoLinesItemDelegate.Model(e8, value2, 2132018477, attr2, null, value, 2132018479, new Color.Attr(R.attr.contentSecondary), attr, res, null, null, null, null, null, null, null, null, externalSourceAddress, false, 0, 0, a(i8, addresses), new Color.Attr(R.attr.dynamicNeutral01), null, null, false, false, false, 524024848, null));
            i8 = i9;
        }
        return arrayList;
    }
}
