package Utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;


public class CertificateRemind {

    public static X509Certificate x509Certificate = null;
    public static Process process = null;
//    public static String locationPrefix = "/Users/guyongliang/Desktop/ca证书/admin.iyoukeji.com.pem \n"

    public static void MessageRemind(String url,int port){
        if (port==0)port = 443;
        Runtime runtime = Runtime.getRuntime();
        try {
            String connect = "openssl s_client -connect " + url + ":" + port;
            process = runtime.exec(connect);
//            HttpsURLConnection conn = (HttpsURLConnection) new URL("https://" + url).openConnection();
//        conn.setHostnameVerifier((s, sslSession) -> true);
//            System.out.println(conn.getResponseCode());
//            X509Certificate[] x509Certificates = (X509Certificate[]) conn.getServerCertificates();
//            fileOutputStream = new FileOutputStream(new File("/Users/guyongliang/Documents/newFile.crt"));
//            int a = 0;
//            byte[] buffer1 = new byte[2048];
//            InputStream inputStream = process.getInputStream();
//            while ((a =inputStream.read())!=-1){
//                int b = inputStream.read(buffer1);
//                fileOutputStream.write(b);
//            }
//            process.waitFor(10, TimeUnit.SECONDS);





              CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            Arrays.stream(x509Certificates).filter(certificate->certificate instanceof )


            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(process.getInputStream());
//            System.out.println(x509Certificate instanceof X509Certificate);
//            System.out.println(x509Certificate.getSubjectAlternativeNames());
//            x509Certificate.getSubjectAlternativeNames().stream().flatMap(objects -> objects.stream()).filter(o -> url.equals(o)).forEach(o -> System.out.println(o));
//            x509Certificate.getSubjectAlternativeNames().stream().map(i->{System.out.println("hello"); return null;});
//            System.out.println(x509Certificate.getNotAfter());
            System.out.print((x509Certificate.getNotAfter().getTime()-new Date().getTime())/(24*60*60*1000)+"天");

//            long date = x509Certificate.getNotAfter().getTime();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//            System.out.println(simpleDateFormat.format(date));
//            System.out.println(x509Certificate.getSerialNumber().toString(16));
//            System.out.println(x509Certificate.getNotBefore());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)  {

        CertificateRemind.MessageRemind("sso.uxiaor.com",443);

    }
}
