package ee.mtakso.driver.ui.screens.work.dispatch;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsState.kt */
/* loaded from: classes5.dex */
public final class DispatchHeatmapSettings {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f33967a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Item> f33968b;

    /* compiled from: DispatchSettingsState.kt */
    /* loaded from: classes5.dex */
    public static final class Item {

        /* renamed from: a  reason: collision with root package name */
        private final String f33969a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33970b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f33971c;

        public Item(String categoryId, String title, boolean z7) {
            Intrinsics.f(categoryId, "categoryId");
            Intrinsics.f(title, "title");
            this.f33969a = categoryId;
            this.f33970b = title;
            this.f33971c = z7;
        }

        public final String a() {
            return this.f33969a;
        }

        public final boolean b() {
            return this.f33971c;
        }

        public final String c() {
            return this.f33970b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.a(this.f33969a, item.f33969a) && Intrinsics.a(this.f33970b, item.f33970b) && this.f33971c == item.f33971c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f33969a.hashCode() * 31) + this.f33970b.hashCode()) * 31;
            boolean z7 = this.f33971c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f33969a;
            String str2 = this.f33970b;
            boolean z7 = this.f33971c;
            return "Item(categoryId=" + str + ", title=" + str2 + ", checked=" + z7 + ")";
        }
    }

    public DispatchHeatmapSettings(boolean z7, List<Item> items) {
        Intrinsics.f(items, "items");
        this.f33967a = z7;
        this.f33968b = items;
    }

    public final boolean a() {
        return this.f33967a;
    }

    public final List<Item> b() {
        return this.f33968b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispatchHeatmapSettings) {
            DispatchHeatmapSettings dispatchHeatmapSettings = (DispatchHeatmapSettings) obj;
            return this.f33967a == dispatchHeatmapSettings.f33967a && Intrinsics.a(this.f33968b, dispatchHeatmapSettings.f33968b);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f33967a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        return (r02 * 31) + this.f33968b.hashCode();
    }

    public String toString() {
        boolean z7 = this.f33967a;
        List<Item> list = this.f33968b;
        return "DispatchHeatmapSettings(checked=" + z7 + ", items=" + list + ")";
    }
}
