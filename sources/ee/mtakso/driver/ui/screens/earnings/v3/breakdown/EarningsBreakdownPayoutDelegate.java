package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownPayoutDelegate;
import ee.mtakso.driver.ui.views.DynamicViewAssociatedById;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownPayoutDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownPayoutDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f28914b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28915c;

    /* compiled from: EarningsBreakdownPayoutDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f28916a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f28917b;

        /* renamed from: c  reason: collision with root package name */
        private final List<PayoutModel> f28918c;

        public Model(String listId, Text title, List<PayoutModel> history) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(history, "history");
            this.f28916a = listId;
            this.f28917b = title;
            this.f28918c = history;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f28917b, model.f28917b) && Intrinsics.a(this.f28918c, model.f28918c);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((m().hashCode() * 31) + this.f28917b.hashCode()) * 31) + this.f28918c.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f28916a;
        }

        public final List<PayoutModel> n() {
            return this.f28918c;
        }

        public final Text o() {
            return this.f28917b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f28917b;
            List<PayoutModel> list = this.f28918c;
            return "Model(listId=" + m8 + ", title=" + text + ", history=" + list + ")";
        }
    }

    /* compiled from: EarningsBreakdownPayoutDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutModel {

        /* renamed from: a  reason: collision with root package name */
        private final Text f28919a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f28920b;

        /* renamed from: c  reason: collision with root package name */
        private final Color f28921c;

        public PayoutModel(Text title, Text text, Color color) {
            Intrinsics.f(title, "title");
            this.f28919a = title;
            this.f28920b = text;
            this.f28921c = color;
        }

        public final Text a() {
            return this.f28919a;
        }

        public final Text b() {
            return this.f28920b;
        }

        public final Color c() {
            return this.f28921c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PayoutModel) {
                PayoutModel payoutModel = (PayoutModel) obj;
                return Intrinsics.a(this.f28919a, payoutModel.f28919a) && Intrinsics.a(this.f28920b, payoutModel.f28920b) && Intrinsics.a(this.f28921c, payoutModel.f28921c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f28919a.hashCode() * 31;
            Text text = this.f28920b;
            int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
            Color color = this.f28921c;
            return hashCode2 + (color != null ? color.hashCode() : 0);
        }

        public String toString() {
            Text text = this.f28919a;
            Text text2 = this.f28920b;
            Color color = this.f28921c;
            return "PayoutModel(title=" + text + ", value=" + text2 + ", valueColor=" + color + ")";
        }
    }

    /* compiled from: EarningsBreakdownPayoutDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class PayoutViewHolder implements DynamicViewAssociatedById.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f28922a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f28923b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f28924c;

        public PayoutViewHolder(View view) {
            Intrinsics.f(view, "view");
            this.f28922a = view;
            TextView textView = (TextView) getView().findViewById(R.id.payoutItemTitle);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f28923b = textView;
            TextView textView2 = (TextView) getView().findViewById(R.id.payoutItemValue);
            Intrinsics.d(textView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f28924c = textView2;
        }

        public final TextView a() {
            return this.f28923b;
        }

        public final TextView b() {
            return this.f28924c;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewAssociatedById.ViewHolder
        public View getView() {
            return this.f28922a;
        }
    }

    /* compiled from: EarningsBreakdownPayoutDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f28925u;

        /* renamed from: v  reason: collision with root package name */
        private final ImageButton f28926v;

        /* renamed from: w  reason: collision with root package name */
        private final ViewGroup f28927w;

        /* renamed from: x  reason: collision with root package name */
        private final DynamicViewAssociatedById<PayoutViewHolder> f28928x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(final View view) {
            super(view);
            List n8;
            Intrinsics.f(view, "view");
            TextView textView = (TextView) view.findViewById(R.id.earningsPayoutTitle);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f28925u = textView;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.earningsPayoutInfoButton);
            Intrinsics.d(imageButton, "null cannot be cast to non-null type android.widget.ImageButton");
            this.f28926v = imageButton;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.earningsPayoutHistory);
            Intrinsics.d(linearLayout, "null cannot be cast to non-null type android.view.ViewGroup");
            this.f28927w = linearLayout;
            DynamicViewAssociatedById.Companion companion = DynamicViewAssociatedById.f34307g;
            View findViewById = view.findViewById(R.id.earningsPayoutItem1);
            Intrinsics.e(findViewById, "view.earningsPayoutItem1");
            View findViewById2 = view.findViewById(R.id.earningsPayoutItem2);
            Intrinsics.e(findViewById2, "view.earningsPayoutItem2");
            View findViewById3 = view.findViewById(R.id.earningsPayoutItem3);
            Intrinsics.e(findViewById3, "view.earningsPayoutItem3");
            n8 = CollectionsKt__CollectionsKt.n(new PayoutViewHolder(findViewById), new PayoutViewHolder(findViewById2), new PayoutViewHolder(findViewById3));
            this.f28928x = companion.a(linearLayout, n8, new Function0<PayoutViewHolder>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownPayoutDelegate$ViewHolder$earningsPayoutHistoryViews$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final EarningsBreakdownPayoutDelegate.PayoutViewHolder invoke() {
                    View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.content_earnings_breakdown_payout_item, this.O(), false);
                    Intrinsics.e(inflate, "inflater.inflate(\n      …  false\n                )");
                    return new EarningsBreakdownPayoutDelegate.PayoutViewHolder(inflate);
                }
            });
        }

        public final ViewGroup O() {
            return this.f28927w;
        }

        public final DynamicViewAssociatedById<PayoutViewHolder> P() {
            return this.f28928x;
        }

        public final ImageButton Q() {
            return this.f28926v;
        }

        public final TextView R() {
            return this.f28925u;
        }
    }

    public EarningsBreakdownPayoutDelegate(Function0<Unit> onPayoutInfoClicked) {
        Intrinsics.f(onPayoutInfoClicked, "onPayoutInfoClicked");
        this.f28914b = onPayoutInfoClicked;
        this.f28915c = R.layout.delegate_item_earnings_breakdown_payout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsBreakdownPayoutDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f28914b.invoke();
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f28915c;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        final Context context = holder.f7332a.getContext();
        TextView R = holder.R();
        Text o8 = model.o();
        Intrinsics.e(context, "context");
        R.setText(TextKt.a(o8, context));
        holder.Q().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsBreakdownPayoutDelegate.u(EarningsBreakdownPayoutDelegate.this, view);
            }
        });
        holder.P().b(model.n().size(), new Function1<Integer, Object>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownPayoutDelegate$onBindDelegate$2
            public final Object b(int i8) {
                return Integer.valueOf(i8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return b(num.intValue());
            }
        }, new Function2<PayoutViewHolder, Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownPayoutDelegate$onBindDelegate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(EarningsBreakdownPayoutDelegate.PayoutViewHolder vh, int i8) {
                CharSequence charSequence;
                Intrinsics.f(vh, "vh");
                EarningsBreakdownPayoutDelegate.PayoutModel payoutModel = EarningsBreakdownPayoutDelegate.Model.this.n().get(i8);
                TextView a8 = vh.a();
                Text a9 = payoutModel.a();
                Context context2 = context;
                Intrinsics.e(context2, "context");
                a8.setText(TextKt.a(a9, context2));
                TextView b8 = vh.b();
                Text b9 = payoutModel.b();
                ColorStateList colorStateList = null;
                if (b9 != null) {
                    Context context3 = context;
                    Intrinsics.e(context3, "context");
                    charSequence = TextKt.a(b9, context3);
                } else {
                    charSequence = null;
                }
                b8.setText(charSequence);
                TextView b10 = vh.b();
                Color c8 = payoutModel.c();
                if (c8 != null) {
                    Context context4 = context;
                    Intrinsics.e(context4, "context");
                    colorStateList = ColorKt.b(c8, context4);
                }
                b10.setTextColor(colorStateList);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(EarningsBreakdownPayoutDelegate.PayoutViewHolder payoutViewHolder, Integer num) {
                b(payoutViewHolder, num.intValue());
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_breakdown_payout, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…wn_payout, parent, false)");
        return new ViewHolder(inflate);
    }
}
