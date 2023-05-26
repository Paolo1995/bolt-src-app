package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
@Singleton
/* loaded from: classes.dex */
public abstract class TransportRuntimeComponent implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Builder {
        Builder a(Context context);

        TransportRuntimeComponent build();
    }

    abstract EventStore a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract TransportRuntime c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
