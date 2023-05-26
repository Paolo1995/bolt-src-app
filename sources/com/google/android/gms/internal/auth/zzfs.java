package com.google.android.gms.internal.auth;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzfs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzfq zzfqVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfqVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i8, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i8, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i8, str, entry);
            }
        } else {
            sb.append('\n');
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzgn.zza(zzeb.zzl((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzeb) {
                sb.append(": \"");
                sb.append(zzgn.zza((zzeb) obj));
                sb.append('\"');
            } else if (obj instanceof zzeq) {
                sb.append(" {");
                zzd((zzeq) obj, sb, i8 + 2);
                sb.append("\n");
                while (i9 < i8) {
                    sb.append(' ');
                    i9++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i11 = i8 + 2;
                zzb(sb, i11, "key", entry2.getKey());
                zzb(sb, i11, AppMeasurementSdk.ConditionalUserProperty.VALUE, entry2.getValue());
                sb.append("\n");
                while (i9 < i8) {
                    sb.append(' ');
                    i9++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < str.length(); i8++) {
            char charAt = str.charAt(i8);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzfq zzfqVar, StringBuilder sb, int i8) {
        Method[] declaredMethods;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean equals;
        String str6;
        String str7;
        String str8;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzfqVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str9 : treeSet) {
            if (str9.startsWith("get")) {
                str = str9.substring(3);
            } else {
                str = str9;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String valueOf = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(str.substring(1, str.length() - 4));
                if (valueOf2.length() != 0) {
                    str8 = valueOf.concat(valueOf2);
                } else {
                    str8 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str9);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i8, zzc(str8), zzeq.zzf(method2, zzfqVar, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String valueOf3 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(str.substring(1, str.length() - 3));
                if (valueOf4.length() != 0) {
                    str7 = valueOf3.concat(valueOf4);
                } else {
                    str7 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str9);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i8, zzc(str7), zzeq.zzf(method3, zzfqVar, new Object[0]));
                }
            }
            if (str.length() != 0) {
                str2 = "set".concat(str);
            } else {
                str2 = new String("set");
            }
            if (((Method) hashMap2.get(str2)) != null) {
                if (str.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(str.substring(0, str.length() - 5));
                    if (valueOf5.length() != 0) {
                        str6 = "get".concat(valueOf5);
                    } else {
                        str6 = new String("get");
                    }
                    if (!hashMap.containsKey(str6)) {
                    }
                }
                String valueOf6 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(str.substring(1));
                if (valueOf7.length() != 0) {
                    str3 = valueOf6.concat(valueOf7);
                } else {
                    str3 = new String(valueOf6);
                }
                if (str.length() != 0) {
                    str4 = "get".concat(str);
                } else {
                    str4 = new String("get");
                }
                Method method4 = (Method) hashMap.get(str4);
                if (str.length() != 0) {
                    str5 = "has".concat(str);
                } else {
                    str5 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str5);
                if (method4 != null) {
                    Object zzf = zzeq.zzf(method4, zzfqVar, new Object[0]);
                    if (method5 == null) {
                        if (zzf instanceof Boolean) {
                            if (((Boolean) zzf).booleanValue()) {
                                zzb(sb, i8, zzc(str3), zzf);
                            }
                        } else if (zzf instanceof Integer) {
                            if (((Integer) zzf).intValue() != 0) {
                                zzb(sb, i8, zzc(str3), zzf);
                            }
                        } else if (zzf instanceof Float) {
                            if (((Float) zzf).floatValue() != 0.0f) {
                                zzb(sb, i8, zzc(str3), zzf);
                            }
                        } else if (zzf instanceof Double) {
                            if (((Double) zzf).doubleValue() != 0.0d) {
                                zzb(sb, i8, zzc(str3), zzf);
                            }
                        } else {
                            if (zzf instanceof String) {
                                equals = zzf.equals("");
                            } else if (zzf instanceof zzeb) {
                                equals = zzf.equals(zzeb.zzb);
                            } else if (zzf instanceof zzfq) {
                                if (zzf != ((zzfq) zzf).zzh()) {
                                    zzb(sb, i8, zzc(str3), zzf);
                                }
                            } else {
                                if ((zzf instanceof Enum) && ((Enum) zzf).ordinal() == 0) {
                                }
                                zzb(sb, i8, zzc(str3), zzf);
                            }
                            if (!equals) {
                                zzb(sb, i8, zzc(str3), zzf);
                            }
                        }
                    } else if (((Boolean) zzeq.zzf(method5, zzfqVar, new Object[0])).booleanValue()) {
                        zzb(sb, i8, zzc(str3), zzf);
                    }
                }
            }
        }
        if (!(zzfqVar instanceof zzep)) {
            zzgq zzgqVar = ((zzeq) zzfqVar).zzc;
            if (zzgqVar != null) {
                zzgqVar.zze(sb, i8);
                return;
            }
            return;
        }
        zzep zzepVar = (zzep) zzfqVar;
        throw null;
    }
}
