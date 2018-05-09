package Utils;

import java.io.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CertificateRemindNew {

    public static X509Certificate x509Certificate = null;
    public static String locationPrefix = "/Users/guyongliang/Desktop/ca证书/";
    public static CertificateFactory certificateFactory = null;
    public static BufferedWriter bufferedWriter = null;

    public static void MessageRemind(Map<String,X509Certificate> x509CertificateMap) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(locationPrefix + "证书到期时间汇总.txt"));
            bufferedWriter.write("截止日期" + "              " + "剩余天数" + "          " + "URL" + "\n");
            for (Map.Entry<String, X509Certificate> x509Certificate : x509CertificateMap.entrySet()) {
                try {
                    long days = (x509Certificate.getValue().getNotAfter().getTime() - new Date().getTime()) / (24 * 60 * 60 * 1000);
                    String endDate = simpleDateFormat.format(x509Certificate.getValue().getNotAfter().getTime());
                    if (days < 6){
                        bufferedWriter.write(endDate + "           " +  days + "天" + "           " + x509Certificate.getKey() + "           " + "要到期啦！🌶" + "\n");
                        bufferedWriter.flush();
                    }
                    else {
                        bufferedWriter.write(endDate + "           " +  days + "天" + "           " + x509Certificate.getKey() + "\n");
                        bufferedWriter.flush();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,X509Certificate> getX509CertificateMap() {
        Map<String, X509Certificate> x509CertificateMap = new HashMap<>();
        File file = new File(locationPrefix);
        List<String> fileNameList = Arrays.asList(file.list());
        fileNameList = fileNameList.stream().filter(f -> f.endsWith(".pem")).collect(Collectors.toList());
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            for (String fileName : fileNameList) {
                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new FileInputStream(locationPrefix + fileName));
                x509CertificateMap.put(fileName, x509Certificate);
            }
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String,X509Certificate>> list = new ArrayList<Map.Entry<String,X509Certificate>>(x509CertificateMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, X509Certificate>>() {
            @Override
            public int compare(Map.Entry<String, X509Certificate> o1, Map.Entry<String, X509Certificate> o2) {
                if ((o1.getValue().getNotAfter().getTime()>o2.getValue().getNotAfter().getTime())) return 1;
                else return -1;
            }
        });
        Map<String,X509Certificate> map = new LinkedHashMap<>();
        for (Map.Entry<String,X509Certificate> list1:list) {
            map.put(list1.getKey(),list1.getValue());
        }
        return map;
    }


    public static void main(String[] args) {

        Map<String,X509Certificate> x509CertificateMap = getX509CertificateMap();
        CertificateRemindNew.MessageRemind(x509CertificateMap);
    }
}
