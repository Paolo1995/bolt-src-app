package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsRipple;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsSpan;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsActivityTextItemDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsActivityTextItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29281b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29282c;

    /* compiled from: EarningsActivityTextItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29289u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f29290v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f29290v = new LinkedHashMap();
            this.f29289u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29290v;
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
            return this.f29289u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsActivityTextItemDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f29281b = onClick;
        this.f29282c = R.layout.delegate_item_earnings_activity_text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsActivityTextItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29281b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29282c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_activity_text, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        int i8 = R.id.f19825a0;
        ((ImageView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsActivityTextItemDelegate.u(EarningsActivityTextItemDelegate.this, model, view);
            }
        });
        EarningsRipple earningsRipple = EarningsRipple.f28765a;
        ImageView imageView = (ImageView) holder.O(i8);
        Intrinsics.e(imageView, "holder.background");
        earningsRipple.a(imageView);
        Text.Value q8 = model.q();
        Intrinsics.e(context, "context");
        ((TextView) holder.O(R.id.cc)).setText(TextKt.a(q8, context));
        TextView textView = (TextView) holder.O(R.id.textPrimary);
        Intrinsics.e(textView, "holder.textPrimary");
        TextViewExtKt.h(textView, model.o());
        TextView textView2 = (TextView) holder.O(R.id.textSecondary);
        Intrinsics.e(textView2, "holder.textSecondary");
        TextViewExtKt.h(textView2, model.p());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: EarningsActivityTextItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements SpanModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29283a;

        /* renamed from: b  reason: collision with root package name */
        private final Text.Value f29284b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29285c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f29286d;

        /* renamed from: e  reason: collision with root package name */
        private final String f29287e;

        /* renamed from: f  reason: collision with root package name */
        private final SpanModel f29288f;

        public /* synthetic */ Model(String str, Text.Value value, Text text, Text text2, String str2, SpanModel spanModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, value, text, text2, str2, (i8 & 32) != 0 ? EarningsSpan.f28766a : spanModel);
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int b() {
            return this.f29288f.b();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int c() {
            return this.f29288f.c();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29284b, model.f29284b) && Intrinsics.a(this.f29285c, model.f29285c) && Intrinsics.a(this.f29286d, model.f29286d) && Intrinsics.a(this.f29287e, model.f29287e) && Intrinsics.a(this.f29288f, model.f29288f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int g() {
            return this.f29288f.g();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int h() {
            return this.f29288f.h();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((m().hashCode() * 31) + this.f29284b.hashCode()) * 31) + this.f29285c.hashCode()) * 31) + this.f29286d.hashCode()) * 31;
            String str = this.f29287e;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f29288f.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29283a;
        }

        public final String n() {
            return this.f29287e;
        }

        public final Text o() {
            return this.f29285c;
        }

        public final Text p() {
            return this.f29286d;
        }

        public final Text.Value q() {
            return this.f29284b;
        }

        public String toString() {
            String m8 = m();
            Text.Value value = this.f29284b;
            Text text = this.f29285c;
            Text text2 = this.f29286d;
            String str = this.f29287e;
            SpanModel spanModel = this.f29288f;
            return "Model(listId=" + m8 + ", title=" + value + ", textPrimary=" + text + ", textSecondary=" + text2 + ", payload=" + str + ", span=" + spanModel + ")";
        }

        public Model(String listId, Text.Value title, Text textPrimary, Text textSecondary, String str, SpanModel span) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(textPrimary, "textPrimary");
            Intrinsics.f(textSecondary, "textSecondary");
            Intrinsics.f(span, "span");
            this.f29283a = listId;
            this.f29284b = title;
            this.f29285c = textPrimary;
            this.f29286d = textSecondary;
            this.f29287e = str;
            this.f29288f = span;
        }
    }
}
