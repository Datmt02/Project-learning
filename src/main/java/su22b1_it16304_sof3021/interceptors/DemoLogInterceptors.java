package su22b1_it16304_sof3021.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import su22b1_it16304_sof3021.entities.Account;

@Component
public class DemoLogInterceptors implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest req,
			HttpServletResponse res,
			Object handler
	) throws Exception {
		
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		if (user == null ) {
			session.setAttribute("lgError", "Đăng nhập để thực hiện chức năng này");
			res.sendRedirect("/su22b1_it16304_sof3021/login");
			return false;
		}else if (user.getAdmin() == 0) {
			session.setAttribute("lgError", "Bạn phải là admin mới vào được trang quản trị");
			res.sendRedirect("/su22b1_it16304_sof3021/home");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(
			HttpServletRequest req,
			HttpServletResponse res,
			Object handler,
			ModelAndView modelview
	) {
		System.out.println("DemoLogInterceptor - postHandle");
	}
	
	@Override 
	public void afterCompletion(
			HttpServletRequest req,
			HttpServletResponse res,
			Object handler,
			Exception e
	) {
		System.out.println("DemoLogInterceptor - afterCompletion");
	}

}
