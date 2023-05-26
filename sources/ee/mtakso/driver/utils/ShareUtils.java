package ee.mtakso.driver.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ee.mtakso.driver.R;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareUtils.kt */
/* loaded from: classes5.dex */
public final class ShareUtils {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36321a;

    @Inject
    public ShareUtils(Context context) {
        Intrinsics.f(context, "context");
        this.f36321a = context;
    }

    public final void a(String to, String subject, String msg) {
        Intrinsics.f(to, "to");
        Intrinsics.f(subject, "subject");
        Intrinsics.f(msg, "msg");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{to});
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        intent.putExtra("android.intent.extra.TEXT", msg);
        try {
            Context context = this.f36321a;
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.choose_email_app)));
        } catch (ActivityNotFoundException unused) {
            Context context2 = this.f36321a;
            Toast.makeText(context2, context2.getString(R.string.no_email_app), 0).show();
        }
    }
}
