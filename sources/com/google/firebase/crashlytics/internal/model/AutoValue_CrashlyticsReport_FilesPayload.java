package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.FilesPayload.File> f15932a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15933b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.FilesPayload.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.FilesPayload.File> f15934a;

        /* renamed from: b  reason: collision with root package name */
        private String f15935b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload a() {
            String str = "";
            if (this.f15934a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_FilesPayload(this.f15934a, this.f15935b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload.Builder b(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList) {
            if (immutableList != null) {
                this.f15934a = immutableList;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload.Builder c(String str) {
            this.f15935b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    @NonNull
    public ImmutableList<CrashlyticsReport.FilesPayload.File> b() {
        return this.f15932a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public String c() {
        return this.f15933b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (this.f15932a.equals(filesPayload.b())) {
            String str = this.f15933b;
            if (str == null) {
                if (filesPayload.c() == null) {
                    return true;
                }
            } else if (str.equals(filesPayload.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f15932a.hashCode() ^ 1000003) * 1000003;
        String str = this.f15933b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "FilesPayload{files=" + this.f15932a + ", orgId=" + this.f15933b + "}";
    }

    private AutoValue_CrashlyticsReport_FilesPayload(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList, String str) {
        this.f15932a = immutableList;
        this.f15933b = str;
    }
}
