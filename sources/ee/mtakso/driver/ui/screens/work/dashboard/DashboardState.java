package ee.mtakso.driver.ui.screens.work.dashboard;

import ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns;
import ee.mtakso.driver.network.client.order.DriverStatisticsSummary;
import ee.mtakso.driver.ui.interactor.score.DriverScoreItem;
import ee.mtakso.driver.uikit.recyclerview.LayoutListModel;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Lottie;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardState.kt */
/* loaded from: classes5.dex */
public abstract class DashboardState {

    /* compiled from: DashboardState.kt */
    /* loaded from: classes5.dex */
    public static final class Dynamic extends DashboardState {

        /* renamed from: a  reason: collision with root package name */
        private final List<LayoutListModel> f33929a;

        /* renamed from: b  reason: collision with root package name */
        private final int f33930b;

        /* renamed from: c  reason: collision with root package name */
        private final int f33931c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dynamic(List<LayoutListModel> models, int i8, int i9) {
            super(null);
            Intrinsics.f(models, "models");
            this.f33929a = models;
            this.f33930b = i8;
            this.f33931c = i9;
        }

        public final int a() {
            return this.f33931c;
        }

        public final List<LayoutListModel> b() {
            return this.f33929a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dynamic) {
                Dynamic dynamic = (Dynamic) obj;
                return Intrinsics.a(this.f33929a, dynamic.f33929a) && this.f33930b == dynamic.f33930b && this.f33931c == dynamic.f33931c;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f33929a.hashCode() * 31) + this.f33930b) * 31) + this.f33931c;
        }

        public String toString() {
            List<LayoutListModel> list = this.f33929a;
            int i8 = this.f33930b;
            int i9 = this.f33931c;
            return "Dynamic(models=" + list + ", rows=" + i8 + ", cols=" + i9 + ")";
        }
    }

    /* compiled from: DashboardState.kt */
    /* loaded from: classes5.dex */
    public static final class Loading extends DashboardState {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f33943a = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: DashboardState.kt */
    /* loaded from: classes5.dex */
    public static final class Static extends DashboardState {

        /* renamed from: a  reason: collision with root package name */
        private final ActiveAndFutureCampaigns f33944a;

        /* renamed from: b  reason: collision with root package name */
        private final DriverFeaturesConfig.CircleKLoyaltyCampaignStatus f33945b;

        /* renamed from: c  reason: collision with root package name */
        private final DriverStatisticsSummary f33946c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f33947d;

        /* renamed from: e  reason: collision with root package name */
        private final DriverScoreItem f33948e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Static(ActiveAndFutureCampaigns activeAndFutureCampaigns, DriverFeaturesConfig.CircleKLoyaltyCampaignStatus circleKLoyaltyCampaignStatus, DriverStatisticsSummary driverStatisticsSummary, boolean z7, DriverScoreItem driverScoreItem) {
            super(null);
            Intrinsics.f(circleKLoyaltyCampaignStatus, "circleKLoyaltyCampaignStatus");
            Intrinsics.f(driverStatisticsSummary, "driverStatisticsSummary");
            this.f33944a = activeAndFutureCampaigns;
            this.f33945b = circleKLoyaltyCampaignStatus;
            this.f33946c = driverStatisticsSummary;
            this.f33947d = z7;
            this.f33948e = driverScoreItem;
        }

        public final DriverFeaturesConfig.CircleKLoyaltyCampaignStatus a() {
            return this.f33945b;
        }

        public final ActiveAndFutureCampaigns b() {
            return this.f33944a;
        }

        public final DriverScoreItem c() {
            return this.f33948e;
        }

        public final boolean d() {
            return this.f33947d;
        }

        public final DriverStatisticsSummary e() {
            return this.f33946c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Static) {
                Static r52 = (Static) obj;
                return Intrinsics.a(this.f33944a, r52.f33944a) && this.f33945b == r52.f33945b && Intrinsics.a(this.f33946c, r52.f33946c) && this.f33947d == r52.f33947d && Intrinsics.a(this.f33948e, r52.f33948e);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ActiveAndFutureCampaigns activeAndFutureCampaigns = this.f33944a;
            int hashCode = (((((activeAndFutureCampaigns == null ? 0 : activeAndFutureCampaigns.hashCode()) * 31) + this.f33945b.hashCode()) * 31) + this.f33946c.hashCode()) * 31;
            boolean z7 = this.f33947d;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            DriverScoreItem driverScoreItem = this.f33948e;
            return i9 + (driverScoreItem != null ? driverScoreItem.hashCode() : 0);
        }

        public String toString() {
            ActiveAndFutureCampaigns activeAndFutureCampaigns = this.f33944a;
            DriverFeaturesConfig.CircleKLoyaltyCampaignStatus circleKLoyaltyCampaignStatus = this.f33945b;
            DriverStatisticsSummary driverStatisticsSummary = this.f33946c;
            boolean z7 = this.f33947d;
            DriverScoreItem driverScoreItem = this.f33948e;
            return "Static(driverCampaigns=" + activeAndFutureCampaigns + ", circleKLoyaltyCampaignStatus=" + circleKLoyaltyCampaignStatus + ", driverStatisticsSummary=" + driverStatisticsSummary + ", driverScoreVisible=" + z7 + ", driverScore=" + driverScoreItem + ")";
        }
    }

    private DashboardState() {
    }

    public /* synthetic */ DashboardState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DashboardState.kt */
    /* loaded from: classes5.dex */
    public static final class FifoQueue extends DashboardState {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f33932a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f33933b;

        /* renamed from: c  reason: collision with root package name */
        private final Header f33934c;

        /* renamed from: d  reason: collision with root package name */
        private final Info f33935d;

        /* renamed from: e  reason: collision with root package name */
        private final List<ListModel> f33936e;

        /* renamed from: f  reason: collision with root package name */
        private final Throwable f33937f;

        /* compiled from: DashboardState.kt */
        /* loaded from: classes5.dex */
        public static final class Header {

            /* renamed from: a  reason: collision with root package name */
            private final Text f33938a;

            /* renamed from: b  reason: collision with root package name */
            private final Text f33939b;

            public Header(Text title, Text subtitle) {
                Intrinsics.f(title, "title");
                Intrinsics.f(subtitle, "subtitle");
                this.f33938a = title;
                this.f33939b = subtitle;
            }

            public final Text a() {
                return this.f33939b;
            }

            public final Text b() {
                return this.f33938a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Header) {
                    Header header = (Header) obj;
                    return Intrinsics.a(this.f33938a, header.f33938a) && Intrinsics.a(this.f33939b, header.f33939b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f33938a.hashCode() * 31) + this.f33939b.hashCode();
            }

            public String toString() {
                Text text = this.f33938a;
                Text text2 = this.f33939b;
                return "Header(title=" + text + ", subtitle=" + text2 + ")";
            }
        }

        /* compiled from: DashboardState.kt */
        /* loaded from: classes5.dex */
        public static final class Info {

            /* renamed from: a  reason: collision with root package name */
            private final Lottie f33940a;

            /* renamed from: b  reason: collision with root package name */
            private final Image f33941b;

            /* renamed from: c  reason: collision with root package name */
            private final Text f33942c;

            public Info(Lottie lottie, Image image, Text text) {
                this.f33940a = lottie;
                this.f33941b = image;
                this.f33942c = text;
            }

            public final Image a() {
                return this.f33941b;
            }

            public final Lottie b() {
                return this.f33940a;
            }

            public final Text c() {
                return this.f33942c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Info) {
                    Info info = (Info) obj;
                    return Intrinsics.a(this.f33940a, info.f33940a) && Intrinsics.a(this.f33941b, info.f33941b) && Intrinsics.a(this.f33942c, info.f33942c);
                }
                return false;
            }

            public int hashCode() {
                Lottie lottie = this.f33940a;
                int hashCode = (lottie == null ? 0 : lottie.hashCode()) * 31;
                Image image = this.f33941b;
                int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
                Text text = this.f33942c;
                return hashCode2 + (text != null ? text.hashCode() : 0);
            }

            public String toString() {
                Lottie lottie = this.f33940a;
                Image image = this.f33941b;
                Text text = this.f33942c;
                return "Info(lottie=" + lottie + ", image=" + image + ", text=" + text + ")";
            }
        }

        public FifoQueue() {
            this(false, false, null, null, null, null, 63, null);
        }

        public /* synthetic */ FifoQueue(boolean z7, boolean z8, Header header, Info info, List list, Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? false : z7, (i8 & 2) == 0 ? z8 : false, (i8 & 4) != 0 ? null : header, (i8 & 8) != 0 ? null : info, (i8 & 16) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 32) != 0 ? null : th);
        }

        public final boolean a() {
            return this.f33932a;
        }

        public final Header b() {
            return this.f33934c;
        }

        public final Info c() {
            return this.f33935d;
        }

        public final List<ListModel> d() {
            return this.f33936e;
        }

        public final boolean e() {
            return this.f33933b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FifoQueue) {
                FifoQueue fifoQueue = (FifoQueue) obj;
                return this.f33932a == fifoQueue.f33932a && this.f33933b == fifoQueue.f33933b && Intrinsics.a(this.f33934c, fifoQueue.f33934c) && Intrinsics.a(this.f33935d, fifoQueue.f33935d) && Intrinsics.a(this.f33936e, fifoQueue.f33936e) && Intrinsics.a(this.f33937f, fifoQueue.f33937f);
            }
            return false;
        }

        public final Throwable f() {
            return this.f33937f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            boolean z7 = this.f33932a;
            ?? r02 = z7;
            if (z7) {
                r02 = 1;
            }
            int i8 = r02 * 31;
            boolean z8 = this.f33933b;
            int i9 = (i8 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
            Header header = this.f33934c;
            int hashCode = (i9 + (header == null ? 0 : header.hashCode())) * 31;
            Info info = this.f33935d;
            int hashCode2 = (((hashCode + (info == null ? 0 : info.hashCode())) * 31) + this.f33936e.hashCode()) * 31;
            Throwable th = this.f33937f;
            return hashCode2 + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            boolean z7 = this.f33932a;
            boolean z8 = this.f33933b;
            Header header = this.f33934c;
            Info info = this.f33935d;
            List<ListModel> list = this.f33936e;
            Throwable th = this.f33937f;
            return "FifoQueue(closable=" + z7 + ", loading=" + z8 + ", header=" + header + ", info=" + info + ", items=" + list + ", throwable=" + th + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FifoQueue(boolean z7, boolean z8, Header header, Info info, List<? extends ListModel> items, Throwable th) {
            super(null);
            Intrinsics.f(items, "items");
            this.f33932a = z7;
            this.f33933b = z8;
            this.f33934c = header;
            this.f33935d = info;
            this.f33936e = items;
            this.f33937f = th;
        }
    }
}
