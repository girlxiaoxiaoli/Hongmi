package zz.guojin.hongmi.uppictures;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import android.content.Context;

public class HttpClient {

    private static DefaultHttpClient mHttpClient;

    /**
     * 创建httpClient实例
     */
    public static synchronized DefaultHttpClient getHttpClient(Context context)
                                                                               throws KeyStoreException,
                                                                               NoSuchAlgorithmException,
                                                                               CertificateException,
                                                                               IOException,
                                                                               KeyManagementException,
                                                                               UnrecoverableKeyException {
        if (null == mHttpClient) {
            HttpParams params = new BasicHttpParams();
            // 设置一些基本参数
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

            HttpConnectionParams.setConnectionTimeout(params, 30 * 1000);
            /* 请求超时 */
            HttpConnectionParams.setSoTimeout(params, 30 * 1000);
            // 设置我们的HttpClient支持HTTP和HTTPS两种模式
            SchemeRegistry schReg = new SchemeRegistry();
            schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));

            // 使用线程安全的连接管理来创建HttpClient
            ClientConnectionManager conMgr = new ThreadSafeClientConnManager(params, schReg);
            mHttpClient = new DefaultHttpClient(conMgr, params);
        }
        return mHttpClient;
    }

}
