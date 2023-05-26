package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog {

    /* renamed from: j  reason: collision with root package name */
    final AlertController f1167j;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.AlertParams f1168a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1169b;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.j(context, 0));
        }

        @NonNull
        public AlertDialog a() {
            AlertDialog alertDialog = new AlertDialog(this.f1168a.f1126a, this.f1169b);
            this.f1168a.a(alertDialog.f1167j);
            alertDialog.setCancelable(this.f1168a.f1143r);
            if (this.f1168a.f1143r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1168a.f1144s);
            alertDialog.setOnDismissListener(this.f1168a.f1145t);
            DialogInterface.OnKeyListener onKeyListener = this.f1168a.f1146u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        @NonNull
        public Context b() {
            return this.f1168a.f1126a;
        }

        public Builder c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1148w = listAdapter;
            alertParams.f1149x = onClickListener;
            return this;
        }

        public Builder d(boolean z7) {
            this.f1168a.f1143r = z7;
            return this;
        }

        public Builder e(View view) {
            this.f1168a.f1132g = view;
            return this;
        }

        public Builder f(int i8) {
            this.f1168a.f1128c = i8;
            return this;
        }

        public Builder g(Drawable drawable) {
            this.f1168a.f1129d = drawable;
            return this;
        }

        public Builder h(int i8) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1133h = alertParams.f1126a.getText(i8);
            return this;
        }

        public Builder i(CharSequence charSequence) {
            this.f1168a.f1133h = charSequence;
            return this;
        }

        public Builder j(int i8, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1140o = alertParams.f1126a.getText(i8);
            this.f1168a.f1142q = onClickListener;
            return this;
        }

        public Builder k(DialogInterface.OnKeyListener onKeyListener) {
            this.f1168a.f1146u = onKeyListener;
            return this;
        }

        public Builder l(int i8, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1134i = alertParams.f1126a.getText(i8);
            this.f1168a.f1136k = onClickListener;
            return this;
        }

        public Builder m(ListAdapter listAdapter, int i8, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1148w = listAdapter;
            alertParams.f1149x = onClickListener;
            alertParams.I = i8;
            alertParams.H = true;
            return this;
        }

        public Builder n(int i8) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1131f = alertParams.f1126a.getText(i8);
            return this;
        }

        public Builder o(CharSequence charSequence) {
            this.f1168a.f1131f = charSequence;
            return this;
        }

        public Builder p(int i8) {
            AlertController.AlertParams alertParams = this.f1168a;
            alertParams.f1151z = null;
            alertParams.f1150y = i8;
            alertParams.E = false;
            return this;
        }

        public Builder(@NonNull Context context, int i8) {
            this.f1168a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.j(context, i8)));
            this.f1169b = i8;
        }
    }

    protected AlertDialog(@NonNull Context context, int i8) {
        super(context, j(context, i8));
        this.f1167j = new AlertController(getContext(), this, getWindow());
    }

    static int j(@NonNull Context context, int i8) {
        if (((i8 >>> 24) & 255) >= 1) {
            return i8;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.f829o, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView i() {
        return this.f1167j.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1167j.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i8, KeyEvent keyEvent) {
        if (this.f1167j.g(i8, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i8, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i8, KeyEvent keyEvent) {
        if (this.f1167j.h(i8, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i8, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1167j.q(charSequence);
    }
}
