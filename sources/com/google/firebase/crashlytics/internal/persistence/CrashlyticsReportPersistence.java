package com.google.firebase.crashlytics.internal.persistence;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class CrashlyticsReportPersistence {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f16118d = Charset.forName("UTF-8");

    /* renamed from: e  reason: collision with root package name */
    private static final int f16119e = 15;

    /* renamed from: f  reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f16120f = new CrashlyticsReportJsonTransform();

    /* renamed from: g  reason: collision with root package name */
    private static final Comparator<? super File> f16121g = new Comparator() { // from class: a0.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int u7;
            u7 = CrashlyticsReportPersistence.u((File) obj, (File) obj2);
            return u7;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final FilenameFilter f16122h = new FilenameFilter() { // from class: a0.d
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean v7;
            v7 = CrashlyticsReportPersistence.v(file, str);
            return v7;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f16123a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final FileStore f16124b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final SettingsProvider f16125c;

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsProvider settingsProvider) {
        this.f16124b = fileStore;
        this.f16125c = settingsProvider;
    }

    @NonNull
    private static String A(@NonNull File file) throws IOException {
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f16118d);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private void B(@NonNull File file, @NonNull CrashlyticsReport.FilesPayload filesPayload, @NonNull String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f16120f;
            F(this.f16124b.g(str), crashlyticsReportJsonTransform.E(crashlyticsReportJsonTransform.D(A(file)).m(filesPayload)));
        } catch (IOException e8) {
            Logger f8 = Logger.f();
            f8.l("Could not synthesize final native report file for " + file, e8);
        }
    }

    private void C(String str, long j8) {
        boolean z7;
        List<File> p8 = this.f16124b.p(str, f16122h);
        if (p8.isEmpty()) {
            Logger f8 = Logger.f();
            f8.i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(p8);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z7 = false;
            for (File file : p8) {
                try {
                    arrayList.add(f16120f.g(A(file)));
                } catch (IOException e8) {
                    Logger f9 = Logger.f();
                    f9.l("Could not add event to report for " + file, e8);
                }
                if (z7 || s(file.getName())) {
                    z7 = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger f10 = Logger.f();
            f10.k("Could not parse event files for session " + str);
            return;
        }
        D(this.f16124b.o(str, "report"), arrayList, j8, z7, UserMetadata.j(str, this.f16124b));
    }

    private void D(@NonNull File file, @NonNull List<CrashlyticsReport.Session.Event> list, long j8, boolean z7, String str) {
        File l8;
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f16120f;
            CrashlyticsReport l9 = crashlyticsReportJsonTransform.D(A(file)).n(j8, z7, str).l(ImmutableList.b(list));
            CrashlyticsReport.Session j9 = l9.j();
            if (j9 == null) {
                return;
            }
            if (z7) {
                l8 = this.f16124b.j(j9.h());
            } else {
                l8 = this.f16124b.l(j9.h());
            }
            F(l8, crashlyticsReportJsonTransform.E(l9));
        } catch (IOException e8) {
            Logger f8 = Logger.f();
            f8.l("Could not synthesize final report file for " + file, e8);
        }
    }

    private int E(String str, int i8) {
        List<File> p8 = this.f16124b.p(str, new FilenameFilter() { // from class: a0.a
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                boolean t7;
                t7 = CrashlyticsReportPersistence.t(file, str2);
                return t7;
            }
        });
        Collections.sort(p8, new Comparator() { // from class: a0.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int x7;
                x7 = CrashlyticsReportPersistence.x((File) obj, (File) obj2);
                return x7;
            }
        });
        return f(p8, i8);
    }

    private static void F(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f16118d);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void G(File file, String str, long j8) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f16118d);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j8));
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private SortedSet<String> e(String str) {
        this.f16124b.b();
        SortedSet<String> p8 = p();
        if (str != null) {
            p8.remove(str);
        }
        if (p8.size() <= 8) {
            return p8;
        }
        while (p8.size() > 8) {
            String last = p8.last();
            Logger f8 = Logger.f();
            f8.b("Removing session over cap: " + last);
            this.f16124b.c(last);
            p8.remove(last);
        }
        return p8;
    }

    private static int f(List<File> list, int i8) {
        int size = list.size();
        for (File file : list) {
            if (size <= i8) {
                return size;
            }
            FileStore.s(file);
            size--;
        }
        return size;
    }

    private void g() {
        int i8 = this.f16125c.b().f16157a.f16168b;
        List<File> n8 = n();
        int size = n8.size();
        if (size <= i8) {
            return;
        }
        for (File file : n8.subList(i8, size)) {
            file.delete();
        }
    }

    private static long h(long j8) {
        return j8 * 1000;
    }

    private void j(List<File> list) {
        for (File file : list) {
            file.delete();
        }
    }

    @NonNull
    private static String m(int i8, boolean z7) {
        String str;
        String format = String.format(Locale.US, "%010d", Integer.valueOf(i8));
        if (z7) {
            str = "_";
        } else {
            str = "";
        }
        return "event" + format + str;
    }

    private List<File> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f16124b.k());
        arrayList.addAll(this.f16124b.h());
        Comparator<? super File> comparator = f16121g;
        Collections.sort(arrayList, comparator);
        List<File> m8 = this.f16124b.m();
        Collections.sort(m8, comparator);
        arrayList.addAll(m8);
        return arrayList;
    }

    @NonNull
    private static String o(@NonNull String str) {
        return str.substring(0, f16119e);
    }

    private static boolean s(@NonNull String str) {
        if (str.startsWith("event") && str.endsWith("_")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(@NonNull File file, @NonNull String str) {
        if (str.startsWith("event") && !str.endsWith("_")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int u(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean v(File file, String str) {
        return str.startsWith("event");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(@NonNull File file, @NonNull File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    public void i() {
        j(this.f16124b.m());
        j(this.f16124b.k());
        j(this.f16124b.h());
    }

    public void k(String str, long j8) {
        for (String str2 : e(str)) {
            Logger f8 = Logger.f();
            f8.i("Finalizing report for session " + str2);
            C(str2, j8);
            this.f16124b.c(str2);
        }
        g();
    }

    public void l(String str, CrashlyticsReport.FilesPayload filesPayload) {
        File o8 = this.f16124b.o(str, "report");
        Logger f8 = Logger.f();
        f8.b("Writing native session report for " + str + " to file: " + o8);
        B(o8, filesPayload, str);
    }

    public SortedSet<String> p() {
        return new TreeSet(this.f16124b.d()).descendingSet();
    }

    public long q(String str) {
        return this.f16124b.o(str, "start-time").lastModified();
    }

    public boolean r() {
        if (this.f16124b.m().isEmpty() && this.f16124b.k().isEmpty() && this.f16124b.h().isEmpty()) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<CrashlyticsReportWithSessionId> w() {
        List<File> n8 = n();
        ArrayList arrayList = new ArrayList();
        for (File file : n8) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.a(f16120f.D(A(file)), file.getName(), file));
            } catch (IOException e8) {
                Logger f8 = Logger.f();
                f8.l("Could not load report file " + file + "; deleting", e8);
                file.delete();
            }
        }
        return arrayList;
    }

    public void y(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str, boolean z7) {
        int i8 = this.f16125c.b().f16157a.f16167a;
        try {
            F(this.f16124b.o(str, m(this.f16123a.getAndIncrement(), z7)), f16120f.h(event));
        } catch (IOException e8) {
            Logger f8 = Logger.f();
            f8.l("Could not persist event for session " + str, e8);
        }
        E(str, i8);
    }

    public void z(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session j8 = crashlyticsReport.j();
        if (j8 == null) {
            Logger.f().b("Could not get session for report");
            return;
        }
        String h8 = j8.h();
        try {
            F(this.f16124b.o(h8, "report"), f16120f.E(crashlyticsReport));
            G(this.f16124b.o(h8, "start-time"), "", j8.k());
        } catch (IOException e8) {
            Logger f8 = Logger.f();
            f8.c("Could not persist report for session " + h8, e8);
        }
    }
}
