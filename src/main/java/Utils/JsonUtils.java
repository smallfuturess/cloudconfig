package Utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.Writer;

/**
 * Utils - JSON
 * 
 */
public final class JsonUtils {

	private static Log logger = LogFactory.getLog(JsonUtils.class);

	/** ObjectMapper */
	// private static ObjectMapper mapper = new ObjectMapper()
	// .setSerializationInclusion(Include.NON_NULL);

	private static ObjectMapper mapper = new ObjectMapper()
			.setSerializationInclusion(Include.NON_NULL).disable(
					DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	/**
	 * 不可实例化
	 */
	private JsonUtils() {

		// mapper.setSerializationInclusion(Include.NON_NULL);
	}

	/**
	 * 将对象转换为JSON字符串
	 *
	 * @param value
	 *            对象
	 * @return JSOn字符串
	 */
	public static String toJson(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			logger.error("ERROR:", e);
		}
		return null;
	}

	/**
	 * 将JSON字符串转换为对象
	 *
	 * @param json
	 *            JSON字符串
	 * @param valueType
	 *            对象类型
	 * @return 对象
	 */
	public static <T> T toObject(String json, Class<T> valueType) {
		try {
			if (valueType != null) {
				return mapper.readValue(json, valueType);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("ERROR:", e);
			return null;
		}
	}


	/**
	 * 将对象转换为JSON流
	 *
	 * @param writer
	 *            writer
	 * @param value
	 *            对象
	 */
	public static void writeValue(Writer writer, Object value) {
		try {
			mapper.writeValue(writer, value);
		} catch (JsonGenerationException e) {
			logger.error("ERROR:", e);
		} catch (JsonMappingException e) {
			logger.error("ERROR:", e);
		} catch (IOException e) {
			logger.error("ERROR:", e);
		}
	}

	/**
	 * 讲json字符串转换成list 获取泛型的Collection Type
	 *
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}

	public static JavaType getClassType(Class<?> objectClass) {
		return mapper.getTypeFactory().constructType(objectClass);
	}

	public static JsonNode toJsonNode(String json) {
		try {
			if (json != null) {
				return mapper.readTree(json);
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.error("ERROR:", e);
		}
		return null;
	}

	public static <T> T jsonNodeToObject(JsonNode jsonNode, JavaType javaType) {
		try {
			return mapper.readValue(mapper.treeAsTokens(jsonNode), javaType);
		} catch (Exception e) {
			logger.error("ERROR:", e);
			return null;
		}
	}

}