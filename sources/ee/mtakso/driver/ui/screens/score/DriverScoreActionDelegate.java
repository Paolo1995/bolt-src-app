package ee.mtakso.driver.ui.screens.score;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.score.Action;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreActionDelegate.kt */
/* loaded from: classes3.dex */
public final class DriverScoreActionDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f32879b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32880c;

    /* compiled from: DriverScoreActionDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f32884u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f32885v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f32885v = new LinkedHashMap();
            this.f32884u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f32885v;
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
            return this.f32884u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DriverScoreActionDelegate(Function1<? super Model, Unit> onButtonClicked) {
        Intrinsics.f(onButtonClicked, "onButtonClicked");
        this.f32879b = onButtonClicked;
        this.f32880c = R.layout.delegate_item_driver_score_action;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DriverScoreActionDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f32879b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f32880c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_driver_score_action, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ((TextView) holder.O(R.id.cc)).setText(model.n().c());
        ((TextView) holder.O(R.id.f19830k7)).setText(model.n().b());
        int i8 = R.id.Z0;
        ((RoundButton) holder.O(i8)).setText(model.n().a().a());
        ((RoundButton) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.score.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverScoreActionDelegate.u(DriverScoreActionDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: DriverScoreActionDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f32881a;

        /* renamed from: b  reason: collision with root package name */
        private final Action f32882b;

        /* renamed from: c  reason: collision with root package name */
        private final DividerModel f32883c;

        public /* synthetic */ Model(String str, Action action, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, action, (i8 & 4) != 0 ? new Divider(true, false, false, new Color.Res(R.color.transparent), null, Float.valueOf(Dimens.c(8.0f)), 22, null) : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f32883c.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f32883c.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f32882b, model.f32882b) && Intrinsics.a(this.f32883c, model.f32883c);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f32883c.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((m().hashCode() * 31) + this.f32882b.hashCode()) * 31) + this.f32883c.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f32883c.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f32883c.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f32883c.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f32881a;
        }

        public final Action n() {
            return this.f32882b;
        }

        public String toString() {
            String m8 = m();
            Action action = this.f32882b;
            DividerModel dividerModel = this.f32883c;
            return "Model(listId=" + m8 + ", action=" + action + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, Action action, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(action, "action");
            Intrinsics.f(divider, "divider");
            this.f32881a = listId;
            this.f32882b = action;
            this.f32883c = divider;
        }
    }
}
