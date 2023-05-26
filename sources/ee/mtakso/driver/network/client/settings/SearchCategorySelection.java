package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class SearchCategorySelection {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f22808a;
    @SerializedName("selected")

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22809b;

    public SearchCategorySelection(String id, boolean z7) {
        Intrinsics.f(id, "id");
        this.f22808a = id;
        this.f22809b = z7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchCategorySelection) {
            SearchCategorySelection searchCategorySelection = (SearchCategorySelection) obj;
            return Intrinsics.a(this.f22808a, searchCategorySelection.f22808a) && this.f22809b == searchCategorySelection.f22809b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f22808a.hashCode() * 31;
        boolean z7 = this.f22809b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f22808a;
        boolean z7 = this.f22809b;
        return "SearchCategorySelection(id=" + str + ", selected=" + z7 + ")";
    }
}
