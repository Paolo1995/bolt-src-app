package ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates.SelectorDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectorDelegate.kt */
/* loaded from: classes5.dex */
public final class SelectorDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f33234b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33235c;

    /* compiled from: SelectorDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f33236a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f33237b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f33238c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f33239d;

        public Model(String listId, Text title, boolean z7, boolean z8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            this.f33236a = listId;
            this.f33237b = title;
            this.f33238c = z7;
            this.f33239d = z8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f33237b, model.f33237b) && this.f33238c == model.f33238c && this.f33239d == model.f33239d;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((m().hashCode() * 31) + this.f33237b.hashCode()) * 31;
            boolean z7 = this.f33238c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean z8 = this.f33239d;
            return i9 + (z8 ? 1 : z8 ? 1 : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f33236a;
        }

        public final Text n() {
            return this.f33237b;
        }

        public final boolean o() {
            return this.f33239d;
        }

        public final boolean p() {
            return this.f33238c;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f33237b;
            boolean z7 = this.f33238c;
            boolean z8 = this.f33239d;
            return "Model(listId=" + m8 + ", title=" + text + ", isSelected=" + z7 + ", isRecommended=" + z8 + ")";
        }
    }

    /* compiled from: SelectorDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f33240u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f33241v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f33241v = new LinkedHashMap();
            this.f33240u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f33241v;
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
            return this.f33240u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectorDelegate(Function1<? super Model, Unit> onItemClicked) {
        Intrinsics.f(onItemClicked, "onItemClicked");
        this.f33234b = onItemClicked;
        this.f33235c = R.layout.item_selector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(SelectorDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f33234b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f33235c;
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
        View inflate = inflater.inflate(e(), parent, false);
        Intrinsics.e(inflate, "inflater.inflate(type, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        int i8;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Text n8 = model.n();
        Context context = holder.P().getContext();
        Intrinsics.e(context, "holder.containerView.context");
        ((TextView) holder.O(R.id.navigatorChooserListItemTitle)).setText(TextKt.a(n8, context));
        Chip chip = (Chip) holder.O(R.id.navigatorChooserListItemRecommendBadge);
        Intrinsics.e(chip, "holder.navigatorChooserListItemRecommendBadge");
        if (model.o()) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        chip.setVisibility(i8);
        ((AppCompatRadioButton) holder.O(R.id.navigatorChooserListItemRadioButton)).setChecked(model.p());
        holder.P().setOnClickListener(new View.OnClickListener() { // from class: c5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectorDelegate.u(SelectorDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
