package com.appsflyer.internal;

/* loaded from: classes.dex */
public class AFa1vSDK {
    public static byte[] AFLogger$LogLevel = null;
    private static Object AppsFlyer2dXConversionCallback = null;
    public static long init = 0;
    private static Object onAppOpenAttributionNative = null;
    public static final int onAttributionFailureNative = 0;
    public static final byte[] onConversionDataSuccess = null;
    private static int onDeepLinkingNative = 1;
    public static int onInstallConversionDataLoadedNative;
    public static byte[] onInstallConversionFailureNative;
    private static int onResponseNative;

    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0045 -> B:10:0x005d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String $$c(short r8, int r9, int r10) {
        /*
            int r0 = com.appsflyer.internal.AFa1vSDK.onDeepLinkingNative
            r1 = r0 & 39
            r0 = r0 | 39
            int r1 = r1 + r0
            int r0 = r1 % 128
            com.appsflyer.internal.AFa1vSDK.onResponseNative = r0
            int r1 = r1 % 2
            byte[] r1 = com.appsflyer.internal.AFa1vSDK.onConversionDataSuccess
            int r10 = r10 + 41
            int r8 = r8 + 4
            r2 = r9 & 1
            r3 = 1
            r9 = r9 | r3
            int r2 = r2 + r9
            byte[] r9 = new byte[r2]
            r4 = 0
            int r2 = r2 - r4
            int r2 = r2 - r3
            if (r1 != 0) goto L21
            r5 = 1
            goto L22
        L21:
            r5 = 0
        L22:
            if (r5 == r3) goto L2a
            r0 = r2
            r5 = 0
            r2 = r10
            r10 = r9
            r9 = r8
            goto L5d
        L2a:
            r10 = r0 | 65
            int r10 = r10 << r3
            r5 = r0 ^ 65
            int r10 = r10 - r5
            int r5 = r10 % 128
            com.appsflyer.internal.AFa1vSDK.onDeepLinkingNative = r5
            int r10 = r10 % 2
            r10 = r0 & 105(0x69, float:1.47E-43)
            r0 = r0 | 105(0x69, float:1.47E-43)
            int r10 = r10 + r0
            int r0 = r10 % 128
            com.appsflyer.internal.AFa1vSDK.onDeepLinkingNative = r0
            int r10 = r10 % 2
            r10 = r9
            r0 = r2
            r5 = 0
            r9 = r8
        L45:
            int r8 = -r8
            int r8 = -r8
            r6 = r2 ^ r8
            r8 = r8 & r2
            int r8 = r8 << r3
            int r6 = r6 + r8
            int r6 = r6 + (-2)
            int r8 = r6 + (-1)
            int r9 = r9 + r3
            int r2 = com.appsflyer.internal.AFa1vSDK.onDeepLinkingNative
            int r2 = r2 + 120
            int r2 = r2 - r3
            int r6 = r2 % 128
            com.appsflyer.internal.AFa1vSDK.onResponseNative = r6
            int r2 = r2 % 2
            r2 = r8
        L5d:
            byte r8 = (byte) r2
            r10[r5] = r8
            r8 = r5 | 45
            int r8 = r8 << r3
            r6 = r5 ^ 45
            int r8 = r8 - r6
            r6 = r8 ^ (-44)
            r8 = r8 & (-44)
            int r8 = r8 << r3
            int r8 = r8 + r6
            if (r5 != r0) goto L74
            java.lang.String r8 = new java.lang.String
            r8.<init>(r10, r4)
            return r8
        L74:
            r5 = r1[r9]
            r7 = r5
            r5 = r8
            r8 = r7
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1vSDK.$$c(short, int, int):java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(50:2|3|(1:5)(1:692)|6|(2:7|8)|(42:10|(1:12)(1:684)|(41:14|15|16|(38:677|678|(36:673|674|(1:22)(1:672)|23|(2:(1:26)(1:34)|(1:28)(3:29|30|(1:32)(1:33)))|35|(1:37)(1:671)|38|(4:40|41|42|43)|(2:46|47)|48|49|50|51|52|53|54|55|(1:57)(1:669)|58|(4:60|(1:62)(1:667)|63|(15:65|66|67|(1:69)(1:666)|70|(1:72)(1:665)|73|(1:75)(1:664)|76|(1:78)(1:663)|79|80|(4:82|(1:84)(1:659)|85|(2:657|658)(7:87|(1:89)(1:656)|90|(18:96|97|(1:99)(1:652)|100|(6:625|(6:627|628|629|630|631|(1:633))(2:648|649)|634|635|636|637)(1:102)|(14:512|513|514|515|516|517|518|519|520|521|522|(17:(1:525)(1:605)|526|(1:(1:529)(1:(1:602)(1:603)))(1:604)|530|531|532|533|534|535|(12:(1:537)(1:592)|538|(2:(6:541|542|543|(1:545)(1:549)|546|547)(2:553|554)|548)(1:555)|550|551|552|329|249|(4:250|(1:252)(1:280)|253|(2:278|279)(4:255|256|(1:258)(1:277)|(2:261|262)(1:260)))|(1:264)(1:276)|265|(2:267|268)(6:269|270|271|272|273|274))|556|(1:558)(1:591)|559|(3:561|562|563)(1:(3:568|569|570)(1:(3:572|573|574)(9:575|576|577|578|579|580|581|582|566)))|564|565|566)|606|607)(1:104)|105|106|107|108|109|110|111|112|113|114|(13:115|116|117|118|119|(19:121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139)(6:502|503|504|505|506|507)|140|141|(34:143|(1:145)(1:363)|(1:147)(1:362)|148|(1:150)(1:361)|151|152|153|154|155|(2:(1:157)(1:357)|(2:355|356)(9:159|160|161|162|163|164|165|166|(4:168|169|170|171)(1:186)))|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|(3:209|210|211)|212)(33:364|365|366|367|368|369|370|371|372|373|(9:374|375|376|377|378|379|(1:381)(1:470)|382|(1:1)(7:388|389|390|391|392|393|394))|406|407|408|409|410|412|413|414|415|416|417|418|419|420|421|422|(3:(1:424)(1:448)|425|(1:438)(4:427|428|429|430))|439|440|(1:442)(1:447)|(2:444|445)|446)|(7:318|319|320|321|322|(2:324|325)|326)(4:214|215|216|217)|(1:219)(1:308)|220|(21:222|223|(1:225)(1:295)|226|(1:228)(1:294)|229|230|231|232|233|234|235|236|237|238|239|240|241|242|244|245)(6:300|301|(1:303)(1:307)|304|305|306))|95)(1:92)|93|94|95))|660|661))|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(2:46|47)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|18|(0)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(0)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|683|(0)|18|(0)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(0)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|685|686|687|(0)(0)|(0)|683|(0)|18|(0)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(0)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661) */
    /* JADX WARN: Can't wrap try/catch for region: R(53:1|2|3|(1:5)(1:692)|6|7|8|(42:10|(1:12)(1:684)|(41:14|15|16|(38:677|678|(36:673|674|(1:22)(1:672)|23|(2:(1:26)(1:34)|(1:28)(3:29|30|(1:32)(1:33)))|35|(1:37)(1:671)|38|(4:40|41|42|43)|(2:46|47)|48|49|50|51|52|53|54|55|(1:57)(1:669)|58|(4:60|(1:62)(1:667)|63|(15:65|66|67|(1:69)(1:666)|70|(1:72)(1:665)|73|(1:75)(1:664)|76|(1:78)(1:663)|79|80|(4:82|(1:84)(1:659)|85|(2:657|658)(7:87|(1:89)(1:656)|90|(18:96|97|(1:99)(1:652)|100|(6:625|(6:627|628|629|630|631|(1:633))(2:648|649)|634|635|636|637)(1:102)|(14:512|513|514|515|516|517|518|519|520|521|522|(17:(1:525)(1:605)|526|(1:(1:529)(1:(1:602)(1:603)))(1:604)|530|531|532|533|534|535|(12:(1:537)(1:592)|538|(2:(6:541|542|543|(1:545)(1:549)|546|547)(2:553|554)|548)(1:555)|550|551|552|329|249|(4:250|(1:252)(1:280)|253|(2:278|279)(4:255|256|(1:258)(1:277)|(2:261|262)(1:260)))|(1:264)(1:276)|265|(2:267|268)(6:269|270|271|272|273|274))|556|(1:558)(1:591)|559|(3:561|562|563)(1:(3:568|569|570)(1:(3:572|573|574)(9:575|576|577|578|579|580|581|582|566)))|564|565|566)|606|607)(1:104)|105|106|107|108|109|110|111|112|113|114|(13:115|116|117|118|119|(19:121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139)(6:502|503|504|505|506|507)|140|141|(34:143|(1:145)(1:363)|(1:147)(1:362)|148|(1:150)(1:361)|151|152|153|154|155|(2:(1:157)(1:357)|(2:355|356)(9:159|160|161|162|163|164|165|166|(4:168|169|170|171)(1:186)))|187|188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|(3:209|210|211)|212)(33:364|365|366|367|368|369|370|371|372|373|(9:374|375|376|377|378|379|(1:381)(1:470)|382|(1:1)(7:388|389|390|391|392|393|394))|406|407|408|409|410|412|413|414|415|416|417|418|419|420|421|422|(3:(1:424)(1:448)|425|(1:438)(4:427|428|429|430))|439|440|(1:442)(1:447)|(2:444|445)|446)|(7:318|319|320|321|322|(2:324|325)|326)(4:214|215|216|217)|(1:219)(1:308)|220|(21:222|223|(1:225)(1:295)|226|(1:228)(1:294)|229|230|231|232|233|234|235|236|237|238|239|240|241|242|244|245)(6:300|301|(1:303)(1:307)|304|305|306))|95)(1:92)|93|94|95))|660|661))|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(2:46|47)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|18|(0)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(0)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|683|(0)|18|(0)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(0)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661)|685|686|687|(0)(0)|(0)|683|(0)|18|(0)|20|(0)(0)|23|(0)|35|(0)(0)|38|(0)|(0)|48|49|50|51|52|53|54|55|(0)(0)|58|(0)|668|66|67|(0)(0)|70|(0)(0)|73|(0)(0)|76|(0)(0)|79|80|(0)|660|661|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e0 A[Catch: Exception -> 0x18f7, TRY_LEAVE, TryCatch #89 {Exception -> 0x18f7, blocks: (B:3:0x0014, B:5:0x0029, B:46:0x0154, B:64:0x01e0, B:82:0x026b, B:94:0x02f3, B:96:0x037b, B:112:0x03cb, B:117:0x03e3, B:121:0x03ec, B:125:0x03f6, B:129:0x0402, B:141:0x0427, B:797:0x1828, B:813:0x18d5, B:800:0x1847, B:786:0x1816, B:810:0x189e, B:83:0x027e, B:49:0x0182, B:50:0x01a8, B:67:0x0230, B:66:0x01f7, B:92:0x02c1, B:802:0x1863, B:803:0x1893), top: B:863:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:780:0x17fe  */
    /* JADX WARN: Removed duplicated region for block: B:781:0x1801  */
    /* JADX WARN: Removed duplicated region for block: B:785:0x1809  */
    /* JADX WARN: Removed duplicated region for block: B:793:0x1822  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x1824  */
    /* JADX WARN: Removed duplicated region for block: B:797:0x1828 A[Catch: Exception -> 0x18f7, TRY_LEAVE, TryCatch #89 {Exception -> 0x18f7, blocks: (B:3:0x0014, B:5:0x0029, B:46:0x0154, B:64:0x01e0, B:82:0x026b, B:94:0x02f3, B:96:0x037b, B:112:0x03cb, B:117:0x03e3, B:121:0x03ec, B:125:0x03f6, B:129:0x0402, B:141:0x0427, B:797:0x1828, B:813:0x18d5, B:800:0x1847, B:786:0x1816, B:810:0x189e, B:83:0x027e, B:49:0x0182, B:50:0x01a8, B:67:0x0230, B:66:0x01f7, B:92:0x02c1, B:802:0x1863, B:803:0x1893), top: B:863:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:827:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:900:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:925:0x1835 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:934:0x1807 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03a8  */
    static {
        /*
            Method dump skipped, instructions count: 6399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1vSDK.<clinit>():void");
    }

    private AFa1vSDK() {
    }

    public static Object AFInAppEventParameterName(int i8, int i9, char c8) {
        int i10 = onResponseNative;
        int i11 = ((i10 | 123) << 1) - (i10 ^ 123);
        onDeepLinkingNative = i11 % 128;
        if (!(i11 % 2 != 0)) {
            throw null;
        }
        Object obj = onAppOpenAttributionNative;
        try {
            Object[] objArr = {Integer.valueOf(i8), Integer.valueOf(i9), Character.valueOf(c8)};
            byte[] bArr = onConversionDataSuccess;
            Class<?> cls = Class.forName($$c(bArr[48], bArr[553], bArr[157]), true, (ClassLoader) AppsFlyer2dXConversionCallback);
            byte b8 = bArr[17];
            String $$c = $$c((short) 425, b8, b8);
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getMethod($$c, cls2, cls2, Character.TYPE).invoke(obj, objArr);
            int i12 = (onResponseNative + 2) - 1;
            onDeepLinkingNative = i12 % 128;
            int i13 = i12 % 2;
            return invoke;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int AFKeystoreWrapper(int i8) {
        Object obj;
        int i9 = onResponseNative;
        int i10 = ((i9 | 85) << 1) - (i9 ^ 85);
        onDeepLinkingNative = i10 % 128;
        if (i10 % 2 == 0) {
            obj = onAppOpenAttributionNative;
            int i11 = 92 / 0;
        } else {
            obj = onAppOpenAttributionNative;
        }
        int i12 = (i9 + 114) - 1;
        int i13 = i12 % 128;
        onDeepLinkingNative = i13;
        int i14 = i12 % 2;
        int i15 = (i13 & 65) + (i13 | 65);
        onResponseNative = i15 % 128;
        int i16 = i15 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i8)};
            byte[] bArr = onConversionDataSuccess;
            Class<?> cls = Class.forName($$c(bArr[48], bArr[553], bArr[157]), true, (ClassLoader) AppsFlyer2dXConversionCallback);
            byte b8 = bArr[17];
            int intValue = ((Integer) cls.getMethod($$c((short) 425, b8, b8), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i17 = (onDeepLinkingNative + 92) - 1;
            onResponseNative = i17 % 128;
            int i18 = i17 % 2;
            return intValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i8 = onResponseNative;
        int i9 = ((i8 | 103) << 1) - (i8 ^ 103);
        onDeepLinkingNative = i9 % 128;
        int i10 = i9 % 2;
        byte[] bArr = new byte[1067];
        System.arraycopy("!\u0019\u009aò\u0015\u0000\u0003ö\f\tã\u0017\röÿ\u0006ó\u0018\u0007ûë\u001f\u0006\u0003\u0000\r\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b\u001eÓJÞô\nÜ\u0003ú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓHàô\nÜLú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓJÞô\nÜ\u0003öÿ\u0006å2ú\u0003\u0010\u0001\u0012Õ&\u0006ü\u0011Ô(\fþú\u000eô\u0001\u0012Ò!\u0005\b\u0000â(\föÿ\u0006\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\tøøî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸î\tí\u000bî\u0007ï\u000bî\u000bë\u000b\b\u0006(Ö2\u0003Ø4ò\f\tß\u0014\u0014ò\u000fû\u0012ô\u0010ß\u0016\u000fûú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ô6ÿô\u0010ÿö\u000eê$þ\u0006ò\t\u0001â(\fö\u0001\u0014þ\u0006\n7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ6Îú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000f\u0006õ\u0006ã$\u0016ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0010ù\u0011\u0000ýþÍD\u0007¾\u001a,\u000bö\f\u0000\u0002\u0002û\f\tî\u000e\fó\u0011\u0010ù\u0011\u0000ýþÍD\u0007¾()ý\u0004ô\u000bÙ,\u0006÷\u000bû\u0001\n\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u00108\u0000\u0016ðÑ8\u0000\u0016ðÑ\u0004\nü\u0012ô\u0001\u0012Õ\u0001\b\b\u001d\u0017ý\u0004þ\u0006öõ\u001eò\u0012\u0003ø\u0010ô\n\u0017í\b\t\u0001\u0012Ò!\u0012\u0006Ý%ø\u0004ö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\f\u0006\u0007õ7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ5Ïú\u0018îÐ>\tÂIü\u0006÷\b\f\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006ú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0001\u0010ì\u001eú\u000eôú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0010ù\u0011\u0000ýþÍIô\u0016ÿ½)\u0014\u0016ÿä\"ø\u0006\nô\u0016÷ç \r\u0004\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐ>\tÂ\u001b&\u0006üî\u0006ð\u000b\u0001\u0012ã!ú\u0007\u0003û\u0002ë\u001c\fü\u0010÷\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006þÖ:þôß4\u0003ò\u001b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010þò\u0012ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000f".getBytes("ISO-8859-1"), 0, bArr, 0, 1067);
        onConversionDataSuccess = bArr;
        onAttributionFailureNative = 28;
        int i11 = onResponseNative + 89;
        onDeepLinkingNative = i11 % 128;
        int i12 = i11 % 2;
    }

    public static int valueOf(Object obj) {
        int i8 = onDeepLinkingNative;
        int i9 = ((i8 | 43) << 1) - (i8 ^ 43);
        int i10 = i9 % 128;
        onResponseNative = i10;
        if ((i9 % 2 != 0 ? '?' : 'W') == '?') {
            throw null;
        }
        Object obj2 = onAppOpenAttributionNative;
        int i11 = (i10 + 42) - 1;
        onDeepLinkingNative = i11 % 128;
        int i12 = i11 % 2;
        try {
            Object[] objArr = {obj};
            byte[] bArr = onConversionDataSuccess;
            return ((Integer) Class.forName($$c(bArr[48], bArr[553], bArr[157]), true, (ClassLoader) AppsFlyer2dXConversionCallback).getMethod($$c((short) 679, bArr[35], bArr[17]), Object.class).invoke(obj2, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
