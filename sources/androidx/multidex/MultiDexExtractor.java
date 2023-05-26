package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
final class MultiDexExtractor implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private final File f6861f;

    /* renamed from: g  reason: collision with root package name */
    private final long f6862g;

    /* renamed from: h  reason: collision with root package name */
    private final File f6863h;

    /* renamed from: i  reason: collision with root package name */
    private final RandomAccessFile f6864i;

    /* renamed from: j  reason: collision with root package name */
    private final FileChannel f6865j;

    /* renamed from: k  reason: collision with root package name */
    private final FileLock f6866k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ExtractedDex extends File {

        /* renamed from: f  reason: collision with root package name */
        public long f6868f;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.f6868f = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiDexExtractor(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f6861f = file;
        this.f6863h = file2;
        this.f6862g = j(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f6864i = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f6865j = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f6866k = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e8) {
                e = e8;
                c(this.f6865j);
                throw e;
            } catch (Error e9) {
                e = e9;
                c(this.f6865j);
                throw e;
            } catch (RuntimeException e10) {
                e = e10;
                c(this.f6865j);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e11) {
            c(this.f6864i);
            throw e11;
        }
    }

    private void a() {
        File[] listFiles = this.f6863h.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f6863h.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    private static void c(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e8) {
            Log.w("MultiDex", "Failed to close resource", e8);
        }
    }

    private static void e(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } finally {
            c(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences g(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    private static long h(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static long j(File file) throws IOException {
        long c8 = ZipUtil.c(file);
        if (c8 == -1) {
            return c8 - 1;
        }
        return c8;
    }

    private static boolean k(Context context, File file, long j8, String str) {
        SharedPreferences g8 = g(context);
        if (g8.getLong(str + "timestamp", -1L) == h(file)) {
            if (g8.getLong(str + "crc", -1L) == j8) {
                return false;
            }
        }
        return true;
    }

    private List<ExtractedDex> m(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f6861f.getName() + ".classes";
        SharedPreferences g8 = g(context);
        int i8 = g8.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i8 + (-1));
        int i9 = 2;
        while (i9 <= i8) {
            ExtractedDex extractedDex = new ExtractedDex(this.f6863h, str2 + i9 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.f6868f = j(extractedDex);
                long j8 = g8.getLong(str + "dex.crc." + i9, -1L);
                long j9 = g8.getLong(str + "dex.time." + i9, -1L);
                long lastModified = extractedDex.lastModified();
                if (j9 == lastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences = g8;
                    if (j8 == extractedDex.f6868f) {
                        arrayList.add(extractedDex);
                        i9++;
                        g8 = sharedPreferences;
                        str2 = str3;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j9 + ", modification time: " + lastModified + ", expected crc: " + j8 + ", file crc: " + extractedDex.f6868f);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private List<ExtractedDex> q() throws IOException {
        boolean z7;
        String str;
        String str2 = this.f6861f.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f6861f);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i8 = 2;
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.f6863h, str2 + i8 + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                int i9 = 0;
                boolean z8 = false;
                while (i9 < 3 && !z8) {
                    int i10 = i9 + 1;
                    e(zipFile, entry, extractedDex, str2);
                    try {
                        extractedDex.f6868f = j(extractedDex);
                        z7 = true;
                    } catch (IOException e8) {
                        Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e8);
                        z7 = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    if (z7) {
                        str = "succeeded";
                    } else {
                        str = "failed";
                    }
                    sb.append(str);
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.f6868f);
                    Log.i("MultiDex", sb.toString());
                    if (!z7) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z8 = z7;
                    i9 = i10;
                }
                if (z8) {
                    i8++;
                    entry = zipFile.getEntry("classes" + i8 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i8 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e9) {
                Log.w("MultiDex", "Failed to close resource", e9);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e10) {
                Log.w("MultiDex", "Failed to close resource", e10);
            }
            throw th;
        }
    }

    private static void t(Context context, String str, long j8, long j9, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = g(context).edit();
        edit.putLong(str + "timestamp", j8);
        edit.putLong(str + "crc", j9);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i8 = 2;
        for (ExtractedDex extractedDex : list) {
            edit.putLong(str + "dex.crc." + i8, extractedDex.f6868f);
            edit.putLong(str + "dex.time." + i8, extractedDex.lastModified());
            i8++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6866k.release();
        this.f6865j.close();
        this.f6864i.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends File> l(Context context, String str, boolean z7) throws IOException {
        List<ExtractedDex> q8;
        List<ExtractedDex> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f6861f.getPath() + ", " + z7 + ", " + str + ")");
        if (this.f6866k.isValid()) {
            if (!z7 && !k(context, this.f6861f, this.f6862g, str)) {
                try {
                    list = m(context, str);
                } catch (IOException e8) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e8);
                    q8 = q();
                    t(context, str, h(this.f6861f), this.f6862g, q8);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            if (z7) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            q8 = q();
            t(context, str, h(this.f6861f), this.f6862g, q8);
            list = q8;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
