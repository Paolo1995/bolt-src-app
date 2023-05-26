package ee.mtakso.driver.ui.screens.work.fifo;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: FifoQueueLoadingModel.kt */
/* loaded from: classes5.dex */
public final class FifoQueueLoadingModel {

    /* renamed from: a  reason: collision with root package name */
    public static final FifoQueueLoadingModel f34074a = new FifoQueueLoadingModel();

    private FifoQueueLoadingModel() {
    }

    public static /* synthetic */ List b(FifoQueueLoadingModel fifoQueueLoadingModel, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 3;
        }
        return fifoQueueLoadingModel.a(i8);
    }

    public final List<ListModel> a(int i8) {
        IntRange o8;
        int v7;
        o8 = RangesKt___RangesKt.o(0, i8);
        v7 = CollectionsKt__IterablesKt.v(o8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new StaticItemDelegate.Model.List("stub_" + nextInt, R.layout.content_work_fifo_item_stub, null, 4, null));
        }
        return arrayList;
    }
}
