package ee.mtakso.driver.ui.screens.dialogs;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.helper.ItemViewInflater;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoCopyDialog.kt */
/* loaded from: classes3.dex */
public final class InfoCopyDialog extends LinearScrollableDialogFragment {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f28299n = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f28300l;

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f28301m = new LinkedHashMap();

    /* compiled from: InfoCopyDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InfoCopyDialog a(String title, String value, CharSequence charSequence, boolean z7) {
            Intrinsics.f(title, "title");
            Intrinsics.f(value, "value");
            Bundle bundle = new Bundle();
            bundle.putParcelable("CONFIG", new Config(title, value, charSequence, z7));
            InfoCopyDialog infoCopyDialog = new InfoCopyDialog();
            infoCopyDialog.setArguments(bundle);
            return infoCopyDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InfoCopyDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final String f28302f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28303g;

        /* renamed from: h  reason: collision with root package name */
        private final CharSequence f28304h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f28305i;

        /* compiled from: InfoCopyDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Config> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Config(parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Config[] newArray(int i8) {
                return new Config[i8];
            }
        }

        public Config(String title, String value, CharSequence charSequence, boolean z7) {
            Intrinsics.f(title, "title");
            Intrinsics.f(value, "value");
            this.f28302f = title;
            this.f28303g = value;
            this.f28304h = charSequence;
            this.f28305i = z7;
        }

        public final boolean a() {
            return this.f28305i;
        }

        public final CharSequence b() {
            return this.f28304h;
        }

        public final String c() {
            return this.f28302f;
        }

        public final String d() {
            return this.f28303g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Config) {
                Config config = (Config) obj;
                return Intrinsics.a(this.f28302f, config.f28302f) && Intrinsics.a(this.f28303g, config.f28303g) && Intrinsics.a(this.f28304h, config.f28304h) && this.f28305i == config.f28305i;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f28302f.hashCode() * 31) + this.f28303g.hashCode()) * 31;
            CharSequence charSequence = this.f28304h;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            boolean z7 = this.f28305i;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode2 + i8;
        }

        public String toString() {
            String str = this.f28302f;
            String str2 = this.f28303g;
            CharSequence charSequence = this.f28304h;
            boolean z7 = this.f28305i;
            return "Config(title=" + str + ", value=" + str2 + ", comment=" + ((Object) charSequence) + ", canCopy=" + z7 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f28302f);
            out.writeString(this.f28303g);
            TextUtils.writeToParcel(this.f28304h, out, i8);
            out.writeInt(this.f28305i ? 1 : 0);
        }
    }

    public InfoCopyDialog() {
        super(false, 1, null);
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Config>() { // from class: ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final InfoCopyDialog.Config invoke() {
                Parcelable parcelable = InfoCopyDialog.this.requireArguments().getParcelable("CONFIG");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog.Config");
                return (InfoCopyDialog.Config) parcelable;
            }
        });
        this.f28300l = b8;
    }

    private final void Q(String str) {
        Object obj;
        ClipboardManager clipboardManager;
        Context context = getContext();
        if (context != null) {
            obj = context.getSystemService("clipboard");
        } else {
            obj = null;
        }
        if (obj instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) obj;
        } else {
            clipboardManager = null;
        }
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
        Toast.makeText(getContext(), (int) R.string.copy_clipboard, 0).show();
    }

    private final Config R() {
        return (Config) this.f28300l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(InfoCopyDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q(this$0.R().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(InfoCopyDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f28301m.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        M().g(R().c(), container, new Margins(0, Dimens.d(4), 0, 0, 13, null)).setGravity(8388611);
        TextView d8 = M().d(R().d(), container, new Margins(0, Dimens.d(4), 0, Dimens.d(16), 5, null));
        d8.setTextColor(ContextCompat.getColor(d8.getContext(), R.color.neutral500));
        d8.setTextSize(18.0f);
        d8.setGravity(8388611);
        CharSequence b8 = R().b();
        if (b8 != null) {
            TextView d9 = M().d(b8, container, new Margins(0, 0, 0, Dimens.d(16), 7, null));
            d9.setGravity(8388611);
            d9.setTextSize(16.0f);
            d9.setLineSpacing(Dimens.c(8.0f), 1.0f);
        }
        if (R().a()) {
            ItemViewInflater M = M();
            String string = getString(R.string.copy_to_clipboard);
            Margins margins = new Margins(0, Dimens.d(16), 0, 0, 13, null);
            Intrinsics.e(string, "getString(R.string.copy_to_clipboard)");
            M.b(string, container, margins).setOnClickListener(new View.OnClickListener() { // from class: i3.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoCopyDialog.S(InfoCopyDialog.this, view);
                }
            });
        }
        ItemViewInflater M2 = M();
        String string2 = getString(R.string.close);
        Margins margins2 = new Margins(0, Dimens.d(16), 0, 0, 13, null);
        Intrinsics.e(string2, "getString(R.string.close)");
        M2.e(string2, container, margins2).setOnClickListener(new View.OnClickListener() { // from class: i3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoCopyDialog.T(InfoCopyDialog.this, view);
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K(new DefaultDialogCallback());
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
