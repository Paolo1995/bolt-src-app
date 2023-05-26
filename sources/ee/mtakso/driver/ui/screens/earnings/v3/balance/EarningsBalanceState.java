package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent;
import ee.mtakso.driver.ui.screens.earnings.v3.common.BannerData;
import ee.mtakso.driver.ui.screens.earnings.v3.common.ButtonData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceState.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceState {

    /* renamed from: a  reason: collision with root package name */
    private final String f28830a;

    /* renamed from: b  reason: collision with root package name */
    private final EarningsBalanceContent<PayoutHeader> f28831b;

    /* renamed from: c  reason: collision with root package name */
    private final EarningsBalanceContent<HistoryHeader> f28832c;

    /* renamed from: d  reason: collision with root package name */
    private final EarningsBalanceContent<History> f28833d;

    /* compiled from: EarningsBalanceState.kt */
    /* loaded from: classes3.dex */
    public static final class HistoryHeader {

        /* renamed from: a  reason: collision with root package name */
        private final Text f28836a;

        /* renamed from: b  reason: collision with root package name */
        private final List<HistorySection> f28837b;

        public HistoryHeader(Text text, List<HistorySection> historySections) {
            Intrinsics.f(historySections, "historySections");
            this.f28836a = text;
            this.f28837b = historySections;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HistoryHeader b(HistoryHeader historyHeader, Text text, List list, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                text = historyHeader.f28836a;
            }
            if ((i8 & 2) != 0) {
                list = historyHeader.f28837b;
            }
            return historyHeader.a(text, list);
        }

        public final HistoryHeader a(Text text, List<HistorySection> historySections) {
            Intrinsics.f(historySections, "historySections");
            return new HistoryHeader(text, historySections);
        }

        public final List<HistorySection> c() {
            return this.f28837b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HistoryHeader) {
                HistoryHeader historyHeader = (HistoryHeader) obj;
                return Intrinsics.a(this.f28836a, historyHeader.f28836a) && Intrinsics.a(this.f28837b, historyHeader.f28837b);
            }
            return false;
        }

        public int hashCode() {
            Text text = this.f28836a;
            return ((text == null ? 0 : text.hashCode()) * 31) + this.f28837b.hashCode();
        }

        public String toString() {
            Text text = this.f28836a;
            List<HistorySection> list = this.f28837b;
            return "HistoryHeader(historyTitle=" + text + ", historySections=" + list + ")";
        }
    }

    /* compiled from: EarningsBalanceState.kt */
    /* loaded from: classes3.dex */
    public static final class HistorySection {

        /* renamed from: a  reason: collision with root package name */
        private final String f28838a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f28839b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f28840c;

        public HistorySection(String id, Text title, boolean z7) {
            Intrinsics.f(id, "id");
            Intrinsics.f(title, "title");
            this.f28838a = id;
            this.f28839b = title;
            this.f28840c = z7;
        }

        public static /* synthetic */ HistorySection b(HistorySection historySection, String str, Text text, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = historySection.f28838a;
            }
            if ((i8 & 2) != 0) {
                text = historySection.f28839b;
            }
            if ((i8 & 4) != 0) {
                z7 = historySection.f28840c;
            }
            return historySection.a(str, text, z7);
        }

        public final HistorySection a(String id, Text title, boolean z7) {
            Intrinsics.f(id, "id");
            Intrinsics.f(title, "title");
            return new HistorySection(id, title, z7);
        }

        public final String c() {
            return this.f28838a;
        }

        public final boolean d() {
            return this.f28840c;
        }

        public final Text e() {
            return this.f28839b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HistorySection) {
                HistorySection historySection = (HistorySection) obj;
                return Intrinsics.a(this.f28838a, historySection.f28838a) && Intrinsics.a(this.f28839b, historySection.f28839b) && this.f28840c == historySection.f28840c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f28838a.hashCode() * 31) + this.f28839b.hashCode()) * 31;
            boolean z7 = this.f28840c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f28838a;
            Text text = this.f28839b;
            boolean z7 = this.f28840c;
            return "HistorySection(id=" + str + ", title=" + text + ", selected=" + z7 + ")";
        }
    }

    /* compiled from: EarningsBalanceState.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutHeader {

        /* renamed from: a  reason: collision with root package name */
        private final Color f28841a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f28842b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f28843c;

        /* renamed from: d  reason: collision with root package name */
        private final ButtonData<DriverButtonAction> f28844d;

        /* renamed from: e  reason: collision with root package name */
        private final InfoBlockData f28845e;

        /* renamed from: f  reason: collision with root package name */
        private final BannerData<DriverButtonAction> f28846f;

        public PayoutHeader(Color color, Text text, Text text2, ButtonData<DriverButtonAction> buttonData, InfoBlockData infoBlockData, BannerData<DriverButtonAction> bannerData) {
            Intrinsics.f(color, "color");
            this.f28841a = color;
            this.f28842b = text;
            this.f28843c = text2;
            this.f28844d = buttonData;
            this.f28845e = infoBlockData;
            this.f28846f = bannerData;
        }

        public final BannerData<DriverButtonAction> a() {
            return this.f28846f;
        }

        public final ButtonData<DriverButtonAction> b() {
            return this.f28844d;
        }

        public final Color c() {
            return this.f28841a;
        }

        public final InfoBlockData d() {
            return this.f28845e;
        }

        public final Text e() {
            return this.f28843c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PayoutHeader) {
                PayoutHeader payoutHeader = (PayoutHeader) obj;
                return Intrinsics.a(this.f28841a, payoutHeader.f28841a) && Intrinsics.a(this.f28842b, payoutHeader.f28842b) && Intrinsics.a(this.f28843c, payoutHeader.f28843c) && Intrinsics.a(this.f28844d, payoutHeader.f28844d) && Intrinsics.a(this.f28845e, payoutHeader.f28845e) && Intrinsics.a(this.f28846f, payoutHeader.f28846f);
            }
            return false;
        }

        public final Text f() {
            return this.f28842b;
        }

        public int hashCode() {
            int hashCode = this.f28841a.hashCode() * 31;
            Text text = this.f28842b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Text text2 = this.f28843c;
            int hashCode3 = (hashCode2 + (text2 == null ? 0 : text2.hashCode())) * 31;
            ButtonData<DriverButtonAction> buttonData = this.f28844d;
            int hashCode4 = (hashCode3 + (buttonData == null ? 0 : buttonData.hashCode())) * 31;
            InfoBlockData infoBlockData = this.f28845e;
            int hashCode5 = (hashCode4 + (infoBlockData == null ? 0 : infoBlockData.hashCode())) * 31;
            BannerData<DriverButtonAction> bannerData = this.f28846f;
            return hashCode5 + (bannerData != null ? bannerData.hashCode() : 0);
        }

        public String toString() {
            Color color = this.f28841a;
            Text text = this.f28842b;
            Text text2 = this.f28843c;
            ButtonData<DriverButtonAction> buttonData = this.f28844d;
            InfoBlockData infoBlockData = this.f28845e;
            BannerData<DriverButtonAction> bannerData = this.f28846f;
            return "PayoutHeader(color=" + color + ", title=" + text + ", subtitle=" + text2 + ", button=" + buttonData + ", infoBlock=" + infoBlockData + ", banner=" + bannerData + ")";
        }
    }

    public EarningsBalanceState() {
        this(null, null, null, null, 15, null);
    }

    public EarningsBalanceState(String str, EarningsBalanceContent<PayoutHeader> payoutHeader, EarningsBalanceContent<HistoryHeader> historyHeader, EarningsBalanceContent<History> history) {
        Intrinsics.f(payoutHeader, "payoutHeader");
        Intrinsics.f(historyHeader, "historyHeader");
        Intrinsics.f(history, "history");
        this.f28830a = str;
        this.f28831b = payoutHeader;
        this.f28832c = historyHeader;
        this.f28833d = history;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EarningsBalanceState b(EarningsBalanceState earningsBalanceState, String str, EarningsBalanceContent earningsBalanceContent, EarningsBalanceContent earningsBalanceContent2, EarningsBalanceContent earningsBalanceContent3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = earningsBalanceState.f28830a;
        }
        if ((i8 & 2) != 0) {
            earningsBalanceContent = earningsBalanceState.f28831b;
        }
        if ((i8 & 4) != 0) {
            earningsBalanceContent2 = earningsBalanceState.f28832c;
        }
        if ((i8 & 8) != 0) {
            earningsBalanceContent3 = earningsBalanceState.f28833d;
        }
        return earningsBalanceState.a(str, earningsBalanceContent, earningsBalanceContent2, earningsBalanceContent3);
    }

    public final EarningsBalanceState a(String str, EarningsBalanceContent<PayoutHeader> payoutHeader, EarningsBalanceContent<HistoryHeader> historyHeader, EarningsBalanceContent<History> history) {
        Intrinsics.f(payoutHeader, "payoutHeader");
        Intrinsics.f(historyHeader, "historyHeader");
        Intrinsics.f(history, "history");
        return new EarningsBalanceState(str, payoutHeader, historyHeader, history);
    }

    public final String c() {
        return this.f28830a;
    }

    public final EarningsBalanceContent<History> d() {
        return this.f28833d;
    }

    public final EarningsBalanceContent<HistoryHeader> e() {
        return this.f28832c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsBalanceState) {
            EarningsBalanceState earningsBalanceState = (EarningsBalanceState) obj;
            return Intrinsics.a(this.f28830a, earningsBalanceState.f28830a) && Intrinsics.a(this.f28831b, earningsBalanceState.f28831b) && Intrinsics.a(this.f28832c, earningsBalanceState.f28832c) && Intrinsics.a(this.f28833d, earningsBalanceState.f28833d);
        }
        return false;
    }

    public final EarningsBalanceContent<PayoutHeader> f() {
        return this.f28831b;
    }

    public int hashCode() {
        String str = this.f28830a;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + this.f28831b.hashCode()) * 31) + this.f28832c.hashCode()) * 31) + this.f28833d.hashCode();
    }

    public String toString() {
        String str = this.f28830a;
        EarningsBalanceContent<PayoutHeader> earningsBalanceContent = this.f28831b;
        EarningsBalanceContent<HistoryHeader> earningsBalanceContent2 = this.f28832c;
        EarningsBalanceContent<History> earningsBalanceContent3 = this.f28833d;
        return "EarningsBalanceState(fagUrl=" + str + ", payoutHeader=" + earningsBalanceContent + ", historyHeader=" + earningsBalanceContent2 + ", history=" + earningsBalanceContent3 + ")";
    }

    /* compiled from: EarningsBalanceState.kt */
    /* loaded from: classes3.dex */
    public static final class History {

        /* renamed from: a  reason: collision with root package name */
        private final List<ListModel> f28834a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28835b;

        public History() {
            this(null, false, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public History(List<? extends ListModel> data, boolean z7) {
            Intrinsics.f(data, "data");
            this.f28834a = data;
            this.f28835b = z7;
        }

        public final History a(List<? extends ListModel> data, boolean z7) {
            Intrinsics.f(data, "data");
            return new History(data, z7);
        }

        public final List<ListModel> b() {
            return this.f28834a;
        }

        public final boolean c() {
            return this.f28835b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof History) {
                History history = (History) obj;
                return Intrinsics.a(this.f28834a, history.f28834a) && this.f28835b == history.f28835b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f28834a.hashCode() * 31;
            boolean z7 = this.f28835b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            List<ListModel> list = this.f28834a;
            boolean z7 = this.f28835b;
            return "History(data=" + list + ", lastPageLoaded=" + z7 + ")";
        }

        public /* synthetic */ History(List list, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 2) != 0 ? false : z7);
        }
    }

    public /* synthetic */ EarningsBalanceState(String str, EarningsBalanceContent earningsBalanceContent, EarningsBalanceContent earningsBalanceContent2, EarningsBalanceContent earningsBalanceContent3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? new EarningsBalanceContent.Loading(null, 1, null) : earningsBalanceContent, (i8 & 4) != 0 ? new EarningsBalanceContent.Loading(null, 1, null) : earningsBalanceContent2, (i8 & 8) != 0 ? new EarningsBalanceContent.Loading(null, 1, null) : earningsBalanceContent3);
    }
}
