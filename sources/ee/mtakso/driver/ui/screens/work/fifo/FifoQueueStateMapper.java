package ee.mtakso.driver.ui.screens.work.fifo;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.FifoQueueStateForDriverResponse;
import ee.mtakso.driver.network.client.order.FifoQueueStateResponse;
import ee.mtakso.driver.network.client.order.FifoQueueTextAppearance;
import ee.mtakso.driver.service.modules.fifo.FifoQueueDetails;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverLottieMapper;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.ui.screens.work.fifo.FifoCategoryItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.DriverButton;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueStateMapper.kt */
/* loaded from: classes5.dex */
public final class FifoQueueStateMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverButtonMapper f34075a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverImageMapper f34076b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverLottieMapper f34077c;

    /* renamed from: d  reason: collision with root package name */
    private final HtmlEngine f34078d;

    /* compiled from: FifoQueueStateMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34079a;

        static {
            int[] iArr = new int[FifoQueueTextAppearance.values().length];
            try {
                iArr[FifoQueueTextAppearance.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FifoQueueTextAppearance.HIGHLIGHTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34079a = iArr;
        }
    }

    @Inject
    public FifoQueueStateMapper(DriverButtonMapper buttonMapper, DriverImageMapper imageMapper, DriverLottieMapper lottieMapper, HtmlEngine htmlEngine) {
        Intrinsics.f(buttonMapper, "buttonMapper");
        Intrinsics.f(imageMapper, "imageMapper");
        Intrinsics.f(lottieMapper, "lottieMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f34075a = buttonMapper;
        this.f34076b = imageMapper;
        this.f34077c = lottieMapper;
        this.f34078d = htmlEngine;
    }

    private final ListModel a(String str, FifoQueueStateResponse.Category category) {
        Text.Value value;
        Text.Value value2 = new Text.Value(category.a());
        String d8 = category.d();
        Text.Value value3 = null;
        if (d8 != null) {
            value = new Text.Value(d8);
        } else {
            value = null;
        }
        Color d9 = d(category.b());
        String c8 = category.c();
        if (c8 != null) {
            value3 = new Text.Value(c8);
        }
        return new FifoCategoryItemDelegate.Model(str, value2, null, value, d9, value3, c(category.b()), 4, null);
    }

    private final Color c(FifoQueueTextAppearance fifoQueueTextAppearance) {
        int i8;
        if (fifoQueueTextAppearance == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f34079a[fifoQueueTextAppearance.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                return new Color.Attr(R.attr.contentSecondary);
            }
            return new Color.Attr(R.attr.linkAlternative);
        }
        return new Color.Attr(R.attr.contentSecondary);
    }

    private final Color d(FifoQueueTextAppearance fifoQueueTextAppearance) {
        int i8;
        if (fifoQueueTextAppearance == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f34079a[fifoQueueTextAppearance.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                return new Color.Attr(R.attr.contentPrimary);
            }
            return new Color.Attr(R.attr.linkAlternative);
        }
        return new Color.Attr(R.attr.contentPrimary);
    }

    public final DashboardState b(FifoQueueDetails details) {
        DashboardState.FifoQueue fifoQueue;
        int v7;
        int v8;
        int v9;
        boolean z7;
        List n02;
        Intrinsics.f(details, "details");
        int i8 = 0;
        if (details instanceof FifoQueueDetails.LoadingProximity) {
            return new DashboardState.FifoQueue(true, true, null, null, FifoQueueLoadingModel.b(FifoQueueLoadingModel.f34074a, 0, 1, null), null, 44, null);
        }
        if (details instanceof FifoQueueDetails.LoadingInQueue) {
            return new DashboardState.FifoQueue(false, true, null, null, FifoQueueLoadingModel.b(FifoQueueLoadingModel.f34074a, 0, 1, null), null, 44, null);
        }
        if (details instanceof FifoQueueDetails.Proximity) {
            FifoQueueDetails.Proximity proximity = (FifoQueueDetails.Proximity) details;
            List<FifoQueueStateResponse.Category> b8 = proximity.a().b();
            v8 = CollectionsKt__IterablesKt.v(b8, 10);
            ArrayList arrayList = new ArrayList(v8);
            int i9 = 0;
            for (Object obj : b8) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                arrayList.add(a("category_" + i9, (FifoQueueStateResponse.Category) obj));
                i9 = i10;
            }
            List<DriverButton> a8 = proximity.a().a();
            v9 = CollectionsKt__IterablesKt.v(a8, 10);
            ArrayList arrayList2 = new ArrayList(v9);
            int i11 = 0;
            for (Object obj2 : a8) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                arrayList2.add(this.f34075a.b("control_" + i11, (DriverButton) obj2));
                i11 = i12;
            }
            List<DriverButton> a9 = proximity.a().a();
            if (!(a9 instanceof Collection) || !a9.isEmpty()) {
                for (DriverButton driverButton : a9) {
                    if (driverButton.a() instanceof DriverButtonAction.Close) {
                        z7 = true;
                        break;
                    }
                }
            }
            z7 = false;
            DashboardState.FifoQueue.Header header = new DashboardState.FifoQueue.Header(new Text.Value(proximity.a().d()), new Text.Value(proximity.a().c()));
            n02 = CollectionsKt___CollectionsKt.n0(arrayList, arrayList2);
            return new DashboardState.FifoQueue(z7, false, header, null, n02, null, 32, null);
        }
        if (details instanceof FifoQueueDetails.InQueue) {
            FifoQueueDetails.InQueue inQueue = (FifoQueueDetails.InQueue) details;
            List<FifoQueueStateForDriverResponse.Category> e8 = inQueue.a().e();
            v7 = CollectionsKt__IterablesKt.v(e8, 10);
            ArrayList arrayList3 = new ArrayList(v7);
            for (Object obj3 : e8) {
                int i13 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                FifoQueueStateForDriverResponse.Category category = (FifoQueueStateForDriverResponse.Category) obj3;
                String str = "category_" + i8;
                Text.Value value = new Text.Value(category.a());
                String d8 = category.d();
                Text.Value value2 = d8 != null ? new Text.Value(d8) : null;
                Color d9 = d(category.b());
                String c8 = category.c();
                arrayList3.add(new FifoCategoryItemDelegate.Model(str, value, null, value2, d9, c8 != null ? new Text.Value(c8) : null, c(category.b()), 4, null));
                i8 = i13;
            }
            fifoQueue = new DashboardState.FifoQueue(false, false, new DashboardState.FifoQueue.Header(new Text.Value(inQueue.a().g()), new Text.Value(inQueue.a().f())), new DashboardState.FifoQueue.Info(this.f34077c.a(inQueue.a().c()), this.f34076b.a(inQueue.a().c()), new Text.Value(this.f34078d.a(inQueue.a().d()))), arrayList3, null, 32, null);
        } else if (details instanceof FifoQueueDetails.Failed) {
            fifoQueue = new DashboardState.FifoQueue(false, false, null, null, null, ((FifoQueueDetails.Failed) details).a(), 31, null);
        } else {
            return new DashboardState.FifoQueue(false, false, null, null, null, null, 63, null);
        }
        return fifoQueue;
    }
}
