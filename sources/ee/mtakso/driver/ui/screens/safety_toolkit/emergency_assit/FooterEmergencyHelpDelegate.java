package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FooterEmergencyHelpDelegate.kt */
/* loaded from: classes3.dex */
public final class FooterEmergencyHelpDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f32728b = R.layout.item_footer_emergency_help;

    /* compiled from: FooterEmergencyHelpDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f32729a;

        /* renamed from: b  reason: collision with root package name */
        private final EmergencyAssistFooterData f32730b;

        public Model(String listId, EmergencyAssistFooterData emergencyAssistFooterData) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(emergencyAssistFooterData, "emergencyAssistFooterData");
            this.f32729a = listId;
            this.f32730b = emergencyAssistFooterData;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f32730b, model.f32730b);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (m().hashCode() * 31) + this.f32730b.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f32729a;
        }

        public final EmergencyAssistFooterData n() {
            return this.f32730b;
        }

        public String toString() {
            String m8 = m();
            EmergencyAssistFooterData emergencyAssistFooterData = this.f32730b;
            return "Model(listId=" + m8 + ", emergencyAssistFooterData=" + emergencyAssistFooterData + ")";
        }
    }

    /* compiled from: FooterEmergencyHelpDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.f(view, "view");
        }
    }

    private final void u(ViewHolder viewHolder, boolean z7) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewHolder.f7332a.findViewById(R.id.logo);
        Intrinsics.e(appCompatImageView, "holder.itemView.logo");
        ViewExtKt.d(appCompatImageView, z7, 0, 2, null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewHolder.f7332a.findViewById(R.id.f19836t6);
        Intrinsics.e(appCompatTextView, "holder.itemView.keyText");
        ViewExtKt.d(appCompatTextView, z7, 0, 2, null);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f32728b;
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
        View v7 = inflater.inflate(R.layout.item_footer_emergency_help, parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: s */
    public void g(ViewHolder holder, Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        EmergencyAssistFooterData n8 = model.n();
        if (n8.b() != null) {
            u(holder, true);
            Image b8 = n8.b();
            AppCompatImageView appCompatImageView = (AppCompatImageView) holder.f7332a.findViewById(R.id.logo);
            Intrinsics.e(appCompatImageView, "holder.itemView.logo");
            ImageKt.b(b8, appCompatImageView, null, 2, null);
            AppCompatTextView appCompatTextView = (AppCompatTextView) holder.f7332a.findViewById(R.id.f19836t6);
            Intrinsics.e(appCompatTextView, "holder.itemView.keyText");
            TextViewExtKt.h(appCompatTextView, n8.a());
            return;
        }
        u(holder, false);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
