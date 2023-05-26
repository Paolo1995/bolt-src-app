package ee.mtakso.driver.ui.screens.order.scheduled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderTextDelegate.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderTextDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f31756b = R.layout.delegate_item_scheduled_order_details_text;

    /* compiled from: ScheduledOrderTextDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f31761u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f31762v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f31762v = new LinkedHashMap();
            this.f31761u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31762v;
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
            return this.f31761u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31756b;
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
        View inflate = inflater.inflate(R.layout.delegate_item_scheduled_order_details_text, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…ails_text, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R.id.Hb;
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.text");
        TextViewExtKt.h(textView, model.p());
        TextView textView2 = (TextView) holder.O(i8);
        Intrinsics.e(textView2, "holder.text");
        ViewExtKt.f(textView2, null, Integer.valueOf(model.o()), null, Integer.valueOf(model.n()), 5, null);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: ScheduledOrderTextDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f31757a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f31758b;

        /* renamed from: c  reason: collision with root package name */
        private final int f31759c;

        /* renamed from: d  reason: collision with root package name */
        private final int f31760d;

        public /* synthetic */ Model(String str, Text text, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, (i10 & 4) != 0 ? Dimens.c(16) : i8, (i10 & 8) != 0 ? Dimens.c(16) : i9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31758b, model.f31758b) && this.f31759c == model.f31759c && this.f31760d == model.f31760d;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Text text = this.f31758b;
            return ((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f31759c) * 31) + this.f31760d;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31757a;
        }

        public final int n() {
            return this.f31760d;
        }

        public final int o() {
            return this.f31759c;
        }

        public final Text p() {
            return this.f31758b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f31758b;
            int i8 = this.f31759c;
            int i9 = this.f31760d;
            return "Model(listId=" + m8 + ", text=" + text + ", marginTop=" + i8 + ", marginBottom=" + i9 + ")";
        }

        public Model(String listId, Text text, int i8, int i9) {
            Intrinsics.f(listId, "listId");
            this.f31757a = listId;
            this.f31758b = text;
            this.f31759c = i8;
            this.f31760d = i9;
        }
    }
}
