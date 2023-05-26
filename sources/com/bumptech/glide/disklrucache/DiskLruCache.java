package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private final File f9810f;

    /* renamed from: g  reason: collision with root package name */
    private final File f9811g;

    /* renamed from: h  reason: collision with root package name */
    private final File f9812h;

    /* renamed from: i  reason: collision with root package name */
    private final File f9813i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9814j;

    /* renamed from: k  reason: collision with root package name */
    private long f9815k;

    /* renamed from: l  reason: collision with root package name */
    private final int f9816l;

    /* renamed from: n  reason: collision with root package name */
    private Writer f9818n;

    /* renamed from: p  reason: collision with root package name */
    private int f9820p;

    /* renamed from: m  reason: collision with root package name */
    private long f9817m = 0;

    /* renamed from: o  reason: collision with root package name */
    private final LinkedHashMap<String, Entry> f9819o = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: q  reason: collision with root package name */
    private long f9821q = 0;

    /* renamed from: r  reason: collision with root package name */
    final ThreadPoolExecutor f9822r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());

    /* renamed from: s  reason: collision with root package name */
    private final Callable<Void> f9823s = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f9818n != null) {
                    DiskLruCache.this.v0();
                    if (DiskLruCache.this.X()) {
                        DiskLruCache.this.f0();
                        DiskLruCache.this.f9820p = 0;
                    }
                    return null;
                }
                return null;
            }
        }
    };

    /* loaded from: classes.dex */
    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes.dex */
    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        private final Entry f9825a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f9826b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9827c;

        public void a() throws IOException {
            DiskLruCache.this.t(this, false);
        }

        public void b() {
            if (!this.f9827c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            DiskLruCache.this.t(this, true);
            this.f9827c = true;
        }

        public File f(int i8) throws IOException {
            File k8;
            synchronized (DiskLruCache.this) {
                if (this.f9825a.f9834f == this) {
                    if (!this.f9825a.f9833e) {
                        this.f9826b[i8] = true;
                    }
                    k8 = this.f9825a.k(i8);
                    DiskLruCache.this.f9810f.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return k8;
        }

        private Editor(Entry entry) {
            this.f9825a = entry;
            this.f9826b = entry.f9833e ? null : new boolean[DiskLruCache.this.f9816l];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class Entry {

        /* renamed from: a  reason: collision with root package name */
        private final String f9829a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f9830b;

        /* renamed from: c  reason: collision with root package name */
        File[] f9831c;

        /* renamed from: d  reason: collision with root package name */
        File[] f9832d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9833e;

        /* renamed from: f  reason: collision with root package name */
        private Editor f9834f;

        /* renamed from: g  reason: collision with root package name */
        private long f9835g;

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f9816l) {
                for (int i8 = 0; i8 < strArr.length; i8++) {
                    try {
                        this.f9830b[i8] = Long.parseLong(strArr[i8]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i8) {
            return this.f9831c[i8];
        }

        public File k(int i8) {
            return this.f9832d[i8];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j8 : this.f9830b) {
                sb.append(' ');
                sb.append(j8);
            }
            return sb.toString();
        }

        private Entry(String str) {
            this.f9829a = str;
            this.f9830b = new long[DiskLruCache.this.f9816l];
            this.f9831c = new File[DiskLruCache.this.f9816l];
            this.f9832d = new File[DiskLruCache.this.f9816l];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i8 = 0; i8 < DiskLruCache.this.f9816l; i8++) {
                sb.append(i8);
                this.f9831c[i8] = new File(DiskLruCache.this.f9810f, sb.toString());
                sb.append(".tmp");
                this.f9832d[i8] = new File(DiskLruCache.this.f9810f, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Value {

        /* renamed from: a  reason: collision with root package name */
        private final String f9837a;

        /* renamed from: b  reason: collision with root package name */
        private final long f9838b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f9839c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f9840d;

        public File a(int i8) {
            return this.f9840d[i8];
        }

        private Value(String str, long j8, File[] fileArr, long[] jArr) {
            this.f9837a = str;
            this.f9838b = j8;
            this.f9840d = fileArr;
            this.f9839c = jArr;
        }
    }

    private DiskLruCache(File file, int i8, int i9, long j8) {
        this.f9810f = file;
        this.f9814j = i8;
        this.f9811g = new File(file, "journal");
        this.f9812h = new File(file, "journal.tmp");
        this.f9813i = new File(file, "journal.bkp");
        this.f9816l = i9;
        this.f9815k = j8;
    }

    private synchronized Editor I(String str, long j8) throws IOException {
        m();
        Entry entry = this.f9819o.get(str);
        if (j8 != -1 && (entry == null || entry.f9835g != j8)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.f9819o.put(str, entry);
        } else if (entry.f9834f != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.f9834f = editor;
        this.f9818n.append((CharSequence) "DIRTY");
        this.f9818n.append(' ');
        this.f9818n.append((CharSequence) str);
        this.f9818n.append('\n');
        N(this.f9818n);
        return editor;
    }

    @TargetApi(26)
    private static void N(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X() {
        int i8 = this.f9820p;
        if (i8 >= 2000 && i8 >= this.f9819o.size()) {
            return true;
        }
        return false;
    }

    public static DiskLruCache Y(File file, int i8, int i9, long j8) throws IOException {
        if (j8 > 0) {
            if (i9 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        s0(file2, file3, false);
                    }
                }
                DiskLruCache diskLruCache = new DiskLruCache(file, i8, i9, j8);
                if (diskLruCache.f9811g.exists()) {
                    try {
                        diskLruCache.c0();
                        diskLruCache.Z();
                        return diskLruCache;
                    } catch (IOException e8) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e8.getMessage() + ", removing");
                        diskLruCache.w();
                    }
                }
                file.mkdirs();
                DiskLruCache diskLruCache2 = new DiskLruCache(file, i8, i9, j8);
                diskLruCache2.f0();
                return diskLruCache2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void Z() throws IOException {
        y(this.f9812h);
        Iterator<Entry> it = this.f9819o.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i8 = 0;
            if (next.f9834f != null) {
                next.f9834f = null;
                while (i8 < this.f9816l) {
                    y(next.j(i8));
                    y(next.k(i8));
                    i8++;
                }
                it.remove();
            } else {
                while (i8 < this.f9816l) {
                    this.f9817m += next.f9830b[i8];
                    i8++;
                }
            }
        }
    }

    private void c0() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f9811g), Util.f9848a);
        try {
            String g8 = strictLineReader.g();
            String g9 = strictLineReader.g();
            String g10 = strictLineReader.g();
            String g11 = strictLineReader.g();
            String g12 = strictLineReader.g();
            if ("libcore.io.DiskLruCache".equals(g8) && "1".equals(g9) && Integer.toString(this.f9814j).equals(g10) && Integer.toString(this.f9816l).equals(g11) && "".equals(g12)) {
                int i8 = 0;
                while (true) {
                    try {
                        d0(strictLineReader.g());
                        i8++;
                    } catch (EOFException unused) {
                        this.f9820p = i8 - this.f9819o.size();
                        if (strictLineReader.e()) {
                            f0();
                        } else {
                            this.f9818n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9811g, true), Util.f9848a));
                        }
                        Util.a(strictLineReader);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + g8 + ", " + g9 + ", " + g11 + ", " + g12 + "]");
            }
        } catch (Throwable th) {
            Util.a(strictLineReader);
            throw th;
        }
    }

    private void d0(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i8 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i8);
            if (indexOf2 == -1) {
                substring = str.substring(i8);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f9819o.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i8, indexOf2);
            }
            Entry entry = this.f9819o.get(substring);
            if (entry == null) {
                entry = new Entry(substring);
                this.f9819o.put(substring, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.f9833e = true;
                entry.f9834f = null;
                entry.n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                entry.f9834f = new Editor(entry);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f0() throws IOException {
        Writer writer = this.f9818n;
        if (writer != null) {
            q(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9812h), Util.f9848a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f9814j));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f9816l));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (Entry entry : this.f9819o.values()) {
            if (entry.f9834f != null) {
                bufferedWriter.write("DIRTY " + entry.f9829a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + entry.f9829a + entry.l() + '\n');
            }
        }
        q(bufferedWriter);
        if (this.f9811g.exists()) {
            s0(this.f9811g, this.f9813i, true);
        }
        s0(this.f9812h, this.f9811g, false);
        this.f9813i.delete();
        this.f9818n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9811g, true), Util.f9848a));
    }

    private void m() {
        if (this.f9818n != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    @TargetApi(26)
    private static void q(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static void s0(File file, File file2, boolean z7) throws IOException {
        if (z7) {
            y(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t(Editor editor, boolean z7) throws IOException {
        Entry entry = editor.f9825a;
        if (entry.f9834f == editor) {
            if (z7 && !entry.f9833e) {
                for (int i8 = 0; i8 < this.f9816l; i8++) {
                    if (editor.f9826b[i8]) {
                        if (!entry.k(i8).exists()) {
                            editor.a();
                            return;
                        }
                    } else {
                        editor.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i8);
                    }
                }
            }
            for (int i9 = 0; i9 < this.f9816l; i9++) {
                File k8 = entry.k(i9);
                if (z7) {
                    if (k8.exists()) {
                        File j8 = entry.j(i9);
                        k8.renameTo(j8);
                        long j9 = entry.f9830b[i9];
                        long length = j8.length();
                        entry.f9830b[i9] = length;
                        this.f9817m = (this.f9817m - j9) + length;
                    }
                } else {
                    y(k8);
                }
            }
            this.f9820p++;
            entry.f9834f = null;
            if (entry.f9833e | z7) {
                entry.f9833e = true;
                this.f9818n.append((CharSequence) "CLEAN");
                this.f9818n.append(' ');
                this.f9818n.append((CharSequence) entry.f9829a);
                this.f9818n.append((CharSequence) entry.l());
                this.f9818n.append('\n');
                if (z7) {
                    long j10 = this.f9821q;
                    this.f9821q = 1 + j10;
                    entry.f9835g = j10;
                }
            } else {
                this.f9819o.remove(entry.f9829a);
                this.f9818n.append((CharSequence) "REMOVE");
                this.f9818n.append(' ');
                this.f9818n.append((CharSequence) entry.f9829a);
                this.f9818n.append('\n');
            }
            N(this.f9818n);
            if (this.f9817m > this.f9815k || X()) {
                this.f9822r.submit(this.f9823s);
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() throws IOException {
        while (this.f9817m > this.f9815k) {
            k0(this.f9819o.entrySet().iterator().next().getKey());
        }
    }

    private static void y(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public Editor F(String str) throws IOException {
        return I(str, -1L);
    }

    public synchronized Value O(String str) throws IOException {
        m();
        Entry entry = this.f9819o.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f9833e) {
            return null;
        }
        for (File file : entry.f9831c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f9820p++;
        this.f9818n.append((CharSequence) "READ");
        this.f9818n.append(' ');
        this.f9818n.append((CharSequence) str);
        this.f9818n.append('\n');
        if (X()) {
            this.f9822r.submit(this.f9823s);
        }
        return new Value(str, entry.f9835g, entry.f9831c, entry.f9830b);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f9818n == null) {
            return;
        }
        Iterator it = new ArrayList(this.f9819o.values()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.f9834f != null) {
                entry.f9834f.a();
            }
        }
        v0();
        q(this.f9818n);
        this.f9818n = null;
    }

    public synchronized boolean k0(String str) throws IOException {
        m();
        Entry entry = this.f9819o.get(str);
        if (entry != null && entry.f9834f == null) {
            for (int i8 = 0; i8 < this.f9816l; i8++) {
                File j8 = entry.j(i8);
                if (j8.exists() && !j8.delete()) {
                    throw new IOException("failed to delete " + j8);
                }
                this.f9817m -= entry.f9830b[i8];
                entry.f9830b[i8] = 0;
            }
            this.f9820p++;
            this.f9818n.append((CharSequence) "REMOVE");
            this.f9818n.append(' ');
            this.f9818n.append((CharSequence) str);
            this.f9818n.append('\n');
            this.f9819o.remove(str);
            if (X()) {
                this.f9822r.submit(this.f9823s);
            }
            return true;
        }
        return false;
    }

    public void w() throws IOException {
        close();
        Util.b(this.f9810f);
    }
}
