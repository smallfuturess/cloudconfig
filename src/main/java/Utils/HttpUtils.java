package Utils;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import conf.ConfigurationGetter;

/**
 * Utils.HttpUtils :
 *
 * @author zhang.lei
 * @version 1.00
 * @since 2017/12/21 14:26
 */
public class HttpUtils {
    private static Log logger = LogFactory.getLog(JsonUtils.class);

    private static final String ENCODE = "UTF-8";

    public HttpUtils() {
    }

    /**
     *  http正常请求  GET
     * @param url
     * @param charset
     * @param pretty
     * @return
     */
    public static String sendGet(String url, String charset, boolean pretty){
        StringBuffer response = new StringBuffer();
        GetMethod method = null;

        try {
            HttpClient e = new HttpClient();
            e.getHttpConnectionManager().getParams().setConnectionTimeout(Integer.parseInt(ConfigurationGetter.getConfiguration("connection.timeout")));
            method = new GetMethod(url);
            method.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
            method.addRequestHeader("model.User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36");
            logger.info("接口请求地址：" + url);
            method.setRequestHeader("Authorization", "Basic");
            int status = e.executeMethod(method);
            if(status != 200) {
                logger.info("接口请求失败，http请求错误码为：" + status);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));

            String line;
            while((line = reader.readLine()) != null) {
                if(pretty) {
                    response.append(line).append(System.getProperty("line.separator"));
                } else {
                    response.append(line);
                }
            }

            reader.close();
            String result = response.toString();
            logger.info("接口返回的数据为：" + result);
            String var10 = result;
            return var10;
        } catch (ConnectTimeoutException var15) {
            logger.info("执行HTTP Get请求时，发生超时异常！" + var15);
        } catch (IOException var16) {
            logger.info("执行HTTP Get请求时，发生异常！" + var16);
        } finally {
            method.releaseConnection();
        }

        return null;
    }

    /**
     * http正常请求  POST
     * @param url
     * @param body
     * @param charset
     * @return
     */
    public static String sendPost(String url, String body, String charset){
        CloseableHttpResponse response = null;

        try {
            DefaultHttpClient e = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            StringEntity se = new StringEntity(body);
            se.setContentType("text/json");
            se.setContentEncoding("GBK");
            httpPost.setEntity(se);
            response = e.execute(httpPost);
            logger.info("执行POST方法返回结果" + response);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("执行POST方法返回结果码：" + statusCode);
            if(statusCode == 200) {
                String results = EntityUtils.toString(response.getEntity());
                logger.info("接口返回的数据为：" + results);
                return results;
            } else {
                throw new Exception("调用异常!");
            }
        } catch (Exception var9) {
            var9.printStackTrace();
            logger.info("执行HTTP Post请求时，发生异常！" + var9);
            return null;
        }
    }


    /**
     * 描述：webserviceJson请求  json/ini格式参数请求
     * @param
     * @param  params
     * @return
     * @throws Exception
     */
    public static Response webservicePost(String methodName, Vector<Parameter> params,String source) throws Exception{
        URL url = null;
        try {
            url = new URL(source);
        } catch (MalformedURLException mue) {
            throw mue;
        }
        Call soapCall = new Call();
        soapCall.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
        soapCall.setTargetObjectURI("urn:HDCRMWebServiceIntf-IHDCRMWebService");
        soapCall.setMethodName(methodName);
        soapCall.setParams(params);
        Response soapResponse = null;
        soapResponse = soapCall.invoke(url, "");
        if (soapResponse.generatedFault()) {
            Fault fault = soapResponse.getFault();
            throw new Exception(fault.getFaultString());
        }
        return soapResponse;
    }

    //GET调用请求
    public static String sendGet(String url) {
        return sendGet(url, "UTF-8", false);
    }

    //POST调用请求
    public static String sendPost(String url, String body){
        return sendPost(url, body, "UTF-8");
    }
    //webservice请求
    public static Response sendWebservicePost(String methodName,Vector<Parameter> params,String source)
            throws Exception {
        return webservicePost(methodName,params,source);
    }

}
