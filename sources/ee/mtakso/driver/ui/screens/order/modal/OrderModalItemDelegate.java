package ee.mtakso.driver.ui.screens.order.modal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderModalItemDelegate.kt */
/* loaded from: classes3.dex */
public final class OrderModalItemDelegate<T> extends DiffAdapterDelegate<ViewHolder, Model<T>> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model<T>, Unit> f31515b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31516c;

    /* compiled from: OrderModalItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model<T> extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f31517a;

        /* renamed from: b  reason: collision with root package name */
        private final Image f31518b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f31519c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f31520d;

        /* renamed from: e  reason: collision with root package name */
        private final T f31521e;

        public Model(String listId, Image image, Text text, Text text2, T t7) {
            Intrinsics.f(listId, "listId");
            this.f31517a = listId;
            this.f31518b = image;
            this.f31519c = text;
            this.f31520d = text2;
            this.f31521e = t7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f31518b, model.f31518b) && Intrinsics.a(this.f31519c, model.f31519c) && Intrinsics.a(this.f31520d, model.f31520d) && Intrinsics.a(this.f31521e, model.f31521e);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Image image = this.f31518b;
            int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
            Text text = this.f31519c;
            int hashCode3 = (hashCode2 + (text == null ? 0 : text.hashCode())) * 31;
            Text text2 = this.f31520d;
            int hashCode4 = (hashCode3 + (text2 == null ? 0 : text2.hashCode())) * 31;
            T t7 = this.f31521e;
            return hashCode4 + (t7 != null ? t7.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f31517a;
        }

        public final Image n() {
            return this.f31518b;
        }

        public final Text o() {
            return this.f31520d;
        }

        public final T p() {
            return this.f31521e;
        }

        public final Text q() {
            return this.f31519c;
        }

        public String toString() {
            String m8 = m();
            Image image = this.f31518b;
            Text text = this.f31519c;
            Text text2 = this.f31520d;
            T t7 = this.f31521e;
            return "Model(listId=" + m8 + ", image=" + image + ", title=" + text + ", message=" + text2 + ", payload=" + t7 + ")";
        }
    }

    /* compiled from: OrderModalItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f31522u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f31523v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f31523v = new LinkedHashMap();
            this.f31522u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31523v;
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
            return this.f31522u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderModalItemDelegate(Function1<? super Model<T>, Unit> onItemClicked) {
        Intrinsics.f(onItemClicked, "onItemClicked");
        this.f31515b = onItemClicked;
        this.f31516c = R.layout.delegate_item_order_modal_item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(OrderModalItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f31515b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f31516c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_order_modal_item, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…odal_item, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model<T> model) {
        Unit unit;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ((ImageView) holder.O(R.id.f19825a0)).setOnClickListener(new View.OnClickListener() { // from class: v4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderModalItemDelegate.u(OrderModalItemDelegate.this, model, view);
            }
        });
        Image n8 = model.n();
        if (n8 != null) {
            ImageView imageView = (ImageView) holder.O(R.id.S5);
            Intrinsics.e(imageView, "holder.image");
            ImageKt.b(n8, imageView, null, 2, null);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((ImageView) holder.O(R.id.S5)).setImageDrawable(null);
        }
        TextView textView = (TextView) holder.O(R.id.cc);
        Intrinsics.e(textView, "holder.title");
        TextViewExtKt.h(textView, model.q());
        TextView textView2 = (TextView) holder.O(R.id.f19830k7);
        Intrinsics.e(textView2, "holder.message");
        TextViewExtKt.h(textView2, model.o());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
