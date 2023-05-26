package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;

/* compiled from: FileSystem.kt */
/* loaded from: classes5.dex */
public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    /* compiled from: FileSystem.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: FileSystem.kt */
        /* loaded from: classes5.dex */
        private static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public Sink appendingSink(File file) throws FileNotFoundException {
                Intrinsics.f(file, "file");
                try {
                    return Okio.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.a(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File file) throws IOException {
                Intrinsics.f(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException(Intrinsics.n("failed to delete ", file));
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File directory) throws IOException {
                Intrinsics.f(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles != null) {
                    int i8 = 0;
                    int length = listFiles.length;
                    while (i8 < length) {
                        File file = listFiles[i8];
                        i8++;
                        if (file.isDirectory()) {
                            Intrinsics.e(file, "file");
                            deleteContents(file);
                        }
                        if (!file.delete()) {
                            throw new IOException(Intrinsics.n("failed to delete ", file));
                        }
                    }
                    return;
                }
                throw new IOException(Intrinsics.n("not a readable directory: ", directory));
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File file) {
                Intrinsics.f(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File from, File to) throws IOException {
                Intrinsics.f(from, "from");
                Intrinsics.f(to, "to");
                delete(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // okhttp3.internal.io.FileSystem
            public Sink sink(File file) throws FileNotFoundException {
                Sink g8;
                Sink g9;
                Intrinsics.f(file, "file");
                try {
                    g9 = Okio__JvmOkioKt.g(file, false, 1, null);
                    return g9;
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    g8 = Okio__JvmOkioKt.g(file, false, 1, null);
                    return g8;
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File file) {
                Intrinsics.f(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public Source source(File file) throws FileNotFoundException {
                Intrinsics.f(file, "file");
                return Okio.j(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
