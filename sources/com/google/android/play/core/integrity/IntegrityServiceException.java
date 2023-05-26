package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public class IntegrityServiceException extends ApiException {

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f14577f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntegrityServiceException(int i8, Throwable th) {
        super(new Status(i8, String.format(Locale.ROOT, "Integrity API error (%d): %s.", Integer.valueOf(i8), com.google.android.play.core.integrity.model.a.a(i8))));
        if (i8 != 0) {
            this.f14577f = th;
            return;
        }
        throw new IllegalArgumentException("ErrorCode should not be 0.");
    }

    public int a() {
        return super.getStatusCode();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f14577f;
    }
}
