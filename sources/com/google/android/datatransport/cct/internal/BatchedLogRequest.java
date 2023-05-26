package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BatchedLogRequest {
    @NonNull
    public static BatchedLogRequest a(@NonNull List<LogRequest> list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    @NonNull
    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().j(AutoBatchedLogRequestEncoder.f11881a).k(true).i();
    }

    @NonNull
    public abstract List<LogRequest> c();
}
