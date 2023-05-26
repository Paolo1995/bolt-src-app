package ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationHeaderItemDelegate.kt */
/* loaded from: classes5.dex */
public final class NavigationHeaderItemDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f33227b = R.layout.item_navigator_header;

    /* compiled from: NavigationHeaderItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f33228a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f33229b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f33230c;

        /* renamed from: d  reason: collision with root package name */
        private final int f33231d;

        public /* synthetic */ Model(String str, Text text, Text text2, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, text, text2, (i9 & 8) != 0 ? 8 : i8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f33229b, model.f33229b) && Intrinsics.a(this.f33230c, model.f33230c) && this.f33231d == model.f33231d;
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((m().hashCode() * 31) + this.f33229b.hashCode()) * 31) + this.f33230c.hashCode()) * 31) + this.f33231d;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f33228a;
        }

        public final int n() {
            return this.f33231d;
        }

        public final Text o() {
            return this.f33230c;
        }

        public final Text p() {
            return this.f33229b;
        }

        public String toString() {
            String m8 = m();
            Text text = this.f33229b;
            Text text2 = this.f33230c;
            int i8 = this.f33231d;
            return "Model(listId=" + m8 + ", title=" + text + ", subTitle=" + text2 + ", marginTopToDp=" + i8 + ")";
        }

        public Model(String listId, Text title, Text subTitle, int i8) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(subTitle, "subTitle");
            this.f33228a = listId;
            this.f33229b = title;
            this.f33230c = subTitle;
            this.f33231d = i8;
        }
    }

    /* compiled from: NavigationHeaderItemDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f33232u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f33233v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f33233v = new LinkedHashMap();
            this.f33232u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f33233v;
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
            return this.f33232u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f33227b;
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
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        int i8 = R.id.cc;
        TextView textView = (TextView) holder.O(i8);
        Intrinsics.e(textView, "holder.title");
        ViewExtKt.f(textView, null, Integer.valueOf(model.n()), null, null, 13, null);
        Text p8 = model.p();
        Context context = holder.P().getContext();
        Intrinsics.e(context, "holder.containerView.context");
        ((TextView) holder.O(i8)).setText(TextKt.a(p8, context));
        Text o8 = model.o();
        Context context2 = holder.P().getContext();
        Intrinsics.e(context2, "holder.containerView.context");
        ((TextView) holder.O(R.id.tb)).setText(TextKt.a(o8, context2));
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
