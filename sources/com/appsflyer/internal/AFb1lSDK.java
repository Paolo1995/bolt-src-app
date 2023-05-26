package com.appsflyer.internal;

/* loaded from: classes.dex */
public class AFb1lSDK {
    public static final byte[] getOutOfStore = null;
    public static byte[] setAndroidIdData = null;
    private static int setAppInviteOneLink = 1;
    public static byte[] setCustomerIdAndLogSession;
    public static int setCustomerUserId;
    private static Object setDebugLog;
    public static long setImeiData;
    public static byte[] setOaidData;
    public static int setPhoneNumber;
    private static int setUserEmails;
    private static Object updateServerUninstallToken;
    public static final int waitForCustomerUserId = 0;

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0054 -> B:14:0x0064). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String $$c(int r9, int r10, int r11) {
        /*
            int r0 = com.appsflyer.internal.AFb1lSDK.setUserEmails
            r1 = r0 | 23
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ 23
            int r1 = r1 - r0
            int r0 = r1 % 128
            com.appsflyer.internal.AFb1lSDK.setAppInviteOneLink = r0
            int r1 = r1 % 2
            int r10 = -r10
            r1 = r10 ^ 36
            r10 = r10 & 36
            int r10 = r10 << r2
            int r1 = r1 + r10
            r10 = r9 | (-16)
            int r10 = r10 << r2
            r9 = r9 ^ (-16)
            int r10 = r10 - r9
            r9 = r10 & 20
            r10 = r10 | 20
            int r9 = r9 + r10
            byte[] r10 = com.appsflyer.internal.AFb1lSDK.getOutOfStore
            int r11 = -r11
            r3 = r11 | 119(0x77, float:1.67E-43)
            int r3 = r3 << r2
            r11 = r11 ^ 119(0x77, float:1.67E-43)
            int r3 = r3 - r11
            byte[] r11 = new byte[r1]
            int r1 = r1 + (-1)
            r4 = 0
            if (r10 != 0) goto L33
            r5 = 0
            goto L34
        L33:
            r5 = 1
        L34:
            if (r5 == r2) goto L43
            int r0 = r0 + 64
            int r0 = r0 - r2
            int r3 = r0 % 128
            com.appsflyer.internal.AFb1lSDK.setUserEmails = r3
            int r0 = r0 % 2
            r5 = 0
            r0 = r9
            r3 = r1
            goto L64
        L43:
            r0 = 0
        L44:
            byte r5 = (byte) r3
            r11[r0] = r5
            r5 = r0 & 1
            r6 = r0 | 1
            int r5 = r5 + r6
            if (r0 != r1) goto L54
            java.lang.String r9 = new java.lang.String
            r9.<init>(r11, r4)
            return r9
        L54:
            r0 = r10[r9]
            int r6 = com.appsflyer.internal.AFb1lSDK.setUserEmails
            int r6 = r6 + 98
            int r6 = r6 - r2
            int r7 = r6 % 128
            com.appsflyer.internal.AFb1lSDK.setAppInviteOneLink = r7
            int r6 = r6 % 2
            r8 = r3
            r3 = r1
            r1 = r8
        L64:
            r6 = r9 & 1
            r9 = r9 | r2
            int r9 = r9 + r6
            int r0 = -r0
            int r0 = -r0
            int r0 = -r0
            r6 = r1 | r0
            int r6 = r6 << r2
            r0 = r0 ^ r1
            int r6 = r6 - r0
            r0 = r6 ^ (-3)
            r1 = r6 & (-3)
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = com.appsflyer.internal.AFb1lSDK.setAppInviteOneLink
            int r1 = r1 + 121
            int r6 = r1 % 128
            com.appsflyer.internal.AFb1lSDK.setUserEmails = r6
            int r1 = r1 % 2
            r1 = r3
            r3 = r0
            r0 = r5
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1lSDK.$$c(int, int, int):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:638:0x1486
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    static {
        /*
            Method dump skipped, instructions count: 6483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1lSDK.<clinit>():void");
    }

    private AFb1lSDK() {
    }

    public static Object AFInAppEventParameterName(int i8, int i9, char c8) {
        int i10 = (setAppInviteOneLink + 32) - 1;
        setUserEmails = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
        Object obj = setDebugLog;
        try {
            Object[] objArr = {Integer.valueOf(i8), Integer.valueOf(i9), Character.valueOf(c8)};
            byte[] bArr = getOutOfStore;
            Class<?> cls = Class.forName($$c((short) 273, bArr[66], bArr[388]), true, (ClassLoader) updateServerUninstallToken);
            String $$c = $$c((short) 448, bArr[109], bArr[63]);
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getMethod($$c, cls2, cls2, Character.TYPE).invoke(obj, objArr);
            int i11 = setAppInviteOneLink;
            int i12 = (i11 ^ 91) + ((i11 & 91) << 1);
            setUserEmails = i12 % 128;
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

    public static int AFInAppEventType(int i8) {
        int i9 = setAppInviteOneLink;
        int i10 = (i9 & 15) + (i9 | 15);
        int i11 = i10 % 128;
        setUserEmails = i11;
        if ((i10 % 2 != 0 ? '\t' : '%') == '\t') {
            throw null;
        }
        Object obj = setDebugLog;
        int i12 = (i11 ^ 65) + ((i11 & 65) << 1);
        setAppInviteOneLink = i12 % 128;
        int i13 = i12 % 2;
        int i14 = ((i11 | 25) << 1) - (i11 ^ 25);
        setAppInviteOneLink = i14 % 128;
        int i15 = i14 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i8)};
            byte[] bArr = getOutOfStore;
            Class<?> cls = Class.forName($$c((short) 273, bArr[66], bArr[388]), true, (ClassLoader) updateServerUninstallToken);
            int i16 = waitForCustomerUserId;
            int intValue = ((Integer) cls.getMethod($$c((short) ((i16 & 780) | (i16 ^ 780)), bArr[568], bArr[23]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i17 = setAppInviteOneLink;
            int i18 = ((i17 | 5) << 1) - (i17 ^ 5);
            setUserEmails = i18 % 128;
            if ((i18 % 2 != 0 ? (char) 22 : 'Z') == 'Z') {
                return intValue;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int AFInAppEventType(Object obj) {
        int i8 = setAppInviteOneLink;
        int i9 = (i8 + 12) - 1;
        setUserEmails = i9 % 128;
        int i10 = i9 % 2;
        Object obj2 = setDebugLog;
        int i11 = i8 + 29;
        setUserEmails = i11 % 128;
        int i12 = i11 % 2;
        try {
            byte[] bArr = getOutOfStore;
            int intValue = ((Integer) Class.forName($$c((short) 273, bArr[66], bArr[388]), true, (ClassLoader) updateServerUninstallToken).getMethod($$c((short) 677, bArr[410], bArr[63]), Object.class).invoke(obj2, obj)).intValue();
            int i13 = setUserEmails;
            int i14 = (i13 & 47) + (i13 | 47);
            setAppInviteOneLink = i14 % 128;
            int i15 = i14 % 2;
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
        int i8 = setAppInviteOneLink;
        int i9 = ((i8 | 79) << 1) - (i8 ^ 79);
        setUserEmails = i9 % 128;
        int i10 = i9 % 2;
        byte[] bArr = new byte[1046];
        System.arraycopy("\u001a@\tJÉñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:È4\u0006è\u00120Â÷>éÊ\fýþð\nþ\u0018Øûøþ\u001eÜÿ\n\u0001ñ\u0006è\u00120¿\bð\u00046Ø×\u0003ü\fõë\u0000ý\nô÷0Îý\u0001\u0000\u0003ÿê\b÷þ\u0006è\u00120½\u0002÷>éÆ\u0002\f Ê\fýþðö\bîú\u000bþ\u000fê\u0001òõ\bù\u0005ð\u0007ï\u0000\u0003\u00023¼ùBéÊ\tú\u0005=Ë\u000eðü\u0007÷þ\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå-Øûøþ\u001eÜÿ\n\u0001ñ\u0000òó\nû:¸÷\u0003ü\fõ<âØ\u001eåõûúö2Üê2Ô\bëý$Ú\u000búüðñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:ëøá.Æ\u0012\fö$ý\n\u0001ú\u001bÎ\u0006ýðÿî+Úú\u0004ï,Øôø\u0007üê&æ\u0002\u0006ò\fÿî.ßûø\u0000\u001eØô\n\u0001úñÿ<Êîýú\n÷ð\u0011ðAÂø÷\fð\u0001\nò;êøá.Æ\u0012\fö$ý\u0000òó\nû:¸÷\u0003ü\fõ<çÜê/Úú\u0004ñ\bü\u0003ùÿûø\u0000\u0000òó\nû:¸÷\u0003ü\fõ<éÞë\u000b\u001eÜê2Ô\bëý$Ú\u000búüðÿî.Ñ\bü\u001fßûø\u0000\u001eØô÷\b\b\u0012ö\u0014õ·üL·\u0002òý\u0007þûõõP±\u0004üïH\u0012÷\u0013õ\u0012ù\u0011õ\u0012õ\u0015õñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:ëøá.Â\u0016\fö$¹øúØ*Îý(Ì\u000eô÷!ìì\u000eñ\u0005î\fð!êñ\u0005\u0006è\u00120¿\bð\u00046èÔ\bëý$Ú\u000búüðð\u0007ï\u0000\u0003\u00023Êîý?êÎý&Øú\nþòöÿî,Ê\u0001\fð\u0001\nò\u0016Ü\u0002ú\u000e÷ÿ\u001eØô\nÿì\u0002úö\u0006è\u00120Â÷>çàê\u0010\u0015Øûøþ\u001eÜÿ\n\u0001ñú\u000bú\u001dÜê\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå'×þ\u0001øþ\u001eÜÿ\n\u0001ñð\u0007ï\u0000\u0003\u00023¼ùBæÔõ\nô\u0000þþ\u0005ô÷\u0012òô\rïð\u0007ï\u0000\u0003\u00023¼ùBØ×\u0003ü\fõ'Ôú\tõ\u0005ÿöÿî.Ô\bëý$Ú\u000búüðÈ\u0000ê\u0010/È\u0000ê\u0010/üö\u0004î\fÿî+ÿøøãé\u0003ü\u0002ú\n\u000bâ\u000eîý\bð\föé\u0013ø÷\nê\bð\u000e\u0016à\u0004í\u000eìö&ìê\t Ö\u0004õ\u0005ô÷þôúù\u000bÉñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:É3\u0006è\u00120Â÷>·\u0004ú\tøôÿî!Û\u0000ü\bðûøÿî0Üì\u0001\u0000ôþ\f\u0012ìê\tð\u0007ï\u0000\u0003\u00023Êîý?êÛì\bð\nòø\"éó\n\u0001ú\u0012òô\r\u0013æ\u0006è\u00120Â÷>åÚú\u0004\u0013×þ\u0001øþ\u001eÜÿ\n\u0001ñÿð\u0014â\u0006ò\f\u0006è\u00120Â÷>â÷\u0007Ê\u0012ûòù\b÷þð\u0007ï\u0000\u0003\u00023·\fê\u0001C×ìê\u0001\u001cÞ\búö\fê\t\u0019àóüÿî(Ø\u0002ò\b\u0005ò(Îý\u0001\u0000\u0003ÿê\b÷þ\u0006è\u00120Â÷>åÚú\u0004\u0012ú\u0010õë\u0000ý\nô÷\u001dèù\u0005\u0015áúý\u0000ó\u0006è\u00120Â÷>åÚú\u0004\u001eÜï\rî\u0006öù\u0002ú\u0002*Æ\u0002\f!Ìý\u000eåú\u000bú\u001eÔ\bëýñÿ<Êîýú\n÷ð\u0011ð\u0002\u000eî\nê\bð\u000e\u0016à\u0004í\u000eìö2Øô\nÿì\u0002ú\u0006\u0001ï\u0006è\u00120Â÷>âØûøþ\u001eÜÿ\n\u0001ñ".getBytes("ISO-8859-1"), 0, bArr, 0, 1046);
        getOutOfStore = bArr;
        waitForCustomerUserId = 34;
        int i11 = setAppInviteOneLink;
        int i12 = ((i11 | 63) << 1) - (i11 ^ 63);
        setUserEmails = i12 % 128;
        if (i12 % 2 == 0) {
            return;
        }
        throw null;
    }
}
