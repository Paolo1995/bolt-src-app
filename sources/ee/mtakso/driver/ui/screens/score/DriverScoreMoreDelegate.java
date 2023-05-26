package ee.mtakso.driver.ui.screens.score;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreMoreDelegate.kt */
/* loaded from: classes3.dex */
public final class DriverScoreMoreDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f32933b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32934c;

    /* compiled from: DriverScoreMoreDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f32939u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f32940v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f32940v = new LinkedHashMap();
            this.f32939u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f32940v;
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
            return this.f32939u;
        }
    }

    public DriverScoreMoreDelegate(Function0<Unit> onFindOutMoreClicked) {
        Intrinsics.f(onFindOutMoreClicked, "onFindOutMoreClicked");
        this.f32933b = onFindOutMoreClicked;
        this.f32934c = R.layout.delegate_item_driver_score_more;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DriverScoreMoreDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f32933b.invoke();
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f32934c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_driver_score_more, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ((TextView) holder.O(R.id.calculationExplanation)).setText(model.n());
        int i8 = R.id.findOutMore;
        ((TextView) holder.O(i8)).setText(model.o());
        ((TextView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.score.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriverScoreMoreDelegate.u(DriverScoreMoreDelegate.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: DriverScoreMoreDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements DividerModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f32935a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32936b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32937c;

        /* renamed from: d  reason: collision with root package name */
        private final DividerModel f32938d;

        public /* synthetic */ Model(String str, String str2, String str3, DividerModel dividerModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i8 & 8) != 0 ? new Divider(true, false, false, new Color.Res(R.color.transparent), null, Float.valueOf(Dimens.c(8.0f)), 22, null) : dividerModel);
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color d() {
            return this.f32938d.d();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean e() {
            return this.f32938d.e();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f32936b, model.f32936b) && Intrinsics.a(this.f32937c, model.f32937c) && Intrinsics.a(this.f32938d, model.f32938d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Color f() {
            return this.f32938d.f();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((m().hashCode() * 31) + this.f32936b.hashCode()) * 31) + this.f32937c.hashCode()) * 31) + this.f32938d.hashCode();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public Float i() {
            return this.f32938d.i();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean j() {
            return this.f32938d.j();
        }

        @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
        public boolean k() {
            return this.f32938d.k();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f32935a;
        }

        public final String n() {
            return this.f32936b;
        }

        public final String o() {
            return this.f32937c;
        }

        public String toString() {
            String m8 = m();
            String str = this.f32936b;
            String str2 = this.f32937c;
            DividerModel dividerModel = this.f32938d;
            return "Model(listId=" + m8 + ", calculationExplanation=" + str + ", findOutMoreText=" + str2 + ", divider=" + dividerModel + ")";
        }

        public Model(String listId, String calculationExplanation, String findOutMoreText, DividerModel divider) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(calculationExplanation, "calculationExplanation");
            Intrinsics.f(findOutMoreText, "findOutMoreText");
            Intrinsics.f(divider, "divider");
            this.f32935a = listId;
            this.f32936b = calculationExplanation;
            this.f32937c = findOutMoreText;
            this.f32938d = divider;
        }
    }
}
