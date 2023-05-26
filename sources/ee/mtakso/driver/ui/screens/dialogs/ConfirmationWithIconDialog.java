package ee.mtakso.driver.ui.screens.dialogs;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationWithIconDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmationWithIconDialog.kt */
/* loaded from: classes3.dex */
public final class ConfirmationWithIconDialog extends BaseDialogFragment {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f28266n = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f28267m = new LinkedHashMap();

    /* compiled from: ConfirmationWithIconDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ConfirmationWithIconDialog c(Companion companion, String str, String str2, String str3, UiKitRoundButtonType uiKitRoundButtonType, String str4, Function3 function3, int i8, Bundle bundle, int i9, Object obj) {
            Bundle bundle2;
            if ((i9 & 128) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            return companion.b(str, str2, str3, uiKitRoundButtonType, str4, function3, i8, bundle2);
        }

        public final ConfirmationWithIconDialog a(String title, String message, String confirmText, UiKitRoundButtonType confirmButtonType, String cancelText, Function3<? super DialogFragment, ? super View, Object, Unit> clickListener, int i8) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(confirmButtonType, "confirmButtonType");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(clickListener, "clickListener");
            return c(this, title, message, confirmText, confirmButtonType, cancelText, clickListener, i8, null, 128, null);
        }

        public final ConfirmationWithIconDialog b(String title, String message, String confirmText, UiKitRoundButtonType confirmButtonType, String cancelText, Function3<? super DialogFragment, ? super View, Object, Unit> clickListener, int i8, Bundle bundle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(confirmButtonType, "confirmButtonType");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(clickListener, "clickListener");
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("CONFIG_KEY", new Model(i8, title, message, confirmText, cancelText, new RoundButtonStyle(confirmButtonType, UiKitRoundButtonSize.f36155i)));
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            ConfirmationWithIconDialog confirmationWithIconDialog = new ConfirmationWithIconDialog();
            confirmationWithIconDialog.setArguments(bundle2);
            confirmationWithIconDialog.K(clickListener);
            return confirmationWithIconDialog;
        }
    }

    /* compiled from: ConfirmationWithIconDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f28268f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28269g;

        /* renamed from: h  reason: collision with root package name */
        private final String f28270h;

        /* renamed from: i  reason: collision with root package name */
        private final String f28271i;

        /* renamed from: j  reason: collision with root package name */
        private final String f28272j;

        /* renamed from: k  reason: collision with root package name */
        private final RoundButtonStyle f28273k;

        /* compiled from: ConfirmationWithIconDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Model(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (RoundButtonStyle) parcel.readParcelable(Model.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(int i8, String title, String message, String confirmText, String cancelText, RoundButtonStyle confirmButtonStyle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(confirmButtonStyle, "confirmButtonStyle");
            this.f28268f = i8;
            this.f28269g = title;
            this.f28270h = message;
            this.f28271i = confirmText;
            this.f28272j = cancelText;
            this.f28273k = confirmButtonStyle;
        }

        public final String a() {
            return this.f28272j;
        }

        public final RoundButtonStyle b() {
            return this.f28273k;
        }

        public final String c() {
            return this.f28271i;
        }

        public final int d() {
            return this.f28268f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f28270h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return this.f28268f == model.f28268f && Intrinsics.a(this.f28269g, model.f28269g) && Intrinsics.a(this.f28270h, model.f28270h) && Intrinsics.a(this.f28271i, model.f28271i) && Intrinsics.a(this.f28272j, model.f28272j) && Intrinsics.a(this.f28273k, model.f28273k);
            }
            return false;
        }

        public final String f() {
            return this.f28269g;
        }

        public int hashCode() {
            return (((((((((this.f28268f * 31) + this.f28269g.hashCode()) * 31) + this.f28270h.hashCode()) * 31) + this.f28271i.hashCode()) * 31) + this.f28272j.hashCode()) * 31) + this.f28273k.hashCode();
        }

        public String toString() {
            int i8 = this.f28268f;
            String str = this.f28269g;
            String str2 = this.f28270h;
            String str3 = this.f28271i;
            String str4 = this.f28272j;
            RoundButtonStyle roundButtonStyle = this.f28273k;
            return "Model(drawableResourceId=" + i8 + ", title=" + str + ", message=" + str2 + ", confirmText=" + str3 + ", cancelText=" + str4 + ", confirmButtonStyle=" + roundButtonStyle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f28268f);
            out.writeString(this.f28269g);
            out.writeString(this.f28270h);
            out.writeString(this.f28271i);
            out.writeString(this.f28272j);
            out.writeParcelable(this.f28273k, i8);
        }
    }

    public static final ConfirmationWithIconDialog R(String str, String str2, String str3, UiKitRoundButtonType uiKitRoundButtonType, String str4, Function3<? super DialogFragment, ? super View, Object, Unit> function3, int i8) {
        return f28266n.a(str, str2, str3, uiKitRoundButtonType, str4, function3, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ConfirmationWithIconDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "confirm");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(ConfirmationWithIconDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "cancel");
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28267m.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28267m;
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
        ItemViewFactory.g(itemViewFactory, container, model.d(), null, 4, null);
        String f8 = model.f();
        Rect rect = new Rect();
        rect.top = Dimens.c(16);
        Unit unit = Unit.f50853a;
        itemViewFactory.o(container, f8, rect);
        String e8 = model.e();
        Rect rect2 = new Rect();
        rect2.top = Dimens.c(16);
        rect2.bottom = Dimens.c(16);
        itemViewFactory.h(container, e8, rect2);
        ItemViewFactory.r(itemViewFactory, container, model.c(), null, model.b(), 4, null).setOnClickListener(new View.OnClickListener() { // from class: i3.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmationWithIconDialog.S(ConfirmationWithIconDialog.this, view);
            }
        });
        ItemViewFactory.l(itemViewFactory, container, model.a(), null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: i3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmationWithIconDialog.T(ConfirmationWithIconDialog.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
