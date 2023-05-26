package ee.mtakso.driver.ui.screens.order.scheduled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderLinkDelegate.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderLinkDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f31745b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31746c;

    /* compiled from: ScheduledOrderLinkDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f31747a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f31748b;

        /* renamed from: c  reason: collision with root package name */
        private final String f31749c;

        public Model(String listId, Text text, String url) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(url, "url");
            this.f31747a = listId;
            this.f31748b = text;
            this.f31749c = url;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31748b, model.f31748b) && Intrinsics.a(this.f31749c, model.f31749c);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f31748b;
            return ((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f31749c.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31747a;
        }

        public final Text n() {
            return this.f31748b;
        }

        public final String o() {
            return this.f31749c;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f31748b;
            String str = this.f31749c;
            return "Model(listId=" + m8 + ", text=" + text + ", url=" + str + ")";
        }
    }

    /* compiled from: ScheduledOrderLinkDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f31750u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f31751v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f31751v = new LinkedHashMap();
            this.f31750u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31751v;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View P = P();
                if (P == null || (findViewById = P.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }

        public View P() {
            return this.f31750u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduledOrderLinkDelegate(Function1<? super Model, Unit> onClicked) {
        Intrinsics.f(onClicked, "onClicked");
        this.f31745b = onClicked;
        this.f31746c = R.layout.delegate_item_scheduled_order_details_link;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ScheduledOrderLinkDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f31745b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31746c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_scheduled_order_details_link, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…ails_link, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R.id.Hb;
        ((TextView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduledOrderLinkDelegate.u(ScheduledOrderLinkDelegate.this, model, view);
            }
        });
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.text");
        TextViewExtKt.h(textView, model.n());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
