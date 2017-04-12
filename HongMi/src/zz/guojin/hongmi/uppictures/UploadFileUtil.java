package zz.guojin.hongmi.uppictures;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;


import android.content.Context;

public class UploadFileUtil {

    /**
     * 提交参数里有文件的数据
     *
     * @param url
     *            服务器地址
     * @param param
     *            参数
     * @return 服务器返回结果json串
     * @throws Exception
     */
    public static String uploadSubmit(Context context, String url, Map<String, String> param)
                                                                                             throws Exception {

        HttpPost post = new HttpPost(url);

        /**
         * 注意这里如果只用new MultipartEntity()无参的构造方法，则传过去的中文是乱码
         */
        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null,
            Charset.forName("UTF-8"));

        if (param != null && !param.isEmpty()) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                entity.addPart(entry.getKey(),
                    new StringBody(entry.getValue(), Charset.forName("UTF-8")));
            }
        }
        // 添加文件参数
        //        if (file != null && file.exists()) {
        //            entity.addPart("file", new FileBody(file));
        //        }
        post.setEntity(entity);
        HttpResponse response = HttpClient.getHttpClient(context).execute(post);
        int stateCode = response.getStatusLine().getStatusCode();
        StringBuffer sb = new StringBuffer();
        if (stateCode == HttpStatus.SC_OK) {
            HttpEntity result = response.getEntity();
            if (result != null) {
                InputStream is = result.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String tempLine;
                while ((tempLine = br.readLine()) != null) {
                    sb.append(tempLine);
                }
            }
        }
        post.abort();
        return sb.toString();
    }

    public static String uploadImage(Context context, String url, Map<String, String> param,
                                     File file) throws Exception {

        try {
            HttpPost post = new HttpPost(url);

            /**
             * 注意这里如果只用new MultipartEntity()无参的构造方法，则传过去的中文是乱码
             */
            MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,
                null, Charset.forName("UTF-8"));

            if (param != null && !param.isEmpty()) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    entity.addPart(entry.getKey(),
                        new StringBody(entry.getValue(), Charset.forName("UTF-8")));
                }
            }
            // 添加文件参数
            if (file != null && file.exists()) {
                entity.addPart("file", new FileBody(file));
            }
            post.setEntity(entity);
            HttpResponse response = HttpClient.getHttpClient(context).execute(post);
            int stateCode = response.getStatusLine().getStatusCode();
            StringBuffer sb = new StringBuffer();
            if (stateCode == HttpStatus.SC_OK) {
                HttpEntity result = response.getEntity();
                if (result != null) {
                    InputStream is = result.getContent();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String tempLine;
                    while ((tempLine = br.readLine()) != null) {
                        sb.append(tempLine);
                    }
                }
            }
            post.abort();
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
