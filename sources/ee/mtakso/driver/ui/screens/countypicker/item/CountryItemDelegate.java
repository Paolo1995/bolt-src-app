package ee.mtakso.driver.ui.screens.countypicker.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.country.Country;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountryItemDelegate.kt */
/* loaded from: classes3.dex */
public final class CountryItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Model, Unit> f28130b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28131c;

    /* compiled from: CountryItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f28133a;

        /* renamed from: b  reason: collision with root package name */
        private final Country f28134b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f28135c;

        /* renamed from: d  reason: collision with root package name */
        private final Text f28136d;

        /* renamed from: e  reason: collision with root package name */
        private final Image f28137e;

        public /* synthetic */ Model(String str, Country country, Text text, Text text2, Image image, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "" : str, country, text, text2, image);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && this.f28134b == model.f28134b && Intrinsics.a(this.f28135c, model.f28135c) && Intrinsics.a(this.f28136d, model.f28136d) && Intrinsics.a(this.f28137e, model.f28137e);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((((m().hashCode() * 31) + this.f28134b.hashCode()) * 31) + this.f28135c.hashCode()) * 31) + this.f28136d.hashCode()) * 31) + this.f28137e.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f28133a;
        }

        public final Country n() {
            return this.f28134b;
        }

        public final Text o() {
            return this.f28136d;
        }

        public final Text p() {
            return this.f28135c;
        }

        public final Image q() {
            return this.f28137e;
        }

        public String toString() {
            String m8 = m();
            Country country = this.f28134b;
            Text text = this.f28135c;
            Text text2 = this.f28136d;
            Image image = this.f28137e;
            return "Model(listId=" + m8 + ", country=" + country + ", countryName=" + text + ", countryCode=" + text2 + ", flag=" + image + ")";
        }

        public Model(String listId, Country country, Text countryName, Text countryCode, Image flag) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(country, "country");
            Intrinsics.f(countryName, "countryName");
            Intrinsics.f(countryCode, "countryCode");
            Intrinsics.f(flag, "flag");
            this.f28133a = listId;
            this.f28134b = country;
            this.f28135c = countryName;
            this.f28136d = countryCode;
            this.f28137e = flag;
        }
    }

    /* compiled from: CountryItemDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f28138u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f28139v;

        /* renamed from: w  reason: collision with root package name */
        private final ImageView f28140w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
            TextView textView = (TextView) view.findViewById(R.id.Y2);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f28138u = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.O8);
            Intrinsics.d(textView2, "null cannot be cast to non-null type android.widget.TextView");
            this.f28139v = textView2;
            ImageView imageView = (ImageView) view.findViewById(R.id.X2);
            Intrinsics.d(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f28140w = imageView;
        }

        public final ImageView O() {
            return this.f28140w;
        }

        public final TextView P() {
            return this.f28138u;
        }

        public final TextView Q() {
            return this.f28139v;
        }
    }

    public CountryItemDelegate() {
        this(null, 1, null);
    }

    public /* synthetic */ CountryItemDelegate(Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new Function1<Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.countypicker.item.CountryItemDelegate.1
            public final void b(Model it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Model model) {
                b(model);
                return Unit.f50853a;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(CountryItemDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f28130b.invoke(model);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f28131c;
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
        View inflate = inflater.inflate(R.layout.country_picker_item, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(R.layou…cker_item, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        Context context = holder.P().getContext();
        TextView P = holder.P();
        Text p8 = model.p();
        Intrinsics.e(context, "context");
        P.setText(TextKt.a(p8, context));
        holder.Q().setText(TextKt.a(model.o(), context));
        ImageKt.b(model.q(), holder.O(), null, 2, null);
        holder.f7332a.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.countypicker.item.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CountryItemDelegate.u(CountryItemDelegate.this, model, view);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        View itemView = holder.f7332a;
        Intrinsics.e(itemView, "itemView");
        RippleProvider.b(rippleProvider, itemView, ColorKt.a(new Color.Attr(R.attr.backPrimary), context), 0, 2, null);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CountryItemDelegate(Function1<? super Model, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        this.f28130b = onClick;
        this.f28131c = R.layout.country_picker_item;
    }
}
