import java.io.BufferedReader;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

public class Test3 {
//    public static void main(String[] args){
//        java.security.cert.Certificate c = trustStore.getCertificate("server");
//        if(c!=null && c instanceof X509Certificate)
//        {
//            ((X509Certificate )c).checkValidity();
//        }
//    }
//    public static X509Certificate getX509CerCate(String cerPath) throws Exception {
//        X509Certificate x509Certificate = null;
//        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//        FileInputStream fileInputStream = new FileInputStream(cerPath);
//        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
//        fileInputStream.close();
//        System.out.println("读取Cer证书信息...");
//        System.out.println("x509Certificate_SerialNumber_序列号___:"+x509Certificate.getSerialNumber());
//        System.out.println("x509Certificate_getIssuerDN_发布方标识名___:"+x509Certificate.getIssuerDN());
//        System.out.println("x509Certificate_getSubjectDN_主体标识___:"+x509Certificate.getSubjectDN());
//        System.out.println("x509Certificate_getSigAlgOID_证书算法OID字符串___:"+x509Certificate.getSigAlgOID());
//        System.out.println("x509Certificate_getNotBefore_证书有效期___:"+x509Certificate.getNotAfter());
//        System.out.println("x509Certificate_getSigAlgName_签名算法___:"+x509Certificate.getSigAlgName());
//        System.out.println("x509Certificate_getVersion_版本号___:"+x509Certificate.getVersion());
//        System.out.println("x509Certificate_getPublicKey_公钥___:"+x509Certificate.getPublicKey());
//        return x509Certificate;
//    }
    public static void main(String[] args)  {
//      getX509CerCate("F:\\test\\test.cer");
        X509Certificate x509Certificate = null;
        String s = "";
        StringBuffer s2 = new StringBuffer();
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        BufferedReader bufferedReader = null;
        try {
            process = runtime.exec("openssl s_client -connect h5.uxiaor.com:443");

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(process.getInputStream());


//            System.out.println("读取Cer证书信息...");
//            System.out.println("x509Certificate_SerialNumber_序列号___:"+x509Certificate.getSerialNumber());
//            System.out.println("x509Certificate_getIssuerDN_发布方标识名___:"+x509Certificate.getIssuerDN());
//            System.out.println("x509Certificate_getSubjectDN_主体标识___:"+x509Certificate.getSubjectDN());
//            System.out.println("x509Certificate_getSigAlgOID_证书算法OID字符串___:"+x509Certificate.getSigAlgOID());
//            System.out.println("x509Certificate_getNotBefore_证书有效期___:"+x509Certificate.getNotAfter());
//            System.out.println("x509Certificate_getSigAlgName_签名算法___:"+x509Certificate.getSigAlgName());
//            System.out.println("x509Certificate_getVersion_版本号___:"+x509Certificate.getVersion());
//            System.out.println("x509Certificate_getPublicKey_公钥___:"+x509Certificate.getPublicKey());

            System.out.print((x509Certificate.getNotAfter().getTime()-new Date().getTime())/(24*60*60*1000)+"天");



//            while ((s = bufferedReader.readLine())!=null){
//                s2.append(s);
//                System.out.println();
//            }
//
//            System.out.println(s2);
//            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }

    }
}
