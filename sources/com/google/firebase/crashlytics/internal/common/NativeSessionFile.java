package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;

/* loaded from: classes3.dex */
interface NativeSessionFile {
    CrashlyticsReport.FilesPayload.File a();

    @NonNull
    String b();

    InputStream c();
}
