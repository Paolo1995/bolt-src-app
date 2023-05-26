package eu.bolt.verification.sdk.internal;

import android.content.Context;
import java.io.File;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class mn {

    /* renamed from: c  reason: collision with root package name */
    private static final a f44219c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f44220a;

    /* renamed from: b  reason: collision with root package name */
    private final File f44221b;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public mn(Context context) {
        Intrinsics.f(context, "context");
        this.f44220a = context;
        this.f44221b = a();
    }

    private final File a() {
        File file = new File(this.f44220a.getFilesDir(), "verification");
        if (!file.exists() && !file.mkdirs()) {
            Timber.f53064a.b(new n5("Fail to create directory for rentals report", false, null, null, 12, null));
        }
        return file;
    }

    public final File b(String stepId) {
        Intrinsics.f(stepId, "stepId");
        File file = this.f44221b;
        return new File(file, stepId + "_cropped.jpg");
    }

    public final File c(String stepId) {
        Intrinsics.f(stepId, "stepId");
        File file = this.f44221b;
        return new File(file, stepId + ".jpg");
    }
}
