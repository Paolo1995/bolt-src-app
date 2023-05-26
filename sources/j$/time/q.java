package j$.time;

import j$.time.zone.ZoneRules;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q extends ZoneId {

    /* renamed from: b  reason: collision with root package name */
    private final String f50087b;

    /* renamed from: c  reason: collision with root package name */
    private final transient ZoneRules f50088c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, ZoneRules zoneRules) {
        this.f50087b = str;
        this.f50088c = zoneRules;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q r(String str) {
        if (str != null) {
            int length = str.length();
            if (length < 2) {
                throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
            }
            for (int i8 = 0; i8 < length; i8++) {
                char charAt = str.charAt(i8);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i8 == 0) && ((charAt < '0' || charAt > '9' || i8 == 0) && ((charAt != '~' || i8 == 0) && ((charAt != '.' || i8 == 0) && ((charAt != '_' || i8 == 0) && ((charAt != '+' || i8 == 0) && (charAt != '-' || i8 == 0))))))))) {
                    throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
                }
            }
            try {
                return new q(str, j$.time.zone.f.b(str, true));
            } catch (j$.time.zone.c e8) {
                throw e8;
            }
        }
        throw new NullPointerException("zoneId");
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f50087b;
    }

    @Override // j$.time.ZoneId
    public final ZoneRules getRules() {
        ZoneRules zoneRules = this.f50088c;
        return zoneRules != null ? zoneRules : j$.time.zone.f.b(this.f50087b, false);
    }
}
