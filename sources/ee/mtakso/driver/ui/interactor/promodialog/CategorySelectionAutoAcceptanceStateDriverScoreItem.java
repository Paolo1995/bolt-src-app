package ee.mtakso.driver.ui.interactor.promodialog;

import ee.mtakso.driver.service.settings.CategorySelectionAutoAcceptanceState;
import ee.mtakso.driver.ui.interactor.score.DriverScoreItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomePromoDialogInteractor.kt */
/* loaded from: classes3.dex */
public final class CategorySelectionAutoAcceptanceStateDriverScoreItem {

    /* renamed from: a  reason: collision with root package name */
    private final CategorySelectionAutoAcceptanceState f26794a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverScoreItem f26795b;

    public CategorySelectionAutoAcceptanceStateDriverScoreItem(CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState, DriverScoreItem driverScoreItem) {
        this.f26794a = categorySelectionAutoAcceptanceState;
        this.f26795b = driverScoreItem;
    }

    public final CategorySelectionAutoAcceptanceState a() {
        return this.f26794a;
    }

    public final DriverScoreItem b() {
        return this.f26795b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategorySelectionAutoAcceptanceStateDriverScoreItem) {
            CategorySelectionAutoAcceptanceStateDriverScoreItem categorySelectionAutoAcceptanceStateDriverScoreItem = (CategorySelectionAutoAcceptanceStateDriverScoreItem) obj;
            return Intrinsics.a(this.f26794a, categorySelectionAutoAcceptanceStateDriverScoreItem.f26794a) && Intrinsics.a(this.f26795b, categorySelectionAutoAcceptanceStateDriverScoreItem.f26795b);
        }
        return false;
    }

    public int hashCode() {
        CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState = this.f26794a;
        int hashCode = (categorySelectionAutoAcceptanceState == null ? 0 : categorySelectionAutoAcceptanceState.hashCode()) * 31;
        DriverScoreItem driverScoreItem = this.f26795b;
        return hashCode + (driverScoreItem != null ? driverScoreItem.hashCode() : 0);
    }

    public String toString() {
        CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState = this.f26794a;
        DriverScoreItem driverScoreItem = this.f26795b;
        return "CategorySelectionAutoAcceptanceStateDriverScoreItem(categorySelectionAutoAcceptanceState=" + categorySelectionAutoAcceptanceState + ", driverScoreItem=" + driverScoreItem + ")";
    }
}
