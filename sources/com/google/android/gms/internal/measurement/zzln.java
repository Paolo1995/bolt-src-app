package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzln {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzll zzllVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzllVar, sb, 0);
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
                sb.append(zzml.zza(zzjd.zzm((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzjd) {
                sb.append(": \"");
                sb.append(zzml.zza((zzjd) obj));
                sb.append('\"');
            } else if (obj instanceof zzke) {
                sb.append(" {");
                zzd((zzke) obj, sb, i8 + 2);
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
                sb.append(obj);
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

    private static void zzd(zzll zzllVar, StringBuilder sb, int i8) {
        Method[] declaredMethods;
        String str;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzllVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str2 : treeSet) {
            if (str2.startsWith("get")) {
                str = str2.substring(3);
            } else {
                str = str2;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String concat = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 4)));
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i8, zzc(concat), zzke.zzbH(method2, zzllVar, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String concat2 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 3)));
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i8, zzc(concat2), zzke.zzbH(method3, zzllVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(str))) != null && (!str.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(str.substring(0, str.length() - 5)))))) {
                String concat3 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(str));
                Method method5 = (Method) hashMap.get("has".concat(str));
                if (method4 != null) {
                    Object zzbH = zzke.zzbH(method4, zzllVar, new Object[0]);
                    if (method5 == null) {
                        if (zzbH instanceof Boolean) {
                            if (((Boolean) zzbH).booleanValue()) {
                                zzb(sb, i8, zzc(concat3), zzbH);
                            }
                        } else if (zzbH instanceof Integer) {
                            if (((Integer) zzbH).intValue() != 0) {
                                zzb(sb, i8, zzc(concat3), zzbH);
                            }
                        } else if (zzbH instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbH).floatValue()) != 0) {
                                zzb(sb, i8, zzc(concat3), zzbH);
                            }
                        } else if (zzbH instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) zzbH).doubleValue()) != 0) {
                                zzb(sb, i8, zzc(concat3), zzbH);
                            }
                        } else {
                            if (zzbH instanceof String) {
                                equals = zzbH.equals("");
                            } else if (zzbH instanceof zzjd) {
                                equals = zzbH.equals(zzjd.zzb);
                            } else if (zzbH instanceof zzll) {
                                if (zzbH != ((zzll) zzbH).zzbO()) {
                                    zzb(sb, i8, zzc(concat3), zzbH);
                                }
                            } else {
                                if ((zzbH instanceof Enum) && ((Enum) zzbH).ordinal() == 0) {
                                }
                                zzb(sb, i8, zzc(concat3), zzbH);
                            }
                            if (!equals) {
                                zzb(sb, i8, zzc(concat3), zzbH);
                            }
                        }
                    } else if (((Boolean) zzke.zzbH(method5, zzllVar, new Object[0])).booleanValue()) {
                        zzb(sb, i8, zzc(concat3), zzbH);
                    }
                }
            }
        }
        if (!(zzllVar instanceof zzkb)) {
            zzmo zzmoVar = ((zzke) zzllVar).zzc;
            if (zzmoVar != null) {
                zzmoVar.zzg(sb, i8);
                return;
            }
            return;
        }
        zzkb zzkbVar = (zzkb) zzllVar;
        throw null;
    }
}
