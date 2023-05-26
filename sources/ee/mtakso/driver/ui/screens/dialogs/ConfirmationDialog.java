package ee.mtakso.driver.ui.screens.dialogs;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.kalev.Kalev;
import j$.util.Spliterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmationDialog.kt */
/* loaded from: classes3.dex */
public final class ConfirmationDialog extends BaseDialogFragment {

    /* renamed from: p */
    public static final Companion f28256p = new Companion(null);

    /* renamed from: m */
    private RoundButton f28257m;

    /* renamed from: n */
    private RoundButton f28258n;

    /* renamed from: o */
    public Map<Integer, View> f28259o = new LinkedHashMap();

    /* compiled from: ConfirmationDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ConfirmationDialog b(Companion companion, CharSequence charSequence, CharSequence charSequence2, String str, String str2, UiKitRoundButtonType uiKitRoundButtonType, String str3, Function3 function3, Bundle bundle, Function3 function32, int i8, Object obj) {
            String str4;
            String str5;
            Function3 function33;
            Bundle bundle2;
            Function3 function34;
            if ((i8 & 8) != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if ((i8 & 32) != 0) {
                str5 = null;
            } else {
                str5 = str3;
            }
            if ((i8 & 64) != 0) {
                function33 = null;
            } else {
                function33 = function3;
            }
            if ((i8 & 128) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            if ((i8 & Spliterator.NONNULL) != 0) {
                function34 = null;
            } else {
                function34 = function32;
            }
            return companion.a(charSequence, charSequence2, str, str4, uiKitRoundButtonType, str5, function33, bundle2, function34);
        }

        public final ConfirmationDialog a(CharSequence title, CharSequence message, String confirmText, String str, UiKitRoundButtonType confirmButtonType, String str2, Function3<? super DialogFragment, ? super View, Object, Unit> function3, Bundle bundle, Function3<? super DialogFragment, ? super View, Object, Unit> function32) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(confirmButtonType, "confirmButtonType");
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("CONFIG_KEY", new Model(title, message, str, confirmText, str2, new RoundButtonStyle(confirmButtonType, UiKitRoundButtonSize.f36155i)));
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            ConfirmationDialog confirmationDialog = new ConfirmationDialog();
            confirmationDialog.setArguments(bundle2);
            confirmationDialog.K(function3);
            confirmationDialog.J(function32);
            return confirmationDialog;
        }
    }

    /* compiled from: ConfirmationDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f */
        private final CharSequence f28260f;

        /* renamed from: g */
        private final CharSequence f28261g;

        /* renamed from: h */
        private final CharSequence f28262h;

        /* renamed from: i */
        private final CharSequence f28263i;

        /* renamed from: j */
        private final CharSequence f28264j;

        /* renamed from: k */
        private final RoundButtonStyle f28265k;

        /* compiled from: ConfirmationDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Model((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (RoundButtonStyle) parcel.readParcelable(Model.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(CharSequence title, CharSequence message, CharSequence charSequence, CharSequence confirmText, CharSequence charSequence2, RoundButtonStyle confirmButtonStyle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(confirmButtonStyle, "confirmButtonStyle");
            this.f28260f = title;
            this.f28261g = message;
            this.f28262h = charSequence;
            this.f28263i = confirmText;
            this.f28264j = charSequence2;
            this.f28265k = confirmButtonStyle;
        }

        public final CharSequence a() {
            return this.f28264j;
        }

        public final RoundButtonStyle b() {
            return this.f28265k;
        }

        public final CharSequence c() {
            return this.f28263i;
        }

        public final CharSequence d() {
            return this.f28262h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final CharSequence e() {
            return this.f28261g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(this.f28260f, model.f28260f) && Intrinsics.a(this.f28261g, model.f28261g) && Intrinsics.a(this.f28262h, model.f28262h) && Intrinsics.a(this.f28263i, model.f28263i) && Intrinsics.a(this.f28264j, model.f28264j) && Intrinsics.a(this.f28265k, model.f28265k);
            }
            return false;
        }

        public final CharSequence f() {
            return this.f28260f;
        }

        public int hashCode() {
            int hashCode = ((this.f28260f.hashCode() * 31) + this.f28261g.hashCode()) * 31;
            CharSequence charSequence = this.f28262h;
            int hashCode2 = (((hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + this.f28263i.hashCode()) * 31;
            CharSequence charSequence2 = this.f28264j;
            return ((hashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.f28265k.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f28260f;
            CharSequence charSequence2 = this.f28261g;
            CharSequence charSequence3 = this.f28262h;
            CharSequence charSequence4 = this.f28263i;
            CharSequence charSequence5 = this.f28264j;
            RoundButtonStyle roundButtonStyle = this.f28265k;
            return "Model(title=" + ((Object) charSequence) + ", message=" + ((Object) charSequence2) + ", linkText=" + ((Object) charSequence3) + ", confirmText=" + ((Object) charSequence4) + ", cancelText=" + ((Object) charSequence5) + ", confirmButtonStyle=" + roundButtonStyle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            TextUtils.writeToParcel(this.f28260f, out, i8);
            TextUtils.writeToParcel(this.f28261g, out, i8);
            TextUtils.writeToParcel(this.f28262h, out, i8);
            TextUtils.writeToParcel(this.f28263i, out, i8);
            TextUtils.writeToParcel(this.f28264j, out, i8);
            out.writeParcelable(this.f28265k, i8);
        }
    }

    public static final void S(ConfirmationDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "link");
        }
        Function3<DialogFragment, View, Object, Unit> F = this$0.F();
        if (F != null) {
            F.l(this$0, view, "link");
        }
    }

    public static final void T(ConfirmationDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "confirm");
        }
        Function3<DialogFragment, View, Object, Unit> F = this$0.F();
        if (F != null) {
            F.l(this$0, view, "confirm");
        }
    }

    public static final void U(ConfirmationDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "cancel");
        }
        Function3<DialogFragment, View, Object, Unit> F = this$0.F();
        if (F != null) {
            F.l(this$0, view, "cancel");
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28259o.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28259o;
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
        int c8;
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
        ItemViewFactory.p(itemViewFactory, container, model.f(), null, 4, null);
        CharSequence e8 = model.e();
        Rect rect = new Rect();
        rect.top = Dimens.c(16);
        if (model.d() == null) {
            c8 = Dimens.c(16);
        } else {
            c8 = Dimens.c(2);
        }
        rect.bottom = c8;
        Unit unit = Unit.f50853a;
        itemViewFactory.h(container, e8, rect);
        CharSequence d8 = model.d();
        if (d8 != null) {
            itemViewFactory.m(container, d8, new Rect(0, 0, 0, 0)).setOnClickListener(new View.OnClickListener() { // from class: i3.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationDialog.S(ConfirmationDialog.this, view);
                }
            });
        }
        RoundButton r7 = ItemViewFactory.r(itemViewFactory, container, model.c(), null, model.b(), 4, null);
        r7.setOnClickListener(new View.OnClickListener() { // from class: i3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmationDialog.T(ConfirmationDialog.this, view);
            }
        });
        this.f28257m = r7;
        CharSequence a8 = model.a();
        if (a8 != null) {
            RoundButton l8 = ItemViewFactory.l(itemViewFactory, container, a8, null, 4, null);
            l8.setOnClickListener(new View.OnClickListener() { // from class: i3.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationDialog.U(ConfirmationDialog.this, view);
                }
            });
            this.f28258n = l8;
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f28257m = null;
        this.f28258n = null;
        D();
    }
}
