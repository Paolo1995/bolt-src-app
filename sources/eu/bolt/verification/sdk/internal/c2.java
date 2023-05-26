package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class c2 implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends c2 {

        /* renamed from: f  reason: collision with root package name */
        private final String f42422f;

        /* renamed from: g  reason: collision with root package name */
        private final List<String> f42423g;

        /* renamed from: h  reason: collision with root package name */
        private final EnumC0039a f42424h;

        /* renamed from: eu.bolt.verification.sdk.internal.c2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public enum EnumC0039a {
            ALL,
            AT_LEAST_ONE
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String checkBoxGroupId, List<String> requiredVariantsIds, EnumC0039a mode) {
            super(null);
            Intrinsics.f(checkBoxGroupId, "checkBoxGroupId");
            Intrinsics.f(requiredVariantsIds, "requiredVariantsIds");
            Intrinsics.f(mode, "mode");
            this.f42422f = checkBoxGroupId;
            this.f42423g = requiredVariantsIds;
            this.f42424h = mode;
        }

        public final String a() {
            return this.f42422f;
        }

        public final EnumC0039a b() {
            return this.f42424h;
        }

        public final List<String> c() {
            return this.f42423g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42422f, aVar.f42422f) && Intrinsics.a(this.f42423g, aVar.f42423g) && this.f42424h == aVar.f42424h;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f42422f.hashCode() * 31) + this.f42423g.hashCode()) * 31) + this.f42424h.hashCode();
        }

        public String toString() {
            String str = this.f42422f;
            List<String> list = this.f42423g;
            EnumC0039a enumC0039a = this.f42424h;
            return "CheckBoxSelected(checkBoxGroupId=" + str + ", requiredVariantsIds=" + list + ", mode=" + enumC0039a + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends c2 {

        /* renamed from: f  reason: collision with root package name */
        private final String f42428f;

        /* renamed from: g  reason: collision with root package name */
        private final String f42429g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String fieldId, String regex) {
            super(null);
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(regex, "regex");
            this.f42428f = fieldId;
            this.f42429g = regex;
        }

        public final String a() {
            return this.f42428f;
        }

        public final String b() {
            return this.f42429g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f42428f, bVar.f42428f) && Intrinsics.a(this.f42429g, bVar.f42429g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f42428f.hashCode() * 31) + this.f42429g.hashCode();
        }

        public String toString() {
            String str = this.f42428f;
            String str2 = this.f42429g;
            return "FieldRegex(fieldId=" + str + ", regex=" + str2 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends c2 {

        /* renamed from: f  reason: collision with root package name */
        private final String f42430f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String fieldId) {
            super(null);
            Intrinsics.f(fieldId, "fieldId");
            this.f42430f = fieldId;
        }

        public final String a() {
            return this.f42430f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.a(this.f42430f, ((c) obj).f42430f);
        }

        public int hashCode() {
            return this.f42430f.hashCode();
        }

        public String toString() {
            String str = this.f42430f;
            return "HasRequiredAnswer(fieldId=" + str + ")";
        }
    }

    private c2() {
    }

    public /* synthetic */ c2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
