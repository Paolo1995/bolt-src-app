package ee.mtakso.driver.ui.screens.history.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.network.client.order.PreviousOrder;
import ee.mtakso.driver.network.client.order.PriceReviewState;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import eu.bolt.driver.core.util.DateTimeFormatter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHistoryDelegate.kt */
/* loaded from: classes3.dex */
public final class OrderHistoryDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29574b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f29575c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29576d;

    /* compiled from: OrderHistoryDelegate.kt */
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        final /* synthetic */ OrderHistoryDelegate f29582u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(OrderHistoryDelegate orderHistoryDelegate, View view) {
            super(view);
            Intrinsics.f(view, "view");
            this.f29582u = orderHistoryDelegate;
        }
    }

    /* compiled from: OrderHistoryDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29583a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f29584b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f29585c;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f29583a = iArr;
            int[] iArr2 = new int[PaymentType.values().length];
            try {
                iArr2[PaymentType.CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PaymentType.IN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f29584b = iArr2;
            int[] iArr3 = new int[PriceReviewState.values().length];
            try {
                iArr3[PriceReviewState.REQUESTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[PriceReviewState.MANUAL_REVIEW_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[PriceReviewState.FRAUD_REVIEW_REQUESTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            f29585c = iArr3;
        }
    }

    public OrderHistoryDelegate() {
        this(null, 1, null);
    }

    public /* synthetic */ OrderHistoryDelegate(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.list.OrderHistoryDelegate.1
            public final void b(Model it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Model model) {
                b(model);
                return Unit.f50853a;
            }
        } : function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A(android.view.View r11, ee.mtakso.driver.network.client.order.PreviousOrder r12) {
        /*
            r10 = this;
            android.content.Context r0 = r11.getContext()
            java.lang.String r1 = r12.h()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L15
            boolean r1 = kotlin.text.StringsKt.y(r1)
            if (r1 == 0) goto L13
            goto L15
        L13:
            r1 = 0
            goto L16
        L15:
            r1 = 1
        L16:
            java.lang.String r4 = "orderItemView.tvTipsInfo"
            r5 = 0
            r6 = 2
            if (r1 == 0) goto L2b
            int r1 = ee.mtakso.driver.R.id.tvTipsInfo
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.e(r1, r4)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r1, r3, r3, r6, r5)
            goto L46
        L2b:
            int r1 = ee.mtakso.driver.R.id.tvTipsInfo
            android.view.View r7 = r11.findViewById(r1)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.jvm.internal.Intrinsics.e(r7, r4)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r7, r2, r3, r6, r5)
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r4 = r12.h()
            r1.setText(r4)
        L46:
            ee.mtakso.driver.network.client.order.PriceReviewState r1 = r12.e()
            int[] r4 = ee.mtakso.driver.ui.screens.history.list.OrderHistoryDelegate.WhenMappings.f29585c
            int r1 = r1.ordinal()
            r1 = r4[r1]
            if (r1 == r2) goto Lcc
            if (r1 == r6) goto Lcc
            r4 = 3
            if (r1 == r4) goto Lcc
            java.lang.String r1 = r12.d()
            if (r1 == 0) goto L68
            boolean r1 = kotlin.text.StringsKt.y(r1)
            if (r1 == 0) goto L66
            goto L68
        L66:
            r1 = 0
            goto L69
        L68:
            r1 = 1
        L69:
            java.lang.String r7 = "orderItemView.ivPaymentMethod"
            java.lang.String r8 = "orderItemView.tvPrice"
            if (r1 == 0) goto L8c
            int r12 = ee.mtakso.driver.R.id.tvPrice
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.jvm.internal.Intrinsics.e(r12, r8)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r12, r3, r3, r6, r5)
            int r12 = ee.mtakso.driver.R.id.ivPaymentMethod
            android.view.View r11 = r11.findViewById(r12)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            kotlin.jvm.internal.Intrinsics.e(r11, r7)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r11, r3, r3, r6, r5)
            goto Lcb
        L8c:
            int r1 = ee.mtakso.driver.R.id.tvPrice
            android.view.View r9 = r11.findViewById(r1)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.e(r9, r8)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r9, r2, r3, r6, r5)
            int r2 = ee.mtakso.driver.R.id.ivPaymentMethod
            android.view.View r6 = r11.findViewById(r2)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            kotlin.jvm.internal.Intrinsics.e(r6, r7)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r6, r3, r3, r4, r5)
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r3 = r12.d()
            r1.setText(r3)
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            ee.mtakso.driver.network.client.order.PaymentType r12 = r12.f()
            android.graphics.drawable.Drawable r12 = r10.u(r0, r12)
            r11.setImageDrawable(r12)
        Lcb:
            return
        Lcc:
            int r12 = ee.mtakso.driver.R.id.tvPrice
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r1 = ""
            r12.setText(r1)
            r12 = 2131232187(0x7f0805bb, float:1.8080476E38)
            android.graphics.drawable.Drawable r12 = androidx.core.content.ContextCompat.getDrawable(r0, r12)
            int r0 = ee.mtakso.driver.R.id.ivPaymentMethod
            android.view.View r11 = r11.findViewById(r0)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r11.setImageDrawable(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.history.list.OrderHistoryDelegate.A(android.view.View, ee.mtakso.driver.network.client.order.PreviousOrder):void");
    }

    private final DateTimeConverter t() {
        return (DateTimeConverter) this.f29575c.getValue();
    }

    private final Drawable u(Context context, PaymentType paymentType) {
        int i8;
        if (paymentType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f29584b[paymentType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                return null;
            }
            return ContextCompat.getDrawable(context, R.drawable.ic_card_orders_history);
        }
        return ContextCompat.getDrawable(context, R.drawable.ic_cash_orders_history);
    }

    private final int v(Context context, PreviousOrder previousOrder) {
        Color.Attr attr;
        int i8 = WhenMappings.f29583a[previousOrder.g().ordinal()];
        if (i8 != 1) {
            if (i8 != 2 && i8 != 3) {
                attr = new Color.Attr(R.attr.contentCritical);
            } else {
                attr = new Color.Attr(R.attr.accentOrange);
            }
        } else {
            attr = new Color.Attr(R.attr.accentGreen);
        }
        return ColorKt.a(attr, context);
    }

    private final String w(Context context, PreviousOrder previousOrder) {
        String string;
        switch (WhenMappings.f29583a[previousOrder.g().ordinal()]) {
            case 1:
                string = context.getString(R.string.history_ride_finished);
                break;
            case 2:
                string = context.getString(R.string.history_ride_rider_cancelled);
                break;
            case 3:
                string = context.getString(R.string.history_ride_rider_didnt_show);
                break;
            case 4:
                string = context.getString(R.string.history_ride_declined);
                break;
            case 5:
                string = context.getString(R.string.history_ride_didnot_respond);
                break;
            case 6:
                string = context.getString(R.string.auto_cancelled_payment_failed);
                break;
            default:
                string = context.getString(R.string.error);
                break;
        }
        Intrinsics.e(string, "when (previousOrder.stat…R.string.error)\n        }");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(OrderHistoryDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29574b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29576d;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View v7 = inflater.inflate(R.layout.item_orders_history_list, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(this, v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        PreviousOrder n8 = model.n();
        ((TextView) holder.f7332a.findViewById(R.id.tvOrderDestinationAddress)).setText(n8.a());
        ((TextView) holder.f7332a.findViewById(R.id.tvCreationDate)).setText(t().a(Long.valueOf(n8.b())));
        View view = holder.f7332a;
        int i8 = R.id.tvOrderStatus;
        Context context = holder.f7332a.getContext();
        Intrinsics.e(context, "holder.itemView.context");
        ((TextView) view.findViewById(i8)).setTextColor(v(context, n8));
        Context context2 = holder.f7332a.getContext();
        Intrinsics.e(context2, "holder.itemView.context");
        ((TextView) holder.f7332a.findViewById(i8)).setText(w(context2, n8));
        View view2 = holder.f7332a;
        Intrinsics.e(view2, "holder.itemView");
        A(view2, n8);
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.history.list.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                OrderHistoryDelegate.y(OrderHistoryDelegate.this, model, view3);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: z */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderHistoryDelegate(Function1<? super Model, Unit> onItemClickListener) {
        Lazy b8;
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f29574b = onItemClickListener;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DateTimeConverter>() { // from class: ee.mtakso.driver.ui.screens.history.list.OrderHistoryDelegate$dateTimeConverter$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DateTimeConverter invoke() {
                return new DateTimeConverter(new DateTimeFormatter());
            }
        });
        this.f29575c = b8;
        this.f29576d = R.layout.item_orders_history_list;
    }

    /* compiled from: OrderHistoryDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29578a;

        /* renamed from: b  reason: collision with root package name */
        private final PreviousOrder f29579b;

        /* renamed from: c  reason: collision with root package name */
        private final DividerModel f29580c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f29581d;

        public /* synthetic */ Model(String str, PreviousOrder previousOrder, DividerModel dividerModel, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, previousOrder, (i8 & 4) != 0 ? new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null) : dividerModel, (i8 & 8) != 0 ? true : z7);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f29580c.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f29581d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29579b, model.f29579b) && Intrinsics.a(this.f29580c, model.f29580c) && e() == model.e();
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f29580c.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f29579b.hashCode()) * 31) + this.f29580c.hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f29580c.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f29580c.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f29580c.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29578a;
        }

        public final PreviousOrder n() {
            return this.f29579b;
        }

        public String toString() {
            String m8 = m();
            PreviousOrder previousOrder = this.f29579b;
            DividerModel dividerModel = this.f29580c;
            boolean e8 = e();
            return "Model(listId=" + m8 + ", order=" + previousOrder + ", divider=" + dividerModel + ", isDividerEnabled=" + e8 + ")";
        }

        public Model(String listId, PreviousOrder order, DividerModel divider, boolean z7) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(order, "order");
            Intrinsics.f(divider, "divider");
            this.f29578a = listId;
            this.f29579b = order;
            this.f29580c = divider;
            this.f29581d = z7;
        }
    }
}
