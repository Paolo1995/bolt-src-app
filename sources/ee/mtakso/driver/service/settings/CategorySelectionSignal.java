package ee.mtakso.driver.service.settings;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DispatchSettingsManager.kt */
/* loaded from: classes3.dex */
public final class CategorySelectionSignal {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25934a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25935b;

    public CategorySelectionSignal() {
        this(false, false, 3, null);
    }

    public CategorySelectionSignal(boolean z7, boolean z8) {
        this.f25934a = z7;
        this.f25935b = z8;
    }

    public final boolean a() {
        return this.f25934a;
    }

    public final boolean b() {
        return this.f25935b;
    }

    public final void c(boolean z7) {
        this.f25935b = z7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategorySelectionSignal) {
            CategorySelectionSignal categorySelectionSignal = (CategorySelectionSignal) obj;
            return this.f25934a == categorySelectionSignal.f25934a && this.f25935b == categorySelectionSignal.f25935b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f25934a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        boolean z8 = this.f25935b;
        return i8 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        boolean z7 = this.f25934a;
        boolean z8 = this.f25935b;
        return "CategorySelectionSignal(signal=" + z7 + ", isConsumed=" + z8 + ")";
    }

    public /* synthetic */ CategorySelectionSignal(boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? true : z8);
    }
}
