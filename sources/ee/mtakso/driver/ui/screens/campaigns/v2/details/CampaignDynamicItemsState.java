package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDynamicItemsState.kt */
/* loaded from: classes3.dex */
public final class CampaignDynamicItemsState {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListModel> f27471a;

    /* JADX WARN: Multi-variable type inference failed */
    public CampaignDynamicItemsState(List<? extends ListModel> items) {
        Intrinsics.f(items, "items");
        this.f27471a = items;
    }

    public final List<ListModel> a() {
        return this.f27471a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CampaignDynamicItemsState) && Intrinsics.a(this.f27471a, ((CampaignDynamicItemsState) obj).f27471a);
    }

    public int hashCode() {
        return this.f27471a.hashCode();
    }

    public String toString() {
        List<ListModel> list = this.f27471a;
        return "CampaignDynamicItemsState(items=" + list + ")";
    }
}
