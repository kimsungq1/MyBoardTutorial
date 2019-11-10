package myboardtutorial.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 	* System.out.Println 대신 Log4j 를 사용하는 이유는 성능적인 측면.
 	* 첫번째로 Sysout을 과다하게 남용시 프로그램 운용에 있어서 불필요한 로그를 출력하게 되고,
 	* 두번째로 Sysout을 전부 지우게 되면 로그를 확인하기 어려운 문제점 때문이다.
 	* 이 인터셉터를 통해 컨트롤러의 전, 후 타이밍에 작업을 가로채서(Intercept) 수행할 작업들을 지정.
*/

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("===================================== START =====================================");
			log.debug(" Request URI \t: " + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("====================================== END ======================================\n");
		}
	}

}
