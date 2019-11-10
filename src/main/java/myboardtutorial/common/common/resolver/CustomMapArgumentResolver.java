package myboardtutorial.common.common.resolver;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

// import 주의!
import myboardtutorial.common.common.CommandMap;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/* 
	* HandlerMethodArgumentResolver를 통해 사용자 요청이 Controller에 도달하기 전에 그 요청의 파라미터들을 수정할 수 있음.
	* 덕분에 컨트롤러에서 하나씩 request.getParameter() 할 필요가 없어짐.
	
	* By using this Resolver, we don't need to get each data by using 'request.getParameter()' in Controller
*/

public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver{
	//아래의 두 메소드는 반드시 구현해야 하는 메소드.
	
	@Override
	public Object resolveArgument(MethodParameter para, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		
		String key = null;
		String[] values = null;
		while(enumeration.hasMoreElements()) {
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null) {
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		return commandMap;
	}

	@Override
	public boolean supportsParameter(MethodParameter para) {
		//Type.IsAssignableFrom(Type) : 지정한 형식의 인스턴스를 현재 형식의 변수에 할당할 수 있는지 여부를 결정하는 메소드.
		return CommandMap.class.isAssignableFrom(para.getParameterType());
	}
	
}
