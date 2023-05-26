package ee.mtakso.driver.uicore.components.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.dialogs.SimpleDialogFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleDialogFragment.kt */
/* loaded from: classes5.dex */
public final class SimpleDialogFragment extends DialogFragment {

    /* renamed from: j */
    public static final Companion f34756j = new Companion(null);

    /* renamed from: f */
    private Function1<? super DialogFragment, Unit> f34757f;

    /* renamed from: g */
    private Function1<? super DialogFragment, Unit> f34758g;

    /* renamed from: h */
    private Function1<? super DialogFragment, Unit> f34759h;

    /* renamed from: i */
    public Map<Integer, View> f34760i = new LinkedHashMap();

    /* compiled from: SimpleDialogFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a */
        private final Context f34761a;

        /* renamed from: b */
        private int f34762b;

        /* renamed from: c */
        private String f34763c;

        /* renamed from: d */
        private String f34764d;

        /* renamed from: e */
        private int f34765e;

        /* renamed from: f */
        private CharSequence f34766f;

        /* renamed from: g */
        private String f34767g;

        /* renamed from: h */
        private String f34768h;

        /* renamed from: i */
        private String f34769i;

        /* renamed from: j */
        private String f34770j;

        /* renamed from: k */
        private boolean f34771k;

        /* renamed from: l */
        private UiKitRoundButtonType f34772l;

        /* renamed from: m */
        private Function1<? super DialogFragment, Unit> f34773m;

        /* renamed from: n */
        private Function1<? super DialogFragment, Unit> f34774n;

        /* renamed from: o */
        private Function1<? super DialogFragment, Unit> f34775o;

        public Builder(Context context) {
            Intrinsics.f(context, "context");
            this.f34761a = context;
            this.f34762b = 17;
            this.f34765e = ContextCompat.getColor(context, R$color.f34587l);
            this.f34771k = true;
            this.f34772l = UiKitRoundButtonType.f36161k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder c(Builder builder, int i8, Function1 function1, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                function1 = null;
            }
            return builder.b(i8, function1);
        }

        public final SimpleDialogFragment a() {
            if (this.f34763c != null || this.f34766f != null || this.f34767g != null || this.f34768h != null) {
                return SimpleDialogFragment.f34756j.b(this);
            }
            throw new IllegalStateException("Dialog cannot be completely empty");
        }

        public final Builder b(int i8, Function1<? super DialogFragment, Unit> function1) {
            this.f34768h = this.f34761a.getString(i8);
            this.f34774n = function1;
            return this;
        }

        public final Builder d(CharSequence content) {
            Intrinsics.f(content, "content");
            this.f34766f = content;
            return this;
        }

        public final String e() {
            return this.f34768h;
        }

        public final UiKitRoundButtonType f() {
            return this.f34772l;
        }

        public final String g() {
            return this.f34767g;
        }

        public final CharSequence h() {
            return this.f34766f;
        }

        public final String i() {
            return this.f34769i;
        }

        public final String j() {
            return this.f34770j;
        }

        public final Function1<DialogFragment, Unit> k() {
            return this.f34775o;
        }

        public final Function1<DialogFragment, Unit> l() {
            return this.f34774n;
        }

        public final Function1<DialogFragment, Unit> m() {
            return this.f34773m;
        }

        public final boolean n() {
            return this.f34771k;
        }

        public final String o() {
            return this.f34764d;
        }

        public final int p() {
            return this.f34765e;
        }

        public final int q() {
            return this.f34762b;
        }

        public final String r() {
            return this.f34763c;
        }

        public final Builder s(String subTitle) {
            Intrinsics.f(subTitle, "subTitle");
            this.f34764d = subTitle;
            return this;
        }

        public final Builder t(int i8) {
            this.f34765e = ContextCompat.getColor(this.f34761a, i8);
            return this;
        }

        public final Builder u(int i8) {
            this.f34762b = i8;
            return this;
        }

        public final Builder v(String str) {
            this.f34763c = str;
            return this;
        }
    }

    /* compiled from: SimpleDialogFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimpleDialogFragment b(Builder builder) {
            SimpleDialogFragment simpleDialogFragment = new SimpleDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("dialog.title", builder.r());
            bundle.putString("dialog.subtitle.text", builder.o());
            bundle.putInt("dialog.subtitle.color", builder.p());
            bundle.putCharSequence("dialog.content", builder.h());
            bundle.putString("dialog.confirm_button", builder.g());
            bundle.putString("dialog.cancel_button", builder.e());
            bundle.putBoolean("dialog.param.should_dismiss_on_cancel", builder.n());
            bundle.putSerializable("dialog.confirm_button.color", builder.f());
            bundle.putString("dialog.link.text", builder.i());
            bundle.putString("dialog.link.url", builder.j());
            bundle.putInt("dialog.text.gravity", builder.q());
            simpleDialogFragment.setArguments(bundle);
            simpleDialogFragment.N(builder.m());
            simpleDialogFragment.M(builder.l());
            simpleDialogFragment.L(builder.k());
            return simpleDialogFragment;
        }
    }

    public static final void I(Uri uri, SimpleDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        this$0.startActivity(intent);
    }

    public static final void J(SimpleDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function1<? super DialogFragment, Unit> function1 = this$0.f34757f;
        if (function1 != null) {
            function1.invoke(this$0);
        }
    }

    public static final void K(SimpleDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function1<? super DialogFragment, Unit> function1 = this$0.f34758g;
        if (function1 != null) {
            function1.invoke(this$0);
        }
        this$0.dismissAllowingStateLoss();
    }

    public void G() {
        this.f34760i.clear();
    }

    public View H(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f34760i;
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

    public final void L(Function1<? super DialogFragment, Unit> function1) {
        this.f34759h = function1;
    }

    public final void M(Function1<? super DialogFragment, Unit> function1) {
        this.f34758g = function1;
    }

    public final void N(Function1<? super DialogFragment, Unit> function1) {
        this.f34757f = function1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R$layout.content_simple_dialog, viewGroup);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        G();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onDismiss(dialog);
        Function1<? super DialogFragment, Unit> function1 = this.f34759h;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        UiKitRoundButtonType uiKitRoundButtonType;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("dialog.title");
            String string2 = arguments.getString("dialog.subtitle.text");
            int i8 = arguments.getInt("dialog.subtitle.color");
            CharSequence charSequence = arguments.getCharSequence("dialog.content");
            String string3 = arguments.getString("dialog.confirm_button");
            String string4 = arguments.getString("dialog.cancel_button");
            Object obj = arguments.get("dialog.confirm_button.color");
            if (obj instanceof UiKitRoundButtonType) {
                uiKitRoundButtonType = (UiKitRoundButtonType) obj;
            } else {
                uiKitRoundButtonType = null;
            }
            int i9 = arguments.getInt("dialog.text.gravity");
            String string5 = arguments.getString("dialog.link.text");
            String string6 = arguments.getString("dialog.link.url");
            int i10 = R$id.dialogTitle;
            ((AppCompatTextView) H(i10)).setText(string);
            ((AppCompatTextView) H(i10)).setGravity(i9);
            AppCompatTextView dialogTitle = (AppCompatTextView) H(i10);
            Intrinsics.e(dialogTitle, "dialogTitle");
            boolean z12 = true;
            if (string != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.e(dialogTitle, z7, 0, 2, null);
            int i11 = R$id.dialogSubTitle;
            ((AppCompatTextView) H(i11)).setText(string2);
            ((AppCompatTextView) H(i11)).setGravity(i9);
            ((AppCompatTextView) H(i11)).setTextColor(i8);
            AppCompatTextView dialogSubTitle = (AppCompatTextView) H(i11);
            Intrinsics.e(dialogSubTitle, "dialogSubTitle");
            if (string2 != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            ViewExtKt.e(dialogSubTitle, z8, 0, 2, null);
            int i12 = R$id.dialogContent;
            ((AppCompatTextView) H(i12)).setText(charSequence);
            ((AppCompatTextView) H(i12)).setGravity(i9);
            AppCompatTextView dialogContent = (AppCompatTextView) H(i12);
            Intrinsics.e(dialogContent, "dialogContent");
            if (charSequence != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            ViewExtKt.e(dialogContent, z9, 0, 2, null);
            int i13 = R$id.dialogConfirmButton;
            ((RoundButton) H(i13)).setText(string3);
            if (uiKitRoundButtonType != null) {
                RoundButton dialogConfirmButton = (RoundButton) H(i13);
                Intrinsics.e(dialogConfirmButton, "dialogConfirmButton");
                UiKitRoundButtonTypeKt.b(dialogConfirmButton, uiKitRoundButtonType);
            }
            RoundButton dialogConfirmButton2 = (RoundButton) H(i13);
            Intrinsics.e(dialogConfirmButton2, "dialogConfirmButton");
            if (string3 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            ViewExtKt.e(dialogConfirmButton2, z10, 0, 2, null);
            int i14 = R$id.dialogCancelButton;
            ((RoundButton) H(i14)).setText(string4);
            RoundButton dialogCancelButton = (RoundButton) H(i14);
            Intrinsics.e(dialogCancelButton, "dialogCancelButton");
            if (string4 != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            ViewExtKt.e(dialogCancelButton, z11, 0, 2, null);
            int i15 = R$id.dialogLink;
            ((RoundButton) H(i15)).setText(string5);
            RoundButton dialogLink = (RoundButton) H(i15);
            Intrinsics.e(dialogLink, "dialogLink");
            if (string5 == null) {
                z12 = false;
            }
            ViewExtKt.e(dialogLink, z12, 0, 2, null);
            if (string6 != null) {
                final Uri parse = Uri.parse(string6);
                ((RoundButton) H(i15)).setOnClickListener(new View.OnClickListener() { // from class: o5.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SimpleDialogFragment.I(parse, this, view2);
                    }
                });
            }
            ((RoundButton) H(i13)).setOnClickListener(new View.OnClickListener() { // from class: o5.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SimpleDialogFragment.J(SimpleDialogFragment.this, view2);
                }
            });
            ((RoundButton) H(i14)).setOnClickListener(new View.OnClickListener() { // from class: o5.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SimpleDialogFragment.K(SimpleDialogFragment.this, view2);
                }
            });
            return;
        }
        throw new IllegalStateException("Arguments cannot be null while creating dialog");
    }
}
