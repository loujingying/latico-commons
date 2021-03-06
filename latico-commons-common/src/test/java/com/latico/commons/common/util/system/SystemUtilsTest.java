package com.latico.commons.common.util.system;

import com.latico.commons.common.util.net.Ipv4Utils;
import org.junit.Test;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author: latico
 * @date: 2018/12/08 14:56
 * @version: 1.0
 */
public class SystemUtilsTest {

    @Test
    public void isX64() {
        assert (SystemUtils.isX64());
    }

    @Test
    public void isX32() {
        assert (SystemUtils.isX32());
    }

    @Test
    public void getSysEncoding() {
    }

    @Test
    public void getJdkVersion() {
    }

    @Test
    public void IS_JAVA_1_6() {
        System.out.printf("", SystemUtils.IS_OS_WINDOWS);
    }


    @Test
    public void isRunByTomcat() {
    }

    @Test
    public void copyToClipboard() {
    }

    @Test
    public void pasteFromClipboard() {
    }

    @Test
    public void getSysFonts() {
    }

    @Test
    public void getStartlock() {
    }

    @Test
    public void getStartlock1() {
    }

    @Test
    public void getJavaStartCommand() {
        System.out.println(SystemUtils.getJavaStartCommand());
    }

    @Test
    public void getJvmFreeMemory() {
        System.out.println(SystemUtils.getJvmFreeMemory());
    }

    @Test
    public void getJvmTotalMemory() {
        System.out.println(SystemUtils.getJvmTotalMemory());
    }

    @Test
    public void getJvmMaxMemory() {
        System.out.println(SystemUtils.getJvmMaxMemory());
    }

    @Test
    public void getOsPhysicalFreeMemory() {
        System.out.println(SystemUtils.getOsFreePhysicalMemorySize() / 1024D / 1024 / 1024);
    }

    @Test
    public void getOsTotalPhysicalMemorySize() {
        System.out.println(SystemUtils.getOsTotalPhysicalMemorySize() / 1024D / 1024 / 1024);
    }

    @Test
    public void getOsDiskAllTotalSpaceSize() {
        System.out.println(SystemUtils.getOsDiskTotalSpaceSize() / 1024D / 1024 / 1024);
    }

    @Test
    public void getOsDiskFreeSpaceSize() {
        System.out.println(SystemUtils.getOsDiskFreeSpaceSize() / 1024D / 1024 / 1024);
    }

    @Test
    public void getOsDiskUsableSpaceSize() {
        System.out.println(SystemUtils.getOsDiskUsableSpaceSize() / 1024D / 1024 / 1024);
    }

    @Test
    public void getOsDiskUsedSpaceSize() {
        System.out.println(SystemUtils.getOsDiskUsedSpaceSize() / 1024D / 1024 / 1024);
    }

    @Test
    public void getLocalMac() throws Exception {
        System.out.println(SystemUtils.getLocalMac());
    }

    @Test
    public void getAllLocalIP() throws Exception {
        System.out.println(SystemUtils.getAllLocalInetAddressIP());
    }

    /**
     * 获取CPU使用率
     *
     * @return
     */
    public static String getCpuRatio() {
        try {
            String procCmd = System.getenv("windir") + "//system32//wbem//wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
            long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));    // 取进程信息
            Thread.sleep(200);
            long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));
            if (c0 != null && c1 != null) {
                long idletime = c1[0] - c0[0];
                long busytime = c1[1] - c0[1];
                return "CPU使用率:" + Double.valueOf(100 * (busytime) * 1.0 / (busytime + idletime)).intValue() + "%";
            } else {
                return "CPU使用率:" + 0 + "%";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "CPU使用率:" + 0 + "%";
        }
    }

    private static long[] readCpu(final Process proc) {
        long[] retn = new long[2];
        try {
            proc.getOutputStream().close();
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line = input.readLine();
            if (line == null || line.length() < 10) {
                return null;
            }
            int capidx = line.indexOf("Caption");
            int cmdidx = line.indexOf("CommandLine");
            int rocidx = line.indexOf("ReadOperationCount");
            int umtidx = line.indexOf("UserModeTime");
            int kmtidx = line.indexOf("KernelModeTime");
            int wocidx = line.indexOf("WriteOperationCount");
            long idletime = 0;
            long kneltime = 0;
            long usertime = 0;
            while ((line = input.readLine()) != null) {
                if (line.length() < wocidx) {
                    continue;
                }
                String caption = substring(line, capidx, cmdidx - 1).trim();
                String cmd = substring(line, cmdidx, kmtidx - 1).trim();
                if (cmd.indexOf("wmic.exe") >= 0) {
                    continue;
                }
                String s1 = substring(line, kmtidx, rocidx - 1).trim();
                String s2 = substring(line, umtidx, wocidx - 1).trim();
                if (caption.equals("System Idle Process") || caption.equals("System")) {
                    if (s1.length() > 0)
                        idletime += Long.valueOf(s1).longValue();
                    if (s2.length() > 0)
                        idletime += Long.valueOf(s2).longValue();
                    continue;
                }
                if (s1.length() > 0)
                    kneltime += Long.valueOf(s1).longValue();
                if (s2.length() > 0)
                    usertime += Long.valueOf(s2).longValue();
            }
            retn[0] = idletime;
            retn[1] = kneltime + usertime;
            return retn;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                proc.getInputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String substring(String src, int start_idx, int end_idx) {
        byte[] b = src.getBytes();
        String tgt = "";
        for (int i = start_idx; i <= end_idx; i++) {
            tgt += (char) b[i];
        }
        return tgt;
    }

    @Test
    public void getAllLocalRealInetAddress() {
        try {
            System.out.println(SystemUtils.getAllLocalRealInetAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     */
    @Test
    public void getAllPhysicsInetAddress(){
        try {
            System.out.println(SystemUtils.getAllPhysicsInetAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getLocalHostName() {
        System.out.println(SystemUtils.getLocalHostName());
    }

    @Test
    public void getLocalHostName1() {
        System.out.println(Ipv4Utils.isValidIpV4Addr("0.0.0.0"));
    }

    @Test
    public void getLocalHost() {
        System.out.println(SystemUtils.getLocalHost());
    }

    @Test
    public void getBootstrapClassPath() {
        System.out.println(SystemUtils.getBootstrapClassPath());
    }

    @Test
    public void getAvailableProcessors() {
        System.out.println(SystemUtils.getAvailableProcessors());
    }


}