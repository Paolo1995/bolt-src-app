package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsRipple;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsSpan;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
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

/* compiled from: EarningsActivityTextWithImageItemDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsActivityTextWithImageItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29291b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29292c;

    /* compiled from: EarningsActivityTextWithImageItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29299u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f29300v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f29300v = new LinkedHashMap();
            this.f29299u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29300v;
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
            return this.f29299u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsActivityTextWithImageItemDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f29291b = onClick;
        this.f29292c = R.layout.delegate_item_earnings_activity_text_with_image;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsActivityTextWithImageItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29291b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29292c;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_activity_text_with_image, parent, false);
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
        ((ImageView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsActivityTextWithImageItemDelegate.u(EarningsActivityTextWithImageItemDelegate.this, model, view);
            }
        });
        EarningsRipple earningsRipple = EarningsRipple.f28765a;
        ImageView imageView = (ImageView) holder.O(i8);
        Intrinsics.e(imageView, "holder.background");
        earningsRipple.a(imageView);
        Text.Value q8 = model.q();
        Intrinsics.e(context, "context");
        ((TextView) holder.O(R.id.cc)).setText(TextKt.a(q8, context));
        TextView textView = (TextView) holder.O(R.id.Hb);
        Intrinsics.e(textView, "holder.text");
        TextViewExtKt.h(textView, model.p());
        Image n8 = model.n();
        if (n8 != null) {
            ImageFilterView imageFilterView = (ImageFilterView) holder.O(R.id.S5);
            Intrinsics.e(imageFilterView, "holder.image");
            ImageKt.b(n8, imageFilterView, null, 2, null);
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* compiled from: EarningsActivityTextWithImageItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel implements SpanModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29293a;

        /* renamed from: b  reason: collision with root package name */
        private final Text.Value f29294b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29295c;

        /* renamed from: d  reason: collision with root package name */
        private final Image f29296d;

        /* renamed from: e  reason: collision with root package name */
        private final String f29297e;

        /* renamed from: f  reason: collision with root package name */
        private final SpanModel f29298f;

        public /* synthetic */ Model(String str, Text.Value value, Text text, Image image, String str2, SpanModel spanModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, value, text, image, str2, (i8 & 32) != 0 ? EarningsSpan.f28766a : spanModel);
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int b() {
            return this.f29298f.b();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int c() {
            return this.f29298f.c();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29294b, model.f29294b) && Intrinsics.a(this.f29295c, model.f29295c) && Intrinsics.a(this.f29296d, model.f29296d) && Intrinsics.a(this.f29297e, model.f29297e) && Intrinsics.a(this.f29298f, model.f29298f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int g() {
            return this.f29298f.g();
        }

        @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpanModel
        public int h() {
            return this.f29298f.h();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f29294b.hashCode()) * 31) + this.f29295c.hashCode()) * 31;
            Image image = this.f29296d;
            int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
            String str = this.f29297e;
            return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f29298f.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29293a;
        }

        public final Image n() {
            return this.f29296d;
        }

        public final String o() {
            return this.f29297e;
        }

        public final Text p() {
            return this.f29295c;
        }

        public final Text.Value q() {
            return this.f29294b;
        }

        public String toString() {
            String m8 = m();
            Text.Value value = this.f29294b;
            Text text = this.f29295c;
            Image image = this.f29296d;
            String str = this.f29297e;
            SpanModel spanModel = this.f29298f;
            return "Model(listId=" + m8 + ", title=" + value + ", text=" + text + ", image=" + image + ", payload=" + str + ", span=" + spanModel + ")";
        }

        public Model(String listId, Text.Value title, Text text, Image image, String str, SpanModel span) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(text, "text");
            Intrinsics.f(span, "span");
            this.f29293a = listId;
            this.f29294b = title;
            this.f29295c = text;
            this.f29296d = image;
            this.f29297e = str;
            this.f29298f = span;
        }
    }
}
