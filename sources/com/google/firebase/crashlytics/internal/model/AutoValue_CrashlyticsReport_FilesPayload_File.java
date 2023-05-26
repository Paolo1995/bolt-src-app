package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.FilesPayload.File {

    /* renamed from: a  reason: collision with root package name */
    private final String f15936a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f15937b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.FilesPayload.File.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f15938a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f15939b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File a() {
            String str = "";
            if (this.f15938a == null) {
                str = " filename";
            }
            if (this.f15939b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(this.f15938a, this.f15939b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File.Builder b(byte[] bArr) {
            if (bArr != null) {
                this.f15939b = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File.Builder c(String str) {
            if (str != null) {
                this.f15938a = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    @NonNull
    public byte[] b() {
        return this.f15937b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    @NonNull
    public String c() {
        return this.f15936a;
    }

    public boolean equals(Object obj) {
        byte[] b8;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload.File)) {
            return false;
        }
        CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
        if (this.f15936a.equals(file.c())) {
            byte[] bArr = this.f15937b;
            if (file instanceof AutoValue_CrashlyticsReport_FilesPayload_File) {
                b8 = ((AutoValue_CrashlyticsReport_FilesPayload_File) file).f15937b;
            } else {
                b8 = file.b();
            }
            if (Arrays.equals(bArr, b8)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f15936a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f15937b);
    }

    public String toString() {
        return "File{filename=" + this.f15936a + ", contents=" + Arrays.toString(this.f15937b) + "}";
    }

    private AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr) {
        this.f15936a = str;
        this.f15937b = bArr;
    }
}
