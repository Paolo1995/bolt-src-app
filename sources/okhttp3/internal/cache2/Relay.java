package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* compiled from: Relay.kt */
/* loaded from: classes5.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN;
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* compiled from: Relay.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Relay edit(File file, Source upstream, ByteString metadata, long j8) throws IOException {
            Intrinsics.f(file, "file");
            Intrinsics.f(upstream, "upstream");
            Intrinsics.f(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j8, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            Intrinsics.f(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.e(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, Relay.FILE_HEADER_SIZE);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (Intrinsics.a(buffer.o0(byteString.z()), byteString)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + Relay.FILE_HEADER_SIZE, buffer2, readLong2);
                return new Relay(randomAccessFile, null, readLong, buffer2.N0(), 0L, null);
            }
            throw new IOException("unreadable cache file");
        }
    }

    /* compiled from: Relay.kt */
    /* loaded from: classes5.dex */
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final Timeout timeout;

        public RelaySource(Relay this$0) {
            Intrinsics.f(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new Timeout();
            RandomAccessFile file = this$0.getFile();
            Intrinsics.c(file);
            FileChannel channel = file.getChannel();
            Intrinsics.e(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = this.this$0;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
                Unit unit = Unit.f50853a;
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
            if (r4 != 2) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
            r10 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
            kotlin.jvm.internal.Intrinsics.c(r2);
            r2.read(r19.sourcePos + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r20, r10);
            r19.sourcePos += r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
            return r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
            r0 = r19.this$0.getUpstream();
            kotlin.jvm.internal.Intrinsics.c(r0);
            r14 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
            if (r14 != (-1)) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c3, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c5, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
            r2.setUpstreamReader(null);
            r2.notifyAll();
            r0 = kotlin.Unit.f50853a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ce, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cf, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
            r11 = java.lang.Math.min(r14, r21);
            r19.this$0.getUpstreamBuffer().j(r20, 0, r11);
            r19.sourcePos += r11;
            r13 = r19.fileOperator;
            kotlin.jvm.internal.Intrinsics.c(r13);
            r13.write(r19.this$0.getUpstreamPos() + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r19.this$0.getUpstreamBuffer().clone(), r14);
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x010b, code lost:
            r2.getBuffer().write(r2.getUpstreamBuffer(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0124, code lost:
            if (r2.getBuffer().size() <= r2.getBufferMaxSize()) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0126, code lost:
            r2.getBuffer().skip(r2.getBuffer().size() - r2.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x013a, code lost:
            r2.setUpstreamPos(r2.getUpstreamPos() + r14);
            r0 = kotlin.Unit.f50853a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0144, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0147, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0148, code lost:
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x014e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x014f, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0156, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0157, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0159, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
            r2.setUpstreamReader(null);
            r2.notifyAll();
            r3 = kotlin.Unit.f50853a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 374
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.f52591i;
        PREFIX_CLEAN = companion.d("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.d("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j8, ByteString byteString, long j9) {
        boolean z7;
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j8;
        this.metadata = byteString;
        this.bufferMaxSize = j9;
        this.upstreamBuffer = new Buffer();
        if (this.upstream == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.complete = z7;
        this.buffer = new Buffer();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j8, ByteString byteString, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j8, byteString, j9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j8, long j9) throws IOException {
        boolean z7;
        Buffer buffer = new Buffer();
        buffer.a1(byteString);
        buffer.c1(j8);
        buffer.c1(j9);
        if (buffer.size() == FILE_HEADER_SIZE) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.c(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.e(channel, "file!!.channel");
            new FileOperator(channel).write(0L, buffer, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j8) throws IOException {
        Buffer buffer = new Buffer();
        buffer.a1(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.e(channel, "file!!.channel");
        new FileOperator(channel).write(FILE_HEADER_SIZE + j8, buffer, this.metadata.z());
    }

    public final void commit(long j8) throws IOException {
        writeMetadata(j8);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.c(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j8, this.metadata.z());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.c(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            setComplete(true);
            Unit unit = Unit.f50853a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly(source);
        }
        this.upstream = null;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (getFile() == null) {
                return null;
            }
            setSourceCount(getSourceCount() + 1);
            return new RelaySource(this);
        }
    }

    public final void setComplete(boolean z7) {
        this.complete = z7;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i8) {
        this.sourceCount = i8;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j8) {
        this.upstreamPos = j8;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}
