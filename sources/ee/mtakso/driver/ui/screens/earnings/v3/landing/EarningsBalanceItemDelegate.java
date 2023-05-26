package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.EarningsRipple;
import ee.mtakso.driver.ui.screens.earnings.v3.common.ChipModel;
import ee.mtakso.driver.ui.screens.earnings.v3.common.ChipXSRenderer;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceItemDelegate.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f29301b;

    /* renamed from: c  reason: collision with root package name */
    private final ChipXSRenderer f29302c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29303d;

    /* compiled from: EarningsBalanceItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f29304a;

        /* renamed from: b  reason: collision with root package name */
        private final Image f29305b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f29306c;

        /* renamed from: d  reason: collision with root package name */
        private final Color f29307d;

        /* renamed from: e  reason: collision with root package name */
        private final ChipModel f29308e;

        /* renamed from: f  reason: collision with root package name */
        private final Text f29309f;

        /* renamed from: g  reason: collision with root package name */
        private final Text f29310g;

        /* renamed from: h  reason: collision with root package name */
        private final String f29311h;

        public Model(String listId, Image image, Text text, Color titleColor, ChipModel chipModel, Text text2, Text text3, String str) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(titleColor, "titleColor");
            this.f29304a = listId;
            this.f29305b = image;
            this.f29306c = text;
            this.f29307d = titleColor;
            this.f29308e = chipModel;
            this.f29309f = text2;
            this.f29310g = text3;
            this.f29311h = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f29305b, model.f29305b) && Intrinsics.a(this.f29306c, model.f29306c) && Intrinsics.a(this.f29307d, model.f29307d) && Intrinsics.a(this.f29308e, model.f29308e) && Intrinsics.a(this.f29309f, model.f29309f) && Intrinsics.a(this.f29310g, model.f29310g) && Intrinsics.a(this.f29311h, model.f29311h);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            int hashCode = m().hashCode() * 31;
            Image image = this.f29305b;
            int hashCode2 = (hashCode + (image == null ? 0 : image.hashCode())) * 31;
            Text text = this.f29306c;
            int hashCode3 = (((hashCode2 + (text == null ? 0 : text.hashCode())) * 31) + this.f29307d.hashCode()) * 31;
            ChipModel chipModel = this.f29308e;
            int hashCode4 = (hashCode3 + (chipModel == null ? 0 : chipModel.hashCode())) * 31;
            Text text2 = this.f29309f;
            int hashCode5 = (hashCode4 + (text2 == null ? 0 : text2.hashCode())) * 31;
            Text text3 = this.f29310g;
            int hashCode6 = (hashCode5 + (text3 == null ? 0 : text3.hashCode())) * 31;
            String str = this.f29311h;
            return hashCode6 + (str != null ? str.hashCode() : 0);
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f29304a;
        }

        public final Text n() {
            return this.f29310g;
        }

        public final ChipModel o() {
            return this.f29308e;
        }

        public final Image p() {
            return this.f29305b;
        }

        public final String q() {
            return this.f29311h;
        }

        public final Text r() {
            return this.f29309f;
        }

        public final Text s() {
            return this.f29306c;
        }

        public final Color t() {
            return this.f29307d;
        }

        public String toString() {
            String m8 = m();
            Image image = this.f29305b;
            Text text = this.f29306c;
            Color color = this.f29307d;
            ChipModel chipModel = this.f29308e;
            Text text2 = this.f29309f;
            Text text3 = this.f29310g;
            String str = this.f29311h;
            return "Model(listId=" + m8 + ", icon=" + image + ", title=" + text + ", titleColor=" + color + ", chip=" + chipModel + ", subtitle=" + text2 + ", attention=" + text3 + ", payload=" + str + ")";
        }
    }

    /* compiled from: EarningsBalanceItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f29312u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f29313v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f29313v = new LinkedHashMap();
            this.f29312u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29313v;
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
            return this.f29312u;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsBalanceItemDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f29301b = onClick;
        this.f29302c = new ChipXSRenderer();
        this.f29303d = R.layout.delegate_item_earnings_balance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(EarningsBalanceItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f29301b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f29303d;
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
        View inflate = inflater.inflate(R.layout.delegate_item_earnings_balance, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…s_balance, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R.id.f19825a0;
        ((ImageView) holder.O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsBalanceItemDelegate.u(EarningsBalanceItemDelegate.this, model, view);
            }
        });
        EarningsRipple earningsRipple = EarningsRipple.f28765a;
        ImageView imageView = (ImageView) holder.O(i8);
        Intrinsics.e(imageView, "holder.background");
        earningsRipple.a(imageView);
        int i9 = R.id.S5;
        ImageView imageView2 = (ImageView) holder.O(i9);
        Intrinsics.e(imageView2, "holder.image");
        boolean z10 = true;
        if (model.p() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(imageView2, z7, 0, 2, null);
        Image p8 = model.p();
        if (p8 != null) {
            ImageView imageView3 = (ImageView) holder.O(i9);
            Intrinsics.e(imageView3, "holder.image");
            ImageKt.b(p8, imageView3, null, 2, null);
        }
        int i10 = R.id.cc;
        TextView textView = (TextView) holder.O(i10);
        Intrinsics.e(textView, "holder.title");
        if (model.s() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(textView, z8, 0, 2, null);
        TextView textView2 = (TextView) holder.O(i10);
        Intrinsics.e(textView2, "holder.title");
        TextViewExtKt.h(textView2, model.s());
        TextView textView3 = (TextView) holder.O(i10);
        Intrinsics.e(textView3, "holder.title");
        TextViewExtKt.i(textView3, model.t());
        ChipXSRenderer chipXSRenderer = this.f29302c;
        TextView textView4 = (TextView) holder.O(R.id.chip);
        Intrinsics.e(textView4, "holder.chip");
        chipXSRenderer.a(textView4, model.o());
        int i11 = R.id.tb;
        TextView textView5 = (TextView) holder.O(i11);
        Intrinsics.e(textView5, "holder.subtitle");
        if (model.r() != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        ViewExtKt.d(textView5, z9, 0, 2, null);
        TextView textView6 = (TextView) holder.O(i11);
        Intrinsics.e(textView6, "holder.subtitle");
        TextViewExtKt.h(textView6, model.r());
        int i12 = R.id.attention;
        TextView textView7 = (TextView) holder.O(i12);
        Intrinsics.e(textView7, "holder.attention");
        if (model.n() == null) {
            z10 = false;
        }
        ViewExtKt.d(textView7, z10, 0, 2, null);
        TextView textView8 = (TextView) holder.O(i12);
        Intrinsics.e(textView8, "holder.attention");
        TextViewExtKt.h(textView8, model.n());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
