package ee.mtakso.driver.service.settings;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettings.kt */
/* loaded from: classes3.dex */
public final class CategorySelectionAutoAcceptanceState {

    /* renamed from: a  reason: collision with root package name */
    private final CategorySelectionState f25932a;

    /* renamed from: b  reason: collision with root package name */
    private final AutoAcceptanceState f25933b;

    public CategorySelectionAutoAcceptanceState(CategorySelectionState categorySelectionState, AutoAcceptanceState autoAcceptanceState) {
        Intrinsics.f(categorySelectionState, "categorySelectionState");
        Intrinsics.f(autoAcceptanceState, "autoAcceptanceState");
        this.f25932a = categorySelectionState;
        this.f25933b = autoAcceptanceState;
    }

    public final AutoAcceptanceState a() {
        return this.f25933b;
    }

    public final CategorySelectionState b() {
        return this.f25932a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategorySelectionAutoAcceptanceState) {
            CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState = (CategorySelectionAutoAcceptanceState) obj;
            return this.f25932a == categorySelectionAutoAcceptanceState.f25932a && this.f25933b == categorySelectionAutoAcceptanceState.f25933b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f25932a.hashCode() * 31) + this.f25933b.hashCode();
    }

    public String toString() {
        CategorySelectionState categorySelectionState = this.f25932a;
        AutoAcceptanceState autoAcceptanceState = this.f25933b;
        return "CategorySelectionAutoAcceptanceState(categorySelectionState=" + categorySelectionState + ", autoAcceptanceState=" + autoAcceptanceState + ")";
    }
}
