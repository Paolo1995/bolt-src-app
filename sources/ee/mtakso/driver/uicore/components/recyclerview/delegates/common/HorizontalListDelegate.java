package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.BackgroundKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Padding;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalListDelegate.kt */
/* loaded from: classes5.dex */
public final class HorizontalListDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final List<DiffAdapterDelegate<?, ?>> f34951b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34952c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Parcelable> f34953d;

    /* compiled from: HorizontalListDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f34954a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ListModel> f34955b;

        /* renamed from: c  reason: collision with root package name */
        private final int f34956c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f34957d;

        /* renamed from: e  reason: collision with root package name */
        private final Background f34958e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f34959f;

        /* renamed from: g  reason: collision with root package name */
        private final Margins f34960g;

        /* renamed from: h  reason: collision with root package name */
        private final Padding f34961h;

        public /* synthetic */ Model(String str, List list, int i8, Color color, Background background, Text text, Margins margins, Padding padding, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, i8, (i9 & 8) != 0 ? null : color, (i9 & 16) != 0 ? null : background, (i9 & 32) != 0 ? null : text, (i9 & 64) != 0 ? null : margins, (i9 & 128) != 0 ? null : padding);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f34955b, model.f34955b) && this.f34956c == model.f34956c && Intrinsics.a(this.f34957d, model.f34957d) && Intrinsics.a(this.f34958e, model.f34958e) && Intrinsics.a(this.f34959f, model.f34959f) && Intrinsics.a(this.f34960g, model.f34960g) && Intrinsics.a(this.f34961h, model.f34961h);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = ((((m().hashCode() * 31) + this.f34955b.hashCode()) * 31) + this.f34956c) * 31;
            Color color = this.f34957d;
            int hashCode2 = (hashCode + (color == null ? 0 : color.hashCode())) * 31;
            Background background = this.f34958e;
            int hashCode3 = (hashCode2 + (background == null ? 0 : background.hashCode())) * 31;
            Text text = this.f34959f;
            int hashCode4 = (hashCode3 + (text == null ? 0 : text.hashCode())) * 31;
            Margins margins = this.f34960g;
            int hashCode5 = (hashCode4 + (margins == null ? 0 : margins.hashCode())) * 31;
            Padding padding = this.f34961h;
            return hashCode5 + (padding != null ? padding.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f34954a;
        }

        public final Background n() {
            return this.f34958e;
        }

        public final Color o() {
            return this.f34957d;
        }

        public final int p() {
            return this.f34956c;
        }

        public final Margins q() {
            return this.f34960g;
        }

        public final List<ListModel> r() {
            return this.f34955b;
        }

        public final Padding s() {
            return this.f34961h;
        }

        public final Text t() {
            return this.f34959f;
        }

        public String toString() {
            String m8 = m();
            List<ListModel> list = this.f34955b;
            int i8 = this.f34956c;
            Color color = this.f34957d;
            Background background = this.f34958e;
            Text text = this.f34959f;
            Margins margins = this.f34960g;
            Padding padding = this.f34961h;
            return "Model(listId=" + m8 + ", models=" + list + ", itemHeight=" + i8 + ", backgroundColor=" + color + ", background=" + background + ", title=" + text + ", margins=" + margins + ", padding=" + padding + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(String listId, List<? extends ListModel> models, int i8, Color color, Background background, Text text, Margins margins, Padding padding) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(models, "models");
            this.f34954a = listId;
            this.f34955b = models;
            this.f34956c = i8;
            this.f34957d = color;
            this.f34958e = background;
            this.f34959f = text;
            this.f34960g = margins;
            this.f34961h = padding;
        }
    }

    /* compiled from: HorizontalListDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final RecyclerView f34962u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f34963v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R$id.f34595f0);
            Intrinsics.d(recyclerView, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            this.f34962u = recyclerView;
            TextView textView = (TextView) itemView.findViewById(R$id.D0);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f34963v = textView;
        }

        public final RecyclerView O() {
            return this.f34962u;
        }

        public final TextView P() {
            return this.f34963v;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalListDelegate(List<? extends DiffAdapterDelegate<?, ?>> innerDelegates) {
        Intrinsics.f(innerDelegates, "innerDelegates");
        this.f34951b = innerDelegates;
        this.f34952c = R$layout.delegate_horizontal_list;
        this.f34953d = new LinkedHashMap();
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f34952c;
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
        View v7 = inflater.inflate(e(), parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        RecyclerView O = holder.O();
        ViewGroup.LayoutParams layoutParams = O.getLayoutParams();
        layoutParams.height = model.p();
        O.setLayoutParams(layoutParams);
        DiffAdapter diffAdapter = new DiffAdapter();
        for (DiffAdapterDelegate<?, ?> diffAdapterDelegate : this.f34951b) {
            diffAdapter.P(diffAdapterDelegate);
        }
        DiffAdapter.V(diffAdapter, model.r(), null, 2, null);
        O.setAdapter(diffAdapter);
        O.setLayoutManager(new LinearLayoutManager(O.getContext(), 0, false));
        Parcelable parcelable = this.f34953d.get(model.m());
        if (parcelable != null) {
            RecyclerView.LayoutManager layoutManager = O.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.l1(parcelable);
            }
        } else {
            RecyclerView.LayoutManager layoutManager2 = O.getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.H1(0);
            }
        }
        Background n8 = model.n();
        if (n8 != null) {
            View view = holder.f7332a;
            Context context = view.getContext();
            Intrinsics.e(context, "holder.itemView.context");
            view.setBackgroundResource(BackgroundKt.a(n8, context));
        }
        Color o8 = model.o();
        if (o8 != null) {
            View view2 = holder.f7332a;
            Context context2 = view2.getContext();
            Intrinsics.e(context2, "holder.itemView.context");
            view2.setBackgroundColor(ColorKt.a(o8, context2));
        }
        TextView P = holder.P();
        if (model.t() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(P, z7, 0, 2, null);
        Text t7 = model.t();
        if (t7 != null) {
            TextView P2 = holder.P();
            Context context3 = holder.P().getContext();
            Intrinsics.e(context3, "holder.title.context");
            P2.setText(TextKt.a(t7, context3));
        }
        Margins q8 = model.q();
        if (q8 != null) {
            View view3 = holder.f7332a;
            Intrinsics.e(view3, "holder.itemView");
            ViewExtKt.e(view3, Integer.valueOf(q8.b()), Integer.valueOf(q8.d()), Integer.valueOf(q8.c()), Integer.valueOf(q8.a()));
        }
        Padding s7 = model.s();
        if (s7 != null) {
            View view4 = holder.f7332a;
            Intrinsics.e(view4, "holder.itemView");
            view4.setPadding(s7.b(), s7.d(), s7.c(), s7.a());
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void m(ViewHolder holder, Model model) {
        Parcelable parcelable;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        super.m(holder, model);
        Map<String, Parcelable> map = this.f34953d;
        String m8 = model.m();
        RecyclerView.LayoutManager layoutManager = holder.O().getLayoutManager();
        if (layoutManager != null) {
            parcelable = layoutManager.m1();
        } else {
            parcelable = null;
        }
        map.put(m8, parcelable);
    }
}
