package j$.time;

import j$.time.zone.ZoneRules;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class ZoneId implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f49965a;

    static {
        HashMap hashMap = new HashMap(64);
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        f49965a = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != q.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId of(String str) {
        int i8;
        if (str != null) {
            if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
                return ZoneOffset.of(str);
            }
            if (str.startsWith("UTC") || str.startsWith("GMT")) {
                i8 = 3;
            } else if (!str.startsWith("UT")) {
                return q.r(str);
            } else {
                i8 = 2;
            }
            String substring = str.substring(0, i8);
            if (str.length() == i8) {
                return q(substring, ZoneOffset.UTC);
            }
            if (str.charAt(i8) == '+' || str.charAt(i8) == '-') {
                try {
                    ZoneOffset of = ZoneOffset.of(str.substring(i8));
                    ZoneOffset zoneOffset = ZoneOffset.UTC;
                    return q(substring, of);
                } catch (DateTimeException e8) {
                    throw new DateTimeException("Invalid ID for offset-based ZoneId: " + str, e8);
                }
            }
            return q.r(str);
        }
        throw new NullPointerException("zoneId");
    }

    public static ZoneId q(String str, ZoneOffset zoneOffset) {
        if (str != null) {
            if (zoneOffset != null) {
                if (str.length() == 0) {
                    return zoneOffset;
                }
                if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
                    if (zoneOffset.s() != 0) {
                        str = str.concat(zoneOffset.getId());
                    }
                    return new q(str, ZoneRules.h(zoneOffset));
                }
                throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
            }
            throw new NullPointerException("offset");
        }
        throw new NullPointerException("prefix");
    }

    public static ZoneId systemDefault() {
        String id = TimeZone.getDefault().getID();
        Map map = f49965a;
        if (id != null) {
            if (map != null) {
                String str = (String) map.get(id);
                if (str != null) {
                    id = str;
                }
                return of(id);
            }
            throw new NullPointerException("aliasMap");
        }
        throw new NullPointerException("zoneId");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public abstract String getId();

    public abstract ZoneRules getRules();

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        try {
            ZoneRules rules = getRules();
            if (rules.isFixedOffset()) {
                return rules.d(Instant.EPOCH);
            }
        } catch (j$.time.zone.c unused) {
        }
        return this;
    }

    public String toString() {
        return getId();
    }
}
