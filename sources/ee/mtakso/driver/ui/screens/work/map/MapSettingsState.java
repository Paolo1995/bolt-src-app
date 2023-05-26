package ee.mtakso.driver.ui.screens.work.map;

import ee.mtakso.driver.ui.interactor.map.MapSettingsCategory;
import ee.mtakso.driver.ui.interactor.map.MapSettingsHeatmap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapSettingsState.kt */
/* loaded from: classes5.dex */
public abstract class MapSettingsState {

    /* compiled from: MapSettingsState.kt */
    /* loaded from: classes5.dex */
    public static final class Loading extends MapSettingsState {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f34163a = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: MapSettingsState.kt */
    /* loaded from: classes5.dex */
    public static final class Ready extends MapSettingsState {

        /* renamed from: a  reason: collision with root package name */
        private final List<MapSettingsHeatmap> f34164a;

        /* renamed from: b  reason: collision with root package name */
        private final String f34165b;

        /* renamed from: c  reason: collision with root package name */
        private final List<MapSettingsCategory> f34166c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ready(List<MapSettingsHeatmap> heatmapOptions, String str, List<MapSettingsCategory> heatmapCategories) {
            super(null);
            Intrinsics.f(heatmapOptions, "heatmapOptions");
            Intrinsics.f(heatmapCategories, "heatmapCategories");
            this.f34164a = heatmapOptions;
            this.f34165b = str;
            this.f34166c = heatmapCategories;
        }

        public final List<MapSettingsCategory> a() {
            return this.f34166c;
        }

        public final String b() {
            return this.f34165b;
        }

        public final List<MapSettingsHeatmap> c() {
            return this.f34164a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ready) {
                Ready ready = (Ready) obj;
                return Intrinsics.a(this.f34164a, ready.f34164a) && Intrinsics.a(this.f34165b, ready.f34165b) && Intrinsics.a(this.f34166c, ready.f34166c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f34164a.hashCode() * 31;
            String str = this.f34165b;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f34166c.hashCode();
        }

        public String toString() {
            List<MapSettingsHeatmap> list = this.f34164a;
            String str = this.f34165b;
            List<MapSettingsCategory> list2 = this.f34166c;
            return "Ready(heatmapOptions=" + list + ", heatmapDescription=" + str + ", heatmapCategories=" + list2 + ")";
        }
    }

    private MapSettingsState() {
    }

    public /* synthetic */ MapSettingsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
