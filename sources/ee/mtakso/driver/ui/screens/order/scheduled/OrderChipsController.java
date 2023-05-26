package ee.mtakso.driver.ui.screens.order.scheduled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.RideDetailChip;
import ee.mtakso.driver.ui.screens.order.scheduled.OrderChipsController;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderChipsController.kt */
/* loaded from: classes3.dex */
public final class OrderChipsController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f31595a;

    /* renamed from: b  reason: collision with root package name */
    private final Flow f31596b;

    /* renamed from: c  reason: collision with root package name */
    private final DynamicViewHelper<ViewHolder> f31597c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f31598d;

    /* compiled from: OrderChipsController.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f31599a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f31600b;

        /* renamed from: c  reason: collision with root package name */
        public Map<Integer, View> f31601c;

        public ViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f31601c = new LinkedHashMap();
            this.f31599a = containerView;
            View a8 = a();
            Intrinsics.d(a8, "null cannot be cast to non-null type android.widget.TextView");
            this.f31600b = (TextView) a8;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f31599a;
        }

        public final TextView b() {
            return this.f31600b;
        }
    }

    /* compiled from: OrderChipsController.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31602a;

        static {
            int[] iArr = new int[RideDetailChip.Type.values().length];
            try {
                iArr[RideDetailChip.Type.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RideDetailChip.Type.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RideDetailChip.Type.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31602a = iArr;
        }
    }

    public OrderChipsController(ViewGroup containerView, Flow flow, List<? extends View> chipVies) {
        int v7;
        List J0;
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(flow, "flow");
        Intrinsics.f(chipVies, "chipVies");
        this.f31598d = new LinkedHashMap();
        this.f31595a = containerView;
        this.f31596b = flow;
        ViewGroup c8 = c();
        v7 = CollectionsKt__IterablesKt.v(chipVies, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (View view : chipVies) {
            arrayList.add(new ViewHolder(view));
        }
        J0 = CollectionsKt___CollectionsKt.J0(arrayList);
        this.f31597c = new DynamicViewHelper<>(c8, J0, this.f31596b, new Function2<LayoutInflater, ViewGroup, ViewHolder>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderChipsController$dynamicViewHelper$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final OrderChipsController.ViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.f(inflater, "inflater");
                Intrinsics.f(parent, "parent");
                View inflate = inflater.inflate(R.layout.content_scheduled_order_chip, parent, false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…rder_chip, parent, false)");
                return new OrderChipsController.ViewHolder(inflate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Color d(RideDetailChip.Type type) {
        int i8 = WhenMappings.f31602a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return new Color.Attr(R.attr.dynamicPurple02);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new Color.Attr(R.attr.dynamicOrange);
        }
        return new Color.Attr(R.attr.dynamicPurple02);
    }

    public final void b(final List<RideDetailChip> chips) {
        Intrinsics.f(chips, "chips");
        ViewExtKt.d(this.f31596b, !chips.isEmpty(), 0, 2, null);
        this.f31597c.a(chips.size(), new Function2<ViewHolder, Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderChipsController$bindChips$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(OrderChipsController.ViewHolder chipHolder, int i8) {
                Color d8;
                Intrinsics.f(chipHolder, "chipHolder");
                RideDetailChip rideDetailChip = chips.get(i8);
                chipHolder.b().setText(rideDetailChip.a());
                TextView b8 = chipHolder.b();
                d8 = this.d(rideDetailChip.b());
                ViewExtKt.b(b8, d8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(OrderChipsController.ViewHolder viewHolder, Integer num) {
                b(viewHolder, num.intValue());
                return Unit.f50853a;
            }
        });
    }

    public ViewGroup c() {
        return this.f31595a;
    }
}
