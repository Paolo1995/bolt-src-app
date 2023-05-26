package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class SettingsUpdateRequest {
    @SerializedName("search_categories")

    /* renamed from: a  reason: collision with root package name */
    private final List<SearchCategorySelection> f22829a;
    @SerializedName("order_acceptance")

    /* renamed from: b  reason: collision with root package name */
    private final AutoOrderAcceptance f22830b;

    public SettingsUpdateRequest(List<SearchCategorySelection> list, AutoOrderAcceptance autoOrderAcceptance) {
        this.f22829a = list;
        this.f22830b = autoOrderAcceptance;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsUpdateRequest) {
            SettingsUpdateRequest settingsUpdateRequest = (SettingsUpdateRequest) obj;
            return Intrinsics.a(this.f22829a, settingsUpdateRequest.f22829a) && this.f22830b == settingsUpdateRequest.f22830b;
        }
        return false;
    }

    public int hashCode() {
        List<SearchCategorySelection> list = this.f22829a;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        AutoOrderAcceptance autoOrderAcceptance = this.f22830b;
        return hashCode + (autoOrderAcceptance != null ? autoOrderAcceptance.hashCode() : 0);
    }

    public String toString() {
        List<SearchCategorySelection> list = this.f22829a;
        AutoOrderAcceptance autoOrderAcceptance = this.f22830b;
        return "SettingsUpdateRequest(selection=" + list + ", orderAcceptance=" + autoOrderAcceptance + ")";
    }
}
