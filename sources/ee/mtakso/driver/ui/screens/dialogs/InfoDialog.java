package ee.mtakso.driver.ui.screens.dialogs;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.ui.screens.dialogs.InfoDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoDialog.kt */
/* loaded from: classes3.dex */
public final class InfoDialog extends BaseDialogFragment {

    /* renamed from: n */
    public static final Companion f28307n = new Companion(null);

    /* renamed from: m */
    public Map<Integer, View> f28308m = new LinkedHashMap();

    /* compiled from: InfoDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InfoDialog b(Companion companion, String str, String str2, String str3, Integer num, Function3 function3, int i8, Object obj) {
            Function3<? super DialogFragment, ? super View, Object, Unit> function32 = function3;
            if ((i8 & 16) != 0) {
                function32 = null;
            }
            return companion.a(str, str2, str3, num, function32);
        }

        public final InfoDialog a(String str, String str2, String dismissText, Integer num, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
            Intrinsics.f(dismissText, "dismissText");
            Bundle bundle = new Bundle();
            bundle.putParcelable("CONFIG_KEY", new Model(num, str, str2, dismissText));
            InfoDialog infoDialog = new InfoDialog();
            infoDialog.setArguments(bundle);
            infoDialog.K(function3);
            return infoDialog;
        }
    }

    /* compiled from: InfoDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f */
        private final Integer f28309f;

        /* renamed from: g */
        private final String f28310g;

        /* renamed from: h */
        private final String f28311h;

        /* renamed from: i */
        private final String f28312i;

        /* compiled from: InfoDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Model(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(Integer num, String str, String str2, String dismissText) {
            Intrinsics.f(dismissText, "dismissText");
            this.f28309f = num;
            this.f28310g = str;
            this.f28311h = str2;
            this.f28312i = dismissText;
        }

        public final String a() {
            return this.f28312i;
        }

        public final Integer b() {
            return this.f28309f;
        }

        public final String c() {
            return this.f28311h;
        }

        public final String d() {
            return this.f28310g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f28309f, model.f28309f) && Intrinsics.a(this.f28310g, model.f28310g) && Intrinsics.a(this.f28311h, model.f28311h) && Intrinsics.a(this.f28312i, model.f28312i);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f28309f;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.f28310g;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f28311h;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f28312i.hashCode();
        }

        public String toString() {
            Integer num = this.f28309f;
            String str = this.f28310g;
            String str2 = this.f28311h;
            String str3 = this.f28312i;
            return "Model(drawableResourceId=" + num + ", title=" + str + ", message=" + str2 + ", dismissText=" + str3 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            int intValue;
            Intrinsics.f(out, "out");
            Integer num = this.f28309f;
            if (num == null) {
                intValue = 0;
            } else {
                out.writeInt(1);
                intValue = num.intValue();
            }
            out.writeInt(intValue);
            out.writeString(this.f28310g);
            out.writeString(this.f28311h);
            out.writeString(this.f28312i);
        }
    }

    public static final void Q(InfoDialog this$0, View view) {
        Unit unit;
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "dismiss");
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            Kalev.d("on item click");
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28308m.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28308m;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public void O(ViewGroup container, Bundle bundle) {
        Model model;
        Intrinsics.f(container, "container");
        Bundle arguments = getArguments();
        if (arguments != null) {
            model = (Model) arguments.getParcelable("CONFIG_KEY");
        } else {
            model = null;
        }
        if (model == null) {
            Kalev.e(new IllegalArgumentException(), "No config passed for dialog -> closing");
            dismiss();
            return;
        }
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        Integer b8 = model.b();
        if (b8 != null) {
            ItemViewFactory.g(itemViewFactory, container, b8.intValue(), null, 4, null);
        }
        String d8 = model.d();
        if (d8 != null) {
            ItemViewFactory.p(itemViewFactory, container, d8, null, 4, null).setGravity(8388611);
        }
        String c8 = model.c();
        if (c8 != null) {
            Rect rect = new Rect();
            rect.top = Dimens.d(16);
            rect.bottom = Dimens.d(16);
            Unit unit = Unit.f50853a;
            TextView h8 = itemViewFactory.h(container, c8, rect);
            h8.setGravity(8388611);
            h8.setLineSpacing(Dimens.d(24), 0.0f);
        }
        ItemViewFactory.l(itemViewFactory, container, model.a(), null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: i3.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.Q(InfoDialog.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
