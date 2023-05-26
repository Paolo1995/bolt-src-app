package ee.mtakso.driver.ui.screens.navigator_chooser.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.navigator_chooser.list.NavigationDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationDelegate.kt */
/* loaded from: classes3.dex */
public final class NavigationDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<NavigationOption, Unit> f30949b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30950c;

    /* compiled from: NavigationDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f30951a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f30952b;

        /* renamed from: c  reason: collision with root package name */
        private final DividerModel f30953c;

        /* renamed from: d  reason: collision with root package name */
        private final NavigationOption f30954d;

        public Model(String listId, boolean z7, DividerModel divider, NavigationOption payload) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(divider, "divider");
            Intrinsics.f(payload, "payload");
            this.f30951a = listId;
            this.f30952b = z7;
            this.f30953c = divider;
            this.f30954d = payload;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f30953c.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f30953c.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f30952b == model.f30952b && Intrinsics.a(this.f30953c, model.f30953c) && Intrinsics.a(this.f30954d, model.f30954d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f30953c.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            boolean z7 = this.f30952b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((((hashCode + i8) * 31) + this.f30953c.hashCode()) * 31) + this.f30954d.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f30953c.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f30953c.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f30953c.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f30951a;
        }

        public final NavigationOption n() {
            return this.f30954d;
        }

        public final boolean o() {
            return this.f30952b;
        }

        public String toString() {
            String m8 = m();
            boolean z7 = this.f30952b;
            DividerModel dividerModel = this.f30953c;
            NavigationOption navigationOption = this.f30954d;
            return "Model(listId=" + m8 + ", isSelected=" + z7 + ", divider=" + dividerModel + ", payload=" + navigationOption + ")";
        }
    }

    /* compiled from: NavigationDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f30955u;

        /* renamed from: v  reason: collision with root package name */
        private final Chip f30956v;

        /* renamed from: w  reason: collision with root package name */
        private final RadioButton f30957w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.navigatorChooserListItemTitle);
            Intrinsics.e(textView, "itemView.navigatorChooserListItemTitle");
            this.f30955u = textView;
            Chip chip = (Chip) itemView.findViewById(R.id.navigatorChooserListItemRecommendBadge);
            Intrinsics.e(chip, "itemView.navigatorChooserListItemRecommendBadge");
            this.f30956v = chip;
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) itemView.findViewById(R.id.navigatorChooserListItemRadioButton);
            Intrinsics.e(appCompatRadioButton, "itemView.navigatorChooserListItemRadioButton");
            this.f30957w = appCompatRadioButton;
        }

        public final RadioButton O() {
            return this.f30957w;
        }

        public final Chip P() {
            return this.f30956v;
        }

        public final TextView Q() {
            return this.f30955u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NavigationDelegate(Function1<? super NavigationOption, Unit> onItemClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f30949b = onItemClickListener;
        this.f30950c = R.layout.item_selector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(NavigationDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f30949b.invoke(model.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(NavigationDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f30949b.invoke(model.n());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f30950c;
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
        View view = inflater.inflate(R.layout.item_selector, parent, false);
        Intrinsics.e(view, "view");
        return new ViewHolder(view);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.Q().setText(model.n().getName());
        ViewExtKt.d(holder.P(), model.n().getRecommended(), 0, 2, null);
        holder.O().setChecked(model.o());
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: n4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationDelegate.v(NavigationDelegate.this, model, view);
            }
        });
        holder.O().setOnClickListener(new View.OnClickListener() { // from class: n4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationDelegate.w(NavigationDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: x */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
