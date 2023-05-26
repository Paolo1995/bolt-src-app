package com.google.firebase.crashlytics.internal.persistence;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class FileStore {

    /* renamed from: a  reason: collision with root package name */
    private final File f16126a;

    /* renamed from: b  reason: collision with root package name */
    private final File f16127b;

    /* renamed from: c  reason: collision with root package name */
    private final File f16128c;

    /* renamed from: d  reason: collision with root package name */
    private final File f16129d;

    /* renamed from: e  reason: collision with root package name */
    private final File f16130e;

    /* renamed from: f  reason: collision with root package name */
    private final File f16131f;

    public FileStore(Context context) {
        String str;
        String processName;
        File filesDir = context.getFilesDir();
        this.f16126a = filesDir;
        if (v()) {
            StringBuilder sb = new StringBuilder();
            sb.append(".com.google.firebase.crashlytics.files.v2");
            sb.append(File.pathSeparator);
            processName = Application.getProcessName();
            sb.append(u(processName));
            str = sb.toString();
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File q8 = q(new File(filesDir, str));
        this.f16127b = q8;
        this.f16128c = q(new File(q8, "open-sessions"));
        this.f16129d = q(new File(q8, "reports"));
        this.f16130e = q(new File(q8, "priority-reports"));
        this.f16131f = q(new File(q8, "native-reports"));
    }

    private void a(File file) {
        if (file.exists() && s(file)) {
            Logger f8 = Logger.f();
            f8.b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private File n(String str) {
        return r(new File(this.f16128c, str));
    }

    private static synchronized File q(File file) {
        synchronized (FileStore.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                Logger f8 = Logger.f();
                f8.b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                Logger f9 = Logger.f();
                f9.d("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        }
    }

    private static File r(File file) {
        file.mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                s(file2);
            }
        }
        return file.delete();
    }

    private static <T> List<T> t(T[] tArr) {
        if (tArr == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(tArr);
    }

    static String u(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static boolean v() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public void b() {
        a(new File(this.f16126a, ".com.google.firebase.crashlytics"));
        a(new File(this.f16126a, ".com.google.firebase.crashlytics-ndk"));
        if (v()) {
            a(new File(this.f16126a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    public boolean c(String str) {
        return s(new File(this.f16128c, str));
    }

    public List<String> d() {
        return t(this.f16128c.list());
    }

    public File e(String str) {
        return new File(this.f16127b, str);
    }

    public List<File> f(FilenameFilter filenameFilter) {
        return t(this.f16127b.listFiles(filenameFilter));
    }

    public File g(String str) {
        return new File(this.f16131f, str);
    }

    public List<File> h() {
        return t(this.f16131f.listFiles());
    }

    public File i(String str) {
        return r(new File(n(str), "native"));
    }

    public File j(String str) {
        return new File(this.f16130e, str);
    }

    public List<File> k() {
        return t(this.f16130e.listFiles());
    }

    public File l(String str) {
        return new File(this.f16129d, str);
    }

    public List<File> m() {
        return t(this.f16129d.listFiles());
    }

    public File o(String str, String str2) {
        return new File(n(str), str2);
    }

    public List<File> p(String str, FilenameFilter filenameFilter) {
        return t(n(str).listFiles(filenameFilter));
    }
}
