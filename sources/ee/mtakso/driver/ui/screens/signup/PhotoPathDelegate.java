package ee.mtakso.driver.ui.screens.signup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import eu.bolt.kalev.Kalev;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhotoPathDelegate.kt */
/* loaded from: classes5.dex */
public final class PhotoPathDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f33325c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f33326a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f33327b;

    /* compiled from: PhotoPathDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PhotoPathDelegate(Context context) {
        Intrinsics.f(context, "context");
        this.f33326a = context;
    }

    private final Uri c() throws IOException {
        String valueOf = String.valueOf(System.currentTimeMillis());
        File externalFilesDir = this.f33326a.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        Uri f8 = FileProvider.f(this.f33326a, "ee.mtakso.driver.fileprovider", File.createTempFile("JPEG_" + valueOf + "_", ".jpg", externalFilesDir));
        Intrinsics.e(f8, "getUriForFile(context, B…ILEPROVIDER_SUFFIX, file)");
        return f8;
    }

    private final Intent e() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.f33326a.getPackageManager()) == null) {
            return null;
        }
        try {
            Uri c8 = c();
            this.f33327b = c8;
            if (c8 != null) {
                intent.putExtra("output", c8);
            } else {
                intent = null;
            }
            return intent;
        } catch (Exception e8) {
            Kalev.e(e8, "Exception on file chooser for sign up WebView!");
            return null;
        }
    }

    public final void a() {
        this.f33327b = null;
    }

    public final Intent b() {
        Intent e8 = e();
        Intent d8 = d();
        if (e8 != null) {
            d8.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{e8});
        }
        return d8;
    }

    public final Intent d() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent putExtra = new Intent("android.intent.action.CHOOSER").putExtra("android.intent.extra.INTENT", intent);
        Intrinsics.e(putExtra, "Intent(Intent.ACTION_CHO…, contentSelectionIntent)");
        return putExtra;
    }

    public final Uri f(Intent intent) {
        Uri uri;
        if (intent == null || (uri = intent.getData()) == null) {
            uri = this.f33327b;
        }
        Kalev.b("Pick file result uri: " + uri);
        return uri;
    }
}
