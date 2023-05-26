package eu.bolt.driver.core.ui.common.dialog;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmationDialog.kt */
/* loaded from: classes5.dex */
public final class ConfirmationDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41075m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41076l = new LinkedHashMap();

    /* compiled from: ConfirmationDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ConfirmationDialog b(Companion companion, String str, String str2, String str3, UiKitRoundButtonType uiKitRoundButtonType, String str4, DialogCallback dialogCallback, Bundle bundle, int i8, Object obj) {
            UiKitRoundButtonType uiKitRoundButtonType2;
            Bundle bundle2;
            if ((i8 & 8) != 0) {
                uiKitRoundButtonType2 = UiKitRoundButtonType.f36161k;
            } else {
                uiKitRoundButtonType2 = uiKitRoundButtonType;
            }
            if ((i8 & 64) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            return companion.a(str, str2, str3, uiKitRoundButtonType2, str4, dialogCallback, bundle2);
        }

        public final ConfirmationDialog a(String title, String message, String confirmText, UiKitRoundButtonType confirmButtonType, String cancelText, DialogCallback callback, Bundle bundle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(confirmButtonType, "confirmButtonType");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(callback, "callback");
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("CONFIG_KEY", new Model(title, message, confirmText, cancelText, new RoundButtonStyle(confirmButtonType, UiKitRoundButtonSize.f36155i)));
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            ConfirmationDialog confirmationDialog = new ConfirmationDialog();
            confirmationDialog.setArguments(bundle2);
            confirmationDialog.K(callback);
            return confirmationDialog;
        }
    }

    /* compiled from: ConfirmationDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Model implements Parcelable {
        public static final Parcelable.Creator<Model> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final String f41077f;

        /* renamed from: g  reason: collision with root package name */
        private final String f41078g;

        /* renamed from: h  reason: collision with root package name */
        private final String f41079h;

        /* renamed from: i  reason: collision with root package name */
        private final String f41080i;

        /* renamed from: j  reason: collision with root package name */
        private final RoundButtonStyle f41081j;

        /* compiled from: ConfirmationDialog.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Model> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Model createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Model(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (RoundButtonStyle) parcel.readParcelable(Model.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Model[] newArray(int i8) {
                return new Model[i8];
            }
        }

        public Model(String title, String message, String confirmText, String cancelText, RoundButtonStyle confirmButtonStyle) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(confirmText, "confirmText");
            Intrinsics.f(cancelText, "cancelText");
            Intrinsics.f(confirmButtonStyle, "confirmButtonStyle");
            this.f41077f = title;
            this.f41078g = message;
            this.f41079h = confirmText;
            this.f41080i = cancelText;
            this.f41081j = confirmButtonStyle;
        }

        public final String a() {
            return this.f41080i;
        }

        public final String b() {
            return this.f41079h;
        }

        public final String c() {
            return this.f41078g;
        }

        public final String d() {
            return this.f41077f;
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
                return Intrinsics.a(this.f41077f, model.f41077f) && Intrinsics.a(this.f41078g, model.f41078g) && Intrinsics.a(this.f41079h, model.f41079h) && Intrinsics.a(this.f41080i, model.f41080i) && Intrinsics.a(this.f41081j, model.f41081j);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f41077f.hashCode() * 31) + this.f41078g.hashCode()) * 31) + this.f41079h.hashCode()) * 31) + this.f41080i.hashCode()) * 31) + this.f41081j.hashCode();
        }

        public String toString() {
            String str = this.f41077f;
            String str2 = this.f41078g;
            String str3 = this.f41079h;
            String str4 = this.f41080i;
            RoundButtonStyle roundButtonStyle = this.f41081j;
            return "Model(title=" + str + ", message=" + str2 + ", confirmText=" + str3 + ", cancelText=" + str4 + ", confirmButtonStyle=" + roundButtonStyle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f41077f);
            out.writeString(this.f41078g);
            out.writeString(this.f41079h);
            out.writeString(this.f41080i);
            out.writeParcelable(this.f41081j, i8);
        }
    }

    public ConfirmationDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ConfirmationDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "ITEM_CONFIRM_TAG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ConfirmationDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "ITEM_CANCEL_TAG");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41076l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        Model model = (Model) requireArguments().getParcelable("CONFIG_KEY");
        if (model != null) {
            M().g(model.d(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
            M().d(model.c(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
            M().b(model.b(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationDialog.R(ConfirmationDialog.this, view);
                }
            });
            M().e(model.a(), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationDialog.S(ConfirmationDialog.this, view);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Missing dialog config");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
