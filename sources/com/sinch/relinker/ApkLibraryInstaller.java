package com.sinch.relinker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.sinch.relinker.ReLinker;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class ApkLibraryInstaller implements ReLinker.LibraryInstaller {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final int MAX_TRIES = 5;

    /* loaded from: classes3.dex */
    public static class ZipFileInZipEntry {
        public ZipEntry zipEntry;
        public ZipFile zipFile;

        public ZipFileInZipEntry(ZipFile zipFile, ZipEntry zipEntry) {
            this.zipFile = zipFile;
            this.zipEntry = zipEntry;
        }
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j8 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j8;
            }
            outputStream.write(bArr, 0, read);
            j8 += read;
        }
    }

    private ZipFileInZipEntry findApkWithLibrary(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        String[] sourceDirectories = sourceDirectories(context);
        int length = sourceDirectories.length;
        char c8 = 0;
        int i8 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i8 >= length) {
                return null;
            }
            String str2 = sourceDirectories[i8];
            int i9 = 0;
            while (true) {
                int i10 = i9 + 1;
                if (i9 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i9 = i10;
                }
            }
            if (zipFile != null) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    if (i11 < 5) {
                        int length2 = strArr.length;
                        int i13 = 0;
                        while (i13 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i13] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c8] = str3;
                            objArr[1] = str2;
                            reLinkerInstance.log("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new ZipFileInZipEntry(zipFile, entry);
                            }
                            i13++;
                            c8 = 0;
                        }
                        i11 = i12;
                        c8 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i8++;
            c8 = 0;
        }
    }

    private String[] getSupportedAbis(Context context, String str) {
        Pattern compile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        for (String str2 : sourceDirectories(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private String[] sourceDirectories(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // com.sinch.relinker.ReLinker.LibraryInstaller
    @SuppressLint({"SetWorldReadable"})
    public void installLibrary(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) {
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long copy;
        ZipFileInZipEntry zipFileInZipEntry = null;
        r0 = null;
        Closeable closeable = null;
        try {
            ZipFileInZipEntry findApkWithLibrary = findApkWithLibrary(context, strArr, str, reLinkerInstance);
            try {
                if (findApkWithLibrary == null) {
                    try {
                        strArr2 = getSupportedAbis(context, str);
                    } catch (Exception e8) {
                        strArr2 = new String[]{e8.toString()};
                    }
                    throw new MissingLibraryException(str, strArr, strArr2);
                }
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i8 >= 5) {
                        reLinkerInstance.log("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile = findApkWithLibrary.zipFile;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    reLinkerInstance.log("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = findApkWithLibrary.zipFile.getInputStream(findApkWithLibrary.zipEntry);
                            } catch (FileNotFoundException unused2) {
                                inputStream = null;
                            } catch (IOException unused3) {
                                inputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = null;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (FileNotFoundException unused4) {
                                fileOutputStream = null;
                                closeSilently(inputStream);
                                closeSilently(fileOutputStream);
                                i8 = i9;
                            } catch (IOException unused5) {
                                fileOutputStream = null;
                                closeSilently(inputStream);
                                closeSilently(fileOutputStream);
                                i8 = i9;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                copy = copy(inputStream, fileOutputStream);
                                fileOutputStream.getFD().sync();
                            } catch (FileNotFoundException | IOException unused6) {
                                closeSilently(inputStream);
                                closeSilently(fileOutputStream);
                                i8 = i9;
                            } catch (Throwable th4) {
                                th = th4;
                                closeable = fileOutputStream;
                                closeSilently(inputStream);
                                closeSilently(closeable);
                                throw th;
                            }
                            if (copy == file.length()) {
                                closeSilently(inputStream);
                                closeSilently(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile2 = findApkWithLibrary.zipFile;
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused7) {
                                    return;
                                }
                            }
                            closeSilently(inputStream);
                            closeSilently(fileOutputStream);
                        }
                    } catch (IOException unused8) {
                    }
                    i8 = i9;
                }
            } catch (Throwable th5) {
                th = th5;
                zipFileInZipEntry = findApkWithLibrary;
                if (zipFileInZipEntry != null) {
                    try {
                        ZipFile zipFile3 = zipFileInZipEntry.zipFile;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused9) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
