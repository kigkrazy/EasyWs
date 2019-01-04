package com.reizx.jwrapper.util;

import lombok.Data;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class NetworkUtil {
    /**
     * 获取服务器所有网卡的物理地址
     *
     * @return List, List中包含主机的网卡的物理地址
     */
    public static List<NetworkInfo> getAllNetworkInfo() throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        List<NetworkInfo> infos = new ArrayList<>();
        for (NetworkInterface ni : Collections.list(nets)) {
            infos.add(NetworkInterfaceToNetworkInfo(ni));
        }
        return infos;
    }

    public static NetworkInfo NetworkInterfaceToNetworkInfo(NetworkInterface nif) throws SocketException {
        NetworkInfo info = new NetworkInfo();
        Enumeration<InetAddress> addrs = nif.getInetAddresses();

        info.setName(nif.getName());
        List<String> ips = new ArrayList<>();
        for (InetAddress addr : Collections.list(addrs)) {
            if (addr instanceof Inet4Address) { // 只关心 IPv4 地址
                ips.add(addr.getHostAddress());
            }
        }
        info.setIps(ips);
        info.setMac(getMac(nif.getHardwareAddress()));
        return info;
    }


    public static String getMac(byte[] bmac) {
        if (bmac == null)
            return "";

        // 下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bmac.length; i++) {
            if (i != 0) {
                sb.append(":");
            }
            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(bmac[i] & 0xFF);
            // System.out.println("--------------");
            // System.err.println(s);
            sb.append(s.length() == 1 ? 0 + s : s);
        }
        // 把字符串所有小写字母改为大写成为正规的mac地址并返回
        return sb.toString().toUpperCase();
    }

    @Data
    public static class NetworkInfo {
        private String name;
        private List<String> ips;//IP
        private String mac;//mac
//        private String nifStat;//流量
    }
}
