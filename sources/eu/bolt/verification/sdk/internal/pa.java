package eu.bolt.verification.sdk.internal;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public interface pa {

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f44523a;

        /* renamed from: b  reason: collision with root package name */
        private final String f44524b;

        /* renamed from: c  reason: collision with root package name */
        private final String f44525c;

        /* renamed from: d  reason: collision with root package name */
        private final File f44526d;

        public a(String str, String str2, String str3, File file) {
            this.f44523a = str;
            this.f44524b = str2;
            this.f44525c = str3;
            this.f44526d = file;
        }

        public /* synthetic */ a(String str, String str2, String str3, File file, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : file);
        }
    }

    void a(a aVar);
}
