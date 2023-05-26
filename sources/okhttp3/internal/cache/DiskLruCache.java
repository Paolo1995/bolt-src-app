package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* compiled from: DiskLruCache.kt */
/* loaded from: classes5.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes5.dex */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache this$0, Entry entry) {
            boolean[] zArr;
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(entry, "entry");
            this.this$0 = this$0;
            this.entry = entry;
            if (entry.getReadable$okhttp()) {
                zArr = null;
            } else {
                zArr = new boolean[this$0.getValueCount$okhttp()];
            }
            this.written = zArr;
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (Intrinsics.a(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    Unit unit = Unit.f50853a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (Intrinsics.a(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    Unit unit = Unit.f50853a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final Sink newSink(int i8) {
            final DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (!Intrinsics.a(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                        return Okio.b();
                    }
                    if (!getEntry$okhttp().getReadable$okhttp()) {
                        boolean[] written$okhttp = getWritten$okhttp();
                        Intrinsics.c(written$okhttp);
                        written$okhttp[i8] = true;
                    }
                    try {
                        return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(getEntry$okhttp().getDirtyFiles$okhttp().get(i8)), new Function1<IOException, Unit>() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
                                invoke2(iOException);
                                return Unit.f50853a;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(IOException it) {
                                Intrinsics.f(it, "it");
                                DiskLruCache diskLruCache2 = DiskLruCache.this;
                                DiskLruCache.Editor editor = this;
                                synchronized (diskLruCache2) {
                                    editor.detach$okhttp();
                                    Unit unit = Unit.f50853a;
                                }
                            }
                        });
                    } catch (FileNotFoundException unused) {
                        return Okio.b();
                    }
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final Source newSource(int i8) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!this.done) {
                    Source source = null;
                    if (!getEntry$okhttp().getReadable$okhttp() || !Intrinsics.a(getEntry$okhttp().getCurrentEditor$okhttp(), this) || getEntry$okhttp().getZombie$okhttp()) {
                        return null;
                    }
                    try {
                        source = diskLruCache.getFileSystem$okhttp().source(getEntry$okhttp().getCleanFiles$okhttp().get(i8));
                    } catch (FileNotFoundException unused) {
                    }
                    return source;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes5.dex */
    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache this$0, String key) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(key, "key");
            this.this$0 = this$0;
            this.key = key;
            this.lengths = new long[this$0.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = this$0.getValueCount$okhttp();
            for (int i8 = 0; i8 < valueCount$okhttp; i8++) {
                sb.append(i8);
                this.cleanFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException(Intrinsics.n("unexpected journal line: ", list));
        }

        private final Source newSource(int i8) {
            Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i8));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new ForwardingSource(this.this$0, this) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;
                final /* synthetic */ DiskLruCache this$0;
                final /* synthetic */ DiskLruCache.Entry this$1;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(Source.this);
                    this.this$0 = r2;
                    this.this$1 = this;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (!this.closed) {
                        this.closed = true;
                        DiskLruCache diskLruCache = this.this$0;
                        DiskLruCache.Entry entry = this.this$1;
                        synchronized (diskLruCache) {
                            entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                            if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                                diskLruCache.removeEntry$okhttp(entry);
                            }
                            Unit unit = Unit.f50853a;
                        }
                    }
                }
            };
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> strings) throws IOException {
            Intrinsics.f(strings, "strings");
            if (strings.size() == this.this$0.getValueCount$okhttp()) {
                int i8 = 0;
                try {
                    int size = strings.size();
                    while (i8 < size) {
                        int i9 = i8 + 1;
                        this.lengths[i8] = Long.parseLong(strings.get(i8));
                        i8 = i9;
                    }
                    return;
                } catch (NumberFormatException unused) {
                    invalidLengths(strings);
                    throw new KotlinNothingValueException();
                }
            }
            invalidLengths(strings);
            throw new KotlinNothingValueException();
        }

        public final void setLockingSourceCount$okhttp(int i8) {
            this.lockingSourceCount = i8;
        }

        public final void setReadable$okhttp(boolean z7) {
            this.readable = z7;
        }

        public final void setSequenceNumber$okhttp(long j8) {
            this.sequenceNumber = j8;
        }

        public final void setZombie$okhttp(boolean z7) {
            this.zombie = z7;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            } else if (!this.readable) {
                return null;
            } else {
                if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                ArrayList<Source> arrayList = new ArrayList();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i8 = 0; i8 < valueCount$okhttp; i8++) {
                        arrayList.add(newSource(i8));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (Source source : arrayList) {
                        Util.closeQuietly(source);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final void writeLengths$okhttp(BufferedSink writer) throws IOException {
            Intrinsics.f(writer, "writer");
            long[] jArr = this.lengths;
            int length = jArr.length;
            int i8 = 0;
            while (i8 < length) {
                long j8 = jArr[i8];
                i8++;
                writer.writeByte(32).l0(j8);
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes5.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache this$0, String key, long j8, List<? extends Source> sources, long[] lengths) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(key, "key");
            Intrinsics.f(sources, "sources");
            Intrinsics.f(lengths, "lengths");
            this.this$0 = this$0;
            this.key = key;
            this.sequenceNumber = j8;
            this.sources = sources;
            this.lengths = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i8) {
            return this.lengths[i8];
        }

        public final Source getSource(int i8) {
            return this.sources.get(i8);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, File directory, int i8, int i9, long j8, TaskRunner taskRunner) {
        boolean z7;
        Intrinsics.f(fileSystem, "fileSystem");
        Intrinsics.f(directory, "directory");
        Intrinsics.f(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.appVersion = i8;
        this.valueCount = i9;
        this.maxSize = j8;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new Task(Intrinsics.n(Util.okHttpName, " Cache")) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z8;
                boolean journalRebuildRequired;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    z8 = diskLruCache.initialized;
                    if (!z8 || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        journalRebuildRequired = diskLruCache.journalRebuildRequired();
                        if (journalRebuildRequired) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        diskLruCache.journalWriter = Okio.c(Okio.b());
                    }
                    return -1L;
                }
            }
        };
        if (j8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 > 0) {
                this.journalFile = new File(directory, JOURNAL_FILE);
                this.journalFileTmp = new File(directory, JOURNAL_FILE_TEMP);
                this.journalFileBackup = new File(directory, JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j8, int i8, Object obj) throws IOException {
        if ((i8 & 2) != 0) {
            j8 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j8);
    }

    public final boolean journalRebuildRequired() {
        int i8 = this.redundantOpCount;
        if (i8 >= 2000 && i8 >= this.lruEntries.size()) {
            return true;
        }
        return false;
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.c(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new Function1<IOException, Unit>() { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
                invoke2(iOException);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(IOException it) {
                Intrinsics.f(it, "it");
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
                    DiskLruCache.this.hasJournalErrors = true;
                    return;
                }
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            }
        }));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.e(next, "i.next()");
            Entry entry = next;
            int i8 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i9 = this.valueCount;
                while (i8 < i9) {
                    this.size += entry.getLengths$okhttp()[i8];
                    i8++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i10 = this.valueCount;
                while (i8 < i10) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i8));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i8));
                    i8++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        boolean z7;
        BufferedSource d8 = Okio.d(this.fileSystem.source(this.journalFile));
        try {
            String b02 = d8.b0();
            String b03 = d8.b0();
            String b04 = d8.b0();
            String b05 = d8.b0();
            String b06 = d8.b0();
            if (Intrinsics.a(MAGIC, b02) && Intrinsics.a(VERSION_1, b03) && Intrinsics.a(String.valueOf(this.appVersion), b04) && Intrinsics.a(String.valueOf(getValueCount$okhttp()), b05)) {
                int i8 = 0;
                if (b06.length() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    while (true) {
                        try {
                            readJournalLine(d8.b0());
                            i8++;
                        } catch (EOFException unused) {
                            this.redundantOpCount = i8 - getLruEntries$okhttp().size();
                            if (!d8.y0()) {
                                rebuildJournal$okhttp();
                            } else {
                                this.journalWriter = newJournalWriter();
                            }
                            Unit unit = Unit.f50853a;
                            CloseableKt.a(d8, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + b02 + ", " + b03 + ", " + b05 + ", " + b06 + ']');
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        int a02;
        int a03;
        String substring;
        boolean L;
        boolean L2;
        boolean L3;
        List<String> B0;
        boolean L4;
        a02 = StringsKt__StringsKt.a0(str, ' ', 0, false, 6, null);
        if (a02 != -1) {
            int i8 = a02 + 1;
            a03 = StringsKt__StringsKt.a0(str, ' ', i8, false, 4, null);
            if (a03 == -1) {
                substring = str.substring(i8);
                Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                String str2 = REMOVE;
                if (a02 == str2.length()) {
                    L4 = StringsKt__StringsJVMKt.L(str, str2, false, 2, null);
                    if (L4) {
                        this.lruEntries.remove(substring);
                        return;
                    }
                }
            } else {
                substring = str.substring(i8, a03);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Entry entry = this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(this, substring);
                this.lruEntries.put(substring, entry);
            }
            if (a03 != -1) {
                String str3 = CLEAN;
                if (a02 == str3.length()) {
                    L3 = StringsKt__StringsJVMKt.L(str, str3, false, 2, null);
                    if (L3) {
                        String substring2 = str.substring(a03 + 1);
                        Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                        B0 = StringsKt__StringsKt.B0(substring2, new char[]{' '}, false, 0, 6, null);
                        entry.setReadable$okhttp(true);
                        entry.setCurrentEditor$okhttp(null);
                        entry.setLengths$okhttp(B0);
                        return;
                    }
                }
            }
            if (a03 == -1) {
                String str4 = DIRTY;
                if (a02 == str4.length()) {
                    L2 = StringsKt__StringsJVMKt.L(str, str4, false, 2, null);
                    if (L2) {
                        entry.setCurrentEditor$okhttp(new Editor(this, entry));
                        return;
                    }
                }
            }
            if (a03 == -1) {
                String str5 = READ;
                if (a02 == str5.length()) {
                    L = StringsKt__StringsJVMKt.L(str, str5, false, 2, null);
                    if (L) {
                        return;
                    }
                }
            }
            throw new IOException(Intrinsics.n("unexpected journal line: ", str));
        }
        throw new IOException(Intrinsics.n("unexpected journal line: ", str));
    }

    private final boolean removeOldestEntry() {
        for (Entry toEvict : this.lruEntries.values()) {
            if (!toEvict.getZombie$okhttp()) {
                Intrinsics.e(toEvict, "toEvict");
                removeEntry$okhttp(toEvict);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.f(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        if (this.initialized && !this.closed) {
            Collection<Entry> values = this.lruEntries.values();
            Intrinsics.e(values, "lruEntries.values");
            int i8 = 0;
            Object[] array = values.toArray(new Entry[0]);
            if (array != null) {
                Entry[] entryArr = (Entry[]) array;
                int length = entryArr.length;
                while (i8 < length) {
                    Entry entry = entryArr[i8];
                    i8++;
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.c(bufferedSink);
                bufferedSink.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        this.closed = true;
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z7) throws IOException {
        Intrinsics.f(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (Intrinsics.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            int i8 = 0;
            if (z7 && !entry$okhttp.getReadable$okhttp()) {
                int i9 = this.valueCount;
                int i10 = 0;
                while (i10 < i9) {
                    int i11 = i10 + 1;
                    boolean[] written$okhttp = editor.getWritten$okhttp();
                    Intrinsics.c(written$okhttp);
                    if (written$okhttp[i10]) {
                        if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i10))) {
                            editor.abort();
                            return;
                        }
                        i10 = i11;
                    } else {
                        editor.abort();
                        throw new IllegalStateException(Intrinsics.n("Newly created entry didn't create value for index ", Integer.valueOf(i10)));
                    }
                }
            }
            int i12 = this.valueCount;
            while (i8 < i12) {
                int i13 = i8 + 1;
                File file = entry$okhttp.getDirtyFiles$okhttp().get(i8);
                if (z7 && !entry$okhttp.getZombie$okhttp()) {
                    if (this.fileSystem.exists(file)) {
                        File file2 = entry$okhttp.getCleanFiles$okhttp().get(i8);
                        this.fileSystem.rename(file, file2);
                        long j8 = entry$okhttp.getLengths$okhttp()[i8];
                        long size = this.fileSystem.size(file2);
                        entry$okhttp.getLengths$okhttp()[i8] = size;
                        this.size = (this.size - j8) + size;
                    }
                } else {
                    this.fileSystem.delete(file);
                }
                i8 = i13;
            }
            entry$okhttp.setCurrentEditor$okhttp(null);
            if (entry$okhttp.getZombie$okhttp()) {
                removeEntry$okhttp(entry$okhttp);
                return;
            }
            this.redundantOpCount++;
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.c(bufferedSink);
            if (!entry$okhttp.getReadable$okhttp() && !z7) {
                getLruEntries$okhttp().remove(entry$okhttp.getKey$okhttp());
                bufferedSink.Q(REMOVE).writeByte(32);
                bufferedSink.Q(entry$okhttp.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                if (this.size <= this.maxSize || journalRebuildRequired()) {
                    TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                }
                return;
            }
            entry$okhttp.setReadable$okhttp(true);
            bufferedSink.Q(CLEAN).writeByte(32);
            bufferedSink.Q(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(bufferedSink);
            bufferedSink.writeByte(10);
            if (z7) {
                long j9 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j9;
                entry$okhttp.setSequenceNumber$okhttp(j9);
            }
            bufferedSink.flush();
            if (this.size <= this.maxSize) {
            }
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String key) throws IOException {
        Intrinsics.f(key, "key");
        return edit$default(this, key, 0L, 2, null);
    }

    public final synchronized Editor edit(String key, long j8) throws IOException {
        Editor currentEditor$okhttp;
        Intrinsics.f(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (j8 != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j8)) {
            return null;
        }
        if (entry == null) {
            currentEditor$okhttp = null;
        } else {
            currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        }
        if (currentEditor$okhttp != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.c(bufferedSink);
            bufferedSink.Q(DIRTY).writeByte(32).Q(key).writeByte(10);
            bufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        Intrinsics.e(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array != null) {
            Entry[] entryArr = (Entry[]) array;
            int length = entryArr.length;
            int i8 = 0;
            while (i8 < length) {
                Entry entry = entryArr[i8];
                i8++;
                Intrinsics.e(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (!this.initialized) {
            return;
        }
        checkNotClosed();
        trimToSize();
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.c(bufferedSink);
        bufferedSink.flush();
    }

    public final synchronized Snapshot get(String key) throws IOException {
        Intrinsics.f(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.c(bufferedSink);
        bufferedSink.Q(READ).writeByte(32).Q(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e8) {
                Platform platform = Platform.Companion.get();
                platform.log("DiskLruCache " + this.directory + " is corrupt: " + ((Object) e8.getMessage()) + ", removing", 5, e8);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink c8 = Okio.c(this.fileSystem.sink(this.journalFileTmp));
        c8.Q(MAGIC).writeByte(10);
        c8.Q(VERSION_1).writeByte(10);
        c8.l0(this.appVersion).writeByte(10);
        c8.l0(getValueCount$okhttp()).writeByte(10);
        c8.writeByte(10);
        for (Entry entry : getLruEntries$okhttp().values()) {
            if (entry.getCurrentEditor$okhttp() != null) {
                c8.Q(DIRTY).writeByte(32);
                c8.Q(entry.getKey$okhttp());
                c8.writeByte(10);
            } else {
                c8.Q(CLEAN).writeByte(32);
                c8.Q(entry.getKey$okhttp());
                entry.writeLengths$okhttp(c8);
                c8.writeByte(10);
            }
        }
        Unit unit = Unit.f50853a;
        CloseableKt.a(c8, null);
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public final synchronized boolean remove(String key) throws IOException {
        Intrinsics.f(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        BufferedSink bufferedSink;
        Intrinsics.f(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.Q(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.Q(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i8 = this.valueCount;
        for (int i9 = 0; i9 < i8; i9++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i9));
            this.size -= entry.getLengths$okhttp()[i9];
            entry.getLengths$okhttp()[i9] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.Q(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.Q(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z7) {
        this.closed = z7;
    }

    public final synchronized void setMaxSize(long j8) {
        this.maxSize = j8;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }
}
