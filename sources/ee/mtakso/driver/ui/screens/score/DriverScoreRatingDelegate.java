package ee.mtakso.driver.ui.screens.score;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreRatingDelegate.kt */
/* loaded from: classes3.dex */
public final class DriverScoreRatingDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f32941b = R.layout.delegate_item_driver_score_rating;

    /* compiled from: DriverScoreRatingDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f32942a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32943b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32944c;

        /* renamed from: d  reason: collision with root package name */
        private final String f32945d;

        public Model(String listId, String title, String description, String value) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(title, "title");
            Intrinsics.f(description, "description");
            Intrinsics.f(value, "value");
            this.f32942a = listId;
            this.f32943b = title;
            this.f32944c = description;
            this.f32945d = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f32943b, model.f32943b) && Intrinsics.a(this.f32944c, model.f32944c) && Intrinsics.a(this.f32945d, model.f32945d);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((m().hashCode() * 31) + this.f32943b.hashCode()) * 31) + this.f32944c.hashCode()) * 31) + this.f32945d.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f32942a;
        }

        public final String n() {
            return this.f32944c;
        }

        public final String o() {
            return this.f32943b;
        }

        public final String p() {
            return this.f32945d;
        }

        public String toString() {
            String m8 = m();
            String str = this.f32943b;
            String str2 = this.f32944c;
            String str3 = this.f32945d;
            return "Model(listId=" + m8 + ", title=" + str + ", description=" + str2 + ", value=" + str3 + ")";
        }
    }

    /* compiled from: DriverScoreRatingDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f32946u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f32947v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f32947v = new LinkedHashMap();
            this.f32946u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f32947v;
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
            return this.f32946u;
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f32941b;
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
        View inflate = inflater.inflate(R.layout.delegate_item_driver_score_rating, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ((TextView) holder.O(R.id.ratingTitle)).setText(model.o());
        ((TextView) holder.O(R.id.ratingDescription)).setText(model.n());
        ((TextView) holder.O(R.id.ratingValue)).setText(model.p());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
