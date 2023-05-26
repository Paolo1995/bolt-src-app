package ee.mtakso.driver.ui.screens.home.v3.map.fifo;

import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueTileLabelState.kt */
/* loaded from: classes3.dex */
public abstract class FifoQueueTileLabelState {

    /* compiled from: FifoQueueTileLabelState.kt */
    /* loaded from: classes3.dex */
    public static final class Drawing extends FifoQueueTileLabelState {

        /* renamed from: a  reason: collision with root package name */
        private final FifoQueueTileLabel f30183a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drawing(FifoQueueTileLabel label) {
            super(null);
            Intrinsics.f(label, "label");
            this.f30183a = label;
        }

        @Override // ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabelState
        public FifoQueueTileLabel a() {
            return this.f30183a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Drawing) && Intrinsics.a(a(), ((Drawing) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            FifoQueueTileLabel a8 = a();
            return "Drawing(label=" + a8 + ")";
        }
    }

    /* compiled from: FifoQueueTileLabelState.kt */
    /* loaded from: classes3.dex */
    public static final class Drawn extends FifoQueueTileLabelState {

        /* renamed from: a  reason: collision with root package name */
        private final FifoQueueTileLabel f30184a;

        /* renamed from: b  reason: collision with root package name */
        private final MarkerInfo f30185b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drawn(FifoQueueTileLabel label, MarkerInfo markerInfo) {
            super(null);
            Intrinsics.f(label, "label");
            Intrinsics.f(markerInfo, "markerInfo");
            this.f30184a = label;
            this.f30185b = markerInfo;
        }

        @Override // ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabelState
        public FifoQueueTileLabel a() {
            return this.f30184a;
        }

        public final MarkerInfo b() {
            return this.f30185b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Drawn) {
                Drawn drawn = (Drawn) obj;
                return Intrinsics.a(a(), drawn.a()) && Intrinsics.a(this.f30185b, drawn.f30185b);
            }
            return false;
        }

        public int hashCode() {
            return (a().hashCode() * 31) + this.f30185b.hashCode();
        }

        public String toString() {
            FifoQueueTileLabel a8 = a();
            MarkerInfo markerInfo = this.f30185b;
            return "Drawn(label=" + a8 + ", markerInfo=" + markerInfo + ")";
        }
    }

    /* compiled from: FifoQueueTileLabelState.kt */
    /* loaded from: classes3.dex */
    public static final class Pending extends FifoQueueTileLabelState {

        /* renamed from: a  reason: collision with root package name */
        private final FifoQueueTileLabel f30186a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pending(FifoQueueTileLabel label) {
            super(null);
            Intrinsics.f(label, "label");
            this.f30186a = label;
        }

        @Override // ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabelState
        public FifoQueueTileLabel a() {
            return this.f30186a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Pending) && Intrinsics.a(a(), ((Pending) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            FifoQueueTileLabel a8 = a();
            return "Pending(label=" + a8 + ")";
        }
    }

    private FifoQueueTileLabelState() {
    }

    public /* synthetic */ FifoQueueTileLabelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract FifoQueueTileLabel a();
}
