package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import eu.bolt.verification.sdk.internal.ll;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class il {
    public static final ll.b a(String str) {
        Intrinsics.f(str, "<this>");
        return new ll.b(str);
    }

    public static final CharSequence b(Context context, ll uiModel) {
        Intrinsics.f(context, "<this>");
        Intrinsics.f(uiModel, "uiModel");
        if (uiModel instanceof ll.c) {
            ll.c cVar = (ll.c) uiModel;
            String string = cVar.a() == null ? context.getString(cVar.b()) : context.getString(cVar.b(), cVar.a());
            Intrinsics.e(string, "if (uiModel.formatArg ==… uiModel.formatArg)\n    }");
            return string;
        } else if (uiModel instanceof ll.d) {
            return ((ll.d) uiModel).a();
        } else {
            if (uiModel instanceof ll.b) {
                return y4.f45720a.a().a(((ll.b) uiModel).a());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final CharSequence c(View view, ll uiModel) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(uiModel, "uiModel");
        Context context = view.getContext();
        Intrinsics.e(context, "context");
        return b(context, uiModel);
    }

    public static final void d(TextView textView, ll textModel) {
        Intrinsics.f(textView, "<this>");
        Intrinsics.f(textModel, "textModel");
        Context context = textView.getContext();
        Intrinsics.e(context, "context");
        textView.setText(b(context, textModel));
    }

    public static final ll.d e(String str) {
        Intrinsics.f(str, "<this>");
        return ll.f44093f.c(str);
    }

    public static final void f(TextView textView, ll llVar) {
        CharSequence charSequence;
        Intrinsics.f(textView, "<this>");
        if (llVar != null) {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            charSequence = b(context, llVar);
        } else {
            charSequence = null;
        }
        ol.d(textView, charSequence);
    }
}
