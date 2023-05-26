package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* compiled from: FileOperator.kt */
/* loaded from: classes5.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        Intrinsics.f(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j8, Buffer sink, long j9) {
        Intrinsics.f(sink, "sink");
        if (j9 >= 0) {
            while (j9 > 0) {
                long transferTo = this.fileChannel.transferTo(j8, j9, sink);
                j8 += transferTo;
                j9 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j8, Buffer source, long j9) throws IOException {
        Intrinsics.f(source, "source");
        if (j9 >= 0 && j9 <= source.size()) {
            long j10 = j8;
            long j11 = j9;
            while (j11 > 0) {
                long transferFrom = this.fileChannel.transferFrom(source, j10, j11);
                j10 += transferFrom;
                j11 -= transferFrom;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
