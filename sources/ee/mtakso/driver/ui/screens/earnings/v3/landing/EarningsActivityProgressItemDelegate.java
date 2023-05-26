package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsRipple;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsSpan;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
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

/* compiled from: EarningsActivityProgressItemDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsActivityProgressItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29270b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29271c;

    /* compiled from: EarningsActivityProgressItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29279u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f29280v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f29280v = new LinkedHashMap();
            this.f29279u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29280v;
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
            return this.f29279u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsActivityProgressItemDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f29270b = onClick;
        this.f29271c = R.layout.delegate_item_earnings_activity_progress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsActivityProgressItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29270b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29271c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_activity_progress, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        int b8;
        int b9;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.f7332a.getContext();
        int i8 = R.id.f19825a0;
        ((ImageView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsActivityProgressItemDelegate.u(EarningsActivityProgressItemDelegate.this, model, view);
            }
        });
        EarningsRipple earningsRipple = EarningsRipple.f28765a;
        ImageView imageView = (ImageView) holder.O(i8);
        Intrinsics.e(imageView, "holder.background");
        earningsRipple.a(imageView);
        Text.Value r7 = model.r();
        Intrinsics.e(context, "context");
        ((TextView) holder.O(R.id.cc)).setText(TextKt.a(r7, context));
        TextView textView = (TextView) holder.O(R.id.textPrimary);
        Intrinsics.e(textView, "holder.textPrimary");
        TextViewExtKt.h(textView, model.p());
        TextView textView2 = (TextView) holder.O(R.id.textSecondary);
        Intrinsics.e(textView2, "holder.textSecondary");
        TextViewExtKt.h(textView2, model.q());
        int i9 = R.id.n9;
        ((LinearProgressIndicator) holder.O(i9)).setProgress((int) (((LinearProgressIndicator) holder.O(i9)).getMax() * model.o()));
        if (model.o() == 1.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            b8 = ContextUtilsKt.b(context, R.attr.dynamicGreen01);
            b9 = ContextUtilsKt.b(context, R.attr.dynamicGreen01);
        } else {
            b8 = ContextUtilsKt.b(context, R.attr.dynamicPurple02);
            b9 = ContextUtilsKt.b(context, R.attr.dynamicNeutral02);
        }
        ((LinearProgressIndicator) holder.O(i9)).setIndicatorColor(b8);
        ViewCompat.x0((ImageView) holder.O(R.id.progressImage), ColorStateList.valueOf(b9));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: EarningsActivityProgressItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements SpanModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29272a;

        /* renamed from: b  reason: collision with root package name */
        private final Text.Value f29273b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29274c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f29275d;

        /* renamed from: e  reason: collision with root package name */
        private final float f29276e;

        /* renamed from: f  reason: collision with root package name */
        private final String f29277f;

        /* renamed from: g  reason: collision with root package name */
        private final SpanModel f29278g;

        public /* synthetic */ Model(String str, Text.Value value, Text text, Text text2, float f8, String str2, SpanModel spanModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, value, text, text2, f8, str2, (i8 & 64) != 0 ? EarningsSpan.f28766a : spanModel);
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int b() {
            return this.f29278g.b();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int c() {
            return this.f29278g.c();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29273b, model.f29273b) && Intrinsics.a(this.f29274c, model.f29274c) && Intrinsics.a(this.f29275d, model.f29275d) && Float.compare(this.f29276e, model.f29276e) == 0 && Intrinsics.a(this.f29277f, model.f29277f) && Intrinsics.a(this.f29278g, model.f29278g);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int g() {
            return this.f29278g.g();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int h() {
            return this.f29278g.h();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((((((m().hashCode() * 31) + this.f29273b.hashCode()) * 31) + this.f29274c.hashCode()) * 31) + this.f29275d.hashCode()) * 31) + Float.floatToIntBits(this.f29276e)) * 31;
            String str = this.f29277f;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f29278g.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29272a;
        }

        public final String n() {
            return this.f29277f;
        }

        public final float o() {
            return this.f29276e;
        }

        public final Text p() {
            return this.f29274c;
        }

        public final Text q() {
            return this.f29275d;
        }

        public final Text.Value r() {
            return this.f29273b;
        }

        public String toString() {
            String m8 = m();
            Text.Value value = this.f29273b;
            Text text = this.f29274c;
            Text text2 = this.f29275d;
            float f8 = this.f29276e;
            String str = this.f29277f;
            SpanModel spanModel = this.f29278g;
            return "Model(listId=" + m8 + ", title=" + value + ", textPrimary=" + text + ", textSecondary=" + text2 + ", progress=" + f8 + ", payload=" + str + ", span=" + spanModel + ")";
        }

        public Model(String listId, Text.Value title, Text textPrimary, Text textSecondary, float f8, String str, SpanModel span) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(textPrimary, "textPrimary");
            Intrinsics.f(textSecondary, "textSecondary");
            Intrinsics.f(span, "span");
            this.f29272a = listId;
            this.f29273b = title;
            this.f29274c = textPrimary;
            this.f29275d = textSecondary;
            this.f29276e = f8;
            this.f29277f = str;
            this.f29278g = span;
        }
    }
}
