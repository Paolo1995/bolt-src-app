package ee.mtakso.driver.ui.screens.order.scheduled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.scheduled.OrderLabelsController;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderLabelsController.kt */
/* loaded from: classes3.dex */
public final class OrderLabelsController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f31608a;

    /* renamed from: b  reason: collision with root package name */
    private final Flow f31609b;

    /* renamed from: c  reason: collision with root package name */
    private final DynamicViewHelper<ViewHolder> f31610c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f31611d;

    /* compiled from: OrderLabelsController.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f31612a;

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, View> f31613b;

        public ViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f31613b = new LinkedHashMap();
            this.f31612a = containerView;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f31612a;
        }

        public View b(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31613b;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View a8 = a();
                if (a8 == null || (findViewById = a8.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }
    }

    public OrderLabelsController(ViewGroup containerView, Flow flow, List<? extends View> labelViews) {
        int v7;
        List J0;
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(flow, "flow");
        Intrinsics.f(labelViews, "labelViews");
        this.f31611d = new LinkedHashMap();
        this.f31608a = containerView;
        this.f31609b = flow;
        ViewGroup b8 = b();
        v7 = CollectionsKt__IterablesKt.v(labelViews, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (View view : labelViews) {
            arrayList.add(new ViewHolder(view));
        }
        J0 = CollectionsKt___CollectionsKt.J0(arrayList);
        this.f31610c = new DynamicViewHelper<>(b8, J0, this.f31609b, new Function2<LayoutInflater, ViewGroup, ViewHolder>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderLabelsController$dynamicViewHelper$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final OrderLabelsController.ViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.f(inflater, "inflater");
                Intrinsics.f(parent, "parent");
                View inflate = inflater.inflate(R.layout.content_scheduled_order_label, parent, false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…der_label, parent, false)");
                return new OrderLabelsController.ViewHolder(inflate);
            }
        });
    }

    public final void a(final List<OrderLabelModel> labels) {
        Intrinsics.f(labels, "labels");
        ViewExtKt.d(this.f31609b, !labels.isEmpty(), 0, 2, null);
        this.f31610c.a(labels.size(), new Function2<ViewHolder, Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderLabelsController$bindLabels$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(OrderLabelsController.ViewHolder labelHolder, int i8) {
                boolean z7;
                int m8;
                Intrinsics.f(labelHolder, "labelHolder");
                OrderLabelModel orderLabelModel = labels.get(i8);
                int i9 = R.id.labelImage;
                ImageView imageView = (ImageView) labelHolder.b(i9);
                Intrinsics.e(imageView, "labelHolder.labelImage");
                boolean z8 = true;
                if (orderLabelModel.a() != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                ViewExtKt.d(imageView, z7, 0, 2, null);
                Image a8 = orderLabelModel.a();
                if (a8 != null) {
                    ImageView imageView2 = (ImageView) labelHolder.b(i9);
                    Intrinsics.e(imageView2, "labelHolder.labelImage");
                    ImageKt.b(a8, imageView2, null, 2, null);
                }
                TextView textView = (TextView) labelHolder.b(R.id.labelText);
                Intrinsics.e(textView, "labelHolder.labelText");
                TextViewExtKt.h(textView, orderLabelModel.b());
                ImageView imageView3 = (ImageView) labelHolder.b(R.id.labelDivider);
                Intrinsics.e(imageView3, "labelHolder.labelDivider");
                m8 = CollectionsKt__CollectionsKt.m(labels);
                if (i8 == m8) {
                    z8 = false;
                }
                ViewExtKt.d(imageView3, z8, 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(OrderLabelsController.ViewHolder viewHolder, Integer num) {
                b(viewHolder, num.intValue());
                return Unit.f50853a;
            }
        });
    }

    public ViewGroup b() {
        return this.f31608a;
    }
}
