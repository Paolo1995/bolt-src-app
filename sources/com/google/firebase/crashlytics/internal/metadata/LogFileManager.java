package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* loaded from: classes3.dex */
public class LogFileManager {

    /* renamed from: c  reason: collision with root package name */
    private static final NoopLogStore f15735c = new NoopLogStore();

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f15736a;

    /* renamed from: b  reason: collision with root package name */
    private FileLogStore f15737b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void a() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public String b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public byte[] c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void d() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void e(long j8, String str) {
        }
    }

    public LogFileManager(FileStore fileStore) {
        this.f15736a = fileStore;
        this.f15737b = f15735c;
    }

    private File d(String str) {
        return this.f15736a.o(str, "userlog");
    }

    public void a() {
        this.f15737b.d();
    }

    public byte[] b() {
        return this.f15737b.c();
    }

    public String c() {
        return this.f15737b.b();
    }

    public final void e(String str) {
        this.f15737b.a();
        this.f15737b = f15735c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    void f(File file, int i8) {
        this.f15737b = new QueueFileLogStore(file, i8);
    }

    public void g(long j8, String str) {
        this.f15737b.e(j8, str);
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        e(str);
    }
}
