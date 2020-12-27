package com.cenozoic.number.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

@Slf4j
public class ParamUtil {
	private static int num = 0;
	
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0) || "null".equals(str) || "undefined".equals(str));
	}

	public static boolean isNotEmpty(String str) {
		return (!(isEmpty(str)));
	}

	public static String toString(Object obj) {
		return (obj == null) ? "" : obj.toString();
	}

	public static boolean isEmpty(Object str) {
		return ((str == null) || ((str + "").length() == 0)|| StringUtils.isBlank(str+ "") || "null".equals(str + "") || "{}".equals(str + "") || "[]".equals(str + ""));
	}

	public static String toStringTwo(Object obj) {
		return (obj == null) ? "0" : obj.toString();
	}

	public static Integer toInteger(Object obj) {
		return (obj == null || "".equals(obj) || "null".equals(obj)) ? 0 : Integer.valueOf(obj.toString());
	}

	public static Long toLong(Object obj) {
		return (obj == null || "".equals(obj) || "null".equals(obj)) ? 0L : Long.valueOf(obj.toString());
	}

	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;

		Object obj = beanClass.newInstance();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}

			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}

		return obj;
	}

	public static Map<String, String> mapToMap(Map<String, Object> map) {
		if (null != map && map.size() > 0) {
			Map<String, String> rMap = new HashMap<String, String>();
			Set<String> keySet = map.keySet();
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String key = it.next();
				rMap.put(key, toString(map.get(key)));
			}
			return rMap;
		} else {
			return null;
		}
	}

	public static String getParam(Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		Field[] fs = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true);
			Object val = f.get(obj);
			if (val != null && !"".equals(val)) {
				if (sb.length() == 0) {
					sb.append(f.getName() + "=" + val);
				} else {
					sb.append("&" + f.getName() + "=" + val);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 参数转map
	 */
	public static Map<String, String> getRequest2Map(HttpServletRequest request) throws Exception {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		for (Map.Entry m : res.entrySet()) {
			log.info(m.getKey() + " = " + m.getValue());
		}
		return res;
	}

	/**
	 * 参数转map
	 */
	public static Map<String, Object> getRequestMap(HttpServletRequest request) throws Exception {
		Map<String, Object> res = new HashMap<String, Object>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}

	/**
	 * 参数转到页面
	 */
	public static void getRequest2Page(HttpServletRequest request) throws Exception {
		try {
			Enumeration<?> temp = request.getParameterNames();
			if (null != temp) {
				while (temp.hasMoreElements()) {
					String en = (String) temp.nextElement();
					String value = request.getParameter(en);
					if (null != value && !"".equals(value)) {
						request.setAttribute(en, value.trim());
					}
				}
			}
		} catch (Exception e) {
			log.error("getRequest2Page:", e);
		}

	}
	public static void getRequest2Page2(HttpServletRequest request) throws Exception {
		try {
			Enumeration<?> temp = request.getParameterNames();
			if (null != temp) {
				while (temp.hasMoreElements()) {
					String en = (String) temp.nextElement();
					String value = request.getParameter(en);
					if (null != value && !"".equals(value)) {
						if(!(en.equals("userId")||en.equals("mobile")||en.equals("userName")||en.equals("tidCard"))){
						request.setAttribute(en, value.trim());
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("getRequest2Page:", e);
		}

	}

	public static String getInputParam(HttpServletRequest request) {
		String queryString = "";
		try {
			Map<String, String[]> params = request.getParameterMap();
			for (String key : params.keySet()) {
				String[] values = params.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					queryString += key + "=" + value + "&";
				}
			}
		} catch (Exception e) {

		}
		return queryString;
	}
	public static String getInputParam(Map<String,Object> params) {
		String queryString = "";
		try {
			for (String key : params.keySet()) {
				Object value = params.get(key);

				queryString += key + "=" + value + "&";

			}
		} catch (Exception e) {

		}
		return queryString;
	}

	/**
	 * 参数转页面nodel
	 */
	public static void request2model(HttpServletRequest request, Model model) {
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				model.addAttribute(en, value);
			}
		}
	}

	public static Map<String, String> getMapFromStr(String body, String splitString) {
		Map<String, String> m = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(body)) {
			String[] bas = body.split(splitString);
			for (String ba : bas) {
				if (ba.contains("=")) {
					String[] b = ba.split("=");
					if (b.length > 1) {
						m.put(b[0], b[1]);
					} else {
						m.put(b[0], "");
					}
				}
			}
		}
		return m;
	}

	public static synchronized String getRandomNum() {
		if (num > 9999) {
			num = 0;
		}
		String count = "" + num++;
		if (count.length() == 1) {
			count = "000" + count;
		} else if (count.length() == 2) {
			count = "00" + count;
		} else if (count.length() == 3) {
			count = "0" + count;
		}
		return count;
	}

	public static String getRequestJsonStr(HttpServletRequest request){
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			log.error("doinsure:",ex);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					log.error("doinsure:",ex);
				}
			}
		}
		return stringBuilder.toString();
	}


	/**
	 * 检查险种费率是否有效
	 * @return true 有效;
	 */
	public static boolean checkGoodsRate(int rate) {
		return rate >= 0 && rate <= 200;
	}


	/**
	 * 值是否为空或等于0
	 * @param l
	 * @return
	 */
	public static boolean isNullOrEquals0L(Long l) {
		return Objects.isNull(l) || l.equals(0L);
	}



}
